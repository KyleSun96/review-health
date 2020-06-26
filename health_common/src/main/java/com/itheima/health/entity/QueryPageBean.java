package com.itheima.health.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 封装查询条件
 */
@Setter
@Getter
public class QueryPageBean implements Serializable {

    private Integer currentPage;//页码
    private Integer pageSize;//每页记录数
    private String queryString;//查询条件

}