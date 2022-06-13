package com.example.quasar;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.channels.Channel;
import co.paralleluniverse.strands.channels.Channels;
import com.example.quasar.enums.ChannelEnum;
import com.example.quasar.fiber.InventoryClientFiber;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class QuasarApplicationTests {


    private static Map<Integer,Channel> idToChannel =new HashMap<>();

    @Test
    void contextLoads() {
    }




}
