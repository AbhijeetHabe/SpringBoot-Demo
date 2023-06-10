package com.springmvcdemo2.daoImpl;

import org.springframework.stereotype.Component;

import com.springmvcdemo2.dao.UserDao;
import com.springmvcdemo2.pojo.User;

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
