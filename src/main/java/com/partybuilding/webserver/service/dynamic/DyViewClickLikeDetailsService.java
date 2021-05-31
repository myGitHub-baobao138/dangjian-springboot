package com.partybuilding.webserver.service.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeListDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeListQueryDto;

public interface DyViewClickLikeDetailsService {
  JsonResult viewClickLikeDetails(ClickLikeListDto clickLikeListDto);

  JsonResult selectPraiseRecordByTime(ClickLikeListQueryDto clickLikeListQueryDto);
}

