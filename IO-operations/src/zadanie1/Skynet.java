package zadanie1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class Skynet {

	private String login = "Reese";
	private String password = "#Terminate";

	public static void main(String args[]) {
		Skynet skynet = new Skynet();
		skynet.run();
	}

	public void run() {
		readCredentials();
		printSkyNetLogo();
		runLoginPanel();
	}

	private void runLoginPanel() {
		String readLogin;
		String readPassword;
		boolean credentialsOK;
		do {
			readLogin = getTextFromInput("Login");
			readPassword = getTextFromInput("Password");
			credentialsOK = verifyCredentials(readLogin, readPassword);
			if (!credentialsOK) {
				System.out.println("Wrong login or password. Try again.");
			}
		} while (!credentialsOK);
		System.out.println();
		System.out.println("Welcome to SKYNET...");
	}

	private String getTextFromInput(String label) {
		System.out.println("Write "+label);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
		// DONE print label and return the user input
	}

	private boolean verifyCredentials(String login, String password) {
		return this.login.equals(login) && this.password.equals(password);
	}

	private void readCredentials() {
		File credentialsFile = new File("res/zadanie1/skynet.conf");

		try {
			Scanner scanner = new Scanner(credentialsFile);
			String tempLogin, tempPass=null;
			tempLogin=scanner.next();
			tempPass=scanner.next();
			
			login=tempLogin;
			password=tempPass;
			System.out.println("INFO System reconfigured...");
			scanner.close();
			
		} catch (IOException ioe) {
			System.out.println("INFO No valid conf data");
		}
		// DONE read credentials from the file "res/zadanie1/skynet.conf"
		// DONE print "INFO System reconfigured..." if correctly read
		// DONE print "INFO No valid conf data" if could not read credentials
	}

	private void printSkyNetLogo() {

		File fileWithLogo = new File("res/zadanie1/logo.txt");

		try (BufferedReader reader = Files.newBufferedReader(fileWithLogo.toPath())) {
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException x) {
			System.err.format("IOException: %s", x);
		}

		// DONE print logo from file "res/zadanie1/logo.txt"
	}
}
