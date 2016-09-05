package by.bsuir.banking.service.impl;

import by.bsuir.banking.dao.UserDao;
import by.bsuir.banking.entity.User;
import by.bsuir.banking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    public User findById(Long id) {
        return null;
    }

    public User findByPassport(String series, String number) {
        return null;
    }

    public User findByFullName(String first, String second, String middle) {
        return null;
    }

    public void saveUser(User user) {

    }

    public void updateUser(User user) {

    }

    public void deleteByPassport(String series, String number) {

    }

    public void deleteByFullName(String first, String second, String middle) {

    }

    public List<User> findAllSortedUsers() {
        return null;
    }

    public boolean isUserUnique(Long id, String first, String second, String middle, String series, String number) {
        return false;
    }
}
