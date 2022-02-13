package com.tradoon.mallmbg.dao;

import com.tradoon.mallmbg.model.UmsAdmin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * author:tradoon
 * desciption:
 * date:
 */
@Mapper
@Repository
public interface UmsAdminMapper {
    /**
     * 插入用户信息
     * @param user
     * @return 操作行数
     */

     int insertAdmin(UmsAdmin user);

    /**
     * 根据用户名或者密码进行查询用户信息
     * @param username
     * @param password
     * @return
     */
     UmsAdmin selectByNameAndKey(@Param("username")String username,@Param("password")String password);

     UmsAdmin selectByPrimaryKey(@Param("id")Long id);

     int updateByPrimaryKeySelective(@Param("admin")UmsAdmin admin);

}
