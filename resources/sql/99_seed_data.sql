-- 初始化角色、权限与管理员账号
-- permission_code 需与 PermissionCodes 常量类保持一致

INSERT INTO sys_role (id, role_code, role_name, description, status)
VALUES (1, 'SYSTEM_ADMIN', '系统管理员', '拥有全部系统级权限', 'ACTIVE'),
       (2, 'MEMBER', '普通成员', '普通注册用户', 'ACTIVE');

INSERT INTO sys_permission (id, permission_code, permission_name, resource_type, description, status)
VALUES (1, 'user:view', '查看用户', 'USER', '查看用户列表和详情', 'ACTIVE'),
       (2, 'user:create', '创建用户', 'USER', '后台创建用户', 'ACTIVE'),
       (3, 'user:update', '修改用户', 'USER', '修改用户资料和状态', 'ACTIVE'),
       (4, 'user:delete', '删除用户', 'USER', '删除或禁用用户', 'ACTIVE'),
       (5, 'role:manage', '管理角色', 'ROLE', '管理系统角色', 'ACTIVE'),
       (6, 'permission:manage', '管理权限', 'PERMISSION', '管理系统权限', 'ACTIVE'),
       (7, 'space:create', '创建知识空间', 'SPACE', '创建知识空间', 'ACTIVE'),
       (8, 'audit:view', '查看审计日志', 'AUDIT', '查看操作日志', 'ACTIVE'),
       (9, 'dashboard:view', '查看后台统计', 'DASHBOARD', '查看后台统计数据', 'ACTIVE'),
       (10, 'space:view', '查看知识空间', 'SPACE', '查看知识空间列表和详情', 'ACTIVE'),
       (11, 'space:update', '修改知识空间', 'SPACE', '修改知识空间资料', 'ACTIVE'),
       (12, 'space:delete', '删除知识空间', 'SPACE', '删除知识空间', 'ACTIVE'),
       (13, 'member:view', '查看空间成员', 'SPACE', '查看空间成员列表', 'ACTIVE'),
       (14, 'member:manage', '管理空间成员', 'SPACE', '添加、修改、移除空间成员', 'ACTIVE'),
       (15, 'kb:create', '创建知识库', 'KB', '在空间下创建知识库', 'ACTIVE'),
       (16, 'kb:view', '查看知识库', 'KB', '查看知识库列表和详情', 'ACTIVE'),
       (17, 'kb:update', '修改知识库', 'KB', '修改知识库资料', 'ACTIVE'),
       (18, 'kb:delete', '删除知识库', 'KB', '删除知识库', 'ACTIVE'),
       (19, 'article:create', '创建知识条目', 'ARTICLE', '创建知识条目', 'ACTIVE'),
       (20, 'article:view', '查看知识条目', 'ARTICLE', '查看知识条目列表和详情', 'ACTIVE'),
       (21, 'article:update', '修改知识条目', 'ARTICLE', '修改知识条目内容', 'ACTIVE'),
       (22, 'article:delete', '删除知识条目', 'ARTICLE', '删除知识条目', 'ACTIVE'),
       (23, 'article:publish', '发布知识条目', 'ARTICLE', '发布或下线知识条目', 'ACTIVE'),
       (24, 'document:view', '查看文档', 'DOCUMENT', '查看文档列表和详情', 'ACTIVE'),
       (25, 'document:manage', '管理文档', 'DOCUMENT', '上传、重新解析、删除文档', 'ACTIVE'),
       (26, 'tag:manage', '管理标签', 'SPACE', '创建、查看、删除空间标签', 'ACTIVE');

-- 系统管理员拥有全部权限
INSERT INTO sys_role_permission (role_id, permission_id)
SELECT 1, id
FROM sys_permission;

-- 普通成员：知识库业务权限，不含后台管理与空间删除/成员管理
INSERT INTO sys_role_permission (role_id, permission_id)
VALUES (2, 7),
       (2, 10),
       (2, 11),
       (2, 13),
       (2, 15),
       (2, 16),
       (2, 17),
       (2, 18),
       (2, 19),
       (2, 20),
       (2, 21),
       (2, 22),
       (2, 23),
       (2, 24),
       (2, 25),
       (2, 26);

INSERT INTO sys_user (id, username, password, nickname, email, phone, avatar, status, last_login_time)
VALUES (1,
        'skaco2',
        '$2a$12$mPNB5YSzhtXVXwXpxD5qR.PDjaPxmPyxAQPSsJOJ5id2sfYbbBWYu',
        'skaco2',
        'arforco3@gmail.com',
        '114514',
        '/_astro/avatar.CzyjB4ne_ZBLvqH.webp',
        'ACTIVE',
        '2026-06-24 23:18:29');

INSERT INTO sys_user_role (user_id, role_id)
VALUES (1, 1);
