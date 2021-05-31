package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.UpdatePermissionInputDTO;
import com.partybuilding.webserver.service.system.SysPermissionService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@CrossOrigin
@RestController
@RequestMapping("/System/SysPermission")
public class SysPermissionController {
    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping(value = "/getPermissionList", method = RequestMethod.GET)
    @ApiOperation(value = "获取角色菜单栏列表")
    public JsonResult getPermissions(String organizationId, String postId) {
        JsonResult jsonResult = new JsonResult(sysPermissionService.getPermissions(organizationId, postId));
        if (jsonResult.getData() == null) {
            jsonResult.setMessage("获取失败");
            jsonResult.setCode(500);
        } else {
            jsonResult.setMessage("获取成功");
        }
        return jsonResult;
    }
    @RequestMapping(value = "/updatePermissionList", method = RequestMethod.POST)
    @ApiOperation(value = "更新角色菜单栏列表")
    public JsonResult updateRolePermissions(@RequestBody UpdatePermissionInputDTO dto){
        JsonResult jsonResult = new JsonResult();
        if (sysPermissionService.updateRolePermissions(dto) == false) {
            jsonResult.setMessage("更新失败");
            jsonResult.setCode(500);
            jsonResult.setData(false);
        } else {
            jsonResult.setData(true);
            jsonResult.setMessage("更新成功");
        }
        return jsonResult;

    }

    @RequestMapping(value = "/getAllPermissions", method = RequestMethod.GET)
    @ApiOperation(value = "获取所有菜单栏列表")
    public JsonResult getAllPermissions() {
        JsonResult jsonResult = new JsonResult(sysPermissionService.getAllPermissions());
        if (jsonResult.getData() == null) {
            jsonResult.setMessage("获取失败");
            jsonResult.setCode(500);
        } else {
            jsonResult.setMessage("获取成功");
        }
        return jsonResult;
    }
}
