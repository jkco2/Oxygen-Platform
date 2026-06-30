package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.AgentType;
import com.ethercraft.enumeration.ChatSessionStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Agent 会话实体")
public class ChatSession {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 用户 ID
    @Schema(description = "用户 ID")
    private Long userId;

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

    // 状态
    @Schema(description = "状态")
    private ChatSessionStatus status;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    // 更新时间
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
