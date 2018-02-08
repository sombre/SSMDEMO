package com.ssm.service.shiro;

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

    protected BaseShiroService baseShiroService;

    public BaseShiroService getBaseShiroService() {
        return baseShiroService;
    }
    @Autowired
    public void setBaseShiroService(BaseShiroService baseShiroService) {
        this.baseShiroService = baseShiroService;
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


    public List<Permission> getRoleAllPermissionsByRoleId(long roleId) {
        List<Permission> permissions = this.shiroService.getAllPermissionsByRoleId(roleId);
        if(null==permissions || permissions.isEmpty()) return null;
        return permissions;
    }

    public List<Permission> getUserAllPermissionsByUId(long uid) {
        //用户所有权限的集合
        List<Permission> permissions = new ArrayList<Permission>();

        //取出用户的所有角色,并取出这些角色的所有权限
        List<Role> roles = this.getAllRolesByUserId(uid);
        if(null!=roles && !roles.isEmpty())
        {
            for(Role role : roles){
                List<Permission> tmp = this.getRoleAllPermissionsByRoleId(role.getRoleId());
                if(null!=tmp && !tmp.isEmpty()){
                    for(Permission permission : tmp){
                        if(!permissions.contains(permission)){
                            permissions.add(permission);
                        }
                    }
                }
            }
        }

        //取出用户所在的组,并取出这些组的所有权限
        List<CommGroup> groups = this.getAllGroupsByUserId(uid);
        if(null!=groups && !groups.isEmpty()){
            for(CommGroup group : groups){
                List<Permission> tmp = this.getGroupPermissionsByGroupId(group.getGroupId());
                if(null!=tmp && !tmp.isEmpty()){
                    for(Permission permission : tmp){
                        if(!permissions.contains(permission)){
                            permissions.add(permission);
                        }
                    }
                }
            }
        }

        if(!permissions.isEmpty()) return permissions;
        return null;
    }

    public List<Permission> getGroupPermissionsByGroupId(long groupId) {
        List<Role> roles = this.shiroService.getAllRolesByGroupId(groupId);
        List<Permission> permissions = new ArrayList<Permission>();
        if(null!=roles && !roles.isEmpty()){
            for(Role role : roles){
                List<Permission> tmp = this.shiroService.getAllPermissionsByRoleId(role.getRoleId());
                if(null!=tmp && !tmp.isEmpty()){
                    for(Permission permission : permissions)
                    {
                        if(!permissions.contains(permission))
                        {
                            permissions.add(permission);
                        }
                    }
                }
            }
        }
        if(!permissions.isEmpty()) return permissions;
        return null;
    }

    public List<CommGroup> getAllGroupsByUserId(long uid) {
        return null;
    }









    public int removeUserFromRoleById(long uid, long roleId) {
        HashMap<String,Long> params = new HashMap<String, Long>();
        params.put("uid",uid);
        params.put("roleId",roleId);
        int affected = this.shiroService.removeUserFromRoleById(params);
        return affected;
    }


    public int removeRoleByRoleId(long roleId) {

        //取角色相关的用户
        List<User> users = this.shiroService.getAllUsersByRoleId(roleId);
        HashMap<Object,Object> params = new HashMap<Object,Object>();
        //删除所有用户与该角色的关联
        if(null!=users && !users.isEmpty()){
            for(User user : users){
                params.put("uid",user.getUid());
                params.put("roleId",roleId);
                this.shiroService.removeUserFromRoleById(params);
            }
        }

        //取角色相关的组
        List<CommGroup> groups = this.shiroService.getAllGroupsByRoleId(roleId);
        //删除所有组与该角色的关联
        if(null!=groups && !groups.isEmpty()){
            for(CommGroup group : groups)
            {
                params.put("groupId",group.getGroupId());
                params.put("roleId",roleId);
                this.shiroService.removeRoleFromGroupById(params);
            }
        }


        //取角色的所有权限
        List<Permission> permissions = this.getRoleAllPermissionsByRoleId(roleId);
        //删除所有权限与该角色的关联
        if(null!=permissions && !permissions.isEmpty()){
            for(Permission permission : permissions){
                params.put("roleId",roleId);
                params.put("permissionId",permission.getPermissionId());
                this.shiroService.removePermissionFromRoleById(params);
            }
        }

        int affected = this.baseShiroService.removeRoleByRoleId(roleId);
        return affected;
    }


    public int removeUserFromGroupById(long uid, long groupId) {
        HashMap params = new HashMap();
        params.put("uid",uid);
        params.put("groupId",groupId);
        int affected = this.shiroService.removeUserFromGroupById(params);
        return affected;
    }

    public int removeRoleFromGroupById(long roleId, long groupId) {
        HashMap params = new HashMap();
        params.put("roleId",roleId);
        params.put("groupId",groupId);
        return this.shiroService.removeRoleFromGroupById(params);
    }

    public int removePermissionByPermissionId(long permissionId) {
        int affected = this.baseShiroService.removePermissionById(permissionId);
        return affected;
    }

    public int removeGroupByGroupId(long groupId) {

        List<Role> roles = this.shiroService.getAllRolesByGroupId(groupId);
        if(null!=roles && !roles.isEmpty()){
            for(Role role : roles){
                this.removeRoleFromGroupById(role.getRoleId(),groupId);
            }
        }




        List<User> users = this.shiroService.getAllUsersByGroupId(groupId);
        if(null!=users && !users.isEmpty()){
            for(User user : users)
            {
                this.removeUserFromGroupById(user.getUid(),groupId);
            }
        }

        int affected  = this.baseShiroService.removeGroupByGroupId(groupId);
        return affected;
    }













    public int addUserToRoleById(long userId,long roleId) {
        int affected = this.baseShiroService.addUserToRoleById(userId,roleId);
        return affected;
    }

    public int addPermissionToRoleById(long roleId, long permissionId) {
        int affected = this.baseShiroService.addPermissionToRoleById(roleId,permissionId);
        return affected;
    }

    public int addRoleByName(String roleName) {
        int affected = this.baseShiroService.addRoleByName(roleName);
        return affected;
    }
    public int addGroupByName(String groupName) {
        return  this.addGroupByName(groupName);
    }

    public int addUserToGroupById(long  userId, long groupId) {
        return this.baseShiroService.addUserToGroupById(userId,groupId);
    }

    public int addPermissionToGroupById(long groupId, long permissionId) {
        return this.baseShiroService.addPermissionToGroupById(groupId,permissionId);
    }

    public int addPermission(Permission permission) {
        return this.baseShiroService.addPermission(permission);
    }




}
