package com.example.paojdbc.services;

import com.example.paojdbc.models.BikeDeliver;
import com.example.paojdbc.repositories.BikeDeliverRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class BikeDeliverService {
    private final BikeDeliverRepository bikeDeliverRepository;

    public void hireCarDeliver(BikeDeliver bikeDeliver){
        bikeDeliverRepository.addCarDeliver(bikeDeliver);
    }

    public List<BikeDeliver> getBikeDelivers(){
        return bikeDeliverRepository.getCarDelivers();
    }

    public void resignBikeDeliver(BikeDeliver bikeDeliver){
        bikeDeliverRepository.deleteCarDeliver(bikeDeliver);
    }

    public void updateLocation(BikeDeliver bikeDeliver, Integer x, Integer y){
        calculateMoney(bikeDeliver, x, y);
        bikeDeliverRepository.locationUpdate(bikeDeliver, x, y);
    }

    public Integer distance(Integer x1, Integer y1, Integer x2, Integer y2) {
        return (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1);

    }

    public void calculateMoney(BikeDeliver bikeDeliver, Integer x, Integer y){
        Integer distance =  distance(bikeDeliver.getMX(), bikeDeliver.getMY(), x, y);

           BigDecimal time;
            if(distance != 0){
                time = BigDecimal.valueOf(bikeDeliver.getMSpeed()).divide(BigDecimal.valueOf(distance), 2);
            }
            else{
                time  = BigDecimal.valueOf(0);
            }

            BigDecimal money = time.multiply(BigDecimal.valueOf(0.8));
            money = money.add(bikeDeliver.getMMoney());
            money = money.add( bikeDeliver.getMCommission());
            bikeDeliver.setMMoney(money);

    }

    public BigDecimal getMoney(BikeDeliver bikeDeliver){
        return bikeDeliver.getMMoney();
    }
}
