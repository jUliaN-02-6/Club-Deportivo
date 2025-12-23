package com.sportbemy.sportbemy.dto.request;

import com.sportbemy.sportbemy.entity.enums.PiernaHabil; // Asegúrate de importar tu Enum
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class RegistroJugadorDTO {

    // 1. COMPOSICIÓN (Datos de Usuario)
    @Valid
    @NotNull(message = "Los datos de la cuenta son obligatorios")
    private DatosCuentaDTO cuenta;

    // 2. DATOS DEPORTIVOS
    @NotBlank(message = "La posición es obligatoria")
    @Size(min = 5, max = 100, message = "La posición debe tener entre 5 y 100 caracteres")
    private String posicion;

    @NotNull(message = "El dorsal es obligatorio")
    @Positive(message = "El dorsal debe ser un número positivo")
    @Max(value = 99, message = "El dorsal no puede ser mayor a 99")
    private Integer dorsal;

    @NotNull(message = "La pierna hábil es obligatoria")
    private PiernaHabil piernaHabil; // Spring/Thymeleaf convertirá el String del formulario a este Enum automáticamente

    @NotNull(message = "La altura del jugador es obligatoria")
    @Positive(message = "La altura debe ser positiva")
    @Min(value = 100, message = "La altura mínima es 100cm")
    private Integer altura;

    @NotNull(message = "El peso es obligatorio")
    @Positive(message = "El peso debe ser positivo")
    private BigDecimal peso;

    @NotBlank(message = "El tipo de sangre es obligatorio")
    @Size(max = 5, message = "El RH es muy largo") // Ej: "O+"
    private String rh;

    @NotBlank(message = "El nombre de la EPS es obligatoria")
    @Size(min = 3, max = 50, message = "El nombre de la EPS debe tener entre 3 y 50 caracteres")
    private String eps;
}