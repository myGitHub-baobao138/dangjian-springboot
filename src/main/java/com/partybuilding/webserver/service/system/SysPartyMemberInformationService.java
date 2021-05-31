package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.system.partyInformation.*;
import com.partybuilding.webserver.dto.system.post.PostNameAndPostId;
import com.partybuilding.webserver.entity.system.SysPartyMemberInformation;
import com.partybuilding.webserver.util.PageResult;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;

public interface SysPartyMemberInformationService {
    int deleteByPrimaryKey(String id);

    JsonResult insert(AddInformationDto record);

    int insertSelective(SysPartyMemberInformation record);

    SysPartyMemberInformation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysPartyMemberInformation sysPartyMemberInformation);

    JsonResult updateByPrimaryKey(UpdateInformation record);

    public JsonResult validateExcel(Workbook hssfWorkbook);

    /**
     * 按照工号查找数据
     * @param number
     * @return
     */
    int selectByNumber(String number);


    AddInformationDto selectInformationBySno(String number);

    JsonResult selectInformationByAcademy(String academy, PageInputDTO pageInputDTO);

    JsonResult selectAllInformation(PageInputDTO pageInputDTO);

    int updateBySnoOrNumber(AddInformationDto addInformationDto);

    JsonResult selectByNameAndPost(SearchPostAndNameDto searchPostAndNameDto);

    JsonResult selectByName(SearchByNameDto searchByNameDto);

    JsonResult selectByPostName(SearchByPostDto searchByPostDto);

    List<SelectSnoAndName> selectPartyNameLike(String name);

    /**
     * 查询党员基本信息
     * @param dto
     * @return
     */
    PageResult findPartyBaseInfo(FindPartyBaseInfoPageInfoDTO dto);

    List<PostNameAndPostId> findPostNameAndPostId();
}
