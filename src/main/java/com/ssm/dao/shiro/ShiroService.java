package com.ssm.dao.shiro;


import com.ssm.model.User;
import com.ssm.model.shiro.CommGroup;
import com.ssm.model.shiro.Permission;
import com.ssm.model.shiro.Role;

import java.util.HashMap;
import java.util.List;

public interface ShiroService {

    //取用户关联的所有角色
    List<Role> getAllRolesByUserId(long uid);
    //取组关联的所有角色
    List<Role> getAllRolesByGroupId(long groupId);
    //取角色关联的所有权限
    List<Permission> getAllPermissionsByRoleId(long roleId);
    //取角色关联的所有用户
    List<User> getAllUsersByRoleId(long roleId);

    //取用户关联的所有组
    List<CommGroup> getAllGroupsByUserId(long uid);
    //取角色关联的所有组
    List<CommGroup> getAllGroupsByRoleId(long roleId);
    //取组关联的所有角色
    List<User> getAllUsersByGroupId(long groupId);






    //移除用户的一个角色
    int removeUserFromRoleById(HashMap params);
    //从组中移除一个用户
    int removeUserFromGroupById(HashMap params);
    //从组中移除一个角色
    int removeRoleFromGroupById(HashMap params);
    //移除角色的一个权限
    int removePermissionFromRoleById(HashMap params);



    //移除所有角色与该组的关联
    int removeAllRelationBetweenRolesAndGroupByGroupId(long groupId);
    //移除所有用户与该组的关联
    int removeAllRelationBetweenUsersAndGroupByGroupId(long groupId);
    //移除所有用户与该角色的关联
    int removeAllRelationBetweenUsersAndRoleByRoleId(long roleId);
    //移除所有组与该角色的关联
    int removeAllRelationBetweenGroupsAndRoleByRoleId(long roleId);
    //移除所有权限与该角色的关联
    int removeAllRelationBetweenPermissionsAndRoleByRoleId(long roleId);
    //移除所有角色与该权限的关联
    int removeAllRelationBetweenRolesAndPermissionByPermissionId(long permissionId);
    //移除所有角色与该用户的关联
    int removeAllRelationShipBetweenRoleAndUserByUserId(long uid);
    //移除所有组与该用户的关联
    int removeAllRelationBetweenGroupsAndUserByUserId(long uid);


}
