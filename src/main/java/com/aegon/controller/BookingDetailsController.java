package com.aegon.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aegon.exception.RemoteServiceException;
import com.aegon.model.Book;
import com.aegon.model.BookedRoom;
import com.aegon.model.OccupiedRoom;
import com.aegon.model.Room;
import com.aegon.service.RoomBookingService;

import io.swagger.annotations.ApiOperation;

@RestController
public class BookingDetailsController {
	
	private static final String PATH_ROOM_ID = "roomId";
	private static final String PATH_START_DATE = "startDate";
	private static final String PATH_END_DATE = "endDate";
	
	private final RoomBookingService roomBookingService;
	
	/**
	 * @param roomBookingService
	 */
	public BookingDetailsController(RoomBookingService roomBookingService) {
		this.roomBookingService = roomBookingService;
	}
	
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
    
    
    @GetMapping("/booking/givendates")
    @ApiOperation(
            value = "Fetches the room avalability between two dates",
            notes = "Returns room information",
            response = String.class,
            responseContainer = "List"
    )
	public ResponseEntity<List<Room>> getRoomAvalability(
			@PathVariable(PATH_START_DATE) final String startDate, @PathVariable(PATH_END_DATE) final String endDate) throws RemoteServiceException {
        return null;
    }
    
    
	@PostMapping("/booking/bookrooms")
    @ApiOperation(
            value = "Room booked room service",
            notes = "Set available room details as a response object",
            response = Room.class
    )
	public ResponseEntity<BookedRoom> bookRoom(@RequestBody final Book book) throws RemoteServiceException {
    	
    	BookedRoom roomBooking = roomBookingService.saveRoomDetails(book);
    	return ResponseEntity.ok(roomBooking);
    }
    
    
    @PutMapping("/booking/updatebookings")
    @ApiOperation(
        value = "Update the customer's Booking ",
        notes = "if the customer change his bookings details, system update accordingly",
        response = OccupiedRoom.class)
    public ResponseEntity<?> updateBookedRoom(@RequestBody final OccupiedRoom occupiedRoom) throws RemoteServiceException {
    	
    	BookedRoom updatedRoom = roomBookingService.updateRoomDetails(occupiedRoom);
    	return ResponseEntity.ok(updatedRoom);
    }
}
