package com.aegon.model;

import java.io.Serializable;

import java.util.Date;

import javax.validation.constraints.Null;

import org.springframework.stereotype.Component;
@Component
public class Book implements Serializable {
	
	@Null
	private String bookingId;
	private String customerId;
	private String checkInDate;
	private String checkOutDate;
	private int noOfRoomRequired;
	private boolean roomBreakfastsrviceFlag;
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
	public final String getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId
	 *            the bookingId to set
	 */
	public final void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the customerId
	 */
	public final String getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId
	 *            the customerId to set
	 */
	public final void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the checkIn
	 */
	public final String getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param string
	 *            the checkIn to set
	 */
	public final void setCheckInDate(String checkIn) {
		this.checkInDate = checkIn;
	}

	/**
	 * @return the checkOut
	 */
	public final String getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOut
	 *    the checkOut to set
	 */
	public final void setCheckOutDate(String checkOut) {
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
}