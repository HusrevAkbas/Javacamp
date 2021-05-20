package ecommerce.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ecommerce.business.abstracts.UserValidateService;
import ecommerce.dataAccess.abstracts.ProductDao;
import ecommerce.entities.concrete.User;

public class UserValidateManager implements UserValidateService {
	
	ProductDao productDao;
	
	public UserValidateManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public boolean isValid(User user) {

		if(user.getPassword().length() <5) {
			System.out.println("Uyarı: parola en az 6 karakter olmalıdır. düzeltip tekrar deneyiniz.");
			return false;
		}
		if(user.getFirstName().length() <2 || user.getLastName().length() <2 ) {
			System.out.println("Uyarı: isim ve soyisim en az iki karakter olmalıdır. düzeltip tekrar deneyiniz.");
			return false;
		}
		if(!iseMailValid(user.geteMail())) {
			return false;
		}
		if(iseMailExist(user)) {
			System.out.println("Uyarı: email adresi zaten kullanılmış. değiştirip tekrar deneyiniz.");
			return false;
		}
		return true;
	}

	public boolean iseMailExist(User user) {
		for(User userInDb : this.productDao.getAll()) {
			if(userInDb.geteMail() == user.geteMail()) {
				return true;
			}
		}
		return false;
	}
	public boolean iseMailValid(String eMail) {
		Pattern pattern = Pattern.compile("^(.+)@(.+)[.](.+)$");
		Matcher matcher = pattern.matcher(eMail);
		//System.out.println(eMail+": "+ matcher.matches());
		if(matcher.matches()) {
			return true;
		} else {
			return false;
		}
	}

}
