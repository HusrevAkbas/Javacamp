package com.example.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.HRMS.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer>{
	List<School> findByGraduationYearNotNullOrderByGraduationYearDesc();
	List<School> findByGraduationYearIsNull();
}
