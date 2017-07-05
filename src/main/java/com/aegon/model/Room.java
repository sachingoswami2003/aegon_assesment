package com.aegon.model;

import org.springframework.stereotype.Component;

@Component
public class Room {

	private String roomId;
	private String roomType;
	private String roomStatus;
	private String roomPrice;
	
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
	 * @return the roomStatus
	 */
	public final String getRoomStatus() {
		return roomStatus;
	}
	/**
	 * @param roomStatus the roomStatus to set
	 */
	public final void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}
	/**
	 * @return the roomPrice
	 */
	public final String getRoomPrice() {
		return roomPrice;
	}
	/**
	 * @param roomPrice the roomPrice to set
	 */
	public final void setRoomPrice(String roomPrice) {
		this.roomPrice = roomPrice;
	}
	
}
