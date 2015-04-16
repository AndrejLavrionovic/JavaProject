import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import gmit.*;

public class TestRunner {

	public static Scanner c = new Scanner(System.in); // allows a user to read from System.in

	public static void main(String[] args){

		// Local Variables
		String keyword;
		String fileIn;
		String fileOut = "encText.txt";
		long startTime;
		long endTime;
		char ch;

		// INTRO
		intro(); // displays the intro text

		System.out.print("\n\tDo you want to try encrypt your text? (y/n) -->  ");
		ch = Character.toLowerCase(c.next().charAt(0));
		isCharVal(ch); // validating of characters (Just y or n is allowd)

		if(ch == 'y'){ // if user wants to try encrypt text

			while(ch == 'y'){ // confirming loop (if user wants to try enctipt the text again after)

				// Prompting file name that contains text
				System.out.print("\n\n\tThen enter file name that contains the text for encryption:\n\t-->   ");
				fileIn = c.next().trim();

				// Entering keyword for encrypting
				System.out.print("\tEnter keyword -->  ");
				keyword = c.next();

				// PROGRAM STARTS ENCRIPT TEXT HERE
				startTime = System.currentTimeMillis(); // timer starts here

				//***************************************************************************
				// TextEncryptor class contains method
				// encryptText(String fileIn, String fileOut) that takes two argument of
				// type string. First argument is file that contains text for encrypting,
				// second argument is name of file where encrypted text is stores.
				// TextEncriptor object takes the keyword string and using
				// sort(String keyword) method that brakes the keyword on characters
				// (that takes O(n) time) and
				// fills the indexOrder array with its character's indexes in alphabet
				// order (O(n^3)). This process cost of efficiency but still fast as
				// keyword is not too long anyway. This approach makes encrypting very
				// fast and time in big-O notation is linear --> O(n).
				// encryptText() method takes needed character using index --> O(1)
				// and using HashMap polibius cypher picks apropriate character --> O(1)
				// then append it on the end of output file O(1). And so for each character.
				// So Encrypting whole text takes:
				// EncSpeed = (O(kn) + O(kn^3)) + 2*O(tn)
				// where kn - keyword charachter, tn - text character
				// 2O(tn) is because BufferedReader.readLine() requires O(n) time as it
				// searching for '\n' reading each charachter and encriptText() is O(n) too.
				// O(n) + O(n) is 2O(n).
				//***************************************************************************
				TextEncryptor tEnc = new TextEncryptor(keyword);
				tEnc.encryptText(fileIn, fileOut);

				endTime = System.currentTimeMillis();
				System.out.println("\n\tEncryptng is done. Encrypted text is stored in encText.txt file.");
				System.out.println("\tTook "+(endTime - startTime) + " miliseconds");

				System.out.print("\n\tDo you want to decrypt encrypted text? (y/n) -->   ");
				ch = Character.toLowerCase(c.next().charAt(0));
				isCharVal(ch);

				if(ch == 'y'){ // then Decrypting

					fileIn = "encText.txt";
					fileOut = "decText.txt";
					startTime = System.currentTimeMillis();

					//***********************************************************************************
					// TextEncryptor.decryptText(String fileIn, String fileOut) takes two String
					// parameters. First parameter is file name that contains encrypted text and
					// second parameter is the file name where decrypted text going to be stored.
					// Method serching for appropriate charachter using algorithm that devides line
					// on rows of keyword length, learnig if there is reminder (is the last row full)
					// using position indexed of characters in the keyword and calculates index of
					// serching charachter in the line.
					// This method working fast anough but depend of keyword length, because
					// program is searching for proper matrix column for every character -->
					// In big-O notation process is taking 2 * O(tn)*O(Log kn),
					// where tn - is text length and kn - is keywrd length
					// BufferedReader is reading lines - O(n) and decryptor searching for every
					// character O(n), that maks 2 * O(n); Algorithm for searching column where
					// letter is sitting takes O(Log n).
					//***********************************************************************************
					tEnc.decryptText(fileIn, fileOut);

					endTime = System.currentTimeMillis();
					System.out.println("\n\tDecryptng is done. Decrypted text is stored in decText.txt file.");
					System.out.println("\tTook "+(endTime - startTime) + " miliseconds");
				}

					System.out.print("\n\nDo you want to try encrypt another text? (y/n) -->   ");
					ch = Character.toLowerCase(c.next().charAt(0));
					isCharVal(ch);

			} // end of while(ch == 'y')
		} // if ch == 'y'
		if(ch == 'n'){ // if ch == 'n'
			System.out.println("\n\n\tGOOD BY!");
		} // END IF-ELSEIF
	} // MAIN

	private static void intro(){

		// Local Variables
		String line;

		System.out.println("\n\n\tRAPID ENCRYPTION USING THE GERMAN WW1 ADFGVX CYPHER\n");

		try {
			File fileIn = new File("intro.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileIn)));

			line = null;

			while((line = br.readLine()) != null){
				System.out.println(line);
			} // end of while

			br.close();
		} catch(IOException e){
			e.printStackTrace();
		}
	} // end intro()

	private static void isCharVal(char ch){
		while(ch != 'y' && ch != 'n'){ // Validation
			System.out.println("\n\t\'y\' or \'n\' is valid only. Try again.");
			System.out.print("\n\tDo you want to try encrypt your tex? (y/n) -->  ");
			ch = Character.toLowerCase(c.next().charAt(0));
		}
	}

} // CLASS
