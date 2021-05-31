package com.partybuilding.webserver.controller.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeListDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeListQueryDto;
import com.partybuilding.webserver.service.dynamic.DyViewClickLikeDetailsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/Dynamic/viewClickLikeDetails")
@Api("点赞管理点赞详情的controller")
public class DyClickLikeDetailsController {

  @Autowired
  DyViewClickLikeDetailsService dyViewClickLikeDetailsService;

  @ApiOperation("获取点赞数详情列表的数据")
  @PostMapping("/ByArticleId")
  @RequiresPermissions("/Dynamic/viewClickLikeDetails/**")
  public JsonResult viewClickLike(@RequestBody @Validated ClickLikeListDto clickLikeListDto){
    return dyViewClickLikeDetailsService.viewClickLikeDetails(clickLikeListDto);
  }

  @PostMapping("/ByTime")
  @RequiresPermissions("/Dynamic/viewClickLikeDetails/**")
  public JsonResult selectPraiseRecordByTime(@RequestBody @Validated ClickLikeListQueryDto clickLikeListQueryDto){
    return dyViewClickLikeDetailsService.selectPraiseRecordByTime(clickLikeListQueryDto);
  }
}
