package com.services;

import com.common.ServerResponse;
import com.dao.UserMapper;
import com.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ServerResponse<User> Login(String email, String password) {
        System.out.println(111111111+":");
            //该用户是否存在
        int resultCount = userMapper.checkEmail(email);
        if (resultCount == 0){
            System.out.println(1111111111+"用户");
            return ServerResponse.createByErrorMessage("用户名不存在");
        }
        // todo 密码MD5加密判断目前没加密
        User user = userMapper.selectByUserAndPass(email,password);
        if (user == null){
            System.out.println(111111111+"密码");
            return ServerResponse.createByErrorMessage("密码错误");
        }

        //将返回值的密码设置为空
        user.setPassword("");
        return ServerResponse.createBySuccess("登录成功",user);
    }
    @Override
    public ServerResponse<String> register(User user){
        int resultCount = userMapper.checkEmail(user.getEmail());
        //校验用户是否存在
        if(resultCount>0){
            return ServerResponse.createByErrorMessage("用户(邮箱)已存在");
        }
        if (user.getLastLoginIp()==null){
            user.setLastLoginIp("0:0:0:0:0:0:0:1");
        }
        if (user.getLastLoginTime()==null){
            user.setLastLoginTime(0L);
        }
        user.setIsEmailVerify("N");
        user.setEmailVerifyCode(String.valueOf(UUID.randomUUID()));
        resultCount = userMapper.insertSelective(user);
        //是否添加成功
        if (resultCount == 0){
            return ServerResponse.createBySuccessMessage("注册失败");
        }
        return ServerResponse.createBySuccessMessage("注册成功");
    }
}
