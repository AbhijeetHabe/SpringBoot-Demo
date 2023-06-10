package com.springmvcdemo3.daoImpl;

import org.springframework.stereotype.Component;

import com.springmvcdemo3.dao.UserDao;
import com.springmvcdemo3.pojo.User;

@Component
public class UserDaoImpl implements UserDao {

	@Override
	public boolean checkUserCredentials(User user) {
		if (user.getUsername().equals("ABC@gmail.com") &&
				user.getPassword().equals("ABC@123")) {
			return true;
		}
		return false;
	}
}
