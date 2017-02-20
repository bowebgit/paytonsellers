package com.paytonsellersbooks.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="add_id", nullable = false)
	private int add_id;
	
	@Column(name="cus_id")
	private int cus_id;
	
	@Column(name="add_l1")
	private String add_l1;
	
	@Column(name="add_l2")
	private String add_l2;
	
	@Column(name="add_city")
	private String add_city;
	
	@Column(name="add_state")
	private String add_state;
	
	@Column(name="add_zip")
	private String add_zip;
	
	@Column(name="add_phone")
	private int add_phone;
	
	/* Getters and Setters */
	public int getAdd_id() {
		return add_id;
	}
	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}
	public int getCus_id() {
		return cus_id;
	}
	public void setCus_id(int cus_id) {
		this.cus_id = cus_id;
	}
	public String getAdd_l1() {
		return add_l1;
	}
	public void setAdd_l1(String add_l1) {
		this.add_l1 = add_l1;
	}
	public String getAdd_l2() {
		return add_l2;
	}
	public void setAdd_l2(String add_l2) {
		this.add_l2 = add_l2;
	}
	public String getAdd_city() {
		return add_city;
	}
	public void setAdd_city(String add_city) {
		this.add_city = add_city;
	}
	public String getAdd_state() {
		return add_state;
	}
	public void setAdd_state(String add_state) {
		this.add_state = add_state;
	}
	public String getAdd_zip() {
		return add_zip;
	}
	public void setAdd_zip(String add_zip) {
		this.add_zip = add_zip;
	}
	public int getAdd_phone() {
		return add_phone;
	}
	public void setAdd_phone(int add_phone) {
		this.add_phone = add_phone;
	}
	
	
}
