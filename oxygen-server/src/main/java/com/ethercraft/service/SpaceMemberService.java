package com.ethercraft.service;

import com.ethercraft.dto.KnowledgeMemberUpdateDTO;
import com.ethercraft.dto.SpaceMemberAddDTO;
import com.ethercraft.entity.SpaceMember;
import com.ethercraft.result.PageResult;

public interface SpaceMemberService {

    PageResult<SpaceMember> pageSpaceMembers(Long spaceId, Integer page, Integer size);

    void addSpaceMember(Long spaceId, SpaceMemberAddDTO addDTO);

    void updateSpaceMember(Long spaceId, Long memberId, KnowledgeMemberUpdateDTO updateDTO);

    void deleteSpaceMember(Long spaceId, Long memberId);
}
