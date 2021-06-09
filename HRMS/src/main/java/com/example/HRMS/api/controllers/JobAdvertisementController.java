package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.JobAdvertisementService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	} 
	
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	
	@GetMapping("/getallactive")
	public DataResult<List<JobAdvertisement>> getAllActiveAds(){
		return this.jobAdvertisementService.getAllActiveAds();
	}

	@GetMapping("/getallactiveorderedbyreleasedate")
	public DataResult<List<JobAdvertisement>> getAllActiveAdsOrderedByReleaseDate(){
		return this.jobAdvertisementService.getAllActiveAdsOrderedByReleaseDate();
	}

	@PostMapping("/getbyemployerid")
	public DataResult<List<JobAdvertisement>> getAllByEmployerId(@RequestBody int companyId){
		return this.jobAdvertisementService.getByEmployerId(companyId);
	}
	
}
