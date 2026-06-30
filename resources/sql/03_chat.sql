-- Agent 会话与消息表

CREATE TABLE chat_session (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    user_id     BIGINT       NOT NULL,
    space_id    BIGINT       NOT NULL,
    kb_id       BIGINT                DEFAULT NULL,
    title       VARCHAR(200) NOT NULL,
    agent_type  VARCHAR(32)  NOT NULL,
    status      VARCHAR(32)  NOT NULL DEFAULT 'NORMAL',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_chat_session_user (user_id),
    KEY idx_chat_session_space (space_id),
    KEY idx_chat_session_kb (kb_id),
    CONSTRAINT fk_chat_session_user
        FOREIGN KEY (user_id) REFERENCES sys_user (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_chat_session_space
        FOREIGN KEY (space_id) REFERENCES knowledge_space (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_chat_session_kb
        FOREIGN KEY (kb_id) REFERENCES knowledge_base (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'Agent 会话';

CREATE TABLE chat_message (
    id                BIGINT   NOT NULL AUTO_INCREMENT,
    session_id        BIGINT   NOT NULL,
    sender_type       VARCHAR(32) NOT NULL,
    content           LONGTEXT NOT NULL,
    model_name        VARCHAR(128) DEFAULT NULL,
    prompt_tokens     INT          DEFAULT NULL,
    completion_tokens INT          DEFAULT NULL,
    latency_ms        BIGINT       DEFAULT NULL,
    status            VARCHAR(32)  NOT NULL DEFAULT 'SUCCESS',
    error_message     TEXT         DEFAULT NULL,
    create_time       DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_chat_message_session (session_id),
    KEY idx_chat_message_create_time (create_time),
    CONSTRAINT fk_chat_message_session
        FOREIGN KEY (session_id) REFERENCES chat_session (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'Agent 消息';
