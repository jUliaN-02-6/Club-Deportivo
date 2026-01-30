# ANÁLISIS Y ESPECIFICACIÓN DEL SISTEMA - SPORTBYME

| Metadato | Detalle |
| :--- | :--- |
| **Proyecto** | SportByMe |
| **Versión del Documento** | 1.1 (Actualizado - Fase Backend Implementation) |
| **Fecha de Actualización** | Enero 2026 |
| **Responsables** | Julián Falla, Julián Garzón, Luisa López |
| **Estado Actual** | En Desarrollo (Backend Core & Auth) |

---

## 1. Datos Generales del Proyecto
* **Nombre del Proyecto:** SportByMe
* **Objetivo:** Evaluar el sistema actual, identificar limitaciones y proponer una solución tecnológica para llevar un historial de deportistas y analizar su evolución.

---

## 2. Objetivo del Análisis
El objetivo de este análisis es evaluar el sistema actual de SportByMe, identificar sus limitaciones y proponer mejoras, esto con el fin de llevar un historial de los deportistas y analizar su evolución deportiva.

### 2.1 Fuentes Consultadas
* Entrevistas con usuarios clave.
* Cuestionarios.

---

## 3. Requerimientos Funcionales (RF)

A continuación se detalla la totalidad de requerimientos funcionales.
**Nota de Estado:** Se marca con **[IMPLEMENTADO]** aquellos que ya están funcionales en el Backend actual.

### 3.1 Módulo de Autenticación (RF00)

| ID | Requisito | Rol | Prioridad | Estado / Notas Técnicas |
| :--- | :--- | :--- | :--- | :--- |
| **RF00.1** | **Autenticación:** El sistema debe permitir iniciar sesión ingresando credenciales válidas. | Todos | Alta | **[IMPLEMENTADO]** Endpoint `/auth/login` con JWT. |
| **RF00.2** | **Registro de cuenta:** El sistema debe permitir a los usuarios crear una cuenta proporcionando datos personales y rol. | Todos | Alta | **[IMPLEMENTADO]** Endpoint `/auth/registro-jugador`. Incluye cálculo automático de categoría basado en la edad. |
| **RF00.3** | **Recuperar contraseña:** Permitir recuperar el acceso mediante "¿Olvidaste tu contraseña?". | Todos | Alta | Pendiente. |

### 3.2 Gestión de Usuarios - Admin (RF01)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF01.1** | **Crear usuarios:** El administrador puede crear usuarios y definir roles. | Admin | Alta | **[IMPLEMENTADO]** Roles definidos en BD. |
| **RF01.2** | **Editar usuarios:** Actualizar datos personales y credenciales. | Admin | Alta | Pendiente. |
| **RF01.3** | **Activar/Desactivar:** Controlar accesos temporales. | Admin | Media | Pendiente. |
| **RF01.4** | **Buscar usuarios:** Filtros por nombre, rol, estado. | Admin | Media | Pendiente. |
| **RF01.5** | **Exportar listados:** Generar CSV con fines de auditoría. | Admin | Baja | Pendiente. |
| **RF01.6** | **Eliminar usuarios:** Eliminar inactivos (depuración). | Admin | Media | Pendiente. |

### 3.3 Gestión de Equipos y Categorías (RF02)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF02.1** | **Crear categorías/equipos:** Organizar jugadores según edad/nivel (ej. sub-8). | Admin | Alta | **[PARCIAL]** Lógica de asignación automática por edad implementada en el registro. |
| **RF02.2** | **Editar categorías:** Reflejar cambios organizativos. | Admin | Media | Pendiente. |
| **RF02.3** | **Asignar jugadores:** Vincular jugadores y entrenadores a equipos. | Admin | Alta | Pendiente. |
| **RF02.4** | **Eliminar categorías:** Borrar equipos inactivos. | Admin | Media | Pendiente. |

### 3.4 Gestión de Entrenamientos - Admin (RF03)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF03.1** | **Crear plantillas:** Bases para sesiones de entrenamiento. | Admin | Alta | Pendiente. |
| **RF03.2** | **Asignar horarios:** Optimizar uso de canchas y recursos. | Admin | Alta | Pendiente. |
| **RF03.3** | **Editar plantillas:** Modificar disponibilidad o ejercicios. | Admin | Media | Pendiente. |
| **RF03.4** | **Eliminar plantillas:** Borrar datos obsoletos. | Admin | Media | Pendiente. |
| **RF03.5** | **Buscar entrenamientos:** Filtros por fecha, categoría o equipo. | Admin | Baja | Pendiente. |

