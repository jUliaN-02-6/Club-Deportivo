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

### 4.5 Comunicacion y Privacidad
* **BR17 (Restricciones y Permisos de Chat):** El sistema debe restringir el envío de mensajes directos según el rol del usuario, aplicando la siguiente matriz de permisos:

Administrador: Puede enviar mensajes a cualquier usuario del sistema (Entrenadores, Deportistas, Acudientes).

Entrenador: Solo puede enviar mensajes a los Administradores, a los Acudientes de sus equipos asignados, y a los Deportistas de sus equipos (Si el deportista es menor de edad, el sistema debe enviar automáticamente una copia del mensaje a su Acudiente vinculado).

Acudiente: Solo puede enviar mensajes a la Administración y a los Entrenadores de los equipos donde estén sus hijos. (No puede contactar a otros niños).

Deportista: Solo puede enviar mensajes a la Administración y a sus Entrenadores actuales.

---

## 5. Requerimientos Funcionales (Detallados)

### [cite_start]5.1 Módulo de Autenticación (RF00) [cite: 14, 15]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF00.1** | **Autenticación:** (Iniciar sesión) Acceder al sistema (Incluye validacion con credenciales JWT. Incluye opciones de bloquear cuenta tras 3 fallos y recuperar contraseña) . | BR02 | **[IMPLEMENTADO]** |
| **RF00.2** | **Registro:** (Crear cuenta) Crear usuario nuevo. (incluye validacion de datos unicos y calculo de categorias. Incluye opcion de buscar y vincular jugador si el rol es Acudiente). | BR01, BR03, BR04 | **[IMPLEMENTADO]** |
| **RF00.3** | **Recuperación:** Restablecer contraseña vía "¿Olvidaste tu contraseña?". | BR02 | Pendiente |

### [cite_start]5.2 Gestión de Usuarios - Admin (RF01) [cite: 15, 16, 17]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF01.1** | **Crear Usuarios:** Crear entrenadores, deportistas y acudientes (Incluye validacion de unicidad y calculo de categoria. Incluye opcion de vincular acudiente si es menor de 18 años). | BR01, BR03 | **[IMPLEMENTADO]** |
| **RF01.2** | **Editar Usuarios:** Extiende del RF01.4. Actualizar datos personales y credenciales (Incluye validacion de unicidad y recalculo de categoria). | BR01, BR04 | Pendiente |
| **RF01.3** | **Activar/Desactivar:** Extiende del RF01.4. Controlar accesos sin eliminar cuenta. | - | Pendiente |
| **RF01.4** | **Buscar Usuarios:** Filtros por nombre, rol y estado (Incluye opcion de exportar el listado a CSV). | - | Pendiente |
| **RF01.5** | **Exportar:** Extiende del RF01.4. Descargar listados (Incluye opcion de Excel/CSV para manejo y auditoria de datos, o PDF para reportes oficiales de impresion). | - | Pendiente |
| **RF01.6** | **Eliminar:** Extiende del RF01.4. Borrar usuarios inactivos (depuración). | - | Pendiente |

### [cite_start]5.3 Gestión de Equipos y Categorías (RF02) [cite: 17, 18]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF02.1** | **Crear Categorías:** Definir grupos (ej. Sub-8, Sub-12). | - | **[PARCIAL]** (Lógica auto) |
| **RF02.2** | **Consultar Categorias:** Ver el listado de equipos y su plantilla actual | - | Pendiente | 
| **RF02.3** | **Editar/Eliminar Categorías:** Reflejar cambios organizativos o borrar equipos inactivos (Extensiones directas de RF02.2. Editar incluye la opcion de desvincular miembros). | - | Pendiente |
| **RF02.4** | **Asignar Miembros:** Vincular jugadores y entrenadores a equipos (Extenciones de RF2.2. Incluye validacion obligatoria de edad, cupo y dorsal). | BR04, BR05, BR06 (Dorsales) | Pendiente |

### [cite_start]5.4 Gestión de Entrenamientos - Admin (RF03) [cite: 18, 19, 20]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF03.1** | **Crear Plantillas:** Bases para sesiones de entrenamiento. | - | Pendiente |
| **RF03.2** | **Asignar Horarios:** Optimizar uso de canchas/recursos. (Incluye validacion obligatoria de disponibilidad de canchas) | - | Pendiente |
| **RF03.3** | **Editar Plantillas:** Modificar disponibilidad. | - | Pendiente |
| **RF03.4** | **Eliminar Plantillas:** Borrar datos obsoletos. | - | Pendiente |
| **RF03.5** | **Buscar Entrenamientos:** Ver listado de sesiones de entrenamientos (Incluye opcion de aplicar filtros por fecha, categoría o equipo). | - | Pendiente |

