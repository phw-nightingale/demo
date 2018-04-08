package xyz.frt.demo.service.Impl;

import xyz.frt.demo.common.AppConst;
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
public abstract class BaseServiceImpl<T> implements BaseService<T> {

    private BaseMapper<T> baseMapper;

    private JsonResult jsonResult;
    private Map<String, Object> dataMap;

    /**
     * 获取对应的Mapper类，由具体业务层实现
     * @return 对应的mapper类
     */
    public abstract BaseMapper<T> getBaseMapper();

    BaseServiceImpl() {
        baseMapper = getBaseMapper();
        jsonResult = new JsonResult();
        dataMap = new HashMap<>();
    }

    @Override
    public JsonResult deleteByPrimaryKey(Integer id) {
        Integer result = baseMapper.deleteByPrimaryKey(id);
        if (result <= 0) {
            jsonResult = JsonResult.error("错误:删除数据失败.");
        } else {
            jsonResult = JsonResult.success("成功删除了" + result + "条数据.");
        }
        return jsonResult;
    }

    @Override
    public JsonResult insert(T item) {
        Integer result = baseMapper.insert(item);
        if (result <= 0) {
            jsonResult = JsonResult.error("错误:插入数据失败.");
        } else {
            jsonResult = JsonResult.success("成功保存了" + result + "条数据.");
        }
        return jsonResult;
    }

    @Override
    public JsonResult insertSelective(T item) {
        return null;
    }

    @Override
    public JsonResult selectByPrimaryKey(Integer id) {
        T item = baseMapper.selectByPrimaryKey(id);
        if (BaseUtils.isNullOrEmpty(item)) {
            jsonResult = JsonResult.error("错误:加载对象失败.");
        } else {
            dataMap.put(AppConst.KEY_DATA, item);
            jsonResult = JsonResult.success("加载成功.", dataMap);
        }
        return jsonResult;
    }

    @Override
    public JsonResult updateByPrimaryKeySelective(T record) {
        return null;
    }

    @Override
    public JsonResult updateByPrimaryKey(T record) {
        return null;
    }

    @Override
    public JsonResult selectAll() {
        List<T> items = baseMapper.selectAll();
        if (BaseUtils.isNullOrEmpty(items)) {
            jsonResult = JsonResult.error("错误:没有匹配的记录.");
        } else {
            dataMap.put(AppConst.KEY_DATA, items);
            jsonResult = JsonResult.success("加载成功.", dataMap);
        }
        return jsonResult;
    }

    @Override
    public JsonResult selectByConditions(Map<String, Object> map) {
        return null;
    }

    @Override
    public JsonResult updateByConditions(Map<String, Object> map) {
        return null;
    }
}
