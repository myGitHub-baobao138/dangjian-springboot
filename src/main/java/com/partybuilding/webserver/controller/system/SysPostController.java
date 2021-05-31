package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.login.LoginReturnDTO;
import com.partybuilding.webserver.dto.system.post.GetPostPageDTO;
import com.partybuilding.webserver.dto.system.post.RealPostDTO;
import com.partybuilding.webserver.dto.system.post.ReqPostDTO;
import com.partybuilding.webserver.service.system.SysPostService;
import com.partybuilding.webserver.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/System/PostController")
@CrossOrigin
@RestController
@Api(value = "职务管理接口组")
public class SysPostController {
    @Autowired
    SysPostService service;

    /**
     * 通过职务名称模糊查询职务信息
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "通过职务名称模糊查询职务信息")
    @GetMapping("/findPostInfoByName")
    @RequiresPermissions("/System/PostController/**")
    public JsonResult findPostInfoByName(@Validated GetPostPageDTO dto) {
        PageResult list = service.findPostInfoByName(dto);
        JsonResult jsonResult = new JsonResult();
        if (list.getTotal() > 0) {
            jsonResult.setData(list);
            jsonResult.setMessage("查询成功!");
            jsonResult.setCode(441);
        } else {
            jsonResult.setMessage("查询失败，职务不存在!");
            jsonResult.setCode(442);
        }
        return jsonResult;
    }

    /**
     * 通过职务id 删除职务信息
     *
     * @param postId
     * @return
     */
    @ApiOperation(value = "通过职务id删除职务信息")
    @GetMapping("/deletePostInfoById")
    @RequiresPermissions("/System/PostController/**")
    public JsonResult deletePostInfoById(String postId) {
        JsonResult jsonResult = new JsonResult();
        int result = service.deletePostInfoById(postId);
        if (result > 0) {
            jsonResult.setMessage("删除成功!");
            jsonResult.setCode(441);
        } else {
            jsonResult.setMessage("删除失败!");
            jsonResult.setCode(442);
        }
        return jsonResult;
    }

    /**
     * 添加一条职务信息
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "添加一条职务信息")
    @PostMapping("/addPostInfo")
    @RequiresPermissions("/System/PostController/**")
    public JsonResult addPostInfo(@RequestBody @Validated ReqPostDTO dto) {
        JsonResult jsonResult = new JsonResult();
        int result = service.addPostInfo(dto);
        if (result == 440) {
            jsonResult.setMessage("添加失败,该职务已经存在!");
            jsonResult.setCode(441);
        } else if (result > 0) {
            jsonResult.setMessage("添加成功!");
            jsonResult.setCode(442);
        } else {
            jsonResult.setMessage("添加失败!");
            jsonResult.setCode(441);
        }
        return jsonResult;
    }

    /**
     * 通过职务id 修改职务信息
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "通过职务id 修改职务信息")
    @PostMapping("/modifyPostInfo")
    @RequiresPermissions("/System/PostController/**")
    public JsonResult modifyPostInfo(@RequestBody RealPostDTO dto) {
        JsonResult jsonResult = new JsonResult();
        int result = service.modifyPostInfo(dto);
        if (result == 440) {
            jsonResult.setMessage("修改失败,职务名称已经存在!");
            jsonResult.setCode(440);
        } else if (result > 0) {
            jsonResult.setMessage("修改成功!");
            jsonResult.setCode(441);
        } else {
            jsonResult.setMessage("修改失败!");
            jsonResult.setCode(442);
        }
        return jsonResult;
    }
}
