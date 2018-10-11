package com.zspace.message.biz;

import com.zspace.message.command.Command;

/**
 * @ClassName CommandInvoker
 * @Description TODO
 * @Author MoreRoom
 * @Since 2018/10/9
 */
public class CommandInvoker {

    public static Object executeCommand(Command command) {
        return command.execute();
    }

}
