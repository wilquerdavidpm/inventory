package com.example.order_service.service;

import com.example.order_service.dto.OrderRequestDTO;
import com.example.order_service.dto.OrderResponseDTO;

import java.util.List;

public interface OrderService {
    List<OrderResponseDTO> getAllOrders();
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);
    void updateOrderStatus(OrderRequestDTO orderRequestDTO);
}
