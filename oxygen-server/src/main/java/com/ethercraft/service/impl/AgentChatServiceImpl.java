package com.ethercraft.service.impl;

import com.ethercraft.mapper.AgentChatMapper;
import com.ethercraft.service.AgentChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AgentChatServiceImpl implements AgentChatService {

    private final AgentChatMapper agentChatMapper;

}
