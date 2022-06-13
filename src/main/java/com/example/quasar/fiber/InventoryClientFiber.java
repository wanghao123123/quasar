package com.example.quasar.fiber;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;
import com.example.quasar.Test;
import com.example.quasar.enums.ChannelEnum;
import org.springframework.stereotype.Component;

/**
 * test actor
 * @author hao.wong
 * @create 2022/6/13
 */
public class InventoryClientFiber extends Fiber<Boolean> {

    private Channel<Msg> channel;

    public InventoryClientFiber() {
        this.channel = Channels.newChannel(-1);;
        Test.idToChannel.put(ChannelEnum.Inventory.getType(), channel);
        start();
    }

    @Override
    protected Boolean run() throws SuspendExecution, InterruptedException {
        while (true) {
            //接收的是MessageLiteData，其中有消息头
            Msg receive = channel.receive();
            //统一数据处理
            Message.xxxx(receive.getAccuntId(),receive.getJson());

        }
    }
}

