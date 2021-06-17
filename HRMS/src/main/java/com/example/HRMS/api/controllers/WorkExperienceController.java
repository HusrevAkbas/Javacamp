package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.WorkExperienceService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/workexperience")
public class WorkExperienceController {
	private WorkExperienceService workExperienceService;
	
	@Autowired
	public WorkExperienceController(WorkExperienceService workExperienceService) {
		super();
		this.workExperienceService = workExperienceService;
	}
	@GetMapping("/getallbyendyear")
	public DataResult<List<WorkExperience>>getAllByEndYear(){
		return this.workExperienceService.getAllByEndYear();
	}
	
}
