package com.aegon.service.impl;

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
import com.aegon.dao.impl.OccupiedRoomRepository;
import com.aegon.model.Book;
import com.aegon.model.OccupiedRooms;

/**
 * @author Sachin Goswami
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultRoomBookingServicesUnitTest {
	@Mock
	private OccupiedRoomRepository occupiedRoomsRepository;
	
	@InjectMocks
	DefaultRoomBookingServices defaultRoomBookingServices;
	
	@Test
	public void updateRoomDetails() throws Exception {
		OccupiedRooms occupiedRoom = mock(OccupiedRooms.class);
		
		when(occupiedRoomsRepository.save(occupiedRoom)).thenReturn(occupiedRoom);
		
		OccupiedRooms actualBookedRoom = defaultRoomBookingServices.updateRoomDetails(occupiedRoom);		
		
		assertEquals(actualBookedRoom, occupiedRoom);
	}
	
	@Test
	public void getRoomDetails() throws Exception {
		long roomId = 1;
		
		List<OccupiedRooms> roomList = new ArrayList<OccupiedRooms>(); 
		
		when(occupiedRoomsRepository.findByRoomId(roomId)).thenReturn(roomList);
		List<OccupiedRooms> actualBookedRoomList = defaultRoomBookingServices.getRoomDetails(roomId);
		
		assertEquals(actualBookedRoomList, roomList);
	}
	
	@Test
	public void getCustomerRoomDetails() throws Exception {
		long customerId = 123;
		List<Book> cutomerList = new ArrayList<Book>(); 

		when(occupiedRoomsRepository.findByBookRoom(customerId)).thenReturn(cutomerList);
		
		List<Book> actualCustomerRoomList = defaultRoomBookingServices.getCustomerRoomDetails(customerId);
		
		assertEquals(actualCustomerRoomList, cutomerList);
	}
	
	@Test
	public void saveRoomDetails() throws Exception {
		OccupiedRooms occupiedRoom = mock(OccupiedRooms.class);
		
		when(occupiedRoomsRepository.save(occupiedRoom)).thenReturn(occupiedRoom);
		
		OccupiedRooms actualoccupiedRoom = defaultRoomBookingServices.saveRoomDetails(occupiedRoom);
		
		assertEquals(actualoccupiedRoom, occupiedRoom);
	}
		
	
	@Test
	public void checkRoomsAvailabiltyForGivenDates() throws Exception {
		
		Date testCheckInDate = getDateFromat("07-07-2017");
		
		List<Long> availableRoomList = new ArrayList<Long>();
		
		when(occupiedRoomsRepository.findByCheckInDateAndCheckOutDate(testCheckInDate)).thenReturn(availableRoomList);
		
		List<Long> actualRoomList = defaultRoomBookingServices.checkRoomsAvailabiltyForGivenDates(testCheckInDate);
		
		assertEquals(actualRoomList, availableRoomList);
	}
	
	/**
     * To convert DATE in simple date format .
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
