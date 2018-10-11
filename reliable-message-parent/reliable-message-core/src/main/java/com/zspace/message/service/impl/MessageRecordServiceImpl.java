package com.zspace.message.service.impl;

import com.zspace.message.dao.MessageRecordDao;
import com.zspace.message.entity.MessageRecordEntity;
import com.zspace.message.enumtype.MessageRuleTimeUnitEnum;
import com.zspace.message.enumtype.MessageStatusEnum;
import com.zspace.message.service.MessageRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName MessageRecordServiceImpl
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/10
 */
@Service
public class MessageRecordServiceImpl implements MessageRecordService {

    @Resource
    private MessageRecordDao messageRecordDao;

    @Override
    public Boolean initMessageRecord(String businessInitiatorName, String uniqueIdentification, String businessName, String messageBodyJson) {
        MessageRecordEntity messageRecordEntity = new MessageRecordEntity();
        messageRecordEntity.setBusinessInitiatorName(businessInitiatorName);
        messageRecordEntity.setBusinessName(businessName);
        messageRecordEntity.setMessageBodyJson(messageBodyJson);
        messageRecordEntity.setMessageStatus(MessageStatusEnum.INIT);
        messageRecordEntity.setUniqueIdentification(uniqueIdentification);
        messageRecordEntity.setSendCount(0);
        // TODO 需要查询基础配置
        messageRecordEntity.setMaxResendCount(5);
        messageRecordEntity.setSendRuleJson("{1:1,2:1,3:1,4:1}");
        messageRecordEntity.setTimeUnit(MessageRuleTimeUnitEnum.MINUTE);
        messageRecordEntity.setQueueName("AQueue");
        return messageRecordDao.insertMessageRecord(messageRecordEntity) == 1;
    }

}
