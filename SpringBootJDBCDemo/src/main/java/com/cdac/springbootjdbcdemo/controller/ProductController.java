package com.cdac.springbootjdbcdemo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.springbootjdbcdemo.dao.ProductDao;
import com.cdac.springbootjdbcdemo.pojo.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductDao daoImpl;
	
	@GetMapping("/getall")
	public List<Product> getAll() {
		
		List<Product> lst = daoImpl.getAllProducts();
		return lst;
	}
	
	@GetMapping("/find")
	public Product findProduct(@RequestParam("id") int pid) {
		Product product = daoImpl.searchProduct(pid);
		return product;
	}
	
	@PostMapping("/addnew")
	public HashMap<String, String> addNew(@RequestBody Product product) {
		HashMap<String, String> hmap = new HashMap<>();
		if (daoImpl.addNewProduct(product)) {
			hmap.put("message", "success");
		} else {
			hmap.put("message", "failure");
		}
		return hmap;
	}
	
	@PutMapping("/update")
	public HashMap<String, String> updateProduct(@RequestBody Product product) {
		HashMap <String, String> hmap = new HashMap<>();
		
		if (daoImpl.updateProduct(product)) {
			hmap.put("message", "success");
		} else {
			hmap.put("message", "failure");
		}
		return hmap;
	}
	
	@DeleteMapping("/delete/{id}")
	public HashMap<String, String> deleteProduct(@PathVariable("id") int pid) {
		HashMap <String, String> hmap = new HashMap<>();
		
		if (daoImpl.deleteProduct(pid)) {
			hmap.put("message", "success");
		} else {
			hmap.put("message", "failure");
		}
		return hmap;
	}
}
