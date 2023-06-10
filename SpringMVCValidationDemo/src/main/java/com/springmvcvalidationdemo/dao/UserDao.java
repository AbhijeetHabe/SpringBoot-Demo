package com.springmvcvalidationdemo.dao;

import com.springmvcvalidationdemo.pojo.User;

public interface UserDao {

	boolean checkUserCredentials(User user);
}
