package ecommerce.business.abstracts;

import java.util.List;

import ecommerce.entities.concrete.User;

public interface UserService {
	void add(User user);
	void login(String eMail, String password);
	User getByName(String name);
	List<User> getAll();
	void confirmEMail(User user, String onayKodu);
	void loginWithGoogle(String eMail, String password);
}
