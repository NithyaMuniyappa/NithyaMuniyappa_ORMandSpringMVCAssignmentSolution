package com.gl.customerrelations.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gl.customerrelations.model.Customer;


@Repository
public class CustomerDaoImpl implements CustomerDao {
	@Autowired
	SessionFactory factory;

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(customer);

	}

	@Override
	@Transactional
	public void deleteCustomer(int id) {
		Session session = factory.getCurrentSession();
		Customer ct = session.get(Customer.class,id);
		session.delete(ct);


	}

	@Override
	@Transactional
	public Customer findById(int id) {
		Session session = factory.getCurrentSession();
		return session.get(Customer.class, id);
	}

	@Override
	@Transactional
	public List<Customer> findAll() {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class);
		return criteria.list();
	}

}
