package com.example.quasar.strategy;

/**
 * @author hao.wong
 * @create 2022/7/7
 */
public class Test {


    public static void main(String[] args) {
        PayStrategy payStrategy = new PayStrategy(new AliPay());
        payStrategy.order();
        payStrategy.pay();
        payStrategy.callback();
    }
}
