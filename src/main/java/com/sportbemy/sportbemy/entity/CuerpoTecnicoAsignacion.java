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
@Table(
        name = "cuerpo_tecnico_asignacion",
        //Esto significa: "En esta tabla, la pareja (equipo + entrenador) no se puede repetir"
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id_equipo", "id_entrenador"})
        })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CuerpoTecnicoAsignacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo", nullable = false)
    @NotNull(message = "El equipo es obligatorio")
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entrenador", nullable = false)
    @NotNull(message = "El entrenador es obligatorio")
    private Entrenador entrenador;

    @Column(length = 100)
    @NotBlank(message = "El ROL es obligatorio")
    @Size(min = 2, max = 100, message = "El rol debe de tener entre 2 y 100 caracteres")
    private String rolEnEquipo;
}
