

package com.bandweaver.maxtunnelcommon.constant.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @date 2018/8/15
 * 社交登录类型
 */
@Getter
@AllArgsConstructor
public enum EnumLoginType {
	/**
	 * 账号密码登录
	 */
	PWD("PWD", "账号密码登录"),

	/**
	 * QQ登录
	 */
	QQ("QQ", "QQ登录"),

	/**
	 * 微信登录
	 */
	WECHAT("WX", "微信登录");

	/**
	 * 类型
	 */
	private final String type;
	/**
	 * 描述
	 */
	private final String description;
}
