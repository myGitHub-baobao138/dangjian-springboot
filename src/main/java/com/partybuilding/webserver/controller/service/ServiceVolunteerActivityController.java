package com.partybuilding.webserver.controller.service;

import com.partybuilding.webserver.dto.service.volunteer.*;
import com.partybuilding.webserver.service.service.ServiceVolunteerActivityService;
import com.partybuilding.webserver.util.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * 志愿活动Controller
 * @author 包嵩 2019-11-06
 */
@RequestMapping("/Service/VolunteerActivityController")
@CrossOrigin
@RestController
@Api
public class ServiceVolunteerActivityController {
    @Autowired
    private ServiceVolunteerActivityService serviceVolunteerActivityService;


    @PostMapping("examine")
    @RequiresPermissions("/Service/VolunteerActivityController/**")
    public JSONResult examine(@RequestBody ExamineDTO dto){
//        System.out.println(dto.getId()[0]);
        JSONResult jsonResult = new JSONResult();
        String[] id = dto.getId();
        String approvalState = dto.getApprovalState();
        Date date = new Date();
        if (serviceVolunteerActivityService.examine(id,approvalState,date)==1){
            jsonResult.setData(true);
            jsonResult.setMessage("修改成功");
        }else {
            jsonResult.setData(false);
            jsonResult.setMessage("修改失败");
        }
        return jsonResult;
    }

    /**
     * author 包嵩
     * 通过关键字查询活动信息
     * @param dto
     * @return
     */
    @GetMapping("keywordSearchVolunteer")
    @RequiresPermissions("/Service/VolunteerActivityController/**")
    public JSONResult keywordSearchVolunteer(KeywordSearchVolunteerDTO dto){
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(serviceVolunteerActivityService.keywordSearchVolunteer(dto));
        if (jsonResult.getData()!=null){
            jsonResult.setMessage("查询成功");
        }else {
            jsonResult.setMessage("查询失败");
        }
        return jsonResult;
    }

    /**
     * 查询志愿活动显示到活动表格里
     * author:包嵩
     * @return
     */
    @ApiOperation(value = "查看志愿活动",notes = "查看志愿活动")
    @GetMapping("selectVolunteerActivity")
    @RequiresPermissions("/Service/VolunteerActivityController/**")
    public JSONResult selectVolunteerActivity(){
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(serviceVolunteerActivityService.selectVolunteer());
        if (jsonResult.getData()!=null){
            jsonResult.setMessage("查找成功");
        }else {
            jsonResult.setMessage("查找失败");
        }
        return jsonResult;
    }

    /**
     * author：包嵩
     * 分页查询活动
     * @param dto
     * @return
     */
    @ApiOperation(value = "分页查询",notes = "分页查询")
    @GetMapping("getActivityByPage")
    @RequiresPermissions("/Service/VolunteerActivityController/**")
    public JSONResult getActivityByPage(GetActivityByPageDTO dto){
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(serviceVolunteerActivityService.getActivityByPage(dto));
        if (jsonResult.getData()!=null){
            jsonResult.setMessage("查找成功");
        }else {
            jsonResult.setMessage("查询失败");
        }
        return jsonResult;
    }

    /**
     * author：包嵩
     * 获取活动总条数
     * @return
     */
    @ApiOperation(value = "获取总条数",notes = "获取总条数")
    @GetMapping("getTotalPage")
    @RequiresPermissions("/Service/VolunteerActivityController/**")
    public JSONResult getTotalPage(GetActivityByPageDTO record){
        JSONResult jsonResult = new JSONResult();
//        System.out.println("根据状态条件的总条数:" + record.getActivityState());
//        System.out.println("标题："+record.getTitle());
        jsonResult.setData(serviceVolunteerActivityService.getTotalPage(record));
        if (jsonResult.getData()!=null){
            jsonResult.setMessage("查找成功");
        }
        else {
            jsonResult.setMessage("查找失败");
        }
        return jsonResult;
    }


