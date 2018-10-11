package com.zspace.message.exception;

/**
 * @ClassName MessageBaseException
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/11
 */
public class MessageBaseException extends RuntimeException {

    protected String errorCode;

    public static final MessageBaseException ILLEGAL_ARGUMENT_EXCEPTION = new MessageBaseException("BS000001");

    public final MessageBaseException newInstance(String message) {
        return new MessageBaseException(message, errorCode);
    }

    private MessageBaseException(String errorCode) {
        this.errorCode = errorCode;
    }

    private MessageBaseException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
