# ANÁLISIS Y ESPECIFICACIÓN DEL SISTEMA - SPORTBYME

| Metadato | Detalle |
| :--- | :--- |
| **Proyecto** | SportByMe |
| **Versión del Documento** | 1.3 (Final - Incluye Módulo Acudiente) |
| **Fecha de Actualización** | Enero 2026 |
| **Responsables** | Julián Falla, Julián Garzón, Luisa López |
| **Estado Actual** | En Desarrollo (Backend Core & Auth) |

---

## 1. Datos Generales del Proyecto
* **Nombre del Proyecto:** SportByMe
* **Objetivo:** Evaluar el sistema actual, identificar limitaciones y proponer una solución tecnológica integral para llevar un historial de deportistas, analizar su evolución y gestionar la administración del club.

---

## 2. Descripción y Actores del Sistema
El sistema SportByMe es una plataforma integral para la gestión de clubes deportivos. Se han identificado y definido los siguientes actores en el sistema (reflejados en la Base de Datos):

1.  **ADMIN (ID 2):** Tiene control total del sistema (usuarios, pagos, torneos, configuraciones).
2.  **ENTRENADOR (ID 3):** Gestiona entrenamientos, partidos, convocatorias y evalúa el rendimiento de los jugadores.
3.  **JUGADOR (ID 1):** (Deportista) Usuario final que consulta su rendimiento, estadísticas y convocatorias.
4.  **ACUDIENTE (ID 4):** Responsable legal de los jugadores menores de edad. Recibe notificaciones, gestiona pagos y supervisa el proceso del menor.

---

## 3. Requerimientos Funcionales (RF)

**Nota de Estado:** Se marca con **[IMPLEMENTADO]** aquellos requisitos que ya están funcionales en el Backend actual.

### 3.1 Módulo de Autenticación (RF00)

| ID | Requisito | Rol | Prioridad | Estado / Notas Técnicas |
| :--- | :--- | :--- | :--- | :--- |
| **RF00.1** | **Autenticación:** El sistema debe permitir iniciar sesión ingresando credenciales válidas. | Todos | Alta | **[IMPLEMENTADO]** Endpoint `/auth/login` con JWT. |
| **RF00.2** | **Registro de cuenta:** El sistema debe permitir crear cuentas proporcionando datos personales y rol. | Todos | Alta | **[IMPLEMENTADO]** Endpoint `/auth/registro-jugador`. Incluye cálculo automático de categoría basado en la edad. |
| **RF00.3** | **Recuperar contraseña:** Permitir recuperar el acceso mediante "¿Olvidaste tu contraseña?". | Todos | Alta | Pendiente. |

### 3.2 Gestión de Usuarios - Admin (RF01)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF01.1** | **Crear usuarios:** El administrador puede crear usuarios y definir roles (incluyendo Acudientes). | Admin | Alta | **[IMPLEMENTADO]** Roles definidos en BD. |
| **RF01.2** | **Editar usuarios:** Actualizar datos personales y credenciales. | Admin | Alta | Pendiente. |
| **RF01.3** | **Activar/Desactivar:** Controlar accesos temporales. | Admin | Media | Pendiente. |
| **RF01.4** | **Buscar usuarios:** Filtros por nombre, rol, estado. | Admin | Media | Pendiente. |

### 3.3 Gestión de Equipos y Categorías (RF02)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF02.1** | **Crear categorías/equipos:** Organizar jugadores según edad/nivel (ej. sub-8). | Admin | Alta | **[PARCIAL]** Lógica de asignación automática por edad implementada en el registro. |
| **RF02.2** | **Editar categorías:** Reflejar cambios organizativos. | Admin | Media | Pendiente. |
| **RF02.3** | **Asignar jugadores:** Vincular jugadores y entrenadores a equipos. | Admin | Alta | Pendiente. |

