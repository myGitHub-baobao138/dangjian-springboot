package com.partybuilding.webserver.controller.service;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.service.changeOrganization.FindChangeOrganizationInfoPageDTO;
import com.partybuilding.webserver.dto.service.changeOrganization.OrganizationApplicationRequestDTO;
import com.partybuilding.webserver.dto.service.changeOrganization.OrganizationApprovalHistory;
import com.partybuilding.webserver.dto.service.changeOrganization.OriginAndTargetOrganizationDTO;
import com.partybuilding.webserver.entity.service.ServiceChangeOrganizationApproval;
import com.partybuilding.webserver.service.service.ServiceChangeOrganizationService;
import com.partybuilding.webserver.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Service/ChangeOrganization")
@Api(value = "转组织关系")
public class ServiceChangeOrganizationController {
    @Autowired
    ServiceChangeOrganizationService changeOrganizationService;

    /**
     * 创建转组织关系申请
     *
     * @param dto
     * @return
     */
    @PostMapping("/createApplication")
    @ApiOperation("创建转组织关系")
    @RequiresPermissions("/Service/ChangeOrganization/**")
    public JsonResult createChangeOrganizationRelationshipApplication(@RequestBody @Validated OrganizationApplicationRequestDTO dto) {
        JsonResult jsonResult = new JsonResult();
        int result = changeOrganizationService.createChangeOrganizationRelationshipApplication(dto);
        if (result == 700) {
            jsonResult.setMessage("创建失败,民族不存在!");
            jsonResult.setCode(700);
        } else if (result == 100) {
            jsonResult.setMessage("创建失败,原党支部不存在!");
            jsonResult.setCode(100);
        } else if (result == 200) {
            jsonResult.setMessage("创建失败,移交党支部不存在!");
            jsonResult.setCode(200);
        } else if (result == 300) {
            jsonResult.setMessage("创建失败,党员不在原党支部中!");
            jsonResult.setCode(300);
        } else if (result == 600) {
            jsonResult.setMessage("创建失败,原党支部与移交党支部不能相同!");
            jsonResult.setCode(600);
        } else if (result > 0) {
            jsonResult.setMessage("创建成功!");
            jsonResult.setCode(400);
        } else {
            jsonResult.setMessage("创建失败，系统错误!");
            jsonResult.setCode(500);
        }
        return jsonResult;
    }

    /**
     * 创建转组织关系申请时，通过学号/工号查询源组织与目的组织
     *
     * @param number
     * @return
     */
    @GetMapping("/searchOrganizationByNum")
    @ApiOperation("通过学号/工号查询源组织与目的组织")
    @RequiresPermissions("/Service/ChangeOrganization/**")
    public JsonResult searchOrganizationByNum(@RequestParam String number) {
        JsonResult jsonResult = new JsonResult();
        OriginAndTargetOrganizationDTO data = changeOrganizationService.searchOrganizationByNum(number);
        if (data != null && !data.getOriginOrganizationId().isEmpty()) {
            jsonResult.setData(data);
            jsonResult.setCode(200);
            jsonResult.setMessage("查询成功!");
        } else {
            jsonResult.setCode(403);
            jsonResult.setMessage("查询失败!");
        }
        return jsonResult;
    }

    /**
     * 查询转组织关系申请
     *
     * @param
     * @return
     */
    @PostMapping("/findApplicationInfo")
    @ApiOperation("查看转组织关系")
    @RequiresPermissions("/Service/ChangeOrganization/**")
    public JsonResult findChangeOrganizationByCondition(@RequestBody @Validated FindChangeOrganizationInfoPageDTO dto) {
        PageResult list = changeOrganizationService.findChangeOrganizationByCondition(dto);
        JsonResult jsonResult = new JsonResult();
        if (list.getTotal() > 0) {
            jsonResult.setData(list);
            jsonResult.setMessage("查询转组织关系成功!");
            jsonResult.setCode(100);
        } else {
            jsonResult.setMessage("查询失败,不存在数据!");
            jsonResult.setCode(200);
        }
        return jsonResult;
    }

    /**
     * 查询审核历史
     *
     * @param applicationId
     * @return
     */
    @GetMapping("/findApprovalHistory")
    @ApiOperation("查看审批历史记录")
    @RequiresPermissions("/Service/ChangeOrganization/**")
    public JsonResult findApprovalHistory(String applicationId) {
        JsonResult jsonResult = new JsonResult();
        List<OrganizationApprovalHistory> list = changeOrganizationService.findApprovalHistory(applicationId);
        if (list.size() > 0) {
            jsonResult.setData(list);
            jsonResult.setMessage("查询成功!");
            jsonResult.setCode(100);
        } else {
            jsonResult.setMessage("查询失败,不存在数据!");
            jsonResult.setCode(200);
        }
        return jsonResult;
    }

    /**
     * 审批确认并添加一条审核历史记录
     *
     * @param dto
     * @return
     */
    @PostMapping("/addApprovalRecord")
    @ApiOperation("审批确认并添加一条审核历史记录")
    @RequiresPermissions("/Service/ChangeOrganization/**")
    public JsonResult addApprovalRecord(@RequestBody @Validated ServiceChangeOrganizationApproval dto) {
        JsonResult jsonResult = new JsonResult();
        int result = changeOrganizationService.addApprovalRecord(dto);
        if (result > 0) {
            jsonResult.setMessage("审批成功!");
            jsonResult.setCode(100);
        } else {
            jsonResult.setMessage("审批失败!");
            jsonResult.setCode(200);
        }
        return jsonResult;
    }

    /**
     * 状态完成时查看审批状态
     *
     * @param applicationId
     * @return
     */
    @GetMapping("/findApplicationState")
    @ApiOperation("状态完成时查看审批状态")
    @RequiresPermissions("/Service/ChangeOrganization/**")
    public JsonResult findApplicationState(String applicationId) {
        JsonResult jsonResult = new JsonResult();
        int state = changeOrganizationService.findApplicationState(applicationId);
        jsonResult.setData(state);
        if (state == 400) {
            jsonResult.setCode(400);
            jsonResult.setMessage("获取状态失败!");
        } else {
            jsonResult.setCode(200);
            jsonResult.setMessage("获取状态成功!");
        }
        return jsonResult;
    }
}
