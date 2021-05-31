package com.partybuilding.webserver.serviceImpl.dynamic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.dynamic.DynamicClickLikeMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDataDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeDto;
import com.partybuilding.webserver.dto.dynamic.clickLike.ClickLikeQueryDataDto;
import com.partybuilding.webserver.service.dynamic.DyClickLikeService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DyClickLikeServiceImpl implements DyClickLikeService {

  @Autowired
  DynamicClickLikeMapper dynamicClickLikeMapper;

  @Override
  public JsonResult getClickLikeInfo(ClickLikeDataDto clickLikeDataDto) {
    //  判断参数是否有误
    if (clickLikeDataDto.getCurrentPage() <= 0) {
      clickLikeDataDto.setCurrentPage(1);  //设置默认当前页
    }
    if (clickLikeDataDto.getPageSize() <= 0) {
      clickLikeDataDto.setPageSize(5); // 默认每页5条
    }

    JsonResult jsonResult = new JsonResult();
    PageHelper.startPage(clickLikeDataDto.getCurrentPage(), clickLikeDataDto.getPageSize());

    List<ClickLikeDto> clickLikeDtos= dynamicClickLikeMapper.selectClickLikeInfo(clickLikeDataDto.getOrganizationId(),clickLikeDataDto.getOrganizationRank());
    System.out.println(clickLikeDtos.toString());
    // 获取分页查询后的数据
    PageInfo<ClickLikeDto> pageInfo = new PageInfo<>(clickLikeDtos);
    // 封装需要返回的分页实体
    PageResult<ClickLikeDto> result = new PageResult<ClickLikeDto>();
    // 设置总记录数total
    result.setTotal((int) pageInfo.getTotal());
    // 设置数据库集合
    result.setList(clickLikeDtos);

    jsonResult.setData(result);
    return jsonResult;
  }

  //根据搜索输入内容查询点赞记录
  @Override
  public JsonResult selectClickLikeListBySearch(ClickLikeQueryDataDto clickLikeQueryDataDto) {
    //  判断参数是否有误
    if (clickLikeQueryDataDto.getCurrentPage() <= 0) {
      clickLikeQueryDataDto.setCurrentPage(1);  //设置默认当前页
    }
    if (clickLikeQueryDataDto.getPageSize() <= 0) {
      clickLikeQueryDataDto.setPageSize(5); // 默认每页5条
    }
    JsonResult jsonResult = new JsonResult();
    PageHelper.startPage(clickLikeQueryDataDto.getCurrentPage(), clickLikeQueryDataDto.getPageSize());

    //搜索框的输入内容
    String inputContent = clickLikeQueryDataDto.getInputContent();
    String id = clickLikeQueryDataDto.getOrganizationId();
    int rank = clickLikeQueryDataDto.getOrganizationRank();
    String startTime = clickLikeQueryDataDto.getStartTime();
    String endTime = clickLikeQueryDataDto.getEndTime();

    StringBuilder stringBuilder = new StringBuilder("%");
    if (inputContent!=null){
      for(int i=0; i<inputContent.length();i++){
        stringBuilder.append(inputContent.charAt(i));
        stringBuilder.append("%");
      }
    }
    String newInputContent = stringBuilder.toString();
    List<ClickLikeDto> clickLikeDtos= dynamicClickLikeMapper.selectClickLikeListBySearch(id,rank,newInputContent,startTime,endTime);
    System.out.println(clickLikeDtos.toString());
    // 获取分页查询后的数据
    PageInfo<ClickLikeDto> pageInfo = new PageInfo<>(clickLikeDtos);
    // 封装需要返回的分页实体
    PageResult<ClickLikeDto> result = new PageResult<ClickLikeDto>();
    // 设置总记录数total
    result.setTotal((int) pageInfo.getTotal());
    // 设置数据库集合
    result.setList(clickLikeDtos);

    jsonResult.setData(result);
    return jsonResult;

  }
}
