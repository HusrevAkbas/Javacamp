package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> getAll();
}
