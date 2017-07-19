package com.aegon.dao.impl;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import com.aegon.model.Customers;


/**
 * @author Sachin Goswami
 * BookRoomRepository interface get details for Customer room booking 
 * Cost incur  
 */
public interface BookRoomRepository extends Repository<Customers, Long> {
	
	public final static String FIND_BY_COST_BY_CUSTOMER_ID_QUERY = "select SUM(r.roomPrice + r.breakFastPrice) from "
			+ "OccupiedRooms b, Room r where ((b.roomId=r.roomId) AND (b.customerId = :customerId))";
		
	@Query(FIND_BY_COST_BY_CUSTOMER_ID_QUERY)
    List<Double> getRoomChargesByCustomerId(@Param("customerId") long customerId);
}
