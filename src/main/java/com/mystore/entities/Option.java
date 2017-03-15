package com.mystore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the options database table.
 * 
 */
@Entity
@Table(name="options")
@NamedQuery(name="Option.findAll", query="SELECT o FROM Option o")
public class Option implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int optionID;

	private String optionName;

	//bi-directional many-to-one association to Optiongroup
	@ManyToOne
	@JoinColumn(name="OptionGroupID")
	private Optiongroup optiongroup;

	//bi-directional many-to-one association to Productoption
	@OneToMany(mappedBy="option")
	private List<Productoption> productoptions;

	public Option() {
	}

	public int getOptionID() {
		return this.optionID;
	}

	public void setOptionID(int optionID) {
		this.optionID = optionID;
	}

	public String getOptionName() {
		return this.optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public Optiongroup getOptiongroup() {
		return this.optiongroup;
	}

	public void setOptiongroup(Optiongroup optiongroup) {
		this.optiongroup = optiongroup;
	}

	public List<Productoption> getProductoptions() {
		return this.productoptions;
	}

	public void setProductoptions(List<Productoption> productoptions) {
		this.productoptions = productoptions;
	}

	public Productoption addProductoption(Productoption productoption) {
		getProductoptions().add(productoption);
		productoption.setOption(this);

		return productoption;
	}

	public Productoption removeProductoption(Productoption productoption) {
		getProductoptions().remove(productoption);
		productoption.setOption(null);

		return productoption;
	}

}