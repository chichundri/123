package com.mystore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prod_subcategory database table.
 * 
 */
@Entity
@Table(name="prod_subcategory")
@NamedQuery(name="ProdSubcategory.findAll", query="SELECT p FROM ProdSubcategory p")
public class ProdSubcategory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="subcategory_id")
	private int subcategoryId;

	@Column(name="short_desc")
	private String shortDesc;

	@Column(name="subcategory_name")
	private String subcategoryName;

	//bi-directional many-to-one association to Productcategory
	@ManyToOne
	@JoinColumn(name="productCategoryId")
	private Productcategory productcategory;

	//bi-directional many-to-one association to Product
	@OneToMany(fetch=FetchType.EAGER,mappedBy="prodSubcategory")
	private List<Product> products;

	public ProdSubcategory() {
	}

	public int getSubcategoryId() {
		return this.subcategoryId;
	}

	public void setSubcategoryId(int subcategoryId) {
		this.subcategoryId = subcategoryId;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

	public String getSubcategoryName() {
		return this.subcategoryName;
	}

	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}

	public Productcategory getProductcategory() {
		return this.productcategory;
	}

	public void setProductcategory(Productcategory productcategory) {
		this.productcategory = productcategory;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setProdSubcategory(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setProdSubcategory(null);

		return product;
	}

}