package com.partybuilding.webserver.serviceImpl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.system.SysCertificationAuditRecordMapper;
import com.partybuilding.webserver.dao.system.SysWxUserMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.system.academy.GetAcademyQueryListInputDTO;
import com.partybuilding.webserver.dto.system.auditRecord.*;
import com.partybuilding.webserver.entity.system.SysPartyMemberInformation;
import com.partybuilding.webserver.entity.system.SysWxUser;
import com.partybuilding.webserver.service.system.SysAuditRecordService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import com.partybuilding.webserver.util.WxUnicode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 */
@Service
@Transactional
public class SysAuditRecordServiceImpl implements SysAuditRecordService {

    @Autowired
    private SysWxUserMapper sysWxUserMapper;

    @Autowired
    private SysCertificationAuditRecordMapper sysCertificationAuditRecordMapper;


    /**
     * 获取认证信息详情
     *
     * @param id
     * @return
     */
    @Override
    public GetVerificationInfoDTO getVerificationInfo(String id) {
        List<GetVerificationInfoDTO> list1 = sysWxUserMapper.selectVerificationInfo(id);
        if (list1 != null && list1.size() != 0) {
            GetVerificationInfoDTO dto = list1.get(0);
            dto.setAuditRecords(new ArrayList<VerificationRecordDTO>());
            dto.setOrganizationName(new ArrayList<String>());
            dto.setPosition(new ArrayList<String>());
            for (int i = 0; i < list1.size(); i++) {
                dto.setAuditRecords(sysWxUserMapper.getAuditRecords(list1.get(i).getId()));
                dto.getOrganizationName().add(sysWxUserMapper.getOrganizationNameList(list1.get(i).getOgId()));
                dto.getPosition().add(sysWxUserMapper.getPostNameList(list1.get(i).getpId()));
            }
            dto.setNickname(WxUnicode.decodeUnicode(dto.getNickname())); // 昵称解码

            List<VerificationRecordDTO> list = dto.getAuditRecords();
            if (list.size() != 0) {
                for (VerificationRecordDTO verificationRecordDTO : list) {
                    if (verificationRecordDTO.getAuditUser() == null) {
                        verificationRecordDTO.setAuditUser("系统认证");
                    }

                }
            }
            return dto;
        } else {
            return null;
        }


    }

