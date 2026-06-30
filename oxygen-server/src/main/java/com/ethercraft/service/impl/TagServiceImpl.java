package com.ethercraft.service.impl;

import com.ethercraft.entity.KnowledgeTag;
import com.ethercraft.mapper.TagMapper;
import com.ethercraft.result.PageResult;
import com.ethercraft.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagMapper tagMapper;

    @Override
    public void createTag(Long spaceId, KnowledgeTag tag) {
    }

    @Override
    public PageResult<KnowledgeTag> listTags(Long spaceId) {
        return new PageResult<>(List.of(), 0L, 1, 0, 0);
    }

    @Override
    public void deleteTag(Long spaceId, Long tagId) {
    }
}
