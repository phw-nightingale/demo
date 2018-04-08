package xyz.frt.demo.dao;

import java.util.List;
import java.util.Map;

/**
 * @author phw
 * @date Created in 04-08-2018
 * @description
 */
public interface BaseMapper<T> {

    int deleteByPrimaryKey(Integer id);

    int insert(T item);

    int insertSelective(T item);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> selectAll();

    List<T> selectByConditions(Map<String, Object> map);

    int updateByConditions(Map<String, Object> map);

}
