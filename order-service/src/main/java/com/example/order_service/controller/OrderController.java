package com.example.order_service.controller;


import com.example.order_service.dto.OrderRequestDTO;
import com.example.order_service.dto.OrderResponseDTO;
import com.example.order_service.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponseDTO> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponseDTO createOrder(@Valid @RequestBody OrderRequestDTO orderRequestDTO) {
        return orderService.createOrder(orderRequestDTO);
    }
}
