package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Candidate;
import com.example.HRMS.entities.concretes.VerificationEmail;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	Result add(Candidate candidate, String confirmPassword);
	DataResult<Candidate> getById(int id);
	DataResult<VerificationEmail> checkVerificationEmailCode(int id, String verificationCode);
}
