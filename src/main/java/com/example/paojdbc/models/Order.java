package com.example.paojdbc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int mIdOrder;
    private int mIdUser;
    private int mIdDeliver;
    private int mIdVenue;
    private String mProducts;

}
