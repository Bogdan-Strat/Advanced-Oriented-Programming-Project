package com.example.paojdbc.services;

import com.example.paojdbc.models.Food;
import com.example.paojdbc.repositories.FoodRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    public void addFood(Food food){
        foodRepository.addFood(food);
    }

    public void deleteFood(Food food){
        foodRepository.deleteFood(food);
    }

    public void updatePrice(Food food, Integer price){
        foodRepository.updatePrice(food, price);
    }
}
