package pl.edu.agh.mwo.java2;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;


public class Invoice {

	private ArrayList<Product> productList;
	private BigDecimal subTotal;
	private BigDecimal total;
	private BigDecimal tax;
	private LocalDate date;
	private static int number = 0;

	// konstruktor
	private Invoice() {
		subTotal = new BigDecimal("0");
		total = new BigDecimal("0");
		tax = new BigDecimal("0");
		productList = new ArrayList<Product>();
		date=null;
		date = LocalDate.now();
		number++;
	}


	public void addProduct(Product product) {
		productList.add(product);
		update();
	}

	public void addProduct(Product product, Integer quantity) {
		if (quantity <= 0) {
			throw new IllegalArgumentException();
		}
		for (int i = 0; i < quantity; i++) {
			productList.add(product);
		}
		update();
	}

	public void setSubtotal() {
		subTotal = BigDecimal.ZERO;
		for (Product product : productList) {
			subTotal = subTotal.add(product.getPrice());
		}
	}

	public BigDecimal getSubtotal() {
		return subTotal;
	}

	public void setTax() {
		tax = total.subtract(subTotal);
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTotal() {
		total = BigDecimal.ZERO;
		for (Product product : productList) {
			total = total.add(product.getPriceWithTax());
		}
	}

	public BigDecimal getTotal() {
		return total;
	}

	public static Invoice create() {
		return new Invoice();
	}

	public LocalDate getDate() {
		return date;
	}

	public static int getNumber() {
		return number;
	}

	public static void setNumber(int number) {
		Invoice.number = number;
	}

	public void update() {
		setSubtotal();
		setTotal();
		setTax();
		date = LocalDate.now();
	}

}
