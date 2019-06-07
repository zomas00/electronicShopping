package com.services;


import com.common.ServerResponse;
import com.domain.User;

public interface UserService {
  //登录
    ServerResponse<User> Login(String email, String password);
  //注册
    ServerResponse<String> register(User user);
}
