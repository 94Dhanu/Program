package com.brz.spring.jdbc.main;




import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.brz.spring.jdbc.model.Address;
import  com.brz.spring.jdbc.model.Customer;
import  com.brz.spring.jdbc.service.CustomerManager;
import  com.brz.spring.jdbc.service.CustomerManagerImpl;

public class TransactionManagerMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");

		CustomerManager customerManager = ctx.getBean("customerManager",
				CustomerManagerImpl.class);

		Customer cust = createDummyCustomer();
		customerManager.createCustomer(cust);

		ctx.close();
	}

	private static Customer createDummyCustomer() {
		Customer customer = new Customer();
		customer.setId(5);
		customer.setName("Dhananjay");
		Address address = new Address();
		address.setId(3);
		address.setCountry("Ind");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Dhananjay Dr, San, CA 95129");
		customer.setAddress(address);
		return customer;
	}

}
