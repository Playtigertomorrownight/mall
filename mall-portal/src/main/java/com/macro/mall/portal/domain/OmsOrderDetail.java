package com.macro.mall.portal.domain;

import java.util.List;

import com.macro.mall.model.OmsOrder;
import com.macro.mall.model.OmsOrderItem;

/**
 * 包含订单商品信息的订单详情
 * Created by macro on 2018/9/4.
 */
public class OmsOrderDetail extends OmsOrder {
  private static final long serialVersionUID = -4470959009604968381L;
    private List<OmsOrderItem> orderItemList;

    public List<OmsOrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OmsOrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }
}
