package xyz.frt.demo.configuration;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.frt.demo.common.AppConst;
import xyz.frt.demo.model.Resource;
import xyz.frt.demo.service.ResourceService;
import xyz.frt.demo.util.BaseUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author phw
 * @date Created in 04-08-2018
 * @description
 */
@Configuration
public class ShiroConfig {

    @Autowired(required = false)
    private ResourceService resourceService;

    private static final String redis_host = "localhost";
    private static final Integer redis_port = 6379;
    private static final Integer redis_timeout = 10000;

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * ShiroDialect，为了在thymeleaf里使用shiro的标签的bean,
     * 此处并没有使用thymeleaf，所以暂时不配置
     */

    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //必须设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        //拦截器
        //配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/font-awesome/**","anon");
        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问;

        //自定义加载权限资源关系
        List<Resource> resources = (List<Resource>) resourceService.selectAll().getDataMap().get(AppConst.KEY_DATA);
        for (Resource res: resources) {
            if (BaseUtils.isNullOrEmpty(res.getResUrl())) {
                String permission = "perms[" + res.getResUrl() + "]";
                filterChainDefinitionMap.put(res.getResUrl(), permission);
            }
        }
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        //设置Realm
        defaultSecurityManager.setRealm(myShiroRealm());

        return null;
    }

    public MyShiroRealm myShiroRealm() {
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    public CredentialsMatcher hashedCredentialsMatcher() {
        return null;
    }

}
