package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.dto.service.voteDto.*;
import com.partybuilding.webserver.entity.service.ServiceVote;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.List;

@Mapper
@Repository
public interface ServiceVoteMapper {
    int deleteByPrimaryKey(String voteId);

    int insert(ServiceVote record);

    int insertSelective(ServiceVote record);

    ServiceVote selectByPrimaryKey(String voteId);

//    int updateByPrimaryKeySelective(ServiceVote record);
//
//    int updateByPrimaryKeyWithBLOBs(ServiceVote record);

    int updateByPrimaryKey(ServiceVote record);

    /**
     * 根据title查找
     * @param title
     * @return
     */
//    List<ServiceVoteDto> selectByTitle(String title);

    /**
     * 根据状态查找
     * @param status
     * @return
     */
    List<ServiceVoteDto> selectVoteByStatus(Integer status);

    List<ServiceVoteDto> selectVoteByBeginTime(String beginTime);

    List<ServiceVoteDto> selectVoteByTitleAndAcademy(@Param("title") String title,@Param("academy") String academy );

    List<ServiceVoteDto> selectVoteByStatusAndAcademy(StatusAndAcademy statusAndAcademy);

    List<GetVoteInfoListDto> selectByTitleOrTimeOrStatus(SelectByTitleOrTimeOrStatusDto selectByTitleOrTimeOrStatusDto);

    int updateList(@Param("list") List<ServiceVote> list);

    int updateStatus(@Param("id") String id,@Param("status") int status);

    List<EndTimeAndId> getStatusAndTime();

    List<EndTimeAndId> getBeginTime();
}