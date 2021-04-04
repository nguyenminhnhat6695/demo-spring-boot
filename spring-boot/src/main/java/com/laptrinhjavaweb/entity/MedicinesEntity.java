package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "medicines")
public class MedicinesEntity extends BaseEntity {
	@Column
	private String name;

	@Column
	private String composition;

	@Column
	private String cost;

	@Column
	private String unit;

	@Column
	private String description;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id")
	private CompanyEntity company;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_medicine_id")
	private CategoryMedicineEntity category_medicine;

	@OneToOne(mappedBy = "medicines_stocks")
	private StocksEntity stocks;

	@OneToOne(mappedBy = "medicines_inventory")
	private InventoryEntity inventory;

	@Column
	private String manufactureOfDate;

	@Column
	private String expiryDate;

	@Column
	private String lotNumber;

	@Column
	private String image;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CompanyEntity getCompany() {
		return company;
	}

	public void setCompany(CompanyEntity company) {
		this.company = company;
	}

	public CategoryMedicineEntity getCategory_medicine() {
		return category_medicine;
	}

	public void setCategory_medicine(CategoryMedicineEntity category_medicine) {
		this.category_medicine = category_medicine;
	}

	public StocksEntity getStocks() {
		return stocks;
	}

	public void setStocks(StocksEntity stocks) {
		this.stocks = stocks;
	}

	public InventoryEntity getInventory() {
		return inventory;
	}

	public void setInventory(InventoryEntity inventory) {
		this.inventory = inventory;
	}

	public String getManufactureOfDate() {
		return manufactureOfDate;
	}

	public void setManufactureOfDate(String manufactureOfDate) {
		this.manufactureOfDate = manufactureOfDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getLotNumber() {
		return lotNumber;
	}

	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
