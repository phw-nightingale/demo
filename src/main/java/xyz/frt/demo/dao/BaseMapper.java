package xyz.frt.demo.dao;

import xyz.frt.demo.common.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * @author phw
 * @date Created in 04-08-2018
 * @description
 */
public interface BaseMapper<T extends BaseEntity> {

    int deleteByPrimaryKey(Integer id);

    int insert(T item);

    int insertSelective(T item);

    T selectByPrimaryKey(Integer id);;

    List<T> selectAll();

    List<T> selectAll(String orderBy);

    int updateByPrimaryKeySelective(T item);

    int updateByPrimaryKey(T item);

    List<T> selectByConditions(Map<String, Object> conditions);

    List<T> selectByConditions(Map<String, Object> conditions, String orderBy);

    int updateByConditions(Map<String, Object> conditions);

}
