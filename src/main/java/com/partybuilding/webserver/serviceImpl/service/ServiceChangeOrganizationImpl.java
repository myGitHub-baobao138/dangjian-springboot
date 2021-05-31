package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceChangeOrganizationMapper;
import com.partybuilding.webserver.dto.service.changeOrganization.*;
import com.partybuilding.webserver.entity.service.ServiceChangeOrganization;
import com.partybuilding.webserver.entity.service.ServiceChangeOrganizationApproval;
import com.partybuilding.webserver.service.service.ServiceChangeOrganizationService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 */
@Transactional
@Service
public class ServiceChangeOrganizationImpl implements ServiceChangeOrganizationService {
    private static ArrayList<String> nations = new ArrayList<>();
    @Autowired
    ServiceChangeOrganizationMapper changeOrganizationMapper;

    /**
     * 创建转组织关系申请
     *
     * @param dto
     * @return
     */
    @Override
    public int createChangeOrganizationRelationshipApplication(OrganizationApplicationRequestDTO dto) {
        dto.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        if (!nationVerify(dto.getUserNation())) {
            return 700; // 民族不存在
        }
        String originOrganizationId;
        String targetOrganizationId;
        if (dto.getOriginOrganizationName().equals(dto.getTargetOrganizationName())) {
            return 600; // 原党支部跟目的党支部不能相同
        }
        originOrganizationId = changeOrganizationMapper.findOriginOrganizationIsExist(dto.getOriginOrganizationName());

        if (originOrganizationId == null || originOrganizationId.equals(""))
            return 100; // 原党支部不存在
        targetOrganizationId = changeOrganizationMapper.findOriginOrganizationIsExist(dto.getTargetOrganizationName());
        if (targetOrganizationId == null || targetOrganizationId.equals(""))
            return 200; // 现党支部不存在
        FindPartyIsExistOnOriginOrganizationDTO partyIsExistOnOriginOrganizationDTO = new FindPartyIsExistOnOriginOrganizationDTO();
        partyIsExistOnOriginOrganizationDTO.setNumber(dto.getUserNumber());
        partyIsExistOnOriginOrganizationDTO.setOrganizationName(dto.getOriginOrganizationName());
        String organizationId = changeOrganizationMapper.findPartyIsExistOnOriginOrganization(partyIsExistOnOriginOrganizationDTO);
        if (organizationId == null || organizationId.equals(""))
            return 300; // 党员不在现党支部中
        dto.setOriginOrganizationId(originOrganizationId);
        dto.setTargetOrganizationId(targetOrganizationId);
        dto.setApprovalHistoryId(UUID.randomUUID().toString().replaceAll("-", ""));
        dto.setApprovalDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        return changeOrganizationMapper.createChangeOrganizationRelationshipApplication(dto);
    }

    /**
     * 创建转组织关系申请时，通过学号/工号查询源组织与目的组织
     * @param number
     * @return
     */
    @Override
    public OriginAndTargetOrganizationDTO searchOrganizationByNum(String number){
        return changeOrganizationMapper.searchOrganizationByNum(number);
    }


    /**
     * 查询转组织关系申请
     *
     * @param dto
     * @return
     */
    @Override
    public PageResult findChangeOrganizationByCondition(FindChangeOrganizationInfoPageDTO dto) {
        //  判断参数是否有误
        if (dto.getCurrentPage() <= 0) {
            dto.setCurrentPage(1);  //设置默认当前页
        }
        if (dto.getPageSize() <= 0) {
            dto.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        List<ServiceChangeOrganization> list;
        list = changeOrganizationMapper.findChangeOrganizationByCondition(dto);
        // 获取分页查询后的数据
        PageInfo<ServiceChangeOrganization> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<ServiceChangeOrganization> result = new PageResult<ServiceChangeOrganization>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    /**
     * 查询审核历史
     *
     * @param applicationId
     * @return
     */
    public List<OrganizationApprovalHistory> findApprovalHistory(String applicationId) {
        return changeOrganizationMapper.findApprovalHistory(applicationId);
    }

    /**
     * 审批确认并添加一条审核历史记录
     *
     * @param dto
     * @return
     */
    public int addApprovalRecord(ServiceChangeOrganizationApproval dto) {
        dto.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        dto.setApprovalDate(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        return changeOrganizationMapper.addApprovalRecord(dto);
    }

    /**
     * 状态完成时查看审批状态
     *
     * @param applicationId
     * @return
     */
    public int findApplicationState(String applicationId) {
        if (changeOrganizationMapper.findApplicationState(applicationId) == null)
            return 400;
        else
            return Integer.valueOf(changeOrganizationMapper.findApplicationState(applicationId));
    }

    static {
        nations.add("汉族");
        nations.add("蒙古族");
        nations.add("回族");
        nations.add("藏族");
        nations.add("维吾尔族");
        nations.add("苗族");
        nations.add("彝族");
        nations.add("壮族");
        nations.add("布依族");
        nations.add("朝鲜族");
        nations.add("满族");
        nations.add("侗族");
        nations.add("瑶族");
        nations.add("白族");
        nations.add("土家族");
        nations.add("哈尼族");
        nations.add("哈萨克族");
        nations.add("傣族");
        nations.add("黎族");
        nations.add("傈僳族");
        nations.add("佤族");
        nations.add("畲族");
        nations.add("高山族");
        nations.add("拉祜族");
        nations.add("水族");
        nations.add("东乡族");
        nations.add("纳西族");
        nations.add("景颇族");
        nations.add("柯尔克孜族");
        nations.add("土族");
        nations.add("达斡尔族");
        nations.add("仫佬族");
        nations.add("羌族");
        nations.add("布朗族");
        nations.add("撒拉族");
        nations.add("毛难族");
        nations.add("仡佬族");
        nations.add("锡伯族");
        nations.add("阿昌族");
        nations.add("普米族");
        nations.add("塔吉克族");
        nations.add("怒族");
        nations.add("乌孜别克族");
        nations.add("俄罗斯族");
        nations.add("鄂温克族");
        nations.add("俄罗斯族");
        nations.add("崩龙族");
        nations.add("俄罗斯族");
        nations.add("保安族");
        nations.add("裕固族");
        nations.add("京族");
        nations.add("塔塔尔族");
        nations.add("独龙族");
        nations.add("鄂伦春族");
        nations.add("赫哲族");
        nations.add("门巴族");
        nations.add("珞巴族");
        nations.add("基诺族");
    }

    private boolean nationVerify(String nation) {
        return nations.contains(nation);
    }
}
