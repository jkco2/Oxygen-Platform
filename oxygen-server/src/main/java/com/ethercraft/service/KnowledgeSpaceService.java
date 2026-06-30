package com.ethercraft.service;

import com.ethercraft.dto.KnowledgeSpaceCreateDTO;
import com.ethercraft.dto.KnowledgeSpaceUpdateDTO;
import com.ethercraft.entity.KnowledgeSpace;
import com.ethercraft.result.PageResult;

public interface KnowledgeSpaceService {

    void createKnowledgeSpace(KnowledgeSpaceCreateDTO createDTO);

    PageResult<KnowledgeSpace> pageKnowledgeSpaces(Integer page, Integer size, String keyword);

    PageResult<KnowledgeSpace> pageMyKnowledgeSpaces(Integer page, Integer size);

    KnowledgeSpace getKnowledgeSpaceById(Long spaceId);

    void updateKnowledgeSpace(Long spaceId, KnowledgeSpaceUpdateDTO updateDTO);

    void deleteKnowledgeSpace(Long spaceId);
}
