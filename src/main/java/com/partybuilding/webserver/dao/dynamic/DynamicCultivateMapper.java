package com.partybuilding.webserver.dao.dynamic;

import com.partybuilding.webserver.dto.dynamic.cultivate.CreateCultivateEssayInDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.CultivateEssayDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.CultivateEssayPageDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.modifyEssayInDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
public interface DynamicCultivateMapper {
    List<CultivateEssayDto> findEssayInformation(CultivateEssayPageDto dto);
    int createUserAccount(CreateCultivateEssayInDto inDto);
    int deleteCultivateEssayById(String cultivateEssayId);
    int publishEssayById(String cultivateEssayId);
    int modifyEssayById(modifyEssayInDto inDto);
}
