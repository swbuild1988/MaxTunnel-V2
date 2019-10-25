package com.bandweaver.maxtunnelgateway.filter;

import com.alibaba.fastjson.JSONObject;
import com.bandweaver.maxtunnelfeign.shiro.RemoteRabbitMqService;
import com.bandweaver.maxtunnelfeign.shiro.RemoteShiroService;
import com.bandweaver.maxtunnelfeign.vo.SecurityUser;
import com.bandweaver.maxtunnelfeign.vo.User;
import com.bandweaver.maxtunnelgateway.configura.JwtUtil;
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

    @Autowired
    private RemoteRabbitMqService remoteRabbitMqService;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("------ 进入 gateway 的全局过滤器  ------");
        ServerHttpRequest request = exchange.getRequest();
        log.info("--- request.getPath() ==" + request.getPath());
        log.info("--- request.getHeaders() ==" + request.getHeaders().toString());
        log.info("--- request.getHeaders().getFirst(\"auth\") ==" + request.getHeaders().getFirst("Authorization"));

        URI uri = request.getURI();
        log.info("--- request.getURI() ==" + request.getURI().toString());
        String requestPath = request.getURI().getPath();
        log.info("--- requestPath ----" + requestPath);
        //若是登录操作,直接放行
        if(requestPath.contains("/login")){
            return chain.filter(exchange);
        }

        String token = request.getHeaders().getFirst("Authorization");
        boolean isPremission = false;
        if(StringUtils.isNotBlank(token)){
            boolean isExpired = JwtUtil.isTokenExpired(token);
            if(isExpired){ //若 token 失效,则删除队列,并跳登录页面
                String queueName = JwtUtil.getPrivateClaimsFromToken(token,"queueName");
                //删除队列,并跳登录页面
                remoteRabbitMqService.deleteQueue(queueName);
                isPremission = false;
            }else{
                String userName = JwtUtil.getPrivateClaimsFromToken(token,"username");
                Set<String> premissSet = remoteShiroService.getAuthorityByUser(userName);
                //验证是否有权限
                if(premissSet != null && premissSet.size() > 0){
                    for(String temPre : premissSet){
                        if(temPre.contains(requestPath)){
                            return chain.filter(exchange); //有权限
                        }
                    }
                }else{
                    isPremission = false;
                }
            }
        }else{
            isPremission = false;
        }

        if(!isPremission){
            log.info("===== 验证不通过，鉴权失败 =====");
            ServerHttpResponse response = exchange.getResponse();
            JSONObject message = new JSONObject();
            message.put("status", 401);
            message.put("data", "鉴权失败");
            byte[] bytes = message.toJSONString().getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = response.bufferFactory().wrap(bytes);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            //指定编码，否则在浏览器中会中文乱码
            response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");
            return exchange.getResponse().writeWith(Flux.just(buffer));
        }

        return chain.filter(exchange);
    }




    @Override
    public int getOrder() {
        return 0;
    }
}
