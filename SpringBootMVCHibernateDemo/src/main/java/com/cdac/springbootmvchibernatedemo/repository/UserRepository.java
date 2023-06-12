package com.cdac.springbootmvchibernatedemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cdac.springbootmvchibernatedemo.pojo.User;

public interface UserRepository extends CrudRepository<User, String> {

//	@Query(value = "FROM User u WHERE u.username =:uname AND "
//			+ "u.password =:upass")
//	List<User> findUser(@Param("uname") String name, @Param("upass") 
//	String pass);
}
