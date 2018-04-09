package xyz.frt.demo.service;

import xyz.frt.demo.common.BaseEntity;
import xyz.frt.demo.common.JsonResult;

import java.util.List;
import java.util.Map;

public interface BaseService<T extends BaseEntity> {

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(T item);

    Integer insertSelective(T item);

    T selectByPrimaryKey(Integer id);

    Integer updateByPrimaryKeySelective(T item);

    Integer updateByPrimaryKey(T item);

    List<T> selectAll();

    List<T> selectAll(String orderBy);

    List<T> selectByConditions(Map<String, Object> map);

    List<T> selectByConditions(Map<String, Object> map, String orderBy);

    Integer updateByConditions(Map<String, Object> map);

    T selectByUnique(String col, Object value);

    JsonResult removeByPrimaryKey(Integer id);

    JsonResult add(T item);

    JsonResult findByPrimaryKey(Integer id);

    JsonResult upgradeByPrimaryKey(T item);

    JsonResult findAll();

    JsonResult findAll(String orderBy);

    JsonResult findByConditions(Map<String, Object> map, String orderBy);

    JsonResult findByConditions(Map<String, Object> map);

    JsonResult load(String col, Object value);

}
