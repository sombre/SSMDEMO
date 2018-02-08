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


    int removeUserFromRoleById(HashMap params);
    int removeUserFromGroupById(HashMap params);
    int removeRoleFromGroupById(HashMap params);
    int removePermissionFromRoleById(HashMap params);

    //删除所有角色与该组的关联
    int removeAllRolesFromGroupByGroupId(long groupId);
    //删除所有用户与该组的关联
    int removeAllUsersFromGroupByGroupId(long groupId);
    //删除所有用户与该角色的关联
    int removeAllUsersFromRoleByRoleId(long roleId);
    //删除所有组与该角色的关联
    int removeAllGroupsFromRoleByRoleId(long roleId);
    //删除所有权限与该角色的关联
    int removeAllPermissionsFromRoleByRoleId(long roleId);


}
