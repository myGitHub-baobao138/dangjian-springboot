package com.partybuilding.webserver.dao.dynamic;

import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDetaislDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
@Repository
public interface DynamicClickLikeDetailsMapper {
  //根据文章id查看点赞详情列表
  List<ClickLikeDetaislDto> viewClickLikeDetails(@Param("id") String id);

  //根据点赞的时间范围查找该文章的点赞记录
  List<ClickLikeDetaislDto>  selectPraiseRecordByTime(@Param("startTime") String startTime,@Param("endTime") String endTime, @Param("articleId")String articleId);
}
