import React, { useState } from 'react';
import axios from 'axios';
import { BFF_REPORTES_URL } from '../config'; // Sube un nivel para buscar el config

function PanelCiudadano({ token, alCrearReporte }) {
  const [tipo, setTipo] = useState('INCENDIO');
  const [descripcion, setDescripcion] = useState('');
  const [enviando, setEnviando] = useState(false);

  const enviarReporte = (e) => {
    e.preventDefault();
    setEnviando(true);

    const nuevoReporte = { tipo, descripcion, estado: 'ABIERTO', fecha: new Date().toISOString() };

    // Petición oficial pasando por el API Gateway Kong hasta el BFF
    axios.post(BFF_REPORTES_URL, nuevoReporte, {
      headers: { 'Authorization': `Bearer ${token}` }
    })
    .then((response) => {
      alCrearReporte(`🎉 ¡Reporte creado! Mensaje despachado a Kafka (Topic: "incidentes-emergencias"). ID: ${response.data.id || 'Simulado'}`);
      setDescripcion('');
    })
    .catch((err) => {
      console.error(err);
      alCrearReporte('❌ Error al enviar reporte al BFF a través de Kong Gateway.');
    })
    .finally(() => setEnviando(false));
  };

  return (
    <div style={styles.panel}>
      <h2>📢 Módulo Ciudadano: Reportar Emergencia</h2>
      <form onSubmit={enviarReporte} style={styles.form}>
        <label>Tipo de Emergencia:</label>
        <select value={tipo} onChange={(e) => setTipo(e.target.value)} style={styles.input}>
          <option value="INCENDIO FORESTAL">🔥🌳 Vegetacion / Bosques 🌳🔥 </option>
          <option value="INCENDIO ESTRUCTURAL">🔥🚗 Zonas Urbanas / Edificios 🚗 🔥</option>
          <option value="INCENDIO INDUSTRIAL">🏢🔥 Bodegas / Sustancias Quimicas 🏢🔥</option>
        </select>

        <label>Detalles de la Situación:</label>
        <textarea 
          value={descripcion} 
          onChange={(e) => setDescripcion(e.target.value)} 
          placeholder="Describe brevemente lo que ocurre y la ubicación..."
          required
          style={{ ...styles.input, height: '80px', resize: 'none' }}
        />

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
  btn: { background: '#16A34A', color: 'white', border: 'none', padding: '12px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer', fontSize: '16px' }
};

export default PanelCiudadano;