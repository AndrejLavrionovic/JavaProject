package gmit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestRunner {
	public static void main(String[] args) throws IOException {


		File f = new File("WarAndPeace-LeoTolstoy.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		
		String line = null;
		while((line = br.readLine()) != null){
			System.out.println(line);
		}
	} // main
} // class
