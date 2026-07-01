package com.ethercraft.service;

import com.ethercraft.enumeration.ScopeType;

public interface ScopeAuthorizationService {

    boolean hasPermission(String permissionCode, ScopeType scopeType, Long scopeId);

    boolean hasPermissionForKnowledgeBase(String permissionCode, Long kbId);

}
