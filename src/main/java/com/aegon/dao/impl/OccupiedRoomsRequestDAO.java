/**
 * 
 */
package com.aegon.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aegon.dao.OccupiedRoomsDAO;
import com.aegon.model.OccupiedRooms;


/**
 * A JPA-based implementation of the Booking Service. Delegates to a JPA entity manager to issue data access calls
 * against the backing repository. The EntityManager reference is provided by the managing container (Spring)
 * automatically.
 */
@Transactional
@Repository
public class OccupiedRoomsRequestDAO implements OccupiedRoomsDAO {
	
	@PersistenceContext
	private EntityManager entityManagers;
	
	/* (non-Javadoc)
	 * @see com.aegon.dao.OccupiedRoomsDAO#create(com.aegon.model.OccupiedRooms)
	 */
	@Override
	public void create(OccupiedRooms occupiedRooms) {
		// TODO Auto-generated method stub
		entityManagers.persist(occupiedRooms);
	}

	/* (non-Javadoc)
	 * @see com.aegon.dao.OccupiedRoomsDAO#update(com.aegon.model.OccupiedRooms)
	 */
	@Override
	public void update(OccupiedRooms occupiedRooms) {
		// TODO Auto-generated method stub
		entityManagers.merge(occupiedRooms);
	}

	/* (non-Javadoc)
	 * @see com.aegon.dao.OccupiedRoomsDAO#findAvailableRoomsBetweenDates(java.lang.String, java.lang.String)
	 */
	@Override
	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<OccupiedRooms> findAvailableRoomsBetweenDates(long roomId, Date checkInDate, Date checkOutDate) {
		// TODO Auto-generated method stub 
		//SELECT*FROM OCCUPIED_ROOMS c WHERE(( ((c.CHECK_IN_DATE like '2017-07-10 18:47:52.69') and (c.CHECK_OUT_DATE like '2017-07-12 18:47:52.69') )or (c.CHECK_IN_DATE like '2017-07-10 18:47:52.69') and (c.CHECK_OUT_DATE like '2017-07-12 18:47:52.69') ) and c.ROOM_ID like 124)
		List<OccupiedRooms> availableRoomList= new ArrayList<OccupiedRooms>();
		if (roomId != 0) {
		    return (List<OccupiedRooms>)entityManagers.createQuery("SELECT c FROM OccupiedRooms c WHERE ((((c.checkInDate LIKE :checkInDate) and (c.checkOutDate LIKE :checkInDate)) or ((c.checkOutDate LIKE :checkOutDate) and (c.checkInDate LIKE :checkOutDate))) and (c.roomId like :roomId))")
				    .setParameter("checkInDate", checkInDate).setParameter("checkOutDate", checkOutDate)
				    .setParameter("roomId", roomId).getResultList();
		} else {
		    return availableRoomList;
		}
	}

	/* (non-Javadoc)
	 * @see com.aegon.dao.OccupiedRoomsDAO#delete(long)
	 */
	@Override
	public void delete(long customerId) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
	public List<OccupiedRooms> getRoomDetails(long roomId) {
		// TODO Auto-generated method stub
		List<OccupiedRooms> availableRoomList= new ArrayList<OccupiedRooms>();
		if (roomId != 0) {
		    return (List<OccupiedRooms>)entityManagers.createQuery("SELECT c FROM OccupiedRooms c WHERE c.roomId LIKE :roomId")
			    .setParameter("roomId", roomId).getResultList();
		} else {
		    return availableRoomList;
		}
	}

}
