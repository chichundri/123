package com.mystore.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the productcategories database table.
 * 
 */
@Entity
@Table(name="PRODUCTCATEGORIES")
public class Productcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int categoryID;

	private String categoryName;

	//bi-directional many-to-one association to ProdSubcategory
	@OneToMany(fetch=FetchType.EAGER, mappedBy="productcategory")
	private List<ProdSubcategory> prodSubcategories;

	public Productcategory() {
	}

	public int getCategoryID() {
		return this.categoryID;
	}

	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public List<ProdSubcategory> getProdSubcategories() {
		return this.prodSubcategories;
	}

	public void setProdSubcategories(List<ProdSubcategory> prodSubcategories) {
		this.prodSubcategories = prodSubcategories;
	}

	public ProdSubcategory addProdSubcategory(ProdSubcategory prodSubcategory) {
		getProdSubcategories().add(prodSubcategory);
		prodSubcategory.setProductcategory(this);

		return prodSubcategory;
	}

	public ProdSubcategory removeProdSubcategory(ProdSubcategory prodSubcategory) {
		getProdSubcategories().remove(prodSubcategory);
		prodSubcategory.setProductcategory(null);

		return prodSubcategory;
	}

}