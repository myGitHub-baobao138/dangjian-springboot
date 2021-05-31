package com.partybuilding.webserver.controller.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.dynamic.essay.AllEssaysListDto;
import com.partybuilding.webserver.dto.dynamic.essay.CheckFormDto;
import com.partybuilding.webserver.dto.dynamic.essay.InsertEssayDto;
import com.partybuilding.webserver.dto.dynamic.essay.QueryEssayBodyDto;
import com.partybuilding.webserver.service.dynamic.DyPublishEssayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 文章发布管理--controller
 */

@RestController
@CrossOrigin
@RequestMapping("/Dynamic/DyPublishEssayController")
@Api("文章发布管理")

public class DyPublishEssayController {

    @Autowired(required=false)
    DyPublishEssayService service;

    @ApiOperation("根据管理员组织Rank和组织id获取文章列表信息")
    @PostMapping("/getPublishEssayList")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    //currentPage pageSize 组织id 组织等级
    public JsonResult getPublishEssayList(@Validated @RequestBody AllEssaysListDto getListDto){
        return service.getPublishEssayListByOrganization(getListDto);
    }


    @ApiOperation("下架单篇文章")
    @PostMapping("/makeSingleEssayLeave")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    //下架文章id 下架文章标题 下架人id 下架人姓名 下架时间 下架说明
    public JsonResult makeSingleEssayLeave(@Validated @RequestBody CheckFormDto leaveFormDto){
        return service.makeSingleEssayLeave(leaveFormDto);
    }

    @ApiOperation("批量下架多篇文章")
    @PostMapping("/makeManyEssaysLeave")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    public JsonResult makeManyEssayLeave(@Validated @RequestBody CheckFormDto leaveFormDto){
        return service.makeManyEssayLeave(leaveFormDto);
    }

    @ApiOperation("发布单篇文章（草稿发布）")
    @PostMapping("/publishSingleEssayFromList")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    public JsonResult publishSingleEssayFromList(@RequestBody CheckFormDto publishFormDto){
        return service.publishSingleEssayFromList(publishFormDto);
    }

    //白写了嘤嘤嘤
    @ApiOperation("发布批量文章（草稿发布）")
    @PostMapping("/publishManyEssayFromList")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    public  JsonResult publishManyEssayFromList(@RequestBody CheckFormDto publishFormListDto){
        return service.publishManyEssayFromList(publishFormListDto);
    }

    @ApiOperation("置顶文章")
    @PostMapping("/setEssayTop")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    //置顶文章id 文章标题 操作人id 操作人姓名
    public JsonResult setEssayTop(@RequestBody CheckFormDto publishFormDt){
        return service.setTop(publishFormDt);
    }

    @ApiOperation("取消置顶文章")
    @PostMapping("/setEssayOutTop")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    //置顶文章id 文章标题 操作人id 操作人姓名
    public JsonResult setEssayOutTop(@RequestBody CheckFormDto publishFormDto){
        return service.setOutTop(publishFormDto);
    }

    @ApiOperation("根据查询条件（输入内容/时间段） 获取发布文章列表信息")
    @PostMapping("/queryPublishEssayList")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    //组织id 组织等级 输入内容 开始时间 截止时间
    public JsonResult queryPublishEssayList(@Validated @RequestBody QueryEssayBodyDto queryBodyDto){
        JsonResult jsonRuslt = new JsonResult();
        if(queryBodyDto.getInputContent().isEmpty() && !queryBodyDto.getStartTime().isEmpty()){
            //输入内容为空 ->  按时间段去查询文章列表信息
            System.out.println("input为空");
            jsonRuslt = service.queryByTimeZone(queryBodyDto);
        }else if(!queryBodyDto.getInputContent().isEmpty() && queryBodyDto.getStartTime().isEmpty()){
            //时间段为空 ->  按输入内容查询文章列表信息
            System.out.println("timeZone为空");
            jsonRuslt = service.queryByInputContent(queryBodyDto);
        }else if(!queryBodyDto.getInputContent().isEmpty() && !queryBodyDto.getStartTime().isEmpty()){

            jsonRuslt = service.getQueryByInputAndTime(queryBodyDto);
        }
        return jsonRuslt;
    }


    @ApiOperation("根据文章id删除   （删除草稿）")
    @GetMapping("/deleteByEssayIdFromList")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    //草稿id  当前页 页码大小
    public JsonResult deleteByEssayIdFromList(String essayId){
        return service.deleteByEssayIdFromList(essayId);
    }


    @ApiOperation("新增文章（保存草稿/直接发布文章）")
    @PostMapping("/insertNewEssay")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    public JsonResult insertNewEssay(@Validated @RequestBody InsertEssayDto insertEssayDto){

        return service.insertNewEssay(insertEssayDto);
    }

    @ApiOperation("获得需要编辑的草稿内容")
    @GetMapping("/getUpdateEssayInf")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    public JsonResult getUpdateEssayInf(String essayId){
        return service.getUpdateEssayInf(essayId);
    }

    @ApiOperation("修改草稿内容")
    @PostMapping("/updateEssayById")
    @RequiresPermissions("/Dynamic/DyPublishEssayController/**")
    public JsonResult updateEssayById(@Validated @RequestBody InsertEssayDto insertEssayDto){
        return service.updataEssayById(insertEssayDto);
    }
}
