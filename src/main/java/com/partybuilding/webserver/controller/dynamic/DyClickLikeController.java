package com.partybuilding.webserver.controller.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDataDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeQueryDataDto;
import com.partybuilding.webserver.service.dynamic.DyClickLikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/Dynamic/ClickLikeController")
@Api("点赞管理controller")
public class DyClickLikeController {
  @Autowired
  DyClickLikeService dyClickLikeService;

  @ApiOperation("获取点赞管理的列表数据")
  @PostMapping("/getClickLikeList")
  @RequiresPermissions("/Dynamic/DyClickLikeController/**")
  public JsonResult getClickLikeInfo(@Validated @RequestBody ClickLikeDataDto clickLikeDataDto) {
    return dyClickLikeService.getClickLikeInfo( clickLikeDataDto);
  }

  @ApiOperation("根据搜索框的输入内容获得点赞管理列表的数据")
  @PostMapping("/getClickLikeListBySearch")
  @RequiresPermissions("/Dynamic/ClickLikeController/**")
  public JsonResult getClickLikeListBySearch(@Validated @RequestBody ClickLikeQueryDataDto clickLikeQueryDataDto){
    return dyClickLikeService.selectClickLikeListBySearch(clickLikeQueryDataDto);
  }
}
