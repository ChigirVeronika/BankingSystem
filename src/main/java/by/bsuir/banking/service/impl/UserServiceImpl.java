package by.bsuir.banking.service.impl;

import by.bsuir.banking.dao.UserDao;
import by.bsuir.banking.dao.exception.DaoException;
import by.bsuir.banking.entity.User;
import by.bsuir.banking.service.UserService;
import by.bsuir.banking.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao dao;

    public User findByPassport(String passportSeriesAndNumber) throws ServiceException {
        User user = null;
        try {
            user = dao.findByPassport(passportSeriesAndNumber.substring(0,2), passportSeriesAndNumber.substring(2));
        } catch (DaoException e) {
            throw new ServiceException("");
        }
        return user;
    }


    public void saveUser(User user) throws ServiceException {
        try {
            dao.saveUser(user);
        } catch (DaoException e) {
            throw new ServiceException("");
        }
    }

    public void updateUser(User user) throws ServiceException {
        try {
            dao.updateUser(user);
        } catch (DaoException e) {
            throw new ServiceException("");
        }
    }

    public void deleteByPassport(String passportSeriesAndNumber) throws ServiceException {
        try {
            dao.deleteByPassport(passportSeriesAndNumber.substring(0,2), passportSeriesAndNumber.substring(2));
        } catch (DaoException e) {
            throw new ServiceException("");
        }
    }

    public List<User> findAllSortedUsers() throws ServiceException {
        List<User> list = null;
        try {
            list = dao.findAllSortedUsers();
        } catch (DaoException e) {
            throw new ServiceException("");
        }
        return list;
    }

    public boolean isUserUnique(Long id, String passportSeriesAndNumber) throws ServiceException {
        try {
            return dao.isUserUnique(id ,passportSeriesAndNumber.substring(0,2), passportSeriesAndNumber.substring(2));
        } catch (DaoException e) {
            throw new ServiceException("");
        }
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
