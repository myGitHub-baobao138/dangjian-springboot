package com.partybuilding.webserver.service.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.dynamic.clickLike.ViewEssayDetailsDto;

import java.util.List;

public interface DyViewEssayDetaisService {
  JsonResult viewArticleById(String titleId,int type);
}
