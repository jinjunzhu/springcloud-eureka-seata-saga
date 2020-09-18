create table seata_state_machine_def
(
    id               varchar(32)  not null comment 'id',
    name             varchar(128) not null comment 'name',
    tenant_id        varchar(32)  not null comment 'tenant id',
    app_name         varchar(32)  not null comment 'application name',
    type             varchar(20) comment 'state language type',
    comment_         varchar(255) comment 'comment',
    ver              varchar(16)  not null comment 'version',
    gmt_create       timestamp(3)    not null comment 'create time',
    status           varchar(2)   not null comment 'status(AC:active|IN:inactive)',
    content          longtext comment 'content',
    recover_strategy varchar(16) comment 'transaction recover strategy(compensate|retry)',
    primary key (id)
);

CREATE TABLE seata_state_machine_inst
(
    id                  VARCHAR(128) NOT NULL COMMENT 'id',
    machine_id          VARCHAR(32) NOT NULL COMMENT 'state machine definition id',
    tenant_id           VARCHAR(32) NOT NULL COMMENT 'tenant id',
    parent_id           VARCHAR(128) COMMENT 'parent id',
    gmt_started         TIMESTAMP(3)   NOT NULL COMMENT 'start time',
    business_key        VARCHAR(48) COMMENT 'business key',
    start_params        LONGTEXT COMMENT 'start parameters',
    gmt_end             TIMESTAMP(3) COMMENT 'end time',
    excep               BLOB COMMENT 'exception',
    end_params          LONGTEXT COMMENT 'end parameters',
    STATUS              VARCHAR(2) COMMENT 'status(SU succeed|FA failed|UN unknown|SK skipped|RU running)',
    compensation_status VARCHAR(2) COMMENT 'compensation status(SU succeed|FA failed|UN unknown|SK skipped|RU running)',
    is_running          TINYINT(1) COMMENT 'is running(0 no|1 yes)',
    gmt_updated         TIMESTAMP(3)   NOT NULL,
    PRIMARY KEY (id),
    UNIQUE KEY unikey_buz_tenant (business_key, tenant_id)
);

CREATE TABLE seata_state_inst
(
    id                       VARCHAR(48)  NOT NULL COMMENT 'id',
    machine_inst_id          VARCHAR(128)  NOT NULL COMMENT 'state machine instance id',
    NAME                     VARCHAR(128) NOT NULL COMMENT 'state name',
    TYPE                     VARCHAR(20) COMMENT 'state type',
    service_name             VARCHAR(128) COMMENT 'service name',
    service_method           VARCHAR(128) COMMENT 'method name',
    service_type             VARCHAR(16) COMMENT 'service type',
    business_key             VARCHAR(48) COMMENT 'business key',
    state_id_compensated_for VARCHAR(50) COMMENT 'state compensated for',
    state_id_retried_for     VARCHAR(50) COMMENT 'state retried for',
    gmt_started              TIMESTAMP(3)    NOT NULL COMMENT 'start time',
    is_for_update            TINYINT(1) COMMENT 'is service for update',
    input_params             LONGTEXT COMMENT 'input parameters',
    output_params            LONGTEXT COMMENT 'output parameters',
    STATUS                   VARCHAR(2)   NOT NULL COMMENT 'status(SU succeed|FA failed|UN unknown|SK skipped|RU running)',
    excep                    BLOB COMMENT 'exception',
    gmt_end                  TIMESTAMP(3) COMMENT 'end time',
    PRIMARY KEY (id, machine_inst_id)
);