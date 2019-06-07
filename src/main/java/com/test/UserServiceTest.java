package com.test;

import com.common.ServerResponse;
import com.domain.User;
import com.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-mybatis.xml")
public class UserServiceTest {
    @Autowired
    private UserService service;

    @Test
    public void login() {
       String email = "32423423eqdaasdad@126.com";
       String password= "123456";
       ServerResponse serverResponse = service.Login(email,password);
        System.out.println(serverResponse.getMsg());
    }

    @Test
    public void register() {
        User u = new User();
        u.setEmail("qweqweqwe@126.com");
        u.setPassword("123456");
        u.setIsEmailVerify("N");
        u.setEmailVerifyCode("DSFASDASDWQ");
        u.setNickname("ssw");
        u.setLastLoginIp("0:0:0:0:0:0:0:1");
        u.setLastLoginTime(12345678L);
        u.setUserIntegral(10000);
        ServerResponse response = service.register(u);
        System.out.println(response.getMsg());
    }
}