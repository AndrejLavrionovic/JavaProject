package gmit;

import java.util.HashMap;
import java.util.Map;

public class Polybius {

	// Declaring HashMaps
	//************************************************************************************
	Map<Character, String> encPol = new HashMap<Character, String>(); // encoding HashMap
	Map<Character, Character> decPol = new HashMap<Character, Character>(); // decoding HashMap

	Map<Character, Character> decHorA = new HashMap<Character, Character>();
	Map<Character, Character> decHorD = new HashMap<Character, Character>();
	Map<Character, Character> decHorF = new HashMap<Character, Character>();
	Map<Character, Character> decHorG = new HashMap<Character, Character>();
	Map<Character, Character> decHorV = new HashMap<Character, Character>();
	Map<Character, Character> decHorX = new HashMap<Character, Character>();
	Map<Character, Character> decHorZ = new HashMap<Character, Character>();
	Map<Character, Character> decHorY = new HashMap<Character, Character>();

	Map<Character, Map> decVer = new HashMap<Character, Map>();

	// Cosntructor
	//************************************************************************************
	public Polybius(){
		encPut();
		decPut();
	} // end of Constructor

	// Methods
	//*************************************************************************************
	public String encrypt(char key){
		return encPol.get(key);
	} // encript method take char key and return its String value

	public char decrypt(String key){
		char ch;
		decPol = decVer.get(key1);
		return ch = decPol.get(key2);
	} // decrypt method takes String key and returns char value

	// encPut and decPut creates HashMaps<Character, String> and <String, Character> respectively
	private void encPut(){
		encPol.put('a', "DG");
		encPol.put('b', "VX");
		encPol.put('c', "GV");
		encPol.put('d', "FX");
		encPol.put('e', "DF");
		encPol.put('f', "FV");
		encPol.put('g', "AV");
		encPol.put('h', "AD");
		encPol.put('i', "XV");
		encPol.put('j', "XA");
		encPol.put('k', "GD");
		encPol.put('l', "FA");
		encPol.put('m', "DD");
		encPol.put('n', "FF");
		encPol.put('o', "FG");
		encPol.put('p', "AA");
		encPol.put('q', "AG");
		encPol.put('r', "GF");
		encPol.put('s', "VA");
		encPol.put('t', "XG");
		encPol.put('u', "XF");
		encPol.put('v', "GX");
		encPol.put('w', "VG");
		encPol.put('x', "GA");
		encPol.put('y', "DX");
		encPol.put('z', "VF");
		encPol.put('0', "AF");
		encPol.put('1', "DV");
		encPol.put('2', "FD");
		encPol.put('3', "GG");
		encPol.put('4', "DA");
		encPol.put('5', "VD");
		encPol.put('6', "AX");
		encPol.put('7', "VV");
		encPol.put('8', "XX");
		encPol.put('9', "XD");
		encPol.put('.', "AZ");
		encPol.put(',', "DZ");
		encPol.put('\"', "FZ");
		encPol.put(':', "GZ");
		encPol.put('-', "VZ");
		encPol.put('?', "XZ");
		encPol.put('(', "ZA");
		encPol.put(')', "ZD");
		encPol.put(' ', "ZF");
		encPol.put('_', "ZG");
		encPol.put(';', "ZV");
		encPol.put('\'', "ZX");
		encPol.put('!', "ZZ");
		encPol.put('*', "YA");
		encPol.put('[', "YD");
		encPol.put(']', "YF");
		encPol.put('=', "YG");
		encPol.put('/', "YV");
		encPol.put('&', "YX");
		encPol.put('<', "YZ");
		encPol.put('>', "YZ");
		encPol.put('%', "YZ");
		encPol.put('+', "YZ");
		encPol.put('{', "YZ");
		encPol.put('}', "YZ");
		encPol.put('\\', "YZ");
		encPol.put('|', "YZ");
	} // end encPut

	private void decPut(){
		// decHor
		decHorA.put('A', 'p');
		decHorA.put('D', 'h');
		decHorA.put('F', '0');
		decHorA.put('G', 'q');
		decHorA.put('V', 'g');
		decHorA.put('X', '6');
		decHorA.put('Z', '.');
		decHorA.put('Y', '<');

		decHorY.put('A', '*');
		decHorY.put('D', '[');
		decHorY.put('F', ']');
		decHorY.put('G', '=');
		decHorY.put('V', '/');
		decHorY.put('X', '&');
		decHorY.put('Z', '#');
		decHorA.put('Y', '>');

		decHorD.put('A', '4');
		decHorD.put('D', 'm');
		decHorD.put('F', 'e');
		decHorD.put('G', 'a');
		decHorD.put('V', '1');
		decHorD.put('X', 'y');
		decHorD.put('Z', ',');
		decHorA.put('Y', '%');

		decHorF.put('A', 'l');
		decHorF.put('D', '2');
		decHorF.put('F', 'n');
		decHorF.put('G', 'o');
		decHorF.put('V', 'f');
		decHorF.put('X', 'd');
		decHorF.put('Z', '\"');
		decHorA.put('Y', '+');

		decHorG.put('A', 'x');
		decHorG.put('D', 'k');
		decHorG.put('F', 'r');
		decHorG.put('G', '3');
		decHorG.put('V', 'c');
		decHorG.put('X', 'v');
		decHorG.put('Z', ':');
		decHorA.put('Y', '{');

		decHorV.put('A', 's');
		decHorV.put('D', '5');
		decHorV.put('F', 'z');
		decHorV.put('G', 'w');
		decHorV.put('V', '7');
		decHorV.put('X', 'b');
		decHorV.put('Z', '-');
		decHorA.put('Y', '}');

		decHorX.put('A', 'j');
		decHorX.put('D', '9');
		decHorX.put('F', 'u');
		decHorX.put('G', 't');
		decHorX.put('V', 'i');
		decHorX.put('X', '8');
		decHorX.put('Z', '?');
		decHorA.put('Y', '\\');

		decHorZ.put('A', '(');
		decHorZ.put('D', ')');
		decHorZ.put('F', ' ');
		decHorZ.put('G', '_');
		decHorZ.put('V', ';');
		decHorZ.put('X', '\'');
		decHorZ.put('Z', '!');
		decHorA.put('Y', '|');

		//decVer
		decVer.put('A', decHorA);
		decVer.put('D', decHorD);
		decVer.put('F', decHorF);
		decVer.put('G', decHorG);
		decVer.put('V', decHorV);
		decVer.put('X', decHorX);
		decVer.put('Z', decHorZ);
		decVer.put('Y', decHorY);
	} // and decPut

} // class
