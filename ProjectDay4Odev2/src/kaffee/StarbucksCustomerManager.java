package kaffee;

public class StarbucksCustomerManager extends BaseCustomerManager  {
	
	private CustomerCheckManager customerCheckManager;
	
	public StarbucksCustomerManager(CustomerCheckManager customerCheckManager) {
		this.customerCheckManager = customerCheckManager;
	}
	
	@Override
	public void save(Customer customer) {
		if(customerCheckManager.CheckIfRealPerson(customer)) {
			super.save(customer);			
		} else {
			System.out.println("hatalı kişi bilgisi");
		}		
	}
}
