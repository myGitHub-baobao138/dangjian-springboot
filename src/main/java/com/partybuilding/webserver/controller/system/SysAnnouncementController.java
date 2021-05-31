package com.partybuilding.webserver.controller.system;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.announcement.AddAnnouncementDto;
import com.partybuilding.webserver.dto.system.announcement.SearchAnnouncementDto;
import com.partybuilding.webserver.service.system.SysAnnouncementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/System/AnnouncementController")
@Api("系统公告controller")
public class SysAnnouncementController {

    @Autowired
    SysAnnouncementService sysAnnouncementService;

    @PostMapping("/addAnnouncement")
    @ApiOperation("/添加系统公告")
    @RequiresPermissions("/System/AnnouncementController/**")
    public JsonResult addAnnouncement(@RequestBody AddAnnouncementDto addAnnouncementDto){
        int success = sysAnnouncementService.insert(addAnnouncementDto);
        JsonResult jsonResult = new JsonResult();
        if(success>0){
            jsonResult.setMessage("发布成功！");
            jsonResult.setCode(200);
        }else {
            jsonResult.setCode(500);
            jsonResult.setMessage("发布失败");
        }

        return jsonResult;
    }
    @PostMapping("/selectByTimeAndContent")
    @ApiOperation("根据不同的条件查询数据")
    @RequiresPermissions("/System/AnnouncementController/**")
    public JsonResult selectByTimeAndContent(@RequestBody SearchAnnouncementDto searchAnnouncementDto){
        JsonResult jsonResult = sysAnnouncementService.selectByTimeAndContent(searchAnnouncementDto);
        return jsonResult;
    }
}
