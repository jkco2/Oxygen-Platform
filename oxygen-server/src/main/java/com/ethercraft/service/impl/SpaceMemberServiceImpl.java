package com.ethercraft.service.impl;

import com.ethercraft.dto.KnowledgeMemberUpdateDTO;
import com.ethercraft.dto.SpaceMemberAddDTO;
import com.ethercraft.entity.SpaceMember;
import com.ethercraft.result.PageResult;
import com.ethercraft.service.SpaceMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceMemberServiceImpl implements SpaceMemberService {

    @Override
    public PageResult<SpaceMember> pageSpaceMembers(Long spaceId, Integer page, Integer size) {
        return new PageResult<>(List.of(), 0L, page, size, 0);
    }

    @Override
    public void addSpaceMember(Long spaceId, SpaceMemberAddDTO addDTO) {
    }

    @Override
    public void updateSpaceMember(Long spaceId, Long memberId, KnowledgeMemberUpdateDTO updateDTO) {
    }

    @Override
    public void deleteSpaceMember(Long spaceId, Long memberId) {
    }
}
