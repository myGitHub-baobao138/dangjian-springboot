package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.partyReminder.AddReminderDto;
import com.partybuilding.webserver.service.system.SysPartyReminderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description
 */
@CrossOrigin
@RestController
@RequestMapping("/System/SysPartyReminderController")
@Api("党员设置提醒api")
public class SysPartyReminderController {
    @Autowired
    SysPartyReminderService service;
    @PostMapping("/insertReminder")
    @ApiOperation("批量添加提醒或者单个添加提醒")
    @RequiresPermissions("/System/SysPartyReminderController/**")
    public JsonResult insertReminder(@RequestBody List<AddReminderDto> list){
        JsonResult jsonResult = service.insertList(list);
        return jsonResult;
    }

}
