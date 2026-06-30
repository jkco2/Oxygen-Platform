-- 初始化角色、权限与管理员账号

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
       (9, 'dashboard:view', '查看后台统计', 'DASHBOARD', '查看后台统计数据', 'ACTIVE');

INSERT INTO sys_role_permission (role_id, permission_id)
SELECT 1, id
FROM sys_permission;

INSERT INTO sys_role_permission (role_id, permission_id)
VALUES (2, 7);

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
