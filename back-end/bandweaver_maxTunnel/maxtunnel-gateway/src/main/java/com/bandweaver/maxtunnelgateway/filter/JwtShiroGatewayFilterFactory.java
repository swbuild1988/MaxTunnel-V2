package com.bandweaver.maxtunnelgateway.filter;

import com.bandweaver.maxtunnelfeign.shiro.RemoteShiroService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Set;

@Slf4j
@Component
public class JwtShiroGatewayFilterFactory implements GlobalFilter, Ordered {

    @Autowired
    private RemoteShiroService remoteShiroService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("进入 gateway 的全局过滤器 JwtShiroGatewayFilterFactory");
        ServerHttpRequest request = exchange.getRequest();
        log.info("--- request.getPath() ==" + request.getPath());
        log.info("--- request.getHeaders() ==" + request.getHeaders().toString());
        log.info("--- request.getHeaders().getFirst(\"auth\") ==" + request.getHeaders().getFirst("auth"));

        URI uri = request.getURI();
        log.info("--- request.getURI() ==" + request.getURI().toString());
        String requestPath = request.getURI().getPath();


//        log.info("*************************");
//        Set<String> premissSet = remoteShiroService.getAuthorityByUser("admin");
//        log.info("==== remoteShiroService premissSet() ==" + premissSet.toString());


//        if(requestPath.contains("/login")){
//            return chain.filter(exchange);
//        }else {
//               // TODO:从Redis中取出当前用户的所有权限,或者 从shiro 中，然后验权
//               //       通过后，再验token
//            String token = request.getHeaders().getFirst("auth");
//            if(StringUtils.isNotBlank(token)){
//              Set<String> premissSet = remoteShiroService.getAuthorityByUser("admin");
//                Subject subject = SecurityUtils.getSubject();
//                Session session = subject.getSession();
//                //User user = (User) session.getAttribute(Constants.SESSION_USER_INFO);
//                if(subject.isPermitted(requestPath)){
//
//                }else {
//
//                }
//
//
//
//
//                return chain.filter(exchange);
//            }else{
//                log.info("===== token 为空 =====");
//                ServerHttpResponse response = exchange.getResponse();
//                response.setStatusCode(HttpStatus.UNAUTHORIZED);
//                byte[] bytes = "{\"status\":\"-1\",\"msg\":\"error\"}".getBytes(StandardCharsets.UTF_8);
//                DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
//                return exchange.getResponse().writeWith(Flux.just(buffer));
//            }
//        }

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
