package com.sportbemy.sportbemy.entity;

import com.sportbemy.sportbemy.entity.enums.PiernaHabil;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "jugadores")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_usuario", nullable = false, unique = true)
    @NotNull(message = "El usuario es obligatorio")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_equipo", nullable = true)
    private Equipo equipo;

    @Column(length = 100, nullable = false)
    @NotBlank(message = "La posicion es obligatoria")
    @Size(min = 5, max = 100, message = "La posicion debe tener entre 5 y 100 caracteres")
    private String posicion; // Ej: "Portero", "Delantero"

    @Column(nullable = false)
    @NotNull(message = "El dorsal es obligatorio")
    @Positive(message = "El dorsal debe ser un numero positivo")
    @Max(value = 99, message = "El dorsal no puede ser mayor a 99")
    private Integer dorsal;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NotNull(message = "La pierna habil es obligatoria")
    private PiernaHabil piernaHabil;

    @Column(nullable = false)
    @NotNull(message = "La altura del jugador es obligatoria")
    @Positive(message = "La altura debe ser positiva")
    @Min(value = 100, message = "La altura mínima es 100cm") // Validación lógica extra
    private Integer altura;

    @Column(nullable = false, precision = 5, scale = 2)
    @NotNull(message = "El peso es obligatorio")
    @Positive(message = "El peso debe ser positivo")
    private BigDecimal peso;

    @Column(nullable = false,  length = 5)
    @NotBlank(message = "El tipo de sangre es obligatorio")
    @Size(max = 5, message = "El RH es muy largo")
    private String rh;

    @Column(nullable = false, length = 50)
    @NotBlank(message = "El nombre de la EPS es obligatoria")
    @Size(min = 3, max = 50, message = "El nombre de la EPS debe tener entre 3 y 50 caracteres")
    private String eps;
}
