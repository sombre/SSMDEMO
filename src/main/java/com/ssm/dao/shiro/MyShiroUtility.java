package com.ssm.dao.shiro;

import com.ssm.model.User;
import com.ssm.model.shiro.CommGroup;
import com.ssm.model.shiro.Permission;
import com.ssm.model.shiro.Role;

import java.util.List;

public interface MyShiroUtility {



    List<Role> getAllRolesByUserId(long uid);
    List<User> getAllUsersByRoleId(long roleId);
    boolean addUserToRole(User user,Role role);
        boolean removeUserFromRole(long uid,long roleId);
    boolean addRolePermission(Role role, Permission permission);
    boolean addRoleByName(String roleName);
        boolean removeRole(long roleId);

    List<Permission> getRoleAllPermissionsByRoleId(long roleId);
    List<Permission> getUserAllPermissionsByUId(long uid);
    List<Permission> getGroupPermissionsByGroupId(long groupId);

    List<CommGroup> getAllGroupsByUserId(long uid);
    boolean addGroupByName(String groupName);
    boolean addUserToGroup(User user,CommGroup group);
    boolean addGroupPermission(CommGroup group,Permission permission);
    boolean removeUserFromGroup(long uid,long groupId);
}
