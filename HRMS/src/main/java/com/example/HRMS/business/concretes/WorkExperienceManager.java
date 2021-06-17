package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.WorkExperienceService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.dataAccess.abstracts.WorkExperienceDao;
import com.example.HRMS.entities.concretes.WorkExperience;

@Service
public class WorkExperienceManager implements WorkExperienceService{
	private WorkExperienceDao workExperienceDao;
	
	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		super();
		this.workExperienceDao = workExperienceDao;
	}

	@Override
	public DataResult<List<WorkExperience>> getAllByEndYear() {
		List<WorkExperience> workExperienceList = this.workExperienceDao.getByEndYearIsNullOrderByStartYear();
		workExperienceList.addAll(this.workExperienceDao.getByEndYearIsNotNullOrderByEndYearDesc());
		return new SuccessDataResult<List<WorkExperience>>(workExperienceList,"çalışma tecrübeleri listelendi");
	}

}
