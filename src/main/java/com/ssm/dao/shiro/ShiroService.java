package com.ssm.dao.shiro;


import com.ssm.model.User;
import com.ssm.model.shiro.Permission;
import com.ssm.model.shiro.Role;

import java.util.HashMap;
import java.util.List;

public interface ShiroService {

    List<Role> getAllRolesByUserId(long uid);
    List<User> getAllUsersByRoleId(long roleId);
    List<MyGroup> getAllGroupsByUserId(long uid);
//    boolean addUserToRole(UserRole userRole);
    int removeUserFromRole(HashMap stringHashMap);

    List<Permission> getRoleAllPermissions(long roleId);
    List<Permission> getUserAllPermissions(long uid);
    List<Permission> getGroupPermissions(long groupId);

//    List<Group> getAllGroupsByUserId(long uid);
//    boolean addGroupByName(String groupName);
//    boolean addUserToGroup(long uid,long groupId);
//    boolean addGroupPermission(long groupId,long permissionId);
//    boolean removeUserFromGroup(long uid,long groupId);


}
