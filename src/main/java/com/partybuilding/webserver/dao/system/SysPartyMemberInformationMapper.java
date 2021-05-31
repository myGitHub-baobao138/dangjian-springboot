package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.dto.system.partyInformation.*;
import com.partybuilding.webserver.entity.system.SysPartyMemberInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SysPartyMemberInformationMapper {
    int deleteByPrimaryKey(String id);

    int deleteBySnoOrNumber(@Param("number") String SnoOrNumber);

    /**
     * 按照学号或者工号查询党员信息
     * @param number
     * @return
     */
    AddInformationDto selectInformationBySno(String number);

    List<SearchResultDto> selectInformationByAcademy(String academy);

    List<SearchResultDto> selectAllInformation();

    int insert(AddPartyInformationDto record);

    int insertSelective(SysPartyMemberInformation record);

    SysPartyMemberInformation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysPartyMemberInformation record);

    int updateByPrimaryKey(AddPartyInformationDto record);

    /**
     * 插入大量数据时使用，即导入word文档时使用
     * @param addPartyInformationDtos
     * @return
     */
    int insertList(@Param("informations") List<AddPartyInformationDto> addPartyInformationDtos);

    int selectByNumber(String number);


    /**
     * 根据学号或者是工号修改信息
     * @param addInformationDto
     * @return
     */
    int updateBySnoOrNumber(AddInformationDto addInformationDto);

    //根据名字以及职务id查询数据 校级
    List<SearchResultDto> selectByNameAndPost(SearchPostAndNameDto searchPostAndNameDto);
    //根据党员姓名以及职务、院校名称查询党员数据  院级
    List<SearchResultDto> selectByNameAndPostAndAcademy(SearchPostAndNameAndAcademyDto searchPostAndNameAndAcademyDto);

    //校级根据名字查询党员数据 校级
    List<SearchResultDto> selectByName(String name);
    //院级根据学院以及名字查询数据 院级

    List<SearchResultDto> selectByNameAndAcademy(SearchByNameAndAcademy searchByNameAndAcademy);

    //根据名称以及学院信息查询数据
    List<SearchResultDto> selectByPostNameAndAcademy(@Param("postName") String postName, @Param("academyId") String academyId);

    //根据职务名称查询数据
    List<SearchResultDto> selectByPostName(String postName);

    List<SelectSnoAndName> selectPartyNameLike(String name);

    List<SnoAndId> getSnoList();


    /**
     * 查询党员基本信息
     * @param dto
     * @return
     */
    List<FindPartyBaseInfoDTO> findPartyBaseInfo(FindPartyBaseInfoPageInfoDTO dto);

    //查找所有党员id
    List<String> selectAllPartyByOrganizationId(String organizationId);
    //查询二级组织下面的所有党员id
    List<String> selectPartyByOrganizationId(String organizationId);
}