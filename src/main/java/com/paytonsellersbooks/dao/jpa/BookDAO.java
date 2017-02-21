package com.paytonsellersbooks.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import com.paytonsellersbooks.entity.Book;

public interface BookDAO {
	
	int insert(Book book) throws DAOException;
	int update(Book book) throws DAOException;
	int delete(int bookId) throws DAOException;
	Book find(int bookId) throws DAOException;
	Book find(String name) throws DAOException;
	
	ArrayList<Book> findBooksByCategory(String category) throws DAOException;
	ArrayList<Book> findBestSelling(String category)throws DAOException;
	ArrayList<Book> findNewArrivals(String category)throws DAOException;
	ArrayList<Book> findBooksInCatSubcat(String category, String subcategory) throws DAOException;
	List<Book> findAllBooks() throws DAOException;
	List<Book> findBooksFromQuery(String query) throws DAOException;


}
