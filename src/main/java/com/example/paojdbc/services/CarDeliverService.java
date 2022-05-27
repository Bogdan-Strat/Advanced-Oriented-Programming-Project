package com.example.paojdbc.services;

import com.example.paojdbc.models.CarDeliver;
import com.example.paojdbc.repositories.CarDeliverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class CarDeliverService {
    private final CarDeliverRepository carDeliverRepository;

    public void hireCarDeliver(CarDeliver carDeliver){
        carDeliverRepository.addCarDeliver(carDeliver);
    }

    public List<CarDeliver> getCarDelivers(){
        return carDeliverRepository.getCarDelivers();
    }

    public void resignCarDeliver(CarDeliver carDeliver){
        carDeliverRepository.deleteCarDeliver(carDeliver);
    }

    public void updateLocation(CarDeliver carDeliver, Integer x, Integer y){
        calculateMoney(carDeliver, x, y);
        carDeliverRepository.locationUpdate(carDeliver, x, y);
    }

    public Integer distance(Integer x1, Integer y1, Integer x2, Integer y2) {
        return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);

    }

    public void calculateMoney(CarDeliver carDeliver, Integer x, Integer y){
        Integer distance =  distance(carDeliver.getMX(), carDeliver.getMY(), x, y);

        BigDecimal time;
        if(distance != 0){
            time = BigDecimal.valueOf(carDeliver.getMSpeed()).divide(BigDecimal.valueOf(distance), 2);
        }
        else{
            time  = BigDecimal.valueOf(0);
        }

        BigDecimal money = time.multiply(BigDecimal.valueOf(0.8));
        money = money.add(carDeliver.getMMoney());
        money = money.add( carDeliver.getMCommission());
        carDeliver.setMMoney(money);

    }

    public BigDecimal getMoney(CarDeliver carDeliver){
        return carDeliver.getMMoney();
    }

}
