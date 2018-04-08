package xyz.frt.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.frt.demo.dao.BaseMapper;
import xyz.frt.demo.dao.UserMapper;
import xyz.frt.demo.model.User;
import xyz.frt.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public BaseMapper<User> getBaseMapper() {
        return userMapper;
    }
}
