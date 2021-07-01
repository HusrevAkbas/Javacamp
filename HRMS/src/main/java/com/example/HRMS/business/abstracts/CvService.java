package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.entities.concretes.CurriculumVitae;
import com.example.HRMS.entities.concretes.dtos.CvAllDto;

public interface CvService {
	DataResult<List<CurriculumVitae>> getAll();
	DataResult<CvAllDto> getCvAllDto(int id);
}
