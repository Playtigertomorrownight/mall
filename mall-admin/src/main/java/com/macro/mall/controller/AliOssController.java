package com.macro.mall.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.macro.mall.common.api.CommonResult;
import com.macro.mall.dto.OssCallbackResult;
import com.macro.mall.dto.OssPolicyResult;
import com.macro.mall.service.impl.AliOssServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Oss相关操作接口
 * Created by macro on 2018/4/26.
 */
@Controller
@Api(tags = "AliOssController", description = "阿里云 Oss 管理")
@RequestMapping("/aliyun/oss")
public class AliOssController {
    @Autowired
    private AliOssServiceImpl aliossService;

    @ApiOperation(value = "oss上传签名生成")
    @RequestMapping(value = "/policy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult policy() {
        OssPolicyResult result = aliossService.policy();
        return CommonResult.success(result);
    }

    @ApiOperation(value = "oss上传成功回调")
    @RequestMapping(value = "callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult callback(HttpServletRequest request) {
        OssCallbackResult ossCallbackResult = aliossService.callback(request);
        return CommonResult.success(ossCallbackResult);
    }

}
