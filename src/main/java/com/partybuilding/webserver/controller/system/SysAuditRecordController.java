package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.system.academy.GetAcademyQueryListInputDTO;
import com.partybuilding.webserver.dto.system.auditRecord.GetVerificationInfoQueryListInputDTO;
import com.partybuilding.webserver.dto.system.auditRecord.VerifyWxUserInputDTO;
import com.partybuilding.webserver.dto.system.auditRecord.VerifyWxUserInputListDTO;
import com.partybuilding.webserver.service.system.SysAuditRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 认证管理controller
 */

@CrossOrigin
@RestController
@RequestMapping("/System/DJAdminVerificationManagement")
@Api(value = "认证管理VerificationManagementController")
public class SysAuditRecordController {

    @Autowired
    private SysAuditRecordService sysVerificationManagementService;


//    @RequestMapping(value = "/getVerificationInfoList", method = RequestMethod.POST)
//    @ApiOperation(value = "获取认证信息列表")
//    public JsonResult getVerificationInfoList(@Validated @RequestBody PageInputDTO inputDTO){
//        JsonResult jsonResult = new JsonResult(sysVerificationManagementService.getVerificationInfoList(inputDTO));
//        if(jsonResult.getData() == null){
//            jsonResult.setCode(500);
//            jsonResult.setMessage("查找数据为空");
//        } else {
//
//            jsonResult.setMessage("获取成功");
//        }
//        return jsonResult;
//    }

    @RequestMapping(value = "/getVerificationInfo", method = RequestMethod.GET)
    @ApiOperation(value = "获取认证信息详情")
    @RequiresPermissions("/System/DJAdminVerificationManagement/**")
    public JsonResult getVerificationInfo(@Validated @RequestParam String id) {
        JsonResult jsonResult = new JsonResult(sysVerificationManagementService.getVerificationInfo(id));
        System.out.println(jsonResult.getData());
        if (jsonResult.getData() == null) {
            jsonResult.setCode(500);
            jsonResult.setMessage("查找数据为空");
        } else {
            jsonResult.setMessage("获取成功");
        }
        return jsonResult;
    }

    @RequestMapping(value = "/verifyWxUser", method = RequestMethod.POST)
    @ApiOperation(value = "审核认证微信用户")
    @RequiresPermissions("/System/DJAdminVerificationManagement/**")
    public JsonResult verifyWxUser(@Validated @RequestBody VerifyWxUserInputDTO inputDTO) {
        JsonResult jsonResult = sysVerificationManagementService.verifyWxUser(inputDTO);
        if (jsonResult.getCode() == 200) {
            jsonResult.setData(true);
            jsonResult.setMessage("认证成功");
        } else {
            jsonResult.setData(false);
        }
        return jsonResult;
    }


    @RequestMapping(value = "/verifyWxUserList", method = RequestMethod.POST)
    @ApiOperation(value = "审核认证微信用户")
    @RequiresPermissions("/System/DJAdminVerificationManagement/**")
    public JsonResult verifyWxUserList(@Validated @RequestBody VerifyWxUserInputListDTO inputDTO) {
        JsonResult jsonResult = sysVerificationManagementService.verifyWxUserList(inputDTO);
        if (jsonResult.getCode() == 200) {
            jsonResult.setData(true);
            jsonResult.setMessage("认证成功");
        } else {
            jsonResult.setData(false);
        }
        return jsonResult;
    }

    @RequestMapping(value = "/getVerificationInfoQueryList", method = RequestMethod.POST)
    @ApiOperation(value = "获取认证信息列表")
    @RequiresPermissions("/System/DJAdminVerificationManagement/**")
    public JsonResult getVerificationInfoQueryList(@Validated @RequestBody GetVerificationInfoQueryListInputDTO inputDTO) {
        JsonResult jsonResult = new JsonResult(sysVerificationManagementService.getVerificationInfoQueryList(inputDTO));
        if (jsonResult.getData() == null) {
            jsonResult.setCode(500);
            jsonResult.setMessage("获取失败");
        } else {
            jsonResult.setMessage("获取成功");
        }
        return jsonResult;
    }

    @GetMapping("/getOrganizationSelectList")
    @ApiOperation(value = "通过组织id获取所有的下级组织")
    @RequiresPermissions("/System/DJAdminVerificationManagement/**")
    public JsonResult getOrganizationDownById(String organizationId) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(sysVerificationManagementService.getOrganizationDownById(organizationId));
        if (jsonResult.getData() == null) {
            jsonResult.setCode(500);
            jsonResult.setMessage("获取组织下拉框数据");
        } else {
            jsonResult.setCode(200);
            jsonResult.setMessage("获取组织下拉框数据失败");

        }
        return jsonResult;

    }

}
