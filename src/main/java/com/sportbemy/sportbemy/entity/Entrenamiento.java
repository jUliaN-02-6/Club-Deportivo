package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "entrenamientos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entrenamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo", nullable = false)
    @NotNull(message = "El equipo es obligatorio")
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sede", nullable = false)
    @NotNull(message = "La sede es obligatoria")
    private Sede sede;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entrenador", nullable = false)
    @NotNull(message = "El entrenador es obligatorio")
    private Entrenador entrenador;

    @Column(nullable = false)
    @NotNull(message = "La fecha y hora es obligatoria")
    @FutureOrPresent(message = "La fecha del entrenamiento debe ser hoy o en el futuro")
    private LocalDateTime fechaHora; // Usamos LocalDateTime (Fecha + Hora)

    @Column(nullable = false, length = 255) // Texto un poco largo
    @NotBlank(message = "El objetivo del entrenamiento es obligatorio")
    @Size(min = 5, max = 255, message = "El objetivo debe tener entre 5 y 255 caracteres")
    private String objetivo;
}
