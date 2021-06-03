package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.adapters.UserCheckService;
import com.example.HRMS.business.abstracts.CandidateService;
import com.example.HRMS.business.abstracts.ValidationService;
import com.example.HRMS.business.abstracts.VerificationeMailService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.CandidateDao;
import com.example.HRMS.entities.concretes.Candidate;
import com.example.HRMS.entities.concretes.VerificationEmail;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	private ValidationService validationService;
	private UserCheckService userCheckService;
	private VerificationeMailService verificationeMailService;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao, ValidationService validationService,UserCheckService userCheckService,VerificationeMailService verificationeMailService) {
		super();
		this.candidateDao = candidateDao;
		this.validationService = validationService;
		this.userCheckService = userCheckService;
		this.verificationeMailService = verificationeMailService;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}

	@Override
	public Result add(Candidate candidate, String confirmPassword) {		
		boolean checkMernis = userCheckService.checkIfRealPerson(candidate);
		Candidate findByIdentityNumber = this.candidateDao.getByNationalIdNumber(candidate.getNationalIdNumber());
		Result isValid = this.validationService.isCandidateValid(candidate,checkMernis, findByIdentityNumber, confirmPassword);		
		if(isValid.isSuccess()) {
			this.candidateDao.save(candidate);
			this.verificationeMailService.sendVerificationCodeToUserEmail(candidate);
			return new SuccessResult("Kullanıcı eklendi: " + candidate.getFirstName());
		} else {
			return new ErrorResult("Kullanıcı eklenmedi: "+isValid.getMessage());
		}
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>
			(this.candidateDao.getById(id),id+" numaralı candidate getirildi");
	}

	@Override
	public DataResult<VerificationEmail> checkVerificationEmailCode(int id, String verificationCode) {
		DataResult<VerificationEmail> result = this.verificationeMailService.checkIfVerificationCodeMatces(id, verificationCode);
		if(result.isSuccess()) {
			return new SuccessDataResult<VerificationEmail>(result.getMessage());
		}
		return new ErrorDataResult<VerificationEmail>(result.getMessage());		
	}
	
}
