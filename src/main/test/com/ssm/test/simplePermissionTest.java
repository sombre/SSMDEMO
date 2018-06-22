package com.ssm.test;

import com.ssm.model.shiro.RoleSimplePermission;
import com.ssm.model.shiro.SimplePermission;
import org.junit.Ignore;
import org.junit.Test;

public class simplePermissionTest extends BaseTest{

    @Ignore
    public void addSimplePer(){
        SimplePermission simplePermission = new SimplePermission();
        RoleSimplePermission roleSimplePermission = new RoleSimplePermission();


        simplePermission.setPermission("user:add");
        myShiroUtility.createNewSimplePermission(simplePermission);

        roleSimplePermission.setPermissionId(simplePermission.getPermissionId());
        roleSimplePermission.setRoleId(2l);


        myShiroUtility.addSimplePermissionToRole(roleSimplePermission);

        simplePermission.setPermission("post:add");
        myShiroUtility.createNewSimplePermission(simplePermission);

        roleSimplePermission.setRoleId(2l);
        roleSimplePermission.setPermissionId(simplePermission.getPermissionId());
        myShiroUtility.addSimplePermissionToRole(roleSimplePermission);

    }


    @Test
    public void removeSimplePer(){

//        myShiroUtility.removeSimplePermissionFromRoleById(9,2);
//
//        myShiroUtility.removeAllSimplePermissionFromRoleByRoleId(2);

    myShiroUtility.removeSimplePermissionAndAllRelationBySimplePermissionId(13);


    }



}
