package com.aegon.model;

import org.springframework.stereotype.Component;

@Component
public class Customer {
	
	private String customerId;
	private String firstName;
	private String lastName;
	private boolean membershipStatus;
	/**
	 * @return the customerId
	 */
	public final String getCustomerId() {
		return customerId;
	}
	/**
	 * @param customerId the customerId to set
	 */
	public final void setCustomerId(String customerId) {
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
