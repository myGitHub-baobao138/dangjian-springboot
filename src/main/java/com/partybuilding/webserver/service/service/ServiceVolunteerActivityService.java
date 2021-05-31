package com.partybuilding.webserver.service.service;

import com.partybuilding.webserver.dto.service.volunteer.*;
import com.partybuilding.webserver.entity.service.ServiceVolunteerActivity;
import com.partybuilding.webserver.util.PageResult;

import java.util.Date;
import java.util.List;

/**
 */
public interface ServiceVolunteerActivityService {
    /**
     * 新增志愿活动
     * @param serviceAddVolunteerActivityDTO
     * @return
     */
    boolean addVolunteerActivity(ServiceAddVolunteerActivityDTO serviceAddVolunteerActivityDTO);

    /**
     * 发布志愿活动
     * @param id
     * @param releaseTime
     * @return
     */
    boolean releaseActivity(String id,Date releaseTime);

    /**
     * 根据id查看志愿活动
     * @param id
     * @return
     */
    ActivityInformationDTO searchVolunteerActivity(String id);

    /**
     * 获取活动列表
     * @param serviceBaseDTO
     * @return
     */
    PageResult<SignUpActivityInformationDTO> getVolunteerActivityList(ServiceBaseDTO serviceBaseDTO);

    /**
     * 得到活动总数
     * @return
     */
    Integer getActivityCount();

    /**
     * 根据id删除志愿活动
     * @param id
     * @return
     */
    boolean deleteVolunteerActivityById(String id);

    /**
     * 根据id修改志愿活动
     * @param serviceEditVolunteerActivityDTO
     * @return
     */
    boolean editVolunteerActivity(ServiceEditVolunteerActivityDTO serviceEditVolunteerActivityDTO);

    /**
     * 根据活动状态查询志愿活动
     * @param serviceSearchActivityDTO
     * @return
     */
    PageResult<ServiceVolunteerActivity> searchActivityByActivityState(ServiceSearchActivityDTO serviceSearchActivityDTO);

    /**
     * 根据活动内容查询志愿活动
     * @param serviceSearchActivityDTO
     * @return
     */
    PageResult<ServiceVolunteerActivity> searchActivityByActivityContent(ServiceSearchActivityDTO serviceSearchActivityDTO);

    /**
     * 改变活动状态为报名截止
     * @param date
     */
    void changeStateToDeadline(Date date);

    /**
     * 改变活动状态为活动结束
     * @param date
     */
    void changeStateToEnd(Date date);

    List<Date> getResisterDeadline();

    /**
     * 获取活动截止时间
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Date> getRegistrationDeadline(Date beginTime,Date endTime);

    /**
     * 获取活动结束时间
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Date> getEndTime(Date beginTime,Date endTime);

    /**
     * 审核志愿活动
     * @param serviceReviewVolunteerActivityDTO
     * @return
     */
    boolean reviewVolunteerActivity(ServiceReviewVolunteerActivityDTO serviceReviewVolunteerActivityDTO);

    /**
     * 获取活动审核列表
     * @param serviceBaseDTO
     * @return
     */
    PageResult<ReviewActivityDTO> getReviewActivityList(ServiceBaseDTO serviceBaseDTO);

    /**
     * 获取活动审核列表
     * @return
     */
    Integer getReviewActivityCount();

    /**
     * 获取报名人数
     * @param id
     * @return
     */
    Integer getSignUpNumber(String id);

    /**
     * 查看报名情况
     * @param id
     * @return
     */
//    List<ServiceVolunteerActivity> getSignUpInformation(String id);







    /**
     * 查询所有的志愿活动装进表里
     * author:包嵩
     * @return
     */
    List<SelectVolunteerDTO> selectVolunteer();

    /**
     * 分页查询
     * author：包嵩
     * @param dto
     * @return
     */
    List<SelectVolunteerDTO> getActivityByPage(GetActivityByPageDTO dto);

    /**
     * author 包嵩
     * 获取总条数
     * @return
     */
    int getTotalPage(GetActivityByPageDTO dto);

    /**
     * author 包嵩
     * 通过内容和状态关键字查询活动
     * @param dto
     * @return
     */
    List<SelectVolunteerDTO> keywordSearchVolunteer(KeywordSearchVolunteerDTO dto);


    /**
     * author 包嵩
     * 审核通过和不通过
     * @param id,approvalState
     * @return
     */
    int examine(String[] id,String approvalState,Date date);

    /**
     * author 包嵩
     * 查看所有活动报名信息
     * @return
     */
    List<ActivityRegistrationDTO> selectActivityRegistration(GetActivityByPageDTO dto);

    /**
     * author 包嵩
     * 通过活动id删除活动
     * @param activityId
     * @return
     */
    int deleteActivityById(String activityId);

    /**
     * author 包嵩
     * 修改活动状态
     * @param activityId
     * @return
     */
    int updateActivityState(String activityId);

    /**
     * author:zhouya
     * 修改志愿活动
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(ActivityRegistrationDTO record);
}
