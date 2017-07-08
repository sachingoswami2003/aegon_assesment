package com.aegon.service;

import java.util.Date;
import java.util.List;

import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.BookedRoom;
import com.aegon.model.OccupiedRooms;

/**
* <h1>RoomBookingService Interface!</h1>
* The service program implements RoomBookingService Interface that
* simply help to develop booking room, room availability , amount to be paid
* check room availability in given date by customer 
* the output provide in from of response.
*
* @author  Sachin Goswami
* @version 1.0
* @since   2017-07-04
*/

public interface RoomBookingService {
	    /**
	     * Book a customer's room as per Book details.
	     * This will replace the existing booking room details.
	     * @param <Book>
	     *
	     * @param roomId - a user's get room details
	     * @return The Booked room details
	     */
	    String saveRoomDetails(OccupiedRooms occupiedRoom) throws RemoteServiceException;
	    
	    /**
	     * Check room details by roomId.
	     * This will provide room details.
	     * @param <Book>
	     *
	     * @param roomId - a user's get room details
	     * @return The OccupiedRoom details
	     */
	    List<OccupiedRooms> getRoomDetails(long roomId)throws RemoteServiceException;
	    
	    /**
	     * Check room details by Customer Id.
	     * This will room details booked by specific customer.
	     * 
	     * @param customerId - a user's get room details
	     * @return The Booked rooms details
	     */
	    
	    List<OccupiedRooms> getCustomerRoomDetails(long customerId)throws RemoteServiceException;
	    
	    /**
	     * Check room details by BookingId provided by user in Occupied room object.
	     * This will room details updated by  customer.
	     * 
	     * @param customerId - a user's get room details
	     * @return The BookedRoom details
	     */

	    String updateRoomDetails(OccupiedRooms occupiedRoom) throws RemoteServiceException;
	    
	    /**
	     * Check room details by Customer Id.
	     * This will room details require to book.
	     * @param <arrivalDate> to check room availability on the given date
	     *
	     * @param departureDate - to check room availability till the given date
	     * @return The availability of Room details
	     */
	    List<OccupiedRooms> checkRoomsAvailabiltyForGivenDates(long room_Id, Date check_In, Date check_out) throws RemoteServiceException;
	    
	    /**
	     * Check expenses details by Customer Id.
	     * This will room details require to book.
	     * @param <customeId> to check room expenses need to pay
	   
	     * @return The total bill amount for Room details
	     */

		public List<Book> findBookingsCost(long customeId) throws RemoteServiceException;
	}
