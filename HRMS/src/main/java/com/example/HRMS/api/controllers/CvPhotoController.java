package com.example.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.HRMS.business.abstracts.CvPhotoService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.CvPhoto;

@RestController
@RequestMapping("/api/photos")
public class CvPhotoController {
	
	private CvPhotoService photoService;
	
	@Autowired
	public CvPhotoController(CvPhotoService photoService) {
		super();
		this.photoService = photoService;
	}
	@GetMapping("/getall")
	public DataResult<List<CvPhoto>> getAll(){
		return this.photoService.getAll();
	}
	@RequestMapping(value = "/addimage", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public Result add(@RequestParam(value = "file") MultipartFile image, @RequestParam int cvId) {
		return this.photoService.add(image, cvId);
	}
}
