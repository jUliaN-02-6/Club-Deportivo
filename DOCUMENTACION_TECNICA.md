# ANÁLISIS Y ESPECIFICACIÓN DEL SISTEMA - SPORTBYME

| Metadato | Detalle |
| :--- | :--- |
| **Proyecto** | SportByMe |
| **Versión del Documento** | 1.1 (Actualizado - Fase de Implementación Backend) |
| **Fecha de Actualización** | Enero 2026 |
| **Responsables** | Julián Falla, Julián Garzón, Luisa López |
| **Estado Actual** | En Desarrollo (Backend Core & Auth) |

---

## 1. Objetivo del Análisis
El objetivo de este documento es detallar la arquitectura, requisitos y diseño del sistema **SportByMe**, una plataforma integral para la gestión deportiva. Este documento ha sido actualizado para reflejar las decisiones tecnológicas tomadas durante la fase de implementación del Backend.

---

## 2. Infraestructura Tecnológica (Actualizada)
Se define la siguiente pila tecnológica (Tech Stack) para la implementación del sistema, reemplazando las propuestas genéricas del análisis inicial.

| Componente | Tecnología Seleccionada | Justificación Técnica |
| :--- | :--- | :--- |
| **Lenguaje Backend** | **Java 17+** | Estándar empresarial, robustez, tipado estricto y alto rendimiento. |
| **Framework** | **Spring Boot 3** | Facilita la inyección de dependencias, seguridad y creación de APIs REST. |
| **Base de Datos** | **MySQL / MariaDB** | Persistencia relacional para asegurar la integridad de datos de usuarios, torneos y pagos. |
| **Seguridad** | **Spring Security + JWT** | Autenticación "Stateless" (sin estado) mediante JSON Web Tokens (HS256). |
| **Encriptación** | **BCrypt** | Hashing irreversible de contraseñas para cumplimiento de seguridad. |
| **Entorno Local** | **XAMPP / Docker** | Para gestión de base de datos local. |
| **Control de Versiones** | **Git / GitHub** | Gestión del código fuente y documentación. |

---

## 3. Requerimientos Funcionales (RF)

A continuación se detalla la totalidad de requerimientos funcionales.
**Nota de Estado:** Se marca con **[IMPLEMENTADO]** aquellos que ya están funcionales en el Backend actual.

### 3.1 Módulo de Autenticación y Registro

| ID | Requisito | Rol | Prioridad | Estado / Notas Técnicas |
| :--- | :--- | :--- | :--- | :--- |
| **RF00.1** | **Autenticación:** El sistema debe permitir iniciar sesión ingresando credenciales válidas. | Todos | Alta | **[IMPLEMENTADO]** Endpoint `/auth/login` con JWT. |
| **RF00.2** | **Registro de cuenta:** El sistema debe permitir a los usuarios crear una cuenta proporcionando datos personales y rol. | Todos | Alta | **[IMPLEMENTADO]** Endpoint `/auth/registro-jugador`. Incluye cálculo automático de categoría. |
| **RF00.3** | **Recuperar contraseña:** Permitir recuperar el acceso mediante "¿Olvidaste tu contraseña?". | Todos | Alta | Pendiente. |

### 3.2 Gestión de Usuarios (Administrador)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF01.1** | **Crear usuarios:** El administrador puede crear usuarios (entrenadores/deportistas) y definir roles. | Admin | Alta | **[IMPLEMENTADO]** Roles definidos en BD. |
| **RF01.2** | **Editar usuarios:** Actualizar datos personales y credenciales. | Admin | Alta | Pendiente. |
| **RF01.3** | **Activar/Desactivar:** Controlar accesos temporales sin eliminar la cuenta. | Admin | Media | Pendiente. |
| **RF01.4** | **Buscar usuarios:** Filtros por nombre, rol, estado. | Admin | Media | Pendiente. |
| **RF01.5** | **Exportar listados:** Generar CSV con fines de auditoría. | Admin | Baja | Pendiente. |
| **RF01.6** | **Eliminar usuarios:** Eliminar inactivos (depuración). | Admin | Media | Pendiente. |

