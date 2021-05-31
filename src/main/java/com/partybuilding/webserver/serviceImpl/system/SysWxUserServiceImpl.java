package com.partybuilding.webserver.serviceImpl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.system.SysWxUserMapper;
import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.system.wxuser.GetWxUserListDTO;
import com.partybuilding.webserver.dto.system.wxuser.GetWxUserListInputDTO;
import com.partybuilding.webserver.entity.system.SysOrganizationalStructure;
import com.partybuilding.webserver.service.system.SysWxUserService;
import com.partybuilding.webserver.util.PageResult;
import com.partybuilding.webserver.util.WxUnicode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信用户service实现类
 */
@Service
public class SysWxUserServiceImpl implements SysWxUserService {

    @Autowired
    private SysWxUserMapper sysWxUserMapper;


    /**
     * 获取微信用户查询列表
     *
     * @param inputDTO
     * @return
     */
    @Override
    public PageResult<GetWxUserListDTO> getWxUserQueryList(GetWxUserListInputDTO inputDTO) {
        inputDTO.setNickname(WxUnicode.unicode(inputDTO.getNickname()));
        inputDTO.setNickname(inputDTO.getNickname().replaceAll("\\\\","_"));
        //  判断参数是否有误
        if (inputDTO.getCurrentPage() <= 0) {
            inputDTO.setCurrentPage(1);  //设置默认当前页
        }
        if (inputDTO.getPageSize() <= 0) {
            inputDTO.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(inputDTO.getCurrentPage(), inputDTO.getPageSize());
        List<GetWxUserListDTO> lists = sysWxUserMapper.selectWxUserAllQueryList(inputDTO);

        for(GetWxUserListDTO dto : lists){
            dto.setNickname(WxUnicode.decodeUnicode(dto.getNickname()));//解码
        }

        // 获取分页查询后的数据
        PageInfo<GetWxUserListDTO> pageInfo = new PageInfo<>(lists);
        // 封装需要返回的分页实体
        PageResult<GetWxUserListDTO> result = new PageResult<GetWxUserListDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(lists);

        return result;
    }

    public List<Organization> getOrganizationDownById(String id){
        return sysWxUserMapper.getOrganizationDownById(id);
    }
}
