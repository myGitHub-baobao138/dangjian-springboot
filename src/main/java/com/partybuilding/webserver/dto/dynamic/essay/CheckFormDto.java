package com.partybuilding.webserver.dto.dynamic.essay;

import java.util.Date;
import java.util.List;

public class CheckFormDto {
    private String checkerId;
    private String checkerName;
    private String checkedEssayId;
    private String checkedEssayName;
    private List<String> checkedIdList;
    private List<String> checkedNameList;
    private int checkStatus;
    private Date checkTime;
    private String details;

    public String getCheckerId() {
        return checkerId;
    }

    public void setCheckerId(String checkerId) {
        this.checkerId = checkerId;
    }

    public String getCheckedEssayId() {
        return checkedEssayId;
    }

    public void setCheckedEssayId(String checkedEssayId) {
        this.checkedEssayId = checkedEssayId;
    }

    public List<String> getCheckedIdList() {
        return checkedIdList;
    }

    public void setCheckedIdList(List<String> checkedIdList) {
        this.checkedIdList = checkedIdList;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getCheckerName() {
        return checkerName;
    }

    public void setCheckerName(String checkerName) {
        this.checkerName = checkerName;
    }

    public String getCheckedEssayName() {
        return checkedEssayName;
    }

    public void setCheckedEssayName(String checkedEssayName) {
        this.checkedEssayName = checkedEssayName;
    }

    public List<String> getCheckedNameList() {
        return checkedNameList;
    }

    public void setCheckedNameList(List<String> checkedNameList) {
        this.checkedNameList = checkedNameList;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }
}
