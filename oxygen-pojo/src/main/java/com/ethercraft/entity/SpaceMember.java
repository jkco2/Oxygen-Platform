package com.ethercraft.entity;

import com.ethercraft.enumeration.SpaceMemberStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "空间成员实体")
public class SpaceMember {

    @Schema(description = "主键 ID")
    private Long id;

    @Schema(description = "知识空间 ID")
    private Long spaceId;

    @Schema(description = "用户 ID")
    private Long userId;

    @Schema(description = "成员状态")
    private SpaceMemberStatus status;

    @Schema(description = "加入时间")
    private LocalDateTime joinTime;

    @Schema(description = "创建时间")
    private LocalDateTime createTime;

    @Schema(description = "更新时间")
    private LocalDateTime updateTime;

}