### 3.3 Gestión de Equipos y Categorías

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF02.1** | **Crear categorías/equipos:** Organizar jugadores según edad/nivel (ej. sub-8). | Admin | Alta | **[PARCIAL]** Lógica de asignación automática por edad implementada en el registro. |
| **RF02.2** | **Editar categorías:** Reflejar cambios organizativos. | Admin | Media | Pendiente. |
| **RF02.3** | **Asignar jugadores:** Vincular jugadores y entrenadores a equipos. | Admin | Alta | Pendiente. |
| **RF02.4** | **Eliminar categorías:** Borrar equipos inactivos. | Admin | Media | Pendiente. |

### 3.4 Gestión de Entrenamientos (Administrador)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF03.1** | **Crear plantillas:** Bases para sesiones de entrenamiento. | Admin | Alta | Pendiente. |
| **RF03.2** | **Asignar horarios:** Optimizar uso de canchas y recursos. | Admin | Alta | Pendiente. |
| **RF03.3** | **Editar plantillas:** Modificar disponibilidad o ejercicios. | Admin | Media | Pendiente. |
| **RF03.4** | **Eliminar plantillas:** Borrar datos obsoletos. | Admin | Media | Pendiente. |
| **RF03.5** | **Buscar entrenamientos:** Filtros por fecha, categoría o equipo. | Admin | Baja | Pendiente. |

### 3.5 Gestión de Competiciones y Torneos

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF04.1** | **Registrar torneos:** Estructurar calendarios y partidos. | Admin | Alta | Pendiente. |
| **RF04.2** | **Editar torneos:** Ajustar fechas o participantes. | Admin | Media | Pendiente. |
| **RF04.3** | **Eliminar torneos:** Depurar torneos cancelados. | Admin | Media | Pendiente. |
| **RF04.4** | **Cargar resultados:** Posiciones, estadísticas y seguimiento. | Admin | Alta | Pendiente. |

### 3.6 Gestión Académica / Deportiva

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF05.1** | **Registrar asistencias:** Control de asistencia de entrenadores y deportistas. | Admin | Alta | Pendiente. |
| **RF05.2** | **Evaluaciones:** Crear métricas de desempeño técnicas y físicas. | Admin | Alta | Pendiente. |
| **RF05.3** | **Consultar registros:** Ver asistencias y evaluaciones por jugador. | Admin | Alta | Pendiente. |
| **RF05.4** | **Editar/Eliminar registros:** Corrección de errores en evaluaciones. | Admin | Media | Pendiente. |
| **RF05.5** | **Buscar registros:** Facilitar la gestión de datos específicos. | Admin | Media | Pendiente. |

### 3.7 Gestión Administrativa / Financiera

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF06.1** | **Registrar pagos:** Mensualidades, inscripciones, uniformes. | Admin | Alta | Pendiente. |
| **RF06.2** | **Editar estados de pago:** Cambiar entre pendiente/pagado. | Admin | Alta | Pendiente. |
| **RF06.3** | **Eliminar pagos:** Borrar registros duplicados o erróneos. | Admin | Media | Pendiente. |
| **RF06.4** | **Consultar facturas:** Asegurar trazabilidad financiera. | Admin | Alta | Pendiente. |
| **RF06.5** | **Reportes financieros:** Generar reportes para control administrativo. | Admin | Alta | Pendiente. |

### 3.8 Reportes y Estadísticas

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF07.1** | **Generar reportes:** Deportivos, administrativos y financieros. | Admin | Alta | Pendiente. |
| **RF07.2** | **Filtrar reportes:** Por fecha, usuario o entidad. | Admin | Media | Pendiente. |
| **RF07.3** | **Exportar reportes:** Formatos PDF o CSV. | Admin | Media | Pendiente. |

