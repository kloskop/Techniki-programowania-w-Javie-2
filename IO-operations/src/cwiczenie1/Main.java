package cwiczenie1;

import java.io.File;
import java.util.Scanner;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.io.IOException;

public class Main {

	public static void main(String args[]) throws Exception {
		readChars("res/cwiczenie1/poem.txt");
		readFile("res/cwiczenie1/poem.txt");
		scanFile("res/cwiczenie1/poem.txt", "a");
	}
	
	private static void readChars(String filename) {
		File poemFile = new File(filename);
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
		    int letter = 0;
		    int lineCounter = 0;
		    int charCounter = 0;
		    while ((letter = reader.read()) !=-1) {
		    	if((char)letter == '\n') {
				    lineCounter++;	
				    System.out.println("Number of chars in a line: " + charCounter);
				    charCounter = 0;
		    	} else if ((char)letter != '\r') {
//		    	  	System.out.print((char) letter);
		    	  	charCounter++;		    	  	
		    	}
		    }
		    
		    System.out.println("Number of lines " + (lineCounter + 1));
		} catch (IOException x) {
		    System.err.format("IOException: %s", x);
		}
	}
	
	private static void readFile(String filename, String... keywords) {
		File poemFile = new File(filename);
		try (BufferedReader reader = Files.newBufferedReader(poemFile.toPath())) {
		    String line = null;
		    int lineCounter = 1;
		    int tokensCounter = 0;
		    while ((line = reader.readLine()) != null) {
		    	for (int i=0; i < keywords.length; i++) {
		    		if(line.contains(keywords[i])) {
		    			  System.out.println(lineCounter + ": " + line);
		    			  tokensCounter++;
		    			  break;
		    		}
		    	}
		    	lineCounter++;
		    }
		    
		    System.out.println("Number of lines " + tokensCounter);
		} catch (IOException x) {
		    System.err.format("IOException: %s", x);
		}
	}
	
	private static void scanFile(String filename, String keyword) throws Exception {
		File poemFile = new File(filename);
		Scanner scanner = new Scanner(poemFile);
		int tokensCount = 0;
		while (scanner.hasNext()) {
			String token = scanner.next();
			if (token.indexOf(keyword) > -1) {
				System.out.println(token);
				tokensCount++;
			}
		}
		scanner.close();
		System.out.println("Found tokens: " + tokensCount);
		System.out.println("File path: " + poemFile.getPath());
		
		Long space =  poemFile.getFreeSpace();
		
		double spaceKb = space/1024;
		double spaceMb = space/(1024*1024);
		double spaceGb = space/(1024*1024*1024);
		
		System.out.println("Free Space in Kb:" + spaceKb +" Kb.");
		System.out.println("Free Space in Mb:" + spaceMb +" Mb.");
		System.out.println("Free Space in Gb:" + spaceGb +" Gb.");
	}
}