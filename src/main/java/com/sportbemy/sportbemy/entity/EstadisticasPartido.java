package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estadisticas_partido",
        // SAFETY: Evita que registres dos planillas de estadísticas para el mismo jugador en el mismo partido.
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id_partido", "id_jugador"})
        }
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EstadisticasPartido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partido", nullable = false)
    @NotNull(message = "El partido es obligatorio")
    private Partido partido;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador", nullable = false)
    @NotNull(message = "El jugador es obligatorio")
    private Jugador jugador;

    // --- ESTADÍSTICAS (Inicializadas en 0) ---

    @Column(nullable = false)
    @NotNull(message = "Los goles no pueden ser nulos")
    @PositiveOrZero(message = "Los goles no pueden ser negativos")
    @Builder.Default // OBLIGATORIO: Si usas @Builder, necesitas esto para que el "= 0" funcione.
    private Integer goles = 0;

    @Column(nullable = false)
    @NotNull(message = "Las asistencias no pueden ser nulas")
    @PositiveOrZero(message = "Las asistencias no pueden ser negativas")
    @Builder.Default
    private Integer asistencias = 0;

    @Column(nullable = false)
    @NotNull(message = "Las amarillas no pueden ser nulas")
    @PositiveOrZero(message = "Las amarillas no pueden ser negativas")
    @Builder.Default
    private Integer amarillas = 0;

    @Column(nullable = false)
    @NotNull(message = "Las rojas no pueden ser nulas")
    @PositiveOrZero(message = "Las rojas no pueden ser negativas")
    @Builder.Default
    private Integer rojas = 0;

    @Column(nullable = false)
    @NotNull(message = "Los minutos jugados son obligatorios")
    @PositiveOrZero(message = "Los minutos no pueden ser negativos")
    @Builder.Default
    private Integer minutosJugados = 0;
}