### 3.9 Gestión de Entrenamientos (Entrenador)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF08.1** | **Planes de entrenamiento:** Crear planes específicos para su equipo. | Entrenador | Alta | Pendiente. |
| **RF08.2** | **Asignar entrenamientos:** Organizar sesiones por categoría/jugador. | Entrenador | Alta | Pendiente. |
| **RF08.3** | **Registrar asistencias:** Controlar presencia de jugadores. | Entrenador | Alta | Pendiente. |

### 3.10 Gestión de Jugadores (Perfil y Rendimiento)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF09.1** | **Consultar perfiles:** Ver datos completos (posición, historial). | Entrenador | Alta | **[IMPLEMENTADO]** Estructura de datos en BD (Entidad `Jugador`). |
| **RF09.2** | **Registrar observaciones:** Notas técnicas y tácticas. | Entrenador | Media | Pendiente. |
| **RF09.3** | **Calificar rendimiento:** Asignar puntajes actualizables. | Entrenador | Alta | Pendiente. |

### 3.11 Gestión de Partidos y Comunicación (Entrenador)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF10.1** | **Crear convocatorias:** Notificar a jugadores seleccionados. | Entrenador | Alta | Pendiente. |
| **RF10.2** | **Alineaciones:** Definir estrategias pre-partido. | Entrenador | Media | Pendiente. |
| **RF10.3** | **Registrar resultados:** Estadísticas post-partido. | Entrenador | Alta | Pendiente. |
| **RF11.1** | **Enviar notificaciones:** Mensajes a jugadores. | Entrenador | Alta | Pendiente. |
| **RF11.2** | **Recibir mensajes:** Confirmaciones de jugadores. | Entrenador | Media | Pendiente. |
| **RF12.1** | **Reportes individuales:** Progreso por jugador. | Entrenador | Media | Pendiente. |
| **RF12.2** | **Reportes grupales:** Métricas del equipo. | Entrenador | Alta | Pendiente. |

### 3.12 Módulo del Jugador (Deportista)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF13.1** | **Consultar perfil:** Ver categoría, posición y estadísticas propias. | Jugador | Media | **[IMPLEMENTADO]** Backend listo para consulta. |
| **RF13.2** | **Actualizar datos:** Modificar datos no sensibles. | Jugador | Alta | Pendiente. |
| **RF14.1** | **Consultar calendario:** Ver entrenamientos programados. | Jugador | Alta | Pendiente. |
| **RF14.2** | **Consultar partidos:** Ver convocatorias y fechas. | Jugador | Media | Pendiente. |
| **RF14.3** | **Ver resultados:** Consultar marcadores pasados. | Jugador | Alta | Pendiente. |
| **RF15.1** | **Ver observaciones:** Leer feedback del entrenador. | Jugador | Alta | Pendiente. |
| **RF15.2** | **Ver estadísticas:** Consultar desempeño (goles, asistencias). | Jugador | Alta | Pendiente. |
| **RF16.1** | **Recibir mensajes:** De entrenadores o admin. | Jugador | Alta | Pendiente. |
| **RF16.2** | **Notificaciones:** Alertas de eventos importantes. | Jugador | Alta | Pendiente. |
| **RF17.1** | **Cerrar sesión:** Salida segura del sistema. | Todos | Alta | **[IMPLEMENTADO]** (Cliente descarta el Token). |

---

## 4. Requerimientos No Funcionales (RNF)

Requisitos de calidad técnica actualizados a la arquitectura Java Spring Boot.

