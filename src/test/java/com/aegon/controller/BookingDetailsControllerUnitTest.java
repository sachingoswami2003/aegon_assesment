/**
 * 
 */
package com.aegon.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.aegon.model.Book;
import com.aegon.model.OccupiedRooms;
import com.aegon.model.Room;
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
		long testRoomId = 2;
		List<OccupiedRooms> roomlist = new ArrayList<OccupiedRooms>();
		
		when(roomBookingServices.getRoomDetails(testRoomId)).thenReturn(roomlist);
		
		when(roomBookingServices.getRoomDetails(testRoomId)).thenReturn(roomlist);
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.getRoomInfo(testRoomId);
		
		assertEquals(ResponseEntity.ok(roomlist), actualResponse);
	}
	
	@Test
	public void getRoomAvailability() throws Exception {
		
		Date testArriveDate = getDateFromat("2017-07-15");
		Date testDepartDate = getDateFromat("2017-07-17");
		
		final HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		
		ResponseEntity<?> mockResponse = ResponseEntity.status(httpStatus).build();
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.getRoomAvailability(testArriveDate, testDepartDate);
		
		assertEquals(mockResponse, actualResponse);
	}
	
	@Test
	public void bookRoom() throws Exception{
		OccupiedRooms occupiedRooms = mock(OccupiedRooms.class);
		
		when(roomBookingServices.saveRoomDetails(occupiedRooms)).thenReturn(occupiedRooms);
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.bookRoom(occupiedRooms);
		
		assertEquals(actualResponse,ResponseEntity.ok(occupiedRooms));
	}
	
	@Test
	public void updateBookedRoom() throws Exception{
		
		OccupiedRooms testOccupiedRoom = mock(OccupiedRooms.class);
		
		when(roomBookingServices.updateRoomDetails(testOccupiedRoom)).thenReturn(testOccupiedRoom);
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.updateBookedRoom(testOccupiedRoom);
		
		assertEquals(ResponseEntity.ok(testOccupiedRoom), actualResponse);
	}
	
	@Test
	public void getCustomerRoomDetails() throws Exception {
		
		long testCustomerId = 1;
		
		List<Book> occupiedRoomByCustomerList = new ArrayList<Book>();
		
		when(roomBookingServices.getCustomerRoomDetails(testCustomerId)).thenReturn(occupiedRoomByCustomerList);
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.getCustomerRoomDetails(testCustomerId);
		
		assertEquals(ResponseEntity.ok(occupiedRoomByCustomerList), actualResponse);
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
