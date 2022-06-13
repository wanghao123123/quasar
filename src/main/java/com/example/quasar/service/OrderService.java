package com.example.quasar.service;

import com.example.quasar.annotation.Processor;
import com.example.quasar.dto.OrderAdd;
import org.springframework.stereotype.Service;

/**
 * @author hao.wong
 * @create 2022/3/24
 */
@Service
public class OrderService {


    @Processor(serviceType = 1)
    public String add(OrderAdd add){

        return "Order.add";
    }

    @Processor(serviceType = 1)
    public String update(){
        return "Order.update";
    }
}
