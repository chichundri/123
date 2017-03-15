package com.mystore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mystore.beans.ProductCategoryBean;
import com.mystore.entities.User;
import com.mystore.service.HomeControllerService;

@Controller
public class HomeController {
	
	@Autowired
	HomeControllerService homeControllerService;
	
	@RequestMapping(value = "/")
	public ModelAndView loadHomePage(Model map) {
		List<ProductCategoryBean> productCategory = homeControllerService.loadHomePage();
		return new ModelAndView("index", "productCategory", productCategory);
	}
	
	@RequestMapping(value = "signUp",method = RequestMethod.POST)
	@ResponseBody
	public String signUp(@RequestBody User user) {
		boolean status = homeControllerService.signUp(user);
		if(status){
			return "Success";
		}
		return "failure";
	}
	
}
