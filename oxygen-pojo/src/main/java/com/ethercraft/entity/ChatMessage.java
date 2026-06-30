package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.MessageSenderType;
import com.ethercraft.enumeration.MessageStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "Agent 消息实体")
public class ChatMessage {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 会话 ID
    @Schema(description = "会话 ID")
    private Long sessionId;

    // 发送方类型
    @Schema(description = "发送方类型")
    private MessageSenderType senderType;

    // 正文内容
    @Schema(description = "正文内容")
    private String content;

    // 模型名称
    @Schema(description = "模型名称")
    private String modelName;

    // 输入 token 数
    @Schema(description = "输入 token 数")
    private Integer promptTokens;

    // 输出 token 数
    @Schema(description = "输出 token 数")
    private Integer completionTokens;

    // 响应耗时毫秒数
    @Schema(description = "响应耗时毫秒数")
    private Long latencyMs;

    // 状态
    @Schema(description = "状态")
    private MessageStatus status;

    // 错误信息
    @Schema(description = "错误信息")
    private String errorMessage;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

}
