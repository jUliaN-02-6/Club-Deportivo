package com.sportbemy.sportbemy.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegistroEntrenadorDTO {

    // 1. COMPOSICIÓN (Datos de Usuario - Login)
    @Valid
    @NotNull(message = "Los datos de la cuenta son obligatorios")
    private DatosCuentaDTO cuenta;

    // 2. DATOS PROFESIONALES (Copiados de tu Entidad)

    @NotBlank(message = "La licencia es obligatoria")
    @Size(min = 3, max = 50, message = "La licencia debe tener entre 3 y 50 caracteres")
    private String licencia;

    @NotBlank(message = "La especialidad es obligatoria")
    @Size(min = 3, max = 100, message = "La especialidad debe tener entre 3 y 100 caracteres")
    private String especialidad;
}