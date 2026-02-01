# ANÁLISIS, ESPECIFICACIÓN Y REQUISITOS DEL SISTEMA - SPORTBYME

| Metadato | Detalle |
| :--- | :--- |
| **Proyecto** | SportByMe |
| **Versión del Documento** | 2.1 (Master - Contexto + Técnica) |
| **Fecha de Actualización** | Febrero 2026 |
| **Responsables** | Julián Falla, Julián Garzón, Luisa López |
| **Estado Actual** | En Desarrollo (Backend Core & Auth) |

---

## 1. Datos Generales del Proyecto
* **Nombre del Proyecto:** SportByMe
* **Objetivo:** Evaluar el sistema actual, identificar limitaciones y proponer una solución tecnológica integral para llevar un historial de deportistas, analizar su evolución y gestionar la administración del club.
* **Fuentes Consultadas:** Entrevistas con usuarios clave y cuestionarios de diagnóstico.

---

## 2. Identificación de Problemas (Justificación)
Se han identificado las siguientes falencias en la operación actual que justifican el desarrollo del software:

| Problema | Descripción | Impacto |
| :--- | :--- | :--- |
| **1. Gestión Manual** | Uso de hojas de cálculo o papel para datos vitales. | Pérdida de datos y errores humanos. |
| **2. Comunicación Ineficiente** | Uso informal de WhatsApp. | Desinformación y falta de trazabilidad. |
| **3. Falta de Trazabilidad** | No hay historial de rendimiento deportivo. | Evaluaciones subjetivas. |
| **4. Seguimiento Médico** | Lesiones no registradas formalmente. | Riesgo para la salud del deportista. |
| **5. Pagos Desorganizados** | Control manual de mensualidades. | Morosidad y confusión financiera. |
| **6. Sin Roles Definidos** | Acceso a información sin restricciones. | Exposición de datos sensibles de menores. |
| **7. Falta de Reportes** | No existen estadísticas automáticas. | Dificultad para tomar decisiones. |

---

## 3. Descripción y Actores del Sistema
El sistema SportByMe es una plataforma integral para la gestión de clubes deportivos con los siguientes actores:

1.  **ADMIN (ID 2):** Control total (usuarios, pagos, torneos, config).
2.  **ENTRENADOR (ID 3):** Gestión deportiva (entrenos, partidos, evaluaciones).
3.  **JUGADOR (ID 1):** Usuario final (consulta rendimiento y convocatorias).
4.  **ACUDIENTE (ID 4):** Responsable legal (pagos, permisos, notificaciones).

---

## 4. Reglas de Negocio (Business Rules)
[cite_start]Lógica inteligente que el sistema valida automáticamente[cite: 17, 18, 27].

### 4.1 Estructura y Registro
* **BR01 (Unicidad):** Email y Documento únicos en BD.
* **BR02 (Seguridad):** Contraseñas encriptadas (BCrypt).
* **BR03 (Vinculación):** Menores de 18 años requieren Acudiente.
* **BR04 (Categoría Automática):** Se calcula según la fecha de nacimiento.
* **BR05 (Cupos):** Máximo 25 jugadores por equipo.
* **BR06 (Dorsales):** No repetir números en un mismo equipo.

### 4.2 Control Disciplinario y Competitivo
* **BR07 (Habilitación):** Solo convocar jugadores activos/sin lesiones.
* **BR08 (Consistencia):** Goles individuales = Marcador final.
* **BR09 (Sanción):** 3 Amarillas = Suspensión automática.
* **BR10 (Expulsión):** Roja directa = Bloqueo siguiente partido.

### 4.3 Control Médico y Financiero
* **BR11 (Alerta IMC):** Alerta automática por sobrepeso/delgadez.
* **BR13 (Bloqueo Mora):** No permite asistencia si hay deuda.
* **BR14 (Bloqueo Admin):** 2 meses deuda = Bloqueo de reportes al acudiente.

---

## 5. Requerimientos Funcionales (RF)

### 5.1 Módulo de Autenticación (RF00)
| ID | Requisito | Estado / Notas |
| :--- | :--- | :--- |
| **RF00.1** | **Autenticación:** Login seguro con Token JWT. | **[IMPLEMENTADO]** |
| **RF00.2** | **Registro:** Crear cuenta con cálculo de categoría. | **[IMPLEMENTADO]** |
| **RF00.3** | **Recuperación:** Restablecer contraseña vía email. | Pendiente |

### 5.2 Gestión de Usuarios - Admin (RF01)
| ID | Requisito | Estado / Notas |
| :--- | :--- | :--- |
| **RF01.1** | **Crear Usuarios:** Definir roles (inc. Acudiente). | **[IMPLEMENTADO]** |
| **RF01.2** | **Editar Usuarios:** Actualizar datos y credenciales. | Pendiente |
| **RF01.3** | **Activar/Desactivar:** Control de acceso temporal. | Pendiente |
| **RF01.4** | **Buscar:** Filtros por nombre y rol. | Pendiente |

