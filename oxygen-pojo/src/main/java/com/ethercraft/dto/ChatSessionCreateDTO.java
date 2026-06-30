package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.AgentType;
import lombok.Data;

@Data
@Schema(description = "Agent 会话创建请求")
public class ChatSessionCreateDTO {

    // 知识空间 ID
    @Schema(description = "知识空间 ID")
    private Long spaceId;

    // 知识库 ID
    @Schema(description = "知识库 ID")
    private Long kbId;

    // 标题
    @Schema(description = "标题")
    private String title;

    // Agent 类型
    @Schema(description = "Agent 类型")
    private AgentType agentType;

}
