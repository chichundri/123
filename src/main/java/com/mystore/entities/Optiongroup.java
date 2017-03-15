package com.mystore.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the optiongroups database table.
 * 
 */
@Entity
@Table(name="optiongroups")
@NamedQuery(name="Optiongroup.findAll", query="SELECT o FROM Optiongroup o")
public class Optiongroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int optionGroupID;

	private String optionGroupName;

	//bi-directional many-to-one association to Option
	@OneToMany(mappedBy="optiongroup")
	private List<Option> options;

	public Optiongroup() {
	}

	public int getOptionGroupID() {
		return this.optionGroupID;
	}

	public void setOptionGroupID(int optionGroupID) {
		this.optionGroupID = optionGroupID;
	}

	public String getOptionGroupName() {
		return this.optionGroupName;
	}

	public void setOptionGroupName(String optionGroupName) {
		this.optionGroupName = optionGroupName;
	}

	public List<Option> getOptions() {
		return this.options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

	public Option addOption(Option option) {
		getOptions().add(option);
		option.setOptiongroup(this);

		return option;
	}

	public Option removeOption(Option option) {
		getOptions().remove(option);
		option.setOptiongroup(null);

		return option;
	}

}