package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.role.UserRoleDTO;
import com.partybuilding.webserver.dto.system.right.DeleteRightRoleAndResourceDTO;
import com.partybuilding.webserver.dto.system.right.FindRightBaseInfoPageInfo;
import com.partybuilding.webserver.dto.system.right.allocateRight.AllocateRightRequest;
import com.partybuilding.webserver.dto.system.right.createRight.CreateRightRequest;
import com.partybuilding.webserver.dto.system.right.createRight.FindOrganizationAndPostIsExist;
import com.partybuilding.webserver.dto.system.right.createRight.OrganizationAndPostDTO;
import com.partybuilding.webserver.dto.system.right.createRight.OrganizationAndPostRequestDTO;
import com.partybuilding.webserver.dto.system.right.showRight.RightListDto;
import com.partybuilding.webserver.service.system.SysRightService;
import com.partybuilding.webserver.service.system.SysUserService;
import com.partybuilding.webserver.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/System/RightController")
@CrossOrigin
@Api(value = "权限管理测试接口组")
public class SysRightController {
    @Autowired
    SysRightService rightService;
    @Autowired
    SysUserService sysUserService;

    /**
     * 改变用户角色
     *
     * @param role
     * @return
     */
    @ApiOperation(value = "改变用户角色")
    @RequestMapping("/changeUserRole")
    public JsonResult changeUserRole(@RequestBody @Validated UserRoleDTO role) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(200);
        jsonResult.setMessage("切换成功！");
        return jsonResult;
    }

    /**
     * 查询权限基本信息
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "查看基本权限信息")
    @PostMapping("/findRightBaseInfo")
    @RequiresPermissions("/System/RightController/**")
    public JsonResult findRightBaseInfo(@RequestBody @Validated FindRightBaseInfoPageInfo dto) {
        JsonResult jsonResult = new JsonResult();
        PageResult pageResult = rightService.findRightBaseInfo(dto);
        if (pageResult.getTotal() > 0) {
            jsonResult.setData(pageResult);
            jsonResult.setMessage("查询成功!");
            jsonResult.setCode(200);
        } else {
            jsonResult.setMessage("查询失败,查询数据为空!");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }

    /**
     * 删除权限角色及资源
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "删除权限角色及资源")
    @PostMapping("/deleteRightRoleAndResource")
    @RequiresPermissions("/System/RightController/**")
    public JsonResult deleteRightRoleAndResource(@RequestBody @Validated DeleteRightRoleAndResourceDTO dto) {
        JsonResult jsonResult = new JsonResult();
        int result = rightService.deleteRightRoleAndResource(dto);
        if (result > 0) {
            jsonResult.setMessage("删除成功!");
            jsonResult.setCode(200);
        } else {
            jsonResult.setMessage("删除失败!");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }


    /**
     * 创建权限
     *
     * @return
     */
    @ApiOperation(value = "创建权限")
    @PostMapping("/createRightInfo")
    @RequiresPermissions("/System/RightController/**")
    public JsonResult createRightInfo(@RequestBody @Validated CreateRightRequest dto) {
        JsonResult jsonResult = new JsonResult();

        int result = rightService.createRightInfo(dto);

        if (result == 400) {
            jsonResult.setMessage("创建失败,角色已经存在,请分配权限!");
            jsonResult.setCode(400);
        } else if (result > 0) {
            jsonResult.setMessage("创建成功!");
            jsonResult.setCode(200);
        } else {
            jsonResult.setMessage("创建失败!");
            jsonResult.setCode(200);
        }
        return jsonResult;
    }

    /**
     * 查询组织及其下面的职务
     *
     * @return
     */
    @ApiOperation(value = "查询组织及其下面的职务")
    @PostMapping("/organizationAndPost")
    @RequiresPermissions("/System/RightController/**")
    public JsonResult organizationAndPost(@RequestBody OrganizationAndPostRequestDTO dto) {
        JsonResult jsonResult = new JsonResult();
        List<OrganizationAndPostDTO> list = rightService.organizationAndPost(dto);
        if (list.size() > 0) {
            jsonResult.setData(list);
            jsonResult.setCode(200);
            jsonResult.setMessage("查询成功!");
        } else {
            jsonResult.setCode(404);
            jsonResult.setMessage("查询失败,数据为空!");
        }
        return jsonResult;
    }

    /**
     * 查询角色已有权限
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "查询角色权限")
    @PostMapping("/findRightList")
    @RequiresPermissions("/System/RightController/**")
    public JsonResult findRoleHavingRightList(@RequestBody @Validated FindOrganizationAndPostIsExist dto) {
        JsonResult jsonResult = new JsonResult();
        RightListDto rightListDto = rightService.findRightList(dto);
        if (rightListDto != null) {
            jsonResult.setData(rightListDto);
            jsonResult.setCode(200);
            jsonResult.setMessage("查询成功!");
        } else {
            jsonResult.setCode(404);
            jsonResult.setMessage("查询失败,权限列表为空!");
        }
        return jsonResult;
    }

    /**
     * 分配角色权限
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "分配角色权限")
    @PostMapping("/allocateRoleRight")
    @RequiresPermissions("/System/RightController/**")
    public JsonResult allocateRoleRight(@RequestBody @Validated AllocateRightRequest dto) {
        JsonResult jsonResult = new JsonResult();
        int result = rightService.allocateRoleRight(dto);

        if (result == 400) {
            jsonResult.setMessage("分配,角色已经存在,请分配权限!");
            jsonResult.setCode(400);
        } else if (result > 0) {
            jsonResult.setMessage("分配成功!");
            jsonResult.setCode(200);
        } else {
            jsonResult.setMessage("分配失败!");
            jsonResult.setCode(200);
        }
        return jsonResult;
    }

    @RequestMapping("/403")
    public String noAuthority() {
        return "403 你没有权限";
    }
}