### 3.5 Gestión de Competiciones y Torneos (RF04)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF04.1** | **Registrar torneos:** Estructurar calendarios y partidos. | Admin | Alta | Pendiente. |
| **RF04.2** | **Editar torneos:** Ajustar fechas o participantes. | Admin | Media | Pendiente. |
| **RF04.3** | **Eliminar torneos:** Depurar torneos cancelados. | Admin | Media | Pendiente. |
| **RF04.4** | **Cargar resultados:** Posiciones, estadísticas y seguimiento. | Admin | Alta | Pendiente. |

### 3.6 Gestión Académica / Deportiva (RF05)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF05.1** | **Registrar asistencias:** Control de asistencia. | Admin | Alta | Pendiente. |
| **RF05.2** | **Evaluaciones:** Crear métricas de desempeño técnicas y físicas. | Admin | Alta | Pendiente. |
| **RF05.3** | **Consultar registros:** Ver asistencias y evaluaciones. | Admin | Alta | Pendiente. |
| **RF05.4** | **Editar/Eliminar registros:** Corrección de errores. | Admin | Media | Pendiente. |
| **RF05.5** | **Buscar registros:** Facilitar la gestión de datos. | Admin | Media | Pendiente. |

### 3.7 Gestión Administrativa / Financiera (RF06)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF06.1** | **Registrar pagos:** Mensualidades, inscripciones, uniformes. | Admin | Alta | Pendiente. |
| **RF06.2** | **Editar estados de pago:** Cambiar entre pendiente/pagado. | Admin | Alta | Pendiente. |
| **RF06.3** | **Eliminar pagos:** Borrar registros duplicados o erróneos. | Admin | Media | Pendiente. |
| **RF06.4** | **Consultar facturas:** Asegurar trazabilidad financiera. | Admin | Alta | Pendiente. |
| **RF06.5** | **Reportes financieros:** Generar reportes para control. | Admin | Alta | Pendiente. |

### 3.8 Reportes y Estadísticas (RF07)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF07.1** | **Generar reportes:** Deportivos, administrativos y financieros. | Admin | Alta | Pendiente. |
| **RF07.2** | **Filtrar reportes:** Por fecha, usuario o entidad. | Admin | Media | Pendiente. |
| **RF07.3** | **Exportar reportes:** Formatos PDF o CSV. | Admin | Media | Pendiente. |

### 3.9 Gestión de Entrenamientos - Entrenador (RF08)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF08.1** | **Planes de entrenamiento:** Crear planes específicos. | Entrenador | Alta | Pendiente. |
| **RF08.2** | **Asignar entrenamientos:** Organizar sesiones. | Entrenador | Alta | Pendiente. |
| **RF08.3** | **Registrar asistencias:** Controlar presencia de jugadores. | Entrenador | Alta | Pendiente. |

### 3.10 Gestión de Jugadores (RF09)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF09.1** | **Consultar perfiles:** Ver datos completos (posición, historial). | Entrenador | Alta | **[IMPLEMENTADO]** Estructura de datos en BD (Entidad `Jugador`). |
| **RF09.2** | **Registrar observaciones:** Notas técnicas y tácticas. | Entrenador | Media | Pendiente. |
| **RF09.3** | **Calificar rendimiento:** Asignar puntajes actualizables. | Entrenador | Alta | Pendiente. |

### 3.11 Gestión de Partidos (RF10 - RF12)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF10.1** | **Crear convocatorias:** Notificar a jugadores. | Entrenador | Alta | Pendiente. |
| **RF10.2** | **Alineaciones:** Definir estrategias pre-partido. | Entrenador | Media | Pendiente. |
| **RF10.3** | **Registrar resultados:** Estadísticas post-partido. | Entrenador | Alta | Pendiente. |
| **RF11.1** | **Enviar notificaciones:** Mensajes a jugadores. | Entrenador | Alta | Pendiente. |
| **RF11.2** | **Recibir mensajes:** Confirmaciones de jugadores. | Entrenador | Media | Pendiente. |
| **RF12.1** | **Reportes individuales:** Progreso por jugador. | Entrenador | Media | Pendiente. |
| **RF12.2** | **Reportes grupales:** Métricas del equipo. | Entrenador | Alta | Pendiente. |

### 3.12 Módulo del Jugador (RF13 - RF17)

