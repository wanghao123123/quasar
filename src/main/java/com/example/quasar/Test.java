package com.example.quasar;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;
import com.example.quasar.enums.ChannelEnum;
import com.example.quasar.fiber.InventoryClientFiber;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author hao.wong
 * @create 2022/3/18
 */
public class Test {


    public static Map<Integer,Channel> idToChannel =new HashMap<>();


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        System.setProperty("-javaagent","quasar-core-0.7.9.jar");
        Channel<Object> objectChannel = Channels.newChannel(0, Channels.OverflowPolicy.BLOCK, false, false);
        if(!idToChannel.containsKey(ChannelEnum.Inventory.getType())){
            new InventoryClientFiber();
        }


        LongAdder longAdder =new LongAdder();
        for (Integer i = 1; i < 10; i++) {

            longAdder.increment();

            new Fiber<Integer>() {
                @Override
                protected Integer run() throws SuspendExecution, InterruptedException {
                    // your code
                    Channel channel = idToChannel.get(ChannelEnum.Inventory.getType());
                    channel.send(longAdder.longValue());
                    return 1;
                }
            }.start();

        }



        countDownLatch.await();
    }

}
