package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceQuestionCategoryMapper;
import com.partybuilding.webserver.dto.service.question.*;
import com.partybuilding.webserver.dto.service.volunteer.ServiceBaseDTO;
import com.partybuilding.webserver.dto.service.volunteer.SignUpActivityInformationDTO;
import com.partybuilding.webserver.service.service.ServiceQuestionCategoryService;
import com.partybuilding.webserver.util.PageResult;
import org.mapstruct.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceQuestionCategoryServiceImpl implements ServiceQuestionCategoryService {
    @Autowired
    private ServiceQuestionCategoryMapper serviceQuestionCategoryMapper;

    @Override
    public boolean addQuestionCategory(QuestionCategoryDTO questionCategoryDTO) {
        return serviceQuestionCategoryMapper.addQuestionCategory(questionCategoryDTO) > 0;
    }

    @Override
    public boolean editQuestionCategory(EditQuestionCategoryDTO editQuestionCategoryDTO) {
        return serviceQuestionCategoryMapper.editQuestionCategory(editQuestionCategoryDTO)>0;
    }

    @Override
    public PageResult<QuestionRegistrationDTO> getQuestionRegistrationList(ServiceBaseDTO serviceBaseDTO) {
        PageHelper.startPage(serviceBaseDTO.getCurrentPage(),serviceBaseDTO.getPageSize());
        List<QuestionRegistrationDTO> list = serviceQuestionCategoryMapper.getQuestionRegistrationList();

        for(int i = 0; i < list.size(); i++){
            Integer count = serviceQuestionCategoryMapper.getCount(list.get(i).getCategoryName());
            list.get(i).setCount(count);
        }
        // 获取分页查询后的数据
        PageInfo<QuestionRegistrationDTO> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<QuestionRegistrationDTO> result = new PageResult<QuestionRegistrationDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }


    @Override
    public PageResult<QuestionRegistrationDTO> getListByRegistration(GetQuestionCategoryQueryInputDTO inputDTO) {
        PageHelper.startPage(inputDTO.getCurrentPage(),inputDTO.getPageSize());
        List<QuestionRegistrationDTO> list = serviceQuestionCategoryMapper.getListByRegistration(inputDTO);

        for(int i = 0; i < list.size(); i++){
            Integer count = serviceQuestionCategoryMapper.getCount(list.get(i).getCategoryName());
            list.get(i).setCount(count);
        }
        // 获取分页查询后的数据
        PageInfo<QuestionRegistrationDTO> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<QuestionRegistrationDTO> result = new PageResult<QuestionRegistrationDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    @Override
    public boolean checkIsExistCategoryName(String categoryName){
        return serviceQuestionCategoryMapper.checkIsExistCategoryName(categoryName);
    }

    @Override
    public boolean deleteQuestionCategory(String id) {
        boolean isTrue = serviceQuestionCategoryMapper.deleteExaminationCategoryRecord(id);
        return serviceQuestionCategoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<QuestionCategoryNameIdDTO> getCategoryIdNameList() {
        return serviceQuestionCategoryMapper.getCategoryIdNameList();
    }
}
