package com.example.quasar.strategy;

/**
 * @author hao.wong
 * @create 2022/7/7
 */
public class WeChartPay implements Pay{
    @Override
    public void createOrder() {
        System.err.println("WeChart Create Order Success~");
    }

    @Override
    public void pay() {
        System.err.println("WeChart Pay Success~");
    }

    @Override
    public void callback() {
        System.err.println("WeChart Callback Success~");
    }
}
