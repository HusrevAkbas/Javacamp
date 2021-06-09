package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.concretes.JobAdvertisement;
import com.example.HRMS.entities.concretes.VerificationEmail;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer, String confirmPassword);
	DataResult<VerificationEmail> checkVerificationEmailCode(int id, String verificationCode);
	Result changeActiveState(int jobAdvertisementId);
}
