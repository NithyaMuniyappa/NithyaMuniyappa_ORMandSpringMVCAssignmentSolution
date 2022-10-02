package com.gl.customerrelations.dao;

import java.util.List;

import com.gl.customerrelations.model.Customer;



public interface CustomerDao {

	public void saveCustomer(Customer customer);
	public void deleteCustomer(int id);
	public Customer findById(int id);
	public List<Customer>findAll();
}
