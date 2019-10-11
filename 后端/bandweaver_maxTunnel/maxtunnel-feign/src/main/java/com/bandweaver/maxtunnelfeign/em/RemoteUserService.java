package com.bandweaver.maxtunnelfeign.em;

import com.bandweaver.maxtunnelfeign.constants.ServiceNameConstant;
import com.bandweaver.maxtunnelfeign.em.fallback.RemoteUserServiceFallback;
import com.bandweaver.maxtunnelfeign.vo.R;
import com.bandweaver.maxtunnelfeign.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = ServiceNameConstant.EM_SERVICE,
        path = "/user", fallback = RemoteUserServiceFallback.class)
public interface RemoteUserService {

    @RequestMapping("/login")
    R userLogin(Integer id);

    @RequestMapping("/list")
    List<User> pageList();

    @RequestMapping("/getUser")
    R getUser(Integer id);

    @RequestMapping("/test")
    R test(Integer id);

}
