package com.ethercraft.controller;

import com.ethercraft.constant.PermissionCodes;
import com.ethercraft.dto.KnowledgeMemberUpdateDTO;
import com.ethercraft.dto.SpaceMemberAddDTO;
import com.ethercraft.entity.SpaceMember;
import com.ethercraft.result.PageResult;
import com.ethercraft.result.Result;
import com.ethercraft.service.SpaceMemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "空间成员管理")
@Slf4j
@RestController
@RequestMapping("/api/knowledge-spaces/{spaceId}/members")
@RequiredArgsConstructor
public class SpaceMemberController {

    private final SpaceMemberService spaceMemberService;

    @Operation(summary = "查询空间成员")
    @GetMapping
    @PreAuthorize(PermissionCodes.Expr.MEMBER_VIEW)
    public Result<PageResult<SpaceMember>> pageSpaceMembers(
            @PathVariable Long spaceId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return Result.success(spaceMemberService.pageSpaceMembers(spaceId, page, size));
    }

    @Operation(summary = "添加空间成员")
    @PostMapping
    @PreAuthorize(PermissionCodes.Expr.MEMBER_MANAGE)
    public Result<Void> addSpaceMember(@PathVariable Long spaceId, @RequestBody SpaceMemberAddDTO addDTO) {
        spaceMemberService.addSpaceMember(spaceId, addDTO);
        return Result.success();
    }

    @Operation(summary = "修改成员空间角色")
    @PutMapping("/{memberId}")
    @PreAuthorize(PermissionCodes.Expr.MEMBER_MANAGE)
    public Result<Void> updateSpaceMember(
            @PathVariable Long spaceId,
            @PathVariable Long memberId,
            @RequestBody KnowledgeMemberUpdateDTO updateDTO) {
        spaceMemberService.updateSpaceMember(spaceId, memberId, updateDTO);
        return Result.success();
    }

    @Operation(summary = "移除空间成员")
    @DeleteMapping("/{memberId}")
    @PreAuthorize(PermissionCodes.Expr.MEMBER_MANAGE)
    public Result<Void> deleteSpaceMember(@PathVariable Long spaceId, @PathVariable Long memberId) {
        spaceMemberService.deleteSpaceMember(spaceId, memberId);
        return Result.success();
    }
}
