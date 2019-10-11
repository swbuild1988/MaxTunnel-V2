package com.bandweaver.maxtunnelcommon.constant;

/**
 * @author lvlutao
 * @date 2019-08-29
 */
public interface CommonConstant {
	/**
	 * token请求头名称
	 */
	String REQ_HEADER = "Authorization";

	/**
	 * token分割符
	 */
	String TOKEN_SPLIT = "Bearer ";

	/**
	 * jwt签名
	 */
	String SIGN_KEY = "bandweaver";


	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * JSON 资源
	 */
	String CONTENT_TYPE = "application/json; charset=utf-8";

	/**
	 * 阿里大鱼
	 */
	String ALIYUN_SMS = "aliyun_sms";

	/**
	 * 路由信息Redis保存的key
	 */
	String ROUTE_KEY = "_ROUTE_KEY";
}
