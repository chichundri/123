package com.mystore.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the productoptions database table.
 * 
 */
@Entity
@Table(name="productoptions")
@NamedQuery(name="Productoption.findAll", query="SELECT p FROM Productoption p")
public class Productoption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productOptionID;

	private int optionGroupID;

	private double optionPriceIncrement;

	//bi-directional many-to-one association to Option
	@ManyToOne
	@JoinColumn(name="OptionID")
	private Option option;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="ProductID")
	private Product product;

	public Productoption() {
	}

	public int getProductOptionID() {
		return this.productOptionID;
	}

	public void setProductOptionID(int productOptionID) {
		this.productOptionID = productOptionID;
	}

	public int getOptionGroupID() {
		return this.optionGroupID;
	}

	public void setOptionGroupID(int optionGroupID) {
		this.optionGroupID = optionGroupID;
	}

	public double getOptionPriceIncrement() {
		return this.optionPriceIncrement;
	}

	public void setOptionPriceIncrement(double optionPriceIncrement) {
		this.optionPriceIncrement = optionPriceIncrement;
	}

	public Option getOption() {
		return this.option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}