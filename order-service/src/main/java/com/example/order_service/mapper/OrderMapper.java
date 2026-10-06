package com.example.order_service.mapper;

import com.example.order_service.dto.OrderItemsRequestDTO;
import com.example.order_service.dto.OrderItemsResponseDTO;
import com.example.order_service.dto.OrderRequestDTO;
import com.example.order_service.dto.OrderResponseDTO;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderItems;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    //@Mapping(source = "orderItemsRequestDTO", target = "orderItems")
    Order toOrder(OrderRequestDTO orderRequestDTO);

    @Mapping(source = "orderItemsList", target = "orderItemsList")
    OrderResponseDTO toOrderResponseDTO(Order order);

    @Mapping(target = "id", ignore = true)
    OrderItems toOrderItems(OrderItemsRequestDTO orderItemsRequestDTO);

    OrderItemsResponseDTO toOrderItemsResponseDTO(OrderItems orderItems);
}