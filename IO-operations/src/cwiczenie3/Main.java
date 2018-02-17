package cwiczenie3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static String[] stringsToBeWritten = { "Joh Woo 001", "Robert Duval 002", "James Bond 007" };

	public static void main(String args[]) throws Exception {
		// saveAgents(stringsToBeWritten, "res/cwiczenie3/special-agents.txt");
		//saveAgents2(stringsToBeWritten, "res/cwiczenie3/special-agents.txt");
		// modifyFile("res/cwiczenie3/special-agents.txt", "text");
		// makeDirectories();
		//copyFiles();
	}

	private static void saveAgents(String[] agents, String filename) throws Exception { // Podstawowe funkcje
		File file = new File(filename);
		PrintWriter printWriter = new PrintWriter(file, "UTF-8");

		for (String agent : agents) {
			printWriter.println(agent);
		}
		printWriter.close();
	}

	private static void saveAgents2(String[] agents, String filename) throws Exception {
		; // Dopisywanie do pliku
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filename), true /* append = true */));
		pw.println("Dodanie nowej lini do istniejacego pliku jezeli w append jest true");
		pw.close();
	}

	private static void modifyFile(String filename, String text) throws Exception {
		// Swobodny dostep do pliku
		RandomAccessFile raf = new RandomAccessFile(filename, "rw");
		raf.seek(4);
		raf.writeBytes(text);
		raf.close();
	}

	private static void makeDirectories() { // Tworzenie katalogów
		new File("Directory2\\Sub2").mkdirs();
		new File("Directory2\\Sub1").mkdirs();
	}

//	private static void copyFiles() throws Exception { // kopiowanie pliku nie dziala
//
//		Path sourcePath = Paths.get("res/cwiczenie3/special-agents.txt");
//		Path destinationPath = Paths.get("Directory2/Sub1");
//
//		try {
//			Files.copy(sourcePath, destinationPath);
//		} catch (FileAlreadyExistsException e) {
//			// destination file already exists
//		} catch (IOException e) {
//			// something else went wrong
//			e.printStackTrace();
//		}
//	}

}
