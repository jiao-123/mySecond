package cn.htu.service;

import cn.htu.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int id);

    void insert(User user);

    void update(User user);

    void delete(int id);

}
