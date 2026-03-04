# ANÁLISIS, ESPECIFICACIÓN Y REQUISITOS DEL SISTEMA - SPORTBYME

| Metadato | Detalle |
| :--- | :--- |
| **Proyecto** | SportByMe |
| **Versión del Documento** | 2.2 (Master - Completo y Unificado) |
| **Fecha de Actualización** | Febrero 2026 |
| **Responsables** | Julián Falla, Julián Garzón, Luisa López |
| **Estado Actual** | En Desarrollo (Backend Core & Auth) |

---

## 1. Datos Generales del Proyecto
* **Nombre del Proyecto:** SportByMe
* **Objetivo:** Evaluar el sistema actual, identificar limitaciones y proponer una solución tecnológica integral para llevar un historial de deportistas, analizar su evolución y gestionar la administración del club de manera centralizada y segura.
* [cite_start]**Fuentes Consultadas:** Entrevistas con usuarios clave y cuestionarios de diagnóstico[cite: 10, 11, 12].

---

## 2. Identificación de Problemas (Justificación)
[cite_start]Se han identificado las siguientes falencias en la operación actual que justifican el desarrollo del software[cite: 41, 42]:

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
[cite_start]El sistema SportByMe es una plataforma integral para la gestión de clubes deportivos[cite: 45]. Se han identificado y definido los siguientes actores en el sistema:

1.  **ADMIN (ID 2):** Tiene control total del sistema (usuarios, pagos, torneos, configuraciones).
2.  **ENTRENADOR (ID 3):** Gestiona entrenamientos, partidos, convocatorias y evalúa el rendimiento de los jugadores.
3.  **JUGADOR (ID 1):** (Deportista) Usuario final que consulta su rendimiento, estadísticas y convocatorias.
4.  **ACUDIENTE (ID 4):** Responsable legal de los jugadores menores de edad. Recibe notificaciones, gestiona pagos y supervisa el proceso del menor.

---

## 4. Reglas de Negocio (Business Rules)
Estas reglas definen la lógica inteligente del sistema y las restricciones que el software valida automáticamente.

### 4.1 Estructura y Registro
* **BR01 (Unicidad):** No pueden existir dos usuarios con el mismo correo electrónico o número de documento.
* **BR02 (Seguridad):** Las contraseñas deben ser almacenadas de forma encriptada (Hash BCrypt).
* **BR03 (Vinculación):** Si el usuario es menor de 18 años, el sistema obliga a vincular un "Acudiente" responsable.
* **BR04 (Categorización Automática):** La categoría (Sub-15, Sub-20, etc.) se asigna automáticamente calculando la edad del jugador según su fecha de nacimiento.
* **BR05 (Cupos de Equipo):** Un equipo no puede tener más de 25 jugadores activos inscritos.
* **BR06 (Dorsales):** No pueden existir dos jugadores con el mismo número de dorsal en el mismo equipo activo.

### 4.2 Control Disciplinario y Competitivo
* **BR07 (Jugador Habilitado):** Solo se pueden convocar a un partido jugadores que estén activos y que NO tengan una lesión con estado "EN TRATAMIENTO".
* **BR08 (Validación de Resultado):** La suma de goles individuales debe coincidir con el marcador final del partido.
* **BR09 (Acumulación de Tarjetas):** Si un jugador acumula **3 tarjetas amarillas** en un mismo torneo, el sistema debe marcarlo automáticamente como "SUSPENDIDO" para el siguiente partido.
* **BR10 (Expulsión Directa):** Un jugador con tarjeta roja en un partido no puede ser convocado al siguiente encuentro.

### 4.3 Control Médico y Físico
* **BR11 (Alerta IMC):** El sistema calculará el Índice de Masa Corporal. Si indica sobrepeso o delgadez extrema, generará una alerta al entrenador.
* **BR12 (Restricción Post-Lesión):** Un jugador con lesión grave no puede ser convocado hasta 15 días después de su alta médica.

