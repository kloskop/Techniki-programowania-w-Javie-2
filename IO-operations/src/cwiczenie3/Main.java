package cwiczenie3;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static String[] stringsToBeWritten = { "Joh Woo 001", "Robert Duval 002", "James Bond 007" };

	public static void main(String args[]) throws Exception {
		saveAgents(stringsToBeWritten, "res/cwiczenie3/special-agents.txt");
	}

	private static void saveAgents(String[] agents, String filename) throws Exception {
		File file = new File(filename);
		PrintWriter printWriter = new PrintWriter(file, "UTF-8");
		
		for (String agent : agents) {
			printWriter.println(agent);
		}
		printWriter.close();
	}
}
