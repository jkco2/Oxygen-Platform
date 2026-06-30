package com.ethercraft.controller;

import com.ethercraft.constant.PermissionCodes;
import com.ethercraft.entity.KnowledgeDocument;
import com.ethercraft.result.PageResult;
import com.ethercraft.result.Result;
import com.ethercraft.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@Tag(name = "知识文档管理")
@Slf4j
@RestController
@RequestMapping("/api/knowledge-bases/{kbId}/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @Operation(summary = "查询文档列表")
    @GetMapping
    @PreAuthorize(PermissionCodes.Expr.DOCUMENT_VIEW)
    public Result<PageResult<KnowledgeDocument>> pageDocuments(
            @PathVariable Long kbId,
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return Result.success(documentService.pageDocuments(kbId, page, size));
    }

    @Operation(summary = "查询文档详情")
    @GetMapping("/{documentId}")
    @PreAuthorize(PermissionCodes.Expr.DOCUMENT_VIEW)
    public Result<KnowledgeDocument> getDocument(@PathVariable Long kbId, @PathVariable Long documentId) {
        return Result.success(documentService.getDocumentById(kbId, documentId));
    }

    @Operation(summary = "重新解析文档")
    @PostMapping("/{documentId}/reparse")
    @PreAuthorize(PermissionCodes.Expr.DOCUMENT_MANAGE)
    public Result<Void> reparseDocument(@PathVariable Long kbId, @PathVariable Long documentId) {
        documentService.reparseDocument(kbId, documentId);
        return Result.success();
    }

    @Operation(summary = "删除文档")
    @DeleteMapping("/{documentId}")
    @PreAuthorize(PermissionCodes.Expr.DOCUMENT_MANAGE)
    public Result<Void> deleteDocument(@PathVariable Long kbId, @PathVariable Long documentId) {
        documentService.deleteDocument(kbId, documentId);
        return Result.success();
    }
}
