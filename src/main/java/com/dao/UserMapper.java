package com.dao;

import com.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    //删除用户
    int deleteByPrimaryKey(Integer id);

    int insert(User record);
    //添加用户（所有数值不能为null）
    int insertSelective(User user);
    //查询用户信息
    User selectByPrimaryKey(Integer id);
    //登录需要用到username和password
    User selectByUserAndPass(String email, String password);
    //判断用户是否存在
    Integer checkEmail(String email);
    //修改用户信息
    int updateByPrimaryKeySelective(User record);
    int updateByPrimaryKey(User record);
}