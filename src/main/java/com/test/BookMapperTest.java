package com.test;

import com.dao.BookMapper;
import com.domain.Book;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BookMapperTest {
   private BookMapper bookMapper;

    @Before
    public void setUp() throws Exception {
        //创建IOC容器(因为通过容器获取对象)
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
        bookMapper = context.getBean(BookMapper.class);
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        int id = 1;
        Book book = bookMapper.selectByPrimaryKey(id);
        System.out.println(book.getId()+","+book.getAuthor());
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}