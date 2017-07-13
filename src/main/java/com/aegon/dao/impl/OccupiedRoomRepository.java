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
 *
 */
public interface OccupiedRoomRepository extends Repository<OccupiedRooms, Long> {
	
	public final static String FIND_BY_CUSTOMER_ID_QUERY = "SELECT B FROM Book B, Customers C WHERE( (B.customerId=C.customerId) AND C.customerId = :customerId)";
	
	public final static String FIND_BY_AVAILAIBLE_ROOM_ID_QUERY = "SELECT c FROM OccupiedRooms c WHERE ((((c.checkInDate >=:checkInDate) AND (c.checkOutDate >=:checkInDate)) OR ((c.checkOutDate >=:checkOutDate) and (c.checkInDate >=:checkOutDate))) and (c.roomId = :roomId))";
	
	public final static String FIND_BY_ROOM_ID_QUERY = "SELECT O FROM OccupiedRooms O, Room R WHERE (O.roomId = R.roomId) AND R.roomId LIKE :roomId";
	  
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
	@Query(FIND_BY_AVAILAIBLE_ROOM_ID_QUERY)
	List<OccupiedRooms> findByCheckInDateAndCheckOutDate(@Param("checkInDate") Date checkInDate, @Param("checkOutDate") Date checkOutDate, @Param("roomId") long roomId);
	    
}
