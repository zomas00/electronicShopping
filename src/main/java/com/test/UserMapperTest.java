package com.test;

import com.dao.UserMapper;
import com.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/spring-mybatis.xml")
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void selectByUserAndPass() {
        String email = "zomas0000@126.com";
        String password = "123456";
        User u = mapper.selectByUserAndPass(email,password);
        System.out.println(u==null);
        System.out.println(u.toString());
    }
    @Test
    public void checkEmail(){
        String email = "zomas000@126.com";
        int resultCount = mapper.checkEmail(email);
        if (resultCount == 0){
            System.out.println("用户名不存在");
        }
        System.out.println(resultCount);
    }
}