package com.example.quasar.fiber;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hao.wong
 * @create 2022/3/21
 */
@Slf4j
public class Message {


    private static Integer goodsSize;

    public static void onGetProtoBufMessage(String msg){
        System.err.println(msg);

    }


    //扣库存
    public static void xxxx(Long accountId,String msg){
        if(goodsSize==null){
            //todo 查询db
            goodsSize=3;
        }

        if(goodsSize>0){
            log.error("用户：【{}】,库存：【{}】",accountId,goodsSize);
        }
        goodsSize--;
    }
}
