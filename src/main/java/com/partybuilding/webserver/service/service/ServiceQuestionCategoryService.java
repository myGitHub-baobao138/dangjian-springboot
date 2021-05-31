package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.service.question.*;
import com.partybuilding.webserver.dto.service.volunteer.ServiceBaseDTO;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

public interface ServiceQuestionCategoryService {
    /**
     * 添加问题分类
     * @param questionCategoryDTO
     * @return
     */
    boolean addQuestionCategory(QuestionCategoryDTO questionCategoryDTO);

    /**
     * 编辑问题分类
     * @param editQuestionCategoryDTO
     * @return
     */
    boolean editQuestionCategory(EditQuestionCategoryDTO editQuestionCategoryDTO);

    /**
     * 获取问题分类列表
     * @param serviceBaseDTO
     * @return
     */
    PageResult<QuestionRegistrationDTO> getQuestionRegistrationList(ServiceBaseDTO serviceBaseDTO);

    /**
     * 根据分类查询
     * @param inputDTO
     * @return
     */
    PageResult<QuestionRegistrationDTO> getListByRegistration(GetQuestionCategoryQueryInputDTO inputDTO);

    /**
     * 查询分类是否存在
     * @param categoryName
     * @return
     */
    boolean checkIsExistCategoryName(String categoryName);

    /**
     * 删除分类
     * @param id
     * @return
     */
    boolean deleteQuestionCategory(String id);

    /**
     * 获取分类id和name
     * @return
     */
    List<QuestionCategoryNameIdDTO> getCategoryIdNameList();
}
