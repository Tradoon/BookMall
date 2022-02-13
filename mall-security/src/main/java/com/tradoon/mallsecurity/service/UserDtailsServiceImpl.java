package com.tradoon.mallsecurity.service;
import com.tradoon.mallmbg.dao.UmsAdminMapper;
import com.tradoon.mallmbg.model.UmsAdmin;
import com.tradoon.mallsecurity.component.AdminUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * author:tradoon
 * desciption:
 * date:2022/02/12/
 */
@Component
public class UserDtailsServiceImpl implements UserDetailsService {
    @Autowired
    UmsAdminMapper umsAdminMapper;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //根据用户名查询用户的具体信息

            UmsAdmin admin = umsAdminMapper.selectByNameAndKey(s, null);
            if(Objects.isNull(admin)){
                throw  new RuntimeException("用户名查不到对应用户");
            }

        //查询用户授权信息

        //封装成userDetails对象
        return new AdminUserDetails(admin);
    }
}
