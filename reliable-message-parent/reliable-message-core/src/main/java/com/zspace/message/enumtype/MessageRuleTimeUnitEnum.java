package com.zspace.message.enumtype;

/**
 * @ClassName MessageRuleTimeUnitEnum
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/10
 */
public enum MessageRuleTimeUnitEnum {

    MINUTE("分钟"),

    SECOND("秒");

    private String description;

    MessageRuleTimeUnitEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
