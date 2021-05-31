package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.dto.service.question.ExamineListDTO;
import com.partybuilding.webserver.dto.service.question.ExamineManageDTO;
import com.partybuilding.webserver.dto.service.question.QueryExamineInputDTO;
import com.partybuilding.webserver.entity.service.ServiceExaminationManagement;
import com.partybuilding.webserver.entity.service.ServiceQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ServiceExaminationManagementMapper {
    int deleteByPrimaryKey(String id);

//    int insert(ServiceExaminationManagement record);

    ServiceExaminationManagement selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ExamineManageDTO record);


    /**
     * 根据问题分类名称获取问题分类id
     * @param questionCategory
     * @return
     */
    String getQuestionCategoryId(@Param("questionCategory") String questionCategory);

    /**
     * 添加考题
     * @param serviceExaminationManagement
     * @return
     */
    int addExamine(ExamineManageDTO serviceExaminationManagement);

    /**
     * 修改考题
     * @param serviceExaminationManagement
     * @return
     */
    int updateExamine(ExamineManageDTO serviceExaminationManagement);

    /**
     * 发布考题
     * @param id
     * @param release
     * @return
     */
    int releaseExamine(@Param("examineId")String id, @Param("releaseTime")String release);

    /**
     * 提前结束考题
     * @param id
     * @param date
     * @return
     */
    int earlyTermination(@Param("id") String id,@Param("endTime") Date date);

    /**
     * 获取所有的考题列表
     * @return
     */
    List<ExamineListDTO> getExamineQuestionList(QueryExamineInputDTO inputDTO);

    /**
     * 按条件获取考题列表(分页)
     * @return
     */
    List<ExamineListDTO> getExamineQuestionQueryList(QueryExamineInputDTO inputDTO);


    /**
     * 根据考题获取问题列表
     * @param examineId
     * @return
     */
    List<ServiceQuestion> getQuestionListByExamineId(String examineId);

    /**
     * 根据考题id获取题目数
     * @param examineId
     * @return
     */
    Integer getQuestionsNumber(String examineId);

    /**
     * 根据考题id获取答题人数
     * @param examineId
     * @return
     */
    Integer getRespondentNumber(String examineId);

    ExamineListDTO getExamineQuestionById(String id);

    /**
     * 删除考题的问题记录
     * @param id
     * @return
     */
    boolean deleteQuestionIdByExamineId(String id);

    /**
     * 删除考题
     * @param id
     * @return
     */
    boolean deleteExamineById(String id);

    /**
     * 获取所有考题
     * @return
     */
    List<ServiceExaminationManagement> selectAllExamineQuestion();

    boolean updateState(@Param("state1")Integer state,@Param("examineId")String examineId);


}