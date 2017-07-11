package com.aegon.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.exception.RemoteServiceException;
import com.aegon.model.OccupiedRooms;
import com.aegon.service.RoomBookingService;

import io.swagger.annotations.ApiOperation;


/**
* <h1>Basic booking system services!</h1>
* The service program implements an application that
* simply help to booking room, room availability , amount to be paid
* check room availability in given date by customer 
* the output provide in from of response.
*
* @author  Sachin Goswami
* @version 1.0
* @since   2017-07-04
*/

@RestController
public class BookingDetailsController {
	
	private static final String PATH_ROOM_ID = "roomId";
		
	@Autowired
	RoomBookingService roomBookingService;
	
 /**
   * This method is used to provide rooms details . 
   * @param roomId This is the parameter to get room details from room booking services
   * @return ResponseEntity with list of occupiedRoom details.
   * @exception RemoteSrviceException On input error.
   * @see Exception
   */

	@GetMapping("/booking/{roomId}")
    @ApiOperation(
            value = "Fetches the rooms detail",
            notes = "Returns rooms information",
            response = OccupiedRooms.class,
            responseContainer = "List"
    )
	public ResponseEntity<List<OccupiedRooms>> getRoomInfo(@PathVariable(PATH_ROOM_ID) final long roomId) throws RemoteServiceException {
        
    	final List<OccupiedRooms> roomlist = roomBookingService.getRoomDetails(roomId);
        return ResponseEntity.ok(roomlist);
    }
    
/**
   * This method is used to provide rooms availability  . 
   * @param arrivalDate This is the parameter to get room details with in given date period
   * @param departureDate This is the parameter to get room details with in given date period
   * @return ResponseEntity with list of occupiedRoom details.
   * @exception RemoteSrviceException On input error.
   * @see Exception
   */
	
    @GetMapping("/booking/givendates")
    @ApiOperation(
            value = "Fetches the room avalability between two dates",
            notes = "Returns room information",
            response = String.class,
            responseContainer = "List"
    )
	public ResponseEntity<List<OccupiedRooms>> getRoomAvailability(@RequestParam(PATH_ROOM_ID) final long roomId,
			@RequestParam(name = "check_in", defaultValue = "1900-01-01") @DateTimeFormat(pattern = "yyyy-mm-dd") Date check_in, 
			@RequestParam(name = "check_out", defaultValue = "2200-01-01") @DateTimeFormat(pattern = "yyyy-mm-dd") Date check_out) throws RemoteServiceException {
        
    	List<OccupiedRooms> roomList = roomBookingService.checkRoomsAvailabiltyForGivenDates(roomId, check_in, check_out);
    	return ResponseEntity.ok(roomList); 
    }
    
/**
   * This method is used to provide rooms booking service  . 
   * @param Book object This is the parameter to receive room details for room booking
   * @param roomId This is the parameter to book room 
   * @return ResponseEntity with list of BookedRoom details.
   * @exception RemoteSrviceException On input error.
   * @see Exception
   */

	@PostMapping("/booking/bookrooms")
    @ApiOperation(
            value = "Booked room service",
            notes = "Set available room details as a response object",
            response = OccupiedRooms.class
    )
	public OccupiedRooms bookRoom(@RequestBody final OccupiedRooms occupiedRooms) throws RemoteServiceException {
		
		OccupiedRooms roomOccupiedRoomsBooking = roomBookingService.saveRoomDetails(occupiedRooms);
    	return roomOccupiedRoomsBooking;
    }
    
/**
   * This method is used to provide update services on the existing bookings. 
   * @param OccupiedRoom object This is the parameter to receive room details for room booking 
   * @return ResponseEntity with list of BookedRoom details.
   * @exception RemoteSrviceException On input error.
   * @see Exception
   */
	
    @PutMapping("/booking/updatebookings")
    @ApiOperation(
        value = "Update the customer's Booking ",
        notes = "if the customer change his bookings details, system update accordingly",
        response = OccupiedRooms.class
    )
    public ResponseEntity<OccupiedRooms> updateBookedRoom(@RequestBody final OccupiedRooms occupiedRoom) throws RemoteServiceException {
    	
    	OccupiedRooms updatedRoom = roomBookingService.updateRoomDetails(occupiedRoom);
    	return ResponseEntity.ok(updatedRoom);
    }
}
