package com.partybuilding.webserver.service.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.dynamic.essay.AllEssaysListDto;
import com.partybuilding.webserver.dto.dynamic.essay.CheckFormDto;
import com.partybuilding.webserver.dto.dynamic.essay.InsertEssayDto;
import com.partybuilding.webserver.dto.dynamic.essay.QueryEssayBodyDto;


public interface DyPublishEssayService {

    JsonResult getPublishEssayListByOrganization(AllEssaysListDto getListDto);

    JsonResult makeSingleEssayLeave(CheckFormDto leaveFormDto);

    JsonResult makeManyEssayLeave(CheckFormDto leaveFormDto);

    JsonResult publishSingleEssayFromList(CheckFormDto publishFormDto);

    //白写了不需要
    JsonResult publishManyEssayFromList(CheckFormDto publishFormListDto);

    JsonResult setTop(CheckFormDto publishFormDto);

    JsonResult setOutTop(CheckFormDto publishFormDto);

    JsonResult queryByTimeZone(QueryEssayBodyDto queryBodyDto);

    JsonResult queryByInputContent(QueryEssayBodyDto queryBodyDto);

    JsonResult getQueryByInputAndTime(QueryEssayBodyDto queryBodyDto);

    JsonResult deleteByEssayIdFromList(String essayId);

    JsonResult insertNewEssay(InsertEssayDto insertEssayDto);

    JsonResult getUpdateEssayInf(String essayId);

    JsonResult updataEssayById(InsertEssayDto insertEssayDto);
}
