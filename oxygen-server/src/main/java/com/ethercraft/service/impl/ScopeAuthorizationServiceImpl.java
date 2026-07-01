package com.ethercraft.service.impl;

import com.ethercraft.context.UserContext;
import com.ethercraft.enumeration.ScopeType;
import com.ethercraft.mapper.KnowledgeBaseMapper;
import com.ethercraft.mapper.RoleAssignmentMapper;
import com.ethercraft.service.ScopeAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("scopeAuth")
@RequiredArgsConstructor
public class ScopeAuthorizationServiceImpl implements ScopeAuthorizationService {

    private final RoleAssignmentMapper roleAssignmentMapper;
    private final KnowledgeBaseMapper knowledgeBaseMapper;

    @Override
    public boolean hasPermission(String permissionCode, ScopeType scopeType, Long scopeId) {
        Long userId = UserContext.getUserId();
        if (userId == null || permissionCode == null || scopeType == null) {
            return false;
        }

        if (roleAssignmentMapper.hasGlobalPermission(userId, permissionCode)) {
            return true;
        }

        if (ScopeType.GLOBAL.equals(scopeType)) {
            return false;
        }

        if (scopeId == null) {
            return false;
        }

        return roleAssignmentMapper.hasScopedPermission(userId, permissionCode, scopeType, scopeId);
    }

    @Override
    public boolean hasPermissionForKnowledgeBase(String permissionCode, Long kbId) {
        Long spaceId = knowledgeBaseMapper.selectSpaceIdById(kbId);
        return hasPermission(permissionCode, ScopeType.SPACE, spaceId);
    }

}
