package com.gl.customerrelations.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.customerrelations.dao.CustomerDao;
import com.gl.customerrelations.model.Customer;

@Controller
@RequestMapping("customers")
public class CustomerController {
	@Autowired
	CustomerDao customerDao;
	
	@GetMapping("list")
	public String listCustomers(Model model) {
		List<Customer> customers = customerDao.findAll();
		model.addAttribute("customers", customers);
		return "customer-list";
	}
	
	@GetMapping("showForm")
	public String showCustomerForm(Model model) {
		Customer ct = new Customer();
		model.addAttribute("customer", ct);
		return "customer-form";
	}

	@PostMapping("save")
	public String saveCustomer(Model model, @ModelAttribute("customer") Customer customer) {
		customerDao.saveCustomer(customer);
		return "redirect:/customers/list";
	}

	@GetMapping("update")
	public String updateCustomer(Model model, @RequestParam("id") int id) {
		Customer ct = customerDao.findById(id);
		model.addAttribute("customer", ct);
		return "customer-form";
	}

	@GetMapping("delete")
	public String deleteCustomer(Model model, @RequestParam("id") int id) {
	    customerDao.deleteCustomer(id);
	    return "redirect:/customers/list";
	}

}
