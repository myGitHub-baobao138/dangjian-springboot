package com.partybuilding.webserver.controller.dynamic;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.dynamic.clickLike.ViewEssayDetailsDto;
import com.partybuilding.webserver.service.dynamic.DyViewEssayDetaisService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Dynamic/EssayDetails")
@Api("点赞管理页面根据文章id跳转到查看详情页面的controller")
public class DyViewEssayDetailsController {

  @Autowired
  DyViewEssayDetaisService dyViewEssayDetaisService;
  //查看文章详情
  @ApiOperation("获取查看文章详情页面的数据")
  @GetMapping("/ById")

  public JsonResult selectArticlesById(String titleId,int type){
    return dyViewEssayDetaisService.viewArticleById(titleId,type);
  }
}
