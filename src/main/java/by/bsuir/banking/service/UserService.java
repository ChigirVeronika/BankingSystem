package by.bsuir.banking.service;


import by.bsuir.banking.entity.User;
import by.bsuir.banking.service.exception.ServiceException;

import java.util.List;

public interface UserService {
	
	//User findById(Long id);

	User findByPassport(String passportSeriesAndNumber) throws ServiceException;

	//User findByFullName(String first, String second, String middle);
	
	void saveUser(User user) throws ServiceException;
	
	void updateUser(User user) throws ServiceException;
	
	void deleteByPassport(String passportSeriesAndNumber) throws ServiceException;

	//void deleteByFullName(String first, String second, String middle);

	List<User> findAllSortedUsers() throws ServiceException;
	
	boolean isUserUnique(Long id, String seriesAndNumber) throws ServiceException;

}