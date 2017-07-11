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
import org.springframework.http.ResponseEntity;
import com.aegon.model.OccupiedRooms;
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
	public void getRoomAvailability() throws Exception{
		long testRoomId = 2;
		Date testArriveDate = getDateFromat("07-07-2017");
		Date testDepartDate = getDateFromat("08-07-2017");
		
		List<OccupiedRooms> roomlist = new ArrayList<OccupiedRooms>();
		
		when(roomBookingServices.checkRoomsAvailabiltyForGivenDates(testRoomId, testArriveDate, testDepartDate)).thenReturn(roomlist);
		
		ResponseEntity<?> actualResponse = bookingDetailsControler.getRoomAvailability(testRoomId,testArriveDate, testDepartDate);
		
		assertEquals(ResponseEntity.ok(roomlist), actualResponse);
	}
	
	@Test
	public void bookRoom() throws Exception{
		String str = "Room has been booked";
		OccupiedRooms occupiedRooms = new OccupiedRooms();
		
		when(roomBookingServices.saveRoomDetails(occupiedRooms)).thenReturn(occupiedRooms);
		
		OccupiedRooms actualResponse = bookingDetailsControler.bookRoom(occupiedRooms);
		
		assertEquals(actualResponse,occupiedRooms);
	}
	
	@Test
	public void updateBookedRoom() throws Exception{
		OccupiedRooms testOccupiedRoom = mock(OccupiedRooms.class);
		
		when(roomBookingServices.updateRoomDetails(testOccupiedRoom)).thenReturn(testOccupiedRoom);
		
		ResponseEntity<OccupiedRooms> actualResponse = bookingDetailsControler.updateBookedRoom(testOccupiedRoom);
		
		assertEquals(ResponseEntity.ok(testOccupiedRoom), actualResponse);
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
