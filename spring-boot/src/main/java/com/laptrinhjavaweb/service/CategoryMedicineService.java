package com.laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.dto.CategoryMedicineDTO;

public interface CategoryMedicineService {
	Map<String, String> findAll();
	
	List<CategoryMedicineDTO> findAllCtgMed();
	
	CategoryMedicineDTO findById(Long id);
	
	CategoryMedicineDTO save(CategoryMedicineDTO categoryMedicineDTO);
	
	void delete(long[] ids);
}
