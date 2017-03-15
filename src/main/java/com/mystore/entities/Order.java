package com.mystore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the orders database table.
 * 
 */
@Entity
@Table(name="orders")
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderID;

	private float orderAmount;

	private String orderCity;

	private String orderCountry;

	private Timestamp orderDate;

	private String orderEmail;

	private String orderFax;

	private String orderPhone;

	private String orderShipAddress;

	private String orderShipAddress2;

	private String orderShipName;

	private byte orderShipped;

	private float orderShipping;

	private String orderState;

	private float orderTax;

	private String orderTrackingNumber;

	private String orderZip;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="order")
	private List<Orderdetail> orderdetails;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="OrderUserID")
	private User user;

	public Order() {
	}

	public int getOrderID() {
		return this.orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public float getOrderAmount() {
		return this.orderAmount;
	}

	public void setOrderAmount(float orderAmount) {
		this.orderAmount = orderAmount;
	}

	public String getOrderCity() {
		return this.orderCity;
	}

	public void setOrderCity(String orderCity) {
		this.orderCity = orderCity;
	}

	public String getOrderCountry() {
		return this.orderCountry;
	}

	public void setOrderCountry(String orderCountry) {
		this.orderCountry = orderCountry;
	}

	public Timestamp getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderEmail() {
		return this.orderEmail;
	}

	public void setOrderEmail(String orderEmail) {
		this.orderEmail = orderEmail;
	}

	public String getOrderFax() {
		return this.orderFax;
	}

	public void setOrderFax(String orderFax) {
		this.orderFax = orderFax;
	}

	public String getOrderPhone() {
		return this.orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getOrderShipAddress() {
		return this.orderShipAddress;
	}

	public void setOrderShipAddress(String orderShipAddress) {
		this.orderShipAddress = orderShipAddress;
	}

	public String getOrderShipAddress2() {
		return this.orderShipAddress2;
	}

	public void setOrderShipAddress2(String orderShipAddress2) {
		this.orderShipAddress2 = orderShipAddress2;
	}

	public String getOrderShipName() {
		return this.orderShipName;
	}

	public void setOrderShipName(String orderShipName) {
		this.orderShipName = orderShipName;
	}

	public byte getOrderShipped() {
		return this.orderShipped;
	}

	public void setOrderShipped(byte orderShipped) {
		this.orderShipped = orderShipped;
	}

	public float getOrderShipping() {
		return this.orderShipping;
	}

	public void setOrderShipping(float orderShipping) {
		this.orderShipping = orderShipping;
	}

	public String getOrderState() {
		return this.orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	}

	public float getOrderTax() {
		return this.orderTax;
	}

	public void setOrderTax(float orderTax) {
		this.orderTax = orderTax;
	}

	public String getOrderTrackingNumber() {
		return this.orderTrackingNumber;
	}

	public void setOrderTrackingNumber(String orderTrackingNumber) {
		this.orderTrackingNumber = orderTrackingNumber;
	}

	public String getOrderZip() {
		return this.orderZip;
	}

	public void setOrderZip(String orderZip) {
		this.orderZip = orderZip;
	}

	public List<Orderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Orderdetail addOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().add(orderdetail);
		orderdetail.setOrder(this);

		return orderdetail;
	}

	public Orderdetail removeOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().remove(orderdetail);
		orderdetail.setOrder(null);

		return orderdetail;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}