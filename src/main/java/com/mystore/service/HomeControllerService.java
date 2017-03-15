package com.mystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystore.beans.ProductCategoryBean;
import com.mystore.dao.HomeControllerDao;
import com.mystore.entities.User;

@Service
public class HomeControllerService {
	@Autowired
	HomeControllerDao homeControllerDao;
	
	public List<ProductCategoryBean> loadHomePage(){
		return homeControllerDao.loadHomePage();
	}

	public boolean signUp(User user) {
		return homeControllerDao.signUp(user);
	}
}
