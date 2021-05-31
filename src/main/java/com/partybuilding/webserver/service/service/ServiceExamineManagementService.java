package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.InputDTO;
import com.partybuilding.webserver.dto.service.question.ExamineListDTO;
import com.partybuilding.webserver.dto.service.question.ExamineManageDTO;
import com.partybuilding.webserver.dto.service.question.QueryExamineInputDTO;
import com.partybuilding.webserver.dto.service.question.ReleaseExamineDTO;
import com.partybuilding.webserver.entity.service.ServiceExaminationManagement;
import com.partybuilding.webserver.entity.service.ServiceExaminationQuestion;
import com.partybuilding.webserver.util.PageResult;

import java.util.Date;
import java.util.List;

/**
 */
public interface ServiceExamineManagementService {
    /**
     * 根据问题分类名称获取问题分类id
     * @param questionCategory
     * @return
     */
    String getQuestionCategoryId(String questionCategory);

    /**
     * 添加考题
     * @param serviceExaminationManagement
     * @return
     */
    boolean addExamine(ExamineManageDTO serviceExaminationManagement);

    /**
     * 修改考题
     * @param serviceExaminationManagement
     * @return
     */
    boolean updateExamine(ExamineManageDTO serviceExaminationManagement);

    /**
     * 发布考题
     * @param releaseExamineDTO
     * @return
     */
    boolean releaseExamine(ReleaseExamineDTO releaseExamineDTO);

    /**
     * 添加问题到考题-问题表
     * @param serviceExaminationQuestion
     * @return
     */
    boolean addIntoExamineQuestion(ServiceExaminationQuestion serviceExaminationQuestion);

    /**
     * 提前结束考题
     * @param id
     * @param date
     * @return
     */
    boolean earlyTermination(String id, Date date);


    /**
     * 按条件获取考题列表（分页）
     * @param inputDTO
     * @return
     */
    PageResult<ExamineListDTO> getExamineQuestionQueryList(QueryExamineInputDTO inputDTO);

    /**
     * 获取考题by id
     * @param id
     * @return
     */
    ExamineListDTO getExamineQuestionById(String id);

    /**
     * 删除考题
     * @param id
     * @return
     */
    boolean deleteExamineQuestionById(String id);

    /**
     * 删除考题
     * @param id
     * @return
     */
    boolean deleteExamineById(String id);

    List<ServiceExaminationManagement> selectAllExamineQuestion();

    boolean updateState(Integer state,String examineId);
}
