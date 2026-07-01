package com.ethercraft.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface KnowledgeBaseMapper {

    Long selectSpaceIdById(@Param("kbId") Long kbId);

}
