package com.ethercraft.entity;

import io.swagger.v3.oas.annotations.media.Schema;

import com.ethercraft.enumeration.SpaceMemberStatus;
import com.ethercraft.enumeration.SpaceRole;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "空间成员实体")
public class SpaceMember {

    // 主键 ID
    @Schema(description = "主键 ID")
    private Long id;

    // 知识空间 ID
    @Schema(description = "知识空间 ID")
    private Long spaceId;

    // 空间角色
    @Schema(description = "空间角色")
    private SpaceRole spaceRole;

    // 状态
    @Schema(description = "状态")
    private SpaceMemberStatus status;

    // 加入时间
    @Schema(description = "加入时间")
    private LocalDateTime joinTime;

    // 创建时间
    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    // 更新时间
    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
