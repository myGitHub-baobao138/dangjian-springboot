package com.partybuilding.webserver.controller.system;

import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.system.structure.*;
import com.partybuilding.webserver.service.system.SysOrganizationalStructureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;

/**
 * 组织架构
 */
@RestController
@CrossOrigin
@RequestMapping("/System/OrganizationalStructureController")
@Api("组织架构api")
public class SysOrganizationalStructureController {
    @Autowired
    SysOrganizationalStructureService structureService;
    @PostMapping("/addStructure")
    @ApiOperation("添加组织架构")
    @RequiresPermissions("/System/OrganizationalStructureController/**")
    public JsonResult addStructure(@RequestBody AddStructureDto addStructureDto){
        JsonResult jsonResult = new JsonResult();
        jsonResult = structureService.insertSelective(addStructureDto);
//        if(success>=1){
//            jsonResult.setMessage("success");
//            jsonResult.setData("1");
//
//        }else {
//            jsonResult.setMessage("fail");
//            jsonResult.setData("1");
//        }
        return jsonResult;
    }

    @GetMapping("/searchStructure")
    @ApiOperation("查找组织架构")
    @RequiresPermissions("/System/OrganizationalStructureController/**")
    public JsonResult searchAllStructure(@RequestParam Integer rank) {
        JsonResult jsonResult = new JsonResult();
        List<SearchStructureDto> structureDtoList = structureService.searchAllStructure(rank);
        jsonResult.setData(structureDtoList);
        return jsonResult;
    }
    @PostMapping("/searchByRankAndPostId")
    @ApiOperation("/根据等级以及组织名称查询组织架构数据")
    @RequiresPermissions("/System/OrganizationalStructureController/**")
    public JsonResult searchByRankAndPostId(@RequestBody RankAndOrganization rankAndOrganization){
        JsonResult jsonResult = new JsonResult();
        jsonResult=structureService.searchByRankAndPostId(rankAndOrganization);
        return jsonResult;
    }
//    @PostMapping("/searchByRank")
//    @ApiOperation("/根据等级查询组织架构数据")
//    public JsonResult searchByRank(@RequestBody SearchStructureByRank searchStructureByRank){
//        JsonResult jsonResult = new JsonResult();
//        jsonResult = structureService.searchByRank(searchStructureByRank);
//        return jsonResult;
//    }

//    @PostMapping("/searchByPostName")
//    @ApiOperation("/根据组织名称查询组织架构数据")
//    public JsonResult searchByPostName(@RequestBody SearchStructureByPostName postName){
//        JsonResult jsonResult = new JsonResult();
//        jsonResult = structureService.searchByPostName(postName);
//        return jsonResult;
//    }

    @GetMapping("/SearchOrgNameAndId")
    @ApiOperation("/查询所有的组织与组织id")
    @RequiresPermissions("/System/OrganizationalStructureController/**")
    public JsonResult SearchOrgNameAndId(){
        JsonResult jsonResult = structureService.SearchOrgNameAndId();
        return jsonResult;
    }

    @GetMapping("/SearchSingleOrgNameAndId")
    @ApiOperation("/查询对应组织等级下面的组织")
    @RequiresPermissions("/System/OrganizationalStructureController/**")
    public JsonResult SearchSingleOrgNameAndId(@RequestParam String organizationId,@RequestParam Integer rank){
        JsonResult jsonResult=  new JsonResult();
        if(rank==1){
            jsonResult = SearchOrgNameAndId();
        }else {
            jsonResult = structureService.SearchSingleOrgNameAndId(organizationId);
        }
        return jsonResult;
    }
    @PostMapping("/selectHigherOrgAndRank")
    @ApiOperation("/查询当前等级的上级组织id以及名称")
    @RequiresPermissions("/System/OrganizationalStructureController/**")
    public JsonResult selectHigherOrgAndRank(@RequestBody HigherOrgAndRank higherOrgAndRank){
        JsonResult jsonResult = structureService.selectHigherOrgAndRank(higherOrgAndRank);
        return jsonResult;
    }
    @GetMapping("/selectStructureParty")
    @ApiOperation("/查询当前组织的组织名称以及下级的组织名称和id")
    @RequiresPermissions("/System/OrganizationalStructureController/**")
    public JsonResult selectStructureParty(@RequestParam Integer rank,@RequestParam String organizationId){
        JsonResult jsonResult = structureService.selectStructureParty(rank,organizationId);
        return jsonResult;
    }
    @PostMapping("/updateInfo")
    @ApiOperation("/修改当前组织下的名称或者说明")
    @RequiresPermissions("/System/OrganizationalStructureController/**")
    public JsonResult updateInfo(@RequestBody UpdateNameAndRemarkDto updateNameAndRemarkDto){
        JsonResult jsonResult = structureService.updateInfo(updateNameAndRemarkDto);
        return jsonResult;
    }
    @GetMapping("/deleteInfo")
    @ApiOperation("/删除当前组织以及下级组织，只能删除没有人的组织")
    @RequiresPermissions("/System/OrganizationalStructureController/**")
    public JsonResult deleteInfo(@RequestParam String organizationId){
        JsonResult jsonResult = structureService.deleteByPrimaryKey(organizationId);
        return jsonResult;
    }
}
