package com.brz.spring.jdbc.service;

import org.springframework.transaction.annotation.Transactional;

import com.brz.spring.jdbc.dao.CustomerDAO;
import com.brz.spring.jdbc.model.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public void createCustomer(Customer cust) {

		customerDAO.create(cust);

	}

}
