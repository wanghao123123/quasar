package com.example.quasar.fiber;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.channels.Channel;

/**
 * @author hao.wong
 * @create 2022/3/21
 */
public class ClientFiber extends Fiber<Integer> {


    //
    private Channel<String> channel;


    public Channel<String> getChannel() {
        return channel;
    }

    public void setChannel(Channel<String> channel) {
        this.channel = channel;
    }

    public ClientFiber(Channel channel) {
        this.channel = channel;
    }

    @Override
    protected Integer run() throws SuspendExecution, InterruptedException {
       while (true) {
            String receive = channel.receive();//接收的是MessageLiteData，其中有消息头
           System.err.println(receive);
           //统一数据处理
            Message.onGetProtoBufMessage(receive);

        }
    }
}
