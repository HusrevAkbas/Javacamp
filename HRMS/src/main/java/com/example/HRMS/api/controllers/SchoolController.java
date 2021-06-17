package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.SchoolService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
	private SchoolService schoolService;
	
	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	@GetMapping("/schoolsorderedbygraduationyeardescent")
	public DataResult<List<School>> findAllOrderedByGraduationYearDescent() {
		return this.schoolService.findByGraduationYearOrderByDescent();
	}
}
