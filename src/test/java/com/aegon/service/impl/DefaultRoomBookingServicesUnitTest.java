/**
 * 
 */
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

import com.aegon.dao.impl.CustomerRequestDAO;
import com.aegon.dao.impl.OccupiedRoomsRequestDAO;
import com.aegon.model.OccupiedRooms;

/**
 * @author Sachin Goswami
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultRoomBookingServicesUnitTest {
	
	@Mock
	CustomerRequestDAO customerRequestDAO;
	@Mock
	private OccupiedRoomsRequestDAO occupiedRoomsRequestDAO;
	
	@InjectMocks
	DefaultRoomBookingServices defaultRoomBookingServices;
	
	@Test
	public void updateRoomDetails() throws Exception {
		OccupiedRooms occupiedRoom = mock(OccupiedRooms.class);
		String actualBookedRoom = defaultRoomBookingServices.updateRoomDetails(occupiedRoom);
		String expectedBookedRoom = "Booking Details has been updated";
		
		assertEquals(actualBookedRoom, expectedBookedRoom);
	}
	
	@Test
	public void getRoomDetails() throws Exception {
		long roomId = 1;
		OccupiedRooms occupiedRoom = mock(OccupiedRooms.class);
		List<OccupiedRooms> roomList = new ArrayList<OccupiedRooms>(); 
		
		when(occupiedRoomsRequestDAO.getRoomDetails(roomId)).thenReturn(roomList);
		List<OccupiedRooms> actualBookedRoomList = defaultRoomBookingServices.getRoomDetails(roomId);
		
		assertEquals(actualBookedRoomList, roomList);
	}
	
	@Test
	public void getCustomerRoomDetails() throws Exception {
		long customerId = 123;
		OccupiedRooms occupiedRoom = mock(OccupiedRooms.class);
		List<OccupiedRooms> cutomerList = new ArrayList<OccupiedRooms>(); 

		when(customerRequestDAO.findBookings(customerId)).thenReturn(cutomerList);
		
		List<OccupiedRooms> actualCustomerRoomList = defaultRoomBookingServices.getCustomerRoomDetails(customerId);
		
		assertEquals(actualCustomerRoomList, cutomerList);
	}
	
	@Test
	public void saveRoomDetails() throws Exception {
		OccupiedRooms occupiedRoom = mock(OccupiedRooms.class);
		String saveMeaasge = "Room has been booked";
		String actualSaveMessage = defaultRoomBookingServices.saveRoomDetails(occupiedRoom);
		
		assertEquals(actualSaveMessage, saveMeaasge);
	}
		
	
	@Test
	public void checkRoomsAvailabiltyForGivenDates() throws Exception {
		long roomId = 123;
		Date testCheckInDate = getDateFromat("07-07-2017");
		Date testCheckOutDate = getDateFromat("08-07-2017");
		
		OccupiedRooms occupiedRoom = mock(OccupiedRooms.class);
		List<OccupiedRooms> availableRoomList = new ArrayList<OccupiedRooms>();
		
		when(occupiedRoomsRequestDAO.findAvailableRoomsBetweenDates(roomId, testCheckInDate, testCheckOutDate)).thenReturn(availableRoomList);
		
		List<OccupiedRooms> actualRoomList = defaultRoomBookingServices.checkRoomsAvailabiltyForGivenDates(roomId, testCheckInDate, testCheckOutDate);
		
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
