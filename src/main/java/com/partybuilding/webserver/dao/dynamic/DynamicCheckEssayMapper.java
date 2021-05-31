package com.partybuilding.webserver.dao.dynamic;


import com.partybuilding.webserver.dto.dynamic.essay.EssayDto;
import com.partybuilding.webserver.dto.dynamic.essay.CheckFormDto;
import com.partybuilding.webserver.dto.dynamic.essay.EssayDetailsDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface DynamicCheckEssayMapper {

    //根据组织id 和组织等级 获取稿件
    List<EssayDto> getCheckEssayListByRankAndOrganization(
            @Param("organizationId") String organizationId,
            @Param("organizationRank") int organizationRank);

    //根据稿件id获取稿件具体内容
    EssayDetailsDto getEssayDetails(String essayId);

    //管理员审核稿件
    //根据稿件id 去修改审核状态， 审核人id，审核时间， 审核说明
    int updateEssayBySingleEssayId(@Param("essayId") String essayId, @Param("checkStatus") int checkStatus,
                                   @Param("reviewerId") String reviewerId,
                                   @Param("checkTime") Date checkTime, @Param("checkDiscription") String checkDiscription);

    //查询 根据学院（组织）/标题/内容/投稿人/审核人/  进行模糊查询
    List<EssayDto> queryCheckEssayListByInputContent(@Param("inputContent") String inputContent,
                                                     @Param("organizationId") String organizationId,
                                                     @Param("organizationRank") int organizationRank);

    //查询 根据 稿件来源 进行查询
    List<EssayDto> queryCheckEssayListBySource(@Param("source") int source,
                                               @Param("organizationId") String organizationId,
                                               @Param("organizationRank") int organizationRank);

    //查询 根据 审核状态 进行查询
    List<EssayDto> queryCheckEssayListByCheckStatus(@Param("checkStatus") int checkStatus,
                                                    @Param("organizationId") String organizationId,
                                                    @Param("organizationRank") int organizationRank);

    //输入内容和审核状态 查询 根据审核状态和输入内容 同时进行查询
    List<EssayDto> queryCheckEssayListByCheckStatusAndInputContent(@Param("inputContent") String inputContent,
                                                                   @Param("checkStatus") int checkStatus,
                                                                   @Param("organizationId") String organizationId,
                                                                   @Param("organizationRank") int organizationRank);

    //输入内容和审核状态 查询 根据审核状态和输入内容 同时进行查询
    List<EssayDto> queryCheckEssayListByCheckStatusAndSource(@Param("source") int source,
                                                             @Param("checkStatus") int checkStatus,
                                                             @Param("organizationId") String organizationId,
                                                             @Param("organizationRank") int organizationRank);

    int updateManyEssayByEssayIdList( CheckFormDto checkFormDto);
}
