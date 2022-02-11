package com.tradoon.malladmin.dao;

import com.tradoon.mallmbg.model.UmsAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author:
 * desciption:
 * date:
 */
public interface UmsAdminMapper {
    /**
     * 插入用户信息
     * @param user
     * @return 操作行数
     */
    public int insertAdmin(UmsAdmin user);

    public UmsAdmin selectByNameAndKey(@Param("username")String username,@Param("password")String password);






}
