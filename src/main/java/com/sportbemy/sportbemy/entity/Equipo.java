package com.sportbemy.sportbemy.entity;

import com.sportbemy.sportbemy.entity.enums.Genero;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "equipos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "La categoría es obligatoria")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @Column(length = 100, unique = true, nullable = false)
    @NotBlank(message = "El nombre del equipo es obligatorio")
    @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
    private String nombre;

    // TEMPORADA: (Ej: "2024-I" o "2025")
    @Column(length = 10, nullable = false)
    @NotBlank(message = "La temporada es obligatoria")
    private String temporada;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NotNull(message = "El género es obligatorio")
    private Genero genero;

}
