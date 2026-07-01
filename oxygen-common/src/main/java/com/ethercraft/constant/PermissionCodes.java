package com.ethercraft.constant;

/**
 * 系统权限码常量，需与 sys_permission.permission_code 保持一致。
 */
public final class PermissionCodes {

    private PermissionCodes() {
    }

    // 用户管理
    public static final String USER_VIEW = "user:view";
    public static final String USER_CREATE = "user:create";
    public static final String USER_UPDATE = "user:update";
    public static final String USER_DELETE = "user:delete";

    // 角色与权限管理
    public static final String ROLE_MANAGE = "role:manage";
    public static final String PERMISSION_MANAGE = "permission:manage";

    // 知识空间
    public static final String SPACE_CREATE = "space:create";
    public static final String SPACE_VIEW = "space:view";
    public static final String SPACE_UPDATE = "space:update";
    public static final String SPACE_DELETE = "space:delete";

    // 空间成员
    public static final String MEMBER_VIEW = "member:view";
    public static final String MEMBER_MANAGE = "member:manage";

    // 知识库
    public static final String KB_CREATE = "kb:create";
    public static final String KB_VIEW = "kb:view";
    public static final String KB_UPDATE = "kb:update";
    public static final String KB_DELETE = "kb:delete";

    // 知识条目
    public static final String ARTICLE_CREATE = "article:create";
    public static final String ARTICLE_VIEW = "article:view";
    public static final String ARTICLE_UPDATE = "article:update";
    public static final String ARTICLE_DELETE = "article:delete";
    public static final String ARTICLE_PUBLISH = "article:publish";

    // 文档
    public static final String DOCUMENT_VIEW = "document:view";
    public static final String DOCUMENT_MANAGE = "document:manage";

    // 标签
    public static final String TAG_MANAGE = "tag:manage";

    // 后台
    public static final String AUDIT_VIEW = "audit:view";
    public static final String DASHBOARD_VIEW = "dashboard:view";

    /**
     * 供 PreAuthorize 直接引用的表达式常量。
     */
    public static final class Expr {

        private Expr() {
        }

        public static final String USER_VIEW = "hasAuthority('" + PermissionCodes.USER_VIEW + "')";
        public static final String USER_CREATE = "hasAuthority('" + PermissionCodes.USER_CREATE + "')";
        public static final String USER_UPDATE = "hasAuthority('" + PermissionCodes.USER_UPDATE + "')";
        public static final String USER_DELETE = "hasAuthority('" + PermissionCodes.USER_DELETE + "')";

        public static final String ROLE_MANAGE = "hasAuthority('" + PermissionCodes.ROLE_MANAGE + "')";
        public static final String PERMISSION_MANAGE = "hasAuthority('" + PermissionCodes.PERMISSION_MANAGE + "')";

        public static final String SPACE_CREATE = "hasAuthority('" + PermissionCodes.SPACE_CREATE + "')";
        public static final String SPACE_VIEW = "hasAuthority('" + PermissionCodes.SPACE_VIEW + "')";
        public static final String SPACE_UPDATE = "hasAuthority('" + PermissionCodes.SPACE_UPDATE + "')";
        public static final String SPACE_DELETE = "hasAuthority('" + PermissionCodes.SPACE_DELETE + "')";

        public static final String MEMBER_VIEW = "hasAuthority('" + PermissionCodes.MEMBER_VIEW + "')";
        public static final String MEMBER_MANAGE = "hasAuthority('" + PermissionCodes.MEMBER_MANAGE + "')";

        public static final String KB_CREATE = "hasAuthority('" + PermissionCodes.KB_CREATE + "')";
        public static final String KB_VIEW = "hasAuthority('" + PermissionCodes.KB_VIEW + "')";
        public static final String KB_UPDATE = "hasAuthority('" + PermissionCodes.KB_UPDATE + "')";
        public static final String KB_DELETE = "hasAuthority('" + PermissionCodes.KB_DELETE + "')";

