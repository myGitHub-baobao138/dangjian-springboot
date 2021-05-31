package com.partybuilding.webserver.dao.service;

import com.partybuilding.webserver.dto.service.answerRecord.AnswerRecordListDTO;
import com.partybuilding.webserver.dto.service.answerRecord.GetAnswerRecordInputDTO;
import com.partybuilding.webserver.dto.service.answerRecord.GetAnswerRecordListInputDTO;
import com.partybuilding.webserver.dto.service.answerRecord.Question;
import com.partybuilding.webserver.entity.service.ServiceAnswerRecord;
import com.partybuilding.webserver.entity.service.ServiceQuestion;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ServiceAnswerRecordMapper {

    /**
     * 获取记录列表
     * @param inputDTO
     * @return
     */
    List<AnswerRecordListDTO> getAnswerRecordList(GetAnswerRecordListInputDTO inputDTO);

    /**
     * 获取问题列表
     * @param id
     * @return
     */
    List<Question> getQuestionListByAnswerRecordId(String id);

    /**
     * 获取答题记录通过id
     * @param answerRecordId
     * @return
     */
    AnswerRecordListDTO getAnswerRecordById(String answerRecordId);

    /**
     * 获取职务
     * @param partyId
     * @return
     */
    List<String> getPosition(String partyId);


    int deleteByPrimaryKey(String id);

    int insert(ServiceAnswerRecord record);

    int insertSelective(ServiceAnswerRecord record);

    ServiceAnswerRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServiceAnswerRecord record);

    int updateByPrimaryKey(ServiceAnswerRecord record);
}