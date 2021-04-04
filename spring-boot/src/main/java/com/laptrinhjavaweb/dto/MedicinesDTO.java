package com.laptrinhjavaweb.dto;

import org.springframework.web.multipart.MultipartFile;

public class MedicinesDTO extends AbstractDTO<MedicinesDTO> {
	private String name;

	private String composition;

	private String cost;

	private String unit;

	private String description;

	private String company_name;

	private String company_description;

	private String category_medicine_name;

	private String category_medicine_description;

	private CompanyDTO company;

	private CategoryMedicineDTO category_medicine;

	private String manufactureOfDate;

	private String expiryDate;

	private String lotNumber;

	private MultipartFile[] files;

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

	public CompanyDTO getCompany() {
		return company;
	}

	public void setCompany(CompanyDTO company) {
		this.company = company;
	}

	public CategoryMedicineDTO getCategory_medicine() {
		return category_medicine;
	}

	public void setCategory_medicine(CategoryMedicineDTO category_medicine) {
		this.category_medicine = category_medicine;
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

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCategory_medicine_name() {
		return category_medicine_name;
	}

	public void setCategory_medicine_name(String category_medicine_name) {
		this.category_medicine_name = category_medicine_name;
	}

	public String getCompany_description() {
		return company_description;
	}

	public void setCompany_description(String company_description) {
		this.company_description = company_description;
	}

	public String getCategory_medicine_description() {
		return category_medicine_description;
	}

	public void setCategory_medicine_description(String category_medicine_description) {
		this.category_medicine_description = category_medicine_description;
	}

}
