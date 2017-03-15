package com.mystore.beans;

import java.util.List;

public class ProductCategoryBean {
	private int categoryID;
	private String categoryName;
	private List<SubCategoryBean> prodSubcategories;
	
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public List<SubCategoryBean> getProdSubcategories() {
		return prodSubcategories;
	}
	public void setProdSubcategories(List<SubCategoryBean> prodSubcategories) {
		this.prodSubcategories = prodSubcategories;
	}
}
