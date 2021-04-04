package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//import com.laptrinhjavaweb.converter.NewConverter;
//import com.laptrinhjavaweb.dto.NewDTO;
//import com.laptrinhjavaweb.entity.CategoryEntity;
//import com.laptrinhjavaweb.entity.NewEntity;
//import com.laptrinhjavaweb.repository.CategoryRepository;
//import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService {

//	@Autowired
//	private NewRepository newRepository;
//
//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	@Autowired
//	private NewConverter newConverter;
//
//	@Override
//	public NewDTO save(NewDTO newDTO) {
//		NewEntity newEntity = new NewEntity();
//		if (newDTO.getId() != null) {
//			NewEntity oldNew = newRepository.findOne(newDTO.getId());
//			newEntity = newConverter.toEntity(oldNew, newDTO);
//		} else {
//			newEntity = newConverter.toEntity(newDTO);
//		}
//		CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
//		newEntity.setCategory(categoryEntity);
//		return newConverter.toDto(newRepository.save(newEntity));
//	}
//
//	@Override
//	public void delete(long[] ids) {
//		for (long id : ids) {
//			newRepository.delete(id);
//		}
//	}
//
//	@Override
//	public List<NewDTO> findAll(Pageable pageable) {
//
//		List<NewDTO> results = new ArrayList<NewDTO>();
//		List<NewEntity> entities = null;
//		if (pageable != null) {
//			entities = newRepository.findAll(pageable).getContent();
//		} else {
//			entities = newRepository.findAll();
//		}
//
//		for (NewEntity newEntity : entities) {
//			results.add(newConverter.toDto(newEntity));
//		}
//		return results;
//	}
//
//	@Override
//	public int totalItem() {
//		return (int) newRepository.count();
//	}
}
