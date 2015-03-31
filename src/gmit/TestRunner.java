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
		String keyWord = "JEVAX", codeLine = null, keyWordSorted;
		int i, j, k, index = 0, element, pos;
		char c;
		int[] indexOrder = new int[keyWord.length()];
		char[] keyWordArr = new char[keyWord.length()];
		
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
			System.out.println(indexOrder[i]);
		} // end outer for-loop
		//******************************************************************************
		//******************************************************************************
		//System.out.println("KeyWord length is: "+keyWord.length());
		

		//******************************************************************************
		// Encoding
		//******************************************************************************

		//File fOut = new File("PoblachtNaHEireann.txt");
		//File fOut = new File("DeBelloGallico.txt");
		File fOut = new File("WarAndPeace-LeoTolstoy.txt");
		//File fOut = new File("text.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fOut)));
		
		FileWriter encFIn = new FileWriter("enc.txt");
		
		// Printing text from the file
		String line = null;

		//int ArrayListIndex = 1;
		while((line = br.readLine()) != null){
			//System.out.println(line);
			
			/*
			//*************************************************************************
			// Removing spaces
			//*************************************************************************
			String[] words = line.split(" ");
			line = "";
			for(i = 0; i < words.length; i++){
				line += words[i].trim();
			}
			//System.out.println(line);
			//encFIn.append(line+"\n");
			//System.out.println("Line length is: " + line.length() + "\n");
			 * 
			 */
			
			//**************************************************************************
			// Encoding and Encrypting line by line
			//**************************************************************************
			for(i = 0; i < keyWord.length(); i++){
				index = indexOrder[i];
				int row = 0; // setting row to zero before every new column
				for(j = index / 2; j < line.length(); j += keyWord.length() / 2){
					char letter = line.charAt(j);
					if(65 <= (int)letter && (int)letter <= 90){
						letter = Character.toLowerCase(letter);
					}
					/*
					System.out.println(ArrayListIndex + ")");
					System.out.println("j = " + index + " / 2 = " + index / 2);
					System.out.println("letter is " + letter);
					System.out.println("index = " + index + "; j = " + j + "; index % 2 = " + index % 2 + "; row = " + (row + 1));
					*/
					if(keyWord.length() % 2 == 0){
						if((index % 2) == 0){
							c = p.encrypt(letter).charAt(0);
							//System.out.println("First symbol of " + letter + " character is " + c);
						}
						else{
							c = p.encrypt(letter).charAt(1);
							//System.out.println("Second symbol of " + letter + " character is " + c);
						}
					}
					
					else{
						if(row % 2 == 0){
							if((index % 2) == 0){
								c = p.encrypt(letter).charAt(0);
								//System.out.println("First symbol of " + letter + " character is " + c);
								
							}
							else{
								c = p.encrypt(letter).charAt(1);
								//System.out.println("Second symbol of " + letter + " character is " + c);
								j++;
							}
						} // if row 1, 3, 5 and so on
						else{
							if((index % 2) == 0){
								c = p.encrypt(letter).charAt(1);
								//System.out.println("Second symbol of " + letter + " character is " + c);
								j++;
							}
							else{
								c = p.encrypt(letter).charAt(0);
								//System.out.println("First symbol of " + letter + " character is " + c);
							}
							
						} // else if row 2, 4, 6 and so on
						
						
						
						row++;
					} // end else if keyWord % 2 is NOT 0
					//System.out.print(listColumn.get(ArrayListIndex));
					encFIn.append(c);
					//ArrayListIndex++;
				}
			}
			encFIn.append('\n');
			//**************************************************************************
			//**************************************************************************
			
			 //System.out.println();
			
			
/*			
			//**************************************************************************
			// Bad code
			//**************************************************************************
			//**********************************************************************
			//**********************************************************************
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
			//**********************************************************************
			//**********************************************************************
			//**********************************************************************
			//**********************************************************************
*/			
		} // while 
		br.close();
		encFIn.close();
		

		//**************************************************************************
		// Decrypting
		//**************************************************************************
		File encFile = new File("enc.txt");
		BufferedReader brDec = new BufferedReader(new InputStreamReader(new FileInputStream(encFile)));
		FileWriter decFOut = new FileWriter("dec.txt");
		
		line = null;
		while((line = brDec.readLine()) != null){
			// Searching for characters and
			// building the string of two
			// characters for encoding. Than
			// again and again until the line of text
			// is build.

			String cipher = "";
			int rows = line.length() / keyWord.length(), loops, jLen = keyWord.length();
			int reminder = line.length() % keyWord.length();
			
			if(reminder != 0) loops = (line.length() / keyWord.length()) + 1;
			else loops = rows;
			
			for(i = 0; i < loops; i++){
				// looking for position of character
				// that suppose to be first in the
				// particular column. In other word looking for
				// first column than second and so on.
				//System.out.print("\n" + (i+1) + ") ");
				
				if(reminder != 0 ){
					if((i + 1) == loops){
						jLen = reminder;
					}
				}
				
				for(j = 0; j < jLen; j++){
					
					// 1) Calculating position of index j
					int colLength = 0;
					for(k = 0; k < indexOrder.length; k++){
						
						if(indexOrder[k] == j){
							cipher += String.format("%c", line.charAt(((rows * k) + colLength) + i));
							break;
						}
						
						if(indexOrder[k] < reminder){
							colLength++;
						}
					} // end for loop searching for position of character

					
					if(cipher.length() == 2){
						//System.out.print("String code is: " + cipher);
						c = p.decrypt(cipher);
						//System.out.println(" that represent letter : " + c);
						decFOut.append(c);
						cipher = "";
					}
				} // nested for (j - columns)
			} // outer for (i - rows)
			decFOut.append("\n");
		 
		} // while
		//**************************************************************************
		//**************************************************************************

		
		brDec.close();
		decFOut.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("\n\tTook "+(endTime - startTime) + " miliseconds");
		
	} // main
} // class
