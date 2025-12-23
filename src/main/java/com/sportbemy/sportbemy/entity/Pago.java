package com.sportbemy.sportbemy.entity;

import com.sportbemy.sportbemy.entity.enums.EstadoPago;
import com.sportbemy.sportbemy.entity.enums.MetodoPago;
import jakarta.persistence.*;
import jakarta.validation.constraints.*; // Min, Max, Positive, NotNull
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // RELACIÓN: Quién pone el dinero
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    @NotNull(message = "El usuario que realiza el pago es obligatorio")
    private Usuario usuario;

    // precision=10, scale=2 significa: 8 dígitos enteros y 2 decimales (ej: 99999999.99)
    @Column(nullable = false, precision = 10, scale = 2)
    @NotNull(message = "El monto es obligatorio")
    @Positive(message = "El monto debe ser mayor a cero")
    private BigDecimal monto;

    // FECHA EXACTA DE LA TRANSACCIÓN
    @Column(nullable = false)
    @NotNull(message = "La fecha del pago es obligatoria")
    private LocalDateTime fechaPago;

    // MES PAGADO (1 = Enero, 12 = Diciembre)
    @Column(nullable = false)
    @NotNull(message = "El mes pagado es obligatorio")
    @Min(value = 1, message = "El mes debe ser mínimo 1 (Enero)")
    @Max(value = 12, message = "El mes debe ser máximo 12 (Diciembre)")
    private Integer mesPagado;

    // AÑO PAGADO
    @Column(nullable = false)
    @NotNull(message = "El año pagado es obligatorio")
    @Min(value = 2024, message = "El año no puede ser anterior a 2024")
    private Integer anioPagado;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NotNull(message = "El método de pago es obligatorio")
    private MetodoPago metodoPago;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    @NotNull(message = "El estado del pago es obligatorio")
    @Builder.Default // Por defecto nace PENDIENTE hasta que alguien lo revise
    private EstadoPago estado = EstadoPago.PENDIENTE;

    // COMPROBANTE (URL de la imagen/foto)
    // No es obligatorio (@NotNull) porque si paga en efectivo quizás no hay foto inmediata.
    @Column(length = 500)
    private String comprobanteUrl;
}