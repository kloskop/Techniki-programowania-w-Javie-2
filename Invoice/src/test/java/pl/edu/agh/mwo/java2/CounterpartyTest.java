package pl.edu.agh.mwo.java2;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

public class CounterpartyTest {


	private static final String Name = "Szymon";
	private static final String Surname = "Gasior";
	private static final String Phone = "222222222";
	private static final String Adress = "ul. Reymonta";

	@Test
	public void testCounterpartyNameSurnamePhoneAdressIsCorrect() {
		// given
		Counterparty counterParty = new Counterparty("Szymon", "Gasior", "222222222", "ul. Reymonta");

		// when
		// then
		assertEquals(Name, counterParty.getName());
		assertEquals(Surname, counterParty.getSurname());
		assertEquals(Phone, counterParty.getPhone());
		assertEquals(Adress, counterParty.getAdress());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCounterpartyNameIsNull() {
		// given
		Counterparty counterParty = new Counterparty(null, Surname, Phone, Adress);

		// when
		// then
		assertEquals(Name, counterParty.getName());
		assertEquals(Surname, counterParty.getSurname());
		assertEquals(Phone, counterParty.getPhone());
		assertEquals(Adress, counterParty.getAdress());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCounterpartySurnameIsNull() {
		// given
		Counterparty counterParty = new Counterparty(Name, null, Surname, Phone);

		// when
		// then
		assertEquals(Name, counterParty.getName());
		assertEquals(Surname, counterParty.getSurname());
		assertEquals(Phone, counterParty.getPhone());
		assertEquals(Adress, counterParty.getAdress());

	}

	
	@Test(expected = IllegalArgumentException.class)
	public void testCounterpartyNameIsEmpty() {
		// given
		Counterparty counterParty = new Counterparty("", Surname, Phone, Adress);

		// when
		// then
		assertEquals(Name, counterParty.getName());
		assertEquals(Surname, counterParty.getSurname());
		assertEquals(Phone, counterParty.getPhone());
		assertEquals(Adress, counterParty.getAdress());

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCounterpartySurnameIsEmpty() {
		// given
		Counterparty counterParty = new Counterparty(Name, "", Surname, Phone);

		// when
		// then
		assertEquals(Name, counterParty.getName());
		assertEquals(Surname, counterParty.getSurname());
		assertEquals(Phone, counterParty.getPhone());
		assertEquals(Adress, counterParty.getAdress());

	}

	
	
	
	
	private void assertBigDecimalsAreEquals(String expected, String actual) {
		assertEquals(0, expected.compareTo(actual));
	}

}
