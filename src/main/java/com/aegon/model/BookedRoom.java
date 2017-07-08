/**
 * 
 */
package com.aegon.model;


import java.io.Serializable;

import org.springframework.stereotype.Component;

/**
 * @author Sachin
 *
 * A Book where users may book stays.
 */

@Component
public class BookedRoom implements Serializable {

	private String bookedRoomId;
	private int numberOfRoom;
	private String bookingId;
	private String roomType;
	private float roomCharges;
	private boolean bookingStatus;
	
	/**
	 * @return the roomCharges
	 */
	public final float getRoomCharges() {
		return roomCharges;
	}

	/**
	 * @param roomCharges the roomCharges to set
	 */
	public final void setRoomCharges(float roomCharges) {
		this.roomCharges = roomCharges;
	}

	/**
	 * @return the bookedRoomId
	 */
	public final String getBookedRoomId() {
		return bookedRoomId;
	}

	/**
	 * @param bookedRoomId the bookedRoomId to set
	 */
	public final void setBookedRoomId(String bookedRoomId) {
		this.bookedRoomId = bookedRoomId;
	}

	/**
	 * @return the numberOfRoom
	 */
	public final int getNumberOfRoom() {
		return numberOfRoom;
	}

	/**
	 * @param numberOfRoom the numberOfRoom to set
	 */
	public final void setNumberOfRoom(int numberOfRoom) {
		this.numberOfRoom = numberOfRoom;
	}

	/**
	 * @return the bookingId
	 */
	public final String getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public final void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the roomType
	 */
	public final String getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public final void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * @return the bookingStatus
	 */
	public final boolean isBookingStatus() {
		return bookingStatus;
	}

	/**
	 * @param bookingStatus the bookingStatus to set
	 */
	public final void setBookingStatus(boolean bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	@Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof BookedRoom)) {
            return false;
        }

        BookedRoom bookedRoom = (BookedRoom) o;

        return bookedRoom.bookedRoomId.equals(bookedRoomId) &&
        		bookedRoom.roomType == roomType &&
        		bookedRoom.bookingId.equals(bookingId);
    }
}
