/**
 * 
 */
package com.aegon.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.aegon.model.OccupiedRoom;
import com.aegon.service.RoomBookingService;

/**
 * @author Sachin Goswami
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerRoomsDetailsControllerUnitTest {
	
	@Mock
	private RoomBookingService roomBookingServices;
	
	@InjectMocks
	private CustomerRoomsDetailsController customerRoomsDetailsController;
	
	
	@Test
	public void getCustomerRoomDetails() throws Exception {
		
		String testCustomerId = "Cus01";
		List<OccupiedRoom> occupiedRoomList = new ArrayList<OccupiedRoom>();
		
		when(roomBookingServices.getCustomerRoomDetails(testCustomerId)).thenReturn(occupiedRoomList);
		
		ResponseEntity<?> actualResponse = customerRoomsDetailsController.getCustomerRoomDetails(testCustomerId);
		
		assertEquals(ResponseEntity.ok(occupiedRoomList), actualResponse);
	}
}
