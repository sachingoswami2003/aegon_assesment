package com.aegon.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.BookedRoom;
import com.aegon.model.Customer;
import com.aegon.model.OccupiedRoom;
import com.aegon.service.RoomBookingService;


/**
 * @author Sachin
 *
 */
@Service
public class DefaultRoomBookingServices implements RoomBookingService{
	
	@Autowired
	private Customer customer;
	
	@Autowired
	private Book book;
	
	@Autowired
	private BookedRoom bookedRoom;
	
	@Autowired
	private OccupiedRoom occupiedRoom;
	
	
	/**
     * Check room details by Customer Id.
     * This will room details booked by specific customer.
     * 
     * @param customerId - a user's get room details
     * @return The BookedRoom details
     */
	
	@Override
	public BookedRoom updateRoomDetails(OccupiedRoom OccupiedRoom) throws RemoteServiceException {
		// TODO Auto-generated method stub
		// TODO Room Charges will read from Property file later 
		// TODO Check existing booking from the Occupied room details list and update accordingly
		BookedRoom bookedRoom = new BookedRoom();
		bookedRoom.setBookedRoomId(OccupiedRoom.getRoomId());
		bookedRoom.setBookingId(OccupiedRoom.getBookingId());
		bookedRoom.setBookingStatus(true);
		bookedRoom.setNumberOfRoom(OccupiedRoom.getNumberOfRoom());
		bookedRoom.setRoomType(OccupiedRoom.getRoomType());
		bookedRoom.setRoomCharges(OccupiedRoom.getNumberOfRoom()*200);
		
		return bookedRoom;
	}
	
	/**
     * Check room details by roomId.
     * This will provide room details.
     * @param <Book>
     *
     * @param roomId - a user's get room details
     * @return The OccupiedRoom details
     */
	
	@Override
	public List<OccupiedRoom> getRoomDetails(String roomId) throws RemoteServiceException {
		// TODO Auto-generated method stub
		List<OccupiedRoom> occupiedRoomList = createOccupiedRoomdetails();
		List<OccupiedRoom> roomList = new ArrayList<OccupiedRoom>();
		if(occupiedRoomList!=null) {
			for(OccupiedRoom occupiedRoom:occupiedRoomList ) {
				if(occupiedRoom.getRoomId().equals(roomId)) {
					roomList.add(occupiedRoom);
				}
			}
		}	
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
	public List<OccupiedRoom> getCustomerRoomDetails(String customerId) throws RemoteServiceException {
		// TODO Auto-generated method stub
		List<Book> bookingList = new ArrayList<Book>();
		
		bookingList = setBookingData();
		
		List<OccupiedRoom> occupiedRoomByCustomer = new ArrayList<OccupiedRoom>();
		
		List<OccupiedRoom> occupiedRoomList = createOccupiedRoomdetails();
		
		for(Book book:bookingList){
			if(book.getCustomerId().equals(customerId)) {
				for(OccupiedRoom occupiedRoom:occupiedRoomList ) {
					if(occupiedRoom.getBookingId().equals(book.getBookingId())) {
						occupiedRoomByCustomer.add(occupiedRoom);
					}
				}
			}
		}
		
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
	public BookedRoom saveRoomDetails(Book book) throws RemoteServiceException {
		// TODO Auto-generated method stub
		// TODO Check Room Availability from Occupied room object if find room is not available show message no room available
		
		bookedRoom.setBookedRoomId("R05");
		bookedRoom.setBookingId("B07");
		bookedRoom.setBookingStatus(true);
		bookedRoom.setNumberOfRoom(book.getNoOfRoomRequired());
		bookedRoom.setRoomType("delux");
		bookedRoom.setRoomCharges(book.getNoOfRoomRequired()*200);
		
		return bookedRoom;
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
	public List<OccupiedRoom> checkRoomsAvailabiltyForGivenDates(String firstDate, String secondDate)
			throws RemoteServiceException {
		// TODO Auto-generated method stub
		List<OccupiedRoom> occupiedRoomList = createOccupiedRoomdetails();
		
		List<OccupiedRoom> roomList = new ArrayList<OccupiedRoom>();
		
		Date firstGivenDate = getDateFromat(firstDate);
		Date occupiedDate = null;
		
		for(OccupiedRoom occupiedRoom:occupiedRoomList ) {
			occupiedDate = getDateFromat(occupiedRoom.getCheckOutDate());
			
			if((firstGivenDate.compareTo(occupiedDate) > 0) || (firstGivenDate.compareTo(occupiedDate) == 0)) {
				roomList.add(occupiedRoom);
			}
		}
		return roomList;
		
	}
	
	private List<OccupiedRoom> createOccupiedRoomdetails() {
		
		List<OccupiedRoom> occupiedRoomList = new ArrayList<OccupiedRoom>();
		
		occupiedRoom.setBookingId("B01");
		occupiedRoom.setCheckInDate("06/07/2017");
		occupiedRoom.setCheckOutDate("07/07/2017");
		occupiedRoom.setRoomId("R01");
		occupiedRoomList.add(occupiedRoom);
		
		occupiedRoom = new OccupiedRoom();
		occupiedRoom.setBookingId("B02");
		occupiedRoom.setCheckInDate("06/07/2017");
		occupiedRoom.setCheckOutDate("08/07/2017");
		occupiedRoom.setRoomId("R02");
		occupiedRoomList.add(occupiedRoom);
		
		occupiedRoom = new OccupiedRoom();
		occupiedRoom.setBookingId("B03");
		occupiedRoom.setCheckInDate("08/07/2017");
		occupiedRoom.setCheckOutDate("09/07/2017");
		occupiedRoom.setRoomId("R03");
		occupiedRoomList.add(occupiedRoom);
		
		occupiedRoom = new OccupiedRoom();
		occupiedRoom.setBookingId("B04");
		occupiedRoom.setCheckInDate("08/07/2017");
		occupiedRoom.setCheckOutDate("09/07/2017");
		occupiedRoom.setRoomId("R01");
		occupiedRoomList.add(occupiedRoom);
		
		return occupiedRoomList;
	}
	
	private List<Customer> setCustomerData() {
		
		List<Customer> listCustomer = new ArrayList<Customer>();
		
		customer.setCustomerId("Cus01");
		customer.setFirstName("Sachin");
		customer.setLastName("Goswami");
		customer.setMembershipStatus(true);
		
		listCustomer.add(customer);
		
		customer = new Customer();
		customer.setCustomerId("Cus02");
		customer.setFirstName("Sac");
		customer.setLastName("Gos");
		customer.setMembershipStatus(true);
		
		listCustomer.add(customer);
		
		customer = new Customer();
		customer.setCustomerId("Cus03");
		customer.setFirstName("Deep");
		customer.setLastName("Gos");
		customer.setMembershipStatus(true);
		listCustomer.add(customer);
		
		return listCustomer;
	}
	
	private List<Book> setBookingData() {
		
		List<Book> bookingList = new ArrayList<Book>();
		
		book.setBookingId("B01");
		book.setCustomerId("Cus01");
		book.setCheckInDate("04/07/2017");
		book.setCheckInDate("05/07/2017");
		bookingList.add(book);
		
		book = new Book();
		book.setBookingId("B02");
		book.setCustomerId("Cus01");
		book.setCheckInDate("04/07/2017");
		book.setCheckInDate("06/07/2017");
		bookingList.add(book);
		
		return bookingList;
	}

	private Date getDateFromat(String strDate) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
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
