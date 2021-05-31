package com.partybuilding.webserver.service.dynamic;

import com.partybuilding.webserver.dto.dynamic.cultivate.CreateCultivateEssayInDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.CultivateEssayDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.CultivateEssayPageDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.modifyEssayInDto;
import com.partybuilding.webserver.util.PageResult;

public interface DyCultivateService {
    /*
     * （模糊）查找所有文章内容*/
    PageResult<CultivateEssayDto> findEssayInformation(CultivateEssayPageDto dto);
    /*
     * 创建文章*/
    int createCultivateEssay(CreateCultivateEssayInDto inDto);
    /*删除文章*/
    int deleteCultivateEssayById(String cultivateEssayId);
    /*发布文章*/
    int publishEssayById(String[] cultivateEssayId);
    /*修改文章*/
    int modifyEssayById(modifyEssayInDto inDto);
}
