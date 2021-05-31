package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.dto.service.question.*;
import com.partybuilding.webserver.entity.service.ServiceQuestionCategory;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ServiceQuestionCategoryMapper {
    /**
     * 删除分类
     * @param id
     * @return
     */
    boolean deleteByPrimaryKey(String id);

    boolean deleteExaminationCategoryRecord(String questionCategoryId);

    int insert(ServiceQuestionCategory record);

    int insertSelective(ServiceQuestionCategory record);

    ServiceQuestionCategory selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceQuestionCategory record);

    int updateByPrimaryKey(ServiceQuestionCategory record);

    /**
     * 添加问题分类
     * @param questionCategoryDTO
     * @return
     */
    int addQuestionCategory(QuestionCategoryDTO questionCategoryDTO);

    /**
     * 编辑问题分类
     * @param editQuestionCategoryDTO
     * @return
     */
    int editQuestionCategory(EditQuestionCategoryDTO editQuestionCategoryDTO);

    /**
     * 获取问题分类列表
     * @return
     */
    List<QuestionRegistrationDTO> getQuestionRegistrationList();

    Integer getCount(@Param("name") String name);

    /**
     * 根据问题分类查询
     * @param inputDTO
     * @return
     */
    List<QuestionRegistrationDTO> getListByRegistration(GetQuestionCategoryQueryInputDTO inputDTO);

    /**
     * 查询分类名称是否存在
     * @param categoryName
     * @return
     */
    boolean checkIsExistCategoryName(String categoryName);

    /**
     * 获取分类id和name
     * @return
     */
    List<QuestionCategoryNameIdDTO> getCategoryIdNameList();

}