"use client"; // Obligatorio en Next.js para usar Hooks de cliente

import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { BFF_DASHBOARD_URL, BFF_BASE_URL } from '../config';

// Importación de tus componentes modulares
import PanelCiudadano from '../components/PanelCiudadano';
import PanelBrigadista from '../components/PanelBrigadista';
import PanelFuncionario from '../components/PanelFuncionario';
import RegistroUsuario from '../components/RegistroUsuario';

export default function Home() {
  // --- ESTADOS DE AUTENTICACIÓN Y ROLES ---
  const [token, setToken] = useState(null);
  const [rolActivo, setRolActivo] = useState(null); // CIUDADANO, BRIGADISTA, FUNCIONARIO
  const [usuarioLogueado, setUsuarioLogueado] = useState('');
  
  // --- ESTADOS DE LA PLATAFORMA ---
  const [vistaRegistro, setVistaRegistro] = useState(false);
  const [credenciales, setCredenciales] = useState({ correo: '', password: '' });
  const [metricas, setMetricas] = useState({ totalReportes: 0, totalUsuarios: 0, mensaje: 'Cargando...' });
  const [bannerNotificacion, setBannerNotificacion] = useState(null);

  // Al cargar la app, verifica si ya existía una sesión guardada
  useEffect(() => {
    const tokenGuardado = localStorage.getItem('token_valle_sol');
    const rolGuardado = localStorage.getItem('rol_valle_sol');
    const nombreGuardado = localStorage.getItem('nombre_valle_sol');

    if (tokenGuardado && rolGuardado) {
      setToken(tokenGuardado);
      setRolActivo(rolGuardado);
      setUsuarioLogueado(nombreGuardado);
      cargarDashboard(tokenGuardado);
    }
  }, []);

  // Función para consumir el BFF inyectando el token JWT en las cabeceras
  const cargarDashboard = (tokenValido) => {
    axios.get(BFF_DASHBOARD_URL, {
      headers: { 'Authorization': `Bearer ${tokenValido}` }
    })
    .then(res => setMetricas(res.data))
    .catch(err => console.error("Error al refrescar Dashboard:", err));
  };

  // --- CONTROLADOR DEL LOGIN (Conexión con ms-auth vía BFF) ---
  const manejarLogin = async (e) => {
    e.preventDefault();

    // 🚀 Rescatamos los valores desde tu objeto de estado 'credenciales'
    const datosLogin = {
      correo: credenciales.correo,       
      password: credenciales.password  
    };

    try {
      // 🔑 Petición limpia usando async/await recta al BFF
      const res = await axios.post(
        "http://localhost:8080/api/v1/bff/auth/login", 
        datosLogin
      );

      // 🚀 Desestructuramos los datos que retorna ms-auth
      const { tokenJwt, rol, nombre } = res.data;

      // Persistimos en el navegador usando tus llaves reales para evitar pérdidas con F5
      localStorage.setItem('token_valle_sol', tokenJwt);
      localStorage.setItem('rol_valle_sol', rol);
      localStorage.setItem('nombre_valle_sol', nombre);

      // Actualizamos los estados reactivos de la aplicación
      setToken(tokenJwt);
      setRolActivo(rol);
      setUsuarioLogueado(nombre);

      mostrarBanner(`🔐 Sesión iniciada como ${nombre} con éxito.`);
      cargarDashboard(tokenJwt);

    } catch (error) {
      console.error("Error al autenticar:", error);
      alert("❌ Credenciales inválidas. Revisa el estado de ms-auth o del BFF.");
    }
  };

  const manejarCierreSesion = () => {
    localStorage.clear();
    setToken(null);
    setRolActivo(null);
    setUsuarioLogueado('');
  };

  const mostrarBanner = (mensaje) => {
    setBannerNotificacion(mensaje);
    setTimeout(() => setBannerNotificacion(null), 5000); // Se esconde a los 5 segundos
  };

  // --- RENDERIZADO DE PANTALLA PÚBLICA (LOGIN / REGISTRO) ---
  if (!token) {
    return (
      <div style={styles.loginContainer}>
        <div style={styles.loginCard}>
          <h2 style={{ textAlign: 'center', color: '#1E293B' }}>☀️ Sistema Valle del Sol</h2>
          <p style={{ textAlign: 'center', color: '#64748B', marginTop: '-10px' }}>Gestión Tecnológica de Incendios y Emergencias</p>
          
          {bannerNotificacion && <div style={styles.banner}>{bannerNotificacion}</div>}

          {vistaRegistro ? (
            <>
              {/* Formulario de Registro Modular */}
              <RegistroUsuario alRegistrar={() => {
                setVistaRegistro(false);
                mostrarBanner("🎉 Registro exitoso. Ahora puedes iniciar sesión.");
              }} />
              <button onClick={() => setVistaRegistro(false)} style={styles.btnSecundario}>
                ← Volver al Inicio de Sesión
              </button>
            </>
          ) : (
            <form onSubmit={manejarLogin} style={styles.form}>
              <label style={styles.label}>Correo Electrónico:</label>
              <input 
                type="email" 
                required 
                style={styles.input}
                value={credenciales.correo}
                onChange={(e) => setCredenciales({...credenciales, correo: e.target.value})}
              />
              
              <label style={styles.label}>Contraseña:</label>
              <input 
                type="password" 
                required 
                style={styles.input}
                value={credenciales.password}
                onChange={(e) => setCredenciales({...credenciales, password: e.target.value})}
              />

              <button type="submit" style={styles.btnPrimario}>🔑 Ingresar al Sistema</button>
              <p style={{ textAlign: 'center', margin: '15px 0 5px 0', color: '#64748B' }}>¿Eres un nuevo usuario o brigadista?</p>
              <button type="button" onClick={() => setVistaRegistro(true)} style={styles.btnSecundario}>
                👤 Crear una Cuenta Nueva
              </button>
            </form>
          )}
        </div>
      </div>
    );
  }

  // --- RENDERIZADO DE PANTALLA PRIVADA (SISTEMA LOGUEADO) ---
  return (
    <div style={styles.dashboardContainer}>
      {/* BARRA SUPERIOR DE CONTROL */}
      <header style={styles.header}>
        <div>
          <h1 style={{ margin: 0, fontSize: '22px' }}>☀️ Valle del Sol — Panel de Control</h1>
          <p style={{ margin: 0, color: '#94A3B8', fontSize: '14px' }}>Bienvenido: <strong>{usuarioLogueado}</strong> [{rolActivo}]</p>
        </div>
        <button onClick={manejarCierreSesion} style={styles.btnCerrar}>
          🚪 Cerrar Sesión
        </button>
      </header>

      {/* MÉTRICAS — solo alertas activas */}
      <section style={styles.metricsGrid}>
        <div style={{...styles.metricCard, gridColumn: 'span 4'}}>
          <h3>🔥 Alertas Activas en el Sistema</h3>
          <p style={styles.metricNumber}>{metricas.totalReportes}</p>
        </div>
      </section>

      {/* RENDERIZADO DINÁMICO SEGÚN PERMISOS Y ROLES EXIGIDOS */}
      <main style={{ marginTop: '30px' }}>
        
        {rolActivo === 'CIUDADANO' && (
          <div>
            <h2 style={styles.tituloSeccion}>📢 Panel de Reportes Ciudadanos</h2>
            <PanelCiudadano token={token} alCrearReporte={() => {
              mostrarBanner("🔥 Incendio reportado con éxito. Evento enviado a Kafka.");
              cargarDashboard(token);
            }} />
          </div>
        )}

        {rolActivo === 'BRIGADISTA' && (
          <div>
            <h2 style={styles.tituloSeccion}>🦺 Panel de Operaciones en Terreno</h2>
            <PanelBrigadista token={token} alActualizarEstado={() => {
              mostrarBanner("🔄 Estado del incendio actualizado en la base de datos.");
              cargarDashboard(token);
            }} />
          </div>
        )}

        {(rolActivo === 'FUNCIONARIO' || rolActivo === 'FUNCIONARIO_MUNICIPAL') && (
          <div>
            <h2 style={styles.tituloSeccion}>🏢 Panel de Administración Municipal (Mando Global)</h2>
            <PanelFuncionario token={token} />
          </div>
        )}

      </main>
    </div>
  );
}

