/**
 * 
 */
package com.aegon.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.aegon.model.Book;
import com.aegon.model.BookedRoom;
import com.aegon.model.OccupiedRoom;
import com.aegon.service.RoomBookingService;


/**
 * @author Sachin
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BookingDetailsControllerUnitTest {
	
	@Mock
	private RoomBookingService roomBookingServices;
	
	@InjectMocks
	private BookingDetailsController bookingDetailsControler;
	
	@Test
	public void getRoomInfo() throws Exception{
		String testRoomId = "R02";
		List<OccupiedRoom> roomlist = new ArrayList<OccupiedRoom>();
		
		when(roomBookingServices.getRoomDetails(testRoomId)).thenReturn(roomlist);
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.getRoomInfo(testRoomId);
		
		assertEquals(ResponseEntity.ok(roomlist), actualResponse);
	}
	
	@Test
	public void getRoomAvailability() throws Exception{
		String testArriveDate = "07/07/2017";
		String testDepartDate = "08/07/2017";
		List<OccupiedRoom> roomlist = new ArrayList<OccupiedRoom>();
		
		when(roomBookingServices.checkRoomsAvailabiltyForGivenDates(testArriveDate, testDepartDate)).thenReturn(roomlist);
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.getRoomAvailability(testArriveDate, testDepartDate);
		
		assertEquals(ResponseEntity.ok(roomlist), actualResponse);
	}
	
	@Test
	public void bookRoom() throws Exception{
		Book testBook = new Book();
		BookedRoom testRoomBooking = new BookedRoom();
		
		when(roomBookingServices.saveRoomDetails(testBook)).thenReturn(testRoomBooking);
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.bookRoom(testBook);
		
		assertEquals(ResponseEntity.ok(testRoomBooking), actualResponse);
	}
	
	@Test
	public void updateBookedRoom() throws Exception{
		OccupiedRoom testOccupiedRoom = new OccupiedRoom();
		BookedRoom testBookedRoom = new BookedRoom();
		
		when(roomBookingServices.updateRoomDetails(testOccupiedRoom)).thenReturn(testBookedRoom);
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.updateBookedRoom(testOccupiedRoom);
		
		assertEquals(ResponseEntity.ok(testBookedRoom), actualResponse);
	}
}
