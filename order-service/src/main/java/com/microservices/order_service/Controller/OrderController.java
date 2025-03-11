package com.microservices.order_service.Controller;


import com.microservices.order_service.Dto.OrderRequest;
import com.microservices.order_service.Model.Order;
import com.microservices.order_service.Services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/place")
    @ResponseStatus(HttpStatus.CREATED)
    public OrderRequest placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }
}
