package com.example.HRMS.business.abstracts;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.CvPhoto;

public interface CvPhotoService {
	DataResult<List<CvPhoto>> getAll();
	Result add(MultipartFile file);
}
