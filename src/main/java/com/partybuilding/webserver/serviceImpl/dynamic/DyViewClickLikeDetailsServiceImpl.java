package com.partybuilding.webserver.serviceImpl.dynamic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.dynamic.DynamicClickLikeDetailsMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDetaislDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeListDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeListQueryDto;
import com.partybuilding.webserver.service.dynamic.DyViewClickLikeDetailsService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DyViewClickLikeDetailsServiceImpl implements DyViewClickLikeDetailsService {

  @Autowired(required = false)
  DynamicClickLikeDetailsMapper dynamicClickLikeDetailsMapper;

  @Override
  public JsonResult viewClickLikeDetails(ClickLikeListDto clickLikeListDto) {
    //  判断参数是否有误
    if (clickLikeListDto.getCurrentPage() <= 0) {
      clickLikeListDto.setCurrentPage(1);  //设置默认当前页
    }
    if (clickLikeListDto.getPageSize() <= 0) {
      clickLikeListDto.setPageSize(5); // 默认每页5条
    }
    JsonResult jsonResult = new JsonResult<>();
    PageHelper.startPage(clickLikeListDto.getCurrentPage(), clickLikeListDto.getPageSize());
    List<ClickLikeDetaislDto>  clickLikeDetaislDtoList = dynamicClickLikeDetailsMapper.viewClickLikeDetails(clickLikeListDto.getArticleId());
    // 获取分页查询后的数据
    PageInfo<ClickLikeDetaislDto> pageInfo = new PageInfo<>(clickLikeDetaislDtoList);
    // 封装需要返回的分页实体
    PageResult<ClickLikeDetaislDto> result = new PageResult<ClickLikeDetaislDto>();
    // 设置总记录数total
    result.setTotal((int) pageInfo.getTotal());
    // 设置数据库集合
    result.setList(clickLikeDetaislDtoList);
    jsonResult.setData(result);
    return  jsonResult;
  }

  @Override
  public JsonResult selectPraiseRecordByTime(ClickLikeListQueryDto clickLikeListQueryDto) {
    //  判断参数是否有误
    if (clickLikeListQueryDto.getCurrentPage() <= 0) {
      clickLikeListQueryDto.setCurrentPage(1);  //设置默认当前页
    }
    if (clickLikeListQueryDto.getPageSize() <= 0) {
      clickLikeListQueryDto.setPageSize(5); // 默认每页5条
    }
    JsonResult jsonResult = new JsonResult<>();
    PageHelper.startPage(clickLikeListQueryDto.getCurrentPage(), clickLikeListQueryDto.getPageSize());
   //通过封装好的所需要传参数的dto得到所传参数
    String startTime =clickLikeListQueryDto.getStartTime();
    String endTime = clickLikeListQueryDto.getEndTime();
    String articleId = clickLikeListQueryDto.getArticleId();

    List<ClickLikeDetaislDto>  clickLikeDetaislDtoList = dynamicClickLikeDetailsMapper.selectPraiseRecordByTime(startTime,endTime,articleId);
    // 获取分页查询后的数据
    PageInfo<ClickLikeDetaislDto> pageInfo = new PageInfo<>(clickLikeDetaislDtoList);
    // 封装需要返回的分页实体
    PageResult<ClickLikeDetaislDto> result = new PageResult<ClickLikeDetaislDto>();
    // 设置总记录数total
    result.setTotal((int) pageInfo.getTotal());
    // 设置数据库集合
    result.setList(pageInfo.getList());
    jsonResult.setData(result);
    return  jsonResult;
  }


}