### [cite_start]5.5 Gestión de Competiciones (RF04) [cite: 20, 21]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF04.1** | **Registrar Torneos:** Estructurar calendarios y partidos. | - | Pendiente |
| **RF04.2** | **Consultar Torneos:** Ver el listado de competiciones activas e inactivas. | - | Pendiente |
| **RF04.3** | **Editar/Eliminar Torneos:** Ajustar fechas, participantes o depurar cancelados. (Extensiones de RF04.2. Editar incluye opcion de reprogramar partidos o modificar participantes). | - | Pendiente |
| **RF04.4** | **Cargar Resultados:** Registrar marcadores, posiciones y estadísticas (Incluye validacion obligatoria del marcador y verificaion de acumulacion de tarjetas). | BR08, BR09 | Pendiente |

### [cite_start]5.6 Gestión Académica/Deportiva (RF05) [cite: 21, 22]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF05.1** | **Registrar Asistencias:** Control de presencia (Admin, Entrenador) (Incluye validacion  obligatoria del estado financiero) (Admin, Entrenador). | BR13 | Pendiente |
| **RF05.2** | **Registrar Evaluaciones:** Crear métricas de desempeño técnicas/físicas (Entrenador, Admin) (Incluye calculo automatico de IMC y generacion de alerta). | BR11 | Pendiente |
| **RF05.3** | **Consultar Registros:** Ver historial de asistencias/evaluaciones y localizar jugadores o equipos (Admin, Entrenador) (Incluye opcion de aplicar filtros de busqueda). | - | Pendiente |
| **RF05.4** | **Editar Registros:** Corrección de errores en evaluaciones (Admin, Entrenador) (Extension de RF05.3. Incluye recalculo obligatorio de IMC y alerta). | - | Pendiente |

### [cite_start]5.7 Gestión Financiera (RF06) [cite: 23, 24]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF06.1** | **Registrar Pagos:** Mensualidades, inscripciones, uniformes (Incluye generacion de factura y actualizacion del estado de bloqueo). | BR14 | Pendiente |
| **RF06.2** | **Editar/Eliminar Pagos:** Cambiar estado (Pendiente/Pagado) o borrar registros erroneos. (Extensiones de RF06.3. Editar incluye actualizacion del estado de bloqueo) | BR14 | Pendiente |
| **RF06.3** | **Consultar Pagos/Facturas:** Trazabilidad de cobros generados (Incluye opcion de aplicar filtros de busqueda por fechas/acudiente y la opcion de generar/descargar el comprobante de pago). | - | Pendiente |
| **RF06.4** | **Reportes Financieros:** Control de caja administrativo (Incluye opcion de exportar documento en Excel/PDF). | - | Pendiente |

### [cite_start]5.8 Reportes Generales (RF07) [cite: 24, 25]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF07.1** | **Generar Reportes:** Consolidado deportivo y financiero (Incluye opcion de aplicar filtros y exportar el documento). | - | Pendiente |
| **RF07.2** | **Filtrar Reportes:** Por fecha, usuario o entidad (Extension de RF07.1). | - | Pendiente |
| **RF07.3** | **Exportar Reportes:** Descarga en PDF o CSV (Extension de RF07.1). | - | Pendiente |

### [cite_start]5.9 Gestión Entrenador - Entrenamientos (RF08) [cite: 25]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF08.1** | **Crear Planes:** Diseñar sesiones para su equipo. | - | Pendiente |
| **RF08.2** | **Consultar Planes:** Ver el listado y detalles de los planes creados. | - | Pendiente |
| **RF08.3** | **Editar/Eliminar Planes** Modificar ejercicios o borrar planes obsoletos (Extension de RF08.2). | - | Pendiente |
| **RF08.4** | **Asignar Sesiones:** Vincular plan a categoría/jugador/equipo (Incluye opcion de notificar a jugadores o acudientes). | - | Pendiente |
| **RF08.5** | **Tomar Asistencia:** Registrar presencia en cancha (Incluye validacion obligatoria del estado financiero). | BR13 | Pendiente |

### [cite_start]5.10 Gestión Entrenador - Jugadores (RF09) [cite: 25, 26]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF09.1** | **Consultar Perfil:** Ver datos técnicos, físicos y médicos (Incluye verificacion obligatoria de alert IMC y opcion de buscar/filtrar por categoria/posicion). | BR11 (IMC) | **[IMPLEMENTADO]** |
| **RF09.2** | **Registrar Observaciones:** Notas tácticas sobre el jugador (Incluye opcion de enviar notificacion directa al acudiente). | - | Pendiente |
| **RF09.3** | **Calificar Rendimiento:** Asignar puntajes periódicos. | - | Pendiente |

