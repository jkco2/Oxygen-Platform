-- 操作审计日志表

CREATE TABLE operation_log (
    id             BIGINT       NOT NULL AUTO_INCREMENT,
    user_id        BIGINT                DEFAULT NULL,
    operation_type VARCHAR(32)  NOT NULL,
    resource_type  VARCHAR(32)  NOT NULL,
    resource_id    BIGINT                DEFAULT NULL,
    description    VARCHAR(500)          DEFAULT NULL,
    ip_address     VARCHAR(64)           DEFAULT NULL,
    user_agent     VARCHAR(500)          DEFAULT NULL,
    create_time    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_operation_log_user (user_id),
    KEY idx_operation_log_resource (resource_type, resource_id),
    KEY idx_operation_log_create_time (create_time),
    CONSTRAINT fk_operation_log_user
        FOREIGN KEY (user_id) REFERENCES sys_user (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '操作日志';