### 4.4 Financiero y Administrativo
* **BR13 (Bloqueo por Mora):** El sistema no permite marcar asistencia a entrenamientos si el jugador tiene el estado "BLOQUEADO POR PAGO".
* **BR14 (Bloqueo Administrativo):** Si un acudiente acumula 2 meses de deuda, se bloquea su acceso a reportes y estadísticas (pero el jugador sigue activo).
* **BR15 (Cupo de Extranjeros):** El sistema no permitirá inscribir más de 3 jugadores con nacionalidad extranjera en el mismo equipo competitivo.
* **BR16 (Ventana de Fichajes):** Solo se permite registrar nuevos jugadores en un equipo competitivo durante los meses de Enero y Julio.

---

## 5. Requerimientos Funcionales (Detallados)

### [cite_start]5.1 Módulo de Autenticación (RF00) [cite: 14, 15]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF00.1** | **Autenticación:** Iniciar sesión con credenciales válidas (JWT). | BR02 | **[IMPLEMENTADO]** |
| **RF00.2** | **Registro:** Crear cuenta con validación de datos y cálculo de categoría. | BR01, BR03, BR04 | **[IMPLEMENTADO]** |
| **RF00.3** | **Recuperación:** Restablecer contraseña vía "¿Olvidaste tu contraseña?". | BR02 | Pendiente |

### [cite_start]5.2 Gestión de Usuarios - Admin (RF01) [cite: 15, 16, 17]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF01.1** | **Crear Usuarios:** Crear entrenadores, deportistas y acudientes. | BR01, BR03 | **[IMPLEMENTADO]** |
| **RF01.2** | **Editar Usuarios:** Actualizar datos personales y credenciales. | BR01, BR04 | Pendiente |
| **RF01.3** | **Activar/Desactivar:** Controlar accesos sin eliminar cuenta. | - | Pendiente |
| **RF01.4** | **Buscar Usuarios:** Filtros por nombre, rol y estado. | - | Pendiente |
| **RF01.5** | **Exportar:** Descargar listados en CSV para auditoría. | - | Pendiente |
| **RF01.6** | **Eliminar:** Borrar usuarios inactivos (depuración). | - | Pendiente |

### [cite_start]5.3 Gestión de Equipos y Categorías (RF02) [cite: 17, 18]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF02.1** | **Crear Categorías:** Definir grupos (ej. Sub-8, Sub-12). | - | **[PARCIAL]** (Lógica auto) |
| **RF02.2** | **Editar Categorías:** Reflejar cambios organizativos (incluye desvincular jugadores o entrenadores). | - | Pendiente |
| **RF02.3** | **Asignar Miembros:** Vincular jugadores y entrenadores a equipos. | BR04, BR05, BR06 (Dorsales) | Pendiente |
| **RF02.4** | **Eliminar Categorías:** Borrar equipos inactivos. | - | Pendiente |

### [cite_start]5.4 Gestión de Entrenamientos - Admin (RF03) [cite: 18, 19, 20]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF03.1** | **Crear Plantillas:** Bases para sesiones de entrenamiento. | - | Pendiente |
| **RF03.2** | **Asignar Horarios:** Optimizar uso de canchas/recursos. Validar disponibilidad de canchas | - | Pendiente |
| **RF03.3** | **Editar Plantillas:** Modificar disponibilidad. | - | Pendiente |
| **RF03.4** | **Eliminar Plantillas:** Borrar datos obsoletos. | - | Pendiente |
| **RF03.5** | **Buscar Entrenamientos:** Filtros por fecha, categoría o equipo. | - | Pendiente |

### [cite_start]5.5 Gestión de Competiciones (RF04) [cite: 20, 21]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF04.1** | **Registrar Torneos:** Estructurar calendarios y partidos. | - | Pendiente |
| **RF04.2** | **Editar Torneos:** Ajustar fechas o participantes. | - | Pendiente |
| **RF04.3** | **Eliminar Torneos:** Depurar competiciones canceladas. | - | Pendiente |
| **RF04.4** | **Cargar Resultados:** Registrar marcadores, posiciones y estadísticas. | BR08, BR09 | Pendiente |