    /**
     * 查看活动报名信息,通过页数
     * @return
     */
    @ApiOperation(value = "查看活动报名信息",notes = "查看活动报名信息")
    @GetMapping("/selectActivityRegistration")
    @RequiresPermissions("/Service/VolunteerActivityController/**")
    public JSONResult selectActivityRegistration(GetActivityByPageDTO dto){
        System.out.println(dto.getActivityState()+"  "+dto.getBeginTime()+"  "+dto.getTitle());
        JSONResult jsonResult = new JSONResult();
        jsonResult.setData(serviceVolunteerActivityService.selectActivityRegistration(dto));
        return jsonResult;
    }

    @PostMapping("/updateByPrimaryKeySelective")
    @RequiresPermissions("/Service/VolunteerActivityController/**")
    public JSONResult updateByPrimaryKeySelective(@RequestBody ActivityRegistrationDTO record){
        System.out.println("id: "+record.getId());
        JSONResult jsonResult = new JSONResult();
        if(serviceVolunteerActivityService.updateByPrimaryKeySelective(record)==1){
            jsonResult.setMessage("修改志愿活动成功");
        }else {
            jsonResult.setMessage("修改志愿活动失败");
        }
        return jsonResult;
    }

    /**
     * 通过活动id删除活动
     * author 包嵩
     * @param activityId
     * @return
     */
    @GetMapping("/deleteActivityById")
    @RequiresPermissions("/Service/VolunteerActivityController/**")
    public JSONResult deleteActivityById(@RequestParam String activityId,@RequestParam String imageUrl) throws FileNotFoundException {
//        System.out.println("delete id: "+ activityId);
        if (imageUrl.contains("/images")){
            String imagePath = ResourceUtils.getURL("").getPath()+"src/main/resources/static";
            String picName = imageUrl.substring(imageUrl.indexOf("/images"));
            File file = new File(imagePath+picName);
            file.delete();
        }
        JSONResult jsonResult = new JSONResult();
        if (serviceVolunteerActivityService.deleteActivityById(activityId)==1){
            jsonResult.setData(true);
            jsonResult.setMessage("删除成功");
        }else {
            jsonResult.setData(false);
            jsonResult.setMessage("删除失败");
        }
        return jsonResult;
    }

