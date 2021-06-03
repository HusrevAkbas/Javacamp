package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HRMS.business.abstracts.JobPositionService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.JobPositionsDao;
import com.example.HRMS.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{
	
	private JobPositionsDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionsDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}
	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(),"liste getirildi");
	}
	@Override
	public Result add(JobPosition jobPosition) {
		JobPosition getByTitleJob = this.jobPositionDao.getByTitle(jobPosition.getTitle());
		if(getByTitleJob != null) {
			return new ErrorResult("İş pozisyonu zaten eklenmiş");
		} else {
			this.jobPositionDao.save(jobPosition);
			return new SuccessResult("İş pozisyonu eklendi");			
		}
	}

}
