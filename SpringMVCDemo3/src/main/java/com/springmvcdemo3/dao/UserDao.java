package com.springmvcdemo3.dao;

import com.springmvcdemo3.pojo.User;

public interface UserDao {

	boolean checkUserCredentials(User user);
}
