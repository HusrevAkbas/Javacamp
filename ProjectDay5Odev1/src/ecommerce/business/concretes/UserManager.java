package ecommerce.business.concretes;

import java.util.List;

import ecommerce.business.abstracts.UserService;
import ecommerce.business.abstracts.UserValidateService;
import ecommerce.core.AuthService;
import ecommerce.dataAccess.abstracts.ProductDao;
import ecommerce.entities.concrete.User;

public class UserManager implements UserService {

		ProductDao productDao;
		UserValidateService validator;
		AuthService authService;
		public UserManager(ProductDao productDao, AuthService authService) {
			super();
			this.productDao = productDao;
			this.validator = new UserValidateManager(productDao);
			this.authService = authService;
		}
		
	@Override
	public void add(User user) {
		
		if(this.validator.isValid(user)) {
			this.productDao.add(user);
			System.out.println("Email gönderildi: "+user.getFirstName());
		} else {
			System.out.println("kullanıcı bilgileri kurallara uymamaktadır. eklenemedi: "+
								user.getFirstName());
		}
		
	}
	
	public void confirmEMail(User user, String onayKodu) {
		if(onayKodu == "KabulEt") {
			System.out.println(user.getFirstName()+": email doğrulandı");
			getByName(user.getFirstName()).seteMailConfirmed(true);
		} else {
			System.out.println(user.getFirstName()+": email doğrulanmadı");
			return;
		}
		
	}

	@Override
	public void login(String eMail, String password) {
		if(eMail == "" || password =="") {
			System.out.println("email ve şifre girilmelidir");
			return;
		}
		if(this.productDao.getByeMail(eMail).getPassword() == password) {
			System.out.println(this.productDao.getByeMail(eMail).getFirstName()
								+ " başarıyla giriş yaptı");
		} else {
			System.out.println(this.productDao.getByeMail(eMail).getFirstName() + ": hatalı parola");
		}
	}

	@Override
	public User getByName(String name) {
		return this.productDao.getByName(name);
	}

	@Override
	public List<User> getAll() {
		return this.productDao.getAll();
	}

	@Override
	public void loginWithGoogle(String eMail, String password) {
		this.authService.login(eMail, password);
	}
}
