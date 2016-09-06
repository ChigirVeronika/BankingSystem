package by.bsuir.banking.service.impl;

import by.bsuir.banking.dao.UserDao;
import by.bsuir.banking.dao.exception.DaoException;
import by.bsuir.banking.entity.User;
import by.bsuir.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    public User findByPassport(String passportSeriesAndNumber) {
        return null;
    }


    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteByPassport(String passportSeriesAndNumber) {

    }

    public List<User> findAllSortedUsers() {
        List<User> list;
        try {
            list = dao.findAllSortedUsers();
        } catch (DaoException e) {
            list = new LinkedList<>();
        }
        return list;
    }

    public boolean isUserUnique(Long id, String seriesAndNumber) {
        return false;
    }

    public User findById(Long id) {
        return null;
    }

    public User findByFullName(String first, String second, String middle) {
        return null;
    }

    public void deleteByFullName(String first, String second, String middle) {

    }
}
