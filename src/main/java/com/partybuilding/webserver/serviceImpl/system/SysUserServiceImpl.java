package com.partybuilding.webserver.serviceImpl.system;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.partybuilding.webserver.dao.system.SysUserMapper;
import com.partybuilding.webserver.dto.login.LoginReturnDTO;
import com.partybuilding.webserver.dto.system.accountManagement.CreateUserAccountDTO;
import com.partybuilding.webserver.dto.system.accountManagement.CreateUserAccountInDTO;
import com.partybuilding.webserver.dto.system.userManagement.ChangeUserAccountStateDTO;
import com.partybuilding.webserver.dto.system.userManagement.GetUserAccountInfoDTO;
import com.partybuilding.webserver.dto.system.userManagement.GetUserAccountInfoPageDTO;
import com.partybuilding.webserver.dto.system.userManagement.ModifyUserInformationDTO;
import com.partybuilding.webserver.entity.system.SysUser;
import com.partybuilding.webserver.service.system.SysUserService;
import com.partybuilding.webserver.util.PageResult;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
@Repository
public class SysUserServiceImpl implements SysUserService {

    @Resource
    public SysUserMapper userMapper;

    /**
     * 创建用户账号接口
     *
     * @param dto
     * @return
     */
    @Override
    public int createUserAccount(CreateUserAccountInDTO dto) {
        CreateUserAccountDTO createUserAccountDTO = new CreateUserAccountDTO();
        createUserAccountDTO.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        createUserAccountDTO.setAccount(dto.getAccount());
        createUserAccountDTO.setSysPartyMemberInformationId(dto.getSysPartyMemberInformationId());
        createUserAccountDTO.setPassword(dto.getPassword());

        List<SysUser> userList = userMapper.isAccountExist(createUserAccountDTO.getAccount());
        if (userList.size() == 0) {
            return userMapper.createUserAccount(createUserAccountDTO);
        } else {
            return 100;
        }
    }

    /**
     * 登录用户账号接口
     *
     * @param account
     * @return
     */
    @Override
    public LoginReturnDTO accountLogin(String account) {
        return userMapper.accountLogin(account);
    }

    /**
     * 改变用户账户状态 0禁用 1启用
     *
     * @param dto
     * @return
     */
    @Override
    public int modifyUserAccountState(ChangeUserAccountStateDTO dto) {
        return userMapper.modifyUserAccountState(dto);
    }

    /**
     * 通过账户修改用户信息
     *
     * @param dto
     * @return
     */
    @Override
    public int modifyUserInformationByUserId(ModifyUserInformationDTO dto) {
        if (userMapper.isAccountExist(dto.getAccount()).isEmpty() || userMapper.isAccountExist(dto.getAccount()).get(0).getId().equals(dto.getUserId())) {
            return userMapper.modifyUserInformationByUserId(dto);
        } else {
            return 440;
        }
    }

    /**
     * 模糊查询用户账户的基本信息
     *
     * @param inputDTO
     * @return
     */
    @Override
    public PageResult<GetUserAccountInfoDTO> findPartyMemberInformation(GetUserAccountInfoPageDTO inputDTO) {
        //  判断参数是否有误
        if (inputDTO.getCurrentPage() <= 0) {
            inputDTO.setCurrentPage(1);  //设置默认当前页
        }
        if (inputDTO.getPageSize() <= 0) {
            inputDTO.setPageSize(5); // 默认每页5条
        }

        PageHelper.startPage(inputDTO.getCurrentPage(), inputDTO.getPageSize());
        List<GetUserAccountInfoDTO> userInfo;
        userInfo = userMapper.findPartyMemberInformation(inputDTO);
        // 获取分页查询后的数据
        PageInfo<GetUserAccountInfoDTO> pageInfo = new PageInfo<>(userInfo);
        // 封装需要返回的分页实体
        PageResult<GetUserAccountInfoDTO> result = new PageResult<GetUserAccountInfoDTO>();
        // 设置总记录数total
        result.setTotal((int) pageInfo.getTotal());
        // 设置数据库集合
        result.setList(userInfo);
        return result;
    }

    /**
     * 通过用户 id 删除用户信息
     *
     * @param userId
     * @return
     */
    @Override
    public int deleteUserInfoByUserId(String userId) {
        return userMapper.deleteUserInfoByUserId(userId);
    }

    /**
     * 判断账号是否被注册
     *
     * @param account
     * @return
     */
    @Override
    public List<SysUser> isAccountExist(String account) {
        return userMapper.isAccountExist(account);
    }
}
