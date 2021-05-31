package com.partybuilding.webserver.entity.service;

/**
 * 会议-参会人员表
 */
public class ServiceParticipateThreeSessionOneClass {
    private String id;

    private String threeSessionOneClassId;

    private String participateId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getThreeSessionOneClassId() {
        return threeSessionOneClassId;
    }

    public void setThreeSessionOneClassId(String threeSessionOneClassId) {
        this.threeSessionOneClassId = threeSessionOneClassId == null ? null : threeSessionOneClassId.trim();
    }

    public String getParticipateId() {
        return participateId;
    }

    public void setParticipateId(String participateId) {
        this.participateId = participateId == null ? null : participateId.trim();
    }
}