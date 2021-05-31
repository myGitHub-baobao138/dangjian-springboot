package com.partybuilding.webserver.dao.dynamic;

import com.partybuilding.webserver.dto.dynamic.clickLike.ViewEssayDetailsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DynamicViewEssayDetailsMapper {
  //从点赞列表根据文章id查看文章详情
  ViewEssayDetailsDto viewArticleById(@Param("titleId") String titleId , @Param("type") int  type);
}
