import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { BFF_REPORTES_URL } from '../config';

function PanelCiudadano({ token, alCrearReporte }) {
  const [titulo, setTitulo] = useState('Incendio Forestal');
  const [descripcion, setDescripcion] = useState('');
  const [ubicacion, setUbicacion] = useState('');
  const [nivelRiesgo, setNivelRiesgo] = useState('MEDIO');
  const [enviando, setEnviando] = useState(false);
  const [coordenadas, setCoordenadas] = useState({ latitud: null, longitud: null });
  const [obteniendoUbicacion, setObteniendoUbicacion] = useState(false);
  const [mensajeExito, setMensajeExito] = useState(null);

  // --- Estado para reportes cercanos ---
  const [reportes, setReportes] = useState([]);
  const [cargandoReportes, setCargandoReportes] = useState(true);

  const cargarReportes = () => {
    setCargandoReportes(true);
    axios.get(BFF_REPORTES_URL, { headers: { 'Authorization': `Bearer ${token}` } })
      .then((res) => setReportes(res.data || []))
      .catch((err) => console.error('Error cargando reportes cercanos:', err))
      .finally(() => setCargandoReportes(false));
  };

  useEffect(() => { cargarReportes(); }, [token]);

  const obtenerUbicacionActual = () => {
    if (!navigator.geolocation) {
      alert('Tu navegador no soporta geolocalización.');
      return;
    }
    setObteniendoUbicacion(true);
    navigator.geolocation.getCurrentPosition(
      (posicion) => {
        setCoordenadas({ latitud: posicion.coords.latitude, longitud: posicion.coords.longitude });
        setObteniendoUbicacion(false);
      },
      () => {
        alert('No se pudo obtener tu ubicación automática.');
        setObteniendoUbicacion(false);
      }
    );
  };

  const enviarReporte = (e) => {
    e.preventDefault();
    setEnviando(true);

    const nuevoReporte = { titulo, descripcion, ubicacion, nivelRiesgo, latitud: coordenadas.latitud, longitud: coordenadas.longitud };

    axios.post(BFF_REPORTES_URL, nuevoReporte, { headers: { 'Authorization': `Bearer ${token}` } })
      .then((response) => {
        const id = response.data.id ?? 'desconocido';
        setMensajeExito(`✅ ¡Reporte #${id} creado exitosamente! Será atendido a la brevedad.`);
        setTimeout(() => setMensajeExito(null), 6000);
        alCrearReporte(`🎉 ¡Reporte creado! ID: ${id}`);
        setDescripcion(''); setUbicacion(''); setCoordenadas({ latitud: null, longitud: null });
        cargarReportes(); // refresca la lista tras crear
      })
      .catch((err) => {
        if (err.response?.status === 401) {
          alert('Tu sesión expiró. Vuelve a ingresar.');
        } else {
          alCrearReporte('❌ Error al enviar el reporte.');
        }
      })
      .finally(() => setEnviando(false));
  };

  const colorRiesgo = { BAJO: '#10B981', MEDIO: '#F59E0B', ALTO: '#EF4444', CRITICO: '#7C3AED' };
  const colorEstado = { PENDIENTE: '#F59E0B', EN_REVISION: '#3B82F6', ATENDIDO: '#10B981', CERRADO: '#6B7280' };

  return (
    <div>
      {/* ── FORMULARIO DE REPORTE ── */}
      <div style={styles.panel}>
        <h2>📢 Módulo Ciudadano: Reportar Emergencia</h2>

        {mensajeExito && (
          <div style={styles.bannerExito}>
            {mensajeExito}
            <button onClick={() => setMensajeExito(null)} style={styles.btnCerrar}>×</button>
          </div>
        )}

        <form onSubmit={enviarReporte} style={styles.form}>
          <label>Tipo de Emergencia:</label>
          <select value={titulo} onChange={(e) => setTitulo(e.target.value)} style={styles.input}>
            <option value="Incendio Forestal">🔥🌳 Vegetación / Bosques 🌳🔥</option>
            <option value="Incendio Estructural">🔥🚗 Zonas Urbanas / Edificios 🚗🔥</option>
            <option value="Incendio Industrial">🏢🔥 Bodegas / Sustancias Químicas 🏢🔥</option>
          </select>

          <label>Nivel de Riesgo:</label>
          <select value={nivelRiesgo} onChange={(e) => setNivelRiesgo(e.target.value)} style={styles.input}>
            <option value="BAJO">🟢 Bajo</option>
            <option value="MEDIO">🟡 Medio</option>
            <option value="ALTO">🔴 Alto</option>
          </select>

          <label>Ubicación:</label>
          <input type="text" value={ubicacion} onChange={(e) => setUbicacion(e.target.value)}
            placeholder="Ej: Sector Los Cóndores" required style={styles.input} />

          <button type="button" onClick={obtenerUbicacionActual} disabled={obteniendoUbicacion} style={styles.btnSecundario}>
            {obteniendoUbicacion ? 'Obteniendo ubicación...' : coordenadas.latitud
              ? `📍 Ubicación capturada (${coordenadas.latitud.toFixed(4)}, ${coordenadas.longitud.toFixed(4)})`
              : '📍 Usar mi ubicación actual (opcional)'}
          </button>

          <label>Detalles:</label>
          <textarea value={descripcion} onChange={(e) => setDescripcion(e.target.value)}
            placeholder="Describe lo que ocurre..." required style={{ ...styles.input, height: '80px', resize: 'none' }} />

          <button type="submit" disabled={enviando} style={styles.btn}>
            {enviando ? 'Despachando...' : '🚀 Enviar Reporte de Emergencia'}
          </button>
        </form>
      </div>

      {/* ── REPORTES CERCANOS ── */}
      <div style={styles.seccionReportes}>
        <div style={styles.seccionHeader}>
          <h3 style={styles.seccionTitulo}>📍 Reportes Cercanos en tu Zona</h3>
          <button onClick={cargarReportes} style={styles.btnActualizar}>🔄 Actualizar</button>
        </div>

        {cargandoReportes ? (
          <p style={styles.textoVacio}>⏳ Cargando reportes...</p>
        ) : reportes.length === 0 ? (
          <p style={styles.textoVacio}>No hay reportes activos en tu zona actualmente.</p>
        ) : (
          <div style={styles.gridReportes}>
            {reportes.map((r) => (
              <div key={r.id} style={styles.cardReporte}>
                <div style={styles.cardHeader}>
                  <span style={{ fontWeight: 'bold', fontSize: '14px' }}>#{r.id} — {r.titulo}</span>
                  <span style={{ ...styles.badge, background: colorEstado[r.estado] || '#94A3B8' }}>
                    {r.estado}
                  </span>
                </div>
                <div style={styles.cardBody}>
                  <p style={styles.cardFila}>
                    <span style={styles.cardEtiqueta}>📍 Ubicación:</span> {r.ubicacion || '—'}
                  </p>
                  <p style={styles.cardFila}>
                    <span style={styles.cardEtiqueta}>⚠️ Riesgo:</span>
                    <span style={{ ...styles.badge, background: colorRiesgo[r.nivelRiesgo] || '#94A3B8', marginLeft: '6px' }}>
                      {r.nivelRiesgo}
                    </span>
                  </p>
                  <p style={styles.cardFila}>
                    <span style={styles.cardEtiqueta}>🕐 Fecha:</span>{' '}
                    {r.fechaCreacion ? new Date(r.fechaCreacion).toLocaleString('es-CL') : '—'}
                  </p>
                  {r.descripcion && (
                    <p style={{ ...styles.cardFila, marginTop: '6px', color: '#475569', fontStyle: 'italic', fontSize: '13px' }}>
                      "{r.descripcion}"
                    </p>
                  )}
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
}

const styles = {
  panel: { background: 'white', padding: '25px', borderRadius: '10px', border: '1px solid #E2E8F0', boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)' },
  form: { display: 'flex', flexDirection: 'column', gap: '12px', marginTop: '15px' },
  input: { padding: '10px', borderRadius: '6px', border: '1px solid #CBD5E1', fontSize: '15px' },
  btn: { background: '#16A34A', color: 'white', border: 'none', padding: '12px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer', fontSize: '16px' },
  btnSecundario: { background: 'none', color: '#2563EB', border: '1px dashed #2563EB', padding: '10px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer', fontSize: '14px' },
  bannerExito: { display: 'flex', justifyContent: 'space-between', alignItems: 'center', background: '#D1FAE5', color: '#065F46', border: '1px solid #6EE7B7', borderRadius: '8px', padding: '12px 16px', marginBottom: '16px', fontWeight: '600', fontSize: '15px' },
  btnCerrar: { background: 'none', border: 'none', color: '#065F46', fontSize: '20px', cursor: 'pointer', lineHeight: 1, padding: '0 4px' },

  // --- Sección reportes cercanos ---
  seccionReportes: { marginTop: '28px' },
  seccionHeader: { display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '16px' },
  seccionTitulo: { margin: 0, color: '#1E293B', fontSize: '18px', fontWeight: 'bold' },
  btnActualizar: { background: '#1E293B', color: 'white', border: 'none', padding: '7px 14px', borderRadius: '6px', cursor: 'pointer', fontSize: '13px', fontWeight: '600' },
  textoVacio: { color: '#94A3B8', fontStyle: 'italic', textAlign: 'center', padding: '30px 0' },
  gridReportes: { display: 'grid', gridTemplateColumns: 'repeat(auto-fill, minmax(280px, 1fr))', gap: '16px' },
  cardReporte: { background: 'white', borderRadius: '10px', border: '1px solid #E2E8F0', boxShadow: '0 2px 8px rgba(0,0,0,0.06)', overflow: 'hidden' },
  cardHeader: { display: 'flex', justifyContent: 'space-between', alignItems: 'center', background: '#F8FAFC', padding: '12px 16px', borderBottom: '1px solid #E2E8F0' },
  cardBody: { padding: '14px 16px' },
  cardFila: { margin: '4px 0', fontSize: '13px', color: '#334155', display: 'flex', alignItems: 'center', gap: '4px' },
  cardEtiqueta: { fontWeight: '600', color: '#64748B', minWidth: '90px' },
  badge: { color: 'white', padding: '2px 10px', borderRadius: '999px', fontSize: '11px', fontWeight: 'bold', whiteSpace: 'nowrap' },
};

export default PanelCiudadano;