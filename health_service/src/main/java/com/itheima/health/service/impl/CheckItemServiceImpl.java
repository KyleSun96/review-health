package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.entity.PageResult;
import com.itheima.health.mapper.CheckItemMapper;
import com.itheima.health.service.CheckItemService;
import com.itheima.health.pojo.CheckItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Program: Review01_health
 * @ClassName: CheckItemServiceImpl
 * @Description:
 * @Author: KyleSun
 **/
@Service(interfaceClass = CheckItemService.class)
@Slf4j
@Transactional
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
     * @description: //TODO 根据id查询
     * @param: [id]
     * @return: com.itheima.health.pojo.CheckItem
     */
    @Override
    public CheckItem findOne(Integer id) {
        return checkItemMapper.findOne(id);
    }


    /**
     * @description: //TODO 添加检查项
     * @param: [checkItem]
     * @return: void
     */
    @Override
    public CheckItem add(CheckItem checkItem) {

        // 参数校验
        if (checkItem == null || checkItem.getId() == null) {
            log.error("CheckItemServiceImpl add is error, checkItem={}", checkItem);
            throw new RuntimeException("新增检查项失败");
        }

        // 新增成功后，主键封装到checkItem的id属性
        checkItemMapper.add(checkItem);

        return checkItem;
    }


    /**
     * @description: //TODO 修改检查项，限制必须传入ID，以防代码异常
     * @param: [checkItem]
     * @return: void
     */
    @Override
    public CheckItem edit(Integer id, CheckItem checkItem) {

        // 1.参数校验
        if (id == null) {
            log.error("CheckItemServiceImpl edit is error, caused By id is null");
            throw new RuntimeException("主键不能为空");
        }

        CheckItem item = checkItemMapper.findOne(id);
        if (item == null) {
            log.error("CheckItemServiceImpl edit is error, findById is null, id = {}", id);
            throw new RuntimeException("无当前检查项");
        }

        // 2.业务处理
        checkItem.setId(id);
        checkItemMapper.edit(checkItem);

        // 3.结果处理，返回给 Controller
        return checkItem;

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
     * @description: //TODO 带条件的分页查询
     * @param: [checkItem, page, size]
     * @return: com.itheima.health.entity.PageResult
     */
    @Override
    public PageResult<CheckItem> search(CheckItem checkItem, Integer page, Integer size) {

        // 1.参数校验
        if (page == null) page = 1;
        if (size == null) size = 10;

        // 2.业务处理
        PageHelper.startPage(page, size);

        Page<CheckItem> result = (Page<CheckItem>) checkItemMapper.search(checkItem);

        long total = result.getTotal();
        if (total == 0) {
            log.error("CheckItemServiceImpl edit is error, searchByCheckItem is null");
            throw new RuntimeException("无符合条件的数据");
        }

        List<CheckItem> rows = result.getResult();
        int totalPages = result.getPages();

        return new PageResult<CheckItem>(totalPages, total, rows);
    }

}
