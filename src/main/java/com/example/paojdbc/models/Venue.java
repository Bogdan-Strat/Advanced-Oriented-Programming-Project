package com.example.paojdbc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venue {
    private int mId;
    private String mName;

    private Integer mX;
    private Integer mY;
}
