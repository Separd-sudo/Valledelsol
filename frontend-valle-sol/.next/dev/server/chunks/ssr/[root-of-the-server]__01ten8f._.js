module.exports = [
"[externals]/util [external] (util, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("util", () => require("util"));

module.exports = mod;
}),
"[externals]/stream [external] (stream, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("stream", () => require("stream"));

module.exports = mod;
}),
"[externals]/path [external] (path, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("path", () => require("path"));

module.exports = mod;
}),
"[externals]/http [external] (http, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("http", () => require("http"));

module.exports = mod;
}),
"[externals]/https [external] (https, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("https", () => require("https"));

module.exports = mod;
}),
"[externals]/url [external] (url, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("url", () => require("url"));

module.exports = mod;
}),
"[externals]/fs [external] (fs, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("fs", () => require("fs"));

module.exports = mod;
}),
"[externals]/crypto [external] (crypto, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("crypto", () => require("crypto"));

module.exports = mod;
}),
"[externals]/net [external] (net, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("net", () => require("net"));

module.exports = mod;
}),
"[externals]/tls [external] (tls, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("tls", () => require("tls"));

module.exports = mod;
}),
"[externals]/assert [external] (assert, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("assert", () => require("assert"));

module.exports = mod;
}),
"[externals]/tty [external] (tty, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("tty", () => require("tty"));

module.exports = mod;
}),
"[externals]/os [external] (os, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("os", () => require("os"));

module.exports = mod;
}),
"[externals]/events [external] (events, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("events", () => require("events"));

module.exports = mod;
}),
"[externals]/http2 [external] (http2, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("http2", () => require("http2"));

