import React, { useState } from 'react';
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
        alCrearReporte(`🎉 ¡Reporte creado! ID: ${response.data.id ?? 'desconocido'}`);
        setDescripcion(''); setUbicacion(''); setCoordenadas({ latitud: null, longitud: null });
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

  return (
    <div style={styles.panel}>
      <h2>📢 Módulo Ciudadano: Reportar Emergencia</h2>
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
  );
}

const styles = {
  panel: { background: 'white', padding: '25px', borderRadius: '10px', border: '1px solid #E2E8F0', boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)' },
  form: { display: 'flex', flexDirection: 'column', gap: '12px', marginTop: '15px' },
  input: { padding: '10px', borderRadius: '6px', border: '1px solid #CBD5E1', fontSize: '15px' },
  btn: { background: '#16A34A', color: 'white', border: 'none', padding: '12px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer', fontSize: '16px' },
  btnSecundario: { background: 'none', color: '#2563EB', border: '1px dashed #2563EB', padding: '10px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer', fontSize: '14px' }
};

export default PanelCiudadano;