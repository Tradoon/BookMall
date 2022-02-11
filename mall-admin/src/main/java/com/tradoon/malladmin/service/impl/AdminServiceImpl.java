package com.tradoon.malladmin.service.impl;

import com.tradoon.bookmall.common.api.CommonResult;
import com.tradoon.bookmall.common.api.ResultCode;
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
    public CommonResult<UmsAdmin> register(UmsAdmin user) {
        user.setCreateTime(new Date());
        user.setLoginTime(new Date());
        if(StringUtils.isNotBlank(user.getUsername())){
            UmsAdmin example = adminMapper.selectByNameAndKey(user.getUsername(), null);
            if(example!=null){
                //todo 封装类来判断对象为空/对象每个属性都为空
                //抛出用户名已经存在的错return null;
                //前端拿这个对象去干嘛?
                return CommonResult.failed(ResultCode.NameRepeated.getCode(),
                        ResultCode.NameRepeated.getMessage());
            }
            String pwd = passwordEncoder.encode(user.getPassword());
            user.setPassword(pwd);
            adminMapper.insertAdmin(user);
        }
        return CommonResult.success(user);
    }

    @Override
    public CommonResult<UmsAdmin> login(UmsAdmin user) {
        if(StringUtils.isNotBlank(user.getUsername())&&StringUtils.isNotBlank(user.getPassword())){
            String pwd=passwordEncoder.encode(user.getPassword());
            UmsAdmin umsAdmin = adminMapper.selectByNameAndKey(user.getUsername(), null);
            if(umsAdmin==null)
                return CommonResult.failed(ResultCode.NOADMIN.getCode(), ResultCode.NOADMIN.getMessage());
            if(pwd.equals(umsAdmin.getPassword())){
                return CommonResult.success(umsAdmin);
            }else{
                return CommonResult.failed(ResultCode.PASSWORDERRO.getCode(), ResultCode.PASSWORDERRO.getMessage());
            }
        }
        return CommonResult.failed();
    }
}
