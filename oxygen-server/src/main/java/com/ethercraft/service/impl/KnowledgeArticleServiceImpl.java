package com.ethercraft.service.impl;

import com.ethercraft.dto.KnowledgeArticleCreateDTO;
import com.ethercraft.dto.KnowledgeArticleUpdateDTO;
import com.ethercraft.entity.KnowledgeArticle;
import com.ethercraft.enumeration.ContentStatus;
import com.ethercraft.mapper.KnowledgeArticleMapper;
import com.ethercraft.result.PageResult;
import com.ethercraft.service.KnowledgeArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KnowledgeArticleServiceImpl implements KnowledgeArticleService {

    private final KnowledgeArticleMapper knowledgeArticleMapper;

    @Override
    public void createKnowledgeArticle(Long kbId, KnowledgeArticleCreateDTO createDTO) {
    }

    @Override
    public PageResult<KnowledgeArticle> pageKnowledgeArticles(Long kbId, Integer page, Integer size, String keyword, ContentStatus status) {
        return new PageResult<>(List.of(), 0L, page, size, 0);
    }

    @Override
    public KnowledgeArticle getKnowledgeArticleById(Long kbId, Long articleId) {
        return null;
    }

    @Override
    public void updateKnowledgeArticle(Long kbId, Long articleId, KnowledgeArticleUpdateDTO updateDTO) {
    }

    @Override
    public void publishKnowledgeArticle(Long kbId, Long articleId) {
    }

    @Override
    public void offlineKnowledgeArticle(Long kbId, Long articleId) {
    }

    @Override
    public void deleteKnowledgeArticle(Long kbId, Long articleId) {
    }
}
