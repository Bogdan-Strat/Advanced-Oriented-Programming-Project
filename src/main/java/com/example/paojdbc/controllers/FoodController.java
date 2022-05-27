package com.example.paojdbc.controllers;

import com.example.paojdbc.models.Food;
import com.example.paojdbc.services.FoodService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class FoodController {
    private final FoodService foodService;

    public void addFood(Food food){
        foodService.addFood(food);
    }

    public void deleteFood(Food food){
        foodService.deleteFood(food);
    }

    public void updatePrice(Food food, Integer price){
        foodService.updatePrice(food, price);
    }
}
