package com.cdac.springbootmvchibernatedemo.daoImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.springbootmvchibernatedemo.dao.UserDao;
import com.cdac.springbootmvchibernatedemo.pojo.User;
import com.cdac.springbootmvchibernatedemo.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private UserRepository repository;
	
	@Override
	public boolean checkUserCedentials(User user) {
		try {
			Optional<User> opt =
					repository.findById(user.getUsername());
			if (opt.isPresent()) {
				User u = opt.get();
				if (u.getPassword().equals(user.getPassword()) ) {
					return true;
				} else {
					return false;
				}
				
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addNewUser(User user) {
		try {
			Optional<User> opt = 
					repository.findById(user.getUsername());
			
			if (opt.isPresent()) {
				return false;
			} else {
				repository.save(user);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
