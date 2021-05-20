package ecommerce.dataAccess.abstracts;

import java.util.List;

import ecommerce.entities.concrete.User;

public interface ProductDao {
	void add(User user);
	User getByName(String name);
	User getByeMail(String eMail);
	List<User> getAll();
}
