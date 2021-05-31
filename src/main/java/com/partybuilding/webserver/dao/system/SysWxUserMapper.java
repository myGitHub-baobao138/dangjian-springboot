package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.system.academy.GetAcademyQueryListInputDTO;
import com.partybuilding.webserver.dto.system.auditRecord.*;
import com.partybuilding.webserver.dto.system.wxuser.GetWxUserListDTO;
import com.partybuilding.webserver.dto.system.wxuser.GetWxUserListInputDTO;
import com.partybuilding.webserver.entity.system.SysOrganizationalStructure;
import com.partybuilding.webserver.entity.system.SysPartyMemberInformation;
import com.partybuilding.webserver.entity.system.SysWxUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysWxUserMapper {

    /**
     * 查询名字（其他模块需）
     * @param id
     * @return
     */
    String selectNameById(String id);

    /**
     * 查询职务id（其他模块需）
     * @param id
     * @return
     */
    String selectPositionIdById(String id);




    /**
     * 获取微信全部符合条件的查询列表
     * @return
     */
    List<GetWxUserListDTO> selectWxUserAllQueryList(GetWxUserListInputDTO inputDTO);

    List<Organization> getOrganizationDownById(String id);



    int deleteByPrimaryKey(String id);

    int insert(SysWxUser record);

    int insertSelective(SysWxUser record);



    int updateByPrimaryKeySelective(SysWxUser record);

    int updateByPrimaryKey(SysWxUser record);

    /**
     * 通过id查询微信用户
     * @param id
     * @return
     */
    SysWxUser selectByPrimaryKey(String id);

    /**
     * 根据学工号获取党员id
     * @param stuJobNumber
     * @return
     */
    String getPartyIdByStuJobNumber(String stuJobNumber);


    /**
     * 认证管理模块
     */



    /**
     * 获取认证信息详情
     * @param id
     * @return
     */
    List<GetVerificationInfoDTO> selectVerificationInfo(String id);

    /**
     * 获取职务
     * @param pId
     * @return
     */
    String getPostNameList(String pId);

    /**
     * 获取组织
     * @param ogId
     * @return
     */
    String getOrganizationNameList(String ogId);

    /**
     * 获取审核记录
     * @param wxId
     * @return
     */
    List<VerificationRecordDTO> getAuditRecords(String wxId);


    /**
     * 根据学工号获取党员信息
     * @param studentJobNumber
     * @return
     */
    PartyAuditInfo getPartyInfoByStudentJobNumber(String studentJobNumber);

    /**
     * 微信用户模块认证成功
     * @param inputDTO
     * @return
     */
    boolean verifyWxUser(VerifyWxUserInputDTO inputDTO);

    /**
     * 通过id查找职务名称
     * @param id
     * @return
     */
    String selectPostNameById(String id);

    /**
     * 插入党员id
     * @param partyId
     * @return
     */
    boolean insertPartyId(@Param(value = "partyId") String partyId, @Param(value = "wxUserId") String wxUserId);


    /**
     *  获取认证信息查询列表 校级用户查询所有
     * @param inputDTO
     * @return
     */
    List<GetVerificationInfoListDTO> getAllVerificationInfoQueryList(GetVerificationInfoQueryListInputDTO inputDTO);

    /**
     * 认证成功，更新WxUser数据
     * @param wxId
     * @param auditResult
     * @param verifyTime
     * @param partyId
     * @return
     */
    boolean updateWxUserStateTimeSuccess(@Param("wxId") String wxId,@Param("auditResult")Integer auditResult,@Param("verifyTime")String verifyTime,@Param("partyId")String partyId);

    /**
     * 认证失败
     * @param wxId
     * @param auditResult
     * @return
     */
    boolean updateWxUserStateTimeFail(@Param("wxId")String wxId,@Param("auditResult")Integer auditResult);

    /**改变中间表，认证状态
     * @param orgPostId
     * @param auditResult
     * @return
     */
    boolean updateOrgPostIsAudited(@Param("orgPostId")String orgPostId,@Param("auditResult")Integer auditResult);


}