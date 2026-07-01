-- System users and scoped RBAC tables

CREATE TABLE sys_user (
    id              BIGINT       NOT NULL AUTO_INCREMENT,
    username        VARCHAR(64)  NOT NULL,
    password        VARCHAR(255) NOT NULL,
    nickname        VARCHAR(64)  NOT NULL,
    email           VARCHAR(128)          DEFAULT NULL,
    phone           VARCHAR(32)           DEFAULT NULL,
    avatar          VARCHAR(255)          DEFAULT NULL,
    status          VARCHAR(32)  NOT NULL DEFAULT 'ACTIVE',
    last_login_time DATETIME              DEFAULT NULL,
    create_time     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted         TINYINT      NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    UNIQUE KEY uk_sys_user_username (username),
    UNIQUE KEY uk_sys_user_email (email),
    UNIQUE KEY uk_sys_user_phone (phone)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'system user';

CREATE TABLE sys_role (
    id          BIGINT       NOT NULL AUTO_INCREMENT,
    role_code   VARCHAR(64)  NOT NULL,
    role_name   VARCHAR(64)  NOT NULL,
    description VARCHAR(255)          DEFAULT NULL,
    scope_type  VARCHAR(32)  NOT NULL DEFAULT 'GLOBAL',
    status      VARCHAR(32)  NOT NULL DEFAULT 'ACTIVE',
    create_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted     TINYINT      NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    UNIQUE KEY uk_sys_role_code (role_code),
    KEY idx_sys_role_scope (scope_type)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'role';

CREATE TABLE sys_permission (
    id              BIGINT        NOT NULL AUTO_INCREMENT,
    permission_code VARCHAR(128)  NOT NULL,
    permission_name VARCHAR(64)   NOT NULL,
    resource_type   VARCHAR(32)   NOT NULL,
    description     VARCHAR(255)           DEFAULT NULL,
    status          VARCHAR(32)   NOT NULL DEFAULT 'ACTIVE',
    create_time     DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    update_time     DATETIME      NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    deleted         TINYINT       NOT NULL DEFAULT 0,
    PRIMARY KEY (id),
    UNIQUE KEY uk_sys_permission_code (permission_code)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'permission';

CREATE TABLE sys_user_role (
    id          BIGINT      NOT NULL AUTO_INCREMENT,
    user_id     BIGINT      NOT NULL,
    role_id     BIGINT      NOT NULL,
    scope_type  VARCHAR(32) NOT NULL DEFAULT 'GLOBAL',
    scope_id    BIGINT               DEFAULT NULL,
    create_time DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_user_role_scope (user_id, role_id, scope_type, scope_id),
    KEY idx_user_role_scope (scope_type, scope_id),
    KEY idx_user_role_role (role_id),
    CONSTRAINT fk_user_role_user
        FOREIGN KEY (user_id) REFERENCES sys_user (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_user_role_role
        FOREIGN KEY (role_id) REFERENCES sys_role (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'user scoped role assignment';

CREATE TABLE sys_role_permission (
    id            BIGINT   NOT NULL AUTO_INCREMENT,
    role_id       BIGINT   NOT NULL,
    permission_id BIGINT   NOT NULL,
    create_time   DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    UNIQUE KEY uk_role_permission (role_id, permission_id),
    KEY idx_role_permission_permission (permission_id),
    CONSTRAINT fk_role_permission_role
        FOREIGN KEY (role_id) REFERENCES sys_role (id)
        ON UPDATE CASCADE,
    CONSTRAINT fk_role_permission_permission
        FOREIGN KEY (permission_id) REFERENCES sys_permission (id)
        ON UPDATE CASCADE
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = 'role permission';
