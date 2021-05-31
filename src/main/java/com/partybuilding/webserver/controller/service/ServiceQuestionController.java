package com.partybuilding.webserver.controller.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.service.question.EditQuestionDTO;
import com.partybuilding.webserver.dto.service.question.QuestionTypeDTO;
import com.partybuilding.webserver.dto.service.volunteer.ServiceBaseDTO;
import com.partybuilding.webserver.entity.service.ServiceQuestion;
import com.partybuilding.webserver.service.service.ServiceQuestionService;
import com.partybuilding.webserver.util.JSONResult;
import com.partybuilding.webserver.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Queue;
import java.util.UUID;

/**
 * 问题Controller
 *
 *
 */

@RestController
@CrossOrigin
@RequestMapping("/Service/questionController")
public class ServiceQuestionController {
    @Autowired
    ServiceQuestionService serviceQuestionService;

    /**
     * 添加问题
     *
     * @param serviceQuestion
     * @return
     */
    @ApiOperation(value = "添加问题", notes = "添加问题")
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    @RequiresPermissions("/Service/questionController/**")
    public JsonResult addQuestion(@RequestBody ServiceQuestion serviceQuestion) {
        JsonResult jsonResult = new JsonResult();
        serviceQuestion.setId(UUID.randomUUID().toString().replace("-", ""));
        boolean success = serviceQuestionService.addQuestion(serviceQuestion);
        if (success) {
            jsonResult.setMessage("新增成功");
            jsonResult.setData(serviceQuestion.getId());
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("题目已存在");
        }
        return jsonResult;
    }

    /**
     * 获取问题列表
     *
     * @param serviceBaseDTO
     * @return
     */
    @ApiOperation(value = "获取问题列表", notes = "获取问题列表")
    @RequestMapping(value = "/getQuestionList", method = RequestMethod.POST)
    @RequiresPermissions("/Service/questionController/**")
    public JsonResult getQuestionList(@RequestBody ServiceBaseDTO serviceBaseDTO) {
        JsonResult jsonResult = new JsonResult();
        PageResult<ServiceQuestion> list = serviceQuestionService.getQuestionList(serviceBaseDTO);
        if (list != null) {
            jsonResult.setMessage("success");
            jsonResult.setData(list);
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("false");
        }
        return jsonResult;
    }

    /**
     * 查看问题
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "根据id查看问题", notes = "根据id查看问题")
    @RequestMapping(value = "/searchQuestionById", method = RequestMethod.GET)
    @RequiresPermissions("/Service/questionController/**")
    public ServiceQuestion searchQuestionById(@RequestParam String id) {
        ServiceQuestion serviceQuestion = serviceQuestionService.searchQuestionById(id);
        return serviceQuestion;
    }

    /**
     * 根据问题分类查询
     *
     * @param questionTypeDTO
     * @return
     */
    @ApiOperation(value = "根据问题分类查询", notes = "根据问题分类查询")
    @RequestMapping(value = "/searchQuestionByType", method = RequestMethod.POST)
    @RequiresPermissions("/Service/questionController/**")
    public JsonResult searchQuestionByType(@RequestBody QuestionTypeDTO questionTypeDTO) {
        JsonResult jsonResult = new JsonResult();
        PageResult<ServiceQuestion> list = serviceQuestionService.searchQuestionByType(questionTypeDTO);
        if (list != null) {
            jsonResult.setMessage("success");
            jsonResult.setData(list);
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("false");
        }

        return jsonResult;
    }

    /**
     * 编辑问题
     *
     * @param editQuestionDTO
     * @return
     */
    @ApiOperation(value = "编辑问题", notes = "编辑问题")
    @RequestMapping(value = "/editQuestion", method = RequestMethod.POST)
    @RequiresPermissions("/Service/questionController/**")
    public JsonResult editQuestion(@RequestBody EditQuestionDTO editQuestionDTO) {
        JsonResult jsonResult = new JsonResult();
        boolean success = serviceQuestionService.editQuestion(editQuestionDTO);
        if (success) {
            jsonResult.setMessage("修改成功");
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("问题已存在");
        }
        return jsonResult;
    }

    /**
     * 获取问题列表
     *
     * @return
     */
    @ApiOperation(value = "获取所有题目", notes = "获取所有题目")
    @RequestMapping(value = "/getAllQuestions", method = RequestMethod.GET)
    @RequiresPermissions("/Service/questionController/**")
    public JSONResult getAllQuestions() {
        JSONResult jsonResult = new JSONResult();
        List<ServiceQuestion> list = serviceQuestionService.getAllQuestions();
        jsonResult.setData(list);
        jsonResult.setTotalCount(list.size());
        return jsonResult;
    }

    /**
     * 删除问题
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "删除问题", notes = "删除问题")
    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET)
    @RequiresPermissions("/Service/questionController/**")
    public JsonResult deleteQuestion(@RequestParam String id) {
        JsonResult jsonResult = new JsonResult();
        //删除问题表里的问题
        boolean success1 = serviceQuestionService.deleteQuestion(id);
        //删除考题-问题表里的映射关系
        boolean success2 = serviceQuestionService.deleteExaminationQuestion(id);
        if (success1) {
            jsonResult.setMessage("删除成功");
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("删除失败");
        }
        return jsonResult;
    }
}
