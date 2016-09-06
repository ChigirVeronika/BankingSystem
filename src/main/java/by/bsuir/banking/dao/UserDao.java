package by.bsuir.banking.dao;


import by.bsuir.banking.dao.exception.DaoException;
import by.bsuir.banking.entity.User;

import java.util.List;


public interface UserDao {

//	User findById(Long id);

	User findByPassport(String series, String number);

//	User findByFullName(String first, String second, String middle);

	void saveUser(User user);

	void updateUser(User user);

	void deleteByPassport(String series, String number);

//	void deleteByFullName(String first, String second, String middle);

	List<User> findAllSortedUsers() throws DaoException;

	boolean isUserUnique(Long id, String first, String second, String middle, String series, String number);

}

