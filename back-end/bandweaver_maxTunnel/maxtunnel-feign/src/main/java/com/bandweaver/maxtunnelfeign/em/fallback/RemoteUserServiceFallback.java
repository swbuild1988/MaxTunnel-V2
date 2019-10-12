package com.bandweaver.maxtunnelfeign.em.fallback;

import com.bandweaver.maxtunnelfeign.em.RemoteUserService;
import com.bandweaver.maxtunnelfeign.vo.R;
import com.bandweaver.maxtunnelfeign.vo.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RemoteUserServiceFallback implements RemoteUserService {

    @Override
    public R userLogin(Integer id) {
        return new R("调用失败,服务降级");
    }

    @Override
    public List<User> pageList() {
        return new ArrayList<User>();
    }

    @Override
    public R getUser(Integer id) {
        return new R("getUser()调用失败,服务降级");
    }

    @Override
    public R test(Integer id) {
        return new R("test()调用失败,服务降级");
    }
}
