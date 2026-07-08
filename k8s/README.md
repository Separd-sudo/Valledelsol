# 🚢 Guía de Despliegue en Kubernetes (Amazon EKS) — Valle del Sol

Sigue este orden cronológico estricto para desplegar los componentes en tu clúster de Kubernetes dentro del namespace `valle-del-sol`.

---

## 🛠️ Paso 1: Configurar el Namespace
Crea el entorno lógico de aislamiento:
```bash
kubectl apply -f global/namespace.yaml
```

---

## ⚙️ Paso 2: Configuraciones Globales y Secretos
Inyecta las variables de entorno y las credenciales cifradas:
```bash
kubectl apply -f global/db-config.yaml
kubectl apply -f global/db-secrets.yaml
```

---

## 💾 Paso 3: Capa de Persistencia (PostgreSQL)
Despliega la base de datos PostgreSQL compartida. El ConfigMap inicializará automáticamente todas las bases de datos requeridas (`usuarios_db`, `reportes_db`, etc.):
```bash
kubectl apply -f postgres/postgres-init-configmap.yaml
kubectl apply -f postgres/postgres-deployment.yaml
kubectl apply -f postgres/postgres-service.yaml
```

---

## 📣 Paso 4: Capa de Mensajería (Apache Kafka)
Levanta Zookeeper y Kafka para habilitar la comunicación orientada a eventos (EDA):
```bash
kubectl apply -f kafka/zookeeper.yaml
kubectl apply -f kafka/kafka.yaml
```

---

## 🧠 Paso 5: Capa de Lógica de Negocio (Microservicios)
Despliega los 6 microservicios Spring Boot de manera independiente:
```bash
kubectl apply -f ms-auth/deployment-service.yaml
kubectl apply -f ms-usuarios/deployment-service.yaml
kubectl apply -f ms-reportes/deployment-service.yaml
kubectl apply -f ms-alertas/deployment-service.yaml
kubectl apply -f ms-analitica/deployment-service.yaml
kubectl apply -f ms-geografico/deployment-service.yaml
```

---

## 🏢 Paso 6: Backend for Frontend (BFF)
Despliega el BFF que expone la API Gateway de integración y genera un balanceador de carga público (LoadBalancer) en AWS:
```bash
kubectl apply -f bff-valle-sol/deployment-service.yaml
```

---

## 🌐 Paso 7: Capa de Presentación (Frontend)
Despliega el frontend de usuario:
1. Revisa la DNS del LoadBalancer creada para el BFF ejecutando:
   ```bash
   kubectl get svc bff-valle-sol-service -n valle-del-sol
   ```
2. Edita el archivo `frontend-valle-sol/deployment-service.yaml` y reemplaza la variable `NEXT_PUBLIC_API_BASE_URL` con la DNS pública obtenida en el paso anterior.
3. Aplica el despliegue del frontend:
   ```bash
   kubectl apply -f frontend-valle-sol/deployment-service.yaml
   ```

---

## 🔍 Comandos Útiles de Monitoreo

*   **Verificar el estado de todos los Pods y Servicios:**
    ```bash
    kubectl get all -n valle-del-sol
    ```
*   **Auditar los logs de un servicio (ej. reportes):**
    ```bash
    kubectl logs -f deployment/ms-reportes-deployment -n valle-del-sol
    ```
*   **Inspeccionar un error en un Pod (por si falla al arrancar):**
    ```bash
    kubectl describe pod [nombre-del-pod] -n valle-del-sol
    ```
