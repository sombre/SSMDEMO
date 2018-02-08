package com.ssm.service.shiro;


import com.ssm.dao.shiro.baseshiro.*;
import com.ssm.model.shiro.*;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseShiroServiceImpl implements BaseShiroService{


    protected RoleMapper roleMapper;
    protected CommGroupMapper commGroupMapper;
    protected PermissionMapper permissionMapper;
    protected CommGroupUserMapper commGroupUserMapper;
    protected UserRoleMapper userRoleMapper;
    protected RolePermissionMapper rolePermissionMapper;
    protected CommGroupRoleMapper commGroupRoleMapper;

    public RoleMapper getRoleMapper() {
        return roleMapper;
    }
    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public CommGroupMapper getCommGroupMapper() {
        return commGroupMapper;
    }
    @Autowired
    public void setCommGroupMapper(CommGroupMapper commGroupMapper) {
        this.commGroupMapper = commGroupMapper;
    }

    public PermissionMapper getPermissionMapper() {
        return permissionMapper;
    }
    @Autowired
    public void setPermissionMapper(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    public CommGroupUserMapper getCommGroupUserMapper() {
        return commGroupUserMapper;
    }
    @Autowired
    public void setCommGroupUserMapper(CommGroupUserMapper commGroupUserMapper) {
        this.commGroupUserMapper = commGroupUserMapper;
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
        return commGroupRoleMapper;
    }
    @Autowired
    public void setCommGroupRoleMapper(CommGroupRoleMapper commGroupRoleMapper) {
        this.commGroupRoleMapper = commGroupRoleMapper;
    }

    public int addUserToRoleById(long userId, long roleId) {
        UserRole userRole = new UserRole();
        userRole.setUid(userId);
        userRole.setRoleId(roleId);
        int affected = this.userRoleMapper.insert(userRole);
        return affected;
    }
    public int addRoleByName(String roleName) {
        Role role = new Role();
        role.setRoleName(roleName);
        int affected = this.roleMapper.insert(role);
        return affected;
    }
    public int removeRoleByRoleId(long roleId) {
        int affected =this.roleMapper.deleteByPrimaryKey(roleId);
        return affected;
    }



    public int addUserToGroupById(long userId, long groupId) {
        CommGroupUser commGroupUser = new CommGroupUser();
        commGroupUser.setUid(userId);
        commGroupUser.setGroupId(groupId);
        int affected = this.commGroupUserMapper.insert(commGroupUser);
        return affected;
    }
    public int addRoleToGroupById(long roleId, long groupId) {
        CommGroupRole groupRole = new CommGroupRole();
        groupRole.setRoleId(roleId);
        groupRole.setGroupId(groupId);
        int affected = this.commGroupRoleMapper.insert(groupRole);
        return affected;
    }
    public int addGroupByName(String groupName) {
        CommGroup group = new CommGroup();
        group.setGroupName(groupName);
        int affected = this.commGroupMapper.insert(group);
        return affected;
    }
    public int removeGroupByGroupId(long groupId) {
        int affected = this.commGroupMapper.deleteByPrimaryKey(groupId);
        return affected;
    }
    public int addPermissionToGroupById(long groupId, long permissionId) {
        return 0;
    }
    public int addPermissionToRoleById(long roleId, long permissionId) {
        RolePermission rolePermission = new RolePermission();
        rolePermission.setRoleId(roleId);
        rolePermission.setPermissionId(permissionId);
        int affected = this.rolePermissionMapper.insert(rolePermission);
        return affected;
    }
    public int addPermission(Permission permission) {
        int affected =this.permissionMapper.insert(permission);
        return affected;
    }

    public int removePermissionById(long permissionId) {
        int affected = this.permissionMapper.deleteByPrimaryKey(permissionId);
        return  affected;
    }








}
