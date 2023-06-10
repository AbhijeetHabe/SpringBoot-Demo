package com.springmvcdemo2.dao;

import com.springmvcdemo2.pojo.User;

public interface UserDao {

	boolean checkUserCredentials(User user);
}
