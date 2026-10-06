package com.example.order_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderItemsRequestDTO{
    @NotBlank(message = "El nombre no puede estar vacío")
    private String productId;

    @NotBlank(message = "El nombre del producto es obligatorio")
    private String productName;

    @NotNull(message = "El precio es obligatorio")
    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal productPrice;

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1)
    private Integer quantity;
}
