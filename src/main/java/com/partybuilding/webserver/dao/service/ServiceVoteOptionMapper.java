package com.partybuilding.webserver.dao.service;

import com.partybuilding.webserver.entity.service.ServiceVoteOption;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ServiceVoteOptionMapper {
    //
    int insertList(@Param("voteOptions") List<ServiceVoteOption> serviceVoteOption);
    int deleteVote(String voteId);
    int updateVote(@Param("voteOptions") List<ServiceVoteOption> serviceVoteOptions);
}