### [cite_start]5.11 Gestión Entrenador - Partidos (RF10) [cite: 26, 27]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF10.1** | **Crear Convocatorias:** Seleccionar jugadores para el partido (Incluye validaciones obligatorias de reglas deportivas y opcion de notificar a jugadores/acudientes). | BR07, BR10, BR12 | Pendiente |
| **RF10.2** | **Consultar Convocatoria:** Ver el listado y detalle de convocatorias. | - | Pendiente |
| **RF10.3** | **Editar/Eliminar Convocatoria:** Modificar lista o cancelar convocatoria. (Extensiones de RF10.2. Editar incluye validaciones deportivas). | BR07, BR10, BR12 | Pendiente |
| **RF10.4** | **Definir Alineaciones:** Estrategia pre-partido. | - | Pendiente |
| **RF10.5** | **Registrar Post-Partido:** Resultados y estadísticas (Incluye validacion obligatoria de marcadores). | BR08 | Pendiente |

### [cite_start]5.12 Comunicación (RF11) [cite: 27]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF11.1** | **Consultar Mensajes:** Ver la bandeja de entrada y salida (Todos los roles). (Incluye opcion de buscar/filtrar chats) | - | Pendiente |
| **RF11.2** | **Enviar Mensajes:** Crear y enviar nuevas notificaciones. (Aplicar validacion de permisos de destinatario). | BR17 (Permisos Chat) | Pendiente |
| **RF11.3** | **Responder Mensajes:** Contestar confirmaciones de asistencias o consultas (Extension de RF11.1) . | - | Pendiente |
| **RF11.4** | **Eliminar Mensajes:** Limpiar la bandeja de entrada (Borrado logico por seguridad). (Extension de RF11.1) | - | Pendiente |

### [cite_start]5.13 Reportes de Rendimiento (RF12) [cite: 28]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF12.1** | **Consultar Reportes de Rendimiento:** Visualizar metricas fisicas, tecnicas y tacticas. (Incluye opcion de filtrar y exportar). | - | Pendiente |
| **RF12.** | **Filtrar Reportes:** Por jugador especifico (individual) o por categoria (Grupal). (Extension de RF12.1). | - | Pendiente |
| **RF12.** | **Exportar Reportes:** Descargar en PDF/Excel para entreagr a padres o directivos. (Extension  de RF12.1). | - | Pendiente |

### [cite_start]5.14 Módulo Deportista - Perfil (RF13) [cite: 28]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF13.1** | **Consultar Perfil:** Ver datos personales, fisicos (IMC) y deportivos (categoria/estado actual). | BR04, BR09 ,BR11, BR12 | **[IMPLEMENTADO]** |
| **RF13.2** | **Actualizar Datos:** Editar info de contacto no sensible (Extension de RF13.1). | - | Pendiente |
| **RF13.3** | **Cambiar Contraseña:** Actualizar credenciales de acceso. (Extensiones de RF13.1 Incluye encriptacion obligatoria). | BR02 | Pendiente |

### [cite_start]5.15 Módulo Deportista - Calendario (RF14) [cite: 29]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF14.1** | **Consultar Calendario:** Ver la agenda general del jugador. (Incluye opcion de filtrar por tipo de evento) | - | Pendiente |
| **RF14.2** | **Filtrar por Entrenamiento:** Consultar fechas y horas de practica. (Extension de RF14.1) | - | Pendiente |
| **RF14.3** | **Filtrar por Partidos:** Consultar convocatoria y resultados historicos. (Extension de RF14.1) | - | Pendiente |

### [cite_start]5.16 Módulo Deportista - Seguimiento (RF15) [cite: 29, 30]
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF15.1** | **Consultar Rendimiento:** Visualizar el progreso general del jugador. | - | Pendiente |
| **RF15.2** | **Ver Observaciones:** Leer feedback tactico y notas del entrenador. (Extension de RF15.1) | - | Pendiente |
| **RF15.3** | **Ver Estadisticas:** Consultar metriscas de goles, asistencias y estado fisico. (Extension de RF15.1) | - | Pendiente |


### 5.17 Módulo Acudiente (Nuevo - RF18)
| ID | Requisito | Reglas Asociadas | Estado Actual |
| :--- | :--- | :--- | :--- |
| **RF18.1** | **Consultar Perfil Propio:** Ver y actualizar datos de contacto del acudiente o cambiar contraseña. (Cambio de credenciales incluye encriptacion). | - | Pendiente |
| **RF18.2** | **Consultar Jugador Vinculado:** Ver el perfil del hijo, su calendario de partidos/entrenamientos y su rendimiento (Incluye validacion obligatoria de bloque administrativo). | BR03, BR14 | **[IMPLEMENTADO]** |
| **RF18.3** | **Consultar Estado de Cuenta:** Ver histotrial de pagos, deudas pendientes y descargar recibos en PDF. | BR13, BR14 | Pendiente |


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
