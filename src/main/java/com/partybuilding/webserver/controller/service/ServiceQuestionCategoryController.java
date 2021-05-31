package com.partybuilding.webserver.controller.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.service.question.EditQuestionCategoryDTO;
import com.partybuilding.webserver.dto.service.question.GetQuestionCategoryQueryInputDTO;
import com.partybuilding.webserver.dto.service.question.QuestionCategoryDTO;
import com.partybuilding.webserver.dto.service.question.QuestionRegistrationDTO;
import com.partybuilding.webserver.dto.service.volunteer.ServiceBaseDTO;
import com.partybuilding.webserver.service.service.ServiceQuestionCategoryService;
import com.partybuilding.webserver.util.JSONResult;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
//import jdk.nashorn.internal.scripts.JD;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


/**
 * 问题分类Controller
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/Service/questionCategoryController")
public class ServiceQuestionCategoryController {

    @Autowired
    private ServiceQuestionCategoryService serviceQuestionCategoryService;

    /**
     * 创建问题分类
     *
     * @param questionCategoryDTO
     * @return
     */
    @ApiOperation(value = "创建问题分类", notes = "创建问题分类")
    @RequestMapping(value = "/addQuestionCategory", method = RequestMethod.POST)
    @RequiresPermissions("/Service/questionCategoryController/**")
    public JsonResult addQuestionCategory(@RequestBody QuestionCategoryDTO questionCategoryDTO) {
        JsonResult jsonResult = new JsonResult();
        String id = UUID.randomUUID().toString().replace("-", "");
        questionCategoryDTO.setId(id);
        boolean success = serviceQuestionCategoryService.addQuestionCategory(questionCategoryDTO);
        if (success) {
            jsonResult.setMessage("新增成功");
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("分类已存在");
        }
        return jsonResult;
    }

    /**
     * 编辑问题分类
     *
     * @param editQuestionCategoryDTO
     * @return
     */
    @ApiOperation(value = "编辑问题分类", notes = "编辑问题分类")
    @RequestMapping(value = "/editQuestionCategory", method = RequestMethod.POST)
    @RequiresPermissions("/Service/questionCategoryController/**")
    public JsonResult editQuestionCategory(@RequestBody EditQuestionCategoryDTO editQuestionCategoryDTO) {
        JsonResult jsonResult = new JsonResult();
        boolean success = serviceQuestionCategoryService.editQuestionCategory(editQuestionCategoryDTO);
        if (success) {
            jsonResult.setMessage("修改成功");
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("问题分类已存在");
        }
        return jsonResult;
    }

    /**
     * 获取问题分类列表
     *
     * @param serviceBaseDTO
     * @return
     */
    @ApiOperation(value = "获取问题分类列表", notes = "获取问题分类列表")
    @RequestMapping(value = "/getQuestionRegistrationList", method = RequestMethod.GET)
    @RequiresPermissions("/Service/questionCategoryController/**")
    public JsonResult getQuestionRegistrationList(ServiceBaseDTO serviceBaseDTO) {
        JsonResult jsonResult = new JsonResult();
        PageResult<QuestionRegistrationDTO> list = serviceQuestionCategoryService.getQuestionRegistrationList(serviceBaseDTO);
        jsonResult.setData(list);
        jsonResult.setMessage("获取成功");
        return jsonResult;
    }


    /**
     * 根据分类查询
     *
     * @param inputDTO
     * @return
     */
    @ApiOperation(value = "根据分类查询", notes = "根据分类查询")
    @RequestMapping(value = "/getListByRegistration", method = RequestMethod.POST)
    @RequiresPermissions("/Service/questionCategoryController/**")
    public JsonResult getListByRegistration(@RequestBody GetQuestionCategoryQueryInputDTO inputDTO) {
        JsonResult jsonResult = new JsonResult();
        PageResult<QuestionRegistrationDTO> questionRegistrations = serviceQuestionCategoryService.getListByRegistration(inputDTO);
        if (questionRegistrations != null) {
            jsonResult.setData(questionRegistrations);
            jsonResult.setMessage("获取成功");
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("获取失败");
        }
        return jsonResult;
    }

    @ApiOperation(value = "检查分类名称是否存在")
    @RequestMapping(value = "/checkIsExistCategoryName", method = RequestMethod.GET)
    @RequiresPermissions("/Service/questionCategoryController/**")
    public JsonResult checkIsExistCategoryName(@RequestParam String categoryName) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(serviceQuestionCategoryService.checkIsExistCategoryName(categoryName));
        return jsonResult;

    }

    @ApiOperation(value = "删除分类")
    @RequestMapping(value = "/deleteCategoryById", method = RequestMethod.GET)
    @RequiresPermissions("/Service/questionCategoryController/**")
    public JsonResult deleteCategoryById(@RequestParam String id) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(serviceQuestionCategoryService.deleteQuestionCategory(id));
        return jsonResult;
    }

    @ApiOperation(value = "获取问题分类id和name")
    @RequestMapping(value = "/getCategoryIdNameList" , method = RequestMethod.GET)
    @RequiresPermissions("/Service/questionCategoryController/**")
    public JsonResult getCategoryIdNameList(){
        JsonResult jsonResult = new JsonResult(serviceQuestionCategoryService.getCategoryIdNameList());
        if(jsonResult.getData() == null) {
            jsonResult.setCode(200);
            jsonResult.setMessage("获取问题分类列表失败");
        } else {
            jsonResult.setMessage("获取问题分类列表成功");
        }
        return jsonResult;
    }
}
