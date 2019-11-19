package com.macro.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.macro.mall.service.impl.QiniuOssServiceImpl;

import io.swagger.annotations.Api;

@Controller
@Api(tags = "QiniuOssController", description = "七牛 Oss 管理")
@RequestMapping("/qiniu/oss")
public class QiniuOssController {

  @Autowired
  private QiniuOssServiceImpl qiniuOssServiceImpl;
  
}
