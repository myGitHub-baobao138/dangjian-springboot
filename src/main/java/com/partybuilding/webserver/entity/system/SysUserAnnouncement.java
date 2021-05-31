package com.partybuilding.webserver.entity.system;

public class SysUserAnnouncement {
    private Integer id;

    private String sysWxUserId;

    private String sysAnnouncementId;

    private Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysWxUserId() {
        return sysWxUserId;
    }

    public void setSysWxUserId(String sysWxUserId) {
        this.sysWxUserId = sysWxUserId == null ? null : sysWxUserId.trim();
    }

    public String getSysAnnouncementId() {
        return sysAnnouncementId;
    }

    public void setSysAnnouncementId(String sysAnnouncementId) {
        this.sysAnnouncementId = sysAnnouncementId == null ? null : sysAnnouncementId.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}