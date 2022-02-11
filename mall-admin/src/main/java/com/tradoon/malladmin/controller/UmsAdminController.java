package com.tradoon.malladmin.controller;

import com.tradoon.bookmall.common.api.CommonResult;
import com.tradoon.bookmall.common.api.ResultCode;
import com.tradoon.malladmin.service.AdminService;
import com.tradoon.mallmbg.model.UmsAdmin;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:tradoon
 * desciption:用户注册/登录 相关接口
 * date:
 */
@RestController
@RequestMapping("/admin")
public class UmsAdminController {

    @Autowired
    AdminService adminService;
    @ApiOperation(value ="用户注册",httpMethod = "POST")
    @PostMapping("/register")
    public CommonResult<UmsAdmin> register(UmsAdmin user){

        return  adminService.register(user);
    }
    @ApiOperation(value = "用户登录",httpMethod = "POST")
    @PostMapping("/login")
    public CommonResult login(UmsAdmin user){
        return adminService.login(user);
}
}
