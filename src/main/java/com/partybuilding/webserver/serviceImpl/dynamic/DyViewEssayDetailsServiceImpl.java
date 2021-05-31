package com.partybuilding.webserver.serviceImpl.dynamic;

import com.partybuilding.webserver.dao.dynamic.DynamicViewEssayDetailsMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.dynamic.clickLike.ViewEssayDetailsDto;
import com.partybuilding.webserver.service.dynamic.DyViewEssayDetaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DyViewEssayDetailsServiceImpl implements DyViewEssayDetaisService {
  @Autowired(required = false)
  DynamicViewEssayDetailsMapper dynamicViewEssayDetailsMapper;

  @Override
  public JsonResult viewArticleById(String titleId,int type) {
    JsonResult jsonResult = new JsonResult();

    ViewEssayDetailsDto viewEssayDetailsDto = dynamicViewEssayDetailsMapper.viewArticleById(titleId,type);
    //改变文章的样式
    viewEssayDetailsDto.setContent(formatContent(viewEssayDetailsDto.getContent()));

    jsonResult.setData(viewEssayDetailsDto);

    return jsonResult;
  }

  //查看稿件详情--调整文章样式
  private String formatContent(String content) {
    content = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + content;
    content = content.replaceAll(" ", "&nbsp;");
    content = content.replaceAll("\n", "<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
    return content;
  }
}
