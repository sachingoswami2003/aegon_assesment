package com.aegon.service;

import java.util.List;
import java.util.Set;

import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.BookedRoom;
import com.aegon.model.OccupiedRoom;
import com.aegon.model.Room;

public interface RoomBookingService {
	    /**
	     * Set a customer's room booking by their bookingId.
	     * This will replace the existing booking room details.
	     * @param <Room>
	     *
	     * @param roomId - a user's get room details
	     * @return The new group of email addresses
	     */
	    BookedRoom saveRoomDetails(Book book) throws RemoteServiceException;
	    
	    List<OccupiedRoom> getRoomDetails(String roomId)throws RemoteServiceException;
	    
	    List<OccupiedRoom> getCustomerRoomDetails(String customerId)throws RemoteServiceException;

	    BookedRoom updateRoomDetails(OccupiedRoom occupiedRoom) throws RemoteServiceException;
	    
	    Set<Room> checkRoomsAvailabiltyForGivenDates(String firstDate, String secondDate) throws RemoteServiceException;
	}
