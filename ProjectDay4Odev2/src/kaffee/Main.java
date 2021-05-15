package kaffee;

import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		
		Customer customer1 = new Customer(0,"enigma","demir",LocalDate.now(),"2");
		Customer customer2 = new Customer(1,"ember","ryu",LocalDate.now(),"2333333333");
		
		BaseCustomerManager customerManager = new StarbucksCustomerManager(new CustomerCheckManager());
		customerManager.save(new Customer(1,"ahmet","mehmet",LocalDate.now(),"22222222222"));
		customerManager.save(customer2);
		customerManager.save(customer1);
	}

}
