# 📋 Especificación de Requisitos y Reglas de Negocio - SportBemy

Este documento define el comportamiento funcional y las restricciones lógicas del sistema de gestión deportiva SportBemy.

## 1. Módulo de Seguridad y Usuarios
**RF01 - Gestión de Cuentas:** El sistema debe permitir el registro y autenticación de usuarios con roles específicos.

* **BR01 (Unicidad):** No pueden existir dos usuarios con el mismo correo electrónico o número de documento.
* **BR02 (Seguridad):** Las contraseñas deben ser almacenadas de forma encriptada (Hash).
* **BR03 (Registro de Menores):** Si el usuario es menor de 18 años, el sistema obliga a registrar un "Acudiente" responsable. Si es mayor, el acudiente es opcional.

## 2. Módulo de Estructura Deportiva
**RF02 - Asignación de Categorías:** El sistema debe organizar a los jugadores en equipos según su edad y género.

* **BR04 (Categorización Automática):** La categoría (Sub-15, Sub-20, etc.) se asigna automáticamente calculando la edad del jugador según su fecha de nacimiento.
* **BR05 (Cupos de Equipo):** Un equipo no puede tener más de 25 jugadores activos inscritos.
* **BR06 (Dorsales):** No pueden existir dos jugadores con el mismo número de dorsal en el mismo equipo.

## 3. Módulo de Entrenamiento
**RF03 - Control de Asistencia:** El sistema permite a los entrenadores registrar quién asistió a las prácticas.

* **BR07 (Bloqueo por Deuda):** El sistema no debe permitir marcar asistencia a un jugador que tenga el estado de pago "MORA" o que no haya pagado el mes en curso.
* **BR08 (Ventana de Tiempo):** La asistencia solo puede registrarse el mismo día del entrenamiento. No se permite modificar asistencias de días pasados sin perfil de Administrador.

## 4. Módulo de Competición
**RF04 - Gestión de Partidos:** Registro de convocatorias y estadísticas de juego.

* **BR09 (Jugador Habilitado):** Solo se pueden convocar a un partido jugadores que estén activos y que NO tengan una lesión con estado "EN TRATAMIENTO".
* **BR10 (Validación de Resultado):** Al cerrar un partido, la suma de goles en las estadísticas individuales debe coincidir con el marcador final registrado en el partido.

## 5. Módulo Financiero y Salud
**RF05 - Control de Pagos y Novedades:** Gestión de mensualidades y estado físico.

* **BR11 (Pagos):** Los pagos realizados por métodos no inmediatos (Transferencia) entran en estado "PENDIENTE" y requieren aprobación manual de un administrativo.
* **BR12 (Lesiones):** Al registrar una lesión, el sistema debe cambiar automáticamente el estado del jugador a "NO DISPONIBLE" para convocatorias.
