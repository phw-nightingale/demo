package xyz.frt.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.frt.demo.dao.BaseMapper;
import xyz.frt.demo.dao.UserRoleMapper;
import xyz.frt.demo.model.UserRole;
import xyz.frt.demo.service.UserRoleService;

/**
 * @author phw
 * @date Created in 04-09-2018
 * @description
 */
@Service
@Transactional
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public BaseMapper getBaseMapper() {
        return userRoleMapper;
    }
}
