package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {
	DataResult<List<JobAdvertisement>> getAll();
	Result add(JobAdvertisement JobAdvertisement);
	DataResult<List<JobAdvertisement>> getAllActiveAds();
	DataResult<List<JobAdvertisement>> getAllActiveAdsOrderedByReleaseDate();
	DataResult<List<JobAdvertisement>> getByEmployerId(int companyId);
	Result changeActiveState(int  jobAdvertisementId);
	
}
