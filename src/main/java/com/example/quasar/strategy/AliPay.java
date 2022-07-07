package com.example.quasar.strategy;

/**
 * @author hao.wong
 * @create 2022/7/7
 */
public class AliPay implements Pay{

    @Override
    public void createOrder() {
        System.err.println("Ali Create Order Success~");
    }

    @Override
    public void pay() {
        System.err.println("Ali Pay Success~");
    }

    @Override
    public void callback() {
        System.err.println("Ali Callback Success~");
    }
}
