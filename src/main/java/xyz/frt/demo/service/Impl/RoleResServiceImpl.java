package xyz.frt.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.frt.demo.dao.BaseMapper;
import xyz.frt.demo.dao.RoleResMapper;
import xyz.frt.demo.model.RoleRes;
import xyz.frt.demo.service.RoleResService;

/**
 * @author phw
 * @date Created in 04-09-2018
 * @description
 */
@Service
@Transactional
public class RoleResServiceImpl extends BaseServiceImpl<RoleRes> implements RoleResService {

    @Autowired
    private RoleResMapper roleResMapper;

    @Override
    public BaseMapper<RoleRes> getBaseMapper() {
        return roleResMapper;
    }
}
