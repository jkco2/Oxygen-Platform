package com.ethercraft.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.SpaceRole;
import lombok.Data;

@Data
@Schema(description = "空间成员角色修改请求")
public class KnowledgeMemberUpdateDTO {

    SpaceRole spaceRole;

}
