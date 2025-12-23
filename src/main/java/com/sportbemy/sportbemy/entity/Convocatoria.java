package com.sportbemy.sportbemy.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "convocatorias",
        // RESTRICCIÓN: Un jugador no puede estar convocado dos veces para el MISMO partido.
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"id_partido", "id_jugador"})
        }
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Convocatoria {

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

    // ATRIBUTO: ¿Es titular o suplente?
    @Column(nullable = false)
    @NotNull(message = "Debes indicar si es titular (true) o suplente (false)")
    @Builder.Default // Por defecto asumimos que es suplente (false) hasta que se diga lo contrario
    private Boolean fueTitular = false;

}