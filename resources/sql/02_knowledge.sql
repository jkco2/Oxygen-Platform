-- 知识空间与知识内容表

CREATE TABLE knowledge_space (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    space_name  VARCHAR(128) NOT NULL,
    space_code  VARCHAR(64)  NOT NULL,
    description VARCHAR(500)          DEFAULT NULL,
    visibility  VARCHAR(32)  NOT NULL DEFAULT 'PUBLIC',
    owner_id    BIGINT       NOT NULL,
    status      VARCHAR(32)  NOT NULL DEFAULT 'ACTIVE',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted     TINYINT      NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    UNIQUE KEY uk_knowledge_space_code (space_code),
    KEY idx_knowledge_space_owner (owner_id),
    CONSTRAINT fk_knowledge_space_owner
        FOREIGN KEY (owner_id) REFERENCES sys_user (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识空间';

CREATE TABLE knowledge_space_member (
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    space_id    BIGINT      NOT NULL,
    user_id     BIGINT      NOT NULL,
    status      VARCHAR(32) NOT NULL DEFAULT 'NORMAL',
    join_time   DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    create_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_space_member (space_id, user_id),
    KEY idx_space_member_user (user_id),
    CONSTRAINT fk_space_member_space
        FOREIGN KEY (space_id) REFERENCES knowledge_space (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_space_member_user
        FOREIGN KEY (user_id) REFERENCES sys_user (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识空间成员';

CREATE TABLE knowledge_base (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    space_id    BIGINT       NOT NULL,
    kb_name     VARCHAR(128) NOT NULL,
    description VARCHAR(500)          DEFAULT NULL,
    cover_url   VARCHAR(255)          DEFAULT NULL,
    visibility  VARCHAR(32)  NOT NULL DEFAULT 'PRIVATE',
    owner_id    BIGINT       NOT NULL,
    status      VARCHAR(32)  NOT NULL DEFAULT 'ACTIVE',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted     TINYINT      NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    KEY idx_knowledge_base_space (space_id),
    KEY idx_knowledge_base_owner (owner_id),
    CONSTRAINT fk_knowledge_base_space
        FOREIGN KEY (space_id) REFERENCES knowledge_space (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_knowledge_base_owner
        FOREIGN KEY (owner_id) REFERENCES sys_user (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识库';

CREATE TABLE knowledge_article (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    kb_id       BIGINT       NOT NULL,
    space_id    BIGINT       NOT NULL,
    title       VARCHAR(200) NOT NULL,
    summary     VARCHAR(500)          DEFAULT NULL,
    content     LONGTEXT     NOT NULL,
    author_id   BIGINT       NOT NULL,
    status      VARCHAR(32)  NOT NULL DEFAULT 'DRAFT',
    view_count  INT          NOT NULL DEFAULT 0,
    like_count  INT          NOT NULL DEFAULT 0,
    version     INT          NOT NULL DEFAULT 1,
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted     TINYINT      NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    KEY idx_article_kb (kb_id),
    KEY idx_article_space (space_id),
    KEY idx_article_author (author_id),
    KEY idx_article_status (status),
    CONSTRAINT fk_knowledge_article_kb
        FOREIGN KEY (kb_id) REFERENCES knowledge_base (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_knowledge_article_space
        FOREIGN KEY (space_id) REFERENCES knowledge_space (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_knowledge_article_author
        FOREIGN KEY (author_id) REFERENCES sys_user (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识条目';

CREATE TABLE knowledge_document (
    id           BIGINT       NOT NULL AUTO_INCREMENT,
    kb_id        BIGINT       NOT NULL,
    space_id     BIGINT       NOT NULL,
    uploader_id  BIGINT       NOT NULL,
    file_name    VARCHAR(255) NOT NULL,
    file_url     VARCHAR(500) NOT NULL,
    file_type    VARCHAR(32)  NOT NULL,
    file_size    BIGINT       NOT NULL,
    parse_status VARCHAR(32)  NOT NULL DEFAULT 'PENDING',
    parse_error  TEXT                  DEFAULT NULL,
    version      INT          NOT NULL DEFAULT 1,
    status       VARCHAR(32)  NOT NULL DEFAULT 'DRAFT',
    create_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time  DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted      TINYINT      NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    KEY idx_document_kb (kb_id),
    KEY idx_document_space (space_id),
    KEY idx_document_uploader (uploader_id),
    KEY idx_document_parse_status (parse_status),
    CONSTRAINT fk_knowledge_document_kb
        FOREIGN KEY (kb_id) REFERENCES knowledge_base (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_knowledge_document_space
        FOREIGN KEY (space_id) REFERENCES knowledge_space (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_knowledge_document_uploader
        FOREIGN KEY (uploader_id) REFERENCES sys_user (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识文档';

CREATE TABLE knowledge_tag (
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    space_id    BIGINT      NOT NULL,
    tag_name    VARCHAR(64) NOT NULL,
    color       VARCHAR(32)          DEFAULT NULL,
    create_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted     TINYINT     NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    UNIQUE KEY uk_space_tag (space_id, tag_name),
    CONSTRAINT fk_knowledge_tag_space
        FOREIGN KEY (space_id) REFERENCES knowledge_space (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识标签';

CREATE TABLE knowledge_article_tag (
    id          BIGINT   NOT NULL AUTO_INCREMENT,
    article_id  BIGINT   NOT NULL,
    tag_id      BIGINT   NOT NULL,
    create_time DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_article_tag (article_id, tag_id),
    KEY idx_article_tag_tag (tag_id),
    CONSTRAINT fk_article_tag_article
        FOREIGN KEY (article_id) REFERENCES knowledge_article (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_article_tag_tag
        FOREIGN KEY (tag_id) REFERENCES knowledge_tag (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '知识条目标签关联';
