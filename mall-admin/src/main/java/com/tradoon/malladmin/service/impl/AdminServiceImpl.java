package com.tradoon.malladmin.service.impl;

import com.tradoon.malladmin.dao.UmsAdminMapper;
import com.tradoon.malladmin.service.AdminService;
import com.tradoon.mallmbg.model.UmsAdmin;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    UmsAdminMapper umsAdminMapper;
    @Autowired
    PasswordEncoder  passwordEncoder;
    @Override
    public UmsAdmin register(UmsAdmin user) {
        user.setCreateTime(new Date());
        user.setLoginTime(new Date());
        if(StringUtils.isNotBlank(user.getUsername())){
            UmsAdmin example = umsAdminMapper.selectByNameAndKey(user.getUsername(), null);
            if(example==null){
                //todo 封装类来判断对象为空/对象每个属性都为空
                return null;
                //前端拿这个对象去干嘛?
            }

        }

        return null;
    }
}
