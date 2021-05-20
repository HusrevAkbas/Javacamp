package ecommerce.dataAccess.concrete;

import java.util.List;

import ecommerce.artificialDB.Database;
import ecommerce.dataAccess.abstracts.ProductDao;
import ecommerce.entities.concrete.User;

public class HibernateProductDao implements ProductDao {
	
	Database db = new Database();

	@Override
	public void add(User user) {
		db.database.add(user);
		System.out.println(user.getFirstName() + " kullanıcısı veri tabanına eklendi");
	}

	@Override
	public User getByName(String name) {
		for(User user: this.db.database) {
			if(user.getFirstName() == name) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return this.db.database;
	}

	@Override
	public User getByeMail(String eMail) {
		for(User user: this.db.database) {
			if(user.geteMail() == eMail) {
				return user;
			}
		}
		return null;
	}
	
	

}
