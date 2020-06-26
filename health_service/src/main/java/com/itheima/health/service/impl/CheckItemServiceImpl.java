package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.mapper.CheckItemMapper;
import com.itheima.health.service.CheckItemService;
import com.itheima.health.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Program: Review01_health
 * @ClassName: CheckItemServiceImpl
 * @Description:
 * @Author: KyleSun
 **/
@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    private CheckItemMapper checkItemMapper;

    /**
     * @description: //TODO 查询所有
     * @param: []
     * @return: java.util.List<com.itheima.health.pojo.CheckItem>
     */
    @Override
    public List<CheckItem> findAll() {
        return checkItemMapper.findAll();
    }

    /**
     * @description: //TODO 添加检查项
     * @param: [checkItem]
     * @return: void
     */
    @Override
    public void add(CheckItem checkItem) {
        checkItemMapper.add(checkItem);
    }

    /**
     * @description: //TODO 修改检查项
     * @param: [checkItem]
     * @return: void
     */
    @Override
    public void edit(CheckItem checkItem) {
        checkItemMapper.edit(checkItem);
    }

    /**
     * @description: //TODO 删除检查项
     * @param: [id]
     * @return: void
     */
    @Override
    public void deleteById(Integer id) {
        checkItemMapper.deleteById(id);
    }


    /**
     * @description: //TODO 检查项分页查询
     * @param: [queryPageBean]
     * @return: com.itheima.health.entity.PageResult
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {

        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        String queryString = queryPageBean.getQueryString();

        PageHelper.startPage(currentPage, pageSize);

        Page<CheckItem> page = checkItemMapper.selectByCondition(queryString);
        long total = page.getTotal();
        List<CheckItem> rows = page.getResult();

        return new PageResult(total, rows);
    }

}
