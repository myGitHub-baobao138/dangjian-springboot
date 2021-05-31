package com.partybuilding.webserver.controller.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.dynamic.essay.AllEssaysListDto;
import com.partybuilding.webserver.dto.dynamic.essay.CheckFormDto;
import com.partybuilding.webserver.dto.dynamic.essay.QueryEssayBodyDto;
import com.partybuilding.webserver.service.dynamic.DyCheckEssayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 稿件审核controller
 */
@RestController
@CrossOrigin
@RequestMapping("/Dynamic/DyCheckEssayController")
@Api("审核稿件controller")
public class DyCheckEssayController {
    @Autowired
    DyCheckEssayService service;

    @ApiOperation("根据管理员等级（校级/院级）来获取待审核稿件")
    @PostMapping("/getAllCheckEssay" )
    @RequiresPermissions("/Dynamic/DyCheckEssayController/**")
    public JsonResult getAllCheckEssay(@Validated @RequestBody AllEssaysListDto getListDto){
        return service.getCheckEssayListByRankAndOrganization(getListDto);
    }

    @ApiOperation("根据文章id  获取文章详情")
    @GetMapping("/getEssayDetailsById" )
    @RequiresPermissions("/Dynamic/DyCheckEssayController/**")
    public JsonResult getEssayDetailsById(String essayId){
        return service.getEssayDetails(essayId);
    }

    @ApiOperation("审核单篇稿件")
    @PostMapping("/updateEssayBySingleEssayId" )
    @RequiresPermissions("/Dynamic/DyCheckEssayController/**")
    public JsonResult updateEssayBySingleEssayId(@Validated @RequestBody CheckFormDto checkFormDto){
        return service.updateEssayBySingleEssayId(checkFormDto);
    }

    @ApiOperation("批量审核稿件")
    @PostMapping("/updateManyEssayByEssayIdList")
    @RequiresPermissions("/Dynamic/DyCheckEssayController/**")
    public JsonResult updateManyEssayByEssayIdList(@Validated @RequestBody CheckFormDto checkFormListDto){
        return service.updateManyEssayByEssayIdList(checkFormListDto);
    }

    @ApiOperation("根据输入内容进行查询稿件信息列表")
    @PostMapping("/queryCheckEssayListByInputContent" )
    @RequiresPermissions("/Dynamic/DyCheckEssayController/**")
    public JsonResult queryCheckEssayListByInputContent(@Validated @RequestBody QueryEssayBodyDto queryBodyDto){
        JsonResult jsonResult = new JsonResult();

        //判断input框输入的内容是否是根据文章来源进行搜索的
        int source = isSource(queryBodyDto);

        if(source ==0){//输入的其他内容--从学院/标题/内容/投稿人/审核人/  进行搜索
            jsonResult = service.queryCheckEssayListByInputContent(queryBodyDto);
        }else {//source ==1/2/3
            jsonResult = service.queryCheckEssayListBySource(queryBodyDto);
        }
        return jsonResult;
    }


    @ApiOperation("根据审核状态进行查询稿件信息列表")
    @PostMapping("/queryCheckEssayListByCheckStatus" )
    @RequiresPermissions("/Dynamic/DyCheckEssayController/**")
    public JsonResult queryCheckEssayListByCheckStatus(@Validated @RequestBody QueryEssayBodyDto queryBodyDto){
        return service.queryCheckEssayListByCheckStatus(queryBodyDto);
    }

    @ApiOperation("根据审核状态和输入的内容同时进行查询稿件信息列表")
    @PostMapping("/queryCheckEssayListByCheckAndInput" )
    @RequiresPermissions("/Dynamic/DyCheckEssayController/**")
    public JsonResult queryCheckEssayListByCheckAndInput(@Validated @RequestBody QueryEssayBodyDto queryBodyDto){
        JsonResult jsonResult = new JsonResult();

        //判断input框输入的内容是否是根据文章来源进行搜索的
        int source = isSource(queryBodyDto);

        if(source ==0 ){//输入的其他内容--从学院（组织）/标题/内容/投稿人/审核人/  进行搜索
            jsonResult = service.queryCheckEssayListByCheckAndInput(queryBodyDto);
        }else{//source ==1/2/3
            jsonResult = service.queryCheckEssayListByCheckAndSource(queryBodyDto);
        }
        return jsonResult;
    }

    //判断input框输入的内容是否是根据文章来源进行搜索的
    private int isSource(QueryEssayBodyDto queryEssayBodyDto) {
        int source=0;
        String inputContent = queryEssayBodyDto.getInputContent();
        if(inputContent.equals("党员先锋")){
            source =1;
            queryEssayBodyDto.setSource(1);
        }else if(inputContent.equals("基层风采")){
            source =2;
            queryEssayBodyDto.setSource(2);
        }else if(inputContent.equals("党主题日")) {
            source =3;
            queryEssayBodyDto.setSource(3);
        }
        return source;
    }

}
