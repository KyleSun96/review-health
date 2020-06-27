package com.itheima.health.service;

import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * @Program: Review01_health
 * @InterfaceName: CheckItemService
 * @Description: CheckItemService
 * @Author: KyleSun
 **/
public interface CheckItemService {

    /**
     * @description: //TODO 查询所有
     * @param: []
     * @return: java.util.List<com.itheima.health.pojo.CheckItem>
     */
    public List<CheckItem> findAll();


    /**
     * @description: //TODO 添加检查项
     * @param: [checkItem]
     * @return: void
     */
    public void add(CheckItem checkItem);


    /**
     * @description: //TODO 修改检查项
     * @param: [checkItem]
     * @return: void
     */
    public void edit(CheckItem checkItem);


    /**
     * @description: //TODO 删除检查项
     * @param: [id]
     * @return: void
     */
    public void deleteById(Integer id);


    /**
     * @description: //TODO 检查项分页查询
     * @param: [queryPageBean]
     * @return: com.itheima.health.entity.PageResult
     */
    public PageResult findPage(QueryPageBean queryPageBean);


    /**
     * @description: //TODO 根据id查询
     * @param: [id]
     * @return: com.itheima.health.pojo.CheckItem
     */
    public CheckItem findOne(Integer id);

}
