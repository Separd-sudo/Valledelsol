import React from 'react';

function PanelFuncionario({ token }) {
  return (
    <div style={styles.panel}>
      <h2>🏢 Panel de Mando Municipal (Administrador)</h2>
      <p>Consolidación de auditoría analítica y supervisión del Clúster de Microservicios.</p>
      
      <div style={styles.ConsolaMonitoreo}>
        <h4 style={{ margin: '0 0 10px 0', color: '#38BDF8' }}>🛰️ Monitor de Nodos & Brokers Kafka Activos:</h4>
        <ul style={{ margin: 0, paddingLeft: '20px', color: '#94A3B8', lineHeight: '1.6' }}>
          <li><span style={{ color: '#4ADE80' }}>● ms-reportes:8081</span> - Conectado a Postgres & Producer Activo</li>
          <li><span style={{ color: '#4ADE80' }}>● ms-usuarios:8082</span> - Servicio de Autenticación & RBAC Estable</li>
          <li><span style={{ color: '#4ADE80' }}>● ms-analitica:8085</span> - Consumer "analitica-group" escuchando en tiempo real</li>
          <li><span style={{ color: '#4ADE80' }}>● ms-geografico:8086</span> - Consumer "geografico-group" procesando coordenadas</li>
        </ul>
      </div>
    </div>
  );
}

const styles = {
  panel: { background: 'white', padding: '25px', borderRadius: '10px', border: '1px solid #E2E8F0', boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)' },
  ConsolaMonitoreo: { background: '#0F172A', color: '#F8FAFC', padding: '20px', borderRadius: '8px', fontFamily: 'monospace', marginTop: '15px' }
};

export default PanelFuncionario;