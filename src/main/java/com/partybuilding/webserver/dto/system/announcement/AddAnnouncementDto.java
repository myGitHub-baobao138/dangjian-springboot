package com.partybuilding.webserver.dto.system.announcement;

import java.util.Date;

public class AddAnnouncementDto {
    //通知范围的组织id
    private String notificationScope;
    //通知内容
    private String content;
    //管理员的党员id
    private String partyId;

    public String getNotificationScope() {
        return notificationScope;
    }

    public void setNotificationScope(String notificationScope) {
        this.notificationScope = notificationScope;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }
}
