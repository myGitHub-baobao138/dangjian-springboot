package com.partybuilding.webserver.service.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDataDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeQueryDataDto;

import java.util.List;

public interface DyClickLikeService {
  //根据学院id获取点赞列表的数据
  JsonResult getClickLikeInfo(ClickLikeDataDto clickLikeDataDto);

  JsonResult  selectClickLikeListBySearch(ClickLikeQueryDataDto clickLikeQueryDataDto);
}
