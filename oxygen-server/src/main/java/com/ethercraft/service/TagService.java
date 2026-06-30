package com.ethercraft.service;

import com.ethercraft.entity.KnowledgeTag;
import com.ethercraft.result.PageResult;

public interface TagService {

    void createTag(Long spaceId, KnowledgeTag tag);

    PageResult<KnowledgeTag> listTags(Long spaceId);

    void deleteTag(Long spaceId, Long tagId);
}
