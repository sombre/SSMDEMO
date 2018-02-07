package com.ssm.service.shiro;

import com.ssm.dao.shiro.*;
import com.ssm.model.User;
import com.ssm.model.shiro.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class BaseShiroImpl implements BaseShiro {

    protected RoleMapper roleMapper;
    protected CommGroupMapper myGroupMapper;
    protected PermissionMapper permissionMapper;
    protected CommGroupUserMapper myGroupUserMapper;
    protected UserRoleMapper userRoleMapper;
    protected RolePermissionMapper rolePermissionMapper;
    protected CommGroupRoleMapper myGroupRoleMapper;

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }
    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public CommGroupMapper getCommGroupMapper() {
        return myGroupMapper;
    }
    @Autowired
    public void setCommGroupMapper(CommGroupMapper myGroupMapper) {
        this.myGroupMapper = myGroupMapper;
    }

    public PermissionMapper getPermissionMapper() {
        return permissionMapper;
    }
    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    public CommGroupUserMapper getCommGroupUserMapper() {
        return myGroupUserMapper;
    }
    @Autowired
    public void setCommGroupUserMapper(CommGroupUserMapper myGroupUserMapper) {
        this.myGroupUserMapper = myGroupUserMapper;
    }

    public UserRoleMapper getUserRoleMapper() {
        return userRoleMapper;
    }
    @Autowired
    public void setUserRoleMapper(UserRoleMapper userRoleMapper) {
        this.userRoleMapper = userRoleMapper;
    }

    public RolePermissionMapper getRolePermissionMapper() {
        return rolePermissionMapper;
    }
    @Autowired
    public void setRolePermissionMapper(RolePermissionMapper rolePermissionMapper) {
        this.rolePermissionMapper = rolePermissionMapper;
    }

    public CommGroupRoleMapper getCommGroupRoleMapper() {
        return myGroupRoleMapper;
    }
    @Autowired
    public void setCommGroupRoleMapper(CommGroupRoleMapper myGroupRoleMapper) {
        this.myGroupRoleMapper = myGroupRoleMapper;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean addUserToRole(User user, Role role) {
        UserRole userRole = new UserRole();
        userRole.setUid(user.getUid());
        userRole.setRoleId(role.getRoleId());
        int affected = this.userRoleMapper.insert(userRole);
        if (0 != affected) return true;
        return false;
    }


    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean addRolePermission(Role role, Permission permission) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(role.getRoleId());
        rolePermission.setPermissionId(permission.getPermissionId());
        int affected = this.rolePermissionMapper.insert(rolePermission);
        if (0 != affected) return true;
        return false;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean addRoleByName(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        int affected = this.roleMapper.insert(role);
        if (0 != affected) return true;
        return false;
    }

    public boolean removeRole(long roleId) {
        int affected =this.roleMapper.deleteByPrimaryKey(roleId);
        if(0!=affected) return true;
        return false;
    }


    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean addGroupByName(String groupName) {
        CommGroup group = new CommGroup();
        group.setGroupName(groupName);
        int affected = this.myGroupMapper.insert(group);
        if (0 != affected) return true;
        return false;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public boolean addUserToGroup(User user, CommGroup group) {
        CommGroupUser myGroupUser = new CommGroupUser();
        myGroupUser.setUid(user.getUid());
        myGroupUser.setGroupId(group.getGroupId());
        int affected = this.myGroupUserMapper.insert(myGroupUser);
        if (0 != affected) return true;
        return false;
    }



    public boolean addRoleToGroup(Role role, CommGroup group) {
        CommGroupRole myGroupRole = new CommGroupRole();
        myGroupRole.setRoleId(role.getRoleId());
        myGroupRole.setGroupId(group.getGroupId());
        int affected = this.myGroupRoleMapper.insert(myGroupRole);
        if (0 != affected) return true;
        return false;
    }

    public boolean addGroupPermission(CommGroup group, Permission permission) {
        return false;
    }



}
