package com.example.quasar.strategy;

/**
 * @author hao.wong
 * @create 2022/7/7
 */
public interface Pay {


    /**
     * 创建订单
     */
    void createOrder();

    /**
     * 支付
     */
    void pay();

    /**
     * 回调
     */
    void callback();

}
