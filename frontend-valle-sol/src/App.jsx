// IMPORTACIONES: Traemos las herramientas necesarias de React y la librería Axios
import React, { useState, useEffect } from 'react'
import axios from 'axios'

// CONFIGURACIÓN: Definimos la URL de nuestro BFF (Backend For Frontend)
// Apunta al puerto 8080 que es donde corre la API en el docker-compose
const BFF_URL = 'http://localhost:8080/api'

function App() {
  // ESTADO LOCAL (useState): Es la memoria a corto plazo del componente.
  // 'mensajeBff' guardará el texto que nos responda el servidor.
  const [mensajeBff, setMensajeBff] = useState('Conectando al BFF...')
  
  // ESTADO DE ERROR: Si la conexión falla, guardaremos el mensaje de error aquí.
  const [errorConexion, setErrorConexion] = useState(null)

  // EFECTO AUTOMÁTICO (useEffect): Se ejecuta UNA sola vez apenas la pantalla se carga.
  // Aquí implementamos el patrón para consumir la API de forma asíncrona.
  useEffect(() => {
    // Axios realiza una petición HTTP de tipo GET hacia el endpoint del BFF
    axios.get(`${BFF_URL}/saludo`)
      .then((response) => {
        // RESPUESTA EXITOSA: Si el BFF responde, guardamos sus datos en el estado
        setMensajeBff(response.data)
      })
      .catch((error) => {
        // MANEJO DE EXCEPCIONES: Si el BFF está apagado o falla, capturamos el error
        console.error('Error al conectar con el BFF:', error)
        setErrorConexion('No se pudo establecer comunicación con el BFF de Valle del Sol.')
      })
  }, []) // Los corchetes vacíos [] aseguran que esto se ejecute solo al arrancar la app

  // RENDERIZADO: Todo lo que esté dentro del 'return' es el HTML que verá el usuario
  return (
    <div style={styles.container}>
      {/* Encabezado principal del sistema */}
      <header style={styles.header}>
        <h1>Sistema Valle del Sol ☀️</h1>
        <p>Evaluación Parcial N°2 - Desarrollo Fullstack III</p>
      </header>

      {/* Contenedor de las tarjetas de información */}
      <main style={styles.main}>
        {/* Tarjeta 1: Muestra que el estándar NPM funciona */}
        <section style={styles.card}>
          <h2>Componente Frontend (NPM)</h2>
          <p style={styles.success}>✓ Inicializado correctamente con package.json</p>
        </section>

        {/* Tarjeta 2: Muestra la integración real con el BFF en Java */}
        <section style={styles.card}>
          <h2>Comunicación con Capa Backend (BFF)</h2>
          {/* Si hay un error de conexión, muestra el mensaje en rojo. Si no, muestra la respuesta */}
          {errorConexion ? (
            <p style={styles.error}>{errorConexion}</p>
          ) : (
            <p style={styles.info}>Respuesta del servidor: <strong>{mensajeBff}</strong></p>
          )}
        </section>
      </main>
    </div>
  )
}

// ESTILOS (CSS en JS): Formato visual limpio y ordenado para cumplir con la rúbrica
const styles = {
  container: { fontFamily: 'sans-serif', backgroundColor: '#f4f6f9', minHeight: '100vh', padding: '20px' },
  header: { textAlign: 'center', padding: '20px', backgroundColor: '#2c3e50', color: 'white', borderRadius: '8px', marginBottom: '20px' },
  main: { display: 'flex', gap: '20px', justifyContent: 'center', maxWidth: '1200px', margin: '0 auto' },
  card: { backgroundColor: 'white', padding: '20px', borderRadius: '8px', boxShadow: '0 4px 6px rgba(0,0,0,0.1)', flex: 1 },
  success: { color: '#27ae60', fontWeight: 'bold' },
  info: { color: '#2980b9' },
  error: { color: '#c0392b', fontWeight: 'bold' }
}

// EXPORTACIÓN: Permitimos que 'main.jsx' pueda leer este archivo y pintarlo en el navegador
export default App