package com.example.order_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderRequestDTO{

    @NotNull(message = "La lista de productos no puede estar vacía")
    @NotEmpty(message = "La lista de productos no puede estar vacía")
    @Valid
    private List<OrderItemsRequestDTO> orderItemsList;
}
