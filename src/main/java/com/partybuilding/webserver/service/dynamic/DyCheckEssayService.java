package com.partybuilding.webserver.service.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.dynamic.essay.AllEssaysListDto;
import com.partybuilding.webserver.dto.dynamic.essay.CheckFormDto;
import com.partybuilding.webserver.dto.dynamic.essay.QueryEssayBodyDto;


public interface DyCheckEssayService {

    JsonResult getCheckEssayListByRankAndOrganization(AllEssaysListDto getListDto);

    JsonResult getEssayDetails(String essayId);

    JsonResult updateEssayBySingleEssayId(CheckFormDto checkFormDto);

    JsonResult queryCheckEssayListByInputContent(QueryEssayBodyDto queryBodyDto);

    JsonResult queryCheckEssayListBySource(QueryEssayBodyDto queryBodyDto);

    JsonResult queryCheckEssayListByCheckStatus(QueryEssayBodyDto queryBodyDto);

    JsonResult queryCheckEssayListByCheckAndInput(QueryEssayBodyDto queryBodyDto);

    JsonResult queryCheckEssayListByCheckAndSource(QueryEssayBodyDto queryBodyDto);

    JsonResult updateManyEssayByEssayIdList(CheckFormDto checkFormListDto);
}
