package com.example.paojdbc.controllers;

import com.example.paojdbc.models.Drink;
import com.example.paojdbc.services.DrinkService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class DrinkController {
    private final DrinkService drinkService;

    public void addDrink(Drink drink){
        drinkService.addDrink(drink);
    }

    public void deleteDrink(Drink drink){
        drinkService.deleteDrink(drink);
    }

    public void updatePrice(Drink drink, Integer price){
        drinkService.updatePrice(drink, price);
    }
}
