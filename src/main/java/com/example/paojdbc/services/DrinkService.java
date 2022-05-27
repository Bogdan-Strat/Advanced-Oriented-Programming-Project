package com.example.paojdbc.services;

import com.example.paojdbc.models.Drink;
import com.example.paojdbc.repositories.DrinkRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DrinkService {
    private final DrinkRepository drinkRepository;

    public void addDrink(Drink drink){
        drinkRepository.addDrink(drink);
    }

    public void deleteDrink(Drink drink){
        drinkRepository.deleteDrink(drink);
    }

    public void updatePrice(Drink drink, Integer price){
        drinkRepository.updatePrice(drink, price);
    }
}
