
package com.laptrinhjavaweb.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptrinhjavaweb.entity.MedicinesEntity;

@Repository
public interface MedicinesRepository extends JpaRepository<MedicinesEntity, Long> {
	Page<MedicinesEntity> findAllByname(String name, Pageable pageable);
	int countAllByname(String name);
}
