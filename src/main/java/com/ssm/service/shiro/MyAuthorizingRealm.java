package com.ssm.service.shiro;

import com.ssm.dao.shiro.ShiroService;
import com.ssm.model.User;

import com.ssm.model.shiro.Role;
import com.ssm.model.shiro.SimplePermission;
import com.ssm.service.MyUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class MyAuthorizingRealm extends AuthorizingRealm {

    protected MyUserService MyUserService;

    protected ShiroService shiroService;

    protected MyShiroUtility myShiroUtility;

    public MyShiroUtility getMyShiroUtility() {
        return myShiroUtility;
    }
    @Autowired
    public void setMyShiroUtility(MyShiroUtility myShiroUtility) {
        this.myShiroUtility = myShiroUtility;
    }

    public ShiroService getShiroService() {
        return shiroService;
    }
    @Autowired
    public void setShiroService(ShiroService shiroService) {
        this.shiroService = shiroService;
    }

    public MyUserService getMyUserService() {
        return MyUserService;
    }

    @Autowired
    public void setMyUserService(MyUserService myUserService) {
        this.MyUserService = myUserService;
    }

    @Override
    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型的Token
        return token instanceof UsernamePasswordToken;
    }

    /**
     * 根据用户身份,对用户授权
     *
     * @param principalCollection 权限规则集合
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object myPrincipal = principalCollection.getPrimaryPrincipal();
        String email = myPrincipal.toString();
        User tmpUser = this.MyUserService.selectUserByEmail(email);
        if(null!=tmpUser){
            Set<String> per = new HashSet<String>();
            per.add("user:add");
            //取得用户所属的所有角色
            List<Role> roles = this.shiroService.getAllRolesByUserId(tmpUser.getUid());
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            for(Role role : roles){
                authorizationInfo.addRole(role.getRoleName());
            }
//            List<Permission> permissions = myShiroUtility.getUserAllPermissionsByUId(tmpUser.getUid());
            //取得用户所拥有的所有简单权限
            List<SimplePermission> simplePermissions = myShiroUtility.getUserAllSimplePermissionsByUId(tmpUser.getUid());
            List<String> permissionList = new ArrayList<String>();
            if(null!=simplePermissions && !simplePermissions.isEmpty()){
                for (SimplePermission simplePermission : simplePermissions)
                {
                    permissionList.add(simplePermission.getPermission());
                }
            }
            authorizationInfo.addStringPermissions(permissionList);
            return authorizationInfo;
        }
        return null;
    }

    /**
     * 根据输入的token,认证用户身份
     *
     * @param authenticationToken 用户身份token
     * @return AuthenticationInfo 如果认证成功返回AuthenticationInfo,否则返回null
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        String email = upToken.getUsername();
        User tempUser = MyUserService.selectUserByEmail(email);
        if (null != tempUser) {
            return new SimpleAuthenticationInfo(email, tempUser.getPassword(), ByteSource.Util.bytes(tempUser.getSalt()),getName());
        }
        return null;
    }


}