        public static final String ARTICLE_CREATE = "hasAuthority('" + PermissionCodes.ARTICLE_CREATE + "')";
        public static final String ARTICLE_VIEW = "hasAuthority('" + PermissionCodes.ARTICLE_VIEW + "')";
        public static final String ARTICLE_UPDATE = "hasAuthority('" + PermissionCodes.ARTICLE_UPDATE + "')";
        public static final String ARTICLE_DELETE = "hasAuthority('" + PermissionCodes.ARTICLE_DELETE + "')";
        public static final String ARTICLE_PUBLISH = "hasAuthority('" + PermissionCodes.ARTICLE_PUBLISH + "')";

        public static final String DOCUMENT_VIEW = "hasAuthority('" + PermissionCodes.DOCUMENT_VIEW + "')";
        public static final String DOCUMENT_MANAGE = "hasAuthority('" + PermissionCodes.DOCUMENT_MANAGE + "')";

        public static final String TAG_MANAGE = "hasAuthority('" + PermissionCodes.TAG_MANAGE + "')";

        public static final String AUDIT_VIEW = "hasAuthority('" + PermissionCodes.AUDIT_VIEW + "')";
        public static final String DASHBOARD_VIEW = "hasAuthority('" + PermissionCodes.DASHBOARD_VIEW + "')";

        public static final String SCOPED_SPACE_VIEW =
                "@scopeAuth.hasPermission('" + PermissionCodes.SPACE_VIEW + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";
        public static final String SCOPED_SPACE_UPDATE =
                "@scopeAuth.hasPermission('" + PermissionCodes.SPACE_UPDATE + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";
        public static final String SCOPED_SPACE_DELETE =
                "@scopeAuth.hasPermission('" + PermissionCodes.SPACE_DELETE + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";
        public static final String SCOPED_MEMBER_VIEW =
                "@scopeAuth.hasPermission('" + PermissionCodes.MEMBER_VIEW + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";
        public static final String SCOPED_MEMBER_MANAGE =
                "@scopeAuth.hasPermission('" + PermissionCodes.MEMBER_MANAGE + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";
        public static final String SCOPED_KB_CREATE =
                "@scopeAuth.hasPermission('" + PermissionCodes.KB_CREATE + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";
        public static final String SCOPED_KB_VIEW =
                "@scopeAuth.hasPermission('" + PermissionCodes.KB_VIEW + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";
        public static final String SCOPED_KB_UPDATE =
                "@scopeAuth.hasPermission('" + PermissionCodes.KB_UPDATE + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";
        public static final String SCOPED_KB_DELETE =
                "@scopeAuth.hasPermission('" + PermissionCodes.KB_DELETE + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";
        public static final String SCOPED_TAG_MANAGE =
                "@scopeAuth.hasPermission('" + PermissionCodes.TAG_MANAGE + "', T(com.ethercraft.enumeration.ScopeType).SPACE, #spaceId)";

        public static final String SCOPED_ARTICLE_CREATE =
                "@scopeAuth.hasPermissionForKnowledgeBase('" + PermissionCodes.ARTICLE_CREATE + "', #kbId)";
        public static final String SCOPED_ARTICLE_VIEW =
                "@scopeAuth.hasPermissionForKnowledgeBase('" + PermissionCodes.ARTICLE_VIEW + "', #kbId)";
        public static final String SCOPED_ARTICLE_UPDATE =
                "@scopeAuth.hasPermissionForKnowledgeBase('" + PermissionCodes.ARTICLE_UPDATE + "', #kbId)";
        public static final String SCOPED_ARTICLE_DELETE =
                "@scopeAuth.hasPermissionForKnowledgeBase('" + PermissionCodes.ARTICLE_DELETE + "', #kbId)";
        public static final String SCOPED_ARTICLE_PUBLISH =
                "@scopeAuth.hasPermissionForKnowledgeBase('" + PermissionCodes.ARTICLE_PUBLISH + "', #kbId)";
        public static final String SCOPED_DOCUMENT_VIEW =
                "@scopeAuth.hasPermissionForKnowledgeBase('" + PermissionCodes.DOCUMENT_VIEW + "', #kbId)";
        public static final String SCOPED_DOCUMENT_MANAGE =
                "@scopeAuth.hasPermissionForKnowledgeBase('" + PermissionCodes.DOCUMENT_MANAGE + "', #kbId)";
    }
}
