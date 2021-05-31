package com.partybuilding.webserver.serviceImpl.service;

import com.partybuilding.webserver.dao.service.ServiceVoteOptionMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.entity.service.ServiceVoteOption;
import com.partybuilding.webserver.service.service.ServiceVoteOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ServiceVoteOptionServiceImpl implements ServiceVoteOptionService {
    @Autowired
    ServiceVoteOptionMapper serviceVoteOptionMapper;


    @Override
    public int insertList(ServiceVoteOption serviceVoteOption) {
        return 0;
    }

    @Override
    public JsonResult deleteOption(String voteId) {
        JsonResult jsonResult =  new JsonResult();

        int success = serviceVoteOptionMapper.deleteVote(voteId);
        if (success>0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("删除成功");
        }else {
            jsonResult.setCode(500);
            jsonResult.setMessage("删除错误");
        }
        return jsonResult;
    }
}
