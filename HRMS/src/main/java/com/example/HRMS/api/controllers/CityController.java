package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.CityService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.entities.concretes.City;

@RestController
@RequestMapping("/api/city")
@CrossOrigin
public class CityController {
	
	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}

	@GetMapping("/getall")
	public DataResult<List<City>> getAll(){
		return this.cityService.getAll();
	}

}
