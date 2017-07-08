package com.aegon.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aegon.dao.impl.CustomerRequestDAO;
import com.aegon.dao.impl.OccupiedRoomsRequestDAO;
import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.OccupiedRooms;
import com.aegon.service.RoomBookingService;


/**
 * @author Sachin
 *
 */
@Service
public class DefaultRoomBookingServices implements RoomBookingService{
	
	
	private CustomerRequestDAO customerRequestDAO;
	private OccupiedRoomsRequestDAO occupiedRoomsRequestDAO;
	
	public DefaultRoomBookingServices(CustomerRequestDAO customerRequestDAO, OccupiedRoomsRequestDAO occupiedRoomsRequestDAO) {
		this.customerRequestDAO = customerRequestDAO;
		this.occupiedRoomsRequestDAO = occupiedRoomsRequestDAO;
	}
	/**
     * Check room details by Customer Id.
     * This will room details booked by specific customer.
     * 
     * @param customerId - a user's get room details
     * @return The BookedRoom details
     */
	
	@Override
	public String updateRoomDetails(OccupiedRooms occupiedRoom) throws RemoteServiceException {
		occupiedRoomsRequestDAO.update(occupiedRoom);
		return "Booking Details has been updated";
	}
	
	/**
     * Check room details by roomId.
     * This will provide room details.
      * @param roomId - a user's get room details
     * @return The OccupiedRooms details
     */
	
	@Override
	public List<OccupiedRooms> getRoomDetails(long room_id) throws RemoteServiceException {
		List<OccupiedRooms> roomList = occupiedRoomsRequestDAO.getRoomDetails(room_id);
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
	public List<OccupiedRooms> getCustomerRoomDetails(long customerId) throws RemoteServiceException {
		List<OccupiedRooms> occupiedRoomByCustomer = customerRequestDAO.findBookings(customerId);
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
	public String saveRoomDetails(OccupiedRooms occupiedRooms) throws RemoteServiceException {
		occupiedRoomsRequestDAO.create(occupiedRooms);
		return "Room has been booked";
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
	public List<OccupiedRooms> checkRoomsAvailabiltyForGivenDates(long room_id, Date check_in,Date check_out)
			throws RemoteServiceException {
		List<OccupiedRooms> roomList = occupiedRoomsRequestDAO.findAvailableRoomsBetweenDates(room_id, check_in, check_out);
		return roomList;
		
	}
	

    /**
     * Check expenses details by Customer Id.
     * This will room details require to book.
     * @param <customeId> to check room expenses need to pay
   
     * @return The total bill amount for Room details
     */

	public List<Book> findBookingsCost(long customeId) throws RemoteServiceException {
		// TODO Auto-generated method stub
		List<Book> roomList = customerRequestDAO.findBookingsCost(customeId);
		return roomList;
	}
	
	/**
	 * To convert DATE in simple format .
	 */
	private Date getDateFromat(String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
		try {
			date = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
}
