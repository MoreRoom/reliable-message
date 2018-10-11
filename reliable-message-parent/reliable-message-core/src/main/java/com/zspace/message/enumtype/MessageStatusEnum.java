package com.zspace.message.enumtype;

/**
 * @ClassName MessageStatusEnum
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/10
 */
public enum MessageStatusEnum {

    INIT("待发送"),
    SEND("待确认"),
    COMPLETE("成功"),
    SEND_ERROR("发送失败"),
    SEND_CANCEL("取消发送");

    private String description;

    MessageStatusEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
