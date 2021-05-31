package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.service.voteDto.AddVoteDto;
import com.partybuilding.webserver.dto.service.voteDto.SelectByTitleOrTimeOrStatusDto;
import com.partybuilding.webserver.dto.service.voteDto.ServiceVoteSelectByTitleDto;
import com.partybuilding.webserver.dto.service.voteDto.ServiceVoteDto;
import com.partybuilding.webserver.entity.service.ServiceVote;
import com.partybuilding.webserver.util.PageResult;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ServiceVoteService {
    int deleteByPrimaryKey(String voteId);

    int insert(ServiceVoteDto record);

    JsonResult insertSelective(AddVoteDto record) throws ParseException;

    ServiceVote selectByPrimaryKey(String voteId);


    int updateByPrimaryKeyWithBLOBs(ServiceVote record);
    JsonResult updateByPrimaryKeySelective(AddVoteDto record);

    int updateByPrimaryKey(ServiceVote record);

    JsonResult selectByTitle(ServiceVoteSelectByTitleDto serviceVoteSelectByTitleDto);

    JsonResult selectVoteByStatus(Integer status, PageInputDTO pageInputDTO);

    PageResult<ServiceVoteDto> selectVoteByBeginTime(Date beginTime,PageInputDTO pageInputDTO);

    JsonResult selectByTitleAndTimeAndStatus(SelectByTitleOrTimeOrStatusDto selectByTitleOrTimeOrStatusDto);


}
