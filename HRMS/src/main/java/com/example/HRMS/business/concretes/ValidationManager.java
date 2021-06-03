package com.example.HRMS.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.HRMS.business.abstracts.ValidationService;
import com.example.HRMS.core.utilities.results.ErrorDataResult;
import com.example.HRMS.core.utilities.results.ErrorResult;
import com.example.HRMS.core.utilities.results.Result;
import com.example.HRMS.core.utilities.results.SuccessDataResult;
import com.example.HRMS.core.utilities.results.SuccessResult;
import com.example.HRMS.dataAccess.abstracts.UserDao;
import com.example.HRMS.entities.concretes.Candidate;
import com.example.HRMS.entities.concretes.Employer;
import com.example.HRMS.entities.concretes.User;

@Service
public class ValidationManager implements ValidationService {
	
	private UserDao userDao;
	
	@Autowired
	public ValidationManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result isCandidateValid(Candidate candidate, boolean checkMernis, Candidate foundByNationalIdentity, String confirmPassword) {
		
		if(!checkMernis) {
			return new ErrorResult("cantidate mernis kayıtlarında bulunamadı!");
		}
		if(!isCandidateInformationsValid(candidate).isSuccess()) {
			return new ErrorResult("cantidate bilgileri kurallara uymamaktadır: "+isCandidateInformationsValid(candidate).getMessage());
		}
		if(isUserMailAlreadyExist(candidate)){
			return new ErrorResult("Mail adresi daha önce kullanılmış: " + candidate.getEMail());
		}
		if (foundByNationalIdentity != null) {
			return new ErrorResult("Kimlik numarası daha önce kullanılmış: " + candidate.getNationalIdNumber());
		}
		if (!isPasswordsMatched(candidate, confirmPassword)) {
			return new ErrorResult("Şifreler aynı olmalıdır!");
		}
		
		return new SuccessResult("candidate eklenmeye hazır: " + candidate.getFirstName());
	}
	
	public Result isCandidateInformationsValid(Candidate candidate) {
		if(!isFirstNameValid(candidate)) {
			return new ErrorResult("İsim boş kalamaz ve en az iki karakter uzunluğunda olmalıdır.");
		}
		if(!isLastNameValid(candidate)) {
			return new ErrorResult("Soyisim boş kalamaz ve en az iki karakter uzunluğunda olmalıdır.");
		}
		if(!isBirthDateValid(candidate)) {
			return new ErrorResult("Doğum yılı boş kalamaz ve dört karakter uzunluğunda olmalıdır.");
		}
		if(!isNationalIdentityNumberValid(candidate)) {
			return new ErrorResult("Kimlik numarası boş kalamaz ve 11 karakter uzunluğunda olmalıdır.");
		}
		if(!isEmailValid(candidate)) {
			return new ErrorResult("Email boş kalamaz ve mail adresi yazık kurallarına uymalıdır.");
		}
		if(!isPasswordValid(candidate)) {
			return new ErrorResult("Şifre alanı boş kalamaz ve en az 6 karakter uzunluğunda olmalıdır.");
		}
		return new SuccessResult("Kullanıcı bilgileri kayıt için uygundur.");
	}

	public boolean isFirstNameValid(Candidate candidate) {
		if(candidate.getFirstName().length()<2) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isLastNameValid(Candidate candidate) {
		if(candidate.getLastName().length()<2) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isBirthDateValid(Candidate candidate) {
		String year = Integer.toString(candidate.getBirthYear());
		if(year.length()!=4) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isNationalIdentityNumberValid(Candidate candidate) {
		if(candidate.getNationalIdNumber().length()!=11) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean isEmailValid(User user) {
		String regex = "^(.+)@(.+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEMail());
		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isPasswordValid(User user) {
		if(user.getPassword().length()<6) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean didPasswordAndConfirmPasswordMatch(Candidate candidate, String confirmPassword) {
		if(candidate.getPassword()==confirmPassword) {
			return true;
		} else {
			return false;
		}
	}

	//MAİL VARLIĞI USERDAO DAN ARANIP KONTROL EDİLECEK, AYNI MAİLE AİT HEM EMPLOYER HEM CANDİDATE OLAMAMALI!!!
	@Override
	public boolean isUserMailAlreadyExist(User user) {
		User findByeMail = this.userDao.getByeMail(user.getEMail());
		if(findByeMail == null) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public boolean isIdentityNumberAlreadyExist(Candidate candidate) {
		if(candidate == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean isPasswordsMatched(User user, String confirmPassword) {
		return user.getPassword().equals(confirmPassword);
	}

	@Override
	public Result isEmployerInformationsValid(Employer employer) {
		if(employer.getCompanyName().length()<2) {
			return new ErrorDataResult<Employer>(employer,"Kullanıcı adı boş kalamaz ve en az iki karakter uzunluğunda olmalıdır.");
		}
		if(employer.getPhoneNumber().length()!=10) {
			return new ErrorDataResult<Employer>(employer,"Telefon numarası boş kalamaz ve on karakter(temsili) uzunluğunda olmalıdır.");
		}
		if(employer.getWebSiteAdress().length()<5) {
			return new ErrorDataResult<Employer>(employer,"Geçerli bir web adresi giriniz");
		}
		if(!isEmailValid(employer)) {
			return new ErrorDataResult<Employer>(employer,"Geçerli bir mail adresi giriniz");
		}
		if(!isPasswordValid(employer)) {
			return new ErrorDataResult<Employer>(employer,"Şifre boş kalamaz ve en az 6 karakter uzunluğunda olmalıdır");
		}
		return new SuccessDataResult<Employer>(employer,"Employer kayıt için hazır.");
	}

	@Override
	public Result isEmployerValid(Employer employer, String confirmPassword) {
		Result isValid = isEmployerInformationsValid(employer);
		boolean isEmailAlreadyExist = isUserMailAlreadyExist(employer);
		if(!isValid.isSuccess()) {
			return new ErrorDataResult<Employer>(employer,isValid.getMessage());
		}
		if(isEmailAlreadyExist) {
			return new ErrorDataResult<Employer>(employer,"Mail daha önce kullanılmış!");
		}
		if(!isPasswordsMatched(employer, confirmPassword)) {
			return new ErrorDataResult<Employer>(employer,"Şifreler aynı olmalıdır!");
		}
		
		return new SuccessDataResult<Employer>(employer,"Employer kayıt için geçerlidir");
	}
}
