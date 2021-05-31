package com.partybuilding.webserver.controller.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayPartyMemberNumberDTO;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.*;
import com.partybuilding.webserver.entity.service.ServiceMinuteMeeting;
import com.partybuilding.webserver.entity.service.ServiceParticipateThreeSessionOneClass;
import com.partybuilding.webserver.entity.service.ServiceThreeSessionOneClass;
import com.partybuilding.webserver.service.service.ServiceMinuteMeetingService;
import com.partybuilding.webserver.service.service.ServiceThreeSessionOneClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Service/DJAdminThreeSessionOneClass")
@Api(value = "ThreeSessionOneClass三会一课管理")
public class ServiceThreeSessionOneClassController {
    /**
     */

    @Autowired
    ServiceThreeSessionOneClassService theeOneService;

    @Autowired
    ServiceMinuteMeetingService minuteMeetingService;

    @PostMapping("/getThreeSessionOneClassList")
    @ApiOperation(value = "得到当前管理员、查询条件下的三会一课")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult getThreeSessionOneClassList(@Validated @RequestBody ThreeOneQueryDTO threeOneDTO){

        JsonResult jsonResult = new JsonResult(theeOneService.getThreeSessionOneClassList(threeOneDTO));

        if(jsonResult.getData() == null){
            jsonResult.setMessage("获取三会一课列表失败");
            jsonResult.setCode(500);
        }else {
            jsonResult.setMessage("获取三会一课列表成功");
        }
        return jsonResult;
    }

