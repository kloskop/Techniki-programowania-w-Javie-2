package pl.edu.agh.mwo.java.crawler;

import static org.junit.Assert.*;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class TextExtractorTest {

	@Test
	public void extractTextTest() {
		String html = "<html><body>Pierwsze zdanie. Drugie zdanie. Trzecie, ostatnie zdanie.</body></html>";
		Document doc = Jsoup.parse(html);
		
		TextExtractor textExtractor = new TextExtractor();
		List<String> sentences = textExtractor.extractText(doc);
		assertEquals(3,  sentences.size());	
	}

	@Test
	public void extractTextTestComplex() {
		String html = "<html><body>Pierwsze zdanie. Drugie zdanie. Trzecie, ostatnie zdanie. .</body></html>";
		Document doc = Jsoup.parse(html);
		
		TextExtractor textExtractor = new TextExtractor();
		List<String> sentences = textExtractor.extractText(doc);
		assertEquals(3,  sentences.size());	
	}

	@Test
	public void extractTextTestContent() {
		String html = "<html><body>Pierwsze zdanie. Drugie zdanie.</body></html>";
		Document doc = Jsoup.parse(html);
		
		TextExtractor textExtractor = new TextExtractor();
		List<String> sentences = textExtractor.extractText(doc);
		assertEquals(2,  sentences.size());
		assertEquals("Pierwsze zdanie",  sentences.get(0));	
		assertEquals("Drugie zdanie",  sentences.get(1));	
		
	}

}
