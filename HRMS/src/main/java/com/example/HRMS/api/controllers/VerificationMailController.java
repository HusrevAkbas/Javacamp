package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HRMS.business.abstracts.VerificationeMailService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.VerificationEmail;

@RestController
@RequestMapping("/api/verificationbyemail")
public class VerificationMailController {
	
	private VerificationeMailService verificationeMailService;
	
	@Autowired
	public VerificationMailController(VerificationeMailService verificationeMailService) {
		super();
		this.verificationeMailService = verificationeMailService;
	} 
	
	@GetMapping("/getall")
	public DataResult<List<VerificationEmail>> getAll(){
		return this.verificationeMailService.findAll();
	}
	
	@PostMapping("/checkverificationcodes")
	public Result checkVerificationCodes(@RequestBody String email, String verificationCode) {
		return null;
	}
	
	@GetMapping("/getbyuserid")
	public DataResult<VerificationEmail> getByUserId(int id){
		return this.verificationeMailService.getByUserId(id);
	}

}
