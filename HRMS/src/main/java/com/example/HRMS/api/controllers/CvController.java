package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.CvService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("/api/cv")
public class CvController {
	
	private CvService cvService;
	
	@Autowired
	public CvController(CvService cvService) {
		super();
		this.cvService = cvService;
	}

	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.cvService.getAll();
	}
}
