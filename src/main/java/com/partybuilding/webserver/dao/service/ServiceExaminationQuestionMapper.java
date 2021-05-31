package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.entity.service.ServiceExaminationQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ServiceExaminationQuestionMapper {
    int deleteByPrimaryKey(String id);

//    int insert(ServiceExaminationQuestion record);

    int insertSelective(ServiceExaminationQuestion record);

    ServiceExaminationQuestion selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceExaminationQuestion record);

    int updateByPrimaryKey(ServiceExaminationQuestion record);

    /**
     * 添加问题到考题-问题表
     * @param id
     * @param examinationId
     * @param questionId
     * @return
     */
    int addIntoExamineQuestion(@Param("id")String id,@Param("examinationId")String examinationId,@Param("questionId")String questionId);
}