| ID | Categoría | Descripción | Prioridad | Implementación Actual |
| :--- | :--- | :--- | :--- | :--- |
| **RNF01** | **Seguridad** | Autenticación mediante credenciales únicas y **JWT**. Control de acceso por roles (Spring Security). | Alta | **[DONE]** JWT HS256 implementado. |
| **RNF02** | **Seguridad** | Cifrado de contraseñas (BCrypt) y comunicación HTTPS. | Alta | **[DONE]** BCrypt activo. |
| **RNF03** | **Seguridad** | Acceso a datos sensibles restringido por roles. Auditoría de acciones. | Alta | En desarrollo (Filtros). |
| **RNF04** | **Usabilidad** | Completar tareas principales en máx. 3 clics. | Media | Responsabilidad Frontend. |
| **RNF05** | **Usabilidad** | Diseño Responsive (Móvil y Escritorio). | Alta | Responsabilidad Frontend. |
| **RNF06** | **Usabilidad** | Notificaciones visibles y claras. | Media | Pendiente. |
| **RNF07** | **Rendimiento** | Respuestas de API < 2 segundos. | Alta | **[DONE]** API REST optimizada. |
| **RNF08** | **Rendimiento** | Soporte para 500 usuarios concurrentes. | Alta | Backend escalable (Stateless). |
| **RNF09** | **Escalabilidad** | Arquitectura modular para ampliar capacidad. | Media | **[DONE]** Arquitectura Hexagonal/Capas. |
| **RNF10** | **Mantenibilidad** | Código estructurado, documentado y con pruebas. | Alta | **[DONE]** Código limpio Java. |
| **RNF11** | **Disponibilidad** | Garantía del 99.5% uptime. | Alta | Depende de despliegue (Cloud). |
| **RNF12** | **Compatibilidad** | Navegadores modernos (Chrome, Firefox, Edge). | Media | Web Standard. |
| **RNF13** | **Compatibilidad** | Sistemas móviles (Android/iOS). | Alta | API agnóstica lista para móvil. |

---

## 5. Matriz de Riesgos y Mitigación

Análisis de riesgos actualizado con las medidas de mitigación técnicas implementadas.

| ID | Riesgo | Descripción | Impacto | Mitigación Implementada / Propuesta |
| :--- | :--- | :--- | :--- | :--- |
| **R1** | **Fuga de datos** | Pérdida o acceso no autorizado a datos sensibles (menores/médicos). | Alto | **Uso de JWT y Spring Security (Deny All por defecto).** Encriptación de passwords. |
| **R2** | **Fallos del sistema** | Caídas durante eventos en vivo o alto tráfico. | Alto | Pruebas de carga y despliegue en contenedores (Docker) para reinicio rápido. |
| **R3** | **Uso no autorizado** | Usuarios externos accediendo a funciones administrativas. | Alto | **Filtros de Seguridad (JwtAuthenticationFilter)** que validan el ROL antes de cada petición. |
| **R4** | **Baja adopción** | Resistencia al cambio por parte de usuarios. | Alto | Diseño de interfaz intuitiva (Fase Frontend). |
| **R5** | **Retrasos desarrollo** | Tiempos extendidos en construcción. | Alto | Desarrollo ágil e iterativo (Backend Core ya funcional). |
| **R6** | **Incompatibilidad móvil** | Fallos en dispositivos antiguos. | Medio | API REST estándar compatible con cualquier cliente HTTP. |
| **R7** | **Inexactitud de datos** | Datos mal registrados o calculados. | Medio | **Validaciones (@Valid, @NotNull)** en el Backend antes de guardar en BD. |
| **R8** | **Falta de Internet** | Usuarios sin conexión en zonas remotas. | Medio | Considerar PWA o caché local en el Frontend. |
| **R9** | **Normativa Legal** | Incumplimiento de Habeas Data / GDPR. | Medio | Términos y condiciones en registro y derecho al olvido (Eliminación de cuenta). |
| **R10** | **Saturación** | Cuellos de botella en horas pico. | Alto | Base de datos optimizada y paginación en consultas grandes. |

---

## 6. Conclusiones y Estado del Proyecto
El sistema ha superado la fase de análisis y diseño inicial. Actualmente se encuentra en la **Fase de Desarrollo Backend**, habiendo completado exitosamente:
1.  Modelo de Base de Datos Relacional.
2.  Sistema de Registro con lógica de negocio (Categorización automática).
3.  Sistema de Seguridad Profesional (JWT + BCrypt).

**Siguientes Pasos:**
* Implementar Filtros de Seguridad (Middleware).
* Desarrollar controladores para Gestión de Entrenamientos y Partidos.
* Iniciar desarrollo del Cliente Frontend.

---
