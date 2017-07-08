/**
 * 
 */
package com.aegon.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aegon.model.Customers;
import com.aegon.model.OccupiedRooms;

/**
* <h1>OccupiedRoomsDAO Interface!</h1>
* The DAO  Interface that
* simply help to CRUD operations
*
* @author  Sachin Goswami
* @version 1.0
* @since   2017-07-04
*/

public interface OccupiedRoomsDAO {

	void create(OccupiedRooms occupiedRooms);

    void update(OccupiedRooms occupiedRooms);
    
    List<OccupiedRooms> findAvailableRoomsBetweenDates(long roomId, Date check_in, Date check_out);
    
    List<OccupiedRooms> getRoomDetails(long roomId);

    void delete(long customerId);
}
