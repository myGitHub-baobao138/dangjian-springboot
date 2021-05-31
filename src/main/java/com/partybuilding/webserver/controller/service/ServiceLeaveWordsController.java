package com.partybuilding.webserver.controller.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.GetLeaveWordsInfoInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.GetLeaveWordsQueryListInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.ReplyLeaveWordsInputDTO;
import com.partybuilding.webserver.service.service.LeaveWordsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */

@RestController
@CrossOrigin
@RequestMapping("/Service/DJAdminLeaveWords")
@Api(value = "LeaveWordsController留言管理")
public class ServiceLeaveWordsController {

    @Autowired
    private LeaveWordsService leaveWordsService;

    @RequestMapping(value ="/getLeaveWordsQueryList", method = RequestMethod.POST)
    @ApiOperation(value = "获取留言查询列表")
    @RequiresPermissions("/Service/DJAdminLeaveWords/**")
    public JsonResult getLeaveWordsQueryList(@Validated @RequestBody GetLeaveWordsQueryListInputDTO dto){
        JsonResult jsonResult = new JsonResult(leaveWordsService.getLeaveWordsQueryList(dto));
        if(jsonResult.getData() == null){
            jsonResult.setMessage("获取失败");
            jsonResult.setCode(500);
        } else {
            jsonResult.setMessage("获取留言列表成功");
        }

        return jsonResult;
    }

    @RequestMapping(value ="/getLeaveWordsInfo", method = RequestMethod.POST)
    @ApiOperation(value = "查看留言信息")
    @RequiresPermissions("/Service/DJAdminLeaveWords/**")
    public JsonResult getLeaveWordsInfo(@Validated @RequestBody GetLeaveWordsInfoInputDTO inputDTO){
        JsonResult jsonResult = new JsonResult(leaveWordsService.getLeaveWordsInfo(inputDTO));
        if(jsonResult.getData() == null){
            jsonResult.setMessage("获取失败");
            jsonResult.setCode(500);
        } else {
            jsonResult.setMessage("获取成功");
        }

        return jsonResult;
    }

    @RequestMapping(value = "/replyLeaveWords", method = RequestMethod.POST)
    @ApiOperation(value = "回复留言")
    @RequiresPermissions("/Service/DJAdminLeaveWords/**")
    public JsonResult replyLeaveWords(@Validated @RequestBody ReplyLeaveWordsInputDTO inputDTO){

        return leaveWordsService.replyLeaveWords(inputDTO);
    }

    @GetMapping("/getOrganizationSelectList")
    @ApiOperation(value = "通过管理员组织id获取组织下拉框数据即所有的下级组织")
    @RequiresPermissions("/Service/DJAdminLeaveWords/**")
    public JsonResult getOrganizationDownById(String organizationId) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(leaveWordsService.getOrganizationDownById(organizationId));
        if (jsonResult.getData() == null){
            jsonResult.setCode(500);
            jsonResult.setMessage("获取组织下拉框数据失败");
        } else {
            jsonResult.setCode(200);
            jsonResult.setMessage("获取组织下拉框数据成功");

        }
        return jsonResult;
    }
}
