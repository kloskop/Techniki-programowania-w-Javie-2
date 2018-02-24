package pl.edu.agh.mwo.java.crawler;

import java.util.ArrayList;
import java.util.List;

public class SentenceByCharCountFinder implements SentenceFinder {
	
	protected int countOfChars;
	protected char charToFind;
	
	public SentenceByCharCountFinder(int countOfChars, char charToFind) {
		super();
		this.countOfChars = countOfChars;
		this.charToFind = charToFind;
	}

	public List<String> findSentences(List<String> sentences) 
	{
		ArrayList<String> foundSentences = new ArrayList<>();
				
		for (String sentence : sentences)
		{
			int charCount = 0;
			for (int j = 0; j < sentence.length(); j++) 
			{
			    if (sentence.charAt(j) == charToFind)
			    	charCount++;
			}
			if (charCount >= countOfChars)
			{
				foundSentences.add(sentence);
			}
		}
		return foundSentences;
	}

}
