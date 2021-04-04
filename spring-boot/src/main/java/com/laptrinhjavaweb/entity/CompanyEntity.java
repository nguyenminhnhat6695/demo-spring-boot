package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyEntity extends BaseEntity {
	@Column
	private String name;

	@Column
	private String type;

	@Column
	private String description;

	@Column
	private String address;

	@OneToMany(mappedBy = "company")
	private List<MedicinesEntity> medicines = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<MedicinesEntity> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<MedicinesEntity> medicines) {
		this.medicines = medicines;
	}

}
