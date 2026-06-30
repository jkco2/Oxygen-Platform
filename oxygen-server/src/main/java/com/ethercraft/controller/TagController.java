package com.ethercraft.controller;

import com.ethercraft.constant.PermissionCodes;
import com.ethercraft.entity.KnowledgeTag;
import com.ethercraft.result.PageResult;
import com.ethercraft.result.Result;
import com.ethercraft.service.TagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "知识标签管理")
@Slf4j
@RestController
@RequestMapping("/api/knowledge-spaces/{spaceId}/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @Operation(summary = "创建标签")
    @PostMapping
    @PreAuthorize(PermissionCodes.Expr.TAG_MANAGE)
    public Result<Void> createTag(@PathVariable Long spaceId, @RequestBody KnowledgeTag tag) {
        tagService.createTag(spaceId, tag);
        return Result.success();
    }

    @Operation(summary = "查询空间标签")
    @GetMapping
    @PreAuthorize(PermissionCodes.Expr.TAG_MANAGE)
    public Result<PageResult<KnowledgeTag>> listTags(@PathVariable Long spaceId) {
        return Result.success(tagService.listTags(spaceId));
    }

    @Operation(summary = "删除标签")
    @DeleteMapping("/{tagId}")
    @PreAuthorize(PermissionCodes.Expr.TAG_MANAGE)
    public Result<Void> deleteTag(@PathVariable Long spaceId, @PathVariable Long tagId) {
        tagService.deleteTag(spaceId, tagId);
        return Result.success();
    }
}