    /**
     * 微信用户认证
     *
     * @param inputDTO
     * @return
     */
    @Override
    public JsonResult verifyWxUser(VerifyWxUserInputDTO inputDTO) {
        JsonResult jsonResult = new JsonResult();
        inputDTO.setAuditRecordId(Uuid.getUuid());

        if (inputDTO.getAuditResult() == 1) { // 成功 更新wxUser表的记录，和时间,党员id
            // 微信id查小程序用户
            SysWxUser sysWxUser = sysWxUserMapper.selectByPrimaryKey(inputDTO.getWxUserId());
            if (sysWxUser == null) {
                inputDTO.setAuditResult(2); // 失败
                jsonResult.setCode(500);
                jsonResult.setMessage("找不到该用户");
                inputDTO.setRemarks("找不到该用户");
                boolean isSuccess5 = sysWxUserMapper.updateWxUserStateTimeFail(inputDTO.getWxUserId(), inputDTO.getAuditResult());
            } else {
                String partyId = sysWxUserMapper.getPartyIdByStuJobNumber(sysWxUser.getStudentJobNumber());
                if (partyId == null) {
                    inputDTO.setAuditResult(2); // 失败
                    jsonResult.setCode(500);
                    jsonResult.setMessage("学工号有误");
                    inputDTO.setRemarks("学工号有误");
                    boolean isSuccess5 = sysWxUserMapper.updateWxUserStateTimeFail(inputDTO.getWxUserId(), inputDTO.getAuditResult());
                } else {
                    boolean isSuccess1 = sysWxUserMapper.updateWxUserStateTimeSuccess(inputDTO.getWxUserId(), inputDTO.getAuditResult(), inputDTO.getVerifyTime(), partyId);
                }
            }


        } else { // 失败
            boolean isSuccess2 = sysWxUserMapper.updateWxUserStateTimeFail(inputDTO.getWxUserId(), inputDTO.getAuditResult());
        }


        // 插入一条审核记录
        boolean isSuccess = sysCertificationAuditRecordMapper.insertCertificationAuditRecord(inputDTO);
        // 修改微信组织职务表的is_audited
        boolean isSuccess3 = sysWxUserMapper.updateOrgPostIsAudited(inputDTO.getOrganPostId(),inputDTO.getAuditResult());

        return jsonResult;
    }

//    public JsonResult verifyWxUser(VerifyWxUserInputDTO inputDTO) {
//        JsonResult jsonResult = new JsonResult();
//
//        // 微信id查小程序用户
//        SysWxUser sysWxUser = sysWxUserMapper.selectByPrimaryKey(inputDTO.getWxUserId());
//        // 用学号查党员信息
//        if(sysWxUser != null){
//            PartyAuditInfo partyInfo = sysWxUserMapper.getPartyInfoByStudentJobNumber(sysWxUser.getStudentJobNumber());
//            String message = "";
//            boolean isFlag = true;
//            // 一一比较
//            if(partyInfo == null){
//                message += "学号填写错误,";
//                isFlag = false;
//            } else {
//                if(!partyInfo.getName().equals(sysWxUser.getName())){
//                    message += "姓名填写错误,";
//                    isFlag = false;
//                }
//                if(!partyInfo.getPositionId().equals(sysWxUser.getPositionId())){
//                    message += "职务选择错误,";
//                    isFlag = false;
//                }
//                if(!(partyInfo.getSex() == sysWxUser.getSex())){
//                    message += "性别选择错误,";
//                    isFlag = false;
//                }
//                if(!(partyInfo.getAcademyId().equals(sysWxUser.getAcademyId()))){
//                    message += "学院选择错误,";
//                    isFlag = false;
//                }
//                if(!(partyInfo.getTelNumber().equals(sysWxUser.getTelNumber()))){
//                    message += "联系电话填写错误,";
//                    isFlag = false;
//                }
//                if(!(partyInfo.getType()==sysWxUser.getType())){
//                    message += "类型选择错误,";
//                    isFlag = false;
//                }
//                if(isFlag == true){
//                    String postName = sysWxUserMapper.selectPostNameById(partyInfo.getPositionId());
//                    if(postName.contains("书记") && sysWxUser.getType() == 0){
//                        isFlag = false;
//                        message += "是否书记选择错误";
//                    }
//                }
//            }
//
//            if(isFlag == false){ // 认证失败
//                inputDTO.setAuditResult(2);
//                inputDTO.setRemarks(message);
//                boolean v = sysWxUserMapper.verifyWxUser(inputDTO);
//                inputDTO.setAuditRecordId(Uuid.getUuid());
//                boolean u = sysCertificationAuditRecordMapper.insertCertificationAuditRecord(inputDTO);
//                jsonResult.setData(false);
//                jsonResult.setCode(500);
//                jsonResult.setMessage(message); // 这里现在返回的消息时系统判断的
//            } else { // 认证成功
//                boolean isTrue = true;
////                if (inputDTO.getAuditResult() == 1 || inputDTO.getAuditResult() == 2) {
////                    isTrue = sysWxUserMapper.verifyWxUser(inputDTO);
////                }
//                inputDTO.setAuditResult(1);
//                boolean a = sysWxUserMapper.insertPartyId(partyInfo.getId(),sysWxUser.getId());
//                isTrue = sysWxUserMapper.verifyWxUser(inputDTO);
//                inputDTO.setAuditRecordId(Uuid.getUuid());
//                boolean isSuccess = sysCertificationAuditRecordMapper.insertCertificationAuditRecord(inputDTO);
//                jsonResult.setData(isSuccess && isTrue);
//            }
//
//        } else{
//            jsonResult.setCode(500);
//            jsonResult.setMessage("审核失败，找不到该用户");
//            jsonResult.setData(false);
//        }
//
//        return jsonResult;
//    }


