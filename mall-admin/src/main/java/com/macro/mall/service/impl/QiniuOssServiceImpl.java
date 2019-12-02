package com.macro.mall.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macro.mall.config.QiniuOssConfig;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;

/**
 * 七牛云 oss 服务层
 * 
 * @author 16524
 *
 */
@Service
public class QiniuOssServiceImpl {

	@Autowired
	private QiniuOssConfig qiniuOssConfig;
	
	/**
	 * 获取普通覆盖上传秘钥
	 * @param isPublic
	 * @param key
	 * @return
	 */
	public Map<String,String> getGeneralUploadToken(String isPublic, String key) {
		Map<String,String> result = new HashMap<>();
		Auth auth = Auth.create(qiniuOssConfig.getAccessKey(), qiniuOssConfig.getSecretKey());
		isPublic = StringUtils.isBlank(isPublic)?"public":isPublic;
		isPublic = isPublic.contains("public")?qiniuOssConfig.getBucketPublic():qiniuOssConfig.getBucketPrivate();
		if(StringUtils.isBlank(key)) {
			result.put("token", auth.uploadToken(isPublic)); 
			result.put("baseUrl", qiniuOssConfig.getPublicHost()); 
		}else {
			result.put("token", auth.uploadToken(isPublic,key)); 
			result.put("baseUrl", qiniuOssConfig.getPrivateHost());
		}
		return result;
	}

	/**
	 * 获取服务端上传密钥 可以根据需求自己封装要生成的凭证 默认得到一个默认时间后过期的动态上传凭证，这个凭证可以让文件上传到默认仓库中
	 *
	 * 这个是所有上传凭证的原型，不能动
	 *
	 * @return
	 */
	public String getServerUplodToken() {
		return getServerUplodToken(null,null);
	}
	

	/**
	 *  获取服务端上传密钥
	 * @param key
	 * @return
	 */
	public String getServerUplodToken(String resporties,String key) {
		// 第一步： 先生成一个Auth验证
		Auth auth = Auth.create(qiniuOssConfig.getAccessKey(), qiniuOssConfig.getSecretKey());
		resporties = StringUtils.isBlank(resporties)?qiniuOssConfig.getBucketPublic():resporties;
		key = StringUtils.isBlank(resporties)?null:key;
		long deadline = System.currentTimeMillis() / 1000L + qiniuOssConfig.getPolicyEexpire();
		StringMap putPolicy = new StringMap();
		putPolicy.put("scope", resporties);
		putPolicy.put("deadline", deadline);
		if(StringUtils.isNotBlank(qiniuOssConfig.getCallback())) {
			putPolicy.put("callbackUrl",qiniuOssConfig.getCallback());
			putPolicy.put("returnBody", "{\"key\": $(key), \"hash\": $(etag), \"w\": $(imageInfo.width), \"h\": $(imageInfo.height)}");
			putPolicy.put("callbackBody", "{\"key\":\"$(key)\",\"hash\":\"$(etag)\",\"w\":\"$(imageInfo.width)\",\"h\":\"$(imageInfo.height)\"}");
			putPolicy.put("callbackBodyType", "application/json");
		}
		return auth.uploadToken(resporties, key, deadline, putPolicy);
	}

	/**
	 * 得到资源的访问地址，也是下载地址
	 * 
	 * @param isPublic
	 *            指定是在共有仓库还是私有仓库中，false 为私有仓库，true 为共有仓库
	 * @param objectUrl
	 *            资源的地址
	 * @return 资源的访问地址
	 */
	public String getObjectUrl(boolean isPublic, String objectUrl) {
		if (!isPublic) {
			Auth auth = Auth.create(qiniuOssConfig.getAccessKey(), qiniuOssConfig.getSecretKey());
			return auth.privateDownloadUrl(objectUrl);
		} else {
			return objectUrl;
		}
	}

}
