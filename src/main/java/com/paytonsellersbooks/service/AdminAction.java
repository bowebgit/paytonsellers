package com.paytonsellersbooks.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paytonsellersbooks.entity.Book;

@Service
@Transactional
public class AdminAction {
	
	public Book addBook(Book book){
		return null;
	}
	public int removeBook(int id){
		return 0;
	}
	public Book getBookById(int id){
		return null;
	}
	public int updateBook(Book book){
		return 0;
	}
	public int setCategories(HashMap<String, ArrayList<String>> list, int id){
		return 0;
	}
	public HashMap<String, ArrayList<String>> getBooksCateogories(int id){
		return null;
	}
	public HashMap<String, ArrayList<String>> getBooksCategories(int bookId) {
		HashMap<String, ArrayList<String>> bookCats = new HashMap<String, ArrayList<String>>();
				
		return bookCats;
	}
}
