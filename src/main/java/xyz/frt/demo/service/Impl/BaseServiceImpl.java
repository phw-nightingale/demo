package xyz.frt.demo.service.Impl;

import xyz.frt.demo.common.AppConst;
import xyz.frt.demo.common.BaseEntity;
import xyz.frt.demo.common.JsonResult;
import xyz.frt.demo.dao.BaseMapper;
import xyz.frt.demo.service.BaseService;
import xyz.frt.demo.util.BaseUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author phw
 * @date Created in 04-08-2018
 * @description
 */
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

    public JsonResult jsonResult;
    public Map<String, Object> dataMap;


    /**
     * 获取对应的Mapper类，由具体业务层实现
     * @return 对应的mapper类
     */
    public abstract BaseMapper<T> getBaseMapper();

    BaseServiceImpl() {
        jsonResult = new JsonResult();
        dataMap = new HashMap<>();
    }

    @Override
    public JsonResult removeByPrimaryKey(Integer id) {
        Integer result = getBaseMapper().deleteByPrimaryKey(id);
        if (result <= 0) {
            jsonResult = JsonResult.error("错误:删除数据失败.");
        } else {
            jsonResult = JsonResult.success("成功删除了" + result + "条数据.");
        }
        return jsonResult;
    }

    @Override
    public JsonResult add(T item) {
        Integer result = getBaseMapper().insert(item);
        if (result <= 0) {
            jsonResult = JsonResult.error("错误:插入数据失败.");
        } else {
            jsonResult = JsonResult.success("成功保存了" + result + "条数据.");
        }
        return jsonResult;
    }

    @Override
    public Integer insertSelective(T item) {
        return null;
    }

    @Override
    public JsonResult findByPrimaryKey(Integer id) {
        T item = getBaseMapper().selectByPrimaryKey(id);
        if (BaseUtils.isNullOrEmpty(item)) {
            jsonResult = JsonResult.error("错误:加载对象失败.");
        } else {
            dataMap.put(AppConst.KEY_DATA, item);
            jsonResult = JsonResult.success("加载成功.", dataMap);
        }
        return jsonResult;
    }

    @Override
    public Integer updateByPrimaryKeySelective(T item) {
        return null;
    }

    @Override
    public JsonResult upgradeByPrimaryKey(T item) {
        Integer result = getBaseMapper().updateByPrimaryKey(item);
        if (result == 0) {
            jsonResult = JsonResult.error("错误:更新失败.");
        } else {
            jsonResult = JsonResult.success("成功更新了1条数据.");
        }
        return jsonResult;
    }

    @Override
    public JsonResult findAll() {
        List<T> items = getBaseMapper().selectAll();
        if (BaseUtils.isNullOrEmpty(items)) {
            jsonResult = JsonResult.error("错误:没有匹配的记录.");
        } else {
            dataMap.put(AppConst.KEY_DATA, items);
            jsonResult = JsonResult.success("加载成功.", dataMap);
        }
        return jsonResult;
    }

    @Override
    public JsonResult findAll(String orderBy) {
        return null;
    }

    @Override
    public JsonResult findByConditions(Map<String, Object> map) {

        return null;
    }

    @Override
    public JsonResult findByConditions(Map<String, Object> map, String orderBy) {
        return null;
    }

    @Override
    public JsonResult load(String col, Object value) {
        return null;
    }

    @Override
    public List<T> selectAll() {

        return null;
    }

    @Override
    public List<T> selectAll(String orderBy) {
        return null;
    }

    @Override
    public List<T> selectByConditions(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<T> selectByConditions(Map<String, Object> map, String orderBy) {
        return null;
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public Integer updateByConditions(Map<String, Object> map) {
        return null;
    }

    @Override
    public Integer updateByPrimaryKey(T item) {
        return null;
    }

    @Override
    public Integer insert(T item) {
        return null;
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
        return null;
    }

    @Override
    public T selectByUnique(String col, Object value) {
        return null;
    }
}
