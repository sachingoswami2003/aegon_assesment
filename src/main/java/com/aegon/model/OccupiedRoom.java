/**
 * 
 */
package com.aegon.model;

import org.springframework.stereotype.Component;

/**
 * @author Sachin
 *
 */
@Component
public class OccupiedRoom {
//	private String occupiedId;
	private String checkOutDate;
	private String checkInDate;
	private String roomId;
	private String bookingId;
	private int numberOfRoom;
	private String roomType;
	
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
//	/**
//	 * @return the occupiedId
//	 */
//	public final String getOccupiedId() {
//		return occupiedId;
//	}
//	/**
//	 * @param occupiedId the occupiedId to set
//	 */
//	public final void setOccupiedId(String occupiedId) {
//		this.occupiedId = occupiedId;
//	}
	/**
	 * @return the checkOutDate
	 */
	public final String getCheckOutDate() {
		return checkOutDate;
	}
	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public final void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	/**
	 * @return the checkInDate
	 */
	public final String getCheckInDate() {
		return checkInDate;
	}
	/**
	 * @param checkInDate the checkInDate to set
	 */
	public final void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	/**
	 * @return the roomId
	 */
	public final String getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public final void setRoomId(String roomId) {
		this.roomId = roomId;
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
}
