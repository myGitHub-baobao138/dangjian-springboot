package com.partybuilding.webserver.dao.dynamic;

import com.partybuilding.webserver.dto.dynamic.essay.CheckFormDto;
import com.partybuilding.webserver.dto.dynamic.essay.InsertEssayDto;
import com.partybuilding.webserver.dto.dynamic.essay.PublishEssayDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface DynamicPublishEssayMapper {

    //根据组织id 获取此组织全部文章和对应下级组织文章
    List<PublishEssayDto> getPublishEssayList(@Param("organizationId") String organizationId, @Param("organizationRank") int organizationRank);

    //置顶单篇文章
    int makeSingleEssayLeave(@Param("essayId") String essayId,@Param("operatorId") String  operatorId,
                             @Param("operateTime") Date operateTime, @Param("details") String details);

    //批量下架文章
    int makeManyEssayLeave(CheckFormDto leaveFormDto);

    //发布单篇文章（草稿发布）
    int publishSingleEssayFromList(CheckFormDto publishFormDto);

    //批量发布文章（草稿发布）白写了 目测不需要
    int publishManyEssayFromList(CheckFormDto publishFormDto);

    //置顶文章
    int setTop(@Param("essayId") String essayId);

    //取消置顶
    int setOutTop(@Param("checkedEssayId") String checkedEssayId);

    //根据时间段查询获取 发布文章列表信息
    List<PublishEssayDto> queryByTimeZone(
            @Param("organizationId") String organizationId, @Param("organizationRank") int organizationRank,
            @Param("startTime") String startTime, @Param("endTime") String endTime);

    //根据输入的内容 查询 后去文章发布列表信息
    List<PublishEssayDto> queryByInputContent(@Param("organizationId") String organizationId,
                                              @Param("organizationRank") int organizationRank,
                                              @Param("inputContent") String inputContent);

    //根据输入的内容 判断为是根据文章来源查询
    List<PublishEssayDto> queryBySource(@Param("organizationId") String organizationId,
                                        @Param("organizationRank") int organizationRank,
                                        @Param("source") int source);

    //根据输入内容和时间段同时查询
    List<PublishEssayDto> queryByInputAndTime(
            @Param("organizationId") String organizationId, @Param("organizationRank") int organizationRank,
            @Param("inputContent") String inputContent,
            @Param("startTime") String startTime, @Param("endTime") String endTime);

    //根据输入的内容 判断为是根据文章来源和时间段同时查询
    List<PublishEssayDto> queryBySourceAndTime(
            @Param("organizationId") String organizationId, @Param("organizationRank") int organizationRank,
            @Param("source") int source,
            @Param("startTime") String startTime, @Param("endTime") String endTime);

    //删除草稿
    int deleteByIdFromList(@Param("essayId") String essayId);

    //发布文章/保存草稿
    int insertNewEssay(InsertEssayDto insertEssayDto);

    //编辑文字---获取草稿内容
    InsertEssayDto getUpdateEssayById(@Param("essayId") String essayId);

    //修改草稿
    int updateEssayById(InsertEssayDto insertEssayDto);

    //发布草稿
    int publishEssayById(InsertEssayDto updateEssayDto);
}
