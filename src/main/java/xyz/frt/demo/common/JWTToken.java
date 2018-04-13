package xyz.frt.demo.common;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author phw
 * @date Created in 04-09-2018
 * @description
 */
public class JWTToken implements AuthenticationToken {

    /**
     * 秘钥
     */
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

}
