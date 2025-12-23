package com.sportbemy.sportbemy.entity;

import com.sportbemy.sportbemy.entity.enums.EstadoLesion;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "lesiones")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RELACIÓN: Un jugador puede tener muchas lesiones a lo largo de su carrera.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador", nullable = false)
    @NotNull(message = "El jugador es obligatorio")
    private Jugador jugador;

    // DESCRIPCIÓN: Qué le pasó (Ej: "Esguince de tobillo grado 2")
    @Column(nullable = false, length = 200)
    @NotBlank(message = "La descripción de la lesión es obligatoria")
    @Size(min = 5, max = 200, message = "La descripción debe tener entre 5 y 200 caracteres")
    private String descripcion;

    // FECHA INICIO: Debe ser hoy o antes (No puedes registrar una lesión futura)
    @Column(nullable = false)
    @NotNull(message = "La fecha de la lesión es obligatoria")
    @PastOrPresent(message = "La fecha de inicio no puede ser futura")
    private LocalDate fechaInicio;
    
    // Puede ser NULL en la base de datos.
    @Column(nullable = true)
    private LocalDate fechaFin;

    // ESTADO: Usamos el Enum para controlar las fases
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NotNull(message = "El estado de la lesión es obligatorio")
    private EstadoLesion estado;
}