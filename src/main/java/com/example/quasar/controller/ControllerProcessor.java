package com.example.quasar.controller;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;
import com.alibaba.fastjson.JSONObject;
import com.example.quasar.Test;
import com.example.quasar.annotation.Req;
import com.example.quasar.annotation.Resp;
import com.example.quasar.dto.OrderAdd;
import com.example.quasar.enums.ChannelEnum;
import com.example.quasar.envent.ApplicationStartedProcessorEvent;
import com.example.quasar.fiber.InventoryClientFiber;
import com.example.quasar.fiber.Msg;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author hao.wong
 * @create 2022/3/24
 */
@RequestMapping("/api")
@RestController
public class ControllerProcessor {


    @PostMapping("/main")
    public Resp main(@RequestBody Req req) {
        //todo req.msg 需要序列化为json字符串
        Method method = ApplicationStartedProcessorEvent.idToMethod.get(req.serviceType);
        Object o = ApplicationStartedProcessorEvent.idToClass.get(req.serviceType);
        try {
            Object invoke;
            System.err.println(req.getMsg());
            if (method.getParameterCount() <= 0) {
                invoke = method.invoke(o);
            } else {
                Class<?>[] parameterTypes = method.getParameterTypes();
                Class<?> paramsClass = parameterTypes[0];

                Object o1 = JSONObject.parseObject(req.msg, paramsClass);
                invoke = method.invoke(o, o1);
            }
            return new Resp(invoke);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return new Resp();
    }


    @GetMapping("/fiber")
    public void test(){

        if(!Test.idToChannel.containsKey(ChannelEnum.Inventory.getType())){
            new InventoryClientFiber();
        }

        new Fiber<Void>(()->{
            Channel channel = Test.idToChannel.get(ChannelEnum.Inventory.getType());
            channel.send(Msg.builder()
                    .accuntId(1)
                    .json("dhajdjhahdja")
                    .build());
        }).start();

        new Fiber<Integer>() {
            @Override
            protected Integer run() throws SuspendExecution, InterruptedException {
                // your code
                Channel channel = Test.idToChannel.get(ChannelEnum.Inventory.getType());
                channel.send(Msg.builder()
                        .accuntId(2)
                        .json("dhajdjhahdja")
                        .build());
                return 1;
            }
        }.start();

        new Fiber<Integer>() {
            @Override
            protected Integer run() throws SuspendExecution, InterruptedException {
                // your code
                Channel channel = Test.idToChannel.get(ChannelEnum.Inventory.getType());
                channel.send(Msg.builder()
                        .accuntId(3)
                        .json("dhajdjhahdja")
                        .build());
                return 1;
            }
        }.start();



        new Fiber<Integer>() {
            @Override
            protected Integer run() throws SuspendExecution, InterruptedException {
                // your code
                Channel channel = Test.idToChannel.get(ChannelEnum.Inventory.getType());
                channel.send(Msg.builder()
                        .accuntId(4)
                        .json("dhajdjhahdja")
                        .build());
                return 1;
            }
        }.start();


        new Fiber<Integer>() {
            @Override
            protected Integer run() throws SuspendExecution, InterruptedException {
                // your code
                Channel channel = Test.idToChannel.get(ChannelEnum.Inventory.getType());
                channel.send(Msg.builder()
                        .accuntId(5)
                        .json("dhajdjhahdja")
                        .build());
                return 1;
            }
        }.start();


    }


}
