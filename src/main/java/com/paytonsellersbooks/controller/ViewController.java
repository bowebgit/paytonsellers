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
import com.paytonsellersbooks.entity.Book;

import com.paytonsellersbooks.entity.InvoiceDetail;
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
		
		return "Cart";
	}
	
	// Returns /BookDetail.jsp
	@RequestMapping(value="/view-book/{id}")
	public String viewBook(Model model, @PathVariable Integer id){
		// Get categories
		//HashMap<String, ArrayList<String>> categories = viewAction.getCategories();
		//model.addAttribute("categories", categories);
		
		Book book = viewAction.getBookById(id);
		model.addAttribute("book", book);
		
		return "/BookDetail";
	}
	
	// Returns /Category.jsp 
	@RequestMapping(value="/category/{category}")
	public String category(@PathVariable String category, Model model, HttpServletRequest request){
		return "/Category";
	}

	// Returns /Subcategory.jsp 
	@RequestMapping(value="/category/{category}/{subcategory}")
	public String subcategory(@PathVariable String category, @PathVariable String subcategory, 
			HttpServletRequest request, Model model){
		
		return "/Subcategory";
	}
	
	// Returns /Categories.jsp
	@RequestMapping(value="/all-categories")
	public String categories(Model model){
		
		return "/Categories";
	}
	
	// Returns /Results.jsp
	@RequestMapping(value="/search")
	public String search(Model model, HttpServletRequest req, HttpServletResponse res){
		String query = (String) req.getParameter("q");
		
		//HashMap<String, ArrayList<String>> categories = viewAction.getCategories();
		//model.addAttribute("categories", categories);
		
		ArrayList<Book> books = viewAction.getBooksFromSearchQuery(query);
		model.addAttribute("books", books);
		return "/Results";
	} 
	
	// redirects to /view-cart
	@RequestMapping(value="/add-to-cart", method=RequestMethod.POST)
	public String addToCart(Model model, HttpServletRequest request, HttpServletResponse response ){
		return  "redirect:/view-cart";
	}
	
	// redirects to /view-cart
	@RequestMapping(value="/update-cart", method=RequestMethod.POST)
	public String removeBook(HttpServletRequest request, HttpServletResponse response){
		
		return "redirect:/view-cart";
	}
	
}

