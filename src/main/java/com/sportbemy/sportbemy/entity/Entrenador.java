package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "entrenadores")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    @NotNull(message = "El usuario es obligatorio")
    private Usuario usuario;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "La licencia es obligatoria")
    @Size(min = 3, max = 50, message = "La licencia debe de tener entre 3 y 50 caracteres")
    private String licencia;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "La especialidad es obligatoria")
    @Size(min = 3, max = 100, message = "La especialidad debe tener entre 3 y 100 caracteres")
    private String especialidad;
}
