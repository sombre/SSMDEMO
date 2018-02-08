package com.ssm.service.shiro;

import com.ssm.model.User;
import com.ssm.model.shiro.CommGroup;
import com.ssm.model.shiro.Permission;
import com.ssm.model.shiro.Role;

import java.util.List;

public interface MyShiroUtility {



    List<Role> getAllRolesByUserId(long uid);
    List<User> getAllUsersByRoleId(long roleId);
    List<Permission> getRoleAllPermissionsByRoleId(long roleId);
    List<Permission> getUserAllPermissionsByUId(long uid);
    List<Permission> getGroupPermissionsByGroupId(long groupId);
    List<CommGroup> getAllGroupsByUserId(long uid);


    int removeUserFromRoleById(long uid,long roleId);
    int removeUserFromGroupById(long uid,long groupId);
    int removeRoleFromGroupById(long roleId,long groupId);
    int removeRoleByRoleId(long roleId);
    int removePermissionByPermissionId(long permissionId);
    int removeGroupByGroupId(long groupId);


    int addUserToRoleById(long userId,long roleId);
    int addRoleByName(String roleName);
    int addPermissionToRoleById(long roleId, long permissionId);
    int addGroupByName(String groupName);
    int addUserToGroupById(long userId,long groupId);
    int addPermissionToGroupById(long groupId,long permissionId);
    int addPermission(Permission permission);
}
