package com.ethercraft.service.impl;

import com.ethercraft.dto.KnowledgeBaseCreateDTO;
import com.ethercraft.dto.KnowledgeBaseUpdateDTO;
import com.ethercraft.entity.KnowledgeBase;
import com.ethercraft.mapper.KnowledgeBaseMapper;
import com.ethercraft.result.PageResult;
import com.ethercraft.service.KnowledgeBaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KnowledgeBaseServiceImpl implements KnowledgeBaseService {

    private final KnowledgeBaseMapper knowledgeBaseMapper;

    @Override
    public void createKnowledgeBase(Long spaceId, KnowledgeBaseCreateDTO createDTO) {
    }

    @Override
    public PageResult<KnowledgeBase> pageKnowledgeBases(Long spaceId, Integer page, Integer size) {
        return new PageResult<>(List.of(), 0L, page, size, 0);
    }

    @Override
    public KnowledgeBase getKnowledgeBaseById(Long spaceId, Long kbId) {
        return null;
    }

    @Override
    public void updateKnowledgeBase(Long spaceId, Long kbId, KnowledgeBaseUpdateDTO updateDTO) {
    }

    @Override
    public void deleteKnowledgeBase(Long spaceId, Long kbId) {
    }
}
