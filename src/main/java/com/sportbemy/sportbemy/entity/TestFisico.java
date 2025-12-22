package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "test_fisicos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestFisico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador", nullable = false)
    @NotNull(message = "El jugador es obligatorio")
    private Jugador jugador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entrenador", nullable = false)
    @NotNull(message = "El entrenador es obligatorio")
    private Entrenador entrenador;

    @Column(nullable = false)
    @NotNull(message = "La fecha del test es obligatoria")
    // VALIDACIÓN: @PastOrPresent
    // Lógica: No puedes registrar un resultado de un test que harás mañana.
    // Tiene que ser de hoy o de días anteriores.
    @PastOrPresent(message = "La fecha del test no puede ser futura")
    private LocalDate fecha; // Solo fecha (Año-Mes-Día)

    @Column(precision = 5, scale = 2) // Permite guardar ej: 35.55 (km/h)
    @NotNull(message = "La velocidad máxima es obligatoria")
    @Positive(message = "La velocidad debe ser mayor a 0")
    private BigDecimal velocidadMax;

    @Column(length = 100)
    @NotBlank(message = "El resultado de resistencia es obligatorio")
    @Size(max = 100, message = "El texto de resistencia es muy largo")
    private String resistencia; // Ej: "3200 metros" o "Nivel 12.5"

    @Column(precision = 4, scale = 2) // Permite guardar ej: 24.50 (IMC)
    @NotNull(message = "El IMC es obligatorio")
    @Positive(message = "El IMC debe ser positivo")
    private BigDecimal imc;

}
