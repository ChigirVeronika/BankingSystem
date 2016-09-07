package by.bsuir.banking.service.impl;

import by.bsuir.banking.dao.UserDao;
import by.bsuir.banking.dao.exception.DaoException;
import by.bsuir.banking.entity.User;
import by.bsuir.banking.service.UserService;
import by.bsuir.banking.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao dao;

    public User findByPassport(String passportSeriesAndNumber) throws ServiceException {
        User user;
        try {
            LOGGER.info("start findByPassport");
            LOGGER.info(passportSeriesAndNumber.substring(0, 2));
            LOGGER.info(passportSeriesAndNumber.substring(2));
            user = dao.findByPassport(passportSeriesAndNumber.substring(0, 2), passportSeriesAndNumber.substring(2));

        } catch (DaoException e) {
            throw new ServiceException("Cannot execute UserServiceImpl method findByPassport");
        }
        return user;
    }

    @Override
    public User findByEmail(String email) throws ServiceException {
        User user;
        try {
            user = dao.findByEmail(email);

        } catch (DaoException e) {
            throw new ServiceException("Cannot execute UserServiceImpl method findByPassport");
        }
        return user;
    }

    @Override
    public User findByIdNumber(String idNumber) throws ServiceException {
        User user;
        try {
            user = dao.findByIdNumber(idNumber);
        } catch (DaoException e) {
            throw new ServiceException("Cannot execute UserServiceImpl method findByIdNumber");
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
            dao.deleteByPassport(passportSeriesAndNumber.substring(0, 2), passportSeriesAndNumber.substring(2));
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
        User user = findByPassport(passportSeriesAndNumber);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

    @Override
    public boolean isUserIdNumberUnique(Long id, String idNumber) throws ServiceException {
        User user = findByIdNumber(idNumber);
        return (user == null || ((id != null) && (user.getId() == id)));
    }

    @Override
    public boolean isUserEmailUnique(Long id, String email) throws ServiceException {
        User user = findByEmail(email);
        return (user == null || ((id != null) && (user.getId() == id)));
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
