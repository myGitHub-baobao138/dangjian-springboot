package com.partybuilding.webserver.controller.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.service.question.AddExamineDTO;
import com.partybuilding.webserver.dto.service.question.ExamineManageDTO;
import com.partybuilding.webserver.dto.service.question.QueryExamineInputDTO;
import com.partybuilding.webserver.dto.service.question.ReleaseExamineDTO;
import com.partybuilding.webserver.entity.service.ServiceExaminationQuestion;
import com.partybuilding.webserver.service.service.ServiceExamineManagementService;
import com.partybuilding.webserver.util.Uuid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 考题管理Controller
 *
 */
@RequestMapping("/Service/examineManagementController")
@RestController
@CrossOrigin
@Api
@Transactional
public class ServiceExamineManagementController {
    @Autowired
    ServiceExamineManagementService serviceExamineManagementService;

    /**
     * 新增考题
     * @param addExamineDTO
     * @return
     */
    @ApiOperation(value = "新增考题",notes = "新增考题")
    @RequestMapping(value = "/addExamine",method = RequestMethod.POST)
    @RequiresPermissions("/Service/examineManagementController/**")
    public JsonResult addExamine(@RequestBody AddExamineDTO addExamineDTO){
        JsonResult jsonResult = new JsonResult();
        //创建考题对象
        ExamineManageDTO examineManageDTO = new ExamineManageDTO();
        examineManageDTO.setBeginTime(addExamineDTO.getBeginTime());
        examineManageDTO.setEndTime(addExamineDTO.getEndTime());
        //考题id
        String id = Uuid.getUuid();
        examineManageDTO.setId(id);
        examineManageDTO.setQuestionCategoryId(addExamineDTO.getQuestionCategory());
        examineManageDTO.setReleaseTime(addExamineDTO.getReleaseTime());
        examineManageDTO.setTitle(addExamineDTO.getTitle());
        examineManageDTO.setFounderId(addExamineDTO.getFounderId());
        examineManageDTO.setFounderOrganizationId(addExamineDTO.getFounderOrganizationId());
        //添加考题
        boolean success1 = serviceExamineManagementService.addExamine(examineManageDTO);
        boolean success2 = false;

        if(success1){
            //将问题，考题添加到问题-考题表里形成映射
            for(int i = 0;i < addExamineDTO.getQuestionId().size();i++){
                ServiceExaminationQuestion serviceExaminationQuestion = new ServiceExaminationQuestion();
                //考题id
                serviceExaminationQuestion.setExaminationId(id);
                //问题-考题id
                serviceExaminationQuestion.setId(Uuid.getUuid());
                //问题id
                serviceExaminationQuestion.setQuestionId(addExamineDTO.getQuestionId().get(i));
                success2 = serviceExamineManagementService.addIntoExamineQuestion(serviceExaminationQuestion);
            }
        }

        if(success1 && success2){
            jsonResult.setMessage("success");
        }
        else{
            jsonResult.setCode(500);
            jsonResult.setMessage("考题已存在");
        }
        return jsonResult;
    }

    @ApiOperation(value = "修改考题",notes = "修改考题")
    @RequestMapping(value = "/updateExamineQuestion",method = RequestMethod.POST)
    @RequiresPermissions("/Service/examineManagementController/**")
    public JsonResult updateExamineQuestion(@RequestBody AddExamineDTO addExamineDTO){
        JsonResult jsonResult = new JsonResult();
        boolean isDelete = serviceExamineManagementService.deleteExamineQuestionById(addExamineDTO.getId());
        //创建考题对象
        ExamineManageDTO examineManageDTO = new ExamineManageDTO();
        examineManageDTO.setBeginTime(addExamineDTO.getBeginTime());
        examineManageDTO.setEndTime(addExamineDTO.getEndTime());
        //考题id
        String id = addExamineDTO.getId();
        examineManageDTO.setId(id);
        examineManageDTO.setQuestionCategoryId(addExamineDTO.getQuestionCategory());
        examineManageDTO.setReleaseTime(addExamineDTO.getReleaseTime());
        examineManageDTO.setTitle(addExamineDTO.getTitle());
        examineManageDTO.setFounderId(addExamineDTO.getFounderId());
        examineManageDTO.setFounderOrganizationId(addExamineDTO.getFounderOrganizationId());
        //更新考题
        boolean success1 = serviceExamineManagementService.updateExamine(examineManageDTO);
        boolean success2 = false;

        if(success1){
            //将问题，考题添加到问题-考题表里形成映射
            for(int i = 0;i < addExamineDTO.getQuestionId().size();i++){
                ServiceExaminationQuestion serviceExaminationQuestion = new ServiceExaminationQuestion();
                //考题id
                serviceExaminationQuestion.setExaminationId(id);
                //问题-考题id
                serviceExaminationQuestion.setId(Uuid.getUuid());
                //问题id
                serviceExaminationQuestion.setQuestionId(addExamineDTO.getQuestionId().get(i));
                success2 = serviceExamineManagementService.addIntoExamineQuestion(serviceExaminationQuestion);
            }
        }

        if(success1 && success2){
            jsonResult.setMessage("success");
        }
        else{
            jsonResult.setCode(500);
            jsonResult.setMessage("考题已存在");
        }
        return jsonResult;
    }


