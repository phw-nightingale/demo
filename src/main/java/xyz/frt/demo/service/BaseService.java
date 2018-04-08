package xyz.frt.demo.service;

import xyz.frt.demo.common.JsonResult;

import java.util.Map;

public interface BaseService<T> {

    JsonResult deleteByPrimaryKey(Integer id);

    JsonResult insert(T item);

    JsonResult insertSelective(T item);

    JsonResult selectByPrimaryKey(Integer id);

    JsonResult updateByPrimaryKeySelective(T item);

    JsonResult updateByPrimaryKey(T item);

    JsonResult selectAll();

    JsonResult selectByConditions(Map<String, Object> map);

    JsonResult updateByConditions(Map<String, Object> map);

}
