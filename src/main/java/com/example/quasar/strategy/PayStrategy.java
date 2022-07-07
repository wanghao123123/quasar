package com.example.quasar.strategy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author hao.wong
 * @create 2022/7/7
 */

public class PayStrategy {
    private Pay pay;


    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public PayStrategy(Pay pay) {
        this.pay = pay;
    }

    public PayStrategy() {

    }

    public void pay(){
        pay.pay();
    }
    public void order(){
        pay.createOrder();
    }
    public void callback(){
        pay.callback();
    }

}
