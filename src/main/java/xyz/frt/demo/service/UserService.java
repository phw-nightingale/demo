package xyz.frt.demo.service;

import xyz.frt.demo.common.JsonResult;
import xyz.frt.demo.model.User;

public interface UserService extends BaseService<User> {

    /**
     * 用户登录
     * @param user
     * @return
     */
    JsonResult login(User user);

    User selectByUsername(String username);
}
