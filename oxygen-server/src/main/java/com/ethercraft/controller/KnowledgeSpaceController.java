package com.ethercraft.controller;

import com.ethercraft.constant.PermissionCodes;
import com.ethercraft.dto.KnowledgeSpaceCreateDTO;
import com.ethercraft.dto.KnowledgeSpaceUpdateDTO;
import com.ethercraft.entity.KnowledgeSpace;
import com.ethercraft.result.PageResult;
import com.ethercraft.result.Result;
import com.ethercraft.service.KnowledgeSpaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "知识空间管理")
@Slf4j
@RestController
@RequestMapping("/api/knowledge-spaces")
@RequiredArgsConstructor
public class KnowledgeSpaceController {

    private final KnowledgeSpaceService knowledgeSpaceService;

    @Operation(summary = "创建知识空间")
    @PostMapping
    @PreAuthorize(PermissionCodes.Expr.SPACE_CREATE)
    public Result<Void> createKnowledgeSpace(@RequestBody KnowledgeSpaceCreateDTO createDTO) {
        knowledgeSpaceService.createKnowledgeSpace(createDTO);
        return Result.success();
    }

    @Operation(summary = "分页查询可访问空间")
    @GetMapping
    @PreAuthorize(PermissionCodes.Expr.SPACE_VIEW)
    public Result<PageResult<KnowledgeSpace>> pageKnowledgeSpaces(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(required = false) String keyword) {
        return Result.success(knowledgeSpaceService.pageKnowledgeSpaces(page, size, keyword));
    }

    @Operation(summary = "查询我的知识空间")
    @GetMapping("/my")
    @PreAuthorize(PermissionCodes.Expr.SPACE_VIEW)
    public Result<PageResult<KnowledgeSpace>> pageMyKnowledgeSpaces(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return Result.success(knowledgeSpaceService.pageMyKnowledgeSpaces(page, size));
    }

    @Operation(summary = "查询空间详情")
    @GetMapping("/{spaceId}")
    @PreAuthorize(PermissionCodes.Expr.SPACE_VIEW)
    public Result<KnowledgeSpace> getKnowledgeSpace(@PathVariable Long spaceId) {
        return Result.success(knowledgeSpaceService.getKnowledgeSpaceById(spaceId));
    }

    @Operation(summary = "修改空间")
    @PutMapping("/{spaceId}")
    @PreAuthorize(PermissionCodes.Expr.SPACE_UPDATE)
    public Result<Void> updateKnowledgeSpace(@PathVariable Long spaceId, @RequestBody KnowledgeSpaceUpdateDTO updateDTO) {
        knowledgeSpaceService.updateKnowledgeSpace(spaceId, updateDTO);
        return Result.success();
    }

    @Operation(summary = "删除空间")
    @DeleteMapping("/{spaceId}")
    @PreAuthorize(PermissionCodes.Expr.SPACE_DELETE)
    public Result<Void> deleteKnowledgeSpace(@PathVariable Long spaceId) {
        knowledgeSpaceService.deleteKnowledgeSpace(spaceId);
        return Result.success();
    }

}
