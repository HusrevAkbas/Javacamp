package ecommerce;

import ecommerce.business.abstracts.UserService;
import ecommerce.business.concretes.UserManager;
import ecommerce.core.GoogleAuthManagerAdapter;
import ecommerce.dataAccess.concrete.HibernateProductDao;
import ecommerce.entities.concrete.User;

public class Main {

	public static void main(String[] args) {
		UserService userManager = new UserManager(new HibernateProductDao(), new GoogleAuthManagerAdapter());
		
		User user1 = new User(1,"ali","baba","email@email.mail","password");
		userManager.add(user1);
		userManager.add(user1);
		
		User user2 = new User(1,"birol","can","email2@email.mail","passworte");
		userManager.add(user2);
		userManager.confirmEMail(user2, "KabulEt");
		
		User user3 = new User(3,"deniz","engin","mail@mali.ll","123546");
		userManager.add(user3);
		userManager.confirmEMail(user3,"KabulEdilmedi");
		
		User user4 = new User(4,"faruk","gergin","m@mm","sifeta23");
		userManager.add(user4);
		
		userManager.login("mail@mali.ll", "123546");
		userManager.login("email@email.mail","passwordd");
		userManager.login("", "");
		userManager.loginWithGoogle("mail", "pass");
	}

}
