package by.bsuir.banking.service;


import by.bsuir.banking.entity.User;

import java.util.List;

public interface UserService {
	
	//User findById(Long id);

	User findByPassport(String passportSeriesAndNumber);

	//User findByFullName(String first, String second, String middle);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteByPassport(String passportSeriesAndNumber);

	//void deleteByFullName(String first, String second, String middle);

	List<User> findAllSortedUsers();
	
	boolean isUserUnique(Long id, String seriesAndNumber);

}