package com.ssm.service.shiro;

import com.ssm.dao.shiro.BaseShiro;
import com.ssm.dao.shiro.MyShiroUtility;
import com.ssm.dao.shiro.ShiroService;
import com.ssm.model.User;
import com.ssm.model.shiro.CommGroup;
import com.ssm.model.shiro.Permission;
import com.ssm.model.shiro.Role;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyShiroUtilityImpl implements MyShiroUtility {

    protected BaseShiro baseShiro;

    public BaseShiro getBaseShiro() {
        return baseShiro;
    }
    @Autowired
    public void setBaseShiro(BaseShiro baseShiro) {
        this.baseShiro = baseShiro;
    }

    protected ShiroService shiroService;

    public ShiroService getShiroService() {
        return shiroService;
    }
    @Autowired
    public void setShiroService(ShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public List<Role> getAllRolesByUserId(long uid) {
        List<Role> roles = this.shiroService.getAllRolesByUserId(uid);
        if(null==roles || roles.isEmpty()) return null;
        return roles;
    }

    public List<User> getAllUsersByRoleId(long roleId) {
        List<User> users = this.shiroService.getAllUsersByRoleId(roleId);
        if(null==users || users.isEmpty()) return null;
        return users;
    }

    public boolean addUserToRole(User user,Role role) {
        if(this.baseShiro.addUserToRole(user,role)) return true;
        return false;
    }

    public boolean removeUserFromRole(long uid, long roleId) {
        HashMap<String,Long> tmp = new HashMap<String, Long>();
        tmp.put("uid",uid);
        tmp.put("roleId",roleId);
        int affected = this.shiroService.removeUserFromRole(tmp);
        if(0!=affected) return true;
        return false;
    }

    public boolean addRolePermission(Role role, Permission permission) {
        if(this.baseShiro.addRolePermission(role,permission)) return true;
        return false;
    }

    public boolean addRoleByName(String roleName) {
        if(this.baseShiro.addRoleByName(roleName)) return true;
        return false;
    }

    public boolean removeRole(long roleId) {
        if(this.baseShiro.removeRole(roleId)) return true;
        return false;
    }

    public List<Permission> getRoleAllPermissionsByRoleId(long roleId) {
        List<Permission> permissions = this.shiroService.getRoleAllPermissions(roleId);
        if(null==permissions || permissions.isEmpty()) return null;
        return permissions;
    }

    public List<Permission> getUserAllPermissionsByUId(long uid) {
        List<Role> roles = this.getAllRolesByUserId(uid);
        List<CommGroup> groups = this.getAllGroupsByUserId(uid);
        List<Permission> permissions = new ArrayList<Permission>();

        //根据用户角色取权限
        if(null!=roles && !roles.isEmpty())
        {
            for(Role role : roles){
                List<Permission> tmp = this.shiroService.getRoleAllPermissions(role.getRoleId());
                if(null!=tmp && !tmp.isEmpty()){
                    for(Permission permission : tmp){
                        if(!permissions.contains(permission)){
                            permissions.add(permission);
                        }
                    }
                }
            }
        }

        //根据用户所在的组取权限
        if(null!=groups && !groups.isEmpty()){
            for(CommGroup group : groups){
                List<Permission> tmp = this.shiroService.getGroupPermissions(group.getGroupId());
                if(null!=tmp && !tmp.isEmpty()){
                    for(Permission permission : tmp){
                        if(!permissions.contains(permission)){
                            permissions.add(permission);
                        }
                    }
                }
            }
        }



        return null;
    }

    public List<Permission> getGroupPermissionsByGroupId(long groupId) {

        return null;
    }

    public List<CommGroup> getAllGroupsByUserId(long uid) {
        return null;
    }

    public boolean addGroupByName(String groupName) {
        if(this.addGroupByName(groupName)) return true;
        return false;
    }

    public boolean addUserToGroup(User user, CommGroup group) {
        if(this.addUserToGroup(user,group)) return true;
        return false;
    }

    public boolean addGroupPermission(CommGroup group, Permission permission) {
        if(this.addGroupPermission(group,permission)) return true;
        return false;
    }

    public boolean removeUserFromGroup(long uid, long groupId) {

        return false;
    }


}
