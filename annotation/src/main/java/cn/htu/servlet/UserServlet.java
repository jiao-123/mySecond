package cn.htu.servlet;

import cn.htu.service.UserService;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

/**
 * Bean  可重用组件
 *          Controller
 *          Service
 *          Repository
 */

public class UserServlet {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        UserService service = (UserService) ac.getBean("userService");
//        service.insert();


    }

}
