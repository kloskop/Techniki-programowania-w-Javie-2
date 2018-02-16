package cwiczenie2;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String input;
		System.out.println("Wpisz cos");
		while(!(input=scanner.nextLine()).equalsIgnoreCase("Exit")) {
			System.out.println("Wpisales: " + input);
		}
		System.out.println("Wyszedles z aplikacji");
		
		scanner.close();
	}

}