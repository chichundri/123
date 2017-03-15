package com.mystore.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the orderdetails database table.
 * 
 */
@Entity
@Table(name="orderdetails")
@NamedQuery(name="Orderdetail.findAll", query="SELECT o FROM Orderdetail o")
public class Orderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int detailID;

	private String detailName;

	private float detailPrice;

	private int detailQuantity;

	private String detailSKU;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="DetailOrderID")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="DetailProductID")
	private Product product;

	public Orderdetail() {
	}

	public int getDetailID() {
		return this.detailID;
	}

	public void setDetailID(int detailID) {
		this.detailID = detailID;
	}

	public String getDetailName() {
		return this.detailName;
	}

	public void setDetailName(String detailName) {
		this.detailName = detailName;
	}

	public float getDetailPrice() {
		return this.detailPrice;
	}

	public void setDetailPrice(float detailPrice) {
		this.detailPrice = detailPrice;
	}

	public int getDetailQuantity() {
		return this.detailQuantity;
	}

	public void setDetailQuantity(int detailQuantity) {
		this.detailQuantity = detailQuantity;
	}

	public String getDetailSKU() {
		return this.detailSKU;
	}

	public void setDetailSKU(String detailSKU) {
		this.detailSKU = detailSKU;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}