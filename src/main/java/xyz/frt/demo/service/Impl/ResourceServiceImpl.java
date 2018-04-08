package xyz.frt.demo.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.frt.demo.dao.BaseMapper;
import xyz.frt.demo.dao.ResourceMapper;
import xyz.frt.demo.model.Resource;
import xyz.frt.demo.service.ResourceService;

/**
 * @author phw
 * @date Created in 04-08-2018
 * @description
 */
@Service
@Transactional
public class ResourceServiceImpl extends BaseServiceImpl<Resource> implements ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    @Override
    public BaseMapper<Resource> getBaseMapper() {
        return resourceMapper;
    }
}
