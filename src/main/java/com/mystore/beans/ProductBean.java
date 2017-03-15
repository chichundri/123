package com.mystore.beans;

import java.sql.Timestamp;
import java.util.List;

import com.mystore.entities.Orderdetail;
import com.mystore.entities.ProdSubcategory;
import com.mystore.entities.Productoption;

public class ProductBean {
	private int productID;
	private String productCartDesc;
	private String productImage;
	private byte productLive;
	private String productLocation;
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
	private List<Orderdetail> orderdetails;
	private List<Productoption> productoptions;
	private ProdSubcategory prodSubcategory;
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductCartDesc() {
		return productCartDesc;
	}
	public void setProductCartDesc(String productCartDesc) {
		this.productCartDesc = productCartDesc;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public byte getProductLive() {
		return productLive;
	}
	public void setProductLive(byte productLive) {
		this.productLive = productLive;
	}
	public String getProductLocation() {
		return productLocation;
	}
	public void setProductLocation(String productLocation) {
		this.productLocation = productLocation;
	}
	public String getProductLongDesc() {
		return productLongDesc;
	}
	public void setProductLongDesc(String productLongDesc) {
		this.productLongDesc = productLongDesc;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductOwner() {
		return productOwner;
	}
	public void setProductOwner(String productOwner) {
		this.productOwner = productOwner;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductShortDesc() {
		return productShortDesc;
	}
	public void setProductShortDesc(String productShortDesc) {
		this.productShortDesc = productShortDesc;
	}
	public String getProductSKU() {
		return productSKU;
	}
	public void setProductSKU(String productSKU) {
		this.productSKU = productSKU;
	}
	public float getProductStock() {
		return productStock;
	}
	public void setProductStock(float productStock) {
		this.productStock = productStock;
	}
	public String getProductThumb() {
		return productThumb;
	}
	public void setProductThumb(String productThumb) {
		this.productThumb = productThumb;
	}
	public byte getProductUnlimited() {
		return productUnlimited;
	}
	public void setProductUnlimited(byte productUnlimited) {
		this.productUnlimited = productUnlimited;
	}
	public Timestamp getProductUpdateDate() {
		return productUpdateDate;
	}
	public void setProductUpdateDate(Timestamp productUpdateDate) {
		this.productUpdateDate = productUpdateDate;
	}
	public float getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(float productWeight) {
		this.productWeight = productWeight;
	}
	public List<Orderdetail> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}
	public List<Productoption> getProductoptions() {
		return productoptions;
	}
	public void setProductoptions(List<Productoption> productoptions) {
		this.productoptions = productoptions;
	}
	public ProdSubcategory getProdSubcategory() {
		return prodSubcategory;
	}
	public void setProdSubcategory(ProdSubcategory prodSubcategory) {
		this.prodSubcategory = prodSubcategory;
	}
	
}