    /**
     * 通过活动id修改活动状态
     * author 包嵩
     * @param activityId
     * @return
     */
    @GetMapping("/updateActivityState")
    @RequiresPermissions("/Service/VolunteerActivityController/**")
    public  JSONResult updateActivityState(@RequestParam String activityId){
        JSONResult jsonResult = new JSONResult();
        if (serviceVolunteerActivityService.updateActivityState(activityId)==1){
            jsonResult.setData(true);
            jsonResult.setMessage("修改成功");
        }else {
            jsonResult.setData(false);
            jsonResult.setMessage("修改失败");
        }
        return jsonResult;
    }























//    /**
//     * 新增志愿活动 addVolunteerActivity
//     * @param serviceAddVolunteerActivityDTO
//     * @return
//     */
//    @ApiOperation(value = "新增志愿活动",notes = "新增志愿活动")
//    @RequestMapping(value = "/addVolunteerActivity",method = RequestMethod.POST)
//    public JSONResult addVolunteerActivity(@RequestBody ServiceAddVolunteerActivityDTO serviceAddVolunteerActivityDTO){
//        JSONResult jsonResult = new JSONResult();
//        String id = UUID.randomUUID().toString();
//        serviceAddVolunteerActivityDTO.setId(id.replaceAll("-",""));
//        boolean success = serviceVolunteerActivityService.addVolunteerActivity(serviceAddVolunteerActivityDTO);
//        if(success){
//            jsonResult.setMessage("success");
//        }
//        else{
//            jsonResult.setMessage("false");
//        }
//        return jsonResult;
//    }
//
//    /**
//     * 发布志愿活动 releaseActivity
//     * @param serviceReleaseActivityDTO
//     * @return
//     */
//    @ApiOperation(value = "发布志愿活动",notes = "发布志愿活动")
//    @RequestMapping(value = "/releaseActivity",method = RequestMethod.POST)
//    public JSONResult releaseActivity(@RequestBody ServiceReleaseActivityDTO serviceReleaseActivityDTO){
//        JSONResult jsonResult = new JSONResult();
//        //接收到的id是以逗号分隔的字符串
//        String[] id = serviceReleaseActivityDTO.getId().split(",");
//        boolean[] success = new boolean[id.length];
//        //判断是否有发布失败的活动
//        List<String> error = new ArrayList<>();
//        for (int i = 0; i < id.length; i++){
//            //添加发布时间，改变活动状态为报名中
//            success[i] = serviceVolunteerActivityService.releaseActivity(id[i],serviceReleaseActivityDTO.getReleaseTime());
//            if(!success[i]){
//                error.add(id[i]);
//            }
//        }
//        if(error.size() == 0){
//            jsonResult.setMessage("success");
//        }
//        else{
//            jsonResult.setMessage("false");
//            //返回错误的志愿活动id
//            jsonResult.setData(error);
//            jsonResult.setTotalCount(error.size());
//            jsonResult.setMessage("已超过活动报名截止时间，请修改活动时间");
//        }
//        return jsonResult;
//    }
//
//    /**
//     * 查询志愿活动列表
//     * @param serviceBaseDTO
//     * @return
//     */
//    @ApiOperation(value = "查询志愿活动列表",notes = "查询志愿活动列表")
//    @RequestMapping(value = "/getVolunteerActivityList",method = RequestMethod.POST)
//    public JSONResult getVolunteerActivityList(@RequestBody ServiceBaseDTO serviceBaseDTO){
//        JSONResult jsonResult = new JSONResult();
//        PageResult<SignUpActivityInformationDTO> list = serviceVolunteerActivityService.getVolunteerActivityList(serviceBaseDTO);
//        jsonResult.setData(list);
//        if(list != null){
//            jsonResult.setMessage("success");
//        }
//        else{
//            jsonResult.setMessage("false");
//        }
//        return jsonResult;
//    }
//
//    /**
//     * 根据id查看志愿活动
//     * @param id
//     * @return
//     */
//    @ApiOperation(value = "查看志愿活动",notes = "查看志愿活动")
//    @RequestMapping(value = "/searchVolunteerActivity",method = RequestMethod.GET)
//    public JSONResult searchVolunteerActivity(@RequestParam String id){
//        JSONResult jsonResult = new JSONResult();
//        ActivityInformationDTO activityInformationDTO = BeanMapper.map(serviceVolunteerActivityService.searchVolunteerActivity(id),ActivityInformationDTO.class);
//        if(activityInformationDTO == null){
//            jsonResult.setMessage("false");
//        }
//        else{
//            jsonResult.setMessage("success");
//            jsonResult.setData(activityInformationDTO);
//        }
//        return jsonResult;
//    }
//
//    /**
//     * 根据id删除志愿活动
//     * @param id
//     * @return
//     */
//    @ApiOperation(value = "根据id删除志愿活动",notes = "根据id删除志愿活动")
//    @RequestMapping(value = "/deleteVolunteerActivityById",method = RequestMethod.POST)
//    public JSONResult deleteVolunteerActivityById(@RequestParam String id){
//        JSONResult jsonResult = new JSONResult();
//        //得到每一个id
//        String[] ids = id.split(",");
//        boolean[] success = new boolean[ids.length];
//        List<String> err = new ArrayList<>();
//        for(int i = 0; i < ids.length;i++){
//            success[i] = serviceVolunteerActivityService.deleteVolunteerActivityById(ids[i]);
//            //删除不成功时：
//            if(!success[i]){
//                err.add(ids[i]);
//            }
//        }
//        if(err.size() == 0){
//            jsonResult.setMessage("success");
//        }
//        else{
//            jsonResult.setMessage("存在删除失败的志愿活动");
//            jsonResult.setData(err);
//        }
//        return jsonResult;
//    }
//
//    /**
//     * 根据id修改志愿活动
//     * @param serviceEditVolunteerActivityDTO
//     * @return
//     */
//    @ApiOperation(value = "修改志愿活动",notes = "修改志愿活动")
//    @RequestMapping(value = "/editVolunteerActivity",method = RequestMethod.POST)
//    public JSONResult editVolunteerActivity(@RequestBody ServiceEditVolunteerActivityDTO serviceEditVolunteerActivityDTO){
//        JSONResult jsonResult = new JSONResult();
//        boolean success = serviceVolunteerActivityService.editVolunteerActivity(serviceEditVolunteerActivityDTO);
//        if(success){
//            jsonResult.setMessage("success");
//        }
//        else{
//            jsonResult.setMessage("false");
//        }
//        return jsonResult;
//    }
//
//    /**
//     * 根据状态查询活动
//     * @param serviceSearchActivityDTO
//     * @return
//     */
//    @ApiOperation(value = "根据状态查询活动",notes = "根据活动状态查询")
//    @RequestMapping(value = "/searchActivityByActivityState",method = RequestMethod.POST)
//    public JSONResult searchActivityByActivityState(@RequestBody ServiceSearchActivityDTO serviceSearchActivityDTO){
//        JSONResult jsonResult = new JSONResult();
//        PageResult<ServiceVolunteerActivity> list = serviceVolunteerActivityService.searchActivityByActivityState(serviceSearchActivityDTO);
//        if(list == null){
//            jsonResult.setMessage("不存在这个状态的活动");
//        }
//        else{
//            jsonResult.setMessage("success");
//            jsonResult.setData(list);
//        }
//        return jsonResult;
//    }
//
//    /**
//     * 根据内容查询活动
//     * @param serviceSearchActivityDTO
//     * @return
//     */
//    @ApiOperation(value = "根据内容查询活动",notes = "根据内容查询活动")
//    @RequestMapping(value = "/searchActivityByActivityContent",method = RequestMethod.POST)
//    public JSONResult searchActivityByActivityContent(@RequestBody ServiceSearchActivityDTO serviceSearchActivityDTO){
//        JSONResult jsonResult = new JSONResult();
//        PageResult<ServiceVolunteerActivity> list = serviceVolunteerActivityService.searchActivityByActivityContent(serviceSearchActivityDTO);
//        if(list == null){
//            jsonResult.setMessage("不存在这个内容的活动");
//        }
//        else{
//            jsonResult.setMessage("success");
//            jsonResult.setData(list);
//        }
//        return jsonResult;
//    }
//
//    /**
//     * 审核志愿活动
//     * @param serviceReviewVolunteerActivityDTO
//     * @return
//     */
//    @ApiOperation(value = "审核志愿活动",notes = "审核志愿活动")
//    @RequestMapping(value = "/reviewVolunteerActivity",method = RequestMethod.POST)
//    public JSONResult reviewVolunteerActivity(@RequestBody ServiceReviewVolunteerActivityDTO serviceReviewVolunteerActivityDTO){
//        JSONResult jsonResult = new JSONResult();
//        boolean  success = serviceVolunteerActivityService.reviewVolunteerActivity(serviceReviewVolunteerActivityDTO);
//        jsonResult.setData(serviceReviewVolunteerActivityDTO.getResult());
//        if(success){
//            jsonResult.setMessage("success");
//        }
//        else {
//            jsonResult.setMessage("false");
//        }
//        return jsonResult;
//    }
//
//    /**
//     * 获取活动审核列表
//     * @param serviceBaseDTO
//     * @return
//     */
//    @ApiOperation(value = "获取活动审核列表",notes = "获取活动审核列表")
//    @RequestMapping(value = "/getReviewActivityList",method = RequestMethod.POST)
//    public JSONResult getReviewActivityList(@RequestBody ServiceBaseDTO serviceBaseDTO){
//        JSONResult jsonResult = new JSONResult();
//        PageResult<ReviewActivityDTO> list = serviceVolunteerActivityService.getReviewActivityList(serviceBaseDTO);
//        List<ReviewActivityDTO> list1 = new ArrayList<>();
//
//        for(ReviewActivityDTO reviewActivityDTO:list.getList()){
//            list1.add(BeanMapper.map(reviewActivityDTO,ReviewActivityDTO.class));
//        }
//        if(list1 != null){
//            jsonResult.setMessage("success");
//            jsonResult.setData(list1);
//            jsonResult.setTotalCount(list1.size());
//        }
//        else{
//            jsonResult.setMessage("false");
//        }
//        return jsonResult;
//    }








}
