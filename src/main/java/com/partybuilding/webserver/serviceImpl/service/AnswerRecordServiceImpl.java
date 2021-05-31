package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceAnswerRecordMapper;
import com.partybuilding.webserver.dto.service.answerRecord.AnswerRecordListDTO;
import com.partybuilding.webserver.dto.service.answerRecord.GetAnswerRecordInputDTO;
import com.partybuilding.webserver.dto.service.answerRecord.GetAnswerRecordListInputDTO;
import com.partybuilding.webserver.dto.service.answerRecord.Question;
import com.partybuilding.webserver.dto.service.leavewords.LeaveWordsListDTO;
import com.partybuilding.webserver.entity.service.ServiceQuestion;
import com.partybuilding.webserver.service.service.AnswerRecordService;
import com.partybuilding.webserver.util.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Service
public class AnswerRecordServiceImpl implements AnswerRecordService {

    @Autowired
    private ServiceAnswerRecordMapper serviceAnswerRecordMapper;

    /**
     * 获取列表
     * @param inputDTO
     * @return
     */
    @Override
    public PageResult<AnswerRecordListDTO> getAnswerRecordList(GetAnswerRecordListInputDTO inputDTO) {
        //  判断参数是否有误
        if(inputDTO.getCurrentPage() <= 0){
            inputDTO.setCurrentPage(1);  //设置默认当前页
        }
        if(inputDTO.getPageSize() <= 0) {
            inputDTO.setPageSize(5); // 默认每页5条
        }



        PageHelper.startPage(inputDTO.getCurrentPage(),inputDTO.getPageSize());
        List<AnswerRecordListDTO> lists = serviceAnswerRecordMapper.getAnswerRecordList(inputDTO);
        System.out.println(inputDTO.getContent());

        for(AnswerRecordListDTO dto : lists){
            dto.setPosition(serviceAnswerRecordMapper.getPosition(dto.getPartyId()));
        }

        // 获取分页查询后的数据
        PageInfo<AnswerRecordListDTO> pageInfo = new PageInfo<>(lists);
        // 封装需要返回的分页实体
        PageResult<AnswerRecordListDTO> result = new PageResult<AnswerRecordListDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(lists);

        return result;
    }

    /**
     * 获取一条记录
     * @param inputDTO
     * @return
     */
    @Override
    public AnswerRecordListDTO getAnswerRecordDetailsById(GetAnswerRecordInputDTO inputDTO) {
        System.out.println(inputDTO.getAnswerRecordId());
        AnswerRecordListDTO dto = serviceAnswerRecordMapper.getAnswerRecordById(inputDTO.getAnswerRecordId());

        PageHelper.startPage(inputDTO.getCurrentPage(),inputDTO.getPageSize());
        System.out.println(dto);
        System.out.println(dto.getAnswerTime());
        List<Question> lists = serviceAnswerRecordMapper.getQuestionListByAnswerRecordId(inputDTO.getAnswerRecordId());


        // 获取分页查询后的数据
        PageInfo<Question> pageInfo = new PageInfo<>(lists);
        // 封装需要返回的分页实体
        PageResult<Question> result = new PageResult<Question>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(lists);

        dto.setQuestionTotal(result.getTotal());
        dto.setQuestions(result.getList());

        return dto;
    }
}
