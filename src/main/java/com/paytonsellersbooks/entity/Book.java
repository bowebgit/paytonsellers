package com.paytonsellersbooks.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="book")
public class Book {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="book_id", nullable = false)
	private int book_id;
	
	@Column(name="book_title")
	private String book_title;
	@Column(name="book_author_first")	
	private String book_author_first;
	@Column(name="book_author_last")
	private String book_author_last;
	@Column(name="book_descript")
	private String book_descript;
	@Column(name="book_publisher")
	private String book_publisher;
	@Column(name="book_pubyear")
	private Integer book_pubyear;
	@Column(name="book_isbn")
	private String book_isbn;
	@Column(name="book_length")
	private String book_length;
	@Column(name="book_dim")
	private String book_dim;
	@Column(name="book_format")
	private String book_format;
	@Column(name="book_price")
	private Integer book_price;
	@Column(name="book_buycounter", nullable = false)
	private int book_buycounter;
	@Column(name="book_viewcounter", nullable = false)
	private int book_viewcounter;
	@Column(name="book_img")
	private String book_img;
	@Column(name="book_date")
	private Date book_date;
	
	/* Getters and Setters */
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public String getBook_author_first() {
		return book_author_first;
	}
	public void setBook_author_first(String book_author_first) {
		this.book_author_first = book_author_first;
	}
	public String getBook_author_last() {
		return book_author_last;
	}
	public void setBook_author_last(String book_author_last) {
		this.book_author_last = book_author_last;
	}
	@XmlTransient
	public String getBook_descript() {
		return book_descript;
	}
	public void setBook_descript(String book_descript) {
		this.book_descript = book_descript;
	}
	public String getBook_publisher() {
		return book_publisher;
	}
	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}
	public Integer getBook_pubyear() {
		return book_pubyear;
	}
	public void setBook_pubyear(Integer book_pubyear) {
		this.book_pubyear = book_pubyear;
	}
	public String getBook_isbn() {
		return book_isbn;
	}
	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}
	@XmlTransient
	public String getBook_length() {
		return book_length;
	}
	public void setBook_length(String book_length) {
		this.book_length = book_length;
	}
	@XmlTransient
	public String getBook_dim() {
		return book_dim;
	}
	public void setBook_dim(String book_dim) {
		this.book_dim = book_dim;
	}
	@XmlTransient
	public String getBook_format() {
		return book_format;
	}
	public void setBook_format(String book_format) {
		this.book_format = book_format;
	}
	public Integer getBook_price() {
		return book_price;
	}
	public void setBook_price(Integer book_price) {
		this.book_price = book_price;
	}
	@XmlTransient
	public int getBook_buycounter() {
		return book_buycounter;
	}
	public void setBook_buycounter(int i) {
		this.book_buycounter = i;
	}
	@XmlTransient
	public int getBook_viewcounter() {
		return book_viewcounter;
	}
	public void setBook_viewcounter(int i) {
		this.book_viewcounter = i;
	}
	@XmlTransient
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String img) {
		this.book_img = img;
	}
	@XmlTransient
	public Date getBook_date() {
		return book_date;
	}
	public void setBook_date(Date book_date) {
		this.book_date = book_date;
	}
	
	
}
