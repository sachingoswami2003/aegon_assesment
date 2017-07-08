/**
 * 
 */
package com.aegon.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aegon.dao.CustomerDao;
import com.aegon.dao.impl.CustomerRequestDAO;
import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.Customers;
import com.aegon.model.OccupiedRooms;

/**
 * @author Sachin Goswami
 *
 */
@Service
public class CustomerCreateService{
	@Autowired
	private CustomerRequestDAO customerRequestDAO;
	
	 public void create(Customers customer) {
		 customerRequestDAO.create(customer);
	 }

}
