package com.ethercraft.entity;

import com.ethercraft.enumeration.OperationType;
import com.ethercraft.enumeration.ResourceType;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OperationLog {

    private Long id;

    private Long userId;

    private OperationType operationType;

    private ResourceType resourceType;

    private Long resourceId;

    private String description;

    private String ipAddress;

    private String userAgent;

    private LocalDateTime createTime;

}
