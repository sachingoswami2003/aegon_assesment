package com.aegon.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="customer_Id_gen", sequenceName="customer_Id", initialValue = 1)
	@GeneratedValue(generator = "customer_Id_gen")
	private Long customerId;
	private String firstName;
	private String lastName;
	private boolean membershipStatus;
	private Book book;
	
	/**
	 * @return the book
	 */
	public Book getBook() {
		return book;
	}

	/**
	 * @param book the book to set
	 */
	public void setBook(Book book) {
		this.book = book;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getFirstName()+ "," + getLastName()+ "," +isMembershipStatus();
	}
	
	
}
