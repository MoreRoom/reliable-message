CREATE TABLE
    MESSAGE_RECORD
    (
        ID INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
        CREATE_TIME DATETIME COMMENT '创建时间',
        LAST_MODIFY_TIME DATETIME COMMENT '修改时间',
        VERSION INT COMMENT '版本',
        BUSINESS_INITIATOR_NAME VARCHAR(32) NOT NULL COMMENT '业务发起方',
        BUSINESS_NAME VARCHAR(32) NOT NULL COMMENT '业务名称',
        UNIQUE_IDENTIFICATION_JSON VARCHAR(256) COMMENT '查询时候用到的唯一性参数',
        MESSAGE_BODY_JSON VARCHAR(2048) NOT NULL COMMENT '消息体对应的JSON',
        MESSAGE_STATUS VARCHAR(32) NOT NULL COMMENT '消息状态',
        QUEUE_NAME VARCHAR(64) NOT NULL COMMENT '消息队列名',
        SEND_COUNT INT COMMENT '消息发送次数',
        LAST_SEND_TIME DATETIME COMMENT '最后发送时间',
        SEND_RULE_JSON VARCHAR(512) NOT NULL COMMENT '发送规则JSON',
        TIME_UNIT VARCHAR(16) NOT NULL COMMENT '时间单位',
        MAX_RESEND_COUNT INT NOT NULL COMMENT '最大重试次数'
    ) ENGINE=INNODB DEFAULT charset=utf8;