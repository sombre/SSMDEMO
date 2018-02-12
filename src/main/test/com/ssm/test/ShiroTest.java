package com.ssm.test;



import com.ssm.model.User;
import com.ssm.model.shiro.*;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ShiroTest extends BaseTest{

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;


    @Ignore
    public void testForaddPermission1()
    {

        assertNotNull(this.mockMvc);

        UserRole userRole = new UserRole();
        CommGroupUser commGroupUser = new CommGroupUser();
        CommGroupRole commGroupRole = new CommGroupRole();
        RolePermission rolePermission = new RolePermission();
        CommGroup commGroup = new CommGroup();
        Role role = new Role();
        Permission permission = new Permission();

        role.setRoleName("testRole");
        myShiroUtility.createNewRole(role);


        userRole.setUid((long) 11);
        userRole.setRoleId(role.getRoleId());
        myShiroUtility.addUserToRole(userRole);

        commGroup.setGroupName("testGroup");
        myShiroUtility.createNewGroup(commGroup);

        commGroupUser.setUid((long)11);
        commGroupUser.setGroupId(commGroup.getGroupId());
        myShiroUtility.addUserToGroup(commGroupUser);

        permission.setResourceType("Test");
        permission.setResourceId((long) 1);
        permission.setPermission("testPermission");
        myShiroUtility.createNewPermission(permission);


        rolePermission.setRoleId(role.getRoleId());
        rolePermission.setPermissionId(permission.getPermissionId());
        myShiroUtility.addPermissionToRole(rolePermission);


        commGroupRole.setGroupId(commGroup.getGroupId());
        commGroupRole.setRoleId(role.getRoleId());
        myShiroUtility.addRoleToGroup(commGroupRole);



    }



    @Ignore
    public void testForaddPermission2()
    {

        assertNotNull(this.mockMvc);

        UserRole userRole = new UserRole();
        CommGroupUser commGroupUser = new CommGroupUser();
        CommGroupRole commGroupRole = new CommGroupRole();
        RolePermission rolePermission = new RolePermission();
        CommGroup commGroup = new CommGroup();
        Role role = new Role();
        Permission permission = new Permission();

        role.setRoleName("testRole2");
        myShiroUtility.createNewRole(role);

        System.out.println(role.getRoleId()+"\n");

        userRole.setUid((long) 10);
        userRole.setRoleId(role.getRoleId());
        myShiroUtility.addUserToRole(userRole);

        commGroup.setGroupName("testGroup2");
        myShiroUtility.createNewGroup(commGroup);

        commGroupUser.setUid((long)10);
        commGroupUser.setGroupId(commGroup.getGroupId());
        myShiroUtility.addUserToGroup(commGroupUser);

        permission.setResourceType("Test2");
        permission.setResourceId((long) 1);
        permission.setPermission("testPermission2");
        myShiroUtility.createNewPermission(permission);


        rolePermission.setRoleId(role.getRoleId());
        rolePermission.setPermissionId(permission.getPermissionId());
        myShiroUtility.addPermissionToRole(rolePermission);


        commGroupRole.setGroupId(commGroup.getGroupId());
        commGroupRole.setRoleId(role.getRoleId());
        myShiroUtility.addRoleToGroup(commGroupRole);





//        Role role1 = new Role();
        role.setRoleName("test3");
        myShiroUtility.createNewRole(role);

        System.out.println(role.getRoleId()+"\n");

        rolePermission.setPermissionId((long) 5);
        rolePermission.setRoleId(role.getRoleId());
        myShiroUtility.addPermissionToRole(rolePermission);

        rolePermission.setPermissionId((long) 6);
        rolePermission.setRoleId(role.getRoleId());
        myShiroUtility.addPermissionToRole(rolePermission);

        userRole.setUid(10l);
        userRole.setRoleId(role.getRoleId());
        myShiroUtility.addUserToRole(userRole);

        userRole.setUid(11l);
        userRole.setRoleId(role.getRoleId());
        myShiroUtility.addUserToRole(userRole);


        commGroup.setGroupName("testGroup3");
        myShiroUtility.createNewGroup(commGroup);

        commGroupUser.setUid((long)10);
        commGroupUser.setGroupId(commGroup.getGroupId());
        myShiroUtility.addUserToGroup(commGroupUser);


        role.setRoleName("test4");
        myShiroUtility.createNewRole(role);

        rolePermission.setPermissionId((long) 3);
        rolePermission.setRoleId(role.getRoleId());
        myShiroUtility.addPermissionToRole(rolePermission);





    }

    @Test
    public void testForGet(){

//        List<CommGroup> g = myShiroUtility.getAllGroupsByUserId(10l);
//        List<Role> roles = myShiroUtility.getAllRolesByUserId(10l);
//        List<User> users = myShiroUtility.getAllUsersByRoleId(6l);
//        List<Permission> permissions = myShiroUtility.getGroupPermissionsByGroupId(2l);
//        permissions = myShiroUtility.getRoleAllPermissionsByRoleId(6l);
//        g = myShiroUtility.getAllGroupsByUserId(10l);
//        myShiroUtility.get
//        List<Permission> userPermission = this.myShiroUtility.getUserAllPermissionsByUId(10);
    }








    @Test
    public void testForRemove1(){

//        myShiroUtility.removeRoleFromGroupById(9,3);
//        myShiroUtility.removeUserFromGroupById(11,3);
//        myShiroUtility.removeUserFromRoleById(11,9);
//        myShiroUtility.removePermissionFromRoleById(9,9);
//        myShiroUtility.removeGroupAndAllRelationShipsByGroupId(3l);

//        myShiroUtility.removePermissionAndAllRelationShipsByPermissionId(8l);

//        myShiroUtility.removeRoleAndAllRelationShipsByRoleId();

    }


    @Ignore
    public void testForRemove2(){

        myShiroUtility.removeGroupAndAllRelationShipsByGroupId(1l);
        myShiroUtility.removeGroupAndAllRelationShipsByGroupId(2l);

        myShiroUtility.removePermissionAndAllRelationShipsByPermissionId(7l);

        myShiroUtility.removeRoleAndAllRelationShipsByRoleId(5l);
        myShiroUtility.removeRoleAndAllRelationShipsByRoleId(6l);
        myShiroUtility.removeRoleAndAllRelationShipsByRoleId(7l);

//        myShiroUtility.removeUserAllPermissions(10l);

    }




    public void main(String args[]){

//        testForaddPermission1();
//        testForaddPermission2();
//        this.testForGet();
//        testForRemove1();
//        testForRemove2();

    }

}
