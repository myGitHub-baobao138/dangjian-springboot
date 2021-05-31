package com.partybuilding.webserver.dao.system;

import com.partybuilding.webserver.dto.system.post.PostNameAndPostId;
import com.partybuilding.webserver.dto.system.post.RealPostDTO;
import com.partybuilding.webserver.entity.system.SysPost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SysPostMapper {
    /**
     * 通过职务名称模糊查询职务信息
     * @param postName
     * @return
     */
    List<SysPost> findPostInfoByName(String postName);

    /**
     * 通过职务id 删除职务信息
     * @param postId
     * @return
     */
    int deletePostInfoById(String postId);

    /**
     * 通过职务id 删除职务信息
     * @return
     */
    List<PostNameAndPostId> findPostNameAndPostId();

    /**
     * 添加一条职务信息
     * @param dto
     * @return
     */
    int addPostInfo(RealPostDTO dto);

    /**
     * 通过职务名称查询职务是否已经存在
     * @param postName
     * @return
     */
    List<PostNameAndPostId> isPostExist(String postName);


    /**
     * 通过职务id 修改职务信息
     * @param dto
     * @return
     */
    int modifyPostInfo(RealPostDTO dto);


}
