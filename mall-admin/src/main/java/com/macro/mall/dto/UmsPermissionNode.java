package com.macro.mall.dto;

import java.util.List;

import com.macro.mall.model.UmsPermission;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by macro on 2018/9/30.
 */
public class UmsPermissionNode extends UmsPermission {
    private static final long serialVersionUID = 6433901211408001074L;
    @Getter
    @Setter
    private List<UmsPermissionNode> children;
}
