package com.cdac.springbootmvcjdbcdemo.daoImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Repository;

import com.cdac.springbootmvcjdbcdemo.dao.UserDao;
import com.cdac.springbootmvcjdbcdemo.pojo.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jTemplate;

	@Override
	public boolean checkUserCedentials(User user) {
		try {
			String query = "SELECT * FROM userdata WHERE "
					+ "username = ? AND password = ?";
			
			boolean b = jTemplate.execute(query, 
			new PreparedStatementCallback<Boolean>() {
				@Override
				public Boolean doInPreparedStatement(PreparedStatement ps) 
				throws SQLException, DataAccessException {
					ps.setString(1, user.getUsername());
					ps.setString(2, user.getPassword());
					ResultSet rs = ps.executeQuery();
					if(rs.isBeforeFirst())
						return true;
					else
						return false;
				}
			});
			
			return b;
		}
		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addNewUser(User user) {
		try {
			int count = jTemplate.update("INSERT INTO userdata"
					+ " VALUES(?,?)", 
			new Object[] {user.getUsername(), user.getPassword()});
			
			if(count>0) {
				return true;
			} else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}
