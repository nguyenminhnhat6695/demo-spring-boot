package com.laptrinhjavaweb.converter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.laptrinhjavaweb.dto.MedicinesDTO;
import com.laptrinhjavaweb.entity.MedicinesEntity;
import com.laptrinhjavaweb.util.UploadFilesUtils;

@Component
public class MedicinesConverter {

	private static final String FORMAT_DATE = "dd/MM/yyyy";

	public MedicinesDTO toDto(MedicinesEntity medicinesEntity) {
		MedicinesDTO medicinesDTO = new MedicinesDTO();
		medicinesDTO.setId(medicinesEntity.getId());
		medicinesDTO.setName(medicinesEntity.getName());
		medicinesDTO.setComposition(medicinesEntity.getComposition());
		medicinesDTO.setCost(medicinesEntity.getCost());
		medicinesDTO.setDescription(medicinesEntity.getDescription());
		medicinesDTO.setLotNumber(medicinesEntity.getLotNumber());
		// medicinesDTO.setImage(medicinesEntity.getImage());
		medicinesDTO.setUnit(medicinesEntity.getUnit());

		// Convert name file to Multipart File
		if (!StringUtils.isEmpty(medicinesEntity.getImage())) {
			medicinesDTO.setFiles(UploadFilesUtils.convertMultipartFile(medicinesEntity.getImage()));
		}
		
		// DateFormat dateFormat = new SimpleDateFormat(FORMAT_DATE);
		if (medicinesEntity.getExpiryDate() != null) {
			medicinesDTO.setExpiryDate(medicinesEntity.getExpiryDate());
		}
		if (medicinesEntity.getManufactureOfDate() != null) {
			medicinesDTO.setManufactureOfDate(medicinesEntity.getManufactureOfDate());
		}
		if (medicinesEntity.getCompany() != null) {
			medicinesDTO.setCompany_name(medicinesEntity.getCompany().getName());
			medicinesDTO.setCompany_description(medicinesEntity.getCompany().getDescription());
		}
		if (medicinesEntity.getCategory_medicine() != null) {
			medicinesDTO.setCategory_medicine_name(medicinesEntity.getCategory_medicine().getName());
			medicinesDTO.setCategory_medicine_description(medicinesEntity.getCategory_medicine().getDescription());
		}
		return medicinesDTO;
	}

	public MedicinesEntity toEntity(MedicinesDTO medicinesDTO) {
		MedicinesEntity medicinesEntity = new MedicinesEntity();
		medicinesEntity.setName(medicinesDTO.getName());
		medicinesEntity.setComposition(medicinesDTO.getComposition());
		medicinesEntity.setCost(medicinesDTO.getCost());
		medicinesEntity.setDescription(medicinesDTO.getDescription());
		medicinesEntity.setLotNumber(medicinesDTO.getLotNumber());
		// medicinesEntity.setImage(medicinesDTO.getImage());
		medicinesEntity.setUnit(medicinesDTO.getUnit());
		if (medicinesDTO.getExpiryDate() != null) {
			medicinesEntity.setExpiryDate(convertDate(medicinesDTO.getExpiryDate()));
		}
		if (medicinesDTO.getManufactureOfDate() != null) {
			medicinesEntity.setManufactureOfDate(convertDate(medicinesDTO.getManufactureOfDate()));
		}


		if (medicinesDTO.getFiles() != null) {
			String pathImage = null;
			try {
				pathImage = UploadFilesUtils.saveUploadFiles(medicinesDTO.getFiles());
				medicinesEntity.setImage(pathImage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return medicinesEntity;
	}

	/**
	 * Method convert object DTO to Entity old
	 * 
	 * @param medicinesEntity
	 * @param medicinesDTO
	 */
	public MedicinesEntity toEntity(MedicinesEntity medicinesEntity, MedicinesDTO medicinesDTO) {
		medicinesEntity.setName(medicinesDTO.getName());
		medicinesEntity.setComposition(medicinesDTO.getComposition());
		medicinesEntity.setCost(medicinesDTO.getCost());
		medicinesEntity.setDescription(medicinesDTO.getDescription());
		medicinesEntity.setLotNumber(medicinesDTO.getLotNumber());

		if (medicinesDTO.getFiles() != null) {
			String pathImage = null;
			try {
				pathImage = UploadFilesUtils.saveUploadFiles(medicinesDTO.getFiles());
				medicinesEntity.setImage(pathImage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		medicinesEntity.setUnit(medicinesDTO.getUnit());
		if (medicinesDTO.getExpiryDate() != null) {
			medicinesEntity.setExpiryDate(convertDate(medicinesDTO.getExpiryDate()));
		}
		if (medicinesDTO.getManufactureOfDate() != null) {
			medicinesEntity.setManufactureOfDate(convertDate(medicinesDTO.getManufactureOfDate()));
		}
		return medicinesEntity;
	}

	public String convertDate(String dateDto) {
		String resultDate = null;
		DateFormat formatter = new SimpleDateFormat(FORMAT_DATE);
		try {
			Date dateExpiryDate = formatter.parse(dateDto);
			resultDate = formatter.format(dateExpiryDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return resultDate;
	}
}
