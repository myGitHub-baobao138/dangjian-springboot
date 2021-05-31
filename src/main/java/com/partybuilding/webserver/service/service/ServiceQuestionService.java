package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.service.question.EditQuestionDTO;
import com.partybuilding.webserver.dto.service.question.QuestionTypeDTO;
import com.partybuilding.webserver.dto.service.volunteer.ServiceBaseDTO;
import com.partybuilding.webserver.entity.service.ServiceQuestion;
import com.partybuilding.webserver.util.PageResult;

//import javax.xml.ws.Service;
import java.lang.reflect.Type;
import java.util.List;

public interface ServiceQuestionService {
    /**
     * 添加问题
     * @param serviceQuestion
     * @return
     */
    boolean addQuestion(ServiceQuestion serviceQuestion);

    /**
     * 获取问题列表
     * @param serviceBaseDTO
     * @return
     */
    PageResult<ServiceQuestion> getQuestionList(ServiceBaseDTO serviceBaseDTO);

    /**
     * 获取问题总数
     * @return
     */
    Integer getQuestionCount(Integer type);

    /**
     * 查看问题
     * @param id
     * @return
     */
    ServiceQuestion searchQuestionById(String id);

    /**
     * 根据问题分类查询
     * @param questionTypeDTO
     * @return
     */
    PageResult<ServiceQuestion> searchQuestionByType(QuestionTypeDTO questionTypeDTO);

    /**
     * 获取全部问题
     * @return
     */
    List<ServiceQuestion> getAllQuestions();

    /**
     * 编辑问题
     * @param editQuestionDTO
     * @return
     */
    boolean editQuestion(EditQuestionDTO editQuestionDTO);

    /**
     * 删除问题(问题表）
     * @param id
     * @return
     */
    boolean deleteQuestion(String id);

    /**
     * 删除问题(考题-问题表）
     * @param id
     * @return
     */
    boolean deleteExaminationQuestion(String id);
}
