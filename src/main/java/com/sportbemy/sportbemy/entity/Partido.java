package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Partido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // EQUIPO PRINCIPAL (Nosotros)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo", nullable = false)
    @NotNull(message = "El equipo principal es obligatorio")
    private Equipo equipo;

    // RIVAL INTERNO (Opcional - Puede ser null si el rival es externo)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rival_interno", nullable = true)
    private Equipo rivalInterno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sede", nullable = false)
    @NotNull(message = "La sede es obligatoria")
    private Sede sede;

    // RIVAL EXTERNO (Texto)
    @Column(length = 150)
    @Size(min = 3, max = 150, message = "El nombre del rival externo debe tener entre 3 y 150 caracteres")
    private String nombreRivalExterno;

    @Column(nullable = false)
    @NotNull(message = "La fecha y hora es obligatoria")
    @FutureOrPresent(message = "La fecha del partido debe ser hoy o en el futuro")
    private LocalDateTime fechaHora; // Usamos LocalDateTime (Fecha + Hora)

    @Column(nullable = false)
    @NotNull(message = "Debes indicar si es local o visitante")
    @Builder.Default
    private Boolean esLocal = true;

    @PositiveOrZero(message = "Los goles no pueden ser negativos")
    private Integer resultadoNuestro;

    @PositiveOrZero(message = "Los goles no pueden ser negativos")
    private Integer resultadoRival;
}
