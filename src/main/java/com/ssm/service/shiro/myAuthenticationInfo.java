package com.ssm.service.shiro;

import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class myAuthenticationInfo extends SimpleAuthenticationInfo {

    protected int uid;
    protected String pwd;

    public myAuthenticationInfo(int uid, String pwd) {
        this.uid = uid;
        this.pwd = pwd;
    }

    public myAuthenticationInfo(Object principal, Object credentials, String realmName, int uid, String pwd) {
        super(principal, credentials, realmName);
        this.uid = uid;
        this.pwd = pwd;
    }

    public myAuthenticationInfo(Object principal, Object hashedCredentials, ByteSource credentialsSalt, String realmName, int uid, String pwd) {
        super(principal, hashedCredentials, credentialsSalt, realmName);
        this.uid = uid;
        this.pwd = pwd;
    }

    public myAuthenticationInfo(PrincipalCollection principals, Object credentials, int uid, String pwd) {
        super(principals, credentials);
        this.uid = uid;
        this.pwd = pwd;
    }

    public myAuthenticationInfo(PrincipalCollection principals, Object hashedCredentials, ByteSource credentialsSalt, int uid, String pwd) {
        super(principals, hashedCredentials, credentialsSalt);
        this.uid = uid;
        this.pwd = pwd;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