### [cite_start]5.6 Gestión Académica/Deportiva (RF05) [cite: 21, 22]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF05.1** | **Registrar Asistencias:** Control de presencia (Admin, Entrenador). | BR13 | Pendiente |
| **RF05.2** | **Evaluaciones:** Crear métricas de desempeño técnicas/físicas (Entrenador). | BR11 | Pendiente |
| **RF05.3** | **Consultar Registros:** Ver historial de asistencias/evaluaciones (Admin). | - | Pendiente |
| **RF05.4** | **Editar Registros:** Corrección de errores en evaluaciones (Admin). | - | Pendiente |
| **RF05.5** | **Buscar Registros:** Localizar jugadores o equipos específicos (Admin). | - | Pendiente |

### [cite_start]5.7 Gestión Financiera (RF06) [cite: 23, 24]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF06.1** | **Registrar Pagos:** Mensualidades, inscripciones, uniformes. | BR14 | Pendiente |
| **RF06.2** | **Editar Estado:** Cambiar entre Pendiente/Pagado. | - | Pendiente |
| **RF06.3** | **Eliminar Pagos:** Borrar registros erróneos. | - | Pendiente |
| **RF06.4** | **Consultar Facturas:** Trazabilidad de cobros generados. | - | Pendiente |
| **RF06.5** | **Reportes Financieros:** Control de caja administrativo. | - | Pendiente |

### [cite_start]5.8 Reportes Generales (RF07) [cite: 24, 25]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF07.1** | **Generar Reportes:** Consolidado deportivo y financiero. | - | Pendiente |
| **RF07.2** | **Filtrar Reportes:** Por fecha, usuario o entidad. | - | Pendiente |
| **RF07.3** | **Exportar Reportes:** Descarga en PDF o CSV. | - | Pendiente |

### [cite_start]5.9 Gestión Entrenador - Entrenamientos (RF08) [cite: 25]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF08.1** | **Crear Planes:** Diseñar sesiones para su equipo. | - | Pendiente |
| **RF08.2** | **Asignar Sesiones:** Vincular plan a categoría/jugador. | - | Pendiente |
| **RF08.3** | **Tomar Asistencia:** Registrar presencia en cancha. | BR13 | Pendiente |

### [cite_start]5.10 Gestión Entrenador - Jugadores (RF09) [cite: 25, 26]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF09.1** | **Consultar Perfil:** Ver datos técnicos, físicos y médicos. | BR11 (IMC) | **[IMPLEMENTADO]** |
| **RF09.2** | **Registrar Observaciones:** Notas tácticas sobre el jugador. | - | Pendiente |
| **RF09.3** | **Calificar Rendimiento:** Asignar puntajes periódicos. | - | Pendiente |

### [cite_start]5.11 Gestión Entrenador - Partidos (RF10) [cite: 26, 27]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF10.1** | **Crear Convocatorias:** Notificar a jugadores/acudientes. | BR07, BR10, BR12 | Pendiente |
| **RF10.2** | **Definir Alineaciones:** Estrategia pre-partido. | - | Pendiente |
| **RF10.3** | **Registrar Post-Partido:** Resultados y estadísticas. | BR08 | Pendiente |

### [cite_start]5.12 Comunicación (RF11) [cite: 27]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF11.1** | **Enviar Mensajes:** Notificaciones a jugadores/acudientes. | - | Pendiente |
| **RF11.2** | **Recibir Mensajes:** Confirmaciones de asistencia. | - | Pendiente |

### [cite_start]5.13 Reportes de Rendimiento (RF12) [cite: 28]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF12.1** | **Reporte Individual:** Progreso de un jugador específico. | - | Pendiente |
| **RF12.2** | **Reporte Grupal:** Métricas generales del equipo. | - | Pendiente |

### [cite_start]5.14 Módulo Deportista - Perfil (RF13) [cite: 28]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF13.1** | **Consultar Perfil:** Ver categoría, posición y stats. | BR04, BR11 | **[IMPLEMENTADO]** |
| **RF13.2** | **Actualizar Datos:** Editar info de contacto no sensible. | - | Pendiente |

### [cite_start]5.15 Módulo Deportista - Calendario (RF14) [cite: 29]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF14.1** | **Ver Entrenamientos:** Consultar agenda de prácticas. | - | Pendiente |
| **RF14.2** | **Ver Partidos:** Consultar convocatorias. | - | Pendiente |
| **RF14.3** | **Ver Resultados:** Historial de marcadores pasados. | - | Pendiente |

