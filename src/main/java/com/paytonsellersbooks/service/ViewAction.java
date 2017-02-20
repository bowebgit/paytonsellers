package com.paytonsellersbooks.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paytonsellersbooks.dao.jpa.BookDAO;
import com.paytonsellersbooks.dao.jpa.DAOException;
import com.paytonsellersbooks.model.Book;

@Service
@Transactional
public class ViewAction {

	@Autowired
	private BookDAO bookDAO;
	
	public HashMap<String, ArrayList<String>> getCategories() {
		return null;
	}
	
	public ArrayList<Book> getNewArrivals(String category) {
		return null;
	}

	public ArrayList<Book> getBestSelling(String category) {
		return null;
	}

	public Book getBookById(int bookId){
		return null;
	}
	

	public ArrayList<Book> getBooksInCatSubcat(String category, String subcategory){
		return null;
	}

	public ArrayList<Book> getBooksFromSearchQuery(String query){
		return null;
	}
	

	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> books = new ArrayList<Book>();
		try {
			books = bookDAO.findAllBooks();
		} catch (DAOException e) {
			e.printStackTrace();
		}
		return books;
	}

}
