package com.macro.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.service.impl.QiniuOssServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "QiniuOssController", description = "七牛 Oss 管理")
@RequestMapping("/qiniu/oss")
public class QiniuOssController {

  @Autowired
  private QiniuOssServiceImpl qiniuOssService;
  
  @ApiOperation(value = "七牛云上传签名生成")
  @RequestMapping(value = "/token", method = RequestMethod.GET)
  public CommonResult token(@RequestParam(value="bucketType",required=false) String bucketType,
		  					@RequestParam(value="key",required=false) String key) {
       return CommonResult.success(qiniuOssService.getGeneralUploadToken(bucketType,key));
  }
  
}
