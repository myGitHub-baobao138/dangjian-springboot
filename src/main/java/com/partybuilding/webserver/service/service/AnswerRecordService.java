package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.service.answerRecord.AnswerRecordListDTO;
import com.partybuilding.webserver.dto.service.answerRecord.GetAnswerRecordInputDTO;
import com.partybuilding.webserver.dto.service.answerRecord.GetAnswerRecordListInputDTO;
import com.partybuilding.webserver.util.PageResult;


/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 答题记录
 */
public interface AnswerRecordService {
    /**
     * 获取列表
     * @param inputDTO
     * @return
     */
    public PageResult<AnswerRecordListDTO> getAnswerRecordList( GetAnswerRecordListInputDTO inputDTO);

    /**
     * 获取答题记录详情信息
     * @return
     */
    public AnswerRecordListDTO getAnswerRecordDetailsById(GetAnswerRecordInputDTO inputDTO);
}
