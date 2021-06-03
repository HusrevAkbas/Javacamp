package com.example.HRMS.business.abstracts;

import java.util.List;

import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.entities.concretes.User;
import com.example.HRMS.entities.concretes.VerificationEmail;

public interface VerificationeMailService {
	DataResult<VerificationEmail> sendVerificationCodeToUserEmail(User user);
	DataResult<VerificationEmail> checkIfVerificationCodeMatces(int userId,String verificationCode);
	DataResult<VerificationEmail> getByUserId (int id);
	DataResult<List<VerificationEmail>> findAll();
}
