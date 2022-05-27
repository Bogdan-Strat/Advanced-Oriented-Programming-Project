package com.example.paojdbc.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
public class Deliver {
    protected Integer mId;
    protected String mName;
    protected Integer mX;
    protected Integer mY;
    protected Boolean mFree;

    protected BigDecimal mMoney;

    public Deliver(String m_name, Integer m_x, Integer m_y) {
        this.mName = m_name;
        this.mX = m_x;
        this.mY = m_y;
        mFree = Boolean.TRUE;
    }
}
