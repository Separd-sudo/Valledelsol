import React from 'react';

function PanelBrigadista({ token, alActualizar }) {
  const simularAccion = (accion) => {
    alActualizar(`🦺 Brigada en Terreno ejecutó acción: [${accion}]. Evento enviado a Kafka para actualizar mapa global.`);
  };

  return (
    <div style={styles.panel}>
      <h2>🦺 Módulo Brigadista: Gestión de Eventos en Terreno</h2>
      <p>Actualiza el estado táctico de los incidentes asignados. Cada cambio generará eventos de telemetría inmediatos.</p>
      
      <div style={styles.gridBtn}>
        <button onClick={() => simularAccion('EN ROUTE')} style={{ ...styles.btn, background: '#3B82F6' }}>🚒 En Ruta al Lugar</button>
        <button onClick={() => simularAccion('MITIGANDO')} style={{ ...styles.btn, background: '#D97706' }}>🧑‍🚒 Combatiendo Emergencia</button>
        <button onClick={() => simularAccion('CONTROLADO')} style={{ ...styles.btn, background: '#16A34A' }}>✅ Controlado / Extinguido</button>
      </div>
    </div>
  );
}

const styles = {
  panel: { background: 'white', padding: '25px', borderRadius: '10px', border: '1px solid #E2E8F0', boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)' },
  gridBtn: { display: 'flex', gap: '15px', marginTop: '20px' },
  btn: { color: 'white', border: 'none', padding: '15px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer', flex: 1, fontSize: '15px' }
};

export default PanelBrigadista; 