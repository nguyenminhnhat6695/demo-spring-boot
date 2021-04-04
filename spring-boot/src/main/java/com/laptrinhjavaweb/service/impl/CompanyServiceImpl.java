package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.CompanyEntity;
import com.laptrinhjavaweb.repository.CompanyRepository;
import com.laptrinhjavaweb.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Map<String, String> findAll() {
		Map<String, String> result = new HashMap<>();
		List<CompanyEntity> entities = companyRepository.findAll();
		for (CompanyEntity item: entities) {
			result.put(item.getName(), item.getDescription());
		}
		return result;
	}

}
