package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.system.wxuser.GetWxUserListInputDTO;
import com.partybuilding.webserver.service.system.SysWxUserService;
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
@CrossOrigin
@RestController
@RequestMapping("/System/DJAdminWxUser")
@RequiresPermissions("/System/DJAdminWxUser")
@Api(value = "微信用户管理WxUserController")
public class SysWxUserController {

    @Autowired
    private SysWxUserService sysWxUserService;

    @RequestMapping(value = "/getWxUserQueryList", method = RequestMethod.POST)
    @ApiOperation(value = "获取微信用户查询列表")
    @RequiresPermissions("/System/DJAdminWxUser/**")
    public JsonResult getWxUserQueryList(@Validated @RequestBody GetWxUserListInputDTO inputDTO) {
        JsonResult jsonResult = new JsonResult(sysWxUserService.getWxUserQueryList(inputDTO));
        if (jsonResult.getData() == null) {
            jsonResult.setMessage("获取失败");
            jsonResult.setCode(500);
        } else {
            jsonResult.setMessage("获取成功");
        }
        return jsonResult;

    }

    @GetMapping("/getOrganizationSelectList")
    @ApiOperation(value = "通过组织id获取所有的下级组织")
    @RequiresPermissions("/System/DJAdminWxUser/**")
    public JsonResult getOrganizationDownById(String organizationId) {
        JsonResult jsonResult = new JsonResult(sysWxUserService.getOrganizationDownById(organizationId));
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
