package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.system.post.GetPostPageDTO;
import com.partybuilding.webserver.dto.system.post.RealPostDTO;
import com.partybuilding.webserver.dto.system.post.ReqPostDTO;
import com.partybuilding.webserver.entity.system.SysPost;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

public interface SysPostService {
    /**
     * 通过职务名称模糊查询职务信息
     * @param dto
     * @return
     */
    PageResult findPostInfoByName(GetPostPageDTO dto);

    /**
     * 通过职务id 删除职务信息
     * @param postId
     * @return
     */
    int deletePostInfoById(String postId);

    /**
     * 添加一条职务信息
     * @param dto
     * @return
     */
    int addPostInfo(ReqPostDTO dto);

    /**
     * 通过职务id 修改职务信息
     * @param dto
     * @return
     */
    int modifyPostInfo(RealPostDTO dto);
}
