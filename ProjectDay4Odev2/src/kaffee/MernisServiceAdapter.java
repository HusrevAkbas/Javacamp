package kaffee;

public class MernisServiceAdapter implements CustomerCheckService {

	@Override
	public boolean CheckIfRealPerson(Customer customer) {
		//mernis kodları buraya
		return false;
	}

}
