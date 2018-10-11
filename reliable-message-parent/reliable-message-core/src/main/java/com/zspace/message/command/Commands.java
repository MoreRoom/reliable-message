package com.zspace.message.command;

import com.zspace.message.biz.MessageCommandReceiver;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @ClassName Commands
 * @Description 命令集合工具类 用于获取对应的命令
 * @Author MoreRoom
 * @Since 2018/10/9
 */
@Component
public class Commands implements ApplicationListener<ContextRefreshedEvent>, ApplicationContextAware {

    private ApplicationContext applicationContext;

    private static MessageCommandReceiver messageCommandReceiver;

    public static Command INIT(String businessInitiatorName, String uniqueIdentification, String businessName, String messageBodyJson) {
        return new InitCommand(messageCommandReceiver, businessInitiatorName, uniqueIdentification, businessName, messageBodyJson);
    }

    public static Command SEND(String businessInitiatorName, String uniqueIdentification, String businessName) {
        return new SendCommand(messageCommandReceiver, businessInitiatorName, uniqueIdentification, businessName);
    }

    public static Command COMPLETE() {
        return new CompleteCommand(messageCommandReceiver);
    }

    public static Command SEND_CANCEL() {
        return new SendCancelCommand(messageCommandReceiver);
    }

    public static Command SEND_ERROR() {
        return new SendErrorCommand(messageCommandReceiver);
    }

    private static class InitCommand implements Command {

        private MessageCommandReceiver messageCommandReceiver;

        private String businessInitiatorName;

        private String uniqueIdentification;

        private String businessName;

        private String messageBodyJson;

        public InitCommand(MessageCommandReceiver messageCommandReceiver, String businessInitiatorName, String uniqueIdentification, String businessName, String messageBodyJson) {
            this.messageCommandReceiver = messageCommandReceiver;
            this.businessInitiatorName = businessInitiatorName;
            this.uniqueIdentification = uniqueIdentification;
            this.businessName = businessName;
            this.messageBodyJson = messageBodyJson;
        }

        @Override
        public Object execute() {
            return messageCommandReceiver.doInitMessage(businessInitiatorName, uniqueIdentification, businessName, messageBodyJson);
        }

        public String getBusinessInitiatorName() {
            return businessInitiatorName;
        }

        public void setBusinessInitiatorName(String businessInitiatorName) {
            this.businessInitiatorName = businessInitiatorName;
        }

        public String getUniqueIdentificationJson() {
            return uniqueIdentification;
        }

        public void setUniqueIdentificationJson(String uniqueIdentification) {
            this.uniqueIdentification = uniqueIdentification;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }

        public String getMessageBodyJson() {
            return messageBodyJson;
        }

        public void setMessageBodyJson(String messageBodyJson) {
            this.messageBodyJson = messageBodyJson;
        }
    }

    private static class SendCommand implements Command {

        private MessageCommandReceiver messageCommandReceiver;

        private String businessInitiatorName;

        private String uniqueIdentification;

        private String businessName;

        public SendCommand(MessageCommandReceiver messageCommandReceiver, String businessInitiatorName, String uniqueIdentification, String businessName) {
            this.messageCommandReceiver = messageCommandReceiver;
            this.businessInitiatorName = businessInitiatorName;
            this.uniqueIdentification = uniqueIdentification;
            this.businessName = businessName;
        }

        @Override
        public Object execute() {
            return messageCommandReceiver.doSendMessage(businessInitiatorName, uniqueIdentification, businessName);
        }

        public String getBusinessInitiatorName() {
            return businessInitiatorName;
        }

        public void setBusinessInitiatorName(String businessInitiatorName) {
            this.businessInitiatorName = businessInitiatorName;
        }

        public String getUniqueIdentification() {
            return uniqueIdentification;
        }

        public void setUniqueIdentification(String uniqueIdentification) {
            this.uniqueIdentification = uniqueIdentification;
        }

        public String getBusinessName() {
            return businessName;
        }

        public void setBusinessName(String businessName) {
            this.businessName = businessName;
        }
    }

    private static class CompleteCommand implements Command {
        private MessageCommandReceiver messageCommandReceiver;

        public CompleteCommand(MessageCommandReceiver messageCommandReceiver) {
            this.messageCommandReceiver = messageCommandReceiver;
        }

        @Override
        public Object execute() {
            return messageCommandReceiver.doCompleteMessage();
        }

    }

    private static class SendCancelCommand implements Command {
        private MessageCommandReceiver messageCommandReceiver;

        public SendCancelCommand(MessageCommandReceiver messageCommandReceiver) {
            this.messageCommandReceiver = messageCommandReceiver;
        }

        @Override
        public Object execute() {
            return messageCommandReceiver.doSendCancelMessage();
        }

    }

    private static class SendErrorCommand implements Command {
        private MessageCommandReceiver messageCommandReceiver;

        public SendErrorCommand(MessageCommandReceiver messageCommandReceiver) {
            this.messageCommandReceiver = messageCommandReceiver;
        }

        @Override
        public Object execute() {
            return messageCommandReceiver.doSendErrorMessage();
        }

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("消息命令接收器初始化完成.");
        messageCommandReceiver = applicationContext.getBean("commandReceiver", MessageCommandReceiver.class);
        System.out.println(messageCommandReceiver.toString());
    }
}
