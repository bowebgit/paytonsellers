/**
 * InvoiceDetail.java
 * 
 */

package com.paytonsellersbooks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoice_detail")
public class InvoiceDetail {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="invdet_id", nullable = false)
	private int invdet_id;
	
	@Column(name="inv_id")
	private int inv_id;
	
	@Column(name="invdet_bookid")
	private int invdet_bookid;
	
	@Column(name="invdet_title")
	private String invdet_title;
	
	@Column(name="invdet_author")
	private String invdet_author;
	
	@Column(name="invdet_isbn")
	private String invdet_isbn;
	
	@Column(name="invdet_line")
	private int invdet_line;
	
	@Column(name="invdet_price")
	private int invdet_price;
	
	@Column(name="invdet_units")
	private int invdet_units;

	
	
	/* Getters and Setters */
	public int getInvdet_id() {
		return invdet_id;
	}
	public void setInvdet_id(int invdet_id) {
		this.invdet_id = invdet_id;
	}
	public int getInv_id() {
		return inv_id;
	}
	public void setInv_id(int inv_id) {
		this.inv_id = inv_id;
	}
	public int getInvdet_bookid() {
		return invdet_bookid;
	}
	public void setInvdet_bookid(int invdet_bookid) {
		this.invdet_bookid = invdet_bookid;
	}
	public String getInvdet_title() {
		return invdet_title;
	}
	public void setInvdet_title(String invdet_title) {
		this.invdet_title = invdet_title;
	}
	public String getInvdet_author() {
		return invdet_author;
	}
	public void setInvdet_author(String invdet_author) {
		this.invdet_author = invdet_author;
	}
	public String getInvdet_isbn() {
		return invdet_isbn;
	}
	public void setInvdet_isbn(String invdet_isbn) {
		this.invdet_isbn = invdet_isbn;
	}
	public int getInvdet_line() {
		return invdet_line;
	}
	public void setInvdet_line(int invdet_line) {
		this.invdet_line = invdet_line;
	}
	public int getInvdet_price() {
		return invdet_price;
	}
	public void setInvdet_price(int invdet_price) {
		this.invdet_price = invdet_price;
	}
	public int getInvdet_units() {
		return invdet_units;
	}
	public void setInvdet_units(int invdet_units) {
		this.invdet_units = invdet_units;
	}
		
		


}

