package com.example.paojdbc.controllers;

import com.example.paojdbc.models.Deliver;
import com.example.paojdbc.models.Order;
import com.example.paojdbc.models.User;
import com.example.paojdbc.services.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class OrderController {
    private final OrderService orderService;

    public void placeOrder(Order order){
        orderService.placeOrder(order);
    }

    public void cancelOrder(Order order){
        orderService.cancelOrder(order);
    }

    public void assignDeliver(Order order, Deliver deliver){
        orderService.asigneeDeliver(order, deliver);
    }

    public List<Order> getOrderHistoryOfAUser(User user){
        return orderService.getOrderHistoryOfAUser(user);
    }
}