    /**
     * 发布考题
     * @param releaseExamineDTO
     * @return
     */
    @ApiOperation(value = "多选发布考题",notes = "多选发布考题")
    @RequestMapping(value = "/releaseExamine",method = RequestMethod.POST)
    @RequiresPermissions("/Service/examineManagementController/**")
    public JsonResult releaseExamine(@RequestBody ReleaseExamineDTO releaseExamineDTO){
        JsonResult jsonResult = new JsonResult();
        boolean success = serviceExamineManagementService.releaseExamine(releaseExamineDTO);
        if(success){
            jsonResult.setData(true);
            jsonResult.setMessage("发布成功");
        }
        else{
            jsonResult.setData(false);
            jsonResult.setCode(500);
            jsonResult.setMessage("发布失败");
        }
        return jsonResult;
    }

    @ApiOperation(value = "删除考题",notes = "删除考题")
    @RequestMapping(value = "/deleteExamineQuestionById",method = RequestMethod.GET)
    @RequiresPermissions("/Service/examineManagementController/**")
    public JsonResult deleteExamineQuestionById(@RequestParam("id") String id){
        JsonResult jsonResult = new JsonResult(serviceExamineManagementService.deleteExamineQuestionById(id) && serviceExamineManagementService.deleteExamineById(id));
        if(jsonResult.getData() == null){
            jsonResult.setData(false);
            jsonResult.setCode(500);
            jsonResult.setMessage("删除失败");
        } else {
            jsonResult.setData(true);
            jsonResult.setMessage("删除成功");
        }

        return jsonResult;
    }



    /**
     * 提前结束考题
     * @param id
     * @return
     */
    @ApiOperation(value = "提前结束考题",notes = "提前结束考题")
    @RequestMapping(value = "/earlyTermination",method = RequestMethod.GET)
    @RequiresPermissions("/Service/examineManagementController/**")
    public JsonResult earlyTermination(@RequestParam String id){
        JsonResult jsonResult = new JsonResult();
        Date date = new Date();
        boolean success = serviceExamineManagementService.earlyTermination(id,date);
        if(success){
            jsonResult.setMessage("结束成功");
            jsonResult.setData(true);
        }
        else{
            jsonResult.setData(false);
            jsonResult.setCode(500);
            jsonResult.setMessage("提前结束失败");
        }
        return jsonResult;
    }


    @ApiOperation(value ="获取考题列表")
    @PostMapping("/getExamineQuestionQueryList")
    @RequiresPermissions("/Service/examineManagementController/**")
    public JsonResult getExamineQuestionQueryList(@RequestBody QueryExamineInputDTO inputDTO){
        JsonResult jsonResult = new JsonResult(serviceExamineManagementService.getExamineQuestionQueryList(inputDTO));
        return jsonResult;
    }

    @ApiOperation(value ="查看考题")
    @GetMapping("/getExamineQuestionById")
    @RequiresPermissions("/Service/examineManagementController/**")
    public JsonResult getExamineQuestionById(String id){
        JsonResult jsonResult = new JsonResult(serviceExamineManagementService.getExamineQuestionById(id));
        return jsonResult;
    }
}
