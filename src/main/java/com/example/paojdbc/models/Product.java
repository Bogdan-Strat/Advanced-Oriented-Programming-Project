package com.example.paojdbc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    protected Integer mId;
    protected String mName;
    protected Integer mPortions;
    protected Integer mPrice;
    protected Integer mVenue;
}
