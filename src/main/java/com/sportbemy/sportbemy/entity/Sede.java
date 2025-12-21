package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "sedes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sede {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre de la sede es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre de la sede debe tener entre 3 y 100 caracteres")
    private String nombre;

    @Column(nullable = false, length = 200)
    @NotBlank(message = "La direccion es obligatoria")
    @Size(min = 10, max = 200, message = "La dirección debe tener entre 10 y 200 caracteres")
    private String direccion;

}
