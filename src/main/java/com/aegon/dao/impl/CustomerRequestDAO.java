/**
 * 
 */
package com.aegon.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.aegon.dao.CustomerDao;
import com.aegon.model.Book;
import com.aegon.model.Customers;
import com.aegon.model.OccupiedRooms;

/**
 * A JPA-based implementation of the Booking Service. Delegates to a JPA entity manager to issue data access calls
 * against the backing repository. The EntityManager reference is provided by the managing container (Spring)
 * automatically.
 */
@Transactional
@Repository
public class CustomerRequestDAO implements CustomerDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Customers customer) {
		entityManager.persist(customer);
	}
	
	@Override
	public void update(Customers customer) {
		 entityManager.merge(customer);
	}
	
	@Override
	public void delete(long customerId) {
		Customers customers = (Customers) findBookings(customerId);
		if (customerId != 0.0) {
			entityManager.remove(customers);
		}
	}

	@Override
	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<OccupiedRooms> findBookings(long customerId) {
		if (customerId != 0.0) {
		    return entityManager.createQuery("select b from Booking b where b.user.username = :customerId order by b.checkinDate")
			    .setParameter("customerId", customerId).getResultList();
		} else {
		    return null;
		}
	}
	
 	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<Book> findBookingsCost(long customeId) {
	if (customeId != 0) {
	    return entityManager.createQuery("select SUM(r.roomPrice + r.breakFastPrice) from OccupiedRooms b,Room r where ((b.roomId=r.roomId) and (b.customerId = :customeId))")
		    .setParameter("customeId", customeId).getResultList();
	} else {
	    return null;
	}
	
    }

}
