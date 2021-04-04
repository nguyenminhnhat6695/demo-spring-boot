package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.converter.MedicinesConverter;
import com.laptrinhjavaweb.dto.MedicinesDTO;
import com.laptrinhjavaweb.entity.CategoryMedicineEntity;
import com.laptrinhjavaweb.entity.CompanyEntity;
import com.laptrinhjavaweb.entity.MedicinesEntity;
import com.laptrinhjavaweb.repository.CategoryMedicineRepository;
import com.laptrinhjavaweb.repository.CompanyRepository;
import com.laptrinhjavaweb.repository.MedicinesRepository;
import com.laptrinhjavaweb.service.MedicinesService;
import com.laptrinhjavaweb.util.AppConstants;

@Service
public class MedicinesServiceImpl implements MedicinesService {
	
	public boolean hasPageDefault = false;
	
	@Autowired
	private MedicinesRepository medicinesRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CategoryMedicineRepository categoryMedicineRepository;

	@Autowired
	private MedicinesConverter medicinesConverter;

	@Override
	public List<MedicinesDTO> findAllByNameContaining(String name, Pageable pageable) {
		List<MedicinesEntity> medicinesEntityLst = null;
		if (name != null && !"".equals(name)) {
			medicinesEntityLst = medicinesRepository.findAllByname(name,pageable).getContent();
			if (pageable.getPageNumber() > 0 && medicinesEntityLst.isEmpty()) {
				pageable = new PageRequest(0, AppConstants.LIMIT_PAGE);
				hasPageDefault = true;
				medicinesEntityLst = medicinesRepository.findAllByname(name,pageable).getContent();
			}
		} else {
			medicinesEntityLst = medicinesRepository.findAll(pageable).getContent();
		}
		List<MedicinesDTO> medicinesDTOList = new ArrayList<MedicinesDTO>();
		MedicinesDTO medicinesDTO = null;
		for (MedicinesEntity medicinesEntity : medicinesEntityLst) {
			medicinesDTO = new MedicinesDTO();
			medicinesDTO = medicinesConverter.toDto(medicinesEntity);
			medicinesDTO.setDescription(medicinesDTO.getDescription().replace("\n", "<br>"));
			medicinesDTO.setComposition(medicinesDTO.getComposition().replace("\n", "<br>"));
			medicinesDTOList.add(medicinesDTO);
		}
		return medicinesDTOList;
	}

	@Override
	public int getTotalItem(String name) {
		int count = 0;
		if (name != null && !"".equals(name)) {
			count = (int ) medicinesRepository.countAllByname(name);
		} else {
			count = (int ) medicinesRepository.count();
		}
		
		return count;
	}

	@Override
	public MedicinesDTO findById(long id) {
		MedicinesEntity medicinesEntity = medicinesRepository.findOne(id);
		return medicinesConverter.toDto(medicinesEntity);
	}

	@Override
	@Transactional
	public MedicinesDTO save(MedicinesDTO medicinesDTO) {
		CompanyEntity companyEntity = companyRepository.findOneByName(medicinesDTO.getCompany_name());
		CategoryMedicineEntity categoryMedicineEntity = categoryMedicineRepository
				.findOneByName(medicinesDTO.getCategory_medicine_name());
		MedicinesEntity medicinesEntity = new MedicinesEntity();
		if (medicinesDTO.getId() != null) {
			MedicinesEntity medicinesEntityOld = medicinesRepository.findOne(medicinesDTO.getId());
			medicinesEntityOld.setCompany(companyEntity);
			medicinesEntityOld.setCategory_medicine(categoryMedicineEntity);
			medicinesEntity = medicinesConverter.toEntity(medicinesEntityOld, medicinesDTO);
		} else {
			medicinesEntity = medicinesConverter.toEntity(medicinesDTO);
			medicinesEntity.setCompany(companyEntity);
			medicinesEntity.setCategory_medicine(categoryMedicineEntity);
			
		}
		
		MedicinesDTO medicinesDTONew = medicinesConverter.toDto(medicinesRepository.save(medicinesEntity));
		return medicinesDTONew;
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for (long id: ids) {
			medicinesRepository.delete(id);
		}
	}

	@Override
	public boolean getPageDefault() {
		return this.hasPageDefault;
	}
}
