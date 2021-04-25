package cn.htu.test;

import cn.htu.domain.User;
import cn.htu.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {

    private UserService service;

    @Before
    public void before() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//        service = ac.getBean("userService", UserService.class);
         service = (UserService) ac.getBean("userService");
    }

    @Test
    public void testDelete() {
        service.delete(41);
    }

    @Test
    public void testFindById() {
        User user = service.findById(1);
        System.out.println(user);
    }

    @Test
    public void testFindAll() {
        List<User> userList = service.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

}
