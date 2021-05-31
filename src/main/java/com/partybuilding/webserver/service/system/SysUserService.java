package com.partybuilding.webserver.service.system;

import com.partybuilding.webserver.dto.login.LoginReturnDTO;
import com.partybuilding.webserver.dto.system.accountManagement.CreateUserAccountInDTO;
import com.partybuilding.webserver.dto.system.userManagement.ChangeUserAccountStateDTO;
import com.partybuilding.webserver.dto.system.userManagement.GetUserAccountInfoDTO;
import com.partybuilding.webserver.dto.system.userManagement.GetUserAccountInfoPageDTO;
import com.partybuilding.webserver.dto.system.userManagement.ModifyUserInformationDTO;
import com.partybuilding.webserver.entity.system.SysUser;
import com.partybuilding.webserver.util.PageResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysUserService {
		/**
         * 创建用户账号接口
         *
         * @param dto
         * @return
         */
	int createUserAccount(CreateUserAccountInDTO dto);

	/**
	 * 登录接口
	 * @param account
	 * @return
	 */
	LoginReturnDTO accountLogin(String account);

	/**
	 * 改变用户账户状态 0禁用 1启用
	 * @param dto
	 * @return
	 */
	int modifyUserAccountState(ChangeUserAccountStateDTO dto);

	/**
	 * 通过账户修改用户信息
	 * @param dto
	 * @return
	 */
	int modifyUserInformationByUserId(ModifyUserInformationDTO dto);

	/**
	 * 模糊查询用户账户的基本信息
	 * @return
	 */
	PageResult<GetUserAccountInfoDTO> findPartyMemberInformation(GetUserAccountInfoPageDTO dto);

	/**
	 * 通过用户 id 删除用户信息
	 * @param userId
	 * @return
	 */
	int deleteUserInfoByUserId(String userId);

	/**
	 * 判断账号是否被注册
	 * @param account
	 * @return
	 */
	List<SysUser> isAccountExist(String account);
}
