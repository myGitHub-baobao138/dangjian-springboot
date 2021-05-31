package com.partybuilding.webserver.dto.system.sysPartyOrganizationPost;

/**
 * @description 更改
 */
public class UpdatePartyOrgPostDto {
    //    partyOrgPOstId
    private String partyOrgPOstId;
    //党员partyId
    private String partyId;
    //组织 id  organizationId
    private String organizationId;
    //职务id
    private String postId;

    public String getPartyOrgPOstId() {
        return partyOrgPOstId;
    }

    public void setPartyOrgPOstId(String partyOrgPOstId) {
        this.partyOrgPOstId = partyOrgPOstId;
    }

    public String getPartyId() {
        return partyId;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }
}