    @GetMapping("/deleteThreeOne")
    @ApiOperation(value = "删除三会一课")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public  JsonResult deleteThreeOne(String id){
        JsonResult jsonResult= new JsonResult<>();
        if(theeOneService.deleteThreeOne(id)==0){
            jsonResult.setMessage("delete three onr false");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("delete three one success");
        return jsonResult;
    }

    @PostMapping("/updateThreeOne")
    @ApiOperation(value = "修改三会一课")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult updateThreeOne(@Validated @RequestBody ServiceThreeSessionOneClass record){
        JsonResult jsonResult = new JsonResult();
        if(theeOneService.updateByPrimaryKey(record)==0){
            jsonResult.setMessage("update false");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("update success");
        return jsonResult;
    }

    @PostMapping("/insertThreeOne")
    @ApiOperation(value = "新增三会一课")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult insertThreeOne(@Validated @RequestBody ServiceThreeSessionOneClass record){
        JsonResult jsonResult = new JsonResult();
//        if(theeOneService.insert(record)==0){
//            jsonResult.setMessage("insert false");
//            jsonResult.setCode(500);
//        }
        if(theeOneService.insertSelective(record) == 0){
            jsonResult.setMessage("insert false");
            jsonResult.setCode(500);
        }
        else{
            jsonResult.setMessage("insert success");
            jsonResult.setData(record.getId());
        }

        return jsonResult;
    }

    @PostMapping("/postThreeOne")
    @ApiOperation(value = "发布选中的三会一课")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public  JsonResult postThreeOne(@RequestBody String[] ids){
        JsonResult jsonResult= new JsonResult<>();
        if(theeOneService.postThreeOne(ids)==0){
            jsonResult.setMessage("post three onr false");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("post three one success");
        return jsonResult;
    }

    @GetMapping("/getThreeOneDetails")
    @ApiOperation(value = "得到当前会议的详细信息")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult getThreeOneDetails(@RequestParam String id){
        JsonResult jsonResult = new JsonResult();
        ThreeSessionOnClassDTO threeSessionOnClassDTO = theeOneService.getThreeOneDetail(id);
        jsonResult.setData(threeSessionOnClassDTO);
        return jsonResult;
    }

    @PostMapping("/getNotAttendIdList")
    @ApiOperation(value = "得到未参加当前会议的人员表")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult getNotAttendIdList(@Validated @RequestBody ParticipateDTO record){
        JsonResult jsonResult = new JsonResult();
        List<ParticipateReturnDTO> list = theeOneService.getNotAttendIdList(record);
        jsonResult.setData(list);
        return jsonResult;
    }

    @GetMapping("/getAttendIdList")
    @ApiOperation(value = "得到参与当前会议的人员信息")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult getAttendIdList(@RequestParam String id){
        JsonResult jsonResult = new JsonResult();
        List<String> list = theeOneService.getAttendIdList(id);
        jsonResult.setData(list);
        return jsonResult;
    }

    @PostMapping("/getMinuteMeetingList")
    @ApiOperation(value = "得到当前组织下的所有会议纪要")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult getMinuteMeetingList(@Validated @RequestBody ServiceMinuteMeetingQueryDTO record){
        JsonResult jsonResult = new JsonResult(minuteMeetingService.getMinuteMeetingList(record));
        if(jsonResult.getData() == null){
            jsonResult.setMessage("get meeting summary failure");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("get meeting summary success");
        return jsonResult;
    }

    @GetMapping("/getMinuteMeetingByTheeOneId")
    @ApiOperation(value = "得到当前会议的会议纪要")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult getMinuteMeetingByTheeOneId(String meetingId){
        JsonResult jsonResult = new JsonResult();
        ServiceMinuteMeetingDTO serviceMinuteMeetingDTO = minuteMeetingService.getMinuteMeetingByTheeOneId(meetingId);
        if(serviceMinuteMeetingDTO==null){
            jsonResult.setMessage("get summary details by organization id false");
            jsonResult.setCode(500);
        }
        else {
            jsonResult.setMessage("get summary details by organization id success");
            jsonResult.setData(serviceMinuteMeetingDTO);
        }
        return jsonResult;
    }

    @PostMapping("/updateSummary")
    @ApiOperation(value = "修改会议纪要")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult updateSummary(@Validated @RequestBody ServiceMinuteMeeting record){
        JsonResult jsonResult = new JsonResult();
        if(minuteMeetingService.updateByPrimaryKey(record)==0){
            jsonResult.setMessage("update summary false");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("update summary success");
        return jsonResult;
    }

    @PostMapping("/insertSummary")
    @ApiOperation(value = "编写当前会议的会议纪要")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult insertSummary(@Validated @RequestBody ServiceMinuteMeeting record){
        JsonResult jsonResult = new JsonResult();
        if(minuteMeetingService.insertSelective(record)==0){
            jsonResult.setMessage("insert summary false");
            jsonResult.setCode(500);
        }
        else
            jsonResult.setMessage("insert summary success");
        return jsonResult;
    }

    @GetMapping("/getPartyMemberListByOrganizationId")
    @ApiOperation(value = "得到当前组织下的党员")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult getPartyMemberListByOrganizationId(String organizationId){
        JsonResult jsonResult = new JsonResult();
        List<ParticipateReturnDTO> list= theeOneService.getPartyMemberListByOrganizationId(organizationId);

        if(list==null){
            jsonResult.setMessage("get party member false");
            jsonResult.setCode(500);
        }
        else {
            jsonResult.setData(list);
            jsonResult.setMessage("get party member success");
        }

        return jsonResult;
    }

    @GetMapping("/insertAttendThreeOne")
    @ApiOperation(value = "增加会议中间表信息")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult insertAttendThreeOne(@Param("selectedPartyList") String[] selectedPartyList, @Param("threeOneId")String threeOneId){
        JsonResult jsonResult = new JsonResult();
        List<ServiceParticipateThreeSessionOneClass> record = new ArrayList<>();
        for(int i=0;i<selectedPartyList.length;i++){
            ServiceParticipateThreeSessionOneClass participateThreeOne = new ServiceParticipateThreeSessionOneClass();
            participateThreeOne.setParticipateId(selectedPartyList[i]);
            participateThreeOne.setThreeSessionOneClassId(threeOneId);
            record.add(participateThreeOne);
        }
        if(theeOneService.insertAttendThreeOne(record) == 0){
            jsonResult.setMessage("insert fails");
        }
        else{
            jsonResult.setMessage("insert success");
        }
        return jsonResult;
    }

    @GetMapping("/deleteParticipatesThreeOne")
    @ApiOperation(value = "删除会议中间表")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult deleteParticipatesThreeOne(String threeOneId){
        JsonResult jsonResult = new JsonResult();
        if(theeOneService.deleteParticipatesThreeOne(threeOneId)==0){
            jsonResult.setMessage("delete three one participate fail");
        }
        else {
            jsonResult.setMessage("delete three one participate success");
        }
        return jsonResult;
    }

    @GetMapping("/getParticipateList")
    @ApiOperation(value = "得到当前参会人员列表")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult getParticipateList(String threeOneId){
        JsonResult jsonResult = new JsonResult();
        List<ParticipateReturnDTO> list = theeOneService.getParticipateList(threeOneId);
        if(list==null){
            jsonResult.setMessage("select participate list fail");
        }else {
            jsonResult.setMessage("select participate list success");
            jsonResult.setData(list);
        }
        return jsonResult;
    }

    @GetMapping("/getParticipateName")
    @ApiOperation(value = "得到当前参会人员姓名")
    @RequiresPermissions("/Service/DJAdminThreeSessionOneClass/**")
    public JsonResult getParticipateName(String meetingId){
        JsonResult jsonResult = new JsonResult();
        String list= minuteMeetingService.getParticipateName(meetingId);
        if(list == null){
            jsonResult.setMessage("get participate name fail");
            jsonResult.setCode(500);
        }else{
            jsonResult.setMessage("get participate name success");
            jsonResult.setData(list);
        }
        return jsonResult;
    }

}
