package pl.edu.agh.mwo.java.crawler;

import java.util.List;

public class ConsoleResultsPrinter 
{

	public void print(String sentence)
	{
		System.out.println(sentence);
	}

	public void print(List<String> sentences) 
	{
		System.out.println("========================");
		for (String sentence : sentences)
		{
			print (sentence);
		}		
	}
}
