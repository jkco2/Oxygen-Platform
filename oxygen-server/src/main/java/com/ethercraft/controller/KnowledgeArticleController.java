package com.ethercraft.controller;

import com.ethercraft.constant.PermissionCodes;
import com.ethercraft.dto.KnowledgeArticleCreateDTO;
import com.ethercraft.dto.KnowledgeArticleUpdateDTO;
import com.ethercraft.entity.KnowledgeArticle;
import com.ethercraft.enumeration.ContentStatus;
import com.ethercraft.result.PageResult;
import com.ethercraft.result.Result;
import com.ethercraft.service.KnowledgeArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "知识条目管理")
@Slf4j
@RestController
@RequestMapping("/api/knowledge-bases/{kbId}/articles")
@RequiredArgsConstructor
public class KnowledgeArticleController {

    private final KnowledgeArticleService knowledgeArticleService;

    @Operation(summary = "创建知识条目")
    @PostMapping
    @PreAuthorize(PermissionCodes.Expr.ARTICLE_CREATE)
    public Result<Void> createKnowledgeArticle(@PathVariable Long kbId, @RequestBody KnowledgeArticleCreateDTO createDTO) {
        knowledgeArticleService.createKnowledgeArticle(kbId, createDTO);
        return Result.success();
    }

    @Operation(summary = "分页查询知识条目")
    @GetMapping
    @PreAuthorize(PermissionCodes.Expr.ARTICLE_VIEW)
    public Result<PageResult<KnowledgeArticle>> pageKnowledgeArticles(
            @PathVariable Long kbId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) ContentStatus status) {
        return Result.success(knowledgeArticleService.pageKnowledgeArticles(kbId, page, size, keyword, status));
    }

    @Operation(summary = "查询知识条目详情")
    @GetMapping("/{articleId}")
    @PreAuthorize(PermissionCodes.Expr.ARTICLE_VIEW)
    public Result<KnowledgeArticle> getKnowledgeArticle(@PathVariable Long kbId, @PathVariable Long articleId) {
        return Result.success(knowledgeArticleService.getKnowledgeArticleById(kbId, articleId));
    }

    @Operation(summary = "修改知识条目")
    @PutMapping("/{articleId}")
    @PreAuthorize(PermissionCodes.Expr.ARTICLE_UPDATE)
    public Result<Void> updateKnowledgeArticle(
            @PathVariable Long kbId,
            @PathVariable Long articleId,
            @RequestBody KnowledgeArticleUpdateDTO updateDTO) {
        knowledgeArticleService.updateKnowledgeArticle(kbId, articleId, updateDTO);
        return Result.success();
    }

    @Operation(summary = "发布知识条目")
    @PostMapping("/{articleId}/publish")
    @PreAuthorize(PermissionCodes.Expr.ARTICLE_PUBLISH)
    public Result<Void> publishKnowledgeArticle(@PathVariable Long kbId, @PathVariable Long articleId) {
        knowledgeArticleService.publishKnowledgeArticle(kbId, articleId);
        return Result.success();
    }

    @Operation(summary = "下线知识条目")
    @PostMapping("/{articleId}/offline")
    @PreAuthorize(PermissionCodes.Expr.ARTICLE_PUBLISH)
    public Result<Void> offlineKnowledgeArticle(@PathVariable Long kbId, @PathVariable Long articleId) {
        knowledgeArticleService.offlineKnowledgeArticle(kbId, articleId);
        return Result.success();
    }

    @Operation(summary = "删除知识条目")
    @DeleteMapping("/{articleId}")
    @PreAuthorize(PermissionCodes.Expr.ARTICLE_DELETE)
    public Result<Void> deleteKnowledgeArticle(@PathVariable Long kbId, @PathVariable Long articleId) {
        knowledgeArticleService.deleteKnowledgeArticle(kbId, articleId);
        return Result.success();
    }
}
