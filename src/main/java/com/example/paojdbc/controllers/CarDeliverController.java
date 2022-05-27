package com.example.paojdbc.controllers;

import com.example.paojdbc.models.CarDeliver;
import com.example.paojdbc.services.CarDeliverService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class CarDeliverController {
    private final CarDeliverService carDeliverService;

    public void hireCarDeliver(CarDeliver carDeliver){
        carDeliverService.hireCarDeliver(carDeliver);
    }

    public List<CarDeliver> getCarDelivers(){
        return carDeliverService.getCarDelivers();
    }

    public void resignCarDeliver(CarDeliver carDeliver){
        carDeliverService.resignCarDeliver(carDeliver);
    }

    public void updateLocation(CarDeliver carDeliver, Integer x, Integer y){
        carDeliverService.updateLocation(carDeliver, x, y);
    }

    public BigDecimal getMoney(CarDeliver carDeliver){
        return carDeliverService.getMoney(carDeliver);
    }
}
