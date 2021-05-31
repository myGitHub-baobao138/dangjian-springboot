package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceQuestionMapper;
import com.partybuilding.webserver.dto.service.question.EditQuestionDTO;
import com.partybuilding.webserver.dto.service.question.QuestionTypeDTO;
import com.partybuilding.webserver.dto.service.volunteer.ServiceBaseDTO;
import com.partybuilding.webserver.entity.service.ServiceQuestion;
import com.partybuilding.webserver.entity.service.ServiceVolunteerActivity;
import com.partybuilding.webserver.service.service.ServiceQuestionService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceQuestionServiceImpl implements ServiceQuestionService{
    @Autowired
    private ServiceQuestionMapper serviceQuestionMapper;

    @Override
    public boolean addQuestion(ServiceQuestion serviceQuestion) {
        return serviceQuestionMapper.addQuestion(serviceQuestion) > 0;
    }

    @Override
    public PageResult<ServiceQuestion> getQuestionList(ServiceBaseDTO serviceBaseDTO) {
        PageHelper.startPage(serviceBaseDTO.getCurrentPage(),serviceBaseDTO.getPageSize());
        List<ServiceQuestion> list = serviceQuestionMapper.getQuestionList();
        // 获取分页查询后的数据
        PageInfo<ServiceQuestion> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<ServiceQuestion> result = new PageResult<ServiceQuestion>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    @Override
    public Integer getQuestionCount(Integer type) {
        return serviceQuestionMapper.getQuestionCount(type);
    }

    @Override
    public ServiceQuestion searchQuestionById(String id) {
        return serviceQuestionMapper.searchQuestionById(id);
    }

    @Override
    public PageResult<ServiceQuestion> searchQuestionByType(QuestionTypeDTO questionTypeDTO) {
        Integer type = questionTypeDTO.getQuestionType();

        PageHelper.startPage(questionTypeDTO.getCurrentPage(),questionTypeDTO.getPageSize());
        List<ServiceQuestion> list = serviceQuestionMapper.searchQuestionByType(type);
        // 获取分页查询后的数据
        PageInfo<ServiceQuestion> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<ServiceQuestion> result = new PageResult<ServiceQuestion>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    @Override
    public List<ServiceQuestion> getAllQuestions() {
        return serviceQuestionMapper.getAllQuestions();
    }

    @Override
    public boolean editQuestion(EditQuestionDTO editQuestionDTO) {
        return serviceQuestionMapper.editQuestion(editQuestionDTO) > 0;
    }

    @Override
    public boolean deleteQuestion(String id) {
        return serviceQuestionMapper.deleteQuestion(id) > 0;
    }

    @Override
    public boolean deleteExaminationQuestion(String id) {
        return serviceQuestionMapper.deleteExaminationQuestion(id) > 0;
    }
}