// --- ESTILOS NATIVOS CSS-IN-JS ---
const styles = {
  loginContainer: { display: 'flex', justifyContent: 'center', alignItems: 'center', height: '100vh', backgroundColor: '#F1F5F9' },
  loginCard: { background: 'white', padding: '40px', borderRadius: '12px', boxShadow: '0 10px 15px -3px rgba(0,0,0,0.1)', width: '100%', maxWidth: '450px' },
  form: { display: 'flex', flexDirection: 'column', gap: '12px', marginTop: '20px' },
  label: { fontWeight: 'bold', color: '#475569', fontSize: '14px' },
  input: { padding: '12px', borderRadius: '8px', border: '1px solid #CBD5E1', fontSize: '15px' },
  btnPrimario: { background: '#2563EB', color: 'white', border: 'none', padding: '14px', borderRadius: '8px', fontWeight: 'bold', cursor: 'pointer', fontSize: '16px', marginTop: '10px' },
  btnSecundario: { background: 'none', color: '#2563EB', border: '1px solid #2563EB', padding: '12px', borderRadius: '8px', fontWeight: 'bold', cursor: 'pointer', fontSize: '15px', width: '100%' },
  dashboardContainer: { padding: '30px', maxWidth: '1200px', margin: '0 auto' },
  header: { display: 'flex', justifyContent: 'space-between', alignItems: 'center', background: '#1E293B', color: 'white', padding: '20px 30px', borderRadius: '12px', boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)' },
  btnCerrar: { background: '#EF4444', color: 'white', border: 'none', padding: '10px 16px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer' },
  metricsGrid: { display: 'grid', gridTemplateColumns: 'repeat(4, 1fr)', gap: '20px', marginTop: '30px' },
  metricCard: { background: 'white', padding: '20px', borderRadius: '10px', border: '1px solid #E2E8F0', boxShadow: '0 1px 3px rgba(0,0,0,0.05)' },
  metricNumber: { fontSize: '32px', fontWeight: 'bold', color: '#1E293B', margin: '5px 0 0 0' },
  tituloSeccion: { color: '#1E293B', borderBottom: '2px solid #E2E8F0', paddingBottom: '10px', marginBottom: '20px' },
  banner: { background: '#10B981', color: 'white', padding: '12px', borderRadius: '8px', fontWeight: 'bold', textAlign: 'center', marginBottom: '15px' }
};