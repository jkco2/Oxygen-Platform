package com.ethercraft.service;

import com.ethercraft.entity.KnowledgeDocument;
import com.ethercraft.result.PageResult;

public interface DocumentService {

    PageResult<KnowledgeDocument> pageDocuments(Long kbId, Integer page, Integer size);

    KnowledgeDocument getDocumentById(Long kbId, Long documentId);

    void reparseDocument(Long kbId, Long documentId);

    void deleteDocument(Long kbId, Long documentId);
}
