package pl.edu.agh.mwo.java.crawler;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SentenceByWordFinderTest {

	@Test
	public void testSimple() {
		SentenceByWordFinder sentenceByWordFinder = new SentenceByWordFinder("s這wo");
		List<String> sentences = Arrays.asList("tu s這wa nie ma", "a tu s這wo jest", "a tu nie jest S這wo");
		
		List<String> results = sentenceByWordFinder.findSentences(sentences);		
		assertEquals(1,  results.size());
	}

	@Test
	public void testEmptyWord() {
		SentenceByWordFinder sentenceByWordFinder = new SentenceByWordFinder("");
		List<String> sentences = Arrays.asList("tu s這wa nie ma", "a tu s這wo jest", "a tu nie jest S這wo");
		
		List<String> results = sentenceByWordFinder.findSentences(sentences);		
		assertEquals(0,  results.size());
	}

	
}
