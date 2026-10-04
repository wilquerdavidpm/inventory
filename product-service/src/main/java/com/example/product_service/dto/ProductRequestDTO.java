package com.example.product_service.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;



public record ProductRequestDTO(

        @NotBlank(message = "El nombre no puede estar vacío")
        String name,

        @NotBlank(message = "La descripción no puede estar vacía")
        String description,

        @NotNull(message = "La cantidad es obligatoria")
        @Min(value = 1, message = "La cantidad debe ser mayor o igual a 1")
        Integer quantityInStock,

        @NotNull(message = "El precio es obligatorio")
        @DecimalMin(value = "0.0", inclusive = false, message = "El precio no puede ser negativo")
        BigDecimal price
) {
}
