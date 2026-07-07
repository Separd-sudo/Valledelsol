import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { BFF_USUARIOS_URL, BFF_ANALITICA_URL, BFF_GEOGRAFIA_URL, BFF_ALERTAS_URL } from '../config';

const TABS = [
  { id: 'usuarios', etiqueta: '👥 Usuarios' },
  { id: 'historial', etiqueta: '📊 Historial' },
  { id: 'mapa', etiqueta: '🗺️ Mapa' },
  { id: 'notificaciones', etiqueta: '🔔 Notificaciones' },
];

function PanelFuncionario({ token }) {
  const [tabActiva, setTabActiva] = useState('usuarios');

  return (
    <div style={styles.panel}>
      <h2>🏢 Panel de Administración Municipal</h2>
      <div style={styles.tabBar}>
        {TABS.map((tab) => (
          <button key={tab.id} onClick={() => setTabActiva(tab.id)}
            style={tabActiva === tab.id ? styles.tabActiva : styles.tabInactiva}>
            {tab.etiqueta}
          </button>
        ))}
      </div>
      <div style={styles.contenido}>
        {tabActiva === 'usuarios' && <TabUsuarios token={token} />}
        {tabActiva === 'historial' && <TabHistorial token={token} />}
        {tabActiva === 'mapa' && <TabMapa token={token} />}
        {tabActiva === 'notificaciones' && <TabNotificaciones token={token} />}
      </div>
    </div>
  );
}

