package com.ssm.service.shiro;

import com.ssm.util.Md5;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

public class MyCredentialsMatcher extends SimpleCredentialsMatcher {


    /**
     * Description: 告诉shiro如何验证加密密码，通过SimpleCredentialsMatcher或HashedCredentialsMatcher
     *
     * @Author: wjj
     * @Create Date: 2017-3-14
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        //取出token中的密码
        String pwd = new String(token.getPassword());
        SimpleAuthenticationInfo simpleinfo = (SimpleAuthenticationInfo) info;
        //从认证信息中取出盐
        String salt = new String(simpleinfo.getCredentialsSalt().getBytes());
        //将盐和token中的密码MD5散列
        String realpwd = Md5.encryptPassword(pwd,salt);
        //从认证信息中取出账户密码
        Object accountCredentials = getCredentials(info);
        //将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
        return equals(realpwd, accountCredentials);
    }

}

