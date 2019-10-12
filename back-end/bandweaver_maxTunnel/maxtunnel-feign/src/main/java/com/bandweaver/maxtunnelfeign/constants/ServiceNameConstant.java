package com.bandweaver.maxtunnelfeign.constants;

/**
 * @author lvlutao
 * 服务名称(所有微服务在注册中心注册的名称)
 */
public interface ServiceNameConstant {
	/**
	 * 认证服务的SERVICEID
	 */
	String AUTH_SERVICE = "maxtunnel-shiro";

	/**
	 * EM模块
	 */
	String EM_SERVICE = "maxtunnel-em";

	/**
	 * OMM模块
	 */
	String OMM_SERVICE = "maxtunnel-omm";

	/**
	 * COMMON模块
	 */
	String COMMON_SERVICE = "maxtunnel-commom";


}
