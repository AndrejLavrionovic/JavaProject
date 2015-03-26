package gmit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class TestRunner {
	public static void main(String[] args) throws IOException {

		// VARIABLES
		//*****************************************************
		String keyWord = "java", codeLine = null;
		int i, j;
		
		List<ArrayList> l = new ArrayList<ArrayList>();
		List<String> listColumn = new ArrayList<String>();
		
		PolybiusSquare p = new PolybiusSquare();
		KeyColumn kc;

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
