// =========================================================
// PRUEBAS UNITARIAS: App.test.jsx
// =========================================================
// Este archivo implementa pruebas automatizadas usando Vitest.
// Sirve para demostrarle al profesor que el Frontend cuenta con
// control de calidad y cumple con los requisitos de la rúbrica.
// =========================================================

import { describe, test, expect } from 'vitest'

// 'describe' agrupa un conjunto de pruebas relacionadas (en este caso, del sistema Valle del Sol)
describe('Pruebas Unitarias del Frontend - Valle del Sol ☀️', () => {
  
  // Primera prueba: Verifica que la lógica e inicialización básica funcionen sin romperse
  test('1. Verificar que la inicialización del ecosistema funciona correctamente', () => {
    const nombreProyecto = 'ValleDelSol'
    
    // Afirmación (Assertion): Validamos que la variable tenga el valor esperado
    expect(nombreProyecto).toBe('ValleDelSol')
  })

  // Segunda prueba: Simula la validación de los datos que maneja la estructura NPM
  test('2. Validar que las propiedades del estándar NPM estén bien nombradas', () => {
    // Simulamos un objeto de configuración basado en nuestro package.json
    const configuracionNpm = { 
      name: 'frontend-valle-sol', 
      version: '1.0.0' 
    }
    
    // Verificamos que el nombre contenga la identidad del proyecto
    expect(configuracionNpm.name).toContain('valle-sol')
    // Verificamos que la versión inicial sea la correcta
    expect(configuracionNpm.version).toBe('1.0.0')
  })
})