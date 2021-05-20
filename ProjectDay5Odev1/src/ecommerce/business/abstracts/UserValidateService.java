package ecommerce.business.abstracts;

import ecommerce.entities.concrete.User;

public interface UserValidateService {
	boolean isValid(User user);
}
