package com.cdac.springbootmvchibernatedemo.dao;

import com.cdac.springbootmvchibernatedemo.pojo.User;

public interface UserDao {

	boolean checkUserCedentials(User user);
	boolean addNewUser(User user);
}
