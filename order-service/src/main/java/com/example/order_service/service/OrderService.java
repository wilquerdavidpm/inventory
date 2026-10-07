package com.example.order_service.service;

import com.example.order_service.dto.OrderRequestDTO;
import com.example.order_service.dto.OrderResponseDTO;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderResponseDTO> getAllOrders();
    OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO);
    OrderResponseDTO getOrderById(String orderId);
    void updateOrderStatus(OrderRequestDTO orderRequestDTO);
}
