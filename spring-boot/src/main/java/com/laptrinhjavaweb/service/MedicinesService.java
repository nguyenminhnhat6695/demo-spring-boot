package com.laptrinhjavaweb.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.MedicinesDTO;

public interface MedicinesService {
	
	boolean getPageDefault();
	
	List<MedicinesDTO> findAllByNameContaining(String name, Pageable pageable);
	
	MedicinesDTO save(MedicinesDTO medicinesDTO);
	
	void delete(long[] ids);
	
	int getTotalItem(String name);
	
	MedicinesDTO findById(long id);
}    
