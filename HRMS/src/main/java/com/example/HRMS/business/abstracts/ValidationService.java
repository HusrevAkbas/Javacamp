package com.example.HRMS.business.abstracts;

import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.entities.concretes.Candidate;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.concretes.User;

public interface ValidationService {
	Result isCandidateValid(Candidate candidate, boolean checkMernis, Candidate checkIdentityNumberUser, String confirmPassword);
	Result isCandidateInformationsValid(Candidate candidate);
	boolean isUserMailAlreadyExist(User user);
	boolean isIdentityNumberAlreadyExist(Candidate candidate);
	boolean isPasswordsMatched(User user, String confirmPassword);
	Result isEmployerInformationsValid(Employer employer);
	Result isEmployerValid(Employer employer, String confirmPassword);
}
