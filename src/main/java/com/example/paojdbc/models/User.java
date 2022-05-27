package com.example.paojdbc.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class User {
    private String mName;
    private Integer mId;
    private String mPassword;
    private String mEmail;
    private Integer mX;
    private Integer mY;

    private List<Product> mBasket;

    private Venue mOnRestaurant;

    public User(){
        mBasket = new ArrayList<>();
    }
    public User(String m_name, String m_password, String m_email, Integer x, Integer y) {
        mName = m_name;
        mPassword = m_password;
        mEmail = m_email;
        mX = x;
        mY = y;
        mBasket =  new ArrayList<>();
    }
}
