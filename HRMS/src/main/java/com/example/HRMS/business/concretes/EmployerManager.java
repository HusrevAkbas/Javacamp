package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.EmployerService;
import com.example.HRMS.business.abstracts.JobAdvertisementService;
import com.example.HRMS.business.abstracts.ValidationService;
import com.example.HRMS.business.abstracts.VerificationeMailService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.EmployerDao;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.concretes.JobAdvertisement;
import com.example.HRMS.entities.concretes.VerificationEmail;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private ValidationService validationService;
	private VerificationeMailService verificationeMailService;
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, 
							ValidationService validationService, 
							VerificationeMailService verificationeMailService, 
							JobAdvertisementService jobAdvertisementService) {
		super();
		this.employerDao = employerDao;
		this.validationService=  validationService;
		this.verificationeMailService = verificationeMailService;
		this.jobAdvertisementService = jobAdvertisementService;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll());
	}

	@Override
	public Result add(Employer employer, String confirmPassword) {
		Result isValid = this.validationService.isEmployerValid(employer, confirmPassword);		
		if(isValid.isSuccess()) {
			this.employerDao.save(employer);
			this.verificationeMailService.sendVerificationCodeToUserEmail(employer);
			return new SuccessResult("kayıt başarılı:" + employer.getCompanyName());
		} else {
			return new ErrorResult("Kayıt başarısız: " + isValid.getMessage());	
		}
	}

	@Override
	public DataResult<VerificationEmail> checkVerificationEmailCode(int id, String verificationCode) {
		DataResult<VerificationEmail> result = this.verificationeMailService.checkIfVerificationCodeMatces(id, verificationCode);
		if(result.isSuccess()) {
			return new SuccessDataResult<VerificationEmail>(result.getMessage());
		}
		return new ErrorDataResult<VerificationEmail>(result.getMessage());		
	}

	@Override
	public Result changeActiveState(int jobAdvertisementId) {
		this.jobAdvertisementService.changeActiveState(jobAdvertisementId);
		return new SuccessResult("ilan yayından kaldırıldı");
	}
	
}
