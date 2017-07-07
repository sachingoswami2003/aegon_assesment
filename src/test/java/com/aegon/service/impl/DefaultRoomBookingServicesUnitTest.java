/**
 * 
 */
package com.aegon.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.aegon.model.Book;
import com.aegon.model.BookedRoom;
import com.aegon.model.Customer;
import com.aegon.model.OccupiedRoom;



/**
 * @author Sachin Goswami
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultRoomBookingServicesUnitTest {
	
	@Mock
	Book book;
	
	@Mock
	Customer customer;
	
	@InjectMocks
	DefaultRoomBookingServices defaultRoomBookingServices;
	
	@Test
	public void updateRoomDetails() throws Exception {
		
		BookedRoom expectedBookedRoom = new BookedRoom();
		expectedBookedRoom.setBookedRoomId("R02");
		expectedBookedRoom.setBookingId("B02");
		expectedBookedRoom.setBookingStatus(true);
		expectedBookedRoom.setNumberOfRoom(1);
		expectedBookedRoom.setRoomCharges(200);
		expectedBookedRoom.setRoomType("Simple");
		
		OccupiedRoom occupiedRoom = new OccupiedRoom();
		occupiedRoom.setBookingId("B02");
		occupiedRoom.setCheckInDate("06/07/2017");
		occupiedRoom.setCheckOutDate("08/07/2017");
		occupiedRoom.setRoomId("R02");
		occupiedRoom.setNumberOfRoom(1);
		occupiedRoom.setRoomType("Simple");
		
		BookedRoom actualBookedRoom = defaultRoomBookingServices.updateRoomDetails(occupiedRoom);
		
		assertEquals(actualBookedRoom, expectedBookedRoom);
	}
	
//	@Test
//	public void getRoomDetails() throws Exception {
//		
//	}
	
//	@Test
//	public void getCustomerRoomDetails() throws Exception {
//		
//	}
//	
//	@Test
//	public void saveRoomDetails() throws Exception {
//		
//	}
//	
//	@Test
//	public void checkRoomsAvailabiltyForGivenDates() throws Exception {
//		
//		
//	}
	
}
