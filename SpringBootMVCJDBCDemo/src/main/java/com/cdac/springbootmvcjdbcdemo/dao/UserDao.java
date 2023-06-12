package com.cdac.springbootmvcjdbcdemo.dao;

import com.cdac.springbootmvcjdbcdemo.pojo.User;

public interface UserDao {

	boolean checkUserCedentials(User user);
	boolean addNewUser(User user);
}
