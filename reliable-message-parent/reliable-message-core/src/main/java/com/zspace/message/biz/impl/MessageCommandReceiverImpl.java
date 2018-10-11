package com.zspace.message.biz.impl;

import com.zspace.message.biz.MessageCommandReceiver;
import com.zspace.message.service.MessageRecordService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @ClassName MessageCommandReceiverImpl
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/9
 */
@Component("commandReceiver")
public class MessageCommandReceiverImpl implements MessageCommandReceiver {

    @Resource
    private MessageRecordService messageRecordService;

    @Override
    public Object doInitMessage(String businessInitiatorName, String uniqueIdentification, String businessName, String messageBodyJson) {
        boolean res = messageRecordService.initMessageRecord(businessInitiatorName, uniqueIdentification, businessName, messageBodyJson);
        if (res) {
            return null;
        } else {
            throw new RuntimeException("");
        }
    }

    @Override
    public Object doSendMessage(String businessInitiatorName, String uniqueIdentification, String businessName) {
        // TODO 1. 查询对应的消息
        // TODO 2. 读取对应的要发送的mq队列名称
        // TODO 3. 发送消息
        // TODO 4. 更新消息 最后发送时间 发送次数
        return null;
    }

    @Override
    public Object doCompleteMessage() {
        return null;
    }

    @Override
    public Object doSendCancelMessage() {
        return null;
    }

    @Override
    public Object doSendErrorMessage() {
        return null;
    }

}
