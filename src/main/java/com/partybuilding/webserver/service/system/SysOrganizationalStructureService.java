package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.structure.*;
import com.partybuilding.webserver.entity.system.SysOrganizationalStructure;

import java.util.List;


public interface SysOrganizationalStructureService {
    JsonResult deleteByPrimaryKey(String organizationalId);

    int insert(SysOrganizationalStructure record);

    JsonResult insertSelective(AddStructureDto record);

    SysOrganizationalStructure selectByPrimaryKey(String organizationalId);

    int updateByPrimaryKeySelective(SysOrganizationalStructure record);

    int updateByPrimaryKey(SysOrganizationalStructure record);

    List<SearchStructureDto> searchAllStructure(Integer rank);

//    根据组织名称以及组织等级查询数据
    JsonResult searchByRankAndPostId(RankAndOrganization rankAndOrganization);

    JsonResult searchByPostName(SearchStructureByPostName searchStructureByPostName);

    JsonResult searchByRank(SearchStructureByRank searchStructureByRank);

    JsonResult SearchOrgNameAndId();

    JsonResult SearchSingleOrgNameAndId(String organizationId);

    JsonResult selectHigherOrgAndRank(HigherOrgAndRank higherOrgAndRank);

    JsonResult  selectStructureParty(Integer rank,String organizationId);

    JsonResult updateInfo(UpdateNameAndRemarkDto updateNameAndRemarkDto);
}
