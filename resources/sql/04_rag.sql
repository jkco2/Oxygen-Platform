-- RAG 检索增强相关表

CREATE TABLE document_chunk (
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    source_type VARCHAR(32) NOT NULL,
    source_id   BIGINT      NOT NULL,
    space_id    BIGINT      NOT NULL,
    kb_id       BIGINT      NOT NULL,
    chunk_index INT         NOT NULL,
    content     TEXT        NOT NULL,
    token_count INT                  DEFAULT NULL,
    status      VARCHAR(32) NOT NULL DEFAULT 'ACTIVE',
    create_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_chunk_source (source_type, source_id),
    KEY idx_chunk_space_kb (space_id, kb_id),
    KEY idx_chunk_status (status),
    CONSTRAINT fk_document_chunk_space
        FOREIGN KEY (space_id) REFERENCES knowledge_space (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_document_chunk_kb
        FOREIGN KEY (kb_id) REFERENCES knowledge_base (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识片段';

CREATE TABLE embedding_record (
    id           BIGINT       NOT NULL AUTO_INCREMENT,
    chunk_id     BIGINT       NOT NULL,
    embedding_id VARCHAR(128) NOT NULL,
    model_name   VARCHAR(128) NOT NULL,
    dimension    INT          NOT NULL,
    status       VARCHAR(32)  NOT NULL DEFAULT 'ACTIVE',
    create_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_embedding_id (embedding_id),
    KEY idx_embedding_chunk (chunk_id),
    CONSTRAINT fk_embedding_record_chunk
        FOREIGN KEY (chunk_id) REFERENCES document_chunk (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '向量记录';

CREATE TABLE answer_citation (
    id           BIGINT       NOT NULL AUTO_INCREMENT,
    message_id   BIGINT       NOT NULL,
    chunk_id     BIGINT       NOT NULL,
    source_type  VARCHAR(32)  NOT NULL,
    source_id    BIGINT       NOT NULL,
    source_title VARCHAR(255) NOT NULL,
    score        DOUBLE                DEFAULT NULL,
    quote_text   TEXT                  DEFAULT NULL,
    create_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    KEY idx_citation_message (message_id),
    KEY idx_citation_chunk (chunk_id),
    CONSTRAINT fk_answer_citation_message
        FOREIGN KEY (message_id) REFERENCES chat_message (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_answer_citation_chunk
        FOREIGN KEY (chunk_id) REFERENCES document_chunk (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '回答引用';
