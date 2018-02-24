package pl.edu.agh.mwo.java.crawler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrawlerStarter {

	public static void main(String[] args) throws IOException {

		Crawler c = new Crawler("http://www.onet.pl", new TextExtractor(), new ConsoleResultsPrinter());

		// c.addSentenceFinder(new SentenceByWordFinder("szpital"));
		// c.addSentenceFinder(new SentenceByCharCountFinder(10, 'd'));
		/*
		 * c.addSentenceFinder(new SentenceFinder(){
		 * 
		 * @Override public List<String> findSentences(List<String> sentences) {
		 * List<String> result = new ArrayList<>(); for (String sentence :
		 * sentences) { if (sentence.charAt(0)=='J'){ result.add(sentence); } }
		 * return result; }
		 * 
		 * });
		 */

		/*
		 * c.addSentenceFinder( (sentences) -> { List<String> result = new
		 * ArrayList<>(); for (String sentence : sentences) { if
		 * (sentence.split(" ").length>30) result.add(sentence); } return
		 * result;
		 * 
		 * });
		 */

		c.addSentenceFinder(sentences -> sentences.stream().filter(sentence -> sentence.length() < 10)
				.collect(Collectors.toList()));

		c.run();

	}
}
