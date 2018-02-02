package com.ssm.service.shiro;

import com.ssm.model.User;

import com.ssm.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;


public class MyAuthorizingRealm extends AuthorizingRealm {

    private IUserService IUserService;

    public IUserService getIUserService() {
        return IUserService;
    }

    @Autowired
    public void setIUserService(IUserService IUserService) {
        this.IUserService = IUserService;
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
        Object myPricipal = principalCollection.getPrimaryPrincipal();
        String email = myPricipal.toString();
        User tmpUser = this.IUserService.selectUserByEmail(email);
        if(null!=tmpUser){
            Set<String> per = new HashSet<String>();
            per.add("user:add");
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addStringPermission("post:add");
            authorizationInfo.addStringPermissions(per);
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
        User tempUser = IUserService.selectUserByEmail(email);
        if (null != tempUser) {
            return new SimpleAuthenticationInfo(email, tempUser.getPassword(), ByteSource.Util.bytes(tempUser.getSalt()),getName());
        }
        return null;
    }


}
