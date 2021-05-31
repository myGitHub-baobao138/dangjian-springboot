package com.partybuilding.webserver.dao.dynamic;

import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DynamicClickLikeMapper {
  //得到点赞列表的数据
  List<ClickLikeDto> selectClickLikeInfo(@Param("organizationId") String organizationId, @Param("organizationRank") int organizationRank);

  //通过查询得到点赞管理列表的数据
  List<ClickLikeDto>   selectClickLikeListBySearch(@Param("organizationId")String organizationId,@Param("organizationRank") int organizationRank, @Param("inputContent") String inputContent, @Param("startTime") String startTime ,@Param("endTime") String endTime);

}
