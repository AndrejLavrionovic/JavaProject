package gmit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
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
		long startTime = System.currentTimeMillis();

		// VARIABLES
		//*****************************************************
		String keyWord = "ELEPHANABT", codeLine = null, keyWordSorted;
		int i, j, k, index = 0, element, pos;
		int[] indexOrder = new int[keyWord.length()];
		char[] keyWordArr = new char[keyWord.length()];
		
		List<ArrayList> l = new ArrayList<ArrayList>();
		List<Character> listColumn = new ArrayList<Character>();
		
		PolybiusSquare p = new PolybiusSquare();
		
		//******************************************************************************
		// SORTING KEYWORD
		//******************************************************************************
		for(i = 0; i < keyWord.length(); i++){
			keyWordArr[i] = keyWord.charAt(i);
		}
		for(i = 0; i < keyWord.length(); i++){
			index = 0;
			for(j = index+1; j < keyWord.length(); j++){
				if(keyWordArr[index] > keyWordArr[j]){
					index = j;
				}
			} // end nested for-loop
			keyWordArr[index] = (char)127;
			indexOrder[i] = index;
			//System.out.println(indexOrder[i]);
		} // end outer for-loop
		//******************************************************************************
		//******************************************************************************
		System.out.println("\n\n");
		
		
		//******************************************************************************
		// Encoding
		//******************************************************************************

		//File fOut = new File("PoblachtNaHEireann.txt");
		//File fOut = new File("DeBelloGallico.txt");
		File fOut = new File("WarAndPeace-LeoTolstoy.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fOut)));
		
		FileWriter fIn = new FileWriter("enc.txt");
		
		// Printing text from the file
		String line = null;
		int ArrayListIndex = 0;
		while((line = br.readLine()) != null){
			//System.out.println(line);
			
			//*************************************************************************
			// Removing spaces
			//*************************************************************************
			String[] words = line.split(" ");
			line = "";
			for(i = 0; i < words.length; i++){
				line += words[i].trim();
			}
			//System.out.println(line);
			
			//**************************************************************************
			// Encoding and Encrypting line by line
			//**************************************************************************
			for(i = 0; i < keyWord.length(); i++){
				index = indexOrder[i];
				for(j = index / 2; j < line.length(); j += keyWord.length() / 2){
					char letter = line.charAt(j);
					if(65 <= (int)letter && (int)letter <= 90){
						letter = Character.toLowerCase(letter);
					}
					if((index % 2) == 0){
						listColumn.add(p.encrypt(letter).charAt(0));
					}
					else{
						listColumn.add(p.encrypt(letter).charAt(1));
					}
					//System.out.print(listColumn.get(ArrayListIndex));
					fIn.append(listColumn.get(ArrayListIndex));
					ArrayListIndex++;
				}
			}
			//**************************************************************************
			//**************************************************************************
			 System.out.println();
			 
			/*
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
				
				int listLength = codeLine.length() / keyWord.length();
				if((codeLine.length() % keyWord.length()) != 0){
					if(i >= (codeLine.length() % keyWord.length())){
						listLength = (codeLine.length() / keyWord.length()) - 1;
					}
				}
				
				for(j = i; j < codeLine.length(); j+=keyWord.length()){
					listColumn.add(String.format("%s", codeLine.charAt(j)));
					
					System.out.print(listColumn.get(ArrayListIndex));
					ArrayListIndex++;
				} // end nested for loop
			} // end outer for loop
			
			System.out.println("\n");
			*/
		} // while 
		br.close();
		fIn.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("\n\tTook "+(endTime - startTime) / 1000 + " seconds");
		
	} // main
} // class
