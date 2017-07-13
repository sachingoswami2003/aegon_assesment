package com.aegon.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * A Book where users may book stays.
 */
@Entity
@Table(name = "bookroom")
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	private long customerId;
	private Date checkInDate;
	private Date checkOutDate;
	private int noOfRoomRequired;
	private boolean roomBreakfastsrviceFlag;
	

	public Book() {
		
	}
	
	public Book(Date checkOutDate, Date checkInDate, long customerId, 
			long bookingId, int noOfRoomRequired, boolean roomBreakfastsrviceFlag) 
	{
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.customerId = customerId;
		this.bookingId = bookingId;
		this.noOfRoomRequired = noOfRoomRequired;
		this.roomBreakfastsrviceFlag = roomBreakfastsrviceFlag;
	}

	
	/**
	 * @return the noOfRoomRequired
	 */
	public final int getNoOfRoomRequired() {
		return noOfRoomRequired;
	}

	/**
	 * @param noOfRoomRequired the noOfRoomRequired to set
	 */
	public final void setNoOfRoomRequired(int noOfRoomRequired) {
		this.noOfRoomRequired = noOfRoomRequired;
	}

	/**
	 * @return the bookingId
	 */
	public final long getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId
	 * the bookingId to set
	 */
	public final void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the customerId
	 */
	public final long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *  the customerId to set
	 */
	public final void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the checkIn
	 */
	public final Date getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param string
	 *            the checkIn to set
	 */
	public final void setCheckInDate(Date checkIn) {
		this.checkInDate = checkIn;
	}

	/**
	 * @return the checkOut
	 */
	public final Date getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOut
	 *    the checkOut to set
	 */
	public final void setCheckOutDate(Date checkOut) {
		this.checkOutDate = checkOut;
	}
	
	/**
	 * @return the roomBreakfastsrviceFlag
	 */
	public final boolean isRoomBreakfastsrviceFlag() {
		return roomBreakfastsrviceFlag;
	}
	/**
	 * @param roomBreakfastsrviceFlag the roomBreakfastsrviceFlag to set
	 */
	public final void setRoomBreakfastsrviceFlag(boolean roomBreakfastsrviceFlag) {
		this.roomBreakfastsrviceFlag = roomBreakfastsrviceFlag;
	}
	
	/**
	 * @return the roomCharges
	 *//*
	public final float getRoomCharges() {
		return roomCharges;
	}

	*//**
	 * @param roomCharges the roomCharges to set
	 *//*
	public final void setRoomCharges(float roomCharges) {
		this.roomCharges = roomCharges;
	}*/
	
}