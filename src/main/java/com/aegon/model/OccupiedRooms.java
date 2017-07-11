/**
 * 
 */
package com.aegon.model;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Sachin
 *
 * Check for Reservation where users booked their stays.
 */

@Entity
@Table(name = "OccupiedRooms")
public class OccupiedRooms implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long occupiedId;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date checkOutDate;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date checkInDate;
	private long roomId;
	private long bookingId;
	private int numberOfRoom;
	private String roomType;
	private Long customerId;
	
	
	public OccupiedRooms() {
		
	}

	public OccupiedRooms(long bookingId,Date checkOutDate, Date checkInDate, long roomId, 
			 int numberOfRoom, String roomType, long customerId) 
	{
		this.bookingId = bookingId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.roomId = roomId;
		this.numberOfRoom = numberOfRoom;
		this.roomType = roomType;
		this.customerId = customerId;
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
	 * @return the occupiedId
	 */
	public final long getOccupiedId() {
		return occupiedId;
	}
	/**
	 * @param occupiedId the occupiedId to set
	 */
	public final void setOccupiedId(long occupiedId) {
		this.occupiedId = occupiedId;
	}
	/**
	 * @return the checkOutDate
	 */
	public final Date getCheckOutDate() {
		return checkOutDate;
	}
	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public final void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	/**
	 * @return the checkInDate
	 */
	public final Date getCheckInDate() {
		return checkInDate;
	}
	/**
	 * @param checkInDate the checkInDate to set
	 */
	public final void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	/**
	 * @return the roomId
	 */
	public final long getRoomId() {
		return roomId;
	}
	/**
	 * @param roomId the roomId to set
	 */
	public final void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	/**
	 * @return the bookingId
	 */
	public final long getBookingId() {
		return bookingId;
	}
	/**
	 * @param bookingId the bookingId to set
	 */
	public final void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	
	/**
	 * @return the customerId
	 */
	public final Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public final void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getRoomType() + "," + getBookingId() + "," + getNumberOfRoom() + "," + getCheckInDate() + "," + getCheckOutDate();
	}
	
	
}
