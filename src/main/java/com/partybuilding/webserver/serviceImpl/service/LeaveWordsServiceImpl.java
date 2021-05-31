package com.partybuilding.webserver.serviceImpl.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.service.ServiceLeaveWordsMapper;
import com.partybuilding.webserver.dao.system.SysWxUserMapper;
import com.partybuilding.webserver.dto.JsonResult;
import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.GetLeaveWordsInfoInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.GetLeaveWordsQueryListInputDTO;
import com.partybuilding.webserver.dto.service.leavewords.LeaveWordsListDTO;
import com.partybuilding.webserver.dto.service.leavewords.ReplyLeaveWordsInputDTO;
import com.partybuilding.webserver.service.service.LeaveWordsService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 留言管理service实现类
 */
@Service
public class LeaveWordsServiceImpl implements LeaveWordsService {
    @Autowired
    private ServiceLeaveWordsMapper leaveWordsMapper;

    /**
     * 获取留言列表
     *
     * @param inputDTO
     * @return
     */
    @Override
    public PageResult<LeaveWordsListDTO> getLeaveWordsQueryList(GetLeaveWordsQueryListInputDTO inputDTO) {

        //  判断参数是否有误
        if (inputDTO.getCurrentPage() <= 0) {
            inputDTO.setCurrentPage(1);  //设置默认当前页
        }
        if (inputDTO.getPageSize() <= 0) {
            inputDTO.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(inputDTO.getCurrentPage(), inputDTO.getPageSize());
        List<LeaveWordsListDTO> lists = leaveWordsMapper.getLeaveWordsQueryList(inputDTO);

        // 获取分页查询后的数据
        PageInfo<LeaveWordsListDTO> pageInfo = new PageInfo<>(lists);
        // 封装需要返回的分页实体
        PageResult<LeaveWordsListDTO> result = new PageResult<LeaveWordsListDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(lists);

        return result;
    }

    /**
     * 查看留言信息
     *
     * @param inputDTO
     * @return
     */
    @Override
    public LeaveWordsListDTO getLeaveWordsInfo(GetLeaveWordsInfoInputDTO inputDTO) {
        return leaveWordsMapper.getLeaveWordInfo(inputDTO);
    }

    /**
     * 回复留言信息
     *
     * @param inputDTO
     * @return
     */
    @Override
    public JsonResult replyLeaveWords(ReplyLeaveWordsInputDTO inputDTO) {
        JsonResult jsonResult = new JsonResult();
        if (leaveWordsMapper.replyLeaveWords(inputDTO) == false) {
            jsonResult.setMessage("回复失败");
            jsonResult.setCode(500);
            jsonResult.setData(false);
        } else {
            jsonResult.setData(true);
            jsonResult.setMessage("回复成功");
        }
        return jsonResult;
    }

    /**
     * 根据当前管理员组织id获取所有下级组织
    * @param id
     * @return
     */
    @Override
    public List<Organization> getOrganizationDownById(String id) {
        return leaveWordsMapper.getOrganizationDownById(id);
    }

}
