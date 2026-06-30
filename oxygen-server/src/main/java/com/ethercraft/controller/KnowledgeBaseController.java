package com.ethercraft.controller;

import com.ethercraft.constant.PermissionCodes;
import com.ethercraft.dto.KnowledgeBaseCreateDTO;
import com.ethercraft.dto.KnowledgeBaseUpdateDTO;
import com.ethercraft.entity.KnowledgeBase;
import com.ethercraft.result.PageResult;
import com.ethercraft.result.Result;
import com.ethercraft.service.KnowledgeBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "知识库管理")
@Slf4j
@RestController
@RequestMapping("/api/knowledge-spaces/{spaceId}/knowledge-bases")
@RequiredArgsConstructor
public class KnowledgeBaseController {

    private final KnowledgeBaseService knowledgeBaseService;

    @Operation(summary = "创建知识库")
    @PostMapping
    @PreAuthorize(PermissionCodes.Expr.KB_CREATE)
    public Result<Void> createKnowledgeBase(@PathVariable Long spaceId, @RequestBody KnowledgeBaseCreateDTO createDTO) {
        knowledgeBaseService.createKnowledgeBase(spaceId, createDTO);
        return Result.success();
    }

    @Operation(summary = "查询空间下知识库")
    @GetMapping
    @PreAuthorize(PermissionCodes.Expr.KB_VIEW)
    public Result<PageResult<KnowledgeBase>> pageKnowledgeBases(
            @PathVariable Long spaceId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return Result.success(knowledgeBaseService.pageKnowledgeBases(spaceId, page, size));
    }

    @Operation(summary = "查询知识库详情")
    @GetMapping("/{kbId}")
    @PreAuthorize(PermissionCodes.Expr.KB_VIEW)
    public Result<KnowledgeBase> getKnowledgeBase(@PathVariable Long spaceId, @PathVariable Long kbId) {
        return Result.success(knowledgeBaseService.getKnowledgeBaseById(spaceId, kbId));
    }

    @Operation(summary = "修改知识库")
    @PutMapping("/{kbId}")
    @PreAuthorize(PermissionCodes.Expr.KB_UPDATE)
    public Result<Void> updateKnowledgeBase(
            @PathVariable Long spaceId,
            @PathVariable Long kbId,
            @RequestBody KnowledgeBaseUpdateDTO updateDTO) {
        knowledgeBaseService.updateKnowledgeBase(spaceId, kbId, updateDTO);
        return Result.success();
    }

    @Operation(summary = "删除知识库")
    @DeleteMapping("/{kbId}")
    @PreAuthorize(PermissionCodes.Expr.KB_DELETE)
    public Result<Void> deleteKnowledgeBase(@PathVariable Long spaceId, @PathVariable Long kbId) {
        knowledgeBaseService.deleteKnowledgeBase(spaceId, kbId);
        return Result.success();
    }
}
