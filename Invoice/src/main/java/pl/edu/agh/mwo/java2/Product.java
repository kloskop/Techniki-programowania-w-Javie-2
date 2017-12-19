package pl.edu.agh.mwo.java2;

import java.math.BigDecimal;

public class Product {
	
	private static final BigDecimal DEFAULT_TAX = BigDecimal.valueOf(0.23);
	
	private final String name;
	
	private final BigDecimal price;
	
	private final BigDecimal taxPercent;
	
	private Product(final String name, final BigDecimal price, final BigDecimal tax) {
		if(name==null || name.isEmpty() || price==null || tax==null) {
			throw new IllegalArgumentException();
		}
		if (price.signum()==-1 || tax.signum()==-1) {
			throw new IllegalArgumentException();	
		}
		this.name = name;
		this.price = price;
		this.taxPercent = tax;
	}
	
	public String getName() {
		return name;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
	
	public BigDecimal getTaxPercent() {
		return taxPercent;
	}
	
	public BigDecimal getPriceWithTax() {
		BigDecimal sumPriceAndTax= price.add(price.multiply(taxPercent));
		
		return sumPriceAndTax;
	}
	
	
	public static Product create(final String name, final BigDecimal price, final BigDecimal tax) {
		return new Product(name, price, tax);
	}
	
	public static Product create(final String name, final BigDecimal price) {
		return create(name, price, DEFAULT_TAX);
	}
}
