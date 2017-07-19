package com.aegon.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import com.aegon.model.Book;
import com.aegon.model.OccupiedRooms;

/**
 * @author Sachin Goswami
 * OccupiedRoomRepository provides booked room details by customer,
 * Save room booking details
 * Find specific room by ID
 * Find room availability between given dates	
 */
public interface OccupiedRoomRepository extends Repository<OccupiedRooms, Long> {
	
	public final static String FIND_BY_CUSTOMER_ID_QUERY = "SELECT B FROM Book B, Customers C WHERE( (B.customerId=C.customerId) AND C.customerId = :customerId)";
	
	public final static String FIND_BY_AVAILAIBLE_ROOM_IN_BETWEEN_GIVEN_DATES_QUERY = "SELECT r.id FROM Room r WHERE NOT EXISTS (SELECT c FROM r.occupiedRoomList c "
			+ "WHERE :checkInDate BETWEEN c.checkInDate AND c.checkOutDate)";
	
	public final static String FIND_BY_ROOM_ID_QUERY = "SELECT O FROM OccupiedRooms O, Room R WHERE (O.roomId = R.roomId) AND R.roomId =:roomId";
	  
	/**
	 * Find Customer Occupied  Rooms.
	 */
	@Query(FIND_BY_CUSTOMER_ID_QUERY)
	List<Book> findByBookRoom(@Param("customerId") long customerId);
	
	/**
	 * Save Customer rooms details .
	 */
	OccupiedRooms save(OccupiedRooms occupiedRooms);
	
	/**
	 * Find rooms details .
	 */
	@Query(FIND_BY_ROOM_ID_QUERY)
	List<OccupiedRooms> findByRoomId(@Param("roomId") long roomId);
	
	/**
	 * Find available room details between given Dates.
	 */
	@Query(FIND_BY_AVAILAIBLE_ROOM_IN_BETWEEN_GIVEN_DATES_QUERY)
	List<Long> findByCheckInDateAndCheckOutDate(@Param("checkInDate") Date checkInDate);
}