### 5.3 Gestión de Equipos (RF02)
| ID | Requisito | Estado / Notas |
| :--- | :--- | :--- |
| **RF02.1** | **Crear Categorías:** Organización por edad. | **[PARCIAL]** (Lógica auto) |
| **RF02.3** | **Asignar:** Vincular jugadores a equipos. | Pendiente |

### 5.4 Gestión Deportiva (RF03-RF05)
| ID | Requisito | Estado / Notas |
| :--- | :--- | :--- |
| **RF03.1** | **Entrenamientos:** Crear plantillas y horarios. | Pendiente |
| **RF04.1** | **Torneos:** Registrar partidos y calendarios. | Pendiente |
| **RF04.4** | **Resultados:** Cargar marcadores y stats. | Pendiente |
| **RF05.1** | **Asistencias:** Control de presencia. | Pendiente |

### 5.5 Gestión Financiera (RF06)
| ID | Requisito | Estado / Notas |
| :--- | :--- | :--- |
| **RF06.1** | **Pagos:** Registrar mensualidades. | Pendiente |
| **RF06.5** | **Reportes Financieros:** Control de caja. | Pendiente |

### 5.6 Módulos de Roles Específicos (RF08-RF18)
| ID | Requisito | Rol | Estado |
| :--- | :--- | :--- | :--- |
| **RF09.1** | **Consultar Perfiles:** Ver datos técnicos/médicos. | Entrenador | **[IMPLEMENTADO]** |
| **RF10.1** | **Convocatorias:** Notificar a Jugador/Acudiente. | Entrenador | Pendiente |
| **RF13.1** | **Mi Perfil:** Ver estadísticas propias. | Jugador | **[IMPLEMENTADO]** |
| **RF18.1** | **Consultar Acudido:** Ver datos del hijo. | Acudiente | **[IMPLEMENTADO]** |

---

## 6. Requerimientos No Funcionales (RNF)

| ID | Categoría | Descripción | Prioridad |
| :--- | :--- | :--- | :--- |
| **RNF01** | **Seguridad** | Autenticación **JWT** y Roles. | Alta |
| **RNF02** | **Cifrado** | Contraseñas **BCrypt** y HTTPS (TLS 1.3). | Alta |
| **RNF07** | **Rendimiento** | Respuestas API < 2 seg. | Alta |
| **RNF09** | **Escalabilidad** | Arquitectura Modular (Backend Java). | Media |
| **RNF13** | **Compatibilidad** | Web, Android e iOS. | Alta |

---

## 7. Infraestructura Tecnológica (Actualizada)

| Componente | Tecnología | Justificación |
| :--- | :--- | :--- |
| **Lenguaje Backend** | **Java 17** | Estándar empresarial y robusto. |
| **Framework** | **Spring Boot 3** | Seguridad y rapidez en APIs REST. |
| **Base de Datos** | **MySQL / MariaDB** | Integridad relacional de datos. |
| **Entorno Local** | **XAMPP / Docker** | Simulación de servidor DB. |
| **Control Versiones** | **Git / GitHub** | Trabajo colaborativo y backups. |
| **Frontend (Futuro)** | **HTML/JS/Framework** | Interfaz de usuario responsiva. |

---

## 8. Cumplimiento de Normas y Protocolos
[cite_start]El sistema garantiza el cumplimiento legal, crucial por el manejo de menores[cite: 63, 64, 66].

| Norma | Descripción y Aplicación |
| :--- | :--- |
| **Ley 1581 (Datos Personales)** | Tratamiento seguro y autorizado de datos de menores. |
| **Habeas Data Deportivo** | Derecho a consultar, actualizar y eliminar información. |
| **ISO/IEC 27001** | Cifrado, backups y control de acceso seguro. |
| **OWASP Top 10** | Protección contra inyecciones SQL y ataques XSS. |
| **WCAG 2.1 (Accesibilidad)** | Interfaz amigable para todo tipo de usuario. |

---

## 9. Matriz de Riesgos

| Riesgo | Nivel | Mitigación Implementada |
| :--- | :--- | :--- |
| **R1. Fuga de Datos** | Alto | Cifrado BCrypt y Seguridad JWT. |
| **R2. Fallos Sistema** | Alto | Pruebas de carga y monitoreo. |
| **R3. Uso no autorizado** | Alto | Filtros de Seguridad (Roles). |
| **R7. Datos Inexactos** | Medio | Validaciones estrictas en Backend. |
| **R9. Legal** | Medio | Términos y condiciones claros. |

---

## 10. Conclusiones y Recomendaciones

### 10.1 Conclusiones
1.  **Digitalización Urgente:** Elimina el riesgo de pérdida de datos físicos.
2.  **Centralización:** Integra lo deportivo, médico y financiero en un solo lugar.
3.  **Seguridad:** El uso de Java Spring Boot garantiza protección profesional.
4.  **Transparencia:** Acudientes y directivos tienen claridad real del estado del club.

### 10.2 Recomendaciones
1.  **Fase Piloto:** Iniciar con una categoría pequeña para validar.
2.  **UX Móvil:** Priorizar el diseño para celulares (donde entran los padres).
3.  **Capacitación:** Formar a los entrenadores en el uso de la app.
4.  **Backups:** Asegurar copias de seguridad automáticas de la Base de Datos.

---
