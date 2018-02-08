package com.ssm.service.shiro;

import com.ssm.model.User;
import com.ssm.model.shiro.CommGroup;
import com.ssm.model.shiro.Permission;
import com.ssm.model.shiro.Role;

public interface BaseShiroService {

    //角色
    int addUserToRoleById(long userId,long roleId);
    int addRoleByName(String roleName);
    int removeRoleByRoleId(long roleId);

    //用户组
    int addUserToGroupById(long userId,long groupId);
    int addRoleToGroupById(long roleId,long groupId);
    int addGroupByName(String groupName);
    int removeGroupByGroupId(long groupId);

    //权限
    int addPermissionToGroupById(long groupId,long permissionId);
    int addPermissionToRoleById(long roleId, long permissionId);
    int addPermission(Permission permission);
    int removePermissionById(long permissionId);

}
