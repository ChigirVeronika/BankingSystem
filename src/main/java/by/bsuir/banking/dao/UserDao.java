package by.bsuir.banking.dao;


import by.bsuir.banking.dao.exception.DaoException;
import by.bsuir.banking.entity.User;

import java.util.List;


public interface UserDao {

	User findById(Long id);

	User findByPassport(String series, String number) throws DaoException ;
	User findByEmail(String email) throws DaoException ;
	User findByIdNumber(String idNumber) throws DaoException ;

//	User findByFullName(String first, String second, String middle) throws DaoException ;

	void saveUser(User user) throws DaoException ;

	void updateUser(User user) throws DaoException ;

	void deleteByPassport(String series, String number) throws DaoException ;

//	void deleteByFullName(String first, String second, String middle) throws DaoException ;

	List<User> findAllSortedUsers() throws DaoException;

	boolean isUserUnique(Long id, String series, String number) throws DaoException ;

}

