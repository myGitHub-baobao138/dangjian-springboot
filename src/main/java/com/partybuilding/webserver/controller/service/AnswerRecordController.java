package com.partybuilding.webserver.controller.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.service.answerRecord.GetAnswerRecordInputDTO;
import com.partybuilding.webserver.dto.service.answerRecord.GetAnswerRecordListInputDTO;
import com.partybuilding.webserver.service.service.AnswerRecordService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */

@RestController
@CrossOrigin
@RequestMapping("/Service/answerRecordController")
public class AnswerRecordController {

    @Autowired
    private AnswerRecordService answerRecordService;

    @ApiOperation(value = "获取答题记录列表")
    @PostMapping("/getAnswerRecordList")
    @RequiresPermissions("/Service/answerRecordController/**")
    public JsonResult getAnswerRecordList(@RequestBody GetAnswerRecordListInputDTO inputDTO){
        JsonResult jsonResult = new JsonResult(answerRecordService.getAnswerRecordList(inputDTO));
        if(jsonResult.getData() == null){
            jsonResult.setCode(500);
            jsonResult.setMessage("获取失败");
        }
        return jsonResult;
    }

    @ApiOperation(value = "获取答题记录")
    @PostMapping("/getAnswerRecordDetailsById")
    @RequiresPermissions("/Service/answerRecordController/**")
    public JsonResult getAnswerRecordDetailsById(@RequestBody GetAnswerRecordInputDTO inputDTO){
        JsonResult jsonResult = new JsonResult(answerRecordService.getAnswerRecordDetailsById(inputDTO));
        if(jsonResult.getData() == null){
            jsonResult.setCode(500);
            jsonResult.setMessage("获取失败");
        }
        return jsonResult;
    }
}
