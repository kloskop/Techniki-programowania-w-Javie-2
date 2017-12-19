public class Palindrom {

	public static boolean isPalindrom(String text) {

		boolean result = true;
		String[] formatedText = formatText(text);

		for (int i = 0; i < formatedText.length; i++) {
			int howManyCharsToCheck = 0;
			int counter = 0;
			howManyCharsToCheck = formatedText[i].length() / 2;
			for (int j = 0; j < howManyCharsToCheck; j++) {
				if (formatedText[i].charAt(j) == formatedText[i].charAt(formatedText[i].length() - 1 - j)) {
					counter++;
				}
			}
			if (howManyCharsToCheck != counter) {
				return false;
			}

		}
		return result;
	}

	public static String[] formatText(String text) {
		String formatedText = text.replace('(', ' ').replace(')', ' ').replace('!', ' ').replace('?', ' ')
				.replace('.', ' ').replaceAll(" ", "").replaceAll(",", "").replaceAll("-", "").replaceAll("\"", "").toLowerCase();
		return formatedText.split("\n");
	}

	public static void printInfoAboutPalindrom(String text) {
		if (isPalindrom(text)) {
			System.out.println("\nTen tekst jest palindromem: \n" + text);
		} else {
			System.out.println("\nTen tekst nie jest palindromem: \n" + text);
		}

	}

	public static void main(String[] args) {
		
		String palindrom1 = "\"Iwono, ty rabuj okop spokoju barytonowi\n" + "I zduna zaraz cna japa janczara zanudzi\n"
				+ "I lali masoni wydrom w mordy wino, sami lali\"";

		String palindrom2 = "radar";
		String palindrom3 = "Zagwi¿d¿ i w gaz";
		String palindrom4= "Lorem ipsum";
		String palindrom5= "Koby³a ma pa³ac (da³ w³adca £ap) a ma³y bok.\n" + 
				"Koby³ami Krak ³ama³ kark i ma³y bok.\n" + 
				"Koby³a ma katar (atak) a ma³y bok.";
		String palindrom6= "Lorem ipsum dolor sit amet,\n" + 
				"consectetur adipiscing elit,\n" + 
				"sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

		printInfoAboutPalindrom(palindrom1);
		printInfoAboutPalindrom(palindrom2);
		printInfoAboutPalindrom(palindrom3);
		printInfoAboutPalindrom(palindrom4);
		printInfoAboutPalindrom(palindrom5);
		printInfoAboutPalindrom(palindrom6);
	}

}
