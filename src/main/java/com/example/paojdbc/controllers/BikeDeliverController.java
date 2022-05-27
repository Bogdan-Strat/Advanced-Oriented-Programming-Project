package com.example.paojdbc.controllers;

import com.example.paojdbc.models.BikeDeliver;
import com.example.paojdbc.services.BikeDeliverService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class BikeDeliverController {
    private final BikeDeliverService bikeDeliverService;

    public void hireCarDeliver(BikeDeliver bikeDeliver){
        bikeDeliverService.hireCarDeliver(bikeDeliver);
    }

    public List<BikeDeliver> getBikeDelivers(){
        return bikeDeliverService.getBikeDelivers();
    }

    public void resignBikeDeliver(BikeDeliver bikeDeliver){
        bikeDeliverService.resignBikeDeliver(bikeDeliver);
    }

    public void updateLocation(BikeDeliver bikeDeliver, Integer x, Integer y){
        bikeDeliverService.updateLocation(bikeDeliver, x, y);
    }

    public BigDecimal getMoney(BikeDeliver bikeDeliver){
        return bikeDeliverService.getMoney(bikeDeliver);
    }
}
