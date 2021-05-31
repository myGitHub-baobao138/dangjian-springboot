package com.partybuilding.webserver.config;

import com.partybuilding.webserver.dao.system.SysOperationLogMapper;
import com.partybuilding.webserver.entity.system.SysOperationLog;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
@Aspect
public class LogAopConfiguration {
    @Autowired
    SysOperationLogMapper operationLogMapper;

    @After("execution(public * com.partybuilding.webserver.controller.*.*.*(..))")
    public void after() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();

        Map<String, String> headMap = new HashMap<>();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            headMap.put(key, value);
        }

        String requestUrl = request.getRequestURL().toString();
        writeLog(requestUrl.substring(requestUrl.indexOf("/", 9)), headMap.get("partyid"));
    }

    public int writeLog(String resUrl, String partyId) {

        String[] operationInfos = getOperationPageAndContent(resUrl);

        // 如果未获取到操作页面和内容，则不写入日志
        if (operationInfos == null) {
            return 0;
        }

        SysOperationLog log = new SysOperationLog();
        log.setPartyId(partyId);
        log.setOperationPage(operationInfos[0]);
        log.setOperationContent(operationInfos[1]);
        log.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        log.setOperationTime(new Date());
        return operationLogMapper.addOperationLog(log);
    }

    // 通过url获取操作页面及其操作内容
    public String[] getOperationPageAndContent(String request) {
        switch (request) {
            case "/Dynamic/DyCheckEssayController/updateEssayBySingleEssayId": {
                return new String[]{"风采管理/审核稿件管理", "审核稿件"};
            }
            case "/Dynamic/DyCheckEssayController/updateManyEssayByEssayIdList": {
                return new String[]{"风采管理/审核稿件管理", "审核稿件"};
            }
            case "/Dynamic/CultivateController/createCultivateEssay": {
                return new String[]{"党建培训", "创建文章"};
            }
            case "/Dynamic/CultivateController/deleteCultivateEssayById": {
                return new String[]{"党建培训", "删除文章"};
            }
            case "/Dynamic/CultivateController/modifyEssayById": {
                return new String[]{"党建培训", "修改文章"};
            }
            case "/Dynamic/CultivateController/publishEssayById": {
                return new String[]{"党建培训", "发布文章"};
            }
            case "/Dynamic/DyPublishEssayController/deleteByEssayIdFromList": {
                return new String[]{"风采管理/文章发布管理", "删除文章"};
            }
            case "/Dynamic/DyPublishEssayController/insertNewEssay": {
                return new String[]{"风采管理/文章发布管理", "新增文章"};
            }
            case "/Dynamic/DyPublishEssayController/makeManyEssaysLeave": {
                return new String[]{"风采管理/文章发布管理", "下架文章"};
            }
            case "/Dynamic/DyPublishEssayController/makeSingleEssayLeave": {
                return new String[]{"风采管理/文章发布管理", "下架文章"};
            }
            case "/Dynamic/DyPublishEssayController/publishManyEssayFromList": {
                return new String[]{"风采管理/文章发布管理", "发布文章"};
            }
            case "/Dynamic/DyPublishEssayController/publishSingleEssayFromList": {
                return new String[]{"风采管理/文章发布管理", "发布文章"};
            }
            case "/Dynamic/DyPublishEssayController/setEssayOutTop": {
                return new String[]{"风采管理/文章发布管理", "取消文章置顶"};
            }
            case "/Dynamic/DyPublishEssayController/setEssayTop": {
                return new String[]{"风采管理/文章发布管理", "文章置顶"};
            }
            case "/Dynamic/DyPublishEssayController/updateEssayById": {
                return new String[]{"风采管理/文章发布管理", "修改草稿"};
            }
            case "/Service/ChangeOrganization/createApplication": {
                return new String[]{"转组织关系", "创建转组织关系"};
            }
            case "/Service/ChangeOrganization/addApprovalRecord": {
                return new String[]{"转组织关系", "审批转组织申请"};
            }
            case "/Service/examineManagementController/addExamine": {
                return new String[]{"在线答题/考题管理", "新增考题"};
            }
            case "/Service/examineManagementController/deleteExamineQuestionById": {
                return new String[]{"在线答题/考题管理", "删除考题"};
            }
            case "/Service/examineManagementController/earlyTermination": {
                return new String[]{"在线答题/考题管理", "结束考题"};
            }
            case "/Service/examineManagementController/releaseExamine": {
                return new String[]{"在线答题/考题管理", "发布考题"};
            }
            case "/Service/examineManagementController/updateExamineQuestion": {
                return new String[]{"在线答题/考题管理", "修改考题"};
            }
            case "/Service/DJAdminLeaveWords/replyLeaveWords": {
                return new String[]{"留言管理", "回复留言"};
            }
            case "/Service/questionCategoryController/addQuestionCategory": {
                return new String[]{"在线答题/问题分类管理", "创建分类"};
            }
            case "/Service/questionCategoryController/deleteCategoryById": {
                return new String[]{"在线答题/问题分类管理", "删除分类"};
            }
            case "/Service/questionCategoryController/editQuestionCategory": {
                return new String[]{"在线答题/问题分类管理", "修改分类"};
            }
            case "/Service/questionController/addQuestion": {
                return new String[]{"在线答题/题库管理", "添加问题"};
            }
            case "/Service/questionController/deleteQuestion": {
                return new String[]{"在线答题/题库管理", "删除问题"};
            }
            case "/Service/questionController/editQuestion": {
                return new String[]{"在线答题/题库管理", "编辑问题"};
            }
            case "/Service/ServiceThemeDayController/deleteThemeDay": {
                return new String[]{"党主题日管理", "删除主题"};
            }
            case "/Service/ServiceThemeDayController/insertThemeDay": {
                return new String[]{"党主题日管理", "新增主题"};
            }
            case "/Service/ServiceThemeDayController/postThemeDay": {
                return new String[]{"党主题日管理", "发布主题"};
            }
            case "/Service/ServiceThemeDayController/updateNotTop": {
                return new String[]{"党主题日管理", "取消主题置顶"};
            }
            case "/Service/ServiceThemeDayController/updateThemeDay": {
                return new String[]{"党主题日管理", "修改主题信息"};
            }
            case "/Service/ServiceThemeDayController/updateTop": {
                return new String[]{"党主题日管理", "置顶主题"};
            }
            case "/Service/DJAdminThreeSessionOneClass/deleteThreeOne": {
                return new String[]{"三会一课/三会一课管理", "删除会议/课程"};
            }
            case "/Service/DJAdminThreeSessionOneClass/insertThreeOne": {
                return new String[]{"三会一课/三会一课管理", "新增会议/课程"};
            }
            case "/Service/DJAdminThreeSessionOneClass/postThreeOne": {
                return new String[]{"三会一课/三会一课管理", "发布会议/课程"};
            }
            case "/Service/DJAdminThreeSessionOneClass/updateThreeOne": {
                return new String[]{"三会一课/三会一课管理", "修改会议/课程"};
            }
            case "/Service/DJAdminThreeSessionOneClass/insertSummary": {
                return new String[]{"三会一课/三会一课管理", "新增会议/课程纪要"};
            }
            case "/Service/DJAdminThreeSessionOneClass/updateSummary": {
                return new String[]{"三会一课/三会一课管理", "修改会议/课程纪要"};
            }
            case "/Service/VoteController/insertVote": {
                return new String[]{"投票管理", "发起投票调查"};
            }
            case "/Service/VoteController/updateVote": {
                return new String[]{"投票管理", "修改投票调查信息"};
            }
            case "/System/AnnouncementController/addAnnouncement": {
                return new String[]{"系统公告", "发布系统公告"};
            }
            case "/System/DJAdminVerificationManagement/verifyWxUser": {
                return new String[]{"认证管理", "审核认证申请"};
            }
            case "/System/DJAdminVerificationManagement/verifyWxUserList": {
                return new String[]{"认证管理", "审核认证申请"};
            }
            case "/System/OrganizationalStructureController/addStructure": {
                return new String[]{"组织架构", "添加组织架构"};
            }
            case "/System/OrganizationalStructureController/deleteInfo": {
                return new String[]{"组织架构", "删除选中组织（包括下级）"};
            }
            case "/System/OrganizationalStructureController/updateInfo": {
                return new String[]{"组织架构", "修改组织名称/说明"};
            }
            case "/System/PartyMemberInformationController/addSingleInfo": {
                return new String[]{"党员管理", "新增党员信息"};
            }
            case "/System/PartyMemberInformationController/deleteById": {
                return new String[]{"党员管理", "删除党员信息"};
            }
            case "/System/PartyMemberInformationController/downloadFile": {
                return new String[]{"党员管理", "下载Excel模板"};
            }
            case "/System/PartyMemberInformationController/editInformation": {
                return new String[]{"党员管理", "修改党员信息"};
            }
            case "/System/PartyMemberInformationController/uploadExcel": {
                return new String[]{"党员管理", "上传Excel"};
            }
            case "/System/PostController/addPostInfo": {
                return new String[]{"职务管理", "创建职务"};
            }
            case "/System/PostController/deletePostInfoById": {
                return new String[]{"职务管理", "删除职务"};
            }
            case "/System/PostController/modifyPostInfo": {
                return new String[]{"职务管理", "修改职务"};
            }
            case "/System/RightController/createRightInfo": {
                return new String[]{"权限管理", "创建权限角色"};
            }
            case "/System/RightController/allocateRoleRight": {
                return new String[]{"权限管理", "分配权限"};
            }
            case "/System/RightController/deleteRightRoleAndResource": {
                return new String[]{"权限管理", "删除角色"};
            }
            case "/System/UserController/createUserAccount": {
                return new String[]{"后台账号管理", "创建账号"};
            }
            case "/System/UserController/deleteUserInfoByUserId": {
                return new String[]{"后台账号管理", "删除账号"};
            }
            case "/System/UserController/modifyUserAccountState": {
                return new String[]{"后台账号管理", "启用/禁用账号"};
            }
            case "/System/UserController/modifyUserInformationByUserId": {
                return new String[]{"后台账号管理", "修改账号信息"};
            }
            case "/Service/VolunteerActivityController/deleteActivityById": {
                return new String[]{"志愿活动管理/活动报名管理", "删除志愿活动"};
            }
            case "/Service/VolunteerActivityController/updateByPrimaryKeySelective": {
                return new String[]{"志愿活动管理/活动报名管理", "创建志愿活动"};
            }
            case "/Service/ActivityRegistration/insertActivity": {
                return new String[]{"志愿活动管理/活动报名管理", "发布志愿活动"};
            }
            case "/Service/VolunteerActivityController/examine": {
                return new String[]{"志愿活动管理/志愿活动审核管理", "审核志愿活动"};
            }
            default: {
                return null;
            }
        }
    }
}
