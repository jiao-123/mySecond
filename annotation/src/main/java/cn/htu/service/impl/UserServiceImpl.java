package cn.htu.service.impl;

import cn.htu.dao.UserDao;
import cn.htu.domain.User;
import cn.htu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
@Resource(name = "userDao")
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    public List<User> findAll() {
        return dao.findAll();
    }

    public User findById(int id) {
        return dao.findById(id);
    }

    public void insert(User user) {
        dao.insert(user);
    }

    public void update(User user) {
        dao.update(user);
    }

    public void delete(int id) {
        dao.delete(id);
    }

}