### [cite_start]5.16 Módulo Deportista - Seguimiento (RF15-RF16-RF17) [cite: 29, 30]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF15.1** | **Ver Observaciones:** Feedback del entrenador. | - | Pendiente |
| **RF15.2** | **Ver Estadísticas:** Goles, asistencias, estado físico. | - | Pendiente |
| **RF16.1** | **Buzón de Mensajes:** Comunicados del club. | - | Pendiente |
| **RF16.2** | **Notificaciones:** Alertas de eventos en tiempo real. | - | Pendiente |
| **RF17.1** | **Cerrar Sesión:** Salida segura del sistema. | - | **[IMPLEMENTADO]** |

### 5.17 Módulo Acudiente (Nuevo - RF18)
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF18.1** | **Consultar Acudido:** Ver perfil del hijo (Solo lectura). | BR03 | **[IMPLEMENTADO]** |
| **RF18.2** | **Notificaciones:** Recibir alertas de pagos y partidos. | - | Pendiente |
| **RF18.3** | **Pagos:** Ver estado de cuenta y deudas. | BR13, BR14 | Pendiente |

---

## 6. Requerimientos No Funcionales (RNF)

| ID | Categoría | Descripción | Prioridad |
| :--- | :--- | :--- | :--- |
| **RNF01** | **Seguridad** | Autenticación **JWT** y Roles. | Alta |
| **RNF02** | **Cifrado** | Contraseñas **BCrypt** y HTTPS (TLS 1.3). | Alta |
| **RNF07** | **Rendimiento** | Respuestas API < 2 seg. | Alta |
| **RNF09** | **Escalabilidad** | Arquitectura Modular (Backend Java). | Media |
| **RNF13** | **Compatibilidad** | Web, Android e iOS. | Alta |
| **RNF04** | **Usabilidad** | Tareas en máx. 3 clics. | Media |

---

## 7. Infraestructura Tecnológica (Actualizada)

| Componente | Tecnología | Justificación |
| :--- | :--- | :--- |
| **Lenguaje Backend** | **Java 17** | Estándar empresarial y robusto. |
| **Framework** | **Spring Boot 3** | Seguridad y rapidez en APIs REST. |
| **Base de Datos** | **MySQL / MariaDB** | Integridad relacional de datos. |
| **Entorno Local** | **XAMPP / Docker** | Simulación de servidor DB. |
| **Control Versiones** | **Git / GitHub** | Trabajo colaborativo y backups. |

---

## 8. Cumplimiento de Normas y Protocolos
[cite_start]El sistema garantiza el cumplimiento legal, crucial por el manejo de menores[cite: 66, 67].

| Norma | Descripción y Aplicación |
| :--- | :--- |
| **Ley 1581 (Datos Personales)** | Tratamiento seguro y autorizado de datos de menores. |
| **Habeas Data Deportivo** | Derecho a consultar, actualizar y eliminar información. |
| **ISO/IEC 27001** | Cifrado, backups y control de acceso seguro. |
| **OWASP Top 10** | Protección contra inyecciones SQL y ataques XSS. |
| **WCAG 2.1 (Accesibilidad)** | Interfaz amigable para todo tipo de usuario. |

---

## [cite_start]9. Matriz de Riesgos [cite: 69, 70, 71]

| Riesgo | Nivel | Mitigación Implementada |
| :--- | :--- | :--- |
| **R1. Fuga de Datos** | Alto | Cifrado BCrypt y Seguridad JWT. |
| **R2. Fallos Sistema** | Alto | Pruebas de carga y monitoreo. |
| **R3. Uso no autorizado** | Alto | Filtros de Seguridad (Roles). |
| **R7. Datos Inexactos** | Medio | Validaciones estrictas en Backend. |
| **R9. Legal** | Medio | Términos y condiciones claros. |
| **R10. Saturación** | Alto | Optimización de consultas DB. |

---

## [cite_start]10. Conclusiones y Recomendaciones [cite: 73, 74, 84, 85]

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
