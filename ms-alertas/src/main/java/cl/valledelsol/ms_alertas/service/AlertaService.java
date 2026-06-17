package cl.valledelsol.ms_alertas.service;

import cl.valledelsol.ms_alertas.dto.AlertaIncendioDTO;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {

    public void enviarNotificacionesMunicipales(AlertaIncendioDTO alerta) {
        System.out.println("=====================================================");
        System.out.println("🚨 [MS-ALERTAS ➔ SERVICIO] PROCESANDO LOGÍSTICA DE EMERGENCIA");
        System.out.println("📌 Incendio Detectado en Sector: " + alerta.getSector().toUpperCase());
        System.out.println("🔥 Nivel de Riesgo: " + alerta.getGravedad());
        System.out.println("💬 " + alerta.getDescripcion());
        System.out.println("-----------------------------------------------------");
        System.out.println("⚡ [ACCIÓN] Enviando SMS masivos de evacuación perimetral...");
        System.out.println("⚡ [ACCIÓN] Despachando alerta push a brigadistas en ruta...");
        System.out.println("=====================================================");
    }
}