function TabUsuarios({ token }) {
  const [usuarios, setUsuarios] = useState([]);
  const [cargando, setCargando] = useState(true);
  const [guardandoId, setGuardandoId] = useState(null);

  const cargarUsuarios = () => {
    setCargando(true);
    axios.get(BFF_USUARIOS_URL, { headers: { 'Authorization': `Bearer ${token}` } })
      .then((res) => setUsuarios(res.data || []))
      .catch((err) => console.error(err))
      .finally(() => setCargando(false));
  };

  useEffect(() => { cargarUsuarios(); }, []);

  const actualizarUsuario = (id, cambios) => {
    setGuardandoId(id);
    axios.put(`${BFF_USUARIOS_URL}/${id}`, cambios, { headers: { 'Authorization': `Bearer ${token}` } })
      .then(() => cargarUsuarios())
      .catch((err) => {
        if (err.response?.status === 409) alert(err.response.data?.error || 'No puedes desactivar tu propia cuenta.');
        else alert('No se pudo actualizar el usuario.');
      })
      .finally(() => setGuardandoId(null));
  };

  if (cargando) return <p>Cargando usuarios...</p>;

  return (
    <table style={styles.tabla}>
      <thead><tr>
        <th style={styles.th}>Nombre</th><th style={styles.th}>Correo</th>
        <th style={styles.th}>Rol</th><th style={styles.th}>Activo</th><th style={styles.th}>Acciones</th>
      </tr></thead>
      <tbody>
        {usuarios.map((u) => (
          <tr key={u.id}>
            <td style={styles.td}>{u.nombre}</td>
            <td style={styles.td}>{u.correo}</td>
            <td style={styles.td}>
              <select value={u.rol} disabled={guardandoId === u.id}
                onChange={(e) => actualizarUsuario(u.id, { rol: e.target.value })} style={styles.selectChico}>
                <option value="CIUDADANO">CIUDADANO</option>
                <option value="BRIGADISTA">BRIGADISTA</option>
                <option value="FUNCIONARIO_MUNICIPAL">FUNCIONARIO_MUNICIPAL</option>
              </select>
            </td>
            <td style={styles.td}>{u.activo ? '✅' : '🚫'}</td>
            <td style={styles.td}>
              <button onClick={() => actualizarUsuario(u.id, { activo: !u.activo })}
                disabled={guardandoId === u.id} style={u.activo ? styles.btnDesactivar : styles.btnActivar}>
                {u.activo ? 'Desactivar' : 'Activar'}
              </button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

function TabHistorial({ token }) {
  const [historial, setHistorial] = useState([]);
  const [cargando, setCargando] = useState(true);

  useEffect(() => {
    axios.get(BFF_ANALITICA_URL, { headers: { 'Authorization': `Bearer ${token}` } })
      .then((res) => setHistorial(res.data || []))
      .catch((err) => console.error(err))
      .finally(() => setCargando(false));
  }, [token]);

  if (cargando) return <p>Cargando historial...</p>;
  if (historial.length === 0) return <p style={styles.vacio}>No hay registros todavía.</p>;

  return (
    <table style={styles.tabla}>
      <thead><tr>
        <th style={styles.th}>Reporte</th><th style={styles.th}>Sector</th>
        <th style={styles.th}>Gravedad</th><th style={styles.th}>Estado</th><th style={styles.th}>Registrado</th>
      </tr></thead>
      <tbody>
        {historial.map((h) => (
          <tr key={h.idInterno}>
            <td style={styles.td}>#{h.idReporteOriginal}</td>
            <td style={styles.td}>{h.sector}</td>
            <td style={styles.td}>{h.gravedad}</td>
            <td style={styles.td}>{h.estado}</td>
            <td style={styles.td}>{h.fechaRegistroKafka}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

function TabMapa({ token }) {
  const [puntos, setPuntos] = useState([]);
  const [cargando, setCargando] = useState(true);

  useEffect(() => {
    axios.get(BFF_GEOGRAFIA_URL, { headers: { 'Authorization': `Bearer ${token}` } })
      .then((res) => setPuntos(res.data || []))
      .catch((err) => console.error(err))
      .finally(() => setCargando(false));
  }, [token]);

  if (cargando) return <p>Cargando puntos del mapa...</p>;
  if (puntos.length === 0) return <p style={styles.vacio}>No hay incendios activos.</p>;

  return (
    <table style={styles.tabla}>
      <thead><tr>
        <th style={styles.th}>Reporte</th><th style={styles.th}>Sector</th>
        <th style={styles.th}>Latitud</th><th style={styles.th}>Longitud</th><th style={styles.th}>Estado</th>
      </tr></thead>
      <tbody>
        {puntos.map((p) => (
          <tr key={p.idGeo}>
            <td style={styles.td}>#{p.idReporte}</td>
            <td style={styles.td}>{p.sector}</td>
            <td style={styles.td}>{p.latitud}</td>
            <td style={styles.td}>{p.longitud}</td>
            <td style={styles.td}>{p.estado}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

function TabNotificaciones({ token }) {
  const [notificaciones, setNotificaciones] = useState([]);
  const [cargando, setCargando] = useState(true);

  useEffect(() => {
    axios.get(BFF_ALERTAS_URL, { headers: { 'Authorization': `Bearer ${token}` } })
      .then((res) => setNotificaciones(res.data || []))
      .catch((err) => console.error(err))
      .finally(() => setCargando(false));
  }, [token]);

  if (cargando) return <p>Cargando notificaciones...</p>;
  if (notificaciones.length === 0) return <p style={styles.vacio}>No se han despachado notificaciones.</p>;

  return (
    <table style={styles.tabla}>
      <thead><tr>
        <th style={styles.th}>Reporte</th><th style={styles.th}>Destinatario</th>
        <th style={styles.th}>Rol</th><th style={styles.th}>Mensaje</th><th style={styles.th}>Enviado</th>
      </tr></thead>
      <tbody>
        {notificaciones.map((n) => (
          <tr key={n.id}>
            <td style={styles.td}>#{n.idReporte}</td>
            <td style={styles.td}>{n.correoDestino}</td>
            <td style={styles.td}>{n.rolDestino}</td>
            <td style={styles.td}>{n.mensaje}</td>
            <td style={styles.td}>{n.fechaEnvio}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
}

const styles = {
  panel: { background: 'white', padding: '25px', borderRadius: '10px', border: '1px solid #E2E8F0', boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)' },
  tabBar: { display: 'flex', gap: '8px', marginTop: '20px', borderBottom: '1px solid #E2E8F0', paddingBottom: '10px' },
  tabActiva: { background: '#1E293B', color: 'white', border: 'none', padding: '10px 16px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer' },
  tabInactiva: { background: 'none', color: '#64748B', border: '1px solid #E2E8F0', padding: '10px 16px', borderRadius: '6px', cursor: 'pointer' },
  contenido: { marginTop: '20px', overflowX: 'auto' },
  tabla: { width: '100%', borderCollapse: 'collapse', fontSize: '14px' },
  th: { textAlign: 'left', padding: '10px', borderBottom: '2px solid #E2E8F0', color: '#475569' },
  td: { padding: '10px', borderBottom: '1px solid #F1F5F9' },
  selectChico: { padding: '4px', borderRadius: '4px', border: '1px solid #CBD5E1', fontSize: '13px' },
  btnActivar: { background: '#16A34A', color: 'white', border: 'none', padding: '6px 12px', borderRadius: '4px', cursor: 'pointer', fontSize: '13px' },
  btnDesactivar: { background: '#EF4444', color: 'white', border: 'none', padding: '6px 12px', borderRadius: '4px', cursor: 'pointer', fontSize: '13px' },
  vacio: { color: '#94A3B8', fontStyle: 'italic' }
};

export default PanelFuncionario;