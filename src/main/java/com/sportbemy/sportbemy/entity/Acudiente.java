package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "acudientes",
        uniqueConstraints = {
                // Un menor solo puede tener UN responsable principal (opcional, según tu regla)
                @UniqueConstraint(columnNames = {"id_menor", "id_responsable"})
        })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Acudiente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_menor", nullable = false)
    @NotNull(message = "El menor de edad es obligatorio")
    private Usuario menor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_responsable", nullable = false)
    @NotNull(message = "El responsable (padre/madre) es obligatorio")
    private Usuario responsable;

    @Column(length = 50, nullable = false)
    @NotBlank(message = "El parentesco es obligatorio")
    private String parentesco; // Ej: "Padre", "Madre", "Abuela"
}