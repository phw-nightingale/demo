package xyz.frt.demo.dao;

import xyz.frt.demo.model.Permission;

public interface PermissionMapper extends BaseMapper<Permission> {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}