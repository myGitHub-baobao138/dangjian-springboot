package com.partybuilding.webserver.controller.service;

import com.partybuilding.webserver.dao.service.ServiceVoteOptionMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.service.voteDto.AddVoteDto;
import com.partybuilding.webserver.dto.service.voteDto.SelectByTitleOrTimeOrStatusDto;
import com.partybuilding.webserver.dto.service.voteDto.ServiceVoteDto;
import com.partybuilding.webserver.dto.service.voteDto.ServiceVoteSelectByTitleDto;
import com.partybuilding.webserver.service.service.ServiceVoteOptionService;
import com.partybuilding.webserver.service.service.ServiceVoteService;
import com.partybuilding.webserver.util.PageResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 投票调查controller
 *
 */
@RestController
@RequestMapping("/Service/VoteController")
@CrossOrigin
@Api(value = "ServiceVoteController投票调查")

public class ServiceVoteController {
    @Autowired
    ServiceVoteService serviceVoteService;

    @Autowired
    ServiceVoteOptionService optionService;

    /**
     * 新增投票记录
     * @param addVoteDto
     * @return
     * @throws ParseException
     */
    @PostMapping("/insertVote")
    @ApiOperation(value = "添加投票记录")
    @RequiresPermissions("/Service/VoteController/**")
    public JsonResult insertVote(@Validated @RequestBody AddVoteDto addVoteDto) throws ParseException {
        JsonResult jsonResult = new JsonResult();
        jsonResult = serviceVoteService.insertSelective(addVoteDto);
        return jsonResult;
    }

//    /**
//     * 以投票标题查询数据
//     * @param serviceVoteSelectByTitleDto
//     * @return
//     */
//    @PostMapping("/selectVoteByTitle")
//    public JsonResult selectVoteByTitle(@Validated @RequestBody ServiceVoteSelectByTitleDto serviceVoteSelectByTitleDto) throws IOException, ClassNotFoundException {
//        JsonResult jsonResult = new JsonResult();
//        //返回全部的投票信息数据
//        jsonResult = serviceVoteService.selectByTitle(serviceVoteSelectByTitleDto);
//        return jsonResult;
//    }

//    /**
//     * 根据投票活动的状态查找投票列表
//     * @param status
//     * @param pageInputDTO
//     * @return
//     */
//    @GetMapping("/selectVoteByStatus")
//    public JsonResult selectVoteByStatus(@RequestParam Integer status, @ModelAttribute PageInputDTO pageInputDTO){
//        JsonResult jsonResult = new JsonResult();
//        jsonResult = serviceVoteService.selectVoteByStatus(status,pageInputDTO);
//        return jsonResult;
//    }

    /**
     *
     * @return
     */
//    @GetMapping("/selectVoteByBeginTime")
//    public JsonResult selectVoteByBeginTime(@RequestParam String beginTime,@ModelAttribute PageInputDTO pageInputDTO){
//        JsonResult jsonResult = new JsonResult();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
//        PageResult<ServiceVoteDto> serviceVoteDto = null;
//        try {
//            serviceVoteDto = serviceVoteService.selectVoteByBeginTime(simpleDateFormat.parse(beginTime),pageInputDTO);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        jsonResult.setData(serviceVoteDto);
//        return jsonResult;
//    }
//    @GetMapping("/selectVoteByBeginAndEndTime")
//    public JsonResult selectVoteByBeginAndEndTime(@ModelAttribute PageInputDTO pageInputDTO){
//        JsonResult jsonResult = new JsonResult();
//        return jsonResult;
//    }
//    @GetMapping("/deleteById")
//    public JsonResult deleteById(@RequestParam String id){
//        JsonResult jsonResult = new JsonResult();
//        int success = serviceVoteService.deleteByPrimaryKey(id);
//        if(success>0){
//            jsonResult.setMessage("success");
//        }else {
//            jsonResult.setMessage("fail");
//            jsonResult.setCode(500);
//        }
//        return jsonResult;
//    }
    @ApiOperation("根据条件查询数据")
    @PostMapping("/selectByTitleAndTimeAndStatus")
    @RequiresPermissions("/Service/VoteController/**")
    public JsonResult selectByTitleAndTimeAndStatus(@RequestBody SelectByTitleOrTimeOrStatusDto selectByTitleOrTimeOrStatusDto){
        JsonResult jsonResult = serviceVoteService.selectByTitleAndTimeAndStatus(selectByTitleOrTimeOrStatusDto);
        return jsonResult;
    }
    @ApiOperation("修改投票调查信息")
    @PostMapping("/updateVote")
    @RequiresPermissions("/Service/VoteController/**")
    public JsonResult updateByPrimaryKeySelective(@RequestBody AddVoteDto addVoteDto){
        JsonResult jsonResult = serviceVoteService.updateByPrimaryKeySelective(addVoteDto);
        return jsonResult;
    }
    @ApiOperation("删除投票调查的选项")
    @GetMapping("/deleteOption")
    @RequiresPermissions("/Service/VoteController/**")
    public JsonResult  deleteOption(@RequestParam String voteId){
        JsonResult jsonResult = optionService.deleteOption(voteId);
        return jsonResult;
    }
}
