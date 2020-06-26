package com.itheima.health.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.*;

/**
 * 菜单
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Menu implements Serializable {

    private Integer id;
    private String name; // 菜单名称
    private String linkUrl; // 访问路径
    private String path;//菜单项所对应的路由路径
    private Integer priority; // 优先级（用于排序）
    private String description; // 描述
    private String icon;//图标
    private Set<Role> roles = new HashSet<Role>(0);//角色集合
    private List<Menu> children = new ArrayList<Menu>();//子菜单集合
    private Integer parentMenuId;//父菜单id

}
