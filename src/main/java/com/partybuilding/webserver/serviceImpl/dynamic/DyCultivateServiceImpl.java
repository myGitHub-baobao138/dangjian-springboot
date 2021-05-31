package com.partybuilding.webserver.serviceImpl.dynamic;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.dynamic.DynamicCultivateMapper;
import com.partybuilding.webserver.dto.dynamic.cultivate.CreateCultivateEssayInDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.CultivateEssayDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.CultivateEssayPageDto;
import com.partybuilding.webserver.dto.dynamic.cultivate.modifyEssayInDto;
import com.partybuilding.webserver.entity.dynamic.DynamicCultivateManagement;
import com.partybuilding.webserver.service.dynamic.DyCultivateService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class DyCultivateServiceImpl implements DyCultivateService {

    @Autowired
    private DynamicCultivateMapper mapper;

    @Override
    public PageResult<CultivateEssayDto> findEssayInformation(CultivateEssayPageDto dto) {
        //  判断参数是否有误
        if (dto.getCurrentPage() <= 0) {
            dto.setCurrentPage(1);  //设置默认当前页
        }
        if (dto.getPageSize() <= 0) {
            dto.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(dto.getCurrentPage(),dto.getPageSize());
        List<CultivateEssayDto> essayInformation= mapper.findEssayInformation(dto);
        // 获取分页查询后的数据
        PageInfo<CultivateEssayDto> pageInfo = new PageInfo<>(essayInformation);
        // 封装需要返回的分页实体
        PageResult<CultivateEssayDto> result = new PageResult<>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(essayInformation);
        System.out.print(dto.getPublishTime());
        return result;
    }

    @Override
    public int createCultivateEssay(CreateCultivateEssayInDto inDto) {
        Date date = new Date();
        inDto.setId(UUID.randomUUID().toString().replaceAll("-", "")); //设置uuid
        inDto.setPublishTime(date);
        return mapper.createUserAccount(inDto);
    }

    @Override
    public int deleteCultivateEssayById(String cultivateEssayId) {
        if(cultivateEssayId==null)          //判断是否为空
            return 0;
        else
            return mapper.deleteCultivateEssayById(cultivateEssayId);
    }

    @Override
    public int publishEssayById(String[] cultivateEssayId) {
        if(cultivateEssayId.length==0)  //判断是否为空
            return 0;
        else{
            int i ;
            for (i = 0; i < cultivateEssayId.length; i++) {
                mapper.publishEssayById(cultivateEssayId[i]);
            }
            if (i==cultivateEssayId.length)
                return 1;
            else
                return 0;
        }

    }

    @Override
    public int modifyEssayById(modifyEssayInDto inDto) {
        Date date = new Date();
        inDto.setPublishTime(date);
        return mapper.modifyEssayById(inDto);
    }


}

