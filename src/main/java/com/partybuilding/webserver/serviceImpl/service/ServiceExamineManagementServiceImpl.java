package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceExaminationManagementMapper;
import com.partybuilding.webserver.dao.service.ServiceExaminationQuestionMapper;
import com.partybuilding.webserver.dto.service.question.ExamineListDTO;
import com.partybuilding.webserver.dto.service.question.ExamineManageDTO;
import com.partybuilding.webserver.dto.service.question.QueryExamineInputDTO;
import com.partybuilding.webserver.dto.service.question.ReleaseExamineDTO;
import com.partybuilding.webserver.entity.service.ServiceExaminationManagement;
import com.partybuilding.webserver.entity.service.ServiceExaminationQuestion;
import com.partybuilding.webserver.entity.service.ServiceQuestion;
import com.partybuilding.webserver.service.service.ServiceExamineManagementService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ServiceExamineManagementServiceImpl implements ServiceExamineManagementService{
    @Autowired
    private ServiceExaminationManagementMapper serviceExaminationManagementMapper;
    @Autowired
    private ServiceExaminationQuestionMapper serviceExaminationQuestionMapper;

    @Override
    public String getQuestionCategoryId(String questionCategory) {
        return serviceExaminationManagementMapper.getQuestionCategoryId(questionCategory);
    }

    @Override
    public boolean addExamine(ExamineManageDTO serviceExaminationManagement) {
        return serviceExaminationManagementMapper.addExamine(serviceExaminationManagement)>0;
    }

    /**
     * 修改考题
     * @param serviceExaminationManagement
     * @return
     */
    @Override
    public boolean updateExamine(ExamineManageDTO serviceExaminationManagement) {
        return serviceExaminationManagementMapper.updateExamine(serviceExaminationManagement) > 0;
    }

    @Override
    public boolean releaseExamine(ReleaseExamineDTO releaseExamineDTO) {
        boolean isTrue = true;
        for(String id: releaseExamineDTO.getId()){
           isTrue = serviceExaminationManagementMapper.releaseExamine(id,releaseExamineDTO.getReleaseTime())>0;
        }
        return isTrue;
    }

    @Override
    public boolean addIntoExamineQuestion(ServiceExaminationQuestion serviceExaminationQuestion) {
        String id = serviceExaminationQuestion.getId();
        String examinationId = serviceExaminationQuestion.getExaminationId();
        String questionId = serviceExaminationQuestion.getQuestionId();
        return serviceExaminationQuestionMapper.addIntoExamineQuestion(id,examinationId,questionId)>0;
    }

    @Override
    public boolean earlyTermination(String id, Date date) {
        return serviceExaminationManagementMapper.earlyTermination(id,date)>0;
    }

    @Override
    public PageResult<ExamineListDTO> getExamineQuestionQueryList(QueryExamineInputDTO inputDTO) {
        //  判断参数是否有误
        if(inputDTO.getCurrentPage() <= 0){
            inputDTO.setCurrentPage(1);  //设置默认当前页
        }
        if(inputDTO.getPageSize() <= 0) {
            inputDTO.setPageSize(5); // 默认每页5条
        }


        PageHelper.startPage(inputDTO.getCurrentPage(),inputDTO.getPageSize());
        List<ExamineListDTO> lists = serviceExaminationManagementMapper.getExamineQuestionQueryList(inputDTO);


        for(ExamineListDTO dto : lists){
            dto.setQuestionsNumber(serviceExaminationManagementMapper.getQuestionsNumber(dto.getId()));
            dto.setRespondentNumber(serviceExaminationManagementMapper.getRespondentNumber(dto.getId()));
            List<ServiceQuestion> questions = serviceExaminationManagementMapper.getQuestionListByExamineId(dto.getId());
            dto.setQuestions(questions);
        }

        // 获取分页查询后的数据
        PageInfo<ExamineListDTO> pageInfo = new PageInfo<>(lists);
        // 封装需要返回的分页实体
        PageResult<ExamineListDTO> result = new PageResult<ExamineListDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());

        // 设置数据库集合
        result.setList(lists);

        return result;
    }

    @Override
    public ExamineListDTO getExamineQuestionById(String id) {
        return serviceExaminationManagementMapper.getExamineQuestionById(id);
    }

    /**
     * 删除考题问题记录
     * @param id
     * @return
     */
    @Override
    public boolean deleteExamineQuestionById(String id) {
        return serviceExaminationManagementMapper.deleteQuestionIdByExamineId(id);
    }

    /**
     * 删除考题
     * @param id
     * @return
     */
    public boolean deleteExamineById(String id){
        return serviceExaminationManagementMapper.deleteExamineById(id);
    }


    /**
     * 获取所有数据
     * @return
     */
    public List<ServiceExaminationManagement> selectAllExamineQuestion(){
        return serviceExaminationManagementMapper.selectAllExamineQuestion();
    }

    /**
     * 改变状态
     * @param state
     * @param examineId
     * @return
     */
    public boolean updateState(Integer state,String examineId){
        return serviceExaminationManagementMapper.updateState(state,examineId);
    }

}
