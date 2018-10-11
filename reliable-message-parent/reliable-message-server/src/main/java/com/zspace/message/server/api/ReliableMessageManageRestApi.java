package com.zspace.message.server.api;

import com.zspace.message.biz.CommandInvoker;
import com.zspace.message.command.Commands;
import com.zspace.message.exception.MessageBaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ReliableMessageManageRestApi
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/9
 */
@RestController
public class ReliableMessageManageRestApi {

    private static final Logger logger = LoggerFactory.getLogger(ReliableMessageManageRestApi.class);


    // TODO 考虑是否将queue字段去掉  将其通过页面进行配置
    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public String initMessage(
            @RequestParam("initiatorName") String businessInitiatorName,
            @RequestParam("businessName") String businessName,
            @RequestParam("messageBody") String messageBodyJson,
            @RequestParam("uniqueIdentification") String uniqueIdentification) {
        if (logger.isDebugEnabled()) {
            logger.debug("get init message request, initiatorName:{}, uniqueIdentification:{}, businessName:{}, messageBody:{}"
                    , businessInitiatorName, uniqueIdentification, businessName, messageBodyJson);
        }
        try {
            Assert.isTrue(!StringUtils.isEmpty(businessInitiatorName), "initiatorName");
            Assert.isTrue(!StringUtils.isEmpty(uniqueIdentification), "uniqueIdentification");
            Assert.isTrue(!StringUtils.isEmpty(businessName), "businessName");
            Assert.isTrue(!StringUtils.isEmpty(messageBodyJson), "messageBody");
        } catch (Exception e) {
            throw MessageBaseException.ILLEGAL_ARGUMENT_EXCEPTION.newInstance("请求参数不合法.");
        }

        CommandInvoker.executeCommand(Commands.INIT(businessInitiatorName, uniqueIdentification, businessName, messageBodyJson));
        return "SUCCESS";
    }

    public void sendMessage(
            @RequestParam("initiatorName") String businessInitiatorName,
            @RequestParam("businessName") String businessName,
            @RequestParam("uniqueIdentification") String uniqueIdentification) {
        if (logger.isDebugEnabled()) {
            logger.debug("get send message request, initiatorName:{}, uniqueIdentification:{}, businessName:{}"
                    , businessInitiatorName, uniqueIdentification, businessName);
        }
        try {
            Assert.isTrue(!StringUtils.isEmpty(businessInitiatorName), "initiatorName");
            Assert.isTrue(!StringUtils.isEmpty(businessName), "businessName");
            Assert.isTrue(!StringUtils.isEmpty(uniqueIdentification), "uniqueIdentification");
        } catch (Exception e) {
            throw MessageBaseException.ILLEGAL_ARGUMENT_EXCEPTION.newInstance("请求参数不合法.");
        }
        CommandInvoker.executeCommand(Commands.SEND(businessInitiatorName, uniqueIdentification, businessName));
    }

    // TODO 6. 消息确认 - 消息状态置为 COMPLETE 业务完成。

}