### 3.4 Gestión de Entrenamientos - Admin (RF03)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF03.1** | **Crear plantillas:** Bases para sesiones de entrenamiento. | Admin | Alta | Pendiente. |
| **RF03.2** | **Asignar horarios:** Optimizar uso de canchas y recursos. | Admin | Alta | Pendiente. |
| **RF03.3** | **Editar/Eliminar plantillas:** Modificar disponibilidad. | Admin | Media | Pendiente. |

### 3.5 Gestión de Competiciones y Torneos (RF04)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF04.1** | **Registrar torneos:** Estructurar calendarios y partidos. | Admin | Alta | Pendiente. |
| **RF04.4** | **Cargar resultados:** Posiciones, estadísticas y seguimiento. | Admin | Alta | Pendiente. |

### 3.6 Gestión Académica / Deportiva (RF05)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF05.1** | **Registrar asistencias:** Control de asistencia. | Admin | Alta | Pendiente. |
| **RF05.2** | **Evaluaciones:** Crear métricas de desempeño técnicas y físicas. | Admin | Alta | Pendiente. |
| **RF05.3** | **Consultar registros:** Ver asistencias y evaluaciones. | Admin | Alta | Pendiente. |

### 3.7 Gestión Administrativa / Financiera (RF06)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF06.1** | **Registrar pagos:** Mensualidades, inscripciones. | Admin | Alta | Pendiente. |
| **RF06.5** | **Reportes financieros:** Generar reportes para control. | Admin | Alta | Pendiente. |

### 3.8 Reportes y Estadísticas (RF07)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF07.1** | **Generar reportes:** Deportivos, administrativos y financieros. | Admin | Alta | Pendiente. |
| **RF07.3** | **Exportar reportes:** Formatos PDF o CSV. | Admin | Media | Pendiente. |

### 3.9 Gestión de Entrenamientos - Entrenador (RF08)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF08.1** | **Planes de entrenamiento:** Crear planes específicos. | Entrenador | Alta | Pendiente. |
| **RF08.3** | **Registrar asistencias:** Controlar presencia de jugadores. | Entrenador | Alta | Pendiente. |

### 3.10 Gestión de Jugadores - Entrenador (RF09)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF09.1** | **Consultar perfiles:** Ver datos completos (posición, historial). | Entrenador | Alta | **[IMPLEMENTADO]** Estructura en BD. |
| **RF09.3** | **Calificar rendimiento:** Asignar puntajes actualizables. | Entrenador | Alta | Pendiente. |

### 3.11 Gestión de Partidos y Comunicación (RF10 - RF12)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF10.1** | **Crear convocatorias:** Notificar a jugadores. | Entrenador | Alta | Pendiente. |
| **RF10.3** | **Registrar resultados:** Estadísticas post-partido. | Entrenador | Alta | Pendiente. |
| **RF11.1** | **Enviar notificaciones:** Mensajes a jugadores y **Acudientes**. | Entrenador | Alta | Pendiente. |
| **RF12.1** | **Reportes:** Progreso individual y grupal. | Entrenador | Alta | Pendiente. |

### 3.12 Módulo del Jugador (RF13 - RF17)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF13.1** | **Consultar perfil:** Ver categoría, posición y estadísticas. | Jugador | Media | **[IMPLEMENTADO]** Backend listo. |
| **RF14.1** | **Consultar calendario:** Ver entrenamientos y partidos. | Jugador | Alta | Pendiente. |
| **RF15.1** | **Seguimiento:** Ver observaciones y desempeño. | Jugador | Alta | Pendiente. |
| **RF16.1** | **Recibir mensajes:** De entrenadores o admin. | Jugador | Alta | Pendiente. |
| **RF17.1** | **Cerrar sesión:** Salida segura del sistema. | Todos | Alta | **[IMPLEMENTADO]**. |

