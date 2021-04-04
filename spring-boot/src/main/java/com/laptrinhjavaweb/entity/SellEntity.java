package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "sell")
public class SellEntity extends BaseEntity {
	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Long[] number_medicines;

	@Column
	private Long total_amount_cost;

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

	public Long[] getNumber_medicines() {
		return number_medicines;
	}

	public void setNumber_medicines(Long[] number_medicines) {
		this.number_medicines = number_medicines;
	}

	public Long getTotal_amount_cost() {
		return total_amount_cost;
	}

	public void setTotal_amount_cost(Long total_amount_cost) {
		this.total_amount_cost = total_amount_cost;
	}

}
