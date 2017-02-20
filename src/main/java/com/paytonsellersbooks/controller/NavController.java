package com.paytonsellersbooks.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// import com.paytonsellersbooks.action.CustomerAction;
// import com.paytonsellersbooks.action.ViewAction;
import com.paytonsellersbooks.service.CustomerAction;
import com.paytonsellersbooks.service.ViewAction;
import com.paytonsellersbooks.model.Customer;

@Controller
public class NavController {
	
	@Autowired
	private CustomerAction customerAction;
	
	@Autowired
	private ViewAction viewAction;
	
	// Returns /HoursAndLocation.jsp
	@RequestMapping(value="/hours-and-location")
	public String hoursAndLocation(Model model, HttpServletRequest request){
		// Get categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories(); 
		model.addAttribute("categories", categories);
		
		return "HoursAndLocation";
	}
	
	// Returns /ShippingInfo.jsp
	@RequestMapping(value="/shipping-info")
	public String shipping(Model model){
		// Get categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories(); 
		model.addAttribute("categories", categories);
		return "ShippingInfo";
	}
	
	// /Returns /Support.jsp
	@RequestMapping(value="/support")
	public String support(Model model){
		// Get categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories(); 
		model.addAttribute("categories", categories);
		return "Support";
	} 
	
	// Returns TermsAndConditions.jsp
	@RequestMapping(value="/terms-and-conditions")
	public String termsAndConditions(Model model){
		// Get categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories(); 
		model.addAttribute("categories", categories);
		return "TermsAndConditions";
	}
	
	// Redirects to /home
	@RequestMapping(value="/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response){
		request.getSession().setAttribute("cusid", null);
		request.getSession().invalidate();
		
		try {
			response.sendRedirect("home");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Returns /Login. A request to '/userlogin' is restricted. Tomcat uses 
	// this url mapping for login form page.
	@RequestMapping(value="/login")
	public String login(Model model){
		// Get categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories(); 
		model.addAttribute("categories", categories);
		return "Login";
	}
	
	// Redirects to /home
	/**
	 * Returns a redirect to /home after setting the session attribute 'cusid' to the customers id. 
	 * This url is restricted to 'admin' and 'user' roles. If not a 'user' or 'admin', 
	 * Tomcat redirects to /login for authentication. Once accessed, this sets cusid in the session.
	 */
	@RequestMapping(value="/userlogin")
	public String userlogin(HttpServletRequest request, HttpServletResponse response, 
				RedirectAttributes redirectAttributes) {
		
		String email = request.getRemoteUser();

		int id = customerAction.getIdAtLogin(email);
		
		request.getSession().setAttribute("cusid", id);
		
		if(request.isUserInRole("admin"))
			return "redirect:/admin/admin-front";
		
		return "redirect:/home";
	}

	// Returns /Register.jsp
	@RequestMapping(value="/register")
	public String register(Model model){
		// Get categories
		HashMap<String, ArrayList<String>> categories = viewAction.getCategories(); 
		model.addAttribute("categories", categories);
		
		model.addAttribute("customer", new Customer());
		
		return "Register";
	}
	
	// Redirects to /userlogin after register a new user, or Returns /Register.jsp if errors
	@RequestMapping(value="userregister")
	public String register(@ModelAttribute Customer customer, Model model, HttpServletResponse response,
			RedirectAttributes redirectAttributes) {
		
		// verify input
		if(customer.getCus_first().trim().equals("") ||
				customer.getCus_last().trim().equals("") ||
				customer.getCus_email().trim().equals("") || 
				customer.getCus_pass().trim().equals("") ||
				!(customer.getCus_email().trim().contains("@") )){
			// User input failure
			model.addAttribute("error", "Enter a valid email and password.");
			return "Register";
		}

		customer = customerAction.registerUser(customer);
		if(customer.getCus_id() == 0){
			model.addAttribute("error", "Email is taken.");
			return "Register";
		}
		
		redirectAttributes.addFlashAttribute("mssg", "Thanks for signing up!");
		return "redirect:/userlogin";
	}

}
