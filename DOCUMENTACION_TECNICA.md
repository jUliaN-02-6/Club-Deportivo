# ANÁLISIS Y ESPECIFICACIÓN DEL SISTEMA - SPORTBYME

| Metadato | Detalle |
| :--- | :--- |
| **Proyecto** | SportByMe |
| **Versión del Documento** | 2.0 (Unificado - Especificación Completa) |
| **Fecha de Actualización** | Febrero 2026 |
| **Responsables** | Julián Falla, Julián Garzón, Luisa López |
| **Estado Actual** | En Desarrollo (Backend Core & Auth) |

---

## 1. Datos Generales del Proyecto
* **Nombre del Proyecto:** SportByMe
* **Objetivo:** Evaluar el sistema actual, identificar limitaciones y proponer una solución tecnológica integral para llevar un historial de deportistas, analizar su evolución y gestionar la administración del club.

---

## 2. Descripción y Actores del Sistema
El sistema SportByMe es una plataforma integral para la gestión de clubes deportivos. Se han identificado y definido los siguientes actores en el sistema:

1.  **ADMIN (ID 2):** Tiene control total del sistema (usuarios, pagos, torneos, configuraciones).
2.  **ENTRENADOR (ID 3):** Gestiona entrenamientos, partidos, convocatorias y evalúa el rendimiento de los jugadores.
3.  **JUGADOR (ID 1):** (Deportista) Usuario final que consulta su rendimiento, estadísticas y convocatorias.
4.  **ACUDIENTE (ID 4):** Responsable legal de los jugadores menores de edad. Recibe notificaciones, gestiona pagos y supervisa el proceso del menor.

---

## 3. Reglas de Negocio (Business Rules)
Estas reglas definen la lógica inteligente del sistema. El Backend debe hacer cumplir estas restricciones automáticamente.

### 3.1 Estructura y Registro
* **BR01 (Unicidad):** No pueden existir dos usuarios con el mismo correo electrónico o número de documento.
* **BR02 (Seguridad):** Las contraseñas deben ser almacenadas de forma encriptada (Hash BCrypt).
* **BR03 (Vinculación):** Si el usuario es menor de 18 años, el sistema obliga a vincular un "Acudiente" responsable.
* **BR04 (Categorización Automática):** La categoría (Sub-15, Sub-20, etc.) se asigna automáticamente calculando la edad del jugador según su fecha de nacimiento.
* **BR05 (Cupos de Equipo):** Un equipo no puede tener más de 25 jugadores activos inscritos.
* **BR06 (Dorsales):** No pueden existir dos jugadores con el mismo número de dorsal en el mismo equipo activo.

### 3.2 Control Disciplinario y Competitivo
* **BR07 (Jugador Habilitado):** Solo se pueden convocar jugadores activos y sin lesiones vigentes.
* **BR08 (Validación de Resultado):** La suma de goles individuales debe coincidir con el marcador final del partido.
* **BR09 (Acumulación de Tarjetas):** Si un jugador acumula **3 tarjetas amarillas** en un torneo, se marca como "SUSPENDIDO" para el siguiente partido.
* **BR10 (Expulsión Directa):** Un jugador con tarjeta roja no puede ser convocado al siguiente encuentro.

### 3.3 Control Médico y Físico
* **BR11 (Alerta IMC):** El sistema calculará el Índice de Masa Corporal. Si indica sobrepeso o delgadez extrema, generará una alerta al entrenador.
* **BR12 (Restricción Post-Lesión):** Un jugador con lesión grave no puede ser convocado hasta 15 días después de su alta médica.

### 3.4 Financiero
* **BR13 (Mora):** El sistema no permite marcar asistencia a entrenamientos si el jugador tiene el estado "BLOQUEADO POR PAGO".
* **BR14 (Bloqueo Administrativo):** Si un acudiente acumula 2 meses de deuda, se bloquea su acceso a reportes y estadísticas (pero el jugador sigue activo).

---

## 4. Requerimientos Funcionales (RF)

### 4.1 Módulo de Autenticación
| ID | Requisito | Reglas Asociadas | Estado |
| :--- | :--- | :--- | :--- |
| **RF00.1** | **Autenticación:** Iniciar sesión con credenciales válidas y obtener JWT. | BR02 | **[IMPLEMENTADO]** |
| **RF00.2** | **Registro:** Crear cuentas con validación de datos. | BR01, BR03, BR04 | **[IMPLEMENTADO]** |
| **RF00.3** | **Recuperar Contraseña:** Restablecer acceso vía email. | BR02 | Pendiente |

### 4.2 Módulo de Gestión Deportiva
| ID | Requisito | Reglas Asociadas | Estado |
| :--- | :--- | :--- | :--- |
| **RF02.1** | **Gestión de Equipos:** Crear y organizar equipos. | BR05 | Pendiente |
| **RF04.1** | **Convocatorias:** Seleccionar jugadores para partidos. | BR07, BR09, BR10 | Pendiente |
| **RF09.1** | **Ficha Médica:** Consultar datos antropométricos e IMC. | BR11 | **[PARCIAL]** (Datos en BD) |

### 4.3 Módulo Financiero
| ID | Requisito | Reglas Asociadas | Estado |
| :--- | :--- | :--- | :--- |
| **RF06.1** | **Registro de Pagos:** Ingresar pagos de mensualidades. | BR14 | Pendiente |
| **RF06.2** | **Control de Mora:** Cambiar estados de solvencia. | BR13 | Pendiente |

---

## 5. Requerimientos No Funcionales (RNF)

| ID | Categoría | Descripción | Prioridad |
| :--- | :--- | :--- | :--- |
| **RNF01** | **Seguridad** | Autenticación mediante **JWT**. Control por roles (Spring Security). | Alta |
| **RNF02** | **Seguridad** | Cifrado de contraseñas (BCrypt) y HTTPS. | Alta |
| **RNF07** | **Rendimiento** | Respuestas API < 2 seg. | Alta |
| **RNF13** | **Compatibilidad** | Accesible desde Web y Móvil (Android/iOS). | Alta |

---

## 6. Infraestructura Tecnológica
* **Lenguaje:** Java 17 (Spring Boot 3).
* **Base de Datos:** MySQL / MariaDB.
* **Seguridad:** Spring Security + JWT.
* **Herramientas:** GitHub, IntelliJ, Postman.

---
