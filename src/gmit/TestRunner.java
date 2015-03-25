package gmit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestRunner {
	public static void main(String[] args) throws IOException {

		PolybiusSquare p = new PolybiusSquare();

		File f = new File("PoblachtNaHEireann.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		
		// Printing text from the file
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
			
			String[] words = line.split(" ");
			for(int i = 0; i < words.length; i++){
				String word = words[i];
				for(int j = 0; j < word.length(); j++){
					String letter = String.format("%c", word.charAt(j));
					System.out.print(p.encript(letter.toUpperCase().trim()));
				} // end nested for loop
			} // end for
			System.out.println("\n");
		} // while 
		
		br.close();
		
		
		
	} // main
} // class
