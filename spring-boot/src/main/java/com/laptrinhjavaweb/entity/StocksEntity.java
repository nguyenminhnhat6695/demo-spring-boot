package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class StocksEntity extends BaseEntity {
	@Column
	private String number;

	@Column
	private String name;

	@Column
	private String description;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicine_id")
	private MedicinesEntity medicines_stocks;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

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

	public MedicinesEntity getMedicines_stocks() {
		return medicines_stocks;
	}

	public void setMedicines_stocks(MedicinesEntity medicines_stocks) {
		this.medicines_stocks = medicines_stocks;
	}

}
