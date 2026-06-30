package com.ethercraft.service;

import com.ethercraft.dto.KnowledgeArticleCreateDTO;
import com.ethercraft.dto.KnowledgeArticleUpdateDTO;
import com.ethercraft.entity.KnowledgeArticle;
import com.ethercraft.enumeration.ContentStatus;
import com.ethercraft.result.PageResult;

public interface KnowledgeArticleService {

    void createKnowledgeArticle(Long kbId, KnowledgeArticleCreateDTO createDTO);

    PageResult<KnowledgeArticle> pageKnowledgeArticles(Long kbId, Integer page, Integer size, String keyword, ContentStatus status);

    KnowledgeArticle getKnowledgeArticleById(Long kbId, Long articleId);

    void updateKnowledgeArticle(Long kbId, Long articleId, KnowledgeArticleUpdateDTO updateDTO);

    void publishKnowledgeArticle(Long kbId, Long articleId);

    void offlineKnowledgeArticle(Long kbId, Long articleId);

    void deleteKnowledgeArticle(Long kbId, Long articleId);
}
