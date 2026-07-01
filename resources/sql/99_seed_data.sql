-- Initial roles, permissions, and admin account.
-- permission_code must stay consistent with PermissionCodes.

INSERT INTO sys_role (id, role_code, role_name, description, scope_type, status)
VALUES (1, 'SYSTEM_ADMIN', '系统管理员', '拥有全部全局权限，可穿透所有 scope', 'GLOBAL', 'ACTIVE'),
       (2, 'MEMBER', '普通成员', '普通注册用户，拥有基础全局入口权限', 'GLOBAL', 'ACTIVE'),
       (3, 'SPACE_OWNER', '空间所有者', '拥有空间内全部权限', 'SPACE', 'ACTIVE'),
       (4, 'SPACE_ADMIN', '空间管理员', '管理空间内容和成员，不删除空间', 'SPACE', 'ACTIVE'),
       (5, 'SPACE_EDITOR', '空间编辑者', '编辑空间内知识内容', 'SPACE', 'ACTIVE'),
       (6, 'SPACE_VIEWER', '空间浏览者', '查看空间内知识内容', 'SPACE', 'ACTIVE');

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

-- Global administrator has every global permission and can pass scoped checks.
INSERT INTO sys_role_permission (role_id, permission_id)
SELECT 1, id
FROM sys_permission;

-- Normal members keep only global entry permissions. Space content permissions are scoped.
INSERT INTO sys_role_permission (role_id, permission_id)
VALUES (2, 7),
       (2, 10);

INSERT INTO sys_role_permission (role_id, permission_id)
SELECT 3, id
FROM sys_permission
WHERE permission_code in (
    'space:view', 'space:update', 'space:delete',
    'member:view', 'member:manage',
    'kb:create', 'kb:view', 'kb:update', 'kb:delete',
    'article:create', 'article:view', 'article:update', 'article:delete', 'article:publish',
    'document:view', 'document:manage',
    'tag:manage'
);

INSERT INTO sys_role_permission (role_id, permission_id)
SELECT 4, id
FROM sys_permission
WHERE permission_code in (
    'space:view', 'space:update',
    'member:view', 'member:manage',
    'kb:create', 'kb:view', 'kb:update', 'kb:delete',
    'article:create', 'article:view', 'article:update', 'article:delete', 'article:publish',
    'document:view', 'document:manage',
    'tag:manage'
);

INSERT INTO sys_role_permission (role_id, permission_id)
SELECT 5, id
FROM sys_permission
WHERE permission_code in (
    'space:view',
    'member:view',
    'kb:view',
    'article:create', 'article:view', 'article:update', 'article:publish',
    'document:view', 'document:manage',
    'tag:manage'
);

INSERT INTO sys_role_permission (role_id, permission_id)
SELECT 6, id
FROM sys_permission
WHERE permission_code in (
    'space:view',
    'member:view',
    'kb:view',
    'article:view',
    'document:view'
);

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

INSERT INTO sys_user_role (user_id, role_id, scope_type, scope_id)
VALUES (1, 1, 'GLOBAL', null);
