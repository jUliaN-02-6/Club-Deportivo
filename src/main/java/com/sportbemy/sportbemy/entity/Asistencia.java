package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
// Esto evita que registres al mismo jugador dos veces en el mismo entrenamiento.
@Table(name = "asistencias",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id_jugador", "id_entrenamientos"})
        })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador", nullable = false)
    @NotNull(message = "El jugador es obligatorio")
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entrenamientos", nullable = false)
    @NotNull(message = "El entrenamiento es obligatorio")
    private Entrenamiento entrenamiento;

    @Column(nullable = false)
    @NotNull(message = "Debes indicar si asistio o no")
    @Builder.Default // Para que el Builder sepa que esto empieza en false
    private Boolean asistio = false;

    @Column(columnDefinition = "TEXT")
    private String observaciones;
}

