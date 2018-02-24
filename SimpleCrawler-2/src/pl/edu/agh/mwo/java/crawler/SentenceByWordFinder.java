package pl.edu.agh.mwo.java.crawler;

import java.util.ArrayList;
import java.util.List;

public class SentenceByWordFinder implements SentenceFinder{
	
	protected String wordToFind;

	public SentenceByWordFinder(String wordToFind) {
		super();
		this.wordToFind = wordToFind;
	}

	@Override
	public List<String> findSentences(List<String> sentences) 
	{
		List<String> foundSentences = new ArrayList<>();
		for(String sentence : sentences)
		{
			if (sentence.contains(wordToFind))
				foundSentences.add(sentence);
		}
		return foundSentences;
	}
}
