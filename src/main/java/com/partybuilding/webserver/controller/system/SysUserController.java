package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.accountManagement.CreateUserAccountInDTO;
import com.partybuilding.webserver.dto.system.userManagement.ChangeUserAccountStateDTO;
import com.partybuilding.webserver.dto.system.userManagement.GetUserAccountInfoPageDTO;
import com.partybuilding.webserver.dto.system.userManagement.ModifyUserInformationDTO;
import com.partybuilding.webserver.service.system.SysUserService;
import com.partybuilding.webserver.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/System/UserController")
@CrossOrigin
@Api(value = "用户账号测试")
public class SysUserController {

    @Autowired
    private SysUserService service;


    /**
     * 创建用号账户接口
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "创建用户账号测试")
    @PostMapping("/createUserAccount")
    @RequiresPermissions("/System/UserController/**")
    public JsonResult createUserAccount(@RequestBody @Validated CreateUserAccountInDTO dto) {
        JsonResult jsonResult = new JsonResult();
        int num = service.createUserAccount(dto);
        if (num == 100) {
            jsonResult.setMessage("账号创建失败,账号已被注册!");
            jsonResult.setCode(480);
        } else if (num > 0) {
            jsonResult.setMessage("账号创建成功!");
            jsonResult.setCode(481);
        } else {
            jsonResult.setMessage("账号创建失败!");
            jsonResult.setCode(482);
        }
        return jsonResult;
    }

    /**
     * 修改用户账户状态
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "改变用户账号状态")
    @PostMapping("/modifyUserAccountState")
    @RequiresPermissions("/System/UserController/**")
    public JsonResult modifyUserAccountState(@RequestBody @Validated ChangeUserAccountStateDTO dto) {
        JsonResult jsonResult = new JsonResult();
        if (service.modifyUserAccountState(dto) > 0) {
            jsonResult.setMessage("用户账号更改成功!");
            jsonResult.setCode(481);
        } else {
            jsonResult.setMessage("用户账号更改失败!");
            jsonResult.setCode(482);
        }
        return jsonResult;
    }

    /**
     * 修改用户账户状态
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "通过账号修改用户信息")
    @PostMapping("/modifyUserInformationByUserId")
    @RequiresPermissions("/System/UserController/**")
    public JsonResult modifyUserInformationByAccount(@Validated @RequestBody ModifyUserInformationDTO dto) {
        JsonResult jsonResult = new JsonResult();
        int result = service.modifyUserInformationByUserId(dto);
        if (result == 440) {
            jsonResult.setMessage("修改失败,账号已经存在!");
            jsonResult.setCode(440);
        } else if (result > 0) {
            jsonResult.setMessage("修改成功!");
            jsonResult.setCode(482);
        } else {
            jsonResult.setMessage("修改失败!");
            jsonResult.setCode(483);
        }
        return jsonResult;
    }

    /**
     * 模糊查询用户账户的基本信息
     *
     * @return
     */
    @ApiOperation(value = "模糊查询用户账户的基本信息")
    @GetMapping("/findPartyMemberInformation")
    @RequiresPermissions("/System/UserController/**")
    public JsonResult findAllPartyMemberInformation(@Validated GetUserAccountInfoPageDTO dto) {
        JsonResult jsonResult = new JsonResult();
        PageResult pageResult = service.findPartyMemberInformation(dto);
        if (pageResult.getTotal() > 0) {
            jsonResult.setData(pageResult);
            jsonResult.setMessage("查询成功!");
            jsonResult.setCode(481);
        } else {
            jsonResult.setMessage("查询失败，用户不存在!");
            jsonResult.setCode(482);
        }
        return jsonResult;
    }

    /**
     * 通过用户 id 删除用户信息
     *
     * @return
     */
    @ApiOperation(value = "通过用户id删除用户信息")
    @GetMapping("/deleteUserInfoByUserId")
    @RequiresPermissions("/System/UserController/**")
    public JsonResult deleteUserInfoByUserId(String userId) {
        JsonResult jsonResult = new JsonResult();
        int result = service.deleteUserInfoByUserId(userId);
        if (result > 0) {
            jsonResult.setMessage("删除成功");
            jsonResult.setCode(481);
        } else {
            jsonResult.setMessage("删除失败,用户不存在或系统错误!");
            jsonResult.setCode(482);
        }
        return jsonResult;
    }

    /**
     * 判断账号是否被注册
     *
     * @param account
     * @return
     */
    @ApiOperation(value = "判断账号是否已被注册")
    @PostMapping("/isAccountExist")
    public JsonResult isAccountExist(String account) {
        JsonResult jsonResult = new JsonResult();
        if (!service.isAccountExist(account).isEmpty()) {
            jsonResult.setMessage("√ 账号可以使用");
            jsonResult.setCode(166);
        } else {
            jsonResult.setMessage("× 账号已被注册");
            jsonResult.setCode(167);
        }
        return jsonResult;
    }
}
