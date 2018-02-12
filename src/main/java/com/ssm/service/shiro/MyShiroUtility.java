package com.ssm.service.shiro;

import com.ssm.model.User;
import com.ssm.model.shiro.*;

import java.util.List;

public interface MyShiroUtility {


    //取用户关联的所有角色
    List<Role> getAllRolesByUserId(long uid);
    //取角色关联的所有用户
    List<User> getAllUsersByRoleId(long roleId);
    //取角色的所有权限
    List<Permission> getRoleAllPermissionsByRoleId(long roleId);
    //取该用户的所有权限
    List<Permission> getUserAllPermissionsByUId(long uid);
    //取该组的所有权限
    List<Permission> getGroupPermissionsByGroupId(long groupId);
    //取用户的所有组
    List<CommGroup> getAllGroupsByUserId(long uid);


    //移除用户的一个角色
    int removeUserFromRoleById(long uid,long roleId);
    //移除组的一个用户
    int removeUserFromGroupById(long uid,long groupId);
    //移除组的一个角色
    int removeRoleFromGroupById(long roleId,long groupId);
    //移除角色的一个权限
    int removePermissionFromRoleById(long permissionId,long roleId);
    //移除一个角色以及与该角色关联的所有关系
    int removeRoleAndAllRelationShipsByRoleId(long roleId);
    //移除一个权限以及与该权限关联的所有关系
    int removePermissionAndAllRelationShipsByPermissionId(long permissionId);
    //移除一个组以及与该组关联的所有关系
    int removeGroupAndAllRelationShipsByGroupId(long groupId);
    //移除一个用户的所有权限
    int removeUserAllPermissions(long uid);


    //为用户添加一个角色
    int addUserToRole(UserRole userRole);
    //创建一个新角色
    int createNewRole(Role role);
    //为角色添加一个新权限
    int addPermissionToRole(RolePermission rolePermission);
    //创建一个新组
    int createNewGroup(CommGroup commGroup);
    //为组添加一个新用户
    int addUserToGroup(CommGroupUser commGroupUser);
    //为组添加一个新角色
    int addRoleToGroup(CommGroupRole commGroupRole);
    //为组添加一个新权限
    int addPermissionToGroup();
    //创建一个新权限
    int createNewPermission(Permission permission);
}
