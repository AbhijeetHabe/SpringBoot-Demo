package com.cdac.springboothibernatedemo.daoImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cdac.springboothibernatedemo.dao.ProductDao;
import com.cdac.springboothibernatedemo.pojo.Product;
import com.cdac.springboothibernatedemo.repository.ProductRepository;

@Repository
public class ProductDaoImpl implements ProductDao {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public List<Product> getAllProducts() {
		List<Product> lst = new ArrayList<>();
		try {
			repository.findAll().forEach(lst::add);
			return lst;
			
		} catch (Exception e) {
			e.printStackTrace();
			lst.clear();
			return lst;
		}
	}

	@Override
	public Product searchProduct(int pid) {
		try {
			Optional<Product> opt = 
			repository.findById(pid);
			
			if(opt.isPresent()) {
				Product product = opt.get();
				return product;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean addNewProduct(Product product) {
		try {
			repository.save(product);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		try {
			Optional<Product> opt = 
					repository.findById(product.getId());
			if (opt.isPresent()) {
				repository.save(product);
				return true;
			} else {
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
			Optional<Product> opt = repository.findById(pid);
			
			if (opt.isPresent()) {
				repository.deleteById(pid);
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
