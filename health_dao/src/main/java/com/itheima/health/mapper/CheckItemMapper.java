package com.itheima.health.mapper;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * @Program: Review01_health
 * @InterfaceName: CheckItemMapper
 * @Description:
 * @Author: KyleSun
 **/
public interface CheckItemMapper {

    /**
     * @description: //TODO 查询所有
     * @param: []
     * @return: void
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
     * @description: //TODO 根据条件查询
     * @param: [queryString]
     * @return: void
     */
    Page<CheckItem> selectByCondition(String queryString);
}
