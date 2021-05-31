package com.partybuilding.webserver.serviceImpl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.system.SysRightMapper;
import com.partybuilding.webserver.dto.role.RouterRoleDTO;
import com.partybuilding.webserver.dto.role.UserRoleDTO;
import com.partybuilding.webserver.dto.system.right.DeleteRightRoleAndResourceDTO;
import com.partybuilding.webserver.dto.system.right.FindRightBaseInfoDTO;
import com.partybuilding.webserver.dto.system.right.FindRightBaseInfoPageInfo;
import com.partybuilding.webserver.dto.system.right.allocateRight.AllocateRightRequest;
import com.partybuilding.webserver.dto.system.right.createRight.*;
import com.partybuilding.webserver.dto.system.right.showRight.ResourceColumn;
import com.partybuilding.webserver.dto.system.right.showRight.ResourcePlate;
import com.partybuilding.webserver.dto.system.right.showRight.RightListDto;
import com.partybuilding.webserver.service.system.SysRightService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SysRightServiceImpl implements SysRightService {
    @Autowired
    SysRightMapper sysRightMapper;

    /**
     * 加载用户角色权限
     *
     * @param dto
     * @return
     */
    @Override
    public List<RouterRoleDTO> findUserRight(UserRoleDTO dto) {
        return sysRightMapper.findUserRight(dto);
    }

    /**
     * 查询权限基本信息
     *
     * @param dto
     * @return
     */
    @Override
    public PageResult findRightBaseInfo(FindRightBaseInfoPageInfo dto) {
        //  判断参数是否有误
        if (dto.getCurrentPage() <= 0) {
            dto.setCurrentPage(1);  //设置默认当前页
        }
        if (dto.getPageSize() <= 0) {
            dto.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        List<FindRightBaseInfoDTO> list;
        list = sysRightMapper.findRightBaseInfo(dto);
        // 获取分页查询后的数据
        PageInfo<FindRightBaseInfoDTO> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<FindRightBaseInfoDTO> result = new PageResult<FindRightBaseInfoDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    /**
     * 删除权限角色及资源
     *
     * @param dto
     * @return
     */
    @Override
    public int deleteRightRoleAndResource(DeleteRightRoleAndResourceDTO dto) {
        return sysRightMapper.deleteRightRoleAndResource(dto);
    }

    /**
     * 创建权限
     *
     * @param dto
     * @return
     */
    @Override
    public int createRightInfo(CreateRightRequest dto) {
        dto.setRoleId(UUID.randomUUID().toString().replaceAll("-", ""));
        dto.setCreateTime(new Date());

        // 新增角色
        FindOrganizationAndPostIsExist findOrganizationAndPostIsExist = new FindOrganizationAndPostIsExist();
        findOrganizationAndPostIsExist.setOrganizationId(dto.getOrganizationId());
        findOrganizationAndPostIsExist.setPostId(dto.getPostId());
        // 角色已经存在，创建失败，提示可重新分配权限
        if (sysRightMapper.findRoleIsExist(findOrganizationAndPostIsExist).size() > 0) {
            return 400;
        } else { // 创建角色及其权限
            int result1 = sysRightMapper.addRole(dto);
            return result1;
        }
    }

    /**
     * 查询组织及其下面的职务
     *
     * @return
     */
    @Override
    public List<OrganizationAndPostDTO> organizationAndPost(OrganizationAndPostRequestDTO dto) {
        return sysRightMapper.organizationAndPost(dto);
    }

    /**
     * 查询角色已有权限
     *
     * @param dto
     * @return
     */
    @Override
    public RightListDto findRightList(FindOrganizationAndPostIsExist dto) {
        List<ResourceColumn> resourceColumnList = sysRightMapper.findRightList(dto);
        List<Object> hasRights = new ArrayList<>();
        for (ResourceColumn resourceColumn : resourceColumnList) {
            List<ResourcePlate> resourcePlateList = resourceColumn.getChildren();
            for (ResourcePlate resourcePlate : resourcePlateList) {
                resourcePlate.setId(resourceColumn.getId() + "-" + resourcePlate.getId());
                if ("1".equals(resourcePlate.getHasPermission())) {
                    hasRights.add(resourcePlate.getId());
                }
            }
        }

        RightListDto rightListDto = new RightListDto();
        rightListDto.setRightsList(resourceColumnList);
        rightListDto.setHasRights(hasRights);
        return rightListDto;
    }

    /**
     * 分配角色权限
     *
     * @param dto
     * @return
     */
    @Override
    public int allocateRoleRight(AllocateRightRequest dto) {
        String rightInfo = (String) dto.getRightInfo();
        List<RightsDTO> rightsDTOList = new ArrayList<>();
        if(rightInfo!=null&&!"".equals(rightInfo)) {
            String[] ids = rightInfo.split(",");
            for (String id : ids) {
                if (id.contains("-")) {
                    String[] tIds = id.split("-");
                    RightsDTO rightListDto = new RightsDTO(tIds[0], tIds[1]);
                    rightsDTOList.add(rightListDto);
                }
            }
        }
        dto.setRightsDTOList(rightsDTOList);
        dto.setRoleId(sysRightMapper.findRoleId(new FindOrganizationAndPostIsExist(dto.getOrganizationId(), dto.getPostId())));
        sysRightMapper.deleteRoleRight(dto);
        return sysRightMapper.allocateRoleRight(dto) > 0 ? 1 : 0;
    }
}
