package com.partybuilding.webserver.serviceImpl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.system.SysOrganizationalStructureMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.structure.*;
import com.partybuilding.webserver.entity.system.SysOrganizationalStructure;
import com.partybuilding.webserver.service.system.SysOrganizationalStructureService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class SysOrganizationalStructureServiceImpl implements SysOrganizationalStructureService {
    @Autowired
    SysOrganizationalStructureMapper structureMapper;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public JsonResult deleteByPrimaryKey(String organizationalId) {
        JsonResult jsonResult = new JsonResult();
        List<OrganizationIdAndNumber> organizationIdAndNumber = structureMapper.isDelete(organizationalId);
        if (organizationIdAndNumber == null || organizationIdAndNumber.size() == 0) {
            int success = structureMapper.deleteByPrimaryKey(organizationalId);
            if (success > 0) {
                jsonResult.setCode(200);
                jsonResult.setMessage("删除成功!");
                return jsonResult;
            } else {
                jsonResult.setCode(500);
                jsonResult.setMessage("删除失败，请稍后重试！");
                return jsonResult;
            }
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("删除失败，该组织下面有其他组织!");
            return jsonResult;
        }
    }

    @Override
    public int insert(SysOrganizationalStructure record) {
        return 0;
    }

    /**
     * 新建一个组织
     *
     * @param record
     * @return
     */
    @Override
    public JsonResult insertSelective(AddStructureDto record) {
        SysOrganizationalStructure sysOrganizationalStructure = new SysOrganizationalStructure();
        sysOrganizationalStructure = modelMapper.map(record, SysOrganizationalStructure.class);
        NameAndHigherId nameAndHigherId = new NameAndHigherId();
        nameAndHigherId.setOrganizationName(sysOrganizationalStructure.getOrganizationName());
        nameAndHigherId.setHigherOrganizationId(sysOrganizationalStructure.getHigherOrganizationId());
        String organizationId = structureMapper.repeatOrganization(nameAndHigherId);
        JsonResult jsonResult = new JsonResult();
        if (organizationId != null) {
            jsonResult.setMessage("不能新建重复的组织名称");
            jsonResult.setCode(500);
        } else {
            sysOrganizationalStructure.setOrganizationId(Uuid.getUuid());
            int success = structureMapper.insert(sysOrganizationalStructure);
            if (success > 0) {
                jsonResult.setCode(200);
                jsonResult.setMessage("添加成功！");
            }
        }

        return jsonResult;
    }

    @Override
    public SysOrganizationalStructure selectByPrimaryKey(String organizationalId) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(SysOrganizationalStructure record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(SysOrganizationalStructure record) {
        return 0;
    }

    /**
     * 不能分页
     *
     * @return
     */
    @Override
    public List<SearchStructureDto> searchAllStructure(Integer rank) {
        PageHelper.startPage(1, 2);
        List<SearchStructureDto> structureDtoList = structureMapper.searchAllStructure(rank);
        PageResult<SearchStructureDto> result = getPageResult(structureDtoList);
        return result.getList();
    }

    @Override
    public JsonResult searchByRankAndPostId(RankAndOrganization rankAndOrganization) {
        PageHelper.startPage(rankAndOrganization.getCurrentPage(), rankAndOrganization.getPageSize());
        List<SearchStructureDto> structureDtoList = structureMapper.searchByRankAndPostId(rankAndOrganization);
        PageResult<SearchStructureDto> result = getPageResult(structureDtoList);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(result);
        jsonResult.setMessage("查询成功");
        return jsonResult;
    }

    @Override
    public JsonResult searchByPostName(SearchStructureByPostName searchStructureByPostName) {
        PageHelper.startPage(searchStructureByPostName.getCurrentPage(), searchStructureByPostName.getPageSize());
        List<SearchStructureDto> structureDtoList = structureMapper.searchByPostName(searchStructureByPostName.getPostName());
        PageResult<SearchStructureDto> result = getPageResult(structureDtoList);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(result);
        jsonResult.setMessage("查询成功");
        return jsonResult;
    }

    @Override
    public JsonResult searchByRank(SearchStructureByRank searchStructureByRank) {
        PageHelper.startPage(searchStructureByRank.getCurrentPage(), searchStructureByRank.getPageSize());
        List<SearchStructureDto> structureDtoList = structureMapper.searchByRank(searchStructureByRank.getRank());
        PageResult<SearchStructureDto> result = getPageResult(structureDtoList);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(result);
        jsonResult.setMessage("查询成功");
        return jsonResult;
    }

    /**
     * 查找所有的组织与组织id
     *
     * @return
     */
    @Override
    public JsonResult SearchOrgNameAndId() {
        List<OrganizationNameAndIdDto> list = structureMapper.SearchOrgNameAndId();
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(list);

        return jsonResult;
    }

    /**
     * 查找对应组织下面的组织以及自己的组织名称和id
     *
     * @param organizationId
     * @return
     */
    @Override
    public JsonResult SearchSingleOrgNameAndId(String organizationId) {
        List<OrganizationNameAndIdDto> list = structureMapper.SearchSingleOrgNameAndId(organizationId);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(list);
        return jsonResult;
    }

    @Override
    public JsonResult selectHigherOrgAndRank(HigherOrgAndRank higherOrgAndRank) {
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(structureMapper.selectHigherOrgAndRank(higherOrgAndRank));
        return jsonResult;
    }

    @Override
    public JsonResult selectStructureParty(Integer rank, String organizationId) {
        List<OrganizationNameAndIdDto> list = structureMapper.selectStructureParty(rank, organizationId);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(list);
        return jsonResult;
    }

    @Override
    public JsonResult updateInfo(UpdateNameAndRemarkDto updateNameAndRemarkDto) {
        int success = structureMapper.updateInfo(updateNameAndRemarkDto);
        JsonResult jsonResult = new JsonResult();
        if (success > 0) {
            jsonResult.setCode(200);
            jsonResult.setMessage("修改成功");
        } else {
            jsonResult.setCode(500);
            jsonResult.setMessage("修改失败，请稍后重试！");
        }
        return jsonResult;
    }

    public PageResult<SearchStructureDto> getPageResult(List<SearchStructureDto> structureDtoList) {
        PageInfo<SearchStructureDto> pageInfo = new PageInfo<SearchStructureDto>(structureDtoList);
        // 封装需要返回的分页实体
        PageResult<SearchStructureDto> result = new PageResult<SearchStructureDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(pageInfo.getList());
        return result;
    }


}
