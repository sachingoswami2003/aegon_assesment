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


/**
 * A Book where users may book their stay.
 */
@Entity
@Table(name = "bookroom")
public class Book implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	
	@Column(nullable = false)
	private long customerId;
	
	@Column(nullable = false)
	private int noOfRoomRequired;
	
	private String roomBreakfastsrviceFlag = "Y";

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date checkInDate;
	

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date checkOutDate;
	
	
	
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
	 * the checkOut to set
	 */
	public final void setCheckOutDate(Date checkOut) {
		this.checkOutDate = checkOut;
	}
	
	/**
	 * @return the roomBreakfastsrviceFlag
	 */
	public final String isRoomBreakfastsrviceFlag() {
		return roomBreakfastsrviceFlag;
	}
	/**
	 * @param roomBreakfastsrviceFlag the roomBreakfastsrviceFlag to set
	 */
	public final void setRoomBreakfastsrviceFlag(String roomBreakfastsrviceFlag) {
		this.roomBreakfastsrviceFlag = roomBreakfastsrviceFlag;
	}
}