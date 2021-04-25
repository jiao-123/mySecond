package cn.htu.dao.impl;

import cn.htu.dao.UserDao;
import cn.htu.domain.User;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;
@Repository("userDao")
public class UserDaoImpl implements UserDao {
@Resource(name = "runner")
    private QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public List<User> findAll() {
        try {
            return runner.query("select * from user", new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User findById(int id) {
        try {
            return runner.query("select * from user where id = ?", new BeanHandler<>(User.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void insert(User user) {
        try {
            runner.update("insert into user (name, address) values (?, ?)", user.getName(), user.getAddress());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(User user) {
        try {
            runner.update("update user set name = ? address = ? where id = ?", user.getName(), user.getAddress(), user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        try {
            runner.update("delete from user where id = ?", id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
