package pl.edu.agh.mwo.java.crawler;

import java.io.IOException;
import java.net.MalformedURLException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Crawler {
	String[] sentences;

	protected String urlToProcess;
	protected TextExtractor textExtractor;

	public Crawler(String initUrl) throws MalformedURLException {
		urlToProcess = initUrl;
		textExtractor= new TextExtractor();
	}

	public void run() throws IOException {

		Document doc = null;
		doc = Jsoup.connect(urlToProcess).get();

		sentences=textExtractor.extractText(doc);
	}

	public void findLinesWithWord(String word) {
		for (int i = 0; i < sentences.length; i++) {
			// System.out.println(sentences[i]);

			// wyszukiwanie zdan zawierajacych dane slowo
			if (sentences[i].contains(word)) {
				System.out.println(sentences[i] + " \n");
			}
		}
	}

	public void findLinesWhichContainsChar(char charToFind, int howManyChar) {
		int counter = 0;
		for (int j = 0; j < sentences.length; j++) {
			counter = 0;
			for (int k = 0; k < sentences[j].length(); k++) {
				if (sentences[j].charAt(k) == charToFind) {
					counter++;
				}
				;
			}
			if (howManyChar <= counter) {
				findLinesWithWord(sentences[j]);
			}

		}

	}

}
