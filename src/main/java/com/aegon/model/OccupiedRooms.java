/**
 * 
 */
package com.aegon.model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date checkOutDate;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date checkInDate;
	
	@Column(nullable = false)
	private long roomId;
	
	private long bookingId;
	
	@Column(nullable = false)
	private int numberOfRoom;
	
	@Column(nullable = false)
	private Long customerId;

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
		return  getBookingId() + "," + getNumberOfRoom() + "," + getCheckInDate() + "," + getCheckOutDate();
	}
	
	
}
