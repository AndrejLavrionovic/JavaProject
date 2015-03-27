package gmit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public class TestRunner {
	public static void main(String[] args) throws IOException {

		// VARIABLES
		//*****************************************************
		String keyWord = "java", codeLine = null, keyWordSorted;
		int i, j;
		
		List<ArrayList> l = new ArrayList<ArrayList>();
		List<String> listColumn = new ArrayList<String>();
		
		PolybiusSquare p = new PolybiusSquare();
		
		// Hashmap of keyword
		Map<String, Integer> kwHashMap = new HashMap<String, Integer>();
		
		for(i = 0; i < keyWord.length(); i++){
			kwHashMap.put(String.format("%s", keyWord.charAt(i)), i);
		}
		
		// Arrangement letters in the keyword in alphabetical order
		List<String> kwArrayList = new ArrayList<String>();
		for (i = 0; i < keyWord.length(); i++){
			kwArrayList.add(String.format("%s", keyWord.charAt(i)));
		}
		
		Collections.sort(kwArrayList);
		
		for(i = 0; i < kwArrayList.size(); i++){
			System.out.print(kwArrayList.get(i));
		}
		System.out.println("\n");
		

		File f = new File("PoblachtNaHEireann.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		
		// Printing text from the file
		String line = null;
		int index = 0;
		while((line = br.readLine()) != null){
			System.out.println(line);
			
			codeLine = "";
			
			String[] words = line.split(" ");
			for(i = 0; i < words.length; i++){
				String word = words[i];
				for(j = 0; j < word.length(); j++){
					String letter = String.format("%c", word.charAt(j));
					
					codeLine += p.encript(letter.toUpperCase().trim());
				} // end nested for loop
			} // end for
			
			System.out.println(codeLine+"\n");
			
			
			for(i = 0; i < keyWord.length(); i++){
				/*
				int listLength = codeLine.length() / keyWord.length();
				if((codeLine.length() % keyWord.length()) != 0){
					if(i >= (codeLine.length() % keyWord.length())){
						listLength = (codeLine.length() / keyWord.length()) - 1;
					}
				}
				*/
				for(j = i; j < codeLine.length(); j+=keyWord.length()){
					listColumn.add(String.format("%s", codeLine.charAt(j)));
					
					System.out.print(listColumn.get(index));
					index++;
				} // end nested for loop
			} // end outer for loop
			
			System.out.println("\n");
		} // while 
		
		br.close();
		
		
		
	} // main
} // class
