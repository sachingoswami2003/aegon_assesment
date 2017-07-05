package com.aegon.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Customer;
import com.aegon.model.OccupiedRoom;
import com.aegon.service.RoomBookingService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/booking/rooms/{customerId}", method = RequestMethod.GET)
public class CustomerRoomsDetailsController {
	private static final String PATH_CUSTOMER_ID = "customerId";
	
	private final RoomBookingService roomBookingService;

	/**
	 * @param roomBookingService
	 */
	public CustomerRoomsDetailsController(RoomBookingService roomBookingService) {
		this.roomBookingService = roomBookingService;
	}
	
	
	@GetMapping
    @ApiOperation(
            value = "Fetches the room list ,cutomer has been booked",
            notes = "Returns room information",
            response = String.class,
            responseContainer = "List"
    )
	public ResponseEntity<List<OccupiedRoom>> getCustomerRoomDetails(@PathVariable(PATH_CUSTOMER_ID) final String customerId) throws RemoteServiceException {
        final List<OccupiedRoom> occupiedRoomList = roomBookingService.getCustomerRoomDetails(customerId);
        return ResponseEntity.ok(occupiedRoomList);
    }


}