module.exports = mod;
}),
"[externals]/zlib [external] (zlib, cjs)", ((__turbopack_context__, module, exports) => {

const mod = __turbopack_context__.x("zlib", () => require("zlib"));

module.exports = mod;
}),
"[project]/frontend-valle-sol/src/config.js [app-ssr] (ecmascript)", ((__turbopack_context__) => {
"use strict";

// Centraliza las URLs de los servicios para facilitar su mantenimiento y actualización.
// Cambiamos 'import.meta.env' por 'process.env' y agregamos el prefijo NEXT_PUBLIC_ estándar de Next.js
__turbopack_context__.s([
    "BFF_BASE_URL",
    ()=>BFF_BASE_URL,
    "BFF_DASHBOARD_URL",
    ()=>BFF_DASHBOARD_URL,
    "BFF_REPORTES_URL",
    ()=>BFF_REPORTES_URL,
    "BFF_USUARIOS_URL",
    ()=>BFF_USUARIOS_URL
]);
const BFF_BASE_URL = 'http://localhost:8000/api/v1/bff';
const BFF_DASHBOARD_URL = `${BFF_BASE_URL}/dashboard`;
const BFF_USUARIOS_URL = `${BFF_BASE_URL}/usuarios`;
const BFF_REPORTES_URL = `${BFF_BASE_URL}/reportes`;
}),
"[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx [app-ssr] (ecmascript)", ((__turbopack_context__) => {
"use strict";

__turbopack_context__.s([
    "default",
    ()=>__TURBOPACK__default__export__
]);
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react-jsx-dev-runtime.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$axios$2f$lib$2f$axios$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/axios/lib/axios.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$config$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/src/config.js [app-ssr] (ecmascript)"); // Sube un nivel para buscar el config
;
;
;
;
function PanelCiudadano({ token, alCrearReporte }) {
    const [tipo, setTipo] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])('INCENDIO');
    const [descripcion, setDescripcion] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])('');
    const [enviando, setEnviando] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])(false);
    const enviarReporte = (e)=>{
        e.preventDefault();
        setEnviando(true);
        const nuevoReporte = {
            tipo,
            descripcion,
            estado: 'ABIERTO',
            fecha: new Date().toISOString()
        };
        // Petición oficial pasando por el API Gateway Kong hasta el BFF
        __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$axios$2f$lib$2f$axios$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["default"].post(__TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$config$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["BFF_REPORTES_URL"], nuevoReporte, {
            headers: {
                'Authorization': `Bearer ${token}`
            }
        }).then((response)=>{
            alCrearReporte(`🎉 ¡Reporte creado! Mensaje despachado a Kafka (Topic: "incidentes-emergencias"). ID: ${response.data.id || 'Simulado'}`);
            setDescripcion('');
        }).catch((err)=>{
            console.error(err);
            alCrearReporte('❌ Error al enviar reporte al BFF a través de Kong Gateway.');
        }).finally(()=>setEnviando(false));
    };
    return /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
        style: styles.panel,
        children: [
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h2", {
                children: "📢 Módulo Ciudadano: Reportar Emergencia"
            }, void 0, false, {
                fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                lineNumber: 33,
                columnNumber: 7
            }, this),
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("form", {
                onSubmit: enviarReporte,
                style: styles.form,
                children: [
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("label", {
                        children: "Tipo de Emergencia:"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                        lineNumber: 35,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("select", {
                        value: tipo,
                        onChange: (e)=>setTipo(e.target.value),
                        style: styles.input,
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("option", {
                                value: "INCENDIO FORESTAL",
                                children: "🔥🌳 Vegetacion / Bosques 🌳🔥 "
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                                lineNumber: 37,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("option", {
                                value: "INCENDIO ESTRUCTURAL",
                                children: "🔥🚗 Zonas Urbanas / Edificios 🚗 🔥"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                                lineNumber: 38,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("option", {
                                value: "INCENDIO INDUSTRIAL",
                                children: "🏢🔥 Bodegas / Sustancias Quimicas 🏢🔥"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                                lineNumber: 39,
                                columnNumber: 11
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                        lineNumber: 36,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("label", {
                        children: "Detalles de la Situación:"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                        lineNumber: 42,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("textarea", {
                        value: descripcion,
                        onChange: (e)=>setDescripcion(e.target.value),
                        placeholder: "Describe brevemente lo que ocurre y la ubicación...",
                        required: true,
                        style: {
                            ...styles.input,
                            height: '80px',
                            resize: 'none'
                        }
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                        lineNumber: 43,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("button", {
                        type: "submit",
                        disabled: enviando,
                        style: styles.btn,
                        children: enviando ? 'Despachando...' : '🚀 Enviar Reporte de Emergencia'
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                        lineNumber: 51,
                        columnNumber: 9
                    }, this)
                ]
            }, void 0, true, {
                fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
                lineNumber: 34,
                columnNumber: 7
            }, this)
        ]
    }, void 0, true, {
        fileName: "[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx",
        lineNumber: 32,
        columnNumber: 5
    }, this);
}
const styles = {
    panel: {
        background: 'white',
        padding: '25px',
        borderRadius: '10px',
        border: '1px solid #E2E8F0',
        boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)'
    },
    form: {
        display: 'flex',
        flexDirection: 'column',
        gap: '12px',
        marginTop: '15px'
    },
    input: {
        padding: '10px',
        borderRadius: '6px',
        border: '1px solid #CBD5E1',
        fontSize: '15px'
    },
    btn: {
        background: '#16A34A',
        color: 'white',
        border: 'none',
        padding: '12px',
        borderRadius: '6px',
        fontWeight: 'bold',
        cursor: 'pointer',
        fontSize: '16px'
    }
};
const __TURBOPACK__default__export__ = PanelCiudadano;
}),
"[project]/frontend-valle-sol/src/components/PanelBrigadista.jsx [app-ssr] (ecmascript)", ((__turbopack_context__) => {
"use strict";

__turbopack_context__.s([
    "default",
    ()=>__TURBOPACK__default__export__
]);
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react-jsx-dev-runtime.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react.js [app-ssr] (ecmascript)");
;
;
function PanelBrigadista({ token, alActualizar }) {
    const simularAccion = (accion)=>{
        alActualizar(`🦺 Brigada en Terreno ejecutó acción: [${accion}]. Evento enviado a Kafka para actualizar mapa global.`);
    };
    return /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
        style: styles.panel,
        children: [
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h2", {
                children: "🦺 Módulo Brigadista: Gestión de Eventos en Terreno"
            }, void 0, false, {
                fileName: "[project]/frontend-valle-sol/src/components/PanelBrigadista.jsx",
                lineNumber: 10,
                columnNumber: 7
            }, this),
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("p", {
                children: "Actualiza el estado táctico de los incidentes asignados. Cada cambio generará eventos de telemetría inmediatos."
            }, void 0, false, {
                fileName: "[project]/frontend-valle-sol/src/components/PanelBrigadista.jsx",
                lineNumber: 11,
                columnNumber: 7
            }, this),
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                style: styles.gridBtn,
                children: [
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("button", {
                        onClick: ()=>simularAccion('EN ROUTE'),
                        style: {
                            ...styles.btn,
                            background: '#3B82F6'
                        },
                        children: "🚒 En Ruta al Lugar"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelBrigadista.jsx",
                        lineNumber: 14,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("button", {
                        onClick: ()=>simularAccion('MITIGANDO'),
                        style: {
                            ...styles.btn,
                            background: '#D97706'
                        },
                        children: "🧑‍🚒 Combatiendo Emergencia"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelBrigadista.jsx",
                        lineNumber: 15,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("button", {
                        onClick: ()=>simularAccion('CONTROLADO'),
                        style: {
                            ...styles.btn,
                            background: '#16A34A'
                        },
                        children: "✅ Controlado / Extinguido"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelBrigadista.jsx",
                        lineNumber: 16,
                        columnNumber: 9
                    }, this)
                ]
            }, void 0, true, {
                fileName: "[project]/frontend-valle-sol/src/components/PanelBrigadista.jsx",
                lineNumber: 13,
                columnNumber: 7
            }, this)
        ]
    }, void 0, true, {
        fileName: "[project]/frontend-valle-sol/src/components/PanelBrigadista.jsx",
        lineNumber: 9,
        columnNumber: 5
    }, this);
}
const styles = {
    panel: {
        background: 'white',
        padding: '25px',
        borderRadius: '10px',
        border: '1px solid #E2E8F0',
        boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)'
    },
    gridBtn: {
        display: 'flex',
        gap: '15px',
        marginTop: '20px'
    },
    btn: {
        color: 'white',
        border: 'none',
        padding: '15px',
        borderRadius: '6px',
        fontWeight: 'bold',
        cursor: 'pointer',
        flex: 1,
        fontSize: '15px'
    }
};
const __TURBOPACK__default__export__ = PanelBrigadista;
}),
"[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx [app-ssr] (ecmascript)", ((__turbopack_context__) => {
"use strict";

__turbopack_context__.s([
    "default",
    ()=>__TURBOPACK__default__export__
]);
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react-jsx-dev-runtime.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react.js [app-ssr] (ecmascript)");
;
;
function PanelFuncionario({ token }) {
    return /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
        style: styles.panel,
        children: [
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h2", {
                children: "🏢 Panel de Mando Municipal (Administrador)"
            }, void 0, false, {
                fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                lineNumber: 6,
                columnNumber: 7
            }, this),
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("p", {
                children: "Consolidación de auditoría analítica y supervisión del Clúster de Microservicios."
            }, void 0, false, {
                fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                lineNumber: 7,
                columnNumber: 7
            }, this),
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                style: styles.ConsolaMonitoreo,
                children: [
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h4", {
                        style: {
                            margin: '0 0 10px 0',
                            color: '#38BDF8'
                        },
                        children: "🛰️ Monitor de Nodos & Brokers Kafka Activos:"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                        lineNumber: 10,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("ul", {
                        style: {
                            margin: 0,
                            paddingLeft: '20px',
                            color: '#94A3B8',
                            lineHeight: '1.6'
                        },
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("li", {
                                children: [
                                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("span", {
                                        style: {
                                            color: '#4ADE80'
                                        },
                                        children: "● ms-reportes:8081"
                                    }, void 0, false, {
                                        fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                                        lineNumber: 12,
                                        columnNumber: 15
                                    }, this),
                                    " - Conectado a Postgres & Producer Activo"
                                ]
                            }, void 0, true, {
                                fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                                lineNumber: 12,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("li", {
                                children: [
                                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("span", {
                                        style: {
                                            color: '#4ADE80'
                                        },
                                        children: "● ms-usuarios:8082"
                                    }, void 0, false, {
                                        fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                                        lineNumber: 13,
                                        columnNumber: 15
                                    }, this),
                                    " - Servicio de Autenticación & RBAC Estable"
                                ]
                            }, void 0, true, {
                                fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                                lineNumber: 13,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("li", {
                                children: [
                                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("span", {
                                        style: {
                                            color: '#4ADE80'
                                        },
                                        children: "● ms-analitica:8085"
                                    }, void 0, false, {
                                        fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                                        lineNumber: 14,
                                        columnNumber: 15
                                    }, this),
                                    ' - Consumer "analitica-group" escuchando en tiempo real'
                                ]
                            }, void 0, true, {
                                fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                                lineNumber: 14,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("li", {
                                children: [
                                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("span", {
                                        style: {
                                            color: '#4ADE80'
                                        },
                                        children: "● ms-geografico:8086"
                                    }, void 0, false, {
                                        fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                                        lineNumber: 15,
                                        columnNumber: 15
                                    }, this),
                                    ' - Consumer "geografico-group" procesando coordenadas'
                                ]
                            }, void 0, true, {
                                fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                                lineNumber: 15,
                                columnNumber: 11
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                        lineNumber: 11,
                        columnNumber: 9
                    }, this)
                ]
            }, void 0, true, {
                fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
                lineNumber: 9,
                columnNumber: 7
            }, this)
        ]
    }, void 0, true, {
        fileName: "[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx",
        lineNumber: 5,
        columnNumber: 5
    }, this);
}
const styles = {
    panel: {
        background: 'white',
        padding: '25px',
        borderRadius: '10px',
        border: '1px solid #E2E8F0',
        boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)'
    },
    ConsolaMonitoreo: {
        background: '#0F172A',
        color: '#F8FAFC',
        padding: '20px',
        borderRadius: '8px',
        fontFamily: 'monospace',
        marginTop: '15px'
    }
};
const __TURBOPACK__default__export__ = PanelFuncionario;
}),
"[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx [app-ssr] (ecmascript)", ((__turbopack_context__) => {
"use strict";

__turbopack_context__.s([
    "default",
    ()=>__TURBOPACK__default__export__
]);
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react-jsx-dev-runtime.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$axios$2f$lib$2f$axios$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/axios/lib/axios.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$config$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/src/config.js [app-ssr] (ecmascript)");
;
;
;
;
function RegistroUsuario({ alRegistrar }) {
    const [nombre, setNombre] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])('');
    const [email, setEmail] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])('');
    const [password, setPassword] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])('');
    const [rol, setRol] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])('CIUDADANO');
    const [enviando, setEnviando] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])(false);
    const manejarRegistro = (e)=>{
        e.preventDefault();
        setEnviando(true);
        const nuevoUsuario = {
            nombre,
            email,
            password,
            rol
        };
        // Registramos pasando por Kong Gateway hasta llegar al BFF / ms-usuarios
        __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$axios$2f$lib$2f$axios$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["default"].post(__TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$config$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["BFF_USUARIOS_URL"], nuevoUsuario).then((response)=>{
            alert('🎉 Usuario registrado exitosamente en ms-usuarios');
            setNombre('');
            setEmail('');
            setPassword('');
            if (alRegistrar) alRegistrar(response.data);
        }).catch((err)=>{
            console.error(err);
            alert('❌ Error al registrar el usuario mediante el Gateway.');
        }).finally(()=>setEnviando(false));
    };
    return /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
        style: styles.card,
        children: [
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h3", {
                children: "👤 Registro de Nuevo Personal / Ciudadano"
            }, void 0, false, {
                fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                lineNumber: 36,
                columnNumber: 7
            }, this),
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("form", {
                onSubmit: manejarRegistro,
                style: styles.form,
                children: [
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("input", {
                        type: "text",
                        placeholder: "Nombre Completo",
                        value: nombre,
                        onChange: (e)=>setNombre(e.target.value),
                        required: true,
                        style: styles.input
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                        lineNumber: 38,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("input", {
                        type: "email",
                        placeholder: "Correo Electrónico",
                        value: email,
                        onChange: (e)=>setEmail(e.target.value),
                        required: true,
                        style: styles.input
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                        lineNumber: 46,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("input", {
                        type: "password",
                        placeholder: "Contraseña",
                        value: password,
                        onChange: (e)=>setPassword(e.target.value),
                        required: true,
                        style: styles.input
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                        lineNumber: 54,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("label", {
                        style: {
                            fontWeight: 'bold',
                            color: '#475569'
                        },
                        children: "Asignar Rol del Sistema:"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                        lineNumber: 63,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("select", {
                        value: rol,
                        onChange: (e)=>setRol(e.target.value),
                        style: styles.input,
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("option", {
                                value: "CIUDADANO",
                                children: "📢 Ciudadano (Reportes Públicos)"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                                lineNumber: 65,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("option", {
                                value: "BRIGADISTA",
                                children: "🦺 Brigadista (Acciones en Terreno)"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                                lineNumber: 66,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("option", {
                                value: "FUNCIONARIO",
                                children: "🏢 Administrador Municipal (Mando Global)"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                                lineNumber: 67,
                                columnNumber: 11
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                        lineNumber: 64,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("button", {
                        type: "submit",
                        disabled: enviando,
                        style: styles.btn,
                        children: enviando ? 'Guardando en Base de Datos...' : '💾 Registrar Usuario'
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                        lineNumber: 70,
                        columnNumber: 9
                    }, this)
                ]
            }, void 0, true, {
                fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
                lineNumber: 37,
                columnNumber: 7
            }, this)
        ]
    }, void 0, true, {
        fileName: "[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx",
        lineNumber: 35,
        columnNumber: 5
    }, this);
}
const styles = {
    card: {
        background: 'white',
        padding: '25px',
        borderRadius: '10px',
        border: '1px solid #E2E8F0',
        boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)',
        marginBottom: '25px'
    },
    form: {
        display: 'flex',
        flexDirection: 'column',
        gap: '12px',
        marginTop: '15px'
    },
    input: {
        padding: '10px',
        borderRadius: '6px',
        border: '1px solid #CBD5E1',
        fontSize: '15px'
    },
    btn: {
        background: '#2563EB',
        color: 'white',
        border: 'none',
        padding: '12px',
        borderRadius: '6px',
        fontWeight: 'bold',
        cursor: 'pointer',
        fontSize: '16px'
    }
};
const __TURBOPACK__default__export__ = RegistroUsuario;
}),
"[project]/frontend-valle-sol/src/app/page.js [app-ssr] (ecmascript)", ((__turbopack_context__) => {
"use strict";

__turbopack_context__.s([
    "default",
    ()=>Home
]);
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react-jsx-dev-runtime.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/next/dist/server/route-modules/app-page/vendored/ssr/react.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$axios$2f$lib$2f$axios$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/node_modules/axios/lib/axios.js [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$config$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/src/config.js [app-ssr] (ecmascript)");
// Importación de tus componentes modulares
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$components$2f$PanelCiudadano$2e$jsx__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/src/components/PanelCiudadano.jsx [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$components$2f$PanelBrigadista$2e$jsx__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/src/components/PanelBrigadista.jsx [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$components$2f$PanelFuncionario$2e$jsx__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/src/components/PanelFuncionario.jsx [app-ssr] (ecmascript)");
var __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$components$2f$RegistroUsuario$2e$jsx__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__ = __turbopack_context__.i("[project]/frontend-valle-sol/src/components/RegistroUsuario.jsx [app-ssr] (ecmascript)");
"use client"; // Obligatorio en Next.js para usar Hooks de cliente
;
;
;
;
;
;
;
;
function Home() {
    // --- ESTADOS DE AUTENTICACIÓN Y ROLES ---
    const [token, setToken] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])(null);
    const [rolActivo, setRolActivo] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])(null); // CIUDADANO, BRIGADISTA, FUNCIONARIO
    const [usuarioLogueado, setUsuarioLogueado] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])('');
    // --- ESTADOS DE LA PLATAFORMA ---
    const [vistaRegistro, setVistaRegistro] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])(false);
    const [credenciales, setCredenciales] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])({
        email: '',
        password: ''
    });
    const [metricas, setMetricas] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])({
        totalReportes: 0,
        totalUsuarios: 0,
        mensaje: 'Cargando...'
    });
    const [bannerNotificacion, setBannerNotificacion] = (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useState"])(null);
    // Al cargar la app, verifica si ya existía una sesión guardada
    (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["useEffect"])(()=>{
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
    const cargarDashboard = (tokenValido)=>{
        __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$axios$2f$lib$2f$axios$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["default"].get(__TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$config$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["BFF_DASHBOARD_URL"], {
            headers: {
                'Authorization': `Bearer ${tokenValido}`
            }
        }).then((res)=>setMetricas(res.data)).catch((err)=>console.error("Error al refrescar Dashboard:", err));
    };
    // --- CONTROLADOR DEL LOGIN (Conexión con ms-auth) ---
    const manejarLogin = (e)=>{
        e.preventDefault();
        // Petición al endpoint de autenticación mediante el Gateway de Kong
        __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$axios$2f$lib$2f$axios$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["default"].post('/api/v1/auth/login', credenciales).then((res)=>{
            const { tokenJwt, rol, nombre } = res.data; // Datos que retorna tu ms-auth
            // Persistimos en el navegador para evitar pérdidas al dar F5
            localStorage.setItem('token_valle_sol', tokenJwt);
            localStorage.setItem('rol_valle_sol', rol);
            localStorage.setItem('nombre_valle_sol', nombre);
            setToken(tokenJwt);
            setRolActivo(rol);
            setUsuarioLogueado(nombre);
            mostrarBanner(`🔐 Sesión iniciada como ${nombre} con éxito.`);
            cargarDashboard(tokenJwt);
        }).catch((err)=>{
            alert("❌ Credenciales inválidas. Revisa el estado de ms-auth.");
        });
    };
    const manejarCierreSesion = ()=>{
        localStorage.clear();
        setToken(null);
        setRolActivo(null);
        setUsuarioLogueado('');
    };
    const mostrarBanner = (mensaje)=>{
        setBannerNotificacion(mensaje);
        setTimeout(()=>setBannerNotificacion(null), 5000); // Se esconde a los 5 segundos
    };
    // --- RENDERIZADO DE PANTALLA PÚBLICA (LOGIN / REGISTRO) ---
    if (!token) {
        return /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
            style: styles.loginContainer,
            children: /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                style: styles.loginCard,
                children: [
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h2", {
                        style: {
                            textAlign: 'center',
                            color: '#1E293B'
                        },
                        children: "☀️ Sistema Valle del Sol"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 91,
                        columnNumber: 11
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("p", {
                        style: {
                            textAlign: 'center',
                            color: '#64748B',
                            marginTop: '-10px'
                        },
                        children: "Gestión Tecnológica de Incendios y Emergencias"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 92,
                        columnNumber: 11
                    }, this),
                    bannerNotificacion && /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                        style: styles.banner,
                        children: bannerNotificacion
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 94,
                        columnNumber: 34
                    }, this),
                    vistaRegistro ? /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])(__TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["Fragment"], {
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])(__TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$components$2f$RegistroUsuario$2e$jsx__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["default"], {
                                alRegistrar: ()=>{
                                    setVistaRegistro(false);
                                    mostrarBanner("🎉 Registro exitoso. Ahora puedes iniciar sesión.");
                                }
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 99,
                                columnNumber: 15
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("button", {
                                onClick: ()=>setVistaRegistro(false),
                                style: styles.btnSecundario,
                                children: "← Volver al Inicio de Sesión"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 103,
                                columnNumber: 15
                            }, this)
                        ]
                    }, void 0, true) : /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("form", {
                        onSubmit: manejarLogin,
                        style: styles.form,
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("label", {
                                style: styles.label,
                                children: "Correo Electrónico:"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 109,
                                columnNumber: 15
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("input", {
                                type: "email",
                                required: true,
                                style: styles.input,
                                value: credenciales.email,
                                onChange: (e)=>setCredenciales({
                                        ...credenciales,
                                        email: e.target.value
                                    })
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 110,
                                columnNumber: 15
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("label", {
                                style: styles.label,
                                children: "Contraseña:"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 118,
                                columnNumber: 15
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("input", {
                                type: "password",
                                required: true,
                                style: styles.input,
                                value: credenciales.password,
                                onChange: (e)=>setCredenciales({
                                        ...credenciales,
                                        password: e.target.value
                                    })
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 119,
                                columnNumber: 15
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("button", {
                                type: "submit",
                                style: styles.btnPrimario,
                                children: "🔑 Ingresar al Sistema"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 127,
                                columnNumber: 15
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("p", {
                                style: {
                                    textAlign: 'center',
                                    margin: '15px 0 5px 0',
                                    color: '#64748B'
                                },
                                children: "¿Eres un nuevo usuario o brigadista?"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 128,
                                columnNumber: 15
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("button", {
                                type: "button",
                                onClick: ()=>setVistaRegistro(true),
                                style: styles.btnSecundario,
                                children: "👤 Crear una Cuenta Nueva"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 129,
                                columnNumber: 15
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 108,
                        columnNumber: 13
                    }, this)
                ]
            }, void 0, true, {
                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                lineNumber: 90,
                columnNumber: 9
            }, this)
        }, void 0, false, {
            fileName: "[project]/frontend-valle-sol/src/app/page.js",
            lineNumber: 89,
            columnNumber: 7
        }, this);
    }
    // --- RENDERIZADO DE PANTALLA PRIVADA (SISTEMA LOGUEADO) ---
    return /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
        style: styles.dashboardContainer,
        children: [
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("header", {
                style: styles.header,
                children: [
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h1", {
                                style: {
                                    margin: 0,
                                    fontSize: '22px'
                                },
                                children: "☀️ Valle del Sol — Panel de Control"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 145,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("p", {
                                style: {
                                    margin: 0,
                                    color: '#94A3B8',
                                    fontSize: '14px'
                                },
                                children: [
                                    "Bienvenido: ",
                                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("strong", {
                                        children: usuarioLogueado
                                    }, void 0, false, {
                                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                        lineNumber: 146,
                                        columnNumber: 84
                                    }, this),
                                    " [",
                                    rolActivo,
                                    "]"
                                ]
                            }, void 0, true, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 146,
                                columnNumber: 11
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 144,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("button", {
                        onClick: manejarCierreSesion,
                        style: styles.btnCerrar,
                        children: "🚪 Cerrar Sesión"
                    }, void 0, false, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 148,
                        columnNumber: 9
                    }, this)
                ]
            }, void 0, true, {
                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                lineNumber: 143,
                columnNumber: 7
            }, this),
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("section", {
                style: styles.metricsGrid,
                children: [
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                        style: styles.metricCard,
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h3", {
                                children: "🔥 Alertas Activas"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 156,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("p", {
                                style: styles.metricNumber,
                                children: metricas.totalReportes
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 157,
                                columnNumber: 11
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 155,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                        style: styles.metricCard,
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h3", {
                                children: "👥 Usuarios Registrados"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 160,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("p", {
                                style: styles.metricNumber,
                                children: metricas.totalUsuarios
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 161,
                                columnNumber: 11
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 159,
                        columnNumber: 9
                    }, this),
                    /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                        style: {
                            ...styles.metricCard,
                            gridColumn: 'span 2',
                            backgroundColor: '#EFF6FF',
                            border: '1px solid #BFDBFE'
                        },
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h3", {
                                style: {
                                    color: '#1E40AF'
                                },
                                children: "📢 Estado de Orquestación Síncrona (BFF)"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 164,
                                columnNumber: 11
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("p", {
                                style: {
                                    color: '#1E3A8A',
                                    fontSize: '14px',
                                    marginTop: '10px'
                                },
                                children: metricas.mensaje
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 165,
                                columnNumber: 11
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 163,
                        columnNumber: 9
                    }, this)
                ]
            }, void 0, true, {
                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                lineNumber: 154,
                columnNumber: 7
            }, this),
            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("main", {
                style: {
                    marginTop: '30px'
                },
                children: [
                    rolActivo === 'CIUDADANO' && /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h2", {
                                style: styles.tituloSeccion,
                                children: "📢 Panel de Reportes Ciudadanos"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 174,
                                columnNumber: 13
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])(__TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$components$2f$PanelCiudadano$2e$jsx__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["default"], {
                                token: token,
                                alCrearReporte: ()=>{
                                    mostrarBanner("🔥 Incendio reportado con éxito. Evento enviado a Kafka.");
                                    cargarDashboard(token);
                                }
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 175,
                                columnNumber: 13
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 173,
                        columnNumber: 11
                    }, this),
                    rolActivo === 'BRIGADISTA' && /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h2", {
                                style: styles.tituloSeccion,
                                children: "🦺 Panel de Operaciones en Terreno"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 184,
                                columnNumber: 13
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])(__TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$components$2f$PanelBrigadista$2e$jsx__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["default"], {
                                token: token,
                                alActualizarEstado: ()=>{
                                    mostrarBanner("🔄 Estado del incendio actualizado en la base de datos.");
                                    cargarDashboard(token);
                                }
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 185,
                                columnNumber: 13
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 183,
                        columnNumber: 11
                    }, this),
                    rolActivo === 'FUNCIONARIO' && /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("div", {
                        children: [
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])("h2", {
                                style: styles.tituloSeccion,
                                children: "🏢 Panel de Administración Municipal (Mando Global)"
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 194,
                                columnNumber: 13
                            }, this),
                            /*#__PURE__*/ (0, __TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$node_modules$2f$next$2f$dist$2f$server$2f$route$2d$modules$2f$app$2d$page$2f$vendored$2f$ssr$2f$react$2d$jsx$2d$dev$2d$runtime$2e$js__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["jsxDEV"])(__TURBOPACK__imported__module__$5b$project$5d2f$frontend$2d$valle$2d$sol$2f$src$2f$components$2f$PanelFuncionario$2e$jsx__$5b$app$2d$ssr$5d$__$28$ecmascript$29$__["default"], {
                                token: token
                            }, void 0, false, {
                                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                                lineNumber: 195,
                                columnNumber: 13
                            }, this)
                        ]
                    }, void 0, true, {
                        fileName: "[project]/frontend-valle-sol/src/app/page.js",
                        lineNumber: 193,
                        columnNumber: 11
                    }, this)
                ]
            }, void 0, true, {
                fileName: "[project]/frontend-valle-sol/src/app/page.js",
                lineNumber: 170,
                columnNumber: 7
            }, this)
        ]
    }, void 0, true, {
        fileName: "[project]/frontend-valle-sol/src/app/page.js",
        lineNumber: 141,
        columnNumber: 5
    }, this);
}
// --- ESTILOS NATIVOS CSS-IN-JS PARA AGILIZAR LA ENTREGA ---
const styles = {
    loginContainer: {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        height: '100vh',
        backgroundColor: '#F1F5F9'
    },
    loginCard: {
        background: 'white',
        padding: '40px',
        borderRadius: '12px',
        boxShadow: '0 10px 15px -3px rgba(0,0,0,0.1)',
        width: '100%',
        maxWidth: '450px'
    },
    form: {
        display: 'flex',
        flexDirection: 'column',
        gap: '12px',
        marginTop: '20px'
    },
    label: {
        fontWeight: 'bold',
        color: '#475569',
        fontSize: '14px'
    },
    input: {
        padding: '12px',
        borderRadius: '8px',
        border: '1px solid #CBD5E1',
        fontSize: '15px'
    },
    btnPrimario: {
        background: '#2563EB',
        color: 'white',
        border: 'none',
        padding: '14px',
        borderRadius: '8px',
        fontWeight: 'bold',
        cursor: 'pointer',
        fontSize: '16px',
        marginTop: '10px'
    },
    btnSecundario: {
        background: 'none',
        color: '#2563EB',
        border: '1px solid #2563EB',
        padding: '12px',
        borderRadius: '8px',
        fontWeight: 'bold',
        cursor: 'pointer',
        fontSize: '15px',
        width: '100%'
    },
    dashboardContainer: {
        padding: '30px',
        maxWidth: '1200px',
        margin: '0 auto'
    },
    header: {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        background: '#1E293B',
        color: 'white',
        padding: '20px 30px',
        borderRadius: '12px',
        boxShadow: '0 4px 6px -1px rgba(0,0,0,0.05)'
    },
    btnCerrar: {
        background: '#EF4444',
        color: 'white',
        border: 'none',
        padding: '10px 16px',
        borderRadius: '6px',
        fontWeight: 'bold',
        cursor: 'pointer'
    },
    metricsGrid: {
        display: 'grid',
        gridTemplateColumns: 'repeat(4, 1fr)',
        gap: '20px',
        marginTop: '30px'
    },
    metricCard: {
        background: 'white',
        padding: '20px',
        borderRadius: '10px',
        border: '1px solid #E2E8F0',
        boxShadow: '0 1px 3px rgba(0,0,0,0.05)'
    },
    metricNumber: {
        fontSize: '32px',
        fontWeight: 'bold',
        color: '#1E293B',
        margin: '5px 0 0 0'
    },
    tituloSeccion: {
        color: '#1E293B',
        borderBottom: '2px solid #E2E8F0',
        paddingBottom: '10px',
        marginBottom: '20px'
    },
    banner: {
        background: '#10B981',
        color: 'white',
        padding: '12px',
        borderRadius: '8px',
        fontWeight: 'bold',
        textAlign: 'center',
        marginBottom: '15px'
    }
};
}),
];

//# sourceMappingURL=%5Broot-of-the-server%5D__01ten8f._.js.map