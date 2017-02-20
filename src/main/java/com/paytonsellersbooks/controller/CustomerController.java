package com.paytonsellersbooks.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

// import com.paytonsellersbooks.action.CustomerAction;
// import com.paytonsellersbooks.action.ViewAction;
import com.paytonsellersbooks.service.CustomerAction;
import com.paytonsellersbooks.service.ViewAction;
import com.paytonsellersbooks.entity.Address;
import com.paytonsellersbooks.entity.Book;
import com.paytonsellersbooks.entity.Customer;
import com.paytonsellersbooks.entity.Invoice;
import com.paytonsellersbooks.entity.InvoiceDetail;
import com.paytonsellersbooks.utility.CookieHelper;

@Controller
@RequestMapping(value="/customer")
public class CustomerController {
	
	@Autowired
	private CustomerAction customerAction;
	
	@Autowired
	private ViewAction viewAction;
	
	// customer/my-account
	/**
	 * Returns /customer/MyAccount with customer info, address and shopping cart, and invoices.
	 */
	@RequestMapping(value="/my-account")
	public String myAccount(HttpServletRequest request, Model model){
		return "/customer/MyAccount";
	}
	
	// customer/checkout
	/**
	 * Returns /customer/Shipping with customers address for verification.
	 */
	@RequestMapping(value="/checkout")
	public String checkout(Model model, HttpServletRequest request){
		return "/customer/Shipping";
	}
	
	// /customer/edit-address
	/**
	 * Returns /customer/EditAddress with customers address for updating.
	 */
	@RequestMapping(value="/edit-address")
	public String editAddress(Model model, HttpServletRequest request){
		return "/customer/EditAddress";
	}
	
	// /customer/save-address
	/**
	 * Returns a redirect to /customer/my-account or /customer/shipping after saving/updating address
	 * depending on if the customer was in checkout flow.
	 */
	@RequestMapping(value="/save-address")
	public String saveAddress(HttpServletRequest request, @ModelAttribute Address address){
		return "redirect:/customer/my-account";
	}
	 
	// customer/payment
	/**
	 * Returns /customer/Payment to collect payment info (after user verifies their shipping address).
	 * Sends the current shopping cart, customer, address. 
	 */
	@RequestMapping(value="/payment")
	public String payment(HttpServletRequest request, Model model){
		return "/customer/Payment";
	}
	
	// customer/purchase
	/** 
	 * Returns a redirect to a view for the invoice of newly purchased items. This submits an order. A call to this 
	 * method will verify payment info and save the invoice, clear cookies. Redirect to an invoice view.
	 */
	@RequestMapping(value="/purchase")
	public String purchase(HttpServletRequest request, HttpServletResponse response){
		return "redirect:/home";
	
	}
	
	// customer/invoice/{id}/{invid}
	/**
	 * Returns a view of an invoice. Sends an Invoice object and an array list of InvoiceDetail's 
	 * for the invoice.
	 */
	@RequestMapping(value="/invoice/{id}/{invid}")
	public String viewInvoice(@PathVariable int id, @PathVariable int invid, HttpServletRequest request, Model model){
		return "/customer/Invoice";
	}
	
	/**
	 * Extra security and places 'cusid' in session when its missing.
	 */
	@ModelAttribute
	public void setCusId(HttpServletRequest request, HttpServletResponse response){
	
	}
}
