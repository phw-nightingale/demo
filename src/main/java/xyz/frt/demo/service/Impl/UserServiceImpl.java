package xyz.frt.demo.service.Impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.frt.demo.common.JsonResult;
import xyz.frt.demo.dao.BaseMapper;
import xyz.frt.demo.dao.UserMapper;
import xyz.frt.demo.model.User;
import xyz.frt.demo.service.UserService;
import xyz.frt.demo.util.BaseUtils;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper<User> getBaseMapper() {
        return userMapper;
    }

    @Override
    public JsonResult login(User user) {
        String username = user.getUsername();
        if (BaseUtils.isNullOrEmpty(username)) {
            return JsonResult.error("请输入用户名.");
        }
        String password = user.getPassword();
        if (BaseUtils.isNullOrEmpty(password)) {
            return JsonResult.error("请输入密码.");
        }
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        if (subject.isAuthenticated()) {
            return JsonResult.success("登陆成功.");
        }

        return JsonResult.success("用户名或密码错误.");
    }

    @Override
    public User selectByUsername(String username) {



        return null;
    }
}
