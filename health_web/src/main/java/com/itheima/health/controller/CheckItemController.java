package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Program: Review01_health
 * @ClassName: CheckItemController
 * @Description:
 * @Author: KyleSun
 **/
@RestController
public class CheckItemController {

    @Reference
    private CheckItemService checkItemService;

    /**
     * @description: //TODO 查询所有
     * @param: []
     * @return: java.util.List<com.itheima.health.pojo.CheckItem>
     */
    @GetMapping("/findAll")
    public List<CheckItem> findAll() {
        return checkItemService.findAll();
    }

    /**
     * @description: //TODO 添加检查项
     * @param: [checkItem]
     * @return: void
     */
    public void add(CheckItem checkItem) {
        checkItemService.add(checkItem);
    }
}
