package com.example.quasar.fiber;

import lombok.Builder;
import lombok.Data;

/**
 * @author hao.wong
 * @create 2022/6/13
 */
@Builder
@Data
public class Msg {
    private long accuntId;
    private String  json;

}
