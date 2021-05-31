package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceThemeDayMapper;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayDetailsDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayPartyMemberNumberDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayQueryDTO;
import com.partybuilding.webserver.dto.service.themeDay.ThemeDayTableDto;
import com.partybuilding.webserver.dto.service.threeSessionOneClass.ParticipateReturnDTO;
import com.partybuilding.webserver.entity.service.ServiceThemeDay;
import com.partybuilding.webserver.service.service.ServiceThemeDayService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.Uuid;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceThemeDayServiceImpl implements ServiceThemeDayService {

    @Autowired(required = false)
    ServiceThemeDayMapper serviceThemeDayMapper;
    @Override
    public int deleteByPrimaryKey(String id) {
        return serviceThemeDayMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(ServiceThemeDay record) {
        record.setId( Uuid.getUuid());
//        record.setParticipantsId(StringUtils.join(record.getParticipantsId(),",")) ;
        return serviceThemeDayMapper.insert(record);
    }

    @Override
    public int insertSelective(ServiceThemeDay record) {
        record.setId( Uuid.getUuid());
        return serviceThemeDayMapper.insertSelective(record);
    }

    @Override
    public ServiceThemeDay selectByPrimaryKey(String id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(ServiceThemeDay record) {
        return serviceThemeDayMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(ServiceThemeDay record) {
        return 0;
    }

    @Override
    public PageResult<ThemeDayTableDto> getThemeDayTableList(ThemeDayQueryDTO record) {
        //  判断参数是否有误
        if(record.getCurrentPage() <= 0){
            record.setCurrentPage(1);  //设置默认当前页
        }
        if(record.getPageSize() <= 0) {
            record.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(record.getCurrentPage(),record.getPageSize());
        List<ThemeDayTableDto> lists = serviceThemeDayMapper.getThemeDayTableList(record);

        // 获取分页查询后的数据
        PageInfo<ThemeDayTableDto> pageInfo = new PageInfo<>(lists);
        // 封装需要返回的分页实体
        PageResult<ThemeDayTableDto> result = new PageResult<ThemeDayTableDto>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(lists);

        return result;
    }

    @Override
    public ThemeDayDetailsDTO getThemeDayDetails(String id) {
        return serviceThemeDayMapper.getThemeDayDetails(id);
    }

    @Override
    public int deleteThemeDay(String id) {
        return serviceThemeDayMapper.deleteThemeDay(id);
    }

    @Override
    public int postThemeDay(String[] ids) {
        return serviceThemeDayMapper.postThemeDay(ids);
    }

    @Override
    public int updateTop(String id) {
        return serviceThemeDayMapper.updateTop(id);
    }

    @Override
    public int updateNotTop(String id) {
        return serviceThemeDayMapper.updateNotTop(id);
    }

    @Override
    public ThemeDayDetailsDTO getInsertThemeDayDefaultThree(String organizationId) {
        return serviceThemeDayMapper.getInsertThemeDayDefaultThree(organizationId);
    }

    @Override
    public int getPartyMemberNumber(ThemeDayPartyMemberNumberDTO record) {
        return serviceThemeDayMapper.getPartyMemberNumber(record);
    }

    @Override
    public String getAttendThemeDayPartyIdList(String id) {
        return serviceThemeDayMapper.getAttendThemeDayPartyIdList(id);
    }

    @Override
    public List<ParticipateReturnDTO> getAttendThemeDayPartyList(String id){
        return serviceThemeDayMapper.getAttendThemeDayPartyList(id);
    }

}
