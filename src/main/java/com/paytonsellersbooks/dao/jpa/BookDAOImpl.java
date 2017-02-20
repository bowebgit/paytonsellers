package com.paytonsellersbooks.dao.jpa;

import java.util.ArrayList;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paytonsellersbooks.entity.Book;

@Service
public class BookDAOImpl implements BookDAO {
		
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * Inserts a book into the database and returns the auto-gen primary key.
	 * @param book		a book
	 * @param conn		a connection
	 * @return 			returns the auto-generated pk id for the inserted book and 
	 * 					returns 0 if no insert occurs. 
	 * @throws DAOException
	 */
	public  int insert(Book book) throws DAOException {
		return	0;
	}

	/**
	 * Updates a book in the database and returns the number of rows affected.
	 * @param book		
	 * @param conn
	 * @return			the number of rows affected by the update
	 * @throws DAOException
	 */
	public  int update(Book book) throws DAOException {
		return 0;
	}

	/**
	 * Removes a book from the database by it's id and returns the number of rows affected.
	 * @param bookId		
	 * @param conn	
	 * @return 				the number of rows affected
	 * @throws DAOException
	 */
	public  int delete(int bookId) throws DAOException {
		return 0;
	}
	
	/**
	 * Returns a book found by it's id.
	 * @return book 		the book found by it's id or new Book if no book was found
	 * @param bookId		the id of the book to find
	 * @param conn			
	 * @throws DAOException
	 */
	public  Book find(int bookId) throws DAOException {		
		return (Book) sessionFactory.getCurrentSession().get(Book.class, bookId);

	}
	public  Book find(String name) throws DAOException {
		//Query query = sessionFactory.
		//		getCurrentSession().
		//		createQuery("from Book where prod_name = :name");
		//query.setParameter("name", name);
		//return (Book) query.list().get(0);
		return null;
	}
	/**
	 * Select (30) books by category.
	 * @param category			a category to search for books
	 * @param conn
	 * @return 					an array list of books from the given category
	 * @throws DAOException
	 */
	public  ArrayList<Book> findBooksByCategory(String category) throws DAOException {
		ArrayList<Book> byCategory = new ArrayList<Book>();
		return byCategory;
	}

	/**
	 * Select the 5 best selling from a category.
	 * @param category			the category to search for best selling
	 * @param conn
	 * @return 					an array list of the 5 best selling from the given category
	 * @throws DAOException
	 */
	public  ArrayList<Book> findBestSelling(String category) throws DAOException {
		ArrayList<Book> bestSelling = new ArrayList<Book>();
		return bestSelling;
	}
	
	/**
	 * Select 5 new arrivals from a category.
	 * @param category			
	 * @param conn
	 * @return 					an array list of the 5 newest books in the given category
	 */

	public  ArrayList<Book> findNewArrivals(String category) throws DAOException {
		ArrayList<Book> newArrivals = new ArrayList<Book>();
		return newArrivals;
	}

	/**
	 * Returns a list of books in the given category-subcategory.
	 * @param category
	 * @param subcategory
	 * @param conn
	 * @return 						an array list of books form the given category-subcategory
	 */
	public  ArrayList<Book> findBooksInCatSubcat(String category, String subcategory) throws DAOException{
		ArrayList<Book> books = new ArrayList<Book>();
		
		return books;
	}

	/**
	 * Fetches all of the books.
	 * @return 		an array list of up to 30 books
	 */
	public  ArrayList<Book> findAllBooks() throws DAOException{
		Book book = new Book();
		book.setBook_title("Unknown");
		ArrayList<Book> books = new ArrayList<Book>();
		books.add(book);
		return books;
	
		
	}
	
	/**
	 * Returns results of user search
	 * @param query			a query term used to search in title, author, descript, etc
	 * @param conn	
	 * @return 				an array list of books matching the query
	 */
	public  ArrayList<Book> findBooksFromQuery(String query) throws DAOException{
		ArrayList<Book> books = new ArrayList<Book>();

		return books;
	}

}
