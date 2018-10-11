package com.zspace.message.service;

/**
 * @ClassName MessageRecordService
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/10
 */
public interface MessageRecordService {

    public Boolean initMessageRecord(String businessInitiatorName, String uniqueIdentification, String businessName, String messageBodyJson);


}
