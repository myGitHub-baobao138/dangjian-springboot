package com.partybuilding.webserver.serviceImpl.system;

import com.partybuilding.webserver.dao.system.SysPermissionMapper;
import com.partybuilding.webserver.dao.system.SysRolePermissionMapper;
import com.partybuilding.webserver.dto.PermissionListDTO;
import com.partybuilding.webserver.dto.UpdatePermissionInputDTO;
import com.partybuilding.webserver.entity.system.SysPermission;
import com.partybuilding.webserver.entity.system.SysRolePermission;
import com.partybuilding.webserver.service.system.SysPermissionService;
import com.partybuilding.webserver.util.Uuid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * @Description:
 */
@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Autowired
    private SysPermissionMapper sysPermissionMapper;

    @Autowired
    private SysRolePermissionMapper sysRolePermissionMapper;

    @Override
    public List<PermissionListDTO> getPermissions(String organizationId, String postId) {
        List<PermissionListDTO> list1 =sysPermissionMapper.getPermission(organizationId, postId);
        List<PermissionListDTO> list = sysPermissionMapper.getAllPermissions();
        deletePermission(list,list1);
        return list;
    }

    public void deletePermission(List<PermissionListDTO> list,List<PermissionListDTO> list1){
        for(int i = 0; list.size() >0 && i < list.size(); i++){
            boolean isTrue = false;
            for(int j = 0; list1.size() >0 && j < list1.size(); j++){
                if(list.get(i).getPermissionPath().equals(list1.get(j).getPermissionPath())){
                    isTrue = true;
                }
            }
            if(!isTrue){
                list.remove(i);
                deletePermission(list,list1);
                if(i == list.size()){
                    i--;
                }
            }
            if(list.get(i).getChildren() != null && list.get(i).getChildren().size() > 0 && isTrue){
                deletePermission(list.get(i).getChildren(),list1);
            }

        }
    }

    @Transactional
    @Override
    public boolean updateRolePermissions(UpdatePermissionInputDTO dto) {

        // 查询
        String roleId = sysRolePermissionMapper.getRoleIdByOrganizationIdPostId(dto);

        // 删除
        boolean isTrue = sysRolePermissionMapper.deleteByRoleId(roleId);
        if (dto.getPermissionIds().equals("")) {
            return true;
        } else {
// 把字符串转成成数组
            String[] strArray = null;
            strArray = dto.getPermissionIds().split(","); //拆分字符为"," ,然后把结果交给数组strArray


            boolean isScuess = false;

            // 插入
            for (int i = 0; i < strArray.length; i++) {
                SysRolePermission sysRolePermission = new SysRolePermission();
                sysRolePermission.setRolePermissionId(Uuid.getUuid());
                sysRolePermission.setRoleId(roleId);
                sysRolePermission.setPermissionId(strArray[i]);
                isScuess = sysRolePermissionMapper.insertRolePermissions(sysRolePermission);
            }
            return isScuess;
        }

    }

    @Override
    public List<PermissionListDTO> getAllPermissions() {
        return sysPermissionMapper.getAllPermissions();
    }
}
