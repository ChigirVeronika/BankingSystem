package by.bsuir.banking.dao.impl;

import by.bsuir.banking.dao.UserDao;
import by.bsuir.banking.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
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
