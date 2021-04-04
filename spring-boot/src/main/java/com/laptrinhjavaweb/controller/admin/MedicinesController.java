package com.laptrinhjavaweb.controller.admin;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.laptrinhjavaweb.dto.CategoryMedicineDTO;
import com.laptrinhjavaweb.dto.MedicinesDTO;
import com.laptrinhjavaweb.service.CategoryMedicineService;
import com.laptrinhjavaweb.service.CompanyService;
import com.laptrinhjavaweb.service.MedicinesService;
import com.laptrinhjavaweb.util.AppConstants;
import com.laptrinhjavaweb.util.MessageUtil;

@RestController(value = "MedicinesControllerOfAdmin")
@RequestMapping("/admin/")
public class MedicinesController {

	//----------------------------------------------
	// Inject beans into this controller class
	//----------------------------------------------
	@Autowired
	private MedicinesService medicinesService;

	@Autowired
	@Qualifier("CategoryMedicineServiceImpl")
	private CategoryMedicineService categoryMedicineService;
	
	@Autowired
	private CompanyService companyService;
	
	@Autowired
	private MessageUtil messageUtil;

	
	//----------------------------------------------
	// Control get list
	//----------------------------------------------
	/**
	 * 	Xử lý get list thuốc
	 */
	@GetMapping(value = "medicine-list")
	public ModelAndView medicineListAdmin(
			@RequestParam("page") int page,
			@RequestParam(value = "limit", required = false) Integer limit,
			@RequestParam(value = "medicine_name", required = false) String name,
			HttpServletRequest request) {
		
		// Handle add address to file listMedicines.jsp
		ModelAndView modelAndView = new ModelAndView("admin/medicines/listMedicines");
		
		// Create and add data from request into object MedicinesDTO
		MedicinesDTO medicinesDTO = new MedicinesDTO();
		medicinesDTO.setName_search(name);
		medicinesDTO.setPage(page);
		medicinesDTO.setLimit(AppConstants.LIMIT_PAGE);
		if (limit == null) {
			limit = AppConstants.LIMIT_PAGE;
		}
		
		// Handle page is 0
		if (page <= 0) {
			Map<String, String> message = messageUtil.getMessage("page_is_zero");
			modelAndView.addObject("medicinesDTO", new MedicinesDTO());
			modelAndView.addObject("message", message.get("message"));
			modelAndView.addObject("alert", message.get("alert"));
			return modelAndView;
		}
		
		// Handle phân trang follow page
		Pageable pageable = new PageRequest(page - 1, limit);
		medicinesDTO.setListResult(medicinesService.findAllByNameContaining(name,pageable));
		medicinesDTO.setTotalPage((int) Math.ceil((double) medicinesService.getTotalItem(name) / limit));
		
		//Handle logic page default
		if (medicinesService.getPageDefault()) {
			medicinesDTO.setPage(1);
		}
		
		modelAndView.addObject("medicinesDTO", medicinesDTO);
		if (request.getParameter("message") != null) {
			Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
			modelAndView.addObject("message", message.get("message"));
			modelAndView.addObject("alert", message.get("alert"));
		}
		return modelAndView;
	}

	/**
	 * 	Xử lý get 1 list những loại thuốc
	 */
	@GetMapping(value="categoryMed-list")
	public ModelAndView categoryMed() {
		ModelAndView modalAndView = new ModelAndView("admin/category_med/listCategoryMed");
		CategoryMedicineDTO categoryMedicineDTO = new CategoryMedicineDTO();

		categoryMedicineDTO.setListResult(categoryMedicineService.findAllCtgMed());
		modalAndView.addObject("ctgMedList",categoryMedicineDTO);
		return modalAndView;
	}
	
	//----------------------------------------------
	// Control get element by id
	//----------------------------------------------
	/**
	 * 	Xử lý get 1 loại thuốc dựa vào id
	 */
	@GetMapping(value = "medicine-edit")
	public ModelAndView medicineEditAdmin(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/admin/medicines/edit");
		MedicinesDTO medicinesDTO = new MedicinesDTO();
		if (id != null) {
			medicinesDTO = medicinesService.findById(id);
		}
		modelAndView.addObject("companyList", companyService.findAll());
		modelAndView.addObject("categoryMedicineList", categoryMedicineService.findAll());
		modelAndView.addObject("medicinesDTO", medicinesDTO);
		return modelAndView; 
	}

	@GetMapping(value="categoryMed-edit")
	public ModelAndView categoryMedEditAdmin(@RequestParam(value = "id", required = false) Long id,
			HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/admin/category_med/edit");
		CategoryMedicineDTO categoryMedicineDTO = new CategoryMedicineDTO();
		if (!StringUtils.isEmpty(id)) {
			categoryMedicineDTO = categoryMedicineService.findById(id);
		}
		modelAndView.addObject("categoryMedicineDTO",categoryMedicineDTO);
		return modelAndView;
	}
	
	//----------------------------------------------
	// Control add new
	//----------------------------------------------
	/**
	 * 	Xử lý add new 1 liều thuốc
	 */
	@PostMapping(value = "medicine-new")
	public MedicinesDTO addNewAdmin(@RequestBody MedicinesDTO medicinesDTO) {
		return medicinesService.save(medicinesDTO);
	}
	
	/**
	 * 	Xử lý add new 1 loại thuốc
	 */
	@PostMapping(value = "categoryMed-new")
	public CategoryMedicineDTO addNewCategoryMedAdmin(@RequestBody CategoryMedicineDTO categoryMedicineDTO) {
		return categoryMedicineService.save(categoryMedicineDTO);
	}

	//----------------------------------------------
	// Control modify
	//----------------------------------------------
	/**
	 * 	Xử lý modify 1 liều thuốc
	 */
	@PutMapping(value = "medicine-update")
	public MedicinesDTO updateNew(@RequestBody MedicinesDTO medicinesDTO) {
		return medicinesService.save(medicinesDTO);
	}
	
	/**
	 * 	Xử lý modify 1 loại thuốc
	 */
	@PutMapping(value = "categoryMed-update")
	public CategoryMedicineDTO updateNewCategoryMedAdmin(@RequestBody CategoryMedicineDTO categoryMedicineDTO) {
		return categoryMedicineService.save(categoryMedicineDTO);
	}

	//----------------------------------------------
	// Control delete
	//----------------------------------------------
	/**
	 * 	Xử lý xóa 1 liều thuốc
	 */
	@DeleteMapping(value = "medicine-delete")
	public void deleteNew(@RequestBody long[] ids) {
		medicinesService.delete(ids);
	}
	
	/**
	 * 	Xử lý xóa 1 loại thuốc
	 */
	@DeleteMapping(value = "categoryMed-delete")
	public void deleteCategoryMedAdmin(@RequestBody long[] ids) {
		categoryMedicineService.delete(ids);
	}
}
