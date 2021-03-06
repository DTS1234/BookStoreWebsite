package com.bookstore.entity;
// Generated 2019-05-29 00:20:05 by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Customer generated by hbm2java
 */
@Entity
@Table(name = "customer", catalog = "bookstoredb", uniqueConstraints = @UniqueConstraint(columnNames = "e-mail"))
public class Customer implements java.io.Serializable {

	private int customerId;
	private String EMail;
	private String fullname;
	private String address;
	private String city;
	private String country;
	private String phoneNumber;
	private String zipCode;
	private String password;
	private Date regitsterDate;
	private Set<ReviewTable> reviewTables = new HashSet<ReviewTable>(0);
	private Set<BookOrder> bookOrders = new HashSet<BookOrder>(0);

	public Customer() {
	}

	public Customer(int customerId, String EMail, String fullname, String address, String city, String country,
			String phoneNumber, String zipCode, String password, Date regitsterDate) {
		this.customerId = customerId;
		this.EMail = EMail;
		this.fullname = fullname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.password = password;
		this.regitsterDate = regitsterDate;
	}

	public Customer(int customerId, String EMail, String fullname, String address, String city, String country,
			String phoneNumber, String zipCode, String password, Date regitsterDate, Set<ReviewTable> reviewTables,
			Set<BookOrder> bookOrders) {
		this.customerId = customerId;
		this.EMail = EMail;
		this.fullname = fullname;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.password = password;
		this.regitsterDate = regitsterDate;
		this.reviewTables = reviewTables;
		this.bookOrders = bookOrders;
	}

	@Id

	@Column(name = "customer_id", unique = true, nullable = false)
	public int getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Column(name = "e-mail", unique = true, nullable = false, length = 64)
	public String getEMail() {
		return this.EMail;
	}

	public void setEMail(String EMail) {
		this.EMail = EMail;
	}

	@Column(name = "fullname", nullable = false, length = 30)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "address", nullable = false, length = 128)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", nullable = false, length = 32)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "country", nullable = false, length = 64)
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "phone_number", nullable = false, length = 15)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "zip_code", nullable = false, length = 24)
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "password", nullable = false, length = 16)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "regitster_date", nullable = false, length = 19)
	public Date getRegitsterDate() {
		return this.regitsterDate;
	}

	public void setRegitsterDate(Date regitsterDate) {
		this.regitsterDate = regitsterDate;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<ReviewTable> getReviewTables() {
		return this.reviewTables;
	}

	public void setReviewTables(Set<ReviewTable> reviewTables) {
		this.reviewTables = reviewTables;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<BookOrder> getBookOrders() {
		return this.bookOrders;
	}

	public void setBookOrders(Set<BookOrder> bookOrders) {
		this.bookOrders = bookOrders;
	}

}
