package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "planes_membresia")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlanMembresia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre del plan es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @PositiveOrZero(message = "El costo no puede ser negativo")
    @Column(name = "costo_mensual", precision = 15, scale = 2)
    private BigDecimal costoMensual;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
}