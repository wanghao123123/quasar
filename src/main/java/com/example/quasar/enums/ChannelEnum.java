package com.example.quasar.enums;

/**
 * @author hao.wong
 * @create 2022/6/13
 */
public enum ChannelEnum {
    Inventory(1,"扣库存");

    public Integer type;
    public String note;


    ChannelEnum(Integer type, String note) {
        this.type = type;
        this.note = note;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
