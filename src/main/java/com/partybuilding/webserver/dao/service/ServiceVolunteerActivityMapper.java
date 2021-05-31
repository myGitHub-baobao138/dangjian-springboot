package com.partybuilding.webserver.dao.service;


import com.partybuilding.webserver.dto.service.volunteer.*;
import com.partybuilding.webserver.entity.service.ServiceVolunteerActivity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface ServiceVolunteerActivityMapper {

    int insert(ServiceVolunteerActivity record);

    int insertSelective(ServiceVolunteerActivity record);

    ServiceVolunteerActivity selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ActivityRegistrationDTO record);


    int updateByPrimaryKey(ServiceVolunteerActivity record);

    /**
     * 新增志愿活动
     * @param serviceAddVolunteerActivityDTO
     * @return
     */
    int addVolunteerActivity(ServiceAddVolunteerActivityDTO serviceAddVolunteerActivityDTO);

    /**
     * 发布志愿活动
     * @param id
     * @param releaseTime
     * @return
     */
    int releaseActivity(@Param("id") String id, @Param("releaseTime") Date releaseTime);

    /**
     * 根据id查看志愿活动
     * @param id
     * @return
     */
    ActivityInformationDTO searchVolunteerActivity(@Param("id") String id);

    /**
     * 获取活动列表
     * @return
     */
    List<SignUpActivityInformationDTO> getVolunteerActivityList();

    /**
     * 获取活动列表
     * @return
     */
    Integer getActivityCount();
    /**
     * 根据id删除志愿活动
     * @param id
     * @return
     */
    int deleteVolunteerActivityById(@Param("id")String id);

    /**
     * 编辑志愿活动
     * @param serviceEditVolunteerActivityDTO
     * @return
     */
    int editVolunteerActivity(ServiceEditVolunteerActivityDTO serviceEditVolunteerActivityDTO);

    /**
     * 根据状态查询志愿活动
     * @param activityState
     * @return
     */
    List<ServiceVolunteerActivity> searchActivityByActivityState(@Param("activityState")String activityState);


    /**
     * 根据内容查询志愿活动
     * @param activityContent
     * @return
     */
    List<ServiceVolunteerActivity> searchActivityByActivityContent(@Param("activityContent")String activityContent);

    /**
     * 改变活动状态为报名截止
     * @param registrationDeadline
     */
    void changeStateToDeadline(@Param("registrationDeadline") Date registrationDeadline);

    /**
     * 改变活动状态为活动结束
     * @param endTime
     */
    void changeStateToEnd(@Param("endTime") Date endTime);

    List<Date> getResisterDeadline();

    /**
     * 获取活动截止时间
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Date> getRegistrationDeadline(@Param("beginTime") Date beginTime,@Param("endTime")Date endTime);

    /**
     * 获取活动结束时间
     * @param beginTime
     * @param endTime
     * @return
     */
    List<Date> getEndTime(@Param("beginTime") Date beginTime,@Param("endTime")Date endTime);

    /**
     * 审核志愿活动
     * @param serviceReviewVolunteerActivityDTO
     * @return
     */
    int reviewVolunteerActivity(ServiceReviewVolunteerActivityDTO serviceReviewVolunteerActivityDTO);

    /**
     * 获取活动审核列表
     * @return
     */
    List<ReviewActivityDTO> getReviewActivityList();

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
    Integer getSignUpNumber(@Param("id") String id);

//    /**
//     * 查看报名情况
//     * @param id
//     * @return
//     */
//    List<ServiceVolunteerActivity> getSignUpInformation(@Param("id")String id);


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
     * 获取活动条数
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
    int examine(@Param("id")String[] id, @Param("approvalState") String approvalState,@Param("date") Date date);

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
    int updateActivityState(@Param("activityId") String activityId);

}