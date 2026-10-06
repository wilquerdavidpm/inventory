package com.example.order_service.service.Implement;

import com.example.order_service.dto.OrderItemsRequestDTO;
import com.example.order_service.dto.OrderRequestDTO;
import com.example.order_service.dto.OrderResponseDTO;
import com.example.order_service.mapper.OrderMapper;
import com.example.order_service.model.Order;
import com.example.order_service.model.OrderItems;
import com.example.order_service.model.OrderStatus;
import com.example.order_service.repository.OrderRepository;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    @Override
    public List<OrderResponseDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::toOrderResponseDTO)
                .toList();
    }

    @Override
    public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO) {

        BigDecimal totalPrice = BigDecimal.ZERO;

        for(OrderItemsRequestDTO item : orderRequestDTO.getOrderItemsList()){
            BigDecimal subtotal = item.getProductPrice()
                    .multiply(new BigDecimal(item.getQuantity()));
            totalPrice = totalPrice.add(subtotal);
        }

        /*List<OrderItems> orderItems = orderRequestDTO.getOrderItemsList()
                .stream()
                .map(orderMapper::toOrderItems)
                .toList();*/

        Order order = orderMapper.toOrder(orderRequestDTO);/*new Order(
                UUID.randomUUID().toString(),
                OrderStatus.PLACED,
                totalPrice,
                orderItems
        );*/
        order.setId(UUID.randomUUID().toString());
        order.setTotalPrice(totalPrice);
        order.setStatus(OrderStatus.PLACED);

        Order createdOrder = orderRepository.save(order);

        return orderMapper.toOrderResponseDTO(createdOrder);
    }

    @Override
    public void updateOrderStatus(OrderRequestDTO orderRequestDTO) {
        System.out.println("Hola mundo");
    }
}
