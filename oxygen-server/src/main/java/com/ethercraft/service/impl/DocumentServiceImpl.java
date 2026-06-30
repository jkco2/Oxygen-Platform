package com.ethercraft.service.impl;

import com.ethercraft.entity.KnowledgeDocument;
import com.ethercraft.mapper.DocumentMapper;
import com.ethercraft.result.PageResult;
import com.ethercraft.service.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final DocumentMapper documentMapper;

    @Override
    public PageResult<KnowledgeDocument> pageDocuments(Long kbId, Integer page, Integer size) {
        return new PageResult<>(List.of(), 0L, page, size, 0);
    }

    @Override
    public KnowledgeDocument getDocumentById(Long kbId, Long documentId) {
        return null;
    }

    @Override
    public void reparseDocument(Long kbId, Long documentId) {
    }

    @Override
    public void deleteDocument(Long kbId, Long documentId) {
    }
}
