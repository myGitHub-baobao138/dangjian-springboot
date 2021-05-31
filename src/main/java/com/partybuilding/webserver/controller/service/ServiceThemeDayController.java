package com.partybuilding.webserver.controller.service;


import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayDetailsDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayPartyMemberNumberDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayQueryDTO;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.ParticipateReturnDTO;
import com.partybuilding.webserver.entity.service.ServiceThemeDay;
import com.partybuilding.webserver.service.service.ServiceThemeDayService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Explain:党主题日controller
 */
@RequestMapping("/Service/ServiceThemeDayController")
@RestController
@CrossOrigin
@Api
public class ServiceThemeDayController{

    @Autowired
    ServiceThemeDayService serviceThemeDayService;

    @PostMapping("/getThemeDayTableDto")
    @ApiOperation(value = "获取党主题日的主页面表格所需数据")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult getThemeDayTableDto(@Validated @RequestBody ThemeDayQueryDTO record){
        JsonResult jsonResult = new JsonResult(serviceThemeDayService.getThemeDayTableList(record));
        if(jsonResult.getData() == null){
            jsonResult.setMessage("获取党主题日表格数据失败");
            jsonResult.setCode(500);
        } else {
            jsonResult.setMessage("获取党主题日表格数据成功");
        }
        return jsonResult;
    }

    @PostMapping("/insertThemeDay")
    @ApiOperation(value = "新增一条党主题日数据")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult insertThemeDay(@RequestBody  ServiceThemeDay record){
        JsonResult jsonResult = new JsonResult<>();
        if(serviceThemeDayService.insertSelective(record)==0){
            jsonResult.setMessage("增加党主题日失败");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("增加党主题日成功");
        return jsonResult;
    }

    @GetMapping("/getThemeDayDetails")
    @ApiOperation(value = "得到党主题日的详情")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult getThemeDayDetails(String id){
        JsonResult jsonResult = new JsonResult();
        ThemeDayDetailsDTO themeDayDetailsDTO = serviceThemeDayService.getThemeDayDetails(id);
        if(themeDayDetailsDTO==null){
            jsonResult.setMessage("获取主题日详情失败");
            jsonResult.setCode(500);
        }
        else{
            jsonResult.setMessage("获取当主题日详情成功");
            jsonResult.setData(themeDayDetailsDTO);
        }
        return jsonResult;
    }

    @GetMapping("/deleteThemeDay")
    @ApiOperation(value = "根据id删除党主题日->status=-1")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult deleteThemeDay(String id){
        JsonResult jsonResult = new JsonResult();
        if(serviceThemeDayService.deleteThemeDay(id)==0){
            jsonResult.setMessage("删除当前数据失败");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("删除当前数据成功");
        return jsonResult;
    }

    @PostMapping("/postThemeDay")
    @ApiOperation(value = "发布党主题日")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult postThemeDay(@RequestBody String[] ids){
        JsonResult jsonResult=new JsonResult();
        if(serviceThemeDayService.postThemeDay(ids)==0){
            jsonResult.setMessage("发布党主题日失败");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("发布党主题日成功");
        return jsonResult;
    }

    @PostMapping("/updateThemeDay")
    @ApiOperation(value = "修改党主题日信息")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult updateThemeDay(@RequestBody ServiceThemeDay record){
        JsonResult jsonResult = new JsonResult();
        if(serviceThemeDayService.updateByPrimaryKeySelective(record)==0){
            jsonResult.setMessage("更改党主题日失败");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("更改党主题日成功");
        return jsonResult;
    }

    @GetMapping("/updateTop")
    @ApiOperation(value = "置顶党主题日")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult updateTop(String id){
        JsonResult jsonResult = new JsonResult();
        if(serviceThemeDayService.updateTop(id)==0){
            jsonResult.setMessage("置顶失败");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("置顶成功");
        return jsonResult;
    }

    @GetMapping("/updateNotTop")
    @ApiOperation(value = "取消置顶党主题日")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult updateNotTop(String id){
        JsonResult jsonResult = new JsonResult();
        if(serviceThemeDayService.updateNotTop(id)==0){
            jsonResult.setMessage("取消置顶失败");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("取消置顶成功");
        return jsonResult;
    }

    @GetMapping("/getInsertThemeDayDefaultThree")
    @ApiOperation(value = "新增党主题日时默认的数据")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult getInsertThemeDayDefaultThree(String organizationId){
        JsonResult jsonResult = new JsonResult();
        ThemeDayDetailsDTO themeDayDetailsDTO = serviceThemeDayService.getInsertThemeDayDefaultThree(organizationId);
        if(themeDayDetailsDTO == null){
            jsonResult.setMessage("得到组织名称、党员数、支部书记名称失败");
            jsonResult.setCode(500);
        }
        else{
            jsonResult.setMessage("得到组织名称、党员数、支部书记名称成功");
            jsonResult.setData(themeDayDetailsDTO);
        }
        return jsonResult;
    }

    @PostMapping("/getPartyMemberNumber")
    @ApiOperation(value = "得到当前组织下的所有党员数")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult getPartyMemberNumber(@RequestBody  ThemeDayPartyMemberNumberDTO record){
        JsonResult jsonResult = new JsonResult();
        int partyMemberNumber = serviceThemeDayService.getPartyMemberNumber(record);
        if(partyMemberNumber==0){
            jsonResult.setMessage("get party member number false");
            jsonResult.setCode(500);
        }
        else {
            jsonResult.setData(partyMemberNumber);
            jsonResult.setMessage("get party member number success");
        }
        return jsonResult;
    }

    @GetMapping("/getAttendThemeDayPartyIdList")
    @ApiOperation(value = "得到参加当前党主题日的党员id")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult getAttendThemeDayPartyIdList(String id){
        JsonResult jsonResult = new JsonResult();
        String ids = serviceThemeDayService.getAttendThemeDayPartyIdList(id);
        if(ids==null){
            jsonResult.setMessage("get attend party list fail");
            jsonResult.setCode(500);
        }
        else {
            jsonResult.setData(ids);
            jsonResult.setMessage("get attend party success");
        }
        return jsonResult;
    }

    @GetMapping("/getAttendThemeDayPartyList")
    @RequiresPermissions("/Service/ServiceThemeDayController/**")
    public JsonResult getAttendThemeDayPartyList(String id){
        JsonResult jsonResult = new JsonResult();
        List<ParticipateReturnDTO> attendParty = serviceThemeDayService.getAttendThemeDayPartyList(id);
        if(attendParty == null){
            jsonResult.setMessage("get attend party fail");
            jsonResult.setCode(500);
        }else{
            jsonResult.setData(attendParty);
            jsonResult.setMessage("get attent party success");
        }
        return jsonResult;
    }
}