    /**
     * 获取认证信息列表
     *
     * @param inputDTO
     * @return
     */
    @Override
    public PageResult<GetVerificationInfoListDTO> getVerificationInfoQueryList(GetVerificationInfoQueryListInputDTO inputDTO) {
        //  判断参数是否有误
        if (inputDTO.getCurrentPage() <= 0) {
            inputDTO.setCurrentPage(1);  //设置默认当前页
        }
        if (inputDTO.getPageSize() <= 0) {
            inputDTO.setPageSize(5); // 默认每页5条
        }


        PageHelper.startPage(inputDTO.getCurrentPage(), inputDTO.getPageSize());
        List<GetVerificationInfoListDTO> lists = sysWxUserMapper.getAllVerificationInfoQueryList(inputDTO);
        for (GetVerificationInfoListDTO dto : lists) {
            dto.setNickname(WxUnicode.decodeUnicode(dto.getNickname()));
        }


        // 获取分页查询后的数据
        PageInfo<GetVerificationInfoListDTO> pageInfo = new PageInfo<>(lists);
        // 封装需要返回的分页实体
        PageResult<GetVerificationInfoListDTO> result = new PageResult<GetVerificationInfoListDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(lists);

        return result;
    }

    @Override
    public List<Organization> getOrganizationDownById(String id) {
        return sysCertificationAuditRecordMapper.getOrganizationDownById(id);
    }

    @Override
    public JsonResult verifyWxUserList(VerifyWxUserInputListDTO inputListDTO) {
        JsonResult jsonResult = new JsonResult();
        VerifyWxUserInputDTO inputDTO = new VerifyWxUserInputDTO();

        for(int i = 0; i < inputListDTO.getOrganPostIds().size(); i++){
            inputDTO.setAuditRecordId(Uuid.getUuid());
            inputDTO.setAuditResult(inputListDTO.getAuditResult());
            inputDTO.setRemarks(inputListDTO.getRemarks());
            inputDTO.setOrganPostId(inputListDTO.getOrganPostIds().get(i));
            inputDTO.setWxUserId(inputListDTO.getWxUserIds().get(i));
            inputDTO.setVerifyTime(inputListDTO.getVerifyTime());
            inputDTO.setPartyId(inputListDTO.getPartyId());


            if (inputDTO.getAuditResult() == 1) { // 成功 更新wxUser表的记录，和时间,党员id
                // 微信id查小程序用户
                SysWxUser sysWxUser = sysWxUserMapper.selectByPrimaryKey(inputDTO.getWxUserId());
                if (sysWxUser == null) {
                    inputDTO.setAuditResult(2); // 失败
                    jsonResult.setCode(500);
                    jsonResult.setMessage("审核失败");
                    inputDTO.setRemarks("找不到该用户");
                    boolean isSuccess5 = sysWxUserMapper.updateWxUserStateTimeFail(inputDTO.getWxUserId(), inputDTO.getAuditResult());
                } else {
                    String partyId = sysWxUserMapper.getPartyIdByStuJobNumber(sysWxUser.getStudentJobNumber());
                    if (partyId == null) {
                        inputDTO.setAuditResult(2); // 失败
                        jsonResult.setCode(500);
                        jsonResult.setMessage("部分学工号有误");
                        inputDTO.setRemarks("学工号有误");
                        boolean isSuccess2 = sysWxUserMapper.updateWxUserStateTimeFail(inputDTO.getWxUserId(), inputDTO.getAuditResult());
                    } else {
                        boolean isSuccess6 = sysWxUserMapper.updateWxUserStateTimeSuccess(inputDTO.getWxUserId(), inputDTO.getAuditResult(), inputDTO.getVerifyTime(), partyId);
                    }
                }


            } else { // 失败
                boolean isSuccess2 = sysWxUserMapper.updateWxUserStateTimeFail(inputDTO.getWxUserId(), inputDTO.getAuditResult());
            }


            // 插入一条审核记录
            boolean isSuccess = sysCertificationAuditRecordMapper.insertCertificationAuditRecord(inputDTO);
            // 修改微信组织职务表的is_audited
            boolean isSuccess3 = sysWxUserMapper.updateOrgPostIsAudited(inputDTO.getOrganPostId(),inputDTO.getAuditResult());
        }


        return jsonResult;
    }
}
