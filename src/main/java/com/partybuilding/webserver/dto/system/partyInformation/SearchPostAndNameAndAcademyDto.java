package com.partybuilding.webserver.dto.system.partyInformation;

public class SearchPostAndNameAndAcademyDto {
    private String name;
    private String postName;
    private String academyId;

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getAcademyId() {
        return academyId;
    }

    public void setAcademyId(String academyId) {
        this.academyId = academyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
