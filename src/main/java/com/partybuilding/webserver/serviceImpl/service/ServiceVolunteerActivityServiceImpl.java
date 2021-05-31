package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceVolunteerActivityMapper;
import com.partybuilding.webserver.dto.service.volunteer.*;
import com.partybuilding.webserver.entity.service.ServiceVolunteerActivity;
import com.partybuilding.webserver.entity.system.SysAcademy;
import com.partybuilding.webserver.service.service.ServiceVolunteerActivityService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author
 */
@Service
public class ServiceVolunteerActivityServiceImpl implements ServiceVolunteerActivityService{
    @Autowired
    private ServiceVolunteerActivityMapper serviceVolunteerActivityMapper;

    @Override
    public boolean addVolunteerActivity(ServiceAddVolunteerActivityDTO serviceAddVolunteerActivityDTO) {
        return serviceVolunteerActivityMapper.addVolunteerActivity(serviceAddVolunteerActivityDTO) > 0;
    }

    @Override
    public boolean releaseActivity(String id,Date releaseTime) {
        return serviceVolunteerActivityMapper.releaseActivity(id,releaseTime) > 0;
    }

    @Override
    public ActivityInformationDTO searchVolunteerActivity(String id) {
        return serviceVolunteerActivityMapper.searchVolunteerActivity(id);
    }

    @Override
    public PageResult<SignUpActivityInformationDTO> getVolunteerActivityList(ServiceBaseDTO serviceBaseDTO) {
        PageHelper.startPage(serviceBaseDTO.getCurrentPage(),serviceBaseDTO.getPageSize());
        List<SignUpActivityInformationDTO> list = serviceVolunteerActivityMapper.getVolunteerActivityList();
        // 获取分页查询后的数据
        PageInfo<SignUpActivityInformationDTO> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<SignUpActivityInformationDTO> result = new PageResult<SignUpActivityInformationDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    @Override
    public Integer getActivityCount() {
        return serviceVolunteerActivityMapper.getActivityCount();
    }

    @Override
    public boolean deleteVolunteerActivityById(String id) {
        return serviceVolunteerActivityMapper.deleteVolunteerActivityById(id)>0;
    }

    @Override
    public boolean editVolunteerActivity(ServiceEditVolunteerActivityDTO serviceEditVolunteerActivityDTO) {
        return serviceVolunteerActivityMapper.editVolunteerActivity(serviceEditVolunteerActivityDTO)>0;
    }

    @Override
    public PageResult<ServiceVolunteerActivity> searchActivityByActivityState(ServiceSearchActivityDTO serviceSearchActivityDTO) {
        PageHelper.startPage(serviceSearchActivityDTO.getCurrentPage(),serviceSearchActivityDTO.getPageSize());
        List<ServiceVolunteerActivity> list = serviceVolunteerActivityMapper.searchActivityByActivityState(serviceSearchActivityDTO.getValue());
        // 获取分页查询后的数据
        PageInfo<ServiceVolunteerActivity> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<ServiceVolunteerActivity> result = new PageResult<ServiceVolunteerActivity>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    @Override
    public PageResult<ServiceVolunteerActivity> searchActivityByActivityContent(ServiceSearchActivityDTO serviceSearchActivityDTO) {
        PageHelper.startPage(serviceSearchActivityDTO.getCurrentPage(),serviceSearchActivityDTO.getPageSize());
        String value = serviceSearchActivityDTO.getValue();
        Pattern digit = Pattern.compile("\\d+");
        if(!(digit.matcher(value).matches())){
            value = "%"+value+"%";
        }
        List<ServiceVolunteerActivity> list = serviceVolunteerActivityMapper.searchActivityByActivityContent(value);
        // 获取分页查询后的数据
        PageInfo<ServiceVolunteerActivity> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<ServiceVolunteerActivity> result = new PageResult<ServiceVolunteerActivity>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    @Override
    public void changeStateToDeadline(Date date) {
        serviceVolunteerActivityMapper.changeStateToDeadline(date);
    }

    @Override
    public void changeStateToEnd(Date date) {
        serviceVolunteerActivityMapper.changeStateToEnd(date);
    }

    @Override
    public List<Date> getResisterDeadline() {
        return serviceVolunteerActivityMapper.getResisterDeadline();
    }

    @Override
    public List<Date> getRegistrationDeadline(Date beginTime,Date endTime) {
        return serviceVolunteerActivityMapper.getRegistrationDeadline(beginTime,endTime);
    }

    @Override
    public List<Date> getEndTime(Date beginTime,Date endTime) {
        return serviceVolunteerActivityMapper.getEndTime(beginTime,endTime);
    }

    @Override
    public boolean reviewVolunteerActivity(ServiceReviewVolunteerActivityDTO serviceReviewVolunteerActivityDTO) {
        return serviceVolunteerActivityMapper.reviewVolunteerActivity(serviceReviewVolunteerActivityDTO) > 0;
    }

    @Override
    public PageResult<ReviewActivityDTO> getReviewActivityList(ServiceBaseDTO serviceBaseDTO) {
        PageHelper.startPage(serviceBaseDTO.getCurrentPage(),serviceBaseDTO.getPageSize());
        List<ReviewActivityDTO> list = serviceVolunteerActivityMapper.getReviewActivityList();
        // 获取分页查询后的数据
        PageInfo<ReviewActivityDTO> pageInfo = new PageInfo<>(list);
        // 封装需要返回的分页实体
        PageResult<ReviewActivityDTO> result = new PageResult<ReviewActivityDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(list);
        return result;
    }

    @Override
    public Integer getReviewActivityCount() {
        return serviceVolunteerActivityMapper.getReviewActivityCount();
    }

    @Override
    public Integer getSignUpNumber(String id) {
        return serviceVolunteerActivityMapper.getSignUpNumber(id);
    }

    @Override
    public List<SelectVolunteerDTO> selectVolunteer() {
        return serviceVolunteerActivityMapper.selectVolunteer();
    }

    @Override
    public List<SelectVolunteerDTO> getActivityByPage(GetActivityByPageDTO dto) {
        return serviceVolunteerActivityMapper.getActivityByPage(dto);
    }

    @Override
    public int getTotalPage(GetActivityByPageDTO dto) {
        return serviceVolunteerActivityMapper.getTotalPage(dto);
    }

    @Override
    public List<SelectVolunteerDTO> keywordSearchVolunteer(KeywordSearchVolunteerDTO dto) {
        return serviceVolunteerActivityMapper.keywordSearchVolunteer(dto);
    }

    @Override
    public int examine(String[] id,String approvalState,Date date) {
        return serviceVolunteerActivityMapper.examine(id,approvalState,date);
    }

    @Override
    public List<ActivityRegistrationDTO> selectActivityRegistration(GetActivityByPageDTO dto) {
        return serviceVolunteerActivityMapper.selectActivityRegistration(dto);
    }

    @Override
    public int deleteActivityById(String activityId) {
        return serviceVolunteerActivityMapper.deleteActivityById(activityId);
    }

    @Override
    public int updateActivityState(String activityId) {
        return serviceVolunteerActivityMapper.updateActivityState(activityId);
    }

    @Override
    public int updateByPrimaryKeySelective(ActivityRegistrationDTO record) {
        return serviceVolunteerActivityMapper.updateByPrimaryKeySelective(record);
    }

//    @Override
//    public List<ServiceVolunteerActivity> getSignUpInformation(String id) {
//        return serviceVolunteerActivityMapper.getSignUpInformation(id);
//    }
}
