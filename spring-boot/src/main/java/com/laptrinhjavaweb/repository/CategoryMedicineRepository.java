
package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.CategoryMedicineEntity;

@Repository
public interface CategoryMedicineRepository extends JpaRepository<CategoryMedicineEntity, Long> {
	CategoryMedicineEntity findOneByName(String name);
}
