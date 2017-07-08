package com.aegon.model;


import javax.persistence.*;



@Entity
@Table(name = "customers")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	private String firstName;
	private String lastName;
	private boolean membershipStatus;
	
	public Customers() {
		
	}
	
	public Customers(String firstName, String lastName, boolean membershipStatus) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.membershipStatus = membershipStatus;
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
	/**
	 * @return the firstName
	 */
	public final String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public final String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the membershipStatus
	 */
	public final boolean isMembershipStatus() {
		return membershipStatus;
	}
	/**
	 * @param membershipStatus the membershipStatus to set
	 */
	public final void setMembershipStatus(boolean membershipStatus) {
		this.membershipStatus = membershipStatus;
	}

}
