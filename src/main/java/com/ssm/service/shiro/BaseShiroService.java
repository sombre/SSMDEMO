package com.ssm.service.shiro;

import com.ssm.model.User;
import com.ssm.model.shiro.*;

import java.util.HashMap;

public interface BaseShiroService {

    //角色
    int addUserToRole(UserRole userRole);
    int createNewRole(Role role);
    int removeRoleByRoleId(long roleId);

    //用户组
    int addUserToGroup(CommGroupUser commGroupUser);
    int addRoleToGroup(CommGroupRole commGroupRole);
    int createNewGroup(CommGroup commGroup);
    int removeGroupByGroupId(long groupId);

    //权限
    int addPermissionToGroup(long groupId,long permissionId);
    int addPermissionToRole(RolePermission rolePermission);
    int createNewPermission(Permission permission);
    int removePermissionById(long permissionId);

    //简单权限
    int createNewSimplePermission(SimplePermission simplePermission);
    int addSimplePermissionToRole(RoleSimplePermission roleSimplePermission);
    int removeSimplePermissionById(long simplePermissionId);

}
