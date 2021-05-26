package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.JobPositionService;
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
	public List<JobPosition> getAll() {

		return this.jobPositionDao.findAll();
	}

}
