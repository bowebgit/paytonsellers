package com.paytonsellersbooks.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paytonsellersbooks.entity.Address;
import com.paytonsellersbooks.entity.Customer;
import com.paytonsellersbooks.entity.Invoice;
import com.paytonsellersbooks.entity.InvoiceDetail;

@Service
@Transactional
public class CustomerAction {

	public Customer registerUser(Customer customer) {
		return null;
	}
	public int getIdAtLogin(String email){
		return 0;
	}

	public Customer getCustomerAndAddress(int cusId){
		return null;
	}

	public Address saveAddress(Address address, int cusId){
		return null;
	}

	public ArrayList<Invoice> getAllInvoices(int cusId){
		return null;
	}

	public ArrayList<InvoiceDetail> getInvoiceDetailsByInvId(int invId){
		return null;
	}

	public Invoice getInvoiceById(int invId){
		return null;
	}


	public Invoice saveInvoice(Invoice invoice, ArrayList<InvoiceDetail> invoiceDetails, int cusId){ 
			return null;
	}
}
