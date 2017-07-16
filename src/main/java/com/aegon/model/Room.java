package com.aegon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;

/**
 * @author Sachin
 *
 * Room Details where users booked their stays.
 */

@Entity
@Table(name = "room")
public class Room implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long roomId;
	
	@Column(nullable = false)
	private String roomType;
	
	@Column(nullable = false)
	private float roomPrice;
	
	private float breakFastPrice;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "occupiedId")
	private OccupiedRooms occupiedRooms;
	
	public OccupiedRooms getOccupiedRooms() {
		return occupiedRooms;
	}
	/**
	 * @param occupiedRooms the occupiedRooms to set
	 */
	public void setOccupiedRooms(OccupiedRooms occupiedRooms) {
		this.occupiedRooms = occupiedRooms;
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
	/**
	 * @return the occupiedRooms
	 */
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getRoomType() + "," + getBreakFastPrice() + "," + getRoomPrice();
	}
	
}
