package com.macro.mall.portal.domain;

import java.math.BigDecimal;

import com.macro.mall.model.PmsProduct;

import lombok.Getter;
import lombok.Setter;

/**
 * 秒杀信息和商品对象封装
 * Created by macro on 2019/1/28.
 */
@Getter
@Setter
public class FlashPromotionProduct extends PmsProduct{
  
  private static final long serialVersionUID = -7630129850414229727L;
    private BigDecimal flashPromotionPrice;
    private Integer flashPromotionCount;
    private Integer flashPromotionLimit;
}
