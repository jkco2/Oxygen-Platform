package com.ethercraft.controller;

import com.ethercraft.service.AgentChatService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Agent 问答")
@Slf4j
@RestController
@RequestMapping("/api/chat/sessions")
@RequiredArgsConstructor
public class AgentChatController {

    private final AgentChatService agentChatService;

}
