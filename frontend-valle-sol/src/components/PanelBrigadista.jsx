import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { BFF_REPORTES_URL } from '../config';

const ESTADOS_DISPONIBLES = [
  { valor: 'EN_REVISION', etiqueta: '🚒 En revisión' },
  { valor: 'ATENDIDO', etiqueta: '🧑‍🚒 Atendido' },
  { valor: 'CERRADO', etiqueta: '✅ Cerrado' },
];

function PanelBrigadista({ token, alActualizarEstado }) {
  const [reportes, setReportes] = useState([]);
  const [cargando, setCargando] = useState(true);
  const [reporteSeleccionadoId, setReporteSeleccionadoId] = useState('');
  const [nuevoEstado, setNuevoEstado] = useState('EN_REVISION');
  const [nota, setNota] = useState('');
  const [enviando, setEnviando] = useState(false);

  const cargarReportes = () => {
    setCargando(true);
    axios.get(BFF_REPORTES_URL, { headers: { 'Authorization': `Bearer ${token}` } })
      .then((res) => setReportes(res.data || []))
      .catch((err) => console.error(err))
      .finally(() => setCargando(false));
  };

  useEffect(() => { cargarReportes(); }, []);

  const actualizarReporte = (e) => {
    e.preventDefault();
    if (!reporteSeleccionadoId) { alert('Selecciona un reporte.'); return; }
    setEnviando(true);

    const cuerpo = { estado: nuevoEstado, ...(nota.trim() ? { descripcion: nota.trim() } : {}) };

    axios.put(`${BFF_REPORTES_URL}/${reporteSeleccionadoId}`, cuerpo, { headers: { 'Authorization': `Bearer ${token}` } })
      .then(() => {
        alActualizarEstado(`🔄 Reporte #${reporteSeleccionadoId} actualizado a "${nuevoEstado}".`);
        setNota(''); cargarReportes();
      })
      .catch((err) => {
        if (err.response?.status === 403) alert('No tienes permiso con tu rol actual.');
        else if (err.response?.status === 401) alert('Tu sesión expiró.');
        else alert('No se pudo actualizar el reporte.');
      })
      .finally(() => setEnviando(false));
  };

  return (
    <div style={styles.panel}>
      <h2>🦺 Módulo Brigadista: Gestión de Eventos en Terreno</h2>
      {cargando ? <p>Cargando reportes...</p> : reportes.length === 0 ? (
        <p style={styles.vacio}>No hay reportes registrados.</p>
      ) : (
        <form onSubmit={actualizarReporte} style={styles.form}>
          <label>Selecciona un incidente:</label>
          <select value={reporteSeleccionadoId} onChange={(e) => setReporteSeleccionadoId(e.target.value)} required style={styles.input}>
            <option value="" disabled>-- Elige un reporte --</option>
            {reportes.map((r) => (
              <option key={r.id} value={r.id}>#{r.id} · {r.titulo} · {r.ubicacion} · {r.estado}</option>
            ))}
          </select>

          <label>Nuevo estado:</label>
          <select value={nuevoEstado} onChange={(e) => setNuevoEstado(e.target.value)} style={styles.input}>
            {ESTADOS_DISPONIBLES.map((e) => <option key={e.valor} value={e.valor}>{e.etiqueta}</option>)}
          </select>

          <label>Nota de terreno (opcional):</label>
          <textarea value={nota} onChange={(e) => setNota(e.target.value)}
            placeholder="Ej: Brigada en el lugar..." style={{ ...styles.input, height: '70px', resize: 'none' }} />

          <button type="submit" disabled={enviando} style={styles.btn}>
            {enviando ? 'Actualizando...' : '🔄 Actualizar Estado del Incidente'}
          </button>
        </form>
      )}
    </div>
  );
}

const styles = {
  panel: { background: 'white', padding: '25px', borderRadius: '10px', border: '1px solid #E2E8F0', boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)' },
  form: { display: 'flex', flexDirection: 'column', gap: '12px', marginTop: '20px' },
  input: { padding: '10px', borderRadius: '6px', border: '1px solid #CBD5E1', fontSize: '15px' },
  btn: { background: '#D97706', color: 'white', border: 'none', padding: '14px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer', fontSize: '15px' },
  vacio: { color: '#94A3B8', fontStyle: 'italic' }
};

export default PanelBrigadista;