### 3.13 Módulo del Acudiente (RF18)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF18.1** | **Consultar Acudido:** Ver el perfil deportivo de su(s) hijo(s)/acudido(s). | Acudiente | Alta | **[IMPLEMENTADO]** Relación en BD. |
| **RF18.2** | **Recibir Notificaciones:** Alertas de convocatorias y mensajes. | Acudiente | Alta | Pendiente. |
| **RF18.3** | **Consultar Pagos:** Ver historial de mensualidades y deudas. | Acudiente | Alta | Pendiente. |

---

## 4. Requerimientos No Funcionales (RNF)

| ID | Categoría | Descripción | Prioridad | Implementación Actual |
| :--- | :--- | :--- | :--- | :--- |
| **RNF01** | **Seguridad** | Autenticación mediante **JWT**. Control por roles (incluyendo Acudiente). | Alta | **[DONE]** JWT HS256 implementado. |
| **RNF02** | **Seguridad** | Cifrado de contraseñas (BCrypt) y HTTPS. | Alta | **[DONE]** BCrypt activo. |
| **RNF07** | **Rendimiento** | Respuestas API < 2 seg. | Alta | **[DONE]** API optimizada. |
| **RNF13** | **Compatibilidad** | Android/iOS (Crucial para Acudientes). | Alta | API lista. |

---

## 5. Análisis del Entorno Actual

### 5.1 Infraestructura Tecnológica (Tech Stack)
| Componente | Tecnología | Justificación |
| :--- | :--- | :--- |
| **Lenguaje** | **Java 17+ (Spring Boot 3)** | Robustez y Seguridad Empresarial. |
| **Base de Datos** | **MySQL / MariaDB** | Integridad relacional. |
| **Seguridad** | **Spring Security + JWT** | Protección de datos de menores. |
| **Herramientas** | **GitHub, IntelliJ, Postman** | Ciclo de desarrollo profesional. |

### 5.2 Identificación de Problemas Principales
1.  **Gestión manual:** Riesgo de pérdida de datos médicos o de contacto de acudientes.
2.  **Comunicación ineficiente:** Uso informal de WhatsApp sin trazabilidad.
3.  **Pagos desorganizados:** Dificultad para rastrear qué acudiente ha pagado.

---

## 6. Modelo del Sistema Propuesto

### 6.1 Descripción General
SportByMe centraliza la gestión del club, permitiendo que **Administradores** gestionen el negocio, **Entrenadores** se enfoquen en lo deportivo, y **Acudientes/Jugadores** tengan transparencia sobre el progreso y los pagos.

### 6.2 Módulos Clave

| Módulo | Descripción | Usuarios Principales |
| :--- | :--- | :--- |
| **1. Gestión de Usuarios** | Admin de cuentas y roles. | Admin |
| **6. Financiera** | Pagos y facturas (Interacción clave con Acudiente). | Admin / Acudiente |
| **11. Comunicación** | Mensajería oficial y notificaciones. | Entrenador / Acudiente |
| **13. Perfil Personal** | Consulta de datos y estadísticas. | Jugador / Acudiente |

---

## 7. Cumplimiento de Normas y Protocolos

| Norma | Aplicación en el Proyecto |
| :--- | :--- |
| **Ley 1581 (Datos Personales)** | Tratamiento seguro de datos de **menores y acudientes**. |
| **Habeas Data Deportivo** | Derechos de acceso y actualización de información. |
| **ISO/IEC 27001** | Cifrado de contraseñas y control de acceso seguro. |

---

## 8. Riesgos Identificados

| ID | Riesgo | Mitigación Implementada |
| :--- | :--- | :--- |
| **R1** | **Fuga de datos sensibles** | **[DONE]** Uso de JWT, encriptación y roles estrictos para proteger datos de menores y acudientes. |
| **R3** | **Uso no autorizado** | **[DONE]** Autenticación robusta y filtros de seguridad. |
| **R7** | **Inexactitud de datos** | **[DONE]** Validaciones estrictas en el Backend. |

---
