package com.partybuilding.webserver.dto.system.academy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
public class AcademyIdNameDTO {
    private String id; // 学院id
    private String academyName; // 学院名

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }
}
