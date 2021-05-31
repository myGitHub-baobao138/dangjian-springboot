package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.dto.service.question.EditQuestionDTO;
import com.partybuilding.webserver.entity.service.ServiceQuestion;
import com.partybuilding.webserver.util.PageResult;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ServiceQuestionMapper {
//    int deleteByPrimaryKey(String id);

//    int insert(ServiceQuestion record);

    int insertSelective(ServiceQuestion record);

    ServiceQuestion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceQuestion record);

    int updateByPrimaryKey(ServiceQuestion record);

    int addQuestion(ServiceQuestion serviceQuestion);

    List<ServiceQuestion> getQuestionList();

    Integer getQuestionCount(@Param("type") Integer type);

    ServiceQuestion searchQuestionById(@Param("id")String id);

    List<ServiceQuestion> searchQuestionByType(@Param("type")Integer type);

    int editQuestion(EditQuestionDTO editQuestionDTO);

    List<ServiceQuestion> getAllQuestions();

    int deleteQuestion(@Param("id")String id);

    int deleteExaminationQuestion(@Param("id")String id);
}