package com.aegon.service.impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aegon.dao.impl.BookRoomRepository;
import com.aegon.dao.impl.OccupiedRoomRepository;
import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.OccupiedRooms;
import com.aegon.service.RoomBookingService;

/**
 * @author Sachin Goswami
 * DefaultRoomBookingServices provides  room booking services 
 */
@Service
public class DefaultRoomBookingServices implements RoomBookingService{
	
	@Autowired
	BookRoomRepository bookRoomRepository;
	
	@Autowired
	private OccupiedRoomRepository occupiedRoomRepositroy;

	/**
     * Check room details by Customer Id.
     * This will room details booked by specific customer.
     * 
     * @param customerId - a user's get room details
     * @return The BookedRoom details
     */
	
	@Override
	public OccupiedRooms updateRoomDetails(OccupiedRooms occupiedRoom) throws RemoteServiceException {
		OccupiedRooms occupiedRooms = this.occupiedRoomRepositroy.save(occupiedRoom);
		return occupiedRooms;
	}
	
	/**
     * Check room details by roomId.
     * This will provide room details.
     * @param roomId - a user's get room details
     * @return The OccupiedRooms details
     */
	
	@Override
	public List<OccupiedRooms> getRoomDetails(long room_id) throws RemoteServiceException {
		List<OccupiedRooms> roomList = this.occupiedRoomRepositroy.findByRoomId(room_id);
		return roomList;
	}
	
	/**
     * Check room details by Customer Id.
     * This will room details booked by specific customer.
     * 
     * @param customerId - a user's get room details
     * @return The Booked rooms details
     */

	@Override
	public List<Book> getCustomerRoomDetails(long customerId) throws RemoteServiceException {
		List<Book> occupiedRoomByCustomer = this.occupiedRoomRepositroy.findByBookRoom(customerId);
		return occupiedRoomByCustomer;
	}
	
	/**
     * Book a customer's room as per Book details.
     * This will replace the existing booking room details.
     * @param <Book>
     *
     * @param roomId - a user's get room details
     * @return The Booked room details
     */
	
	@Override
	public OccupiedRooms saveRoomDetails(OccupiedRooms occupiedRooms) throws RemoteServiceException {
		OccupiedRooms occupiedRoom = this.occupiedRoomRepositroy.save(occupiedRooms);
		return occupiedRoom;
	}
	
	/**
     * Check room details by Customer Id.
     * This will room details booked by specific customer.
     * @param <arrivalDate> to check room availability on the given date
     *
     * @param departureDate - to check room availability till the given date
     * @return The availability of Room details
     */
	
	@Override
	public List<Long> checkRoomsAvailabiltyForGivenDates(Date check_in)
			throws RemoteServiceException {
		
		List<Long> roomList = this.occupiedRoomRepositroy.findByCheckInDateAndCheckOutDate(check_in);
		return roomList;
		
	}
	

    /**
     * Check expenses details by Customer Id.
     * This will room details require to book.
     * @param <customeId> to check room expenses need to pay
   
     * @return The total bill amount for Room details
     */

	public List<Double> findBookingsCost(long customeId) throws RemoteServiceException {
		// TODO Auto-generated method stub
		List<Double> roomList = this.bookRoomRepository.getRoomChargesByCustomerId(customeId);
		return roomList;
	}
	
	
}
