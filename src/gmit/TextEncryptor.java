package gmit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class TextEncryptor implements KeywordSort {


	// VARIBALES
	//************************************************************************
	int[] indexOrder;
	Polybius p = new Polybius();

	// CONSTRUCTORS
	//************************************************************************
	public TextEncryptor(String keyword){
		sort(keyword);
	}

	// METHODS
	//************************************************************************
	public void sort(String keyword){

		// Local Variables
		int i, j, index;
		char[] keywordArr = new char[keyword.length()];

		// initializing Array of Ordered indexes of keyword
		indexOrder = new int[keyword.length()];

		// Brake keyword on charachters
		for(i = 0; i < keyword.length(); i++){
			keywordArr[i] = keyword.charAt(i);
		} // O(n)

		//***********************************************
		// serch for lowest character and stor its index
		// into array then replace this character with
		// the largest --> (char)127;
		//***********************************************
		for(i = 0; i < keyword.length(); i++){
			index = 0;
			for(j = index+1; j < keyword.length(); j++){
				if(keywordArr[index] > keywordArr[j]){
					index = j;
				}
			} // end nested for-loop --> O(n^2)
			keywordArr[index] = (char)127;
			indexOrder[i] = index;
		} // end outer for-loop --> O(n) * O(n^2) = O(n3)
	} // end sort() method

	public void encryptText(String fIn, String fOut){

	// Local Variables
	String line = null;
	int i, j, index, row;
	char letter, c;

	try {
		File fileIn = new File(fIn);
		FileWriter fileOut = new FileWriter(fOut);
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn)));

		while((line = br.readLine()) != null){ // brakes all text on the lines O(n)

			//**************************************************************************
			// Encoding and Encrypting line by line
			//**************************************************************************

			for(i = 0; i < indexOrder.length; i++){
				index = indexOrder[i];
				row = 0; // setting row to zero before every new column

				for(j = index / 2; j < line.length(); j += indexOrder.length / 2){
					letter = line.charAt(j);

					if(65 <= (int)letter && (int)letter <= 90){
						letter = Character.toLowerCase(letter);
					}

					if(indexOrder.length % 2 == 0){
						if((index % 2) == 0){
							c = p.encrypt(letter).charAt(0);
						}
						else{
							c = p.encrypt(letter).charAt(1);
						}
					}

					else{
						if(row % 2 == 0){
							if((index % 2) == 0){
								c = p.encrypt(letter).charAt(0);

							}
							else{
								c = p.encrypt(letter).charAt(1);
								j++;
							}
						} // if row 1, 3, 5 and so on
						else{
							if((index % 2) == 0){
								c = p.encrypt(letter).charAt(1);
								j++;
							}
							else{
								c = p.encrypt(letter).charAt(0);
							}

						} // else if row 2, 4, 6 and so on

						row++;
					} // end else if keyWord % 2 is NOT 0
					//System.out.print(listColumn.get(ArrayListIndex));
					fileOut.append(c);
					//ArrayListIndex++;
				} // end nested for-loop
			} // end outer for-loop
			fileOut.append("\n");
		} // end while

		// closing files
		br.close();
		fileOut.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} // end encryptingText()


	public void decryptText(String fIn, String fOut){

		// Local Variables
		String line;
		char c;
		int i, j, k;
		int rows, loops, jLen, reminder;
		int colLength;

		try{
			File fileIn = new File(fIn);
			FileWriter fileOut = new FileWriter(fOut);
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn)));

			while((line = br.readLine()) != null){ // brakes all text on the lines O(n)

				// Inicializing
				char chVer, chHor;
				chVer = chHor = ' ';
				int chIndex = 0;
				jLen = indexOrder.length; // keyword length
				rows = line.length() / jLen; // how many rows
				reminder = line.length() % jLen; // how many characters in the last row (how many loops needed for last row)

				if(reminder != 0) loops = (line.length() / jLen) + 1; // if last row has fiew characters we need to run loop (rows + 1 more time).
				else loops = rows; // if last row is full

				for(i = 0; i < loops; i++){
					// looking for position of character
					// that suppose to be first in the
					// particular column. In other word looking for
					// first column then second and so on.

					// If line / keyword has reminder - if bottom line is not full,
					// we need just reminder number of loops
					// other wise Error will occur
					//******************************************************************
					if(reminder != 0 ){ // if last line is not complete (if reminder)
						if((i + 1) == loops){ // if last line
							jLen = reminder; // just n(reminder) loops.
						} // nested if
					} // outer if
					//*******************************************************************

					for(j = 0; j < jLen; j++){ // O(n)

						// 1) Calculating position of index j
						colLength = 0;
						for(k = 0; k < indexOrder.length; k++){ // O(Log n)

							if(indexOrder[k] == j){ // what position has letter of keyword after sorting
								if(chIndex == 0) // Vertical index (ADFGVXZY)
									chVer = line.charAt(((rows * k) + colLength) + i);
								else // Horizontal index (ADFGVXZY)
									chHor = line.charAt(((rows * k) + colLength) + i);
								break;
							} //

							if(indexOrder[k] < reminder){ // searching for columns that longer, because reminder
								colLength++;
							}
						} // end for loop searching for position of character

						// Decoding text using HashMaps
						if(chIndex == 1){ // if symbol contains two characters
							// than decrypt to the letter
							c = p.decrypt(chVer, chHor);
							fileOut.append(c); // and add it to the text
						} // end if

						// sorting vertical and horizontal indexes in matrix
						if(chIndex == 0) chIndex = 1; // if was vertical index, then will be horizontal
						else chIndex = 0; // if was horizontal index, then will be vertical again

					} // nested for-loop (j - columns)
				} // outer for-loop (i - rows)
				fileOut.append("\n");
			} // end while

			// closing files
			br.close();
			fileOut.close();

		} catch(IOException e){
			e.printStackTrace();
		}
	} // end of DecryptingText()
} // CLASS
