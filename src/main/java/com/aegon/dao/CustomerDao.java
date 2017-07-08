package com.aegon.dao;

import java.util.List;

import com.aegon.model.Book;
import com.aegon.model.Customers;
import com.aegon.model.OccupiedRooms;


/**
* <h1>CustomerDao Interface!</h1>
* The DAO  Interface that
* simply help to CRUD operations
*
* @author  Sachin Goswami
* @version 1.0
* @since   2017-07-04
*/
public interface CustomerDao  {
	
	void create(Customers customer);

    void update(Customers customer);

    List<OccupiedRooms> findBookings(long customerId);
    
    public List<Book> findBookingsCost(long customeId);

    void delete(long customerId);
}
