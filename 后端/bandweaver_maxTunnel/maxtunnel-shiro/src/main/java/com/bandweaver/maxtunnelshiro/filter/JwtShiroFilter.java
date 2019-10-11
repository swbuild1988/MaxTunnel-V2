package com.bandweaver.maxtunnelshiro.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.AccessControlFilter;

@Slf4j
public class JwtShiroFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        return true;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String url = request.getRequestURI();
        // 从头部获取JWT字符串信息
        //String jwt = request.getHeader(JwtConstants.AUTH_HEADER);
        log.info("=====onAccessDenied  url ======"+url);

//        if(StringUtils.isNotBlank(jwt)){
//            try {
//                boolean verify = JwtUtil.verifyToken(jwt);//验证token
//                if(verify){
//                    boolean expired = JwtUtil.isTokenExpired(jwt);//是否过期
//                    if(expired){
//                        String queueName = JwtUtil.getPrivateClaimsFromToken(jwt,"queueName");
//                        mqService.deleteQueue(queueName);
//                        LogUtil.info("-----token过期,跳登陆页面----");
//                        redirectToLogin(servletRequest, servletResponse);
//                        return false;
//                    }else{
//                        return true;
//                    }
//                }else{
//                    LogUtil.info("验证token 失败,跳登陆页面");
//                    redirectToLogin(servletRequest, servletResponse);
//                    return false;
//                }
//            } catch (IllegalArgumentException e) {
//                LogUtil.info("request header中没有JWT参数！");
//                redirectToLogin(servletRequest, servletResponse);
//                return false;
//            } catch (ExpiredJwtException e) {
//                LogUtil.info("ExpiredJwtException JWT已过期");
//                String queueName = JwtUtil.getPrivateClaimsFromToken(jwt,"queueName");
//                mqService.deleteQueue(queueName);
//                redirectToLogin(servletRequest, servletResponse);
//                return false;
//            } catch (Exception e) {
//                LogUtil.info("Exception JWT验证失败" + e.getMessage());
//                redirectToLogin(servletRequest, servletResponse);
//                return false;
//            }
//        }else{
//            LogUtil.info("------ token为空 ----" );
//            redirectToLogin(servletRequest, servletResponse);
//            return false;
//        }

        return false;
    }
}
