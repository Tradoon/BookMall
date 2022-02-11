package com.tradoon.malladmin.service;

import com.tradoon.bookmall.common.api.CommonResult;
import com.tradoon.bookmall.common.api.ResultCode;
import com.tradoon.mallmbg.model.UmsAdmin;

/**
 * author:
 * desciption:
 * date:
 */
public interface AdminService {
    /**
     * 注册功能
     */
    CommonResult<UmsAdmin> register(UmsAdmin user);
    /**
     * 登录功能
     */
    CommonResult<UmsAdmin> login(UmsAdmin user);
}
