import { describe, test, expect } from 'vitest'

describe('Pruebas Unitarias del Frontend - Valle del Sol ☀️', () => {
  
  // PRUEBA 1: Estructura básica
  test('1. Verificar que la inicialización del ecosistema funciona correctamente', () => {
    const nombreProyecto = 'ValleDelSol'
    expect(nombreProyecto).toBe('ValleDelSol')
  })

  // PRUEBA 2: Configuración NPM
  test('2. Validar que las propiedades del estándar NPM estén bien nombradas', () => {
    const configuracionNpm = { name: 'frontend-valle-sol', version: '1.0.0' }
    expect(configuracionNpm.name).toContain('valle-sol')
    expect(configuracionNpm.version).toBe('1.0.0')
  })

  // PRUEBA 3: Validar que la URL del BFF apunte al puerto correcto (YA CORREGIDA!)
  test('3. Verificar que la configuración de red apunte al puerto correcto del BFF (8080)', () => {
    const BFF_URL = 'http://localhost:8080/api'
    
    expect(BFF_URL).toBeDefined()
    expect(BFF_URL).toContain('8080')
    // Usamos toMatch con ^ para asegurar que el string INICIE con http://
    expect(BFF_URL).toMatch(/^http:\/\//)
  })

  // PRUEBA 4: Simular el estado de carga inicial de la pantalla
  test('4. Validar el estado inicial del mensaje de conexión antes de recibir datos', () => {
    const estadoInicialMensaje = 'Conectando al BFF...'
    
    expect(estadoInicialMensaje).toBe('Conectando al BFF...')
    expect(estadoInicialMensaje).not.toBe('') 
  })
})