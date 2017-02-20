package com.paytonsellersbooks.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="cus_id", nullable = false)
	private int cus_id;
	
	@OneToMany
	@JoinColumn(name="cus_id", referencedColumnName="cus_id")
	private List<Invoice> invoice;
	
	@Column(name="cus_first")
	private String cus_first;
	
	@Column(name="cus_last")
	private String cus_last;
	
	@Column(name="cus_email")
	private String cus_email;
	
	@OneToOne
	@JoinColumn(name="cus_id")
	private Address address;
	
	@Column(name="cus_pass")
	private String cus_pass;
	
	@Column(name="cus_date")
	private Date cus_date;
	
	
	/* Getters and Setters */
	public List<Invoice> getInvoice() {
		return invoice;
	}
	public void setInvoice(List<Invoice> invoice) {
		this.invoice = invoice;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getCus_first() {
		return cus_first;
	}
	public void setCus_first(String cus_first) {
		this.cus_first = cus_first;
	}
	public String getCus_last() {
		return cus_last;
	}
	public void setCus_last(String cus_last) {
		this.cus_last = cus_last;
	}
	public String getCus_email() {
		return cus_email;
	}
	public void setCus_email(String cus_email) {
		this.cus_email = cus_email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getCus_pass() {
		return cus_pass;
	}
	public void setCus_pass(String cus_pass) {
		this.cus_pass = cus_pass;
	}
	public Date getCus_date() {
		return cus_date;
	}
	public void setCus_date(Date cus_date) {
		this.cus_date = cus_date;
	}
	

	
}
