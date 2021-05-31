package com.partybuilding.webserver.serviceImpl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.system.SysPostMapper;
import com.partybuilding.webserver.dto.system.post.GetPostPageDTO;
import com.partybuilding.webserver.dto.system.post.RealPostDTO;
import com.partybuilding.webserver.dto.system.post.ReqPostDTO;
import com.partybuilding.webserver.entity.system.SysPost;
import com.partybuilding.webserver.service.system.SysPostService;
import com.partybuilding.webserver.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class SysPostImpl implements SysPostService {

    @Autowired
    SysPostMapper sysPostMapper;

    /**
     * 通过职务名称模糊查询职务信息
     *
     * @param dto
     * @return
     */
    @Override
    public PageResult findPostInfoByName(GetPostPageDTO dto) {
        //  判断参数是否有误
        if (dto.getCurrentPage() <= 0) {
            dto.setCurrentPage(1);  //设置默认当前页
        }
        if (dto.getPageSize() <= 0) {
            dto.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(dto.getCurrentPage(), dto.getPageSize());
        List<SysPost> postList;
        postList = sysPostMapper.findPostInfoByName(dto.getPostName());
        // 获取分页查询后的数据
        PageInfo<SysPost> pageInfo = new PageInfo<>(postList);
        // 封装需要返回的分页实体
        PageResult<SysPost> result = new PageResult<>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(postList);
        return result;
    }

    /**
     * 通过职务id 删除职务信息
     *
     * @param postId
     * @return
     */
    @Override
    public int deletePostInfoById(String postId) {
        return sysPostMapper.deletePostInfoById(postId);
    }

    /**
     * 添加一条职务信息
     *
     * @param dto
     * @return
     */
    @Override
    public int addPostInfo(ReqPostDTO dto) {
        // 如果职务名称已经存在，返回
        if (sysPostMapper.isPostExist(dto.getName()).size() > 0)
            return 440;
        // 否则继续执行
        RealPostDTO realPostDTO = new RealPostDTO();
        realPostDTO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        realPostDTO.setCreateTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
        realPostDTO.setName(dto.getName());
        realPostDTO.setPartyId(dto.getPartyId());
        realPostDTO.setRank(dto.getRank());
        return sysPostMapper.addPostInfo(realPostDTO);
    }

    /**
     * 通过职务id 修改职务信息
     *
     * @param dto
     * @return
     */
    @Override
    public int modifyPostInfo(RealPostDTO dto) {
        if (sysPostMapper.isPostExist(dto.getName()).isEmpty() || sysPostMapper.isPostExist(dto.getName()).get(0).getPostId().equals(dto.getId())) {
            SimpleDateFormat sf = new SimpleDateFormat();
            sf.applyPattern("yyyy/MM/dd hh:mm:ss");
            dto.setCreateTime(sf.format(new Date()));
            return sysPostMapper.modifyPostInfo(dto);
        } else {
            return 440;
        }
    }
}
