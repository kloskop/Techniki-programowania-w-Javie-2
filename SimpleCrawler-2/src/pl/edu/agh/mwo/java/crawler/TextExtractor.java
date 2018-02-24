package pl.edu.agh.mwo.java.crawler;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;

public class TextExtractor {

	public List<String> extractText(Document doc) {
		String text = doc.body().text();
	
		String[] sentences = text.split("\\.");
		
		List<String> filteredSentences = new ArrayList<>(); 
		for (String sentence : sentences )
			if (sentence.trim().length() > 0)
				filteredSentences.add(sentence.trim());
				
		
		return filteredSentences;
	}

}
