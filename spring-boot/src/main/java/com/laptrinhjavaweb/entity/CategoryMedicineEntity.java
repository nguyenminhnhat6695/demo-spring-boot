package com.laptrinhjavaweb.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category_medicine")
public class CategoryMedicineEntity extends BaseEntity {
	@Column
	private String name;
	@Column
	private String description;

	@OneToMany(mappedBy = "category_medicine")
	private List<MedicinesEntity> medicines = new ArrayList<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<MedicinesEntity> getMedicines() {
		return medicines;
	}

	public void setMedicines(List<MedicinesEntity> medicines) {
		this.medicines = medicines;
	}

}
