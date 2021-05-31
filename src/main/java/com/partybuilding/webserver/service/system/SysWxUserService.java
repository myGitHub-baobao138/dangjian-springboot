package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.Organization;
import com.partybuilding.webserver.dto.PageInputDTO;
import com.partybuilding.webserver.dto.system.wxuser.GetWxUserListDTO;
import com.partybuilding.webserver.dto.system.wxuser.GetWxUserListInputDTO;
import com.partybuilding.webserver.entity.system.SysOrganizationalStructure;
import com.partybuilding.webserver.util.PageResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 微信用户service类
 */
public interface SysWxUserService {


    /**
     * 获取微信用户查询列表
     * @param inputDTO
     * @return
     */
    PageResult<GetWxUserListDTO> getWxUserQueryList(GetWxUserListInputDTO inputDTO);

    List<Organization> getOrganizationDownById(String id);

}
