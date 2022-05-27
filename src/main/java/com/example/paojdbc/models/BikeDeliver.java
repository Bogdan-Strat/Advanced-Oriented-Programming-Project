package com.example.paojdbc.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class BikeDeliver extends Deliver{
    private BigDecimal mCommission;

    private Integer mSpeed = 40;

    public BikeDeliver(String name, Integer x, Integer y, BigDecimal commission) {
        super(name, x, y);
        mCommission = commission;
    }
}
