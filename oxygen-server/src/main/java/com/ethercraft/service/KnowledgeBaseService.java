package com.ethercraft.service;

import com.ethercraft.dto.KnowledgeBaseCreateDTO;
import com.ethercraft.dto.KnowledgeBaseUpdateDTO;
import com.ethercraft.entity.KnowledgeBase;
import com.ethercraft.result.PageResult;

public interface KnowledgeBaseService {

    void createKnowledgeBase(Long spaceId, KnowledgeBaseCreateDTO createDTO);

    PageResult<KnowledgeBase> pageKnowledgeBases(Long spaceId, Integer page, Integer size);

    KnowledgeBase getKnowledgeBaseById(Long spaceId, Long kbId);

    void updateKnowledgeBase(Long spaceId, Long kbId, KnowledgeBaseUpdateDTO updateDTO);

    void deleteKnowledgeBase(Long spaceId, Long kbId);
}
