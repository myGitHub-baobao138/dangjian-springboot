package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.entity.service.ServiceVoteOption;

public interface ServiceVoteOptionService {
    int insertList(ServiceVoteOption serviceVoteOption);
    JsonResult deleteOption(String voteId);
}
