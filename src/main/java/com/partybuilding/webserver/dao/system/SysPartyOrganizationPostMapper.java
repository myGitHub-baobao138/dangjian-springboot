package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.dto.system.sysPartyOrganizationPost.InsertPartyOrganizationPost;
import com.partybuilding.webserver.dto.system.sysPartyOrganizationPost.UpdatePartyOrgPostDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysPartyOrganizationPostMapper {
    int addPartyOrgPost(@Param("parties") List<InsertPartyOrganizationPost> insertPartyOrganizationPost);
    int addPartyOrgPostSingle(InsertPartyOrganizationPost insertPartyOrganizationPost);
    int updateOrgByKey(InsertPartyOrganizationPost insertPartyOrganizationPost);
    InsertPartyOrganizationPost getOrgAngPost(@Param("organizationId") String organizationId,@Param("postId") String postId,@Param("partyId") String partyId);
    int updateInfo(UpdatePartyOrgPostDto updatePartyOrgPostDto);
}
