package com.macro.mall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

/**
 * 七牛 oss 配置
 * @author 16524
 *
 */
@Configuration
@ConfigurationProperties(prefix = "qiniu.oss")
@Data
public class QiniuOssConfig {
	
	private String endpoint;
	private String accessKey;
	private String secretKey;
	private String bucketPrivate;
	private String bucketPublic;
	private int policyEexpire = 100;
	private String callback;
	private String publicHost;
	private String privateHost;
}
