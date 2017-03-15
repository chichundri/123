package com.mystore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productID;

	private String productCartDesc;

	private String productImage;

	private byte productLive;

	private String productLocation;

	@Lob
	private String productLongDesc;

	private String productName;

	private String productOwner;

	private float productPrice;

	private String productShortDesc;

	private String productSKU;

	private float productStock;

	private String productThumb;

	private byte productUnlimited;

	private Timestamp productUpdateDate;

	private float productWeight;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="product")
	private List<Orderdetail> orderdetails;

	//bi-directional many-to-one association to Productoption
	@OneToMany(mappedBy="product")
	private List<Productoption> productoptions;

	//bi-directional many-to-one association to ProdSubcategory
	@ManyToOne
	@JoinColumn(name="ProductSubCategoryId")
	private ProdSubcategory prodSubcategory;

	public Product() {
	}

	public int getProductID() {
		return this.productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductCartDesc() {
		return this.productCartDesc;
	}

	public void setProductCartDesc(String productCartDesc) {
		this.productCartDesc = productCartDesc;
	}

	public String getProductImage() {
		return this.productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public byte getProductLive() {
		return this.productLive;
	}

	public void setProductLive(byte productLive) {
		this.productLive = productLive;
	}

	public String getProductLocation() {
		return this.productLocation;
	}

	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}

	public String getProductLongDesc() {
		return this.productLongDesc;
	}

	public void setProductLongDesc(String productLongDesc) {
		this.productLongDesc = productLongDesc;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductOwner() {
		return this.productOwner;
	}

	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}

	public float getProductPrice() {
		return this.productPrice;
	}

	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductShortDesc() {
		return this.productShortDesc;
	}

	public void setProductShortDesc(String productShortDesc) {
		this.productShortDesc = productShortDesc;
	}

	public String getProductSKU() {
		return this.productSKU;
	}

	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}

	public float getProductStock() {
		return this.productStock;
	}

	public void setProductStock(float productStock) {
		this.productStock = productStock;
	}

	public String getProductThumb() {
		return this.productThumb;
	}

	public void setProductThumb(String productThumb) {
		this.productThumb = productThumb;
	}

	public byte getProductUnlimited() {
		return this.productUnlimited;
	}

	public void setProductUnlimited(byte productUnlimited) {
		this.productUnlimited = productUnlimited;
	}

	public Timestamp getProductUpdateDate() {
		return this.productUpdateDate;
	}

	public void setProductUpdateDate(Timestamp productUpdateDate) {
		this.productUpdateDate = productUpdateDate;
	}

	public float getProductWeight() {
		return this.productWeight;
	}

	public void setProductWeight(float productWeight) {
		this.productWeight = productWeight;
	}

	public List<Orderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Orderdetail addOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().add(orderdetail);
		orderdetail.setProduct(this);

		return orderdetail;
	}

	public Orderdetail removeOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().remove(orderdetail);
		orderdetail.setProduct(null);

		return orderdetail;
	}

	public List<Productoption> getProductoptions() {
		return this.productoptions;
	}

	public void setProductoptions(List<Productoption> productoptions) {
		this.productoptions = productoptions;
	}

	public Productoption addProductoption(Productoption productoption) {
		getProductoptions().add(productoption);
		productoption.setProduct(this);

		return productoption;
	}

	public Productoption removeProductoption(Productoption productoption) {
		getProductoptions().remove(productoption);
		productoption.setProduct(null);

		return productoption;
	}

	public ProdSubcategory getProdSubcategory() {
		return this.prodSubcategory;
	}

	public void setProdSubcategory(ProdSubcategory prodSubcategory) {
		this.prodSubcategory = prodSubcategory;
	}

}