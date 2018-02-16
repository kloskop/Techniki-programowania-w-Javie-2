package cwiczenie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		// scanFile("res/cwiczenie1/poem.txt","was");
		readFile("res/cwiczenie1/poem.txt", "was");
		//readChars("res/cwiczenie1/poem.txt");
	}

	private static void scanFile(String filename, String keyword) throws Exception {
		File poemFile = new File(filename);
		Scanner scanner = new Scanner(poemFile);
		int foundTokens = 0;
		while (scanner.hasNext()) {
			String actualWord = scanner.next();
			if (actualWord.equalsIgnoreCase(keyword)) {
				foundTokens++;
				// System.out.println(actualWord);
			}
		}
		System.out.println("Found tokens: " + foundTokens);
		System.out.println("File path: " + poemFile.getAbsolutePath());

		Long space = poemFile.getFreeSpace();
		double spaceKb = space / 1024;
		double spaceMb = space / (1024 * 1024);
		double spaceGb = space / (1024 * 1024 * 1024);

		System.out.println("Free Space in Kb:" + spaceKb + " Kb.");
		System.out.println("Free Space in Mb:" + spaceMb + " Mb.");
		System.out.println("Free Space in Gb:" + spaceGb + " Gb.");
		scanner.close();
	}

	private static void readFile(String filename, String... keywords) throws Exception {
		File poemFile = new File(filename);
		int lineCounter = 0;
		int howManyLinesFound = 0;
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				for (String keyword : keywords) {
					++lineCounter;
					if (line.toLowerCase().contains(keyword.toLowerCase())) {
						howManyLinesFound++;
						System.out.println(lineCounter + ": " + line);
					}
				}
			}
			System.out.println("Found " + howManyLinesFound + " lines");
		} catch (IOException x) {
			System.err.format("IOException: %s", x);
		}

	}

	private static void readChars(String filename) throws Exception {

		File poemFile = new File(filename);
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
			int letter = 0;
			int lineCounter = 0;
			int charCounter = 0;
			while ((letter = reader.read()) != -1) {
				if ((char) letter == '\n') {
					lineCounter++;
					System.out.println("Number of chars in a line: " + charCounter);
					charCounter = 0;
				} else if ((char) letter != '\r') {
					System.out.print((char) letter);
					charCounter++;
				}

			}
		}
	}
}
