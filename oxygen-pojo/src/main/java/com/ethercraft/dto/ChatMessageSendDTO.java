package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import lombok.Data;

@Data
@Schema(description = "Agent 消息发送请求")
public class ChatMessageSendDTO {

    String question;

}
