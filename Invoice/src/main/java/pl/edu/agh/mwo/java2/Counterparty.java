package pl.edu.agh.mwo.java2;

import java.util.ArrayList;

public class Counterparty {

	private ArrayList<Invoice> invoicesList;
	private String name;
	private String surname;
	private String phone;
	private String adress;

	public ArrayList<Invoice> getInvoicesList() {
		return invoicesList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Counterparty(String name, String surname, String phone, String adress) {
		
		if(name==null || name.isEmpty() || surname==null || surname.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.adress = adress;
		invoicesList = new ArrayList<Invoice>();
		
		

	}

	public void addInvoice(Invoice invoice) {
		invoicesList.add(invoice);
	}

}
