package com.zspace.message.biz;

/**
 * @ClassName MessageCommandReceiver
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/9
 */
public interface MessageCommandReceiver {

    public Object doInitMessage(String businessInitiatorName, String uniqueIdentification, String businessName, String messageBodyJson);

    public Object doSendMessage(String businessInitiatorName, String uniqueIdentification, String businessName);

    public Object doCompleteMessage();

    public Object doSendCancelMessage();

    public Object doSendErrorMessage();


}
