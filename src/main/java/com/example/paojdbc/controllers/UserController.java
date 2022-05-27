package com.example.paojdbc.controllers;

import com.example.paojdbc.models.Product;
import com.example.paojdbc.models.User;
import com.example.paojdbc.models.Venue;
import com.example.paojdbc.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public void signUp(User user){
        userService.signUp(user);
    }

    public List<User> getUsers(){
        return userService.getUsers();
    }

    public User getUserById(Integer id){
        return userService.getUserById(id);
    }

    public void closeAccount(User user){
        userService.closeAccount(user);
    }

    public void changePassword(User user, String password){
        userService.changePassword(user, password);
    }

    public void addProductInBasket(User user, Product product){
        userService.addProductInBasket(user, product);
    }

    public List<Product> getBasket(User user){
        return userService.getBasket(user);
    }

    public Integer getPriceOfABasket(User user){
        return userService.getPriceOfBasket(user);
    }

    public void chooseVenue(User user, Venue venue){
        userService.selectRestaurant(user, venue);
    }

}
