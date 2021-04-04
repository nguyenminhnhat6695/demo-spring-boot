package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.CategoryMedicineConverter;
import com.laptrinhjavaweb.dto.CategoryMedicineDTO;
import com.laptrinhjavaweb.entity.CategoryMedicineEntity;
import com.laptrinhjavaweb.repository.CategoryMedicineRepository;
import com.laptrinhjavaweb.service.CategoryMedicineService;

@Service("CategoryMedicineServiceImpl")
public class CategoryMedicineServiceImpl implements CategoryMedicineService {

	@Autowired
	private CategoryMedicineRepository categoryMedicineRepository;
	
	@Autowired
	private CategoryMedicineConverter categoryMedicineConverter;
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryMedicineEntity> entities = categoryMedicineRepository.findAll();
		for (CategoryMedicineEntity item: entities) {
			result.put(item.getName(), item.getDescription());
		}
		return result;
	}

	/**
	 * Handle get all category medicine
 	 */
	@Override
	public List<CategoryMedicineDTO> findAllCtgMed() {
		 List<CategoryMedicineEntity> entities = categoryMedicineRepository.findAll();
		 List<CategoryMedicineDTO> ctdMedDtoList = new ArrayList<CategoryMedicineDTO>();
		 
		 for(CategoryMedicineEntity item : entities) {
			 ctdMedDtoList.add(categoryMedicineConverter.toDto(item));
		 }
		return ctdMedDtoList;
	}

	/**
	 * Handle get a category medicine
 	 */
	@Override
	public CategoryMedicineDTO findById(Long id) {
		CategoryMedicineEntity categoryMedicineEntity = categoryMedicineRepository.findOne(id);
		return categoryMedicineConverter.toDto(categoryMedicineEntity);
	}

	/**
	 * Handle add or mofidy category medicine
 	 */
	@Override
	@Transactional
	public CategoryMedicineDTO save(CategoryMedicineDTO categoryMedicineDTO) {
		// Convert DTO new to Entity
		CategoryMedicineEntity ctgMedEntityNew = categoryMedicineConverter.toEntity(categoryMedicineDTO);
		
		if (categoryMedicineDTO.getId() != null) {
			// Get category medicine by id old
			CategoryMedicineEntity ctgMedEntityOld = categoryMedicineRepository.findOne(categoryMedicineDTO.getId());
			ctgMedEntityNew = categoryMedicineConverter.toEntityNew(ctgMedEntityOld,ctgMedEntityNew);
		}
		
		return categoryMedicineConverter.toDto(categoryMedicineRepository.save(ctgMedEntityNew));
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			categoryMedicineRepository.delete(id);
		}
	}
	
}
