package com.tradoon.malladmin.service.impl;

import com.tradoon.malladmin.dao.UmsAdminMapper;
import com.tradoon.malladmin.service.AdminService;
import com.tradoon.mallmbg.model.UmsAdmin;
import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * author:
 * desciption:
 * date:
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UmsAdminMapper adminMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Override
    public UmsAdmin register(UmsAdmin user) {
        user.setCreateTime(new Date());
        user.setLoginTime(new Date());
        if(StringUtils.isNotBlank(user.getUsername())){
            UmsAdmin example = adminMapper.selectByNameAndKey(user.getUsername(), null);
            if(example!=null){
                //todo 封装类来判断对象为空/对象每个属性都为空
                //抛出用户名已经存在的错
                return null;
                //前端拿这个对象去干嘛?
            }
            String pwd = passwordEncoder.encode(user.getPassword());
            user.setPassword(pwd);
            adminMapper.insertAdmin(user);
        }
        return user;
    }
}
