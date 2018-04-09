package xyz.frt.demo.configuration;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.frt.demo.common.AppConst;
import xyz.frt.demo.common.JWTToken;
import xyz.frt.demo.common.JWTUtil;
import xyz.frt.demo.common.JsonResult;
import xyz.frt.demo.model.User;
import xyz.frt.demo.service.UserRoleService;
import xyz.frt.demo.service.UserService;

/**
 * @author phw
 * @date Created in 04-08-2018
 * @description
 */
@Component
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    /**
     * 重写Shiro获取用户信息的方法
     * @param authenticationToken token
     * @return 用户信息
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        String username = (String) authenticationToken.getPrincipal();
        System.out.println("Username:" + username);
        System.out.println(authenticationToken.getCredentials());


    }

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只用当用户需要检测权限的时候才会用到这个方法
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = JWTUtil.getUsername(principalCollection.toString());
        User user = userService.selectByUsername(username);


        return null;
    }
}