| ID | Requisito | Rol | Prioridad | Estado |
| :--- | :--- | :--- | :--- | :--- |
| **RF13.1** | **Consultar perfil:** Ver categoría, posición y estadísticas. | Jugador | Media | **[IMPLEMENTADO]** Backend listo para consulta. |
| **RF13.2** | **Actualizar datos:** Modificar datos no sensibles. | Jugador | Alta | Pendiente. |
| **RF14.1** | **Consultar calendario:** Ver entrenamientos. | Jugador | Alta | Pendiente. |
| **RF14.2** | **Consultar partidos:** Ver convocatorias y fechas. | Jugador | Media | Pendiente. |
| **RF14.3** | **Ver resultados:** Consultar marcadores pasados. | Jugador | Alta | Pendiente. |
| **RF15.1** | **Ver observaciones:** Leer feedback del entrenador. | Jugador | Alta | Pendiente. |
| **RF15.2** | **Ver estadísticas:** Consultar desempeño. | Jugador | Alta | Pendiente. |
| **RF16.1** | **Recibir mensajes:** De entrenadores o admin. | Jugador | Alta | Pendiente. |
| **RF16.2** | **Notificaciones:** Alertas de eventos importantes. | Jugador | Alta | Pendiente. |
| **RF17.1** | **Cerrar sesión:** Salida segura del sistema. | Todos | Alta | **[IMPLEMENTADO]** (Cliente descarta el Token). |

---

## 4. Requerimientos No Funcionales (RNF)

| ID | Categoría | Descripción | Prioridad | Implementación Actual |
| :--- | :--- | :--- | :--- | :--- |
| **RNF01** | **Seguridad** | Autenticación mediante **JWT**. Control por roles. | Alta | **[DONE]** JWT HS256 implementado. |
| **RNF02** | **Seguridad** | Cifrado de contraseñas (BCrypt) y HTTPS. | Alta | **[DONE]** BCrypt activo. |
| **RNF03** | **Seguridad** | Acceso restringido por permisos. | Alta | En desarrollo (Filtros). |
| **RNF04** | **Usabilidad** | Tareas en máx. 3 clics. | Media | Frontend. |
| **RNF05** | **Usabilidad** | Responsive (Móvil/Web). | Alta | Frontend. |
| **RNF06** | **Usabilidad** | Notificaciones visibles. | Media | Pendiente. |
| **RNF07** | **Rendimiento** | Respuestas API < 2 seg. | Alta | **[DONE]** API optimizada. |
| **RNF08** | **Rendimiento** | Soporte 500 usuarios. | Alta | Backend Stateless. |
| **RNF09** | **Escalabilidad** | Arquitectura modular. | Media | **[DONE]** Arq. Hexagonal. |
| **RNF10** | **Mantenibilidad** | Código documentado. | Alta | **[DONE]** Java limpio. |
| **RNF11** | **Disponibilidad** | 99.5% uptime. | Alta | Infraestructura Cloud. |
| **RNF12** | **Compatibilidad** | Navegadores web. | Media | Web Standard. |
| **RNF13** | **Compatibilidad** | Android/iOS. | Alta | API lista. |

---

## 5. Análisis del Entorno Actual

### 5.1 Infraestructura Tecnológica Propuesta
Se actualiza la infraestructura original para coincidir con el desarrollo actual.

| Componente | Tecnología | Descripción / Justificación |
| :--- | :--- | :--- |
| **Lenguajes** | **Java 17**, HTML, CSS, JS | Java para Backend robusto (Spring Boot). JS/HTML para Frontend. |
| **Base de Datos** | **MySQL / MariaDB** | Gestión relacional de datos estructurados. |
| **Framework** | **Spring Boot 3** | Framework empresarial para lógica de negocio y seguridad (Security/JWT). |
| **IDE** | **IntelliJ IDEA** | Entorno de desarrollo integrado profesional. |
| **Servidor Local** | **XAMPP** | Utilizado para levantar el servicio de Base de Datos MySQL. |
| **Control Versiones** | **GitHub** | Gestión de versiones y trabajo colaborativo. |
| **Modelado** | **Draw.io** | Diseño de diagramas UML y ER. |

### 5.2 Identificación de Problemas
Razones fundamentales por las que se desarrolla el sistema.

| Problema | Descripción Detallada | Impacto en la Operación |
| :--- | :--- | :--- |
| **1. Gestión manual** | Uso de hojas de cálculo o papel para gestionar jugadores, pagos y lesiones. | Riesgo de pérdida de datos y errores humanos. |
| **2. Comunicación ineficiente** | La comunicación se realiza por WhatsApp o verbalmente. | Desinformación y falta de trazabilidad. |
| **3. Falta de trazabilidad** | No hay plataforma centralizada para el seguimiento del desempeño. | Evaluaciones subjetivas. |
| **4. Seguimiento médico** | Lesiones y restricciones no se registran formalmente. | Riesgo para la salud del deportista. |
| **5. Pagos desorganizados** | Administración manual de mensualidades. | Morosidad y confusión en cuentas. |
| **6. Falta de reportes** | No se generan estadísticas automatizadas. | Dificultad para la toma de decisiones. |
| **7. Falta de roles** | Todos acceden a la información sin restricciones claras. | Exposición de datos sensibles. |
| **8. Calendario disperso** | Torneos y partidos se comunican de forma desorganizada. | Ausencias y mala planificación. |
| **9. Falta de motivación** | El deportista menor de edad no ve su progreso. | Bajo compromiso con su proceso. |

