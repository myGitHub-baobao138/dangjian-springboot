package com.partybuilding.webserver.dao.system;


import com.partybuilding.webserver.dto.system.structure.*;
import com.partybuilding.webserver.entity.system.SysOrganizationalStructure;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysOrganizationalStructureMapper {
    int deleteByPrimaryKey(String organizationalId);

    int insert(SysOrganizationalStructure record);


    SysOrganizationalStructure selectByPrimaryKey(String organizationalId);


    int updateByPrimaryKey(SysOrganizationalStructure record);

    List<SearchStructureDto> searchAllStructure(Integer rank);

    Integer selectRank(String organizationId);

    List<SearchStructureDto> searchByRankAndPostId(RankAndOrganization rankAndOrganization);

    List<SearchStructureDto> searchByPostName(String organizationName);

    List<SearchStructureDto> searchByRank(Integer rank);

    String getOrganizationIdByName(String organizationName);

    List<OrganizationNameAndIdDto> SearchOrgNameAndId();

    List<OrganizationNameAndIdDto> SearchSingleOrgNameAndId(String organizationId);

    List<OrganizationNameAndIdDto> selectHigherOrgAndRank(HigherOrgAndRank higherOrgAndRank);

    List<OrganizationNameAndIdDto> selectStructureParty(@Param("rank") Integer rank, @Param("organizationId") String organizationId);

    int updateInfo(UpdateNameAndRemarkDto updateNameAndRemarkDto);

    String repeatOrganization(NameAndHigherId nameAndHigherId);
    //判断是否有下级组织以及下级组织是否有人
    List<OrganizationIdAndNumber> isDelete(String organizationId);

}