package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.operationLog.AddOperationLogRequestDTO;
import com.partybuilding.webserver.dto.system.operationLog.FindOperationLogPageInfo;
import com.partybuilding.webserver.entity.system.SysOperationLog;
import com.partybuilding.webserver.service.system.SysOperationLogService;
import com.partybuilding.webserver.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/System/OperationController")
@CrossOrigin
@Api(value = "查询日志接口组")
public class SysOperationLogController {
    @Autowired
    SysOperationLogService sysOperationLogService;

    /**
     * 查询系统日志
     *
     * @param dto
     * @return
     */
    @ApiOperation(value = "查询系统操作日志")
    @PostMapping("/findOperationLog")
    @RequiresPermissions("/System/OperationController/**")
    public JsonResult findOperationLog(@RequestBody @Validated FindOperationLogPageInfo dto) {
        JsonResult jsonResult = new JsonResult();
        PageResult list = sysOperationLogService.findOperationLog(dto);
        if (list.getTotal() > 0) {
            jsonResult.setMessage("查询成功!");
            jsonResult.setData(list);
            jsonResult.setCode(200);
        } else {
            jsonResult.setMessage("查询失败，数据不存在!");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }

    /**
     * 查询出操作人员姓名
     *
     * @param operatorName
     * @return
     */
    @ApiOperation(value = "查询出操作人员姓名")
    @GetMapping("/findOperatorName")
    @RequiresPermissions("/System/OperationController/**")
    public JsonResult findOperatorName(String operatorName) {
        JsonResult jsonResult = new JsonResult();
        List<String> list = sysOperationLogService.findOperatorName(operatorName);
        if (list.size() > 0) {
            jsonResult.setMessage("查询成功!");
            jsonResult.setData(list);
            jsonResult.setCode(200);
        } else {
            jsonResult.setMessage("查询失败，数据不存在!");
            jsonResult.setCode(404);
        }
        return jsonResult;
    }
}
