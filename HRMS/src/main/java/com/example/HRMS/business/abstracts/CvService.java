package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.entities.concretes.CurriculumVitae;

public interface CvService {
	DataResult<List<CurriculumVitae>> getAll();
}