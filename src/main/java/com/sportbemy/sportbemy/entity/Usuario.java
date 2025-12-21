package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El rol es obligatorio")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_rol")
    private Rol rol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_plan_membresia")
    private PlanMembresia planMembresia;

    @Column(length = 100)
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @Column(length = 100)
    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    private String apellido;

    @Column(length = 20, unique = true)
    @NotBlank(message = "El documento es obligatorio")
    @Pattern(
            regexp = "^[0-9]+$",
            message = "El documento debe contener solo números")
    private String documento;

    @Column(length = 20)
    @NotBlank(message = "El telefono es obligatorio")
    // Valida que sea un formato numérico básico
    @Pattern(
            regexp = "^\\+?[0-9\\s]{7,15}$",
            message = "El formato del teléfono no es válido")
    private String telefono;

    @Column(name= "fecha_nacimiento")
    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe ser una fecha pasada")
    private LocalDate fechaNacimiento;

    @Column(length = 150, unique = true, nullable = false)
    @NotBlank(message = "El email es obligatorio") // Java valida que no esté vacío
    @Email(message = "El formato del email no es valido") // Java valida que tenga @ y .com
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[@$!%*?&]).*$",
            message = "La contraseña debe tener al menos una mayuscula y un caracter especial (@$!%*?&)"
    )
    private String password;

    @Column(columnDefinition = "BOOLEAN DEFAULT TRUE")
    @Builder.Default // Para que el Builder sepa que esto empieza en true
    private Boolean activo = true;


}
