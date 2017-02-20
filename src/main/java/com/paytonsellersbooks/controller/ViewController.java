package com.paytonsellersbooks.controller;
 
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// import com.paytonsellersbooks.action.CustomerAction;
// import com.paytonsellersbooks.action.ViewAction;
import com.paytonsellersbooks.service.CustomerAction;
import com.paytonsellersbooks.service.ViewAction;
import com.paytonsellersbooks.model.Book;
import com.paytonsellersbooks.model.Customer;
import com.paytonsellersbooks.model.InvoiceDetail;
import com.paytonsellersbooks.utility.CookieHelper;

@Controller
public class ViewController {

	@Autowired
	private ViewAction viewAction;
	
	@Autowired
	private CustomerAction customerAction;
	
	// Returns /Home.jsp
	@RequestMapping(value="/home")
	public String home(Model model, HttpServletRequest request){
		
		ArrayList<Book> books = new ArrayList<Book>();
		books = viewAction.getAllBooks();
		model.addAttribute("books", books);
		
		//ArrayList<Book> litAndFic = viewAction.getBestSelling("Literature & Fiction");
		//model.addAttribute("litAndFic", litAndFic);
		//ArrayList<Book> sciFi = viewAction.getBestSelling("Sci-Fi & Fantasy");
		//model.addAttribute("sciFi", sciFi);
		
		// Get categories
		//HashMap<String, ArrayList<String>> categories = viewAction.getCategories();
		//model.addAttribute("categories", categories);
		return "/Home";
	}
	
	// Returns /Cart.jsp
	@RequestMapping(value="/view-cart")
	public String viewCart(Model model, HttpServletRequest request){
		// Get  existing categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories();
		model.addAttribute("categories", categories);
		
		ArrayList<InvoiceDetail> cart = new ArrayList<InvoiceDetail>();

		int invLineCounter = 1;
		Cookie[] cookies = request.getCookies();		
		CookieHelper helper = new CookieHelper();
		if (cookies != null) {
			for(int i=0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String id = helper.getIdFromCookie(cookie.getName());
				if(id != null){
					InvoiceDetail invdet = new InvoiceDetail();
					
					int d = Integer.parseInt(id);
					Book b = viewAction.getBookById(d);
					if(b.getBook_id() != 0){
						invdet.setInvdet_bookid(b.getBook_id());
						invdet.setInvdet_title(b.getBook_title());
						invdet.setInvdet_author(b.getBook_author_first() + " " + b.getBook_author_last());
						invdet.setInvdet_isbn(b.getBook_isbn());
						invdet.setInvdet_line(invLineCounter);
							invLineCounter++;
						invdet.setInvdet_price(b.getBook_price());
						int units = Integer.parseInt(cookie.getValue());
						invdet.setInvdet_units(units);
						
						cart.add(invdet);
					}
				}
				 
			}
		}
		if(cart.isEmpty()){
			cart = null;
		}
		model.addAttribute("cart", cart);
		
		// If they're signed show their info in the cart.
		Customer customer = new Customer();
		try{
			int cusId = (Integer) request.getSession().getAttribute("cusid");
			customer = customerAction.getCustomerAndAddress(cusId);
		}catch(NullPointerException e){
			// e.printStackTrace();
		}
		model.addAttribute("customer", customer);

		
		return "Cart";
	}
	
	// Returns /BookDetail.jsp
	@RequestMapping(value="/view-book/{id}")
	public String viewBook(Model model, @PathVariable Integer id){
		// Get categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories();
		model.addAttribute("categories", categories);
		
		Book book = viewAction.getBookById(id);
		model.addAttribute("book", book);
		
		return "/BookDetail";
	}
	
	// Returns /Category.jsp 
	@RequestMapping(value="/category/{category}")
	public String category(@PathVariable String category, Model model, HttpServletRequest request){
		model.addAttribute("category", category); // category is simply a String.
		
		ArrayList<Book> bestSelling = viewAction.getBestSelling(category);
		ArrayList<Book> newArrivals = viewAction.getNewArrivals(category);
		model.addAttribute("bestSelling", bestSelling);
		model.addAttribute("newArrivals", newArrivals);
		
		
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories();
		ArrayList<String> subcats = new ArrayList<String>();
		for(String key : categories.keySet()){ // gets subcats from the HashMap above
			if(key.equals(category)){
				subcats = categories.get(key);
			}
		}
		model.addAttribute("subcats", subcats);
		
		return "/Category";
	}

	// Returns /Subcategory.jsp 
	@RequestMapping(value="/category/{category}/{subcategory}")
	public String subcategory(@PathVariable String category, @PathVariable String subcategory, 
			HttpServletRequest request, Model model){
		
		model.addAttribute("category", category); // category is simply a String
		model.addAttribute("subcategory", subcategory); // simply a String for the view

		ArrayList<Book> books = viewAction.getBooksInCatSubcat(category, subcategory);
		model.addAttribute("books", books);
		
		
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories();
		ArrayList<String> subcats = new ArrayList<String>();
		for(String key : categories.keySet()){ // gets subcats from the HashMap above.
			if(key.equals(category)){
				subcats = categories.get(key);
			}
		}
		model.addAttribute("subcats", subcats);

		return "/Subcategory";
	}
	
	// Returns /Categories.jsp
	@RequestMapping(value="/all-categories")
	public String categories(Model model){
		// Get existing categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories();
		model.addAttribute("categories", categories);
		
		return "/Categories";
	}
	
	// Returns /Results.jsp
	@RequestMapping(value="/search")
	public String search(Model model, HttpServletRequest req, HttpServletResponse res){
		String query = (String) req.getParameter("q");
		
		// Get categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories();
		model.addAttribute("categories", categories);
		
		ArrayList<Book> books = viewAction.getBooksFromSearchQuery(query);
		model.addAttribute("books", books);

		return "/Results";
	} 
	
	// redirects to /view-cart
	@RequestMapping(value="/add-to-cart", method=RequestMethod.POST)
	public String addToCart(Model model, HttpServletRequest request, HttpServletResponse response ){
		String bookId = (String) request.getParameter("bookId");
		String qty = (String) request.getParameter("units");
		
		Cookie book = new Cookie("paytonsellers_" + bookId, qty);
		book.setMaxAge(60*60*24*365); // 1 year
		book.setPath("/");
		response.addCookie(book);
		return  "redirect:/view-cart";
	}
	
	// redirects to /view-cart
	@RequestMapping(value="/update-cart", method=RequestMethod.POST)
	public String removeBook(HttpServletRequest request, HttpServletResponse response){
		
		String bookId = request.getParameter("bookId");
		
		Cookie[] cookies = request.getCookies();
		CookieHelper helper = new CookieHelper();
		if(cookies != null){
			for(Cookie cookie : cookies){
				String id = helper.getIdFromCookie(cookie.getName());
				if(id != null){
					if(id.equals(bookId)){
						cookie.setValue(null);
						cookie.setMaxAge(0);
						cookie.setPath("/");
						response.addCookie(cookie);
					}
				}
			}
		}
		return "redirect:/view-cart";
	}
	
}

