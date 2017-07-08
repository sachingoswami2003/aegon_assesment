package com.aegon.model;

import javax.persistence.*;

/**
 * @author Sachin
 *
 * Room Details where users booked their stays.
 */

@Entity
@Table(name = "room")
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String roomId;
	private String roomType;
	private float roomPrice;
	private float breakFastPrice;
	
	
	public Room(String roomType, float roomPrice, float breakFastPrice) {
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.breakFastPrice = breakFastPrice;
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
	 * @return the roomPrice
	 */
	public final float getRoomPrice() {
		return roomPrice;
	}
	/**
	 * @param roomPrice the roomPrice to set
	 */
	public final void setRoomPrice(float roomPrice) {
		this.roomPrice = roomPrice;
	}
	/**
	 * @return the breakFastPrice
	 */
	public final float getBreakFastPrice() {
		return breakFastPrice;
	}
	/**
	 * @param breakFastPrice the breakFastPrice to set
	 */
	public final void setBreakFastPrice(float breakFastPrice) {
		this.breakFastPrice = breakFastPrice;
	}
	
}
