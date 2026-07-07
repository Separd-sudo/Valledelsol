// Centraliza las URLs de los servicios para facilitar su mantenimiento y actualización.
// Cambiamos 'import.meta.env' por 'process.env' y agregamos el prefijo NEXT_PUBLIC_ estándar de Next.js
export const BFF_BASE_URL = "http://localhost:8080/api/v1/bff";


// OJO: Usamos comillas invertidas (backticks ` ) para inyectar la variable correctamente
export const BFF_DASHBOARD_URL = `${BFF_BASE_URL}/dashboard`;
export const BFF_USUARIOS_URL = `${BFF_BASE_URL}/usuarios`;
export const BFF_REPORTES_URL = `${BFF_BASE_URL}/reportes`;