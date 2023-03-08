package com.api.Enums;

import com.baomidou.mybatisplus.annotation.IEnum;

public enum Sex implements IEnum<Integer> {
    CONCEAL(0, "隐藏"),
    MAN(1, "男"),
    WOMAN(2, "女");
    private final int value;
    private final String desc;
    Sex (int value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    @Override
    public Integer getValue() {
        return this.value;
    }
}
