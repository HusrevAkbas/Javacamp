package com.example.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HRMS.business.abstracts.VerificationeMailService;
import com.example.HRMS.core.utilities.results.DataResult;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.dataAccess.abstracts.VerificationEmailDao;
import com.example.HRMS.entities.concretes.User;
import com.example.HRMS.entities.concretes.VerificationEmail;

import net.bytebuddy.utility.RandomString;

@Service
public class VerificationEmailManager implements VerificationeMailService{
	
	private VerificationEmailDao verificationEmailDao;
	
	@Autowired
	public VerificationEmailManager(VerificationEmailDao verificationEmailDao) {
		super();
		this.verificationEmailDao = verificationEmailDao;
	}

	@Override
	public DataResult<VerificationEmail> sendVerificationCodeToUserEmail(User user) {
		String verificationCode = RandomString.make(10);
		VerificationEmail verificationEmail = new VerificationEmail(1, verificationCode, user.getId(), false);
		this.verificationEmailDao.save(verificationEmail);
		return new SuccessDataResult<VerificationEmail>(verificationEmail, user.getEMail() + " adresine email gönderildi.");
	}

	@Override
	public DataResult<VerificationEmail> checkIfVerificationCodeMatces(int userId,String verificationCode) {
		VerificationEmail verificationEmail = this.verificationEmailDao.getByUserId(userId);
		String userCode = verificationEmail.getVerificationCode();
		
		if(userCode.equals(verificationCode)) {
			verificationEmail.setVerified(true);			
			this.verificationEmailDao.save(verificationEmail);
			return new SuccessDataResult<VerificationEmail>(verificationEmail,"doğrulama başarılı");
		}
		return new ErrorDataResult<VerificationEmail>(verificationEmail,"Doğrulama başarısız");
	}

	@Override
	public DataResult<VerificationEmail> getByUserId(int id) {
		return new SuccessDataResult<VerificationEmail>(this.verificationEmailDao.getByUserId(id), "verification mail user_id ile getirildi");
	}

	@Override
	public DataResult<List<VerificationEmail>> findAll() {
		return new SuccessDataResult<List<VerificationEmail>>(this.verificationEmailDao.findAll(),"mailler getirildi");
	}

}
