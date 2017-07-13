package com.aegon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.Customers;
import com.aegon.service.RoomBookingService;

import io.swagger.annotations.ApiOperation;

/**
* <h1>Customer room booking services!</h1>
* The service program implements an application that
* check room availability by customer in given date by customer 
* the output provide in from of response.
*
* @author  Sachin Goswami
* @version 1.0
* @since   2017-07-04
*/

@RestController
@RequestMapping
public class CustomerRoomsDetailsController {
	private static final String PATH_CUSTOMER_ID = "customerId";
	
	@Autowired
	RoomBookingService roomBookingService;

	
	/**
     * Check room details by Customer Id.
     * This will room details booked by specific customer.
     * 
     * @param customerId - a user's get room details
     * @return The Booked rooms details
     */
	
	@GetMapping("/booking/rooms/{customerId}")
    @ApiOperation(
            value = "Fetches the room list ,cutomer has been booked",
            notes = "Returns room information",
            response = Customers.class,
            responseContainer = "List"
    )
	public ResponseEntity<List<Book>> getCustomerRoomDetails(@PathVariable(PATH_CUSTOMER_ID) final long customerId) throws RemoteServiceException {
        final List<Book> occupiedRoomList = roomBookingService.getCustomerRoomDetails(customerId);
        return ResponseEntity.ok(occupiedRoomList);
    }
	
	/**
     * Check room amount by Customer Id.
     * This will provide details booked by specific customer.
     * 
     * @param customerId - a user's get room details
     * @return The Booked rooms details with amount
     */
	
	@GetMapping("/booking/cost/{customerId}")
    @ApiOperation(
            value = "Fetches the room cost list ,cutomer has been booked",
            notes = "Returns room cost information",
            response = Double.class,
            responseContainer = "List"
    )
	public ResponseEntity<List<Double>> getCustomerRoomCostDetails(@PathVariable(PATH_CUSTOMER_ID) final long customerId) throws RemoteServiceException {
        final List<Double> occupiedRoomCostList = roomBookingService.findBookingsCost(customerId);
        return  ResponseEntity.ok(occupiedRoomCostList);
    }
}
