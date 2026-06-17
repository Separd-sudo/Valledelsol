import React, { useState } from 'react';
import axios from 'axios';
import { BFF_USUARIOS_URL } from '../config';

function RegistroUsuario({ alRegistrar }) {
  const [nombre, setNombre] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [rol, setRol] = useState('CIUDADANO');
  const [enviando, setEnviando] = useState(false);

  const manejarRegistro = (e) => {
    e.preventDefault();
    setEnviando(true);

    const nuevoUsuario = { nombre, email, password, rol };

    // Registramos pasando por Kong Gateway hasta llegar al BFF / ms-usuarios
    axios.post(BFF_USUARIOS_URL, nuevoUsuario)
      .then((response) => {
        alert('🎉 Usuario registrado exitosamente en ms-usuarios');
        setNombre('');
        setEmail('');
        setPassword('');
        if (alRegistrar) alRegistrar(response.data);
      })
      .catch((err) => {
        console.error(err);
        alert('❌ Error al registrar el usuario mediante el Gateway.');
      })
      .finally(() => setEnviando(false));
  };

  return (
    <div style={styles.card}>
      <h3>👤 Registro de Nuevo Personal / Ciudadano</h3>
      <form onSubmit={manejarRegistro} style={styles.form}>
        <input 
          type="text" 
          placeholder="Nombre Completo" 
          value={nombre} 
          onChange={(e) => setNombre(e.target.value)} 
          required 
          style={styles.input}
        />
        <input 
          type="email" 
          placeholder="Correo Electrónico" 
          value={email} 
          onChange={(e) => setEmail(e.target.value)} 
          required 
          style={styles.input}
        />
        <input 
          type="password" 
          placeholder="Contraseña" 
          value={password} 
          onChange={(e) => setPassword(e.target.value)} 
          required 
          style={styles.input}
        />
        
        <label style={{ fontWeight: 'bold', color: '#475569' }}>Asignar Rol del Sistema:</label>
        <select value={rol} onChange={(e) => setRol(e.target.value)} style={styles.input}>
          <option value="CIUDADANO">📢 Ciudadano (Reportes Públicos)</option>
          <option value="BRIGADISTA">🦺 Brigadista (Acciones en Terreno)</option>
          <option value="FUNCIONARIO">🏢 Administrador Municipal (Mando Global)</option>
        </select>

        <button type="submit" disabled={enviando} style={styles.btn}>
          {enviando ? 'Guardando en Base de Datos...' : '💾 Registrar Usuario'}
        </button>
      </form>
    </div>
  );
}

const styles = {
  card: { background: 'white', padding: '25px', borderRadius: '10px', border: '1px solid #E2E8F0', boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)', marginBottom: '25px' },
  form: { display: 'flex', flexDirection: 'column', gap: '12px', marginTop: '15px' },
  input: { padding: '10px', borderRadius: '6px', border: '1px solid #CBD5E1', fontSize: '15px' },
  btn: { background: '#2563EB', color: 'white', border: 'none', padding: '12px', borderRadius: '6px', fontWeight: 'bold', cursor: 'pointer', fontSize: '16px' }
};

export default RegistroUsuario;