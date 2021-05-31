package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.announcement.AddAnnouncementDto;
import com.partybuilding.webserver.dto.system.announcement.SearchAnnouncementDto;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public interface SysAnnouncementService {

    int insert(AddAnnouncementDto record);

    JsonResult selectByContent(SearchAnnouncementDto searchAnnouncementDto);

    JsonResult selectByTime(SearchAnnouncementDto searchAnnouncementDto);

    JsonResult selectByTimeAndContent(SearchAnnouncementDto searchAnnouncementDto);
}
