package com.example.order_service.dto;

import com.example.order_service.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDTO{
    private String id;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private List<OrderItemsResponseDTO> orderItemsList;
}
