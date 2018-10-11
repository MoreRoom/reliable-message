package com.zspace.message.entity;

import com.zspace.message.enumtype.MessageRuleTimeUnitEnum;
import com.zspace.message.enumtype.MessageStatusEnum;

import java.util.Date;

/**
 * @ClassName MessageRecordEntity
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/9
 */
public class MessageRecordEntity {
    private Integer id;
    private Date createTime;
    private Date lastModifyTime;
    private Integer version;
    /**
     * 业务发起方名称
     */
    private String businessInitiatorName;
    /**
     * 消息体
     * json格式
     */
    private String messageBodyJson;
    /**
     * 消息状态
     */
    private MessageStatusEnum messageStatus;
    /**
     * 消息队列名称
     */
    private String queueName;
    /**
     * 发送次数
     */
    private Integer sendCount;
    /**
     * 最后发送时间
     */
    private Date lastSendTime;
    /**
     * 发送规则json
     */
    private String sendRuleJson;
    /**
     * 规则时间单位
     */
    private MessageRuleTimeUnitEnum timeUnit;
    /**
     * 业务名称
     */
    private String businessName;
    /**
     * 最大重发次数
     */
    private Integer maxResendCount;

    /**
     * 唯一性标识
     */
    private String uniqueIdentification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getBusinessInitiatorName() {
        return businessInitiatorName;
    }

    public void setBusinessInitiatorName(String businessInitiatorName) {
        this.businessInitiatorName = businessInitiatorName;
    }

    public String getMessageBodyJson() {
        return messageBodyJson;
    }

    public void setMessageBodyJson(String messageBodyJson) {
        this.messageBodyJson = messageBodyJson;
    }

    public MessageStatusEnum getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(MessageStatusEnum messageStatus) {
        this.messageStatus = messageStatus;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public Integer getSendCount() {
        return sendCount;
    }

    public void setSendCount(Integer sendCount) {
        this.sendCount = sendCount;
    }

    public Date getLastSendTime() {
        return lastSendTime;
    }

    public void setLastSendTime(Date lastSendTime) {
        this.lastSendTime = lastSendTime;
    }

    public String getSendRuleJson() {
        return sendRuleJson;
    }

    public void setSendRuleJson(String sendRuleJson) {
        this.sendRuleJson = sendRuleJson;
    }

    public MessageRuleTimeUnitEnum getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(MessageRuleTimeUnitEnum timeUnit) {
        this.timeUnit = timeUnit;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public Integer getMaxResendCount() {
        return maxResendCount;
    }

    public void setMaxResendCount(Integer maxResendCount) {
        this.maxResendCount = maxResendCount;
    }

    public String getUniqueIdentification() {
        return uniqueIdentification;
    }

    public void setUniqueIdentification(String uniqueIdentification) {
        this.uniqueIdentification = uniqueIdentification;
    }
}
