package com.example.order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsResponseDTO{
    private Long id;
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer quantity;
}
