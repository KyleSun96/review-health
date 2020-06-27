package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.entity.PageResult;
import com.itheima.health.entity.QueryPageBean;
import com.itheima.health.entity.Result;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Program: Review01_health
 * @ClassName: CheckItemController
 * @Description: controller层 接收前端参数多为：JSON、k=v、url
 * @Author: KyleSun
 **/
@RestController
@RequestMapping("/checkitem")
public class CheckItemController {

    /*
        RestFul风格

        http://localhost:80/checkitem           查询  GET
        http://localhost:80/checkitem           新增  POST
        http://localhost:80/checkitem           修改  PUT
        http://localhost:80/checkitem/{id}      删除  DELETE
     */

    @Reference
    private CheckItemService checkItemService;

    /**
     * @description: //TODO 查询所有
     * @param: []
     * @return: java.util.List<com.itheima.health.pojo.CheckItem>
     */
    // @GetMapping("/findAll")
    @GetMapping
    public Result findAll() {
        List<CheckItem> all = checkItemService.findAll();
        if (all != null && all.size() != 0) {
            return new Result(true, "查询成功", all);
        }
        return new Result(false, "查询失败");
    }


    /**
     * @description: //TODO 根据id查询
     * @param: []
     * @return: com.itheima.health.entity.Result
     */
    @GetMapping("/{id}")
    public Result findOne(@PathVariable("id") Integer id) {
        CheckItem checkItem = checkItemService.findOne(id);
        return new Result(true, "查询成功", checkItem);
    }


    /**
     * @description: //TODO 添加检查项，带主键返回
     * @param: [checkItem]
     * @return: com.itheima.health.entity.Result
     */
    // @RequestMapping("/add")
    @PostMapping
    public Result add(@RequestBody CheckItem checkItem) {
        try {
            checkItemService.add(checkItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "添加失败");
        }
        return new Result(true, "添加成功");
    }


    /**
     * @description: //TODO 修改检查项
     * @param: [checkItem]
     * @return: com.itheima.health.entity.Result
     */
    // @RequestMapping("/edit")
    @PutMapping("/{id}")
    public Result edit(@RequestBody CheckItem checkItem) {
        try {
            checkItemService.edit(checkItem);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "编辑失败");
        }
        return new Result(true, "编辑成功");
    }


    /**
     * @description: //TODO 删除检查项
     * @param: [id]
     * @return: com.itheima.health.entity.Result
     */
    // @RequestMapping("/delete/{id}")
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        try {
            checkItemService.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "编辑失败");
        }
        return new Result(true, "编辑成功");
    }


    /**
     * @description: //TODO 检查项分页查询
     * @param: [queryPageBean]
     * @return: com.itheima.entity.PageResult
     */
    // @RequestMapping("/findPage")
    @PostMapping("/{page}/{size}")
    public PageResult findPage(@RequestBody QueryPageBean queryPageBean) {
        return checkItemService.findPage(queryPageBean);
    }
}
