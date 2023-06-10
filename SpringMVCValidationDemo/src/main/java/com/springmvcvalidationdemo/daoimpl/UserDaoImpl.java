package com.springmvcvalidationdemo.daoimpl;

import org.springframework.stereotype.Component;

import com.springmvcvalidationdemo.dao.UserDao;
import com.springmvcvalidationdemo.pojo.User;

@Component
public class UserDaoImpl implements UserDao {

	@Override
	public boolean checkUserCredentials(User user) {
		if(user.getUsername().equals("ABC@gmail.com") && 
				user.getPassword().equals("ABC@123"))
			return true;
		else
			return false;
	}
}
