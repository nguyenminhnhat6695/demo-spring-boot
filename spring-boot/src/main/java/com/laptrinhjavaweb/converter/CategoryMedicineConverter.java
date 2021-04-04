package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryMedicineDTO;
import com.laptrinhjavaweb.entity.CategoryMedicineEntity;

@Component
public class CategoryMedicineConverter {

	/**
	 * Convert Entity to DTO
	 * @param categoryMedicineEntity
	 * @return
	 */
	public CategoryMedicineDTO toDto(CategoryMedicineEntity categoryMedicineEntity) {
		CategoryMedicineDTO categoryMedicineDTO = new CategoryMedicineDTO();
		categoryMedicineDTO.setId(categoryMedicineEntity.getId());
		categoryMedicineDTO.setName(categoryMedicineEntity.getName());
		categoryMedicineDTO.setDescription(categoryMedicineEntity.getDescription());
		return categoryMedicineDTO;
	}
	
	/**
	 * Convert DTO to Entity
	 * @param categoryMedicineEntity
	 * @return
	 */
	public CategoryMedicineEntity toEntity(CategoryMedicineDTO categoryMedicineDTO) {
		CategoryMedicineEntity categoryMedicineEntity = new CategoryMedicineEntity();
		categoryMedicineEntity.setName(categoryMedicineDTO.getName());
		categoryMedicineEntity.setDescription(categoryMedicineDTO.getDescription());
		return categoryMedicineEntity;
	}
	
	/**
	 * Convert DTO old to DTO new
	 * @param categoryMedicineEntity
	 * @return
	 */
	public CategoryMedicineEntity toEntityNew(CategoryMedicineEntity ctgMedEntityOld,CategoryMedicineEntity ctgMedEntityNew) {
		ctgMedEntityOld.setName(ctgMedEntityNew.getName());
		ctgMedEntityOld.setDescription(ctgMedEntityNew.getDescription());
		return ctgMedEntityOld;
	}
}
