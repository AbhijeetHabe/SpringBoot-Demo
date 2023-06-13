package com.cdac.springbootjdbcdemo.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cdac.springbootjdbcdemo.dao.ProductDao;
import com.cdac.springbootjdbcdemo.pojo.Product;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private JdbcTemplate jTemplate;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> lst = new ArrayList<>();
		try {
			lst = jTemplate.query("SELECT * FROM productdata", 
			new BeanPropertyRowMapper<Product>(Product.class));
			return lst;
			
		} catch (EmptyResultDataAccessException exc) {
			return lst;
		}
		catch (Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
	}

	@Override
	public Product searchProduct(int pid) {
		try {
			Product product = jTemplate.queryForObject("SELECT * FROM productdata "
					+ "WHERE id = ?",new BeanPropertyRowMapper<Product>(Product.class), pid);
			return product;
			
		} catch (EmptyResultDataAccessException exc) {
			return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addNewProduct(Product product) {
		try {
			int count = jTemplate.update(
			"INSERT INTO productdata(name, price) VALUES(?,?)",
			new Object[] {product.getName(), product.getPrice()});
			
			if (count > 0) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			int count = jTemplate.update(
			"UPDATE productdata SET name=?, price=? WHERE id=?",
			new Object[] {product.getName(), product.getPrice(),
					product.getId()});
			
			if (count > 0) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteProduct(int pid) {
		try {
			int count = jTemplate.update(
			"DELETE FROM productdata WHERE id=?",pid);
			
			if (count > 0) {
				return true;
			}
			else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
