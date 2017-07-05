package com.aegon.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.BookedRoom;
import com.aegon.model.Customer;
import com.aegon.model.OccupiedRoom;
import com.aegon.model.Room;
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
	
	private List<OccupiedRoom> occupiedRoomList = new ArrayList<OccupiedRoom>();
	
	private List<Book> bookingList = new ArrayList<Book>();
	
	
	@Override
	public BookedRoom updateRoomDetails(OccupiedRoom OccupiedRoom) throws RemoteServiceException {
		// TODO Auto-generated method stub
		// TODO Room Charges will read from Property file later 
		// TODO Check existing booking from the Occupied room details list and update accordingly
		
		bookedRoom.setBookedRoomId("R05");
		bookedRoom.setBookingId("B05");
		bookedRoom.setBookingStatus(true);
		bookedRoom.setNumberOfRoom(OccupiedRoom.getNumberOfRoom());
		bookedRoom.setRoomType("Delux");
		bookedRoom.setRoomCharges(OccupiedRoom.getNumberOfRoom()*200);
		
		return bookedRoom;
	}

	@Override
	public List<OccupiedRoom> getRoomDetails(String roomId) throws RemoteServiceException {
		// TODO Auto-generated method stub
		occupiedRoomList = createOccupiedRoomdetails();
		List<OccupiedRoom> roomList = new ArrayList<OccupiedRoom>();
		
		for(OccupiedRoom occupiedRoom:occupiedRoomList ) {
			if(occupiedRoom.getRoomId().equals(roomId)) {
				roomList.add(occupiedRoom);
			}
		}
		return roomList;
	}

	@Override
	public List<OccupiedRoom> getCustomerRoomDetails(String customerId) throws RemoteServiceException {
		// TODO Auto-generated method stub
		List<Book> bookingList = new ArrayList<Book>();
		
		bookingList = setBookingData();
		
		List<OccupiedRoom> occupiedRoomByCustomer = new ArrayList<OccupiedRoom>();
		
		occupiedRoomList = createOccupiedRoomdetails();
		
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
	
	@Override
	public BookedRoom saveRoomDetails(Book book) throws RemoteServiceException {
		// TODO Auto-generated method stub
		// TODO Check Room Availability from Occupied room object if find room is not available show message no room available
		
		boolean availableRoom = true;
		
		occupiedRoomList = createOccupiedRoomdetails();
		
		if(availableRoom){
			occupiedRoom.setBookingId("B05");
			occupiedRoom.setCheckInDate(book.getCheckInDate());
			occupiedRoom.setCheckOutDate(book.getCheckOutDate());
			occupiedRoom.setRoomId("R05");
			occupiedRoom.setNumberOfRoom(book.getNoOfRoomRequired());
			occupiedRoom.setRoomType("Delux");
		}
		occupiedRoomList.add(occupiedRoom);
		
		//Return booked room details to the customer - no logic applied to check room availability 
		bookedRoom.setBookedRoomId("R05");
		bookedRoom.setBookingId("B05");
		bookedRoom.setBookingStatus(true);
		bookedRoom.setNumberOfRoom(book.getNoOfRoomRequired());
		bookedRoom.setRoomType("delux");
		bookedRoom.setRoomCharges(book.getNoOfRoomRequired()*200);
		
		return bookedRoom;
	}
	
	@Override
	public Set<Room> checkRoomsAvailabiltyForGivenDates(String firstDate, String secondDate)
			throws RemoteServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<OccupiedRoom> createOccupiedRoomdetails() {
		
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

	
	
}
