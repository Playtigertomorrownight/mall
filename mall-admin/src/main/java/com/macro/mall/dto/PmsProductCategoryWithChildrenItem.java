package com.macro.mall.dto;

import java.util.List;

import com.macro.mall.model.PmsProductCategory;

/**
 * Created by macro on 2018/5/25.
 */
public class PmsProductCategoryWithChildrenItem extends PmsProductCategory {
    private static final long serialVersionUID = -2619266692550661671L;
    private List<PmsProductCategory> children;

    public List<PmsProductCategory> getChildren() {
        return children;
    }

    public void setChildren(List<PmsProductCategory> children) {
        this.children = children;
    }
}
