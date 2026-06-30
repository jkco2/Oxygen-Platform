package com.ethercraft.service.impl;

import com.ethercraft.dto.KnowledgeSpaceCreateDTO;
import com.ethercraft.dto.KnowledgeSpaceUpdateDTO;
import com.ethercraft.entity.KnowledgeSpace;
import com.ethercraft.mapper.KnowledgeSpaceMapper;
import com.ethercraft.result.PageResult;
import com.ethercraft.service.KnowledgeSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KnowledgeSpaceServiceImpl implements KnowledgeSpaceService {

    private final KnowledgeSpaceMapper knowledgeSpaceMapper;

    @Override
    public void createKnowledgeSpace(KnowledgeSpaceCreateDTO createDTO) {
    }

    @Override
    public PageResult<KnowledgeSpace> pageKnowledgeSpaces(Integer page, Integer size, String keyword) {
        return new PageResult<>(List.of(), 0L, page, size, 0);
    }

    @Override
    public PageResult<KnowledgeSpace> pageMyKnowledgeSpaces(Integer page, Integer size) {
        return new PageResult<>(List.of(), 0L, page, size, 0);
    }

    @Override
    public KnowledgeSpace getKnowledgeSpaceById(Long spaceId) {
        return null;
    }

    @Override
    public void updateKnowledgeSpace(Long spaceId, KnowledgeSpaceUpdateDTO updateDTO) {
    }

    @Override
    public void deleteKnowledgeSpace(Long spaceId) {
    }
}
