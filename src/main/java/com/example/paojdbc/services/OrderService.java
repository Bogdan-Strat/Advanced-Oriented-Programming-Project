package com.example.paojdbc.services;

import com.example.paojdbc.models.Deliver;
import com.example.paojdbc.models.Order;
import com.example.paojdbc.models.User;
import com.example.paojdbc.repositories.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(Order order){
        orderRepository.placeOrder(order);
    }

    public void cancelOrder(Order order){
        orderRepository.cancelOrder(order);
    }

    public void asigneeDeliver(Order order, Deliver deliver){
        orderRepository.updateDeliver(order, deliver);
    }

    public List<Order> getOrderHistoryOfAUser(User user){
       return orderRepository.getOrdersByUser(user);
    }
}
