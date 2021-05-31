package com.partybuilding.webserver.serviceImpl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.system.SysAnnouncementMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.announcement.AddAnnouncementDto;
import com.partybuilding.webserver.dto.system.announcement.ResultAnnouncement;
import com.partybuilding.webserver.dto.system.announcement.SearchAnnouncementDto;
import com.partybuilding.webserver.dto.system.announcement.TimeAndContentDto;
import com.partybuilding.webserver.dto.system.partyInformation.SearchResultDto;
import com.partybuilding.webserver.entity.system.SysAnnouncement;
import com.partybuilding.webserver.service.system.SysAnnouncementService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
@Service
public class SysAnnouncementServiceImpl implements SysAnnouncementService{
    @Autowired
    SysAnnouncementMapper sysAnnouncementMapper;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public int insert(AddAnnouncementDto record) {
        SysAnnouncement sysAnnouncement = new SysAnnouncement();
        sysAnnouncement = modelMapper.map(record,SysAnnouncement.class);
        sysAnnouncement.setId(Uuid.getUuid());
        sysAnnouncement.setPublishedTime(new Date());
        return sysAnnouncementMapper.insert(sysAnnouncement);
    }

    @Override
    public JsonResult selectByContent(SearchAnnouncementDto searchAnnouncementDto) {
        return null;
    }

    @Override
    public JsonResult selectByTime(SearchAnnouncementDto searchAnnouncementDto) {
        return null;
    }

    @Override
    public JsonResult selectByTimeAndContent(SearchAnnouncementDto searchAnnouncementDto) {
        JsonResult jsonResult = new JsonResult();
        if ("".equals(searchAnnouncementDto.getContent())){
            searchAnnouncementDto.setContent(null);
        }
        if ("".equals(searchAnnouncementDto.getPublishTime())){
            searchAnnouncementDto.setPublishTime(null);
        }
        PageHelper.startPage(searchAnnouncementDto.getCurrentPage(),searchAnnouncementDto.getPageSize());
        TimeAndContentDto timeAndContentDto = modelMapper.map(searchAnnouncementDto,TimeAndContentDto.class);
//        System.out.println(searchAnnouncementDto.getPublishTime());
        List<ResultAnnouncement> resultAnnouncements = sysAnnouncementMapper.selectByTimeAndContent(timeAndContentDto);
//        System.out.println(timeAndContentDto.getPublishTime());
        PageResult<ResultAnnouncement> result = getPageResult(resultAnnouncements);
        jsonResult.setData(result);
        return jsonResult;
    }
    public PageResult<ResultAnnouncement> getPageResult(List<ResultAnnouncement> sysAnnouncements) {
        PageInfo<ResultAnnouncement> pageInfo = new PageInfo<ResultAnnouncement>(sysAnnouncements);
        // 封装需要返回的分页实体
        PageResult<ResultAnnouncement> result = new PageResult<ResultAnnouncement>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(pageInfo.getList());
        return result;
    }


}
