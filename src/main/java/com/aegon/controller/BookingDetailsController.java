package com.aegon.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.BookedRoom;
import com.aegon.model.OccupiedRoom;
import com.aegon.model.Room;
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
	private static final String PATH_START_DATE = "startDate";
	private static final String PATH_END_DATE = "endDate";
	
	private final RoomBookingService roomBookingService;
	
	/**
	 * This is BookingDetailsController constructor
	 * @param roomBookingService
	 */
	
	public BookingDetailsController(RoomBookingService roomBookingService) {
		this.roomBookingService = roomBookingService;
	}
	
	
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
            response = String.class,
            responseContainer = "List"
    )
	public ResponseEntity<List<OccupiedRoom>> getRoomInfo(@PathVariable(PATH_ROOM_ID) final String roomId) throws RemoteServiceException {
        
    	final List<OccupiedRoom> roomlist = roomBookingService.getRoomDetails(roomId);
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
	public ResponseEntity<List<OccupiedRoom>> getRoomAvailability(
			@RequestParam(PATH_START_DATE) final String arrivalDate, @RequestParam(PATH_END_DATE) final String departureDate) throws RemoteServiceException {
        
    	List<OccupiedRoom> roomList = roomBookingService.checkRoomsAvailabiltyForGivenDates(arrivalDate, departureDate);
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
            response = Room.class
    )
	public ResponseEntity<BookedRoom> bookRoom(@RequestBody final Book book) throws RemoteServiceException {
    	
    	BookedRoom roomBooking = roomBookingService.saveRoomDetails(book);
    	return ResponseEntity.ok(roomBooking);
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
        response = OccupiedRoom.class
    )
    public ResponseEntity<BookedRoom> updateBookedRoom(@RequestBody final OccupiedRoom occupiedRoom) throws RemoteServiceException {
    	
    	BookedRoom updatedRoom = roomBookingService.updateRoomDetails(occupiedRoom);
    	return ResponseEntity.ok(updatedRoom);
    }
}
