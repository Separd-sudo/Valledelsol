import axios from 'axios';

const BFF_REPORTES_BASE_URL = "http://localhost:8080/api/v1/bff/reportes";

/**
 * Envía el formulario de incendio al BFF con el nivelRiesgo corregido.
 * @param {Object} dataFormulario - { titulo, descripcion, ubicacion, nivelRiesgo }
 */
export const enviarReporteIncendio = async (dataFormulario) => {
    try {
        const respuesta = await axios.post(BFF_REPORTES_BASE_URL, dataFormulario);
        alert("🚨 ¡Reporte de Incendio creado con éxito!");
        return respuesta.data;
    } catch (error) {
        console.error("Error al enviar reporte:", error);
        alert("Error al procesar el reporte.");
        throw error;
    }
};

/**
 * Obtiene el listado de reportes para las tablas del Dashboard
 */
export const obtenerHistorialReportes = async () => {
    try {
        const respuesta = await axios.get(BFF_REPORTES_BASE_URL);
        return respuesta.data;
    } catch (error) {
        console.error("Error al cargar el historial:", error);
        throw error;
    }
};