package com.sportbemy.sportbemy.service.serviceImpl;

import com.sportbemy.sportbemy.dto.request.RegistroJugadorDTO;
import com.sportbemy.sportbemy.dto.response.UsuarioResponseDTO;
import com.sportbemy.sportbemy.entity.Jugador;
import com.sportbemy.sportbemy.entity.Rol;
import com.sportbemy.sportbemy.entity.Usuario;
import com.sportbemy.sportbemy.repository.CategoriaRepository;
import com.sportbemy.sportbemy.repository.JugadorRepository;
import com.sportbemy.sportbemy.repository.RolRepository;
import com.sportbemy.sportbemy.repository.UsuarioRepository;
import com.sportbemy.sportbemy.service.IAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    //1. INYECCION DE DEPENDENCIAS
    private final UsuarioRepository usuarioRepository;
    private final JugadorRepository jugadorRepository;
    private final RolRepository rolRepository;
    private final CategoriaRepository categoriaRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UsuarioResponseDTO registrarJugador(RegistroJugadorDTO dto){
     if (usuarioRepository.existsByEmail(dto.getCuenta().getEmail())) {
         throw new RuntimeException("Este email ya esta registrado");
     }

     // PASO 2: Buscar el Rol
     Rol rolJugador = rolRepository.findById(1L)
             .orElseThrow(() -> new RuntimeException("Error: No se encontro el rol de JUGADOR en la base de datos"));

     // PASO 3: Crear el Usuario y llenar datos básicos
     Usuario usuario = new Usuario();
     usuario.setNombre(dto.getCuenta().getNombre());
     usuario.setApellido(dto.getCuenta().getApellido());
     usuario.setEmail(dto.getCuenta().getEmail());
     usuario.setDocumento(dto.getCuenta().getDocumento());
     usuario.setTelefono(dto.getCuenta().getTelefono());
     usuario.setFechaNacimiento(dto.getCuenta().getFechaNacimiento());

     //Asignamos el Rol que encontramos
     usuario.setRol(rolJugador);
     usuario.setActivo(true);

     // 4. BR02 (Seguridad): ENCRIPTAR LA CONTRASEÑA
     // Leemos la pass del formulario (get), la encriptamos, y la ponemos en el usuario (set)
     String passwordNormal = dto.getCuenta().getPassword();
     String passwordEncriptada = passwordEncoder.encode(passwordNormal);
     usuario.setPassword(passwordEncriptada);

    // 5. GUARDAR EL USUARIO (El primer 'Save')
    // Al guardar, la base de datos le asigna un ID único.
    // Guardamos el resultado en 'usuarioGuardado' para usar ese ID después.
    Usuario usuarioGuardado = usuarioRepository.save(usuario);

    //6. CREAR Y GUARDAR EL JUGADOR (Datos deportivos)
    Jugador jugador = new Jugador();

    //¡IMPORTANTE! Aqui unimos las dos tablas;
    jugador.setUsuario(usuarioGuardado);// "Este perfil deportivo pertenece a ESTE usuario"

    // Copiamos los datos del deporte
    jugador.setPosicion(dto.getPosicion());
    jugador.setDorsal(dto.getDorsal());
    jugador.setPiernaHabil(dto.getPiernaHabil());
    jugador.setAltura(dto.getAltura());
    jugador.setPeso(dto.getPeso());
    jugador.setRh(dto.getRh());
    jugador.setEps(dto.getEps());

    //1. Calcular Edad
    int edad = calcularEdad(dto.getCuenta().getFechaNacimiento());

    //2. Determinar el nombre de la categoria (String)
    String nombreCategoria = determinarCategoria(edad);

    // 3. Buscar la ENTIDAD en la Base de Datos
    // Usamos el repositorio de categorías que ya inyectaste arriba.
    // Si no existe en la BD, lanzamos error (porque no podemos guardar basura).
    com.sportbemy.sportbemy.entity.Categoria categoriaEntidad = categoriaRepository.findByNombre(nombreCategoria)
            .orElseThrow(() -> new RuntimeException("Error crítico: La categoría '" + nombreCategoria + "' no existe en la BD. Crea los inserts primero."));

    //Guardamos el jugador
    jugadorRepository.save(jugador);

    UsuarioResponseDTO response = new UsuarioResponseDTO();
    response.setId(usuarioGuardado.getId());
    response.setNombre(usuarioGuardado.getNombre());
    response.setApellido(usuarioGuardado.getApellido());
    response.setEmail(usuarioGuardado.getEmail());
    response.setRol(rolJugador.getNombre());

    return response;
    }

    // ==========================================
    // MÉTODOS AUXILIARES (Van afuera del método principal, pero dentro de la clase)
    // ==========================================

    private int calcularEdad(java.time.LocalDate fechaNacimiento) {
        if (fechaNacimiento == null) return 0;
        return java.time.Period.between(fechaNacimiento, java.time.LocalDate.now()).getYears();
    }

    // Lógica profesional de asignación de categorías según edad
    private String determinarCategoria(int edad) {
        if (edad < 6)  return "PRE-BENJAMIN"; // O podrías tener una "Babys" si quieres
        if (edad <= 7) return "PRE-BENJAMIN";
        if (edad <= 9) return "BENJAMIN";
        if (edad <= 11) return "ALEVIN";
        if (edad <= 13) return "INFANTIL";
        if (edad <= 15) return "CADETE";
        if (edad <= 19) return "JUVENIL";

        return "PROFESIONAL"; // 20 años en adelante
    }
}