---

## 6. Modelo del Sistema Propuesto

### 6.1 Descripción General
SportByMe es una plataforma digital integral diseñada para centralizar y automatizar los procesos de un club deportivo. Facilita la interacción entre administradores, entrenadores y deportistas. A través de un sistema de roles y permisos, cada usuario tendrá acceso únicamente a la información relevante para su perfil.

**Objetivos del Sistema:**
1.  Digitalizar la gestión del club.
2.  Centralizar información médica, deportiva y financiera.
3.  Mejorar comunicación entrenador-jugador.
4.  Facilitar toma de decisiones con reportes.
5.  Aumentar trazabilidad del rendimiento.
6.  Brindar autonomía a usuarios.

### 6.2 Módulos del Sistema

| Módulo | Descripción | Usuarios |
| :--- | :--- | :--- |
| **1. Gestión de Usuarios** | Admin de cuentas, roles y credenciales. | Admin |
| **2. Gestión de Equipos** | Creación de categorías y asignación de jugadores. | Admin |
| **3. Entrenamientos (Admin)** | Plantillas, horarios y canchas. | Admin |
| **4. Torneos** | Gestión de competiciones y resultados. | Admin |
| **5. Académica/Deportiva** | Asistencias y evaluaciones. | Admin |
| **6. Financiera** | Pagos y facturas. | Admin |
| **7. Reportes** | Estadísticas generales. | Admin |
| **8. Entrenamientos (Entr)** | Planes y asistencias de su equipo. | Entrenador |
| **9. Jugadores (Perfil)** | Consultas técnicas y calificaciones. | Entrenador |
| **10. Partidos** | Convocatorias y estrategias. | Entrenador |
| **11. Comunicación** | Mensajería interna. | Entrenador |
| **12. Reportes Rendimiento** | Progreso individual y grupal. | Entrenador |
| **13. Perfil Personal** | Consulta de datos propios. | Jugador |
| **14. Consulta Calendario** | Ver entrenamientos y partidos. | Jugador |
| **15. Seguimiento** | Ver calificaciones y stats. | Jugador |
| **16. Notificaciones** | Alertas de eventos. | Jugador |

---

## 7. Cumplimiento de Normas y Protocolos

| Norma | Aplicación en el Proyecto |
| :--- | :--- |
| **Ley 1581 (Datos Personales)** | Tratamiento seguro de datos, especialmente menores de edad. |
| **Habeas Data Deportivo** | Derechos de acceso, actualización y eliminación de datos. |
| **GDPR (Ref)** | Principios de consentimiento informado y minimización de datos. |
| **Historia Clínica Digital** | Confidencialidad en datos de lesiones (EPS, RH). |
| **ISO/IEC 27001** | Cifrado de contraseñas y control de acceso. |
| **OWASP Top 10** | Prevención de Inyección SQL y XSS (Spring Security). |
| **Accesibilidad (WCAG)** | Interfaz amigable (Frontend). |

---

## 8. Riesgos Identificados

| ID | Riesgo | Nivel | Mitigación Implementada / Propuesta |
| :--- | :--- | :--- | :--- |
| **R1** | **Fuga de datos** | Alto | **[DONE]** Cifrado, JWT y Backups. |
| **R2** | **Fallos del sistema** | Alto | Pruebas de carga y monitoreo. |
| **R3** | **Uso no autorizado** | Alto | **[DONE]** Autenticación robusta y roles. |
| **R4** | **Baja adopción** | Alto | Interfaz amigable y capacitación. |
| **R5** | **Retrasos desarrollo** | Alto | Gestión ágil e iterativa. |
| **R6** | **Incompatibilidad móvil** | Medio | Pruebas en dispositivos reales. |
| **R7** | **Inexactitud de datos** | Medio | **[DONE]** Validaciones en Backend. |
| **R8** | **Falta de Internet** | Medio | Almacenamiento local temporal (App). |
| **R9** | **Incumplimiento legal** | Medio | Validación de políticas de datos. |
| **R10** | **Saturación** | Alto | Infraestructura escalable. |

---

## 9. Conclusiones y Recomendaciones

**Conclusiones:**
1.  **Necesidad de digitalización:** Urgente para evitar errores y pérdida de datos.
2.  **Valor de centralización:** Integra procesos administrativos y deportivos en una sola plataforma.
3.  **Seguridad:** El uso de JWT y encriptación cumple con los estándares necesarios para proteger datos de menores.

**Recomendaciones:**
1.  Priorizar la experiencia de usuario (UX) en la fase de Frontend.
2.  Mantener la arquitectura modular para facilitar el mantenimiento.
3.  Implementar backups automáticos de la base de datos MySQL.
4.  Continuar con el desarrollo de los módulos de "Entrenamientos" y "Partidos".

---
