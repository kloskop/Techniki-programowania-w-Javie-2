package cwiczenie4;

import java.io.File;

public class Main {

	public static void main(String args[]) throws Exception {
		printFilesSimple("C:\\");
		//printFilesDetails("C:\\");
		//printFiles("C:\\", ".txt");
		//printTree("C:\\");
	}
 
	public static void printFilesSimple(String path) {
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		for (File file : listOfFiles) {
			System.out.println(file.getName());
		}
	}

	public static void printFilesDetails(String path) throws Exception {
		// to be implemented

	}
	
	public static void printFiles(String path, String extensionFilter) {
		// to be implemented
	}

	public static void printTree(String path) {
		// to be implemented
		// Example
		// dirname
		// dirname/file1
		// dirname/file2
		// dirname/dirname1
		// dirname/dirname1/file1
		// dirname/dirname1/file2
		// dirname/dirname2/file1
	}

}
