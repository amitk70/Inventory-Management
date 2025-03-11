package com.microservices.order_service.Services;

import com.microservices.order_service.Client.InventoryClient;
import com.microservices.order_service.Dto.OrderRequest;
import com.microservices.order_service.Model.Order;
import com.microservices.order_service.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    public OrderRequest placeOrder(Order order){

        boolean isInStock = inventoryClient.isInStock(order.getCode(),order.getQuantity());

        if(!isInStock) {
            throw new RuntimeException("Item is Not in Stock");
        }
            Order order1 = new Order();
            order1.setOrderNumber(UUID.randomUUID().toString());
            order1.setCode(order.getCode());
            order1.setPrice(order.getPrice());
            order1.setQuantity(order.getQuantity());
            orderRepository.save(order);
            return new OrderRequest(order.getId(),order.getOrderNumber(),order.getCode(),order.getPrice(), order.getQuantity());

    }

}
