package gmit;

import java.util.HashMap;
import java.util.Map;

public class PolybiusSquare {
	Map<Character, String> polybius = new HashMap<Character, String>();
	Map<String, Character> decPol = new HashMap<String, Character>();
	
	public PolybiusSquare(){
		encPut();
		decPut();
	}
	
	public String encrypt(char key){
		return polybius.get(key);
	}
	
	public char decrypt(String key){
		return decPol.get(key);
	}
	
	private void encPut(){
		polybius.put('a', "DG");
		polybius.put('b', "VX");
		polybius.put('c', "GV");
		polybius.put('d', "FX");
		polybius.put('e', "DF");
		polybius.put('f', "FV");
		polybius.put('g', "AV");
		polybius.put('h', "AD");
		polybius.put('i', "XV");
		polybius.put('j', "XA");
		polybius.put('k', "GD");
		polybius.put('l', "FA");
		polybius.put('m', "DD");
		polybius.put('n', "FF");
		polybius.put('o', "FG");
		polybius.put('p', "AA");
		polybius.put('q', "AG");
		polybius.put('r', "GF");
		polybius.put('s', "VA");
		polybius.put('t', "XG");
		polybius.put('u', "XF");
		polybius.put('v', "GX");
		polybius.put('w', "VG");
		polybius.put('x', "GA");
		polybius.put('y', "DX");
		polybius.put('z', "VF");
		polybius.put('0', "AF");
		polybius.put('1', "DV");
		polybius.put('2', "FD");
		polybius.put('3', "GG");
		polybius.put('4', "DA");
		polybius.put('5', "VD");
		polybius.put('6', "AX");
		polybius.put('7', "VV");
		polybius.put('8', "XX");
		polybius.put('9', "XD");
		polybius.put('.', "AZ");
		polybius.put(',', "DZ");
		polybius.put('\"', "FZ");
		polybius.put(':', "GZ");
		polybius.put('-', "VZ");
		polybius.put('?', "XZ");
		polybius.put('(', "ZA");
		polybius.put(')', "ZD");
		polybius.put(' ', "ZF");
		polybius.put('_', "ZG");
		polybius.put(';', "ZV");
		polybius.put('\'', "ZX");
		polybius.put('!', "ZZ");
		polybius.put('*', "YA");
		polybius.put('[', "YD");
		polybius.put(']', "YF");
		polybius.put('=', "YG");
		polybius.put('/', "YV");
	}
	
	private void decPut(){
		decPol.put("DG", 'a');
		decPol.put("VX", 'b');
		decPol.put("GV", 'c');
		decPol.put("FX", 'd');
		decPol.put("DF", 'e');
		decPol.put("FV", 'f');
		decPol.put("AV", 'g');
		decPol.put("AD", 'h');
		decPol.put("XV", 'i');
		decPol.put("XA", 'j');
		decPol.put("GD", 'k');
		decPol.put("FA", 'l');
		decPol.put("DD", 'm');
		decPol.put("FF", 'n');
		decPol.put("FG", 'o');
		decPol.put("AA", 'p');
		decPol.put("AG", 'q');
		decPol.put("GF", 'r');
		decPol.put("VA", 's');
		decPol.put("XG", 't');
		decPol.put("XF", 'u');
		decPol.put("GX", 'v');
		decPol.put("VG", 'w');
		decPol.put("GA", 'x');
		decPol.put("DX", 'y');
		decPol.put("VF", 'z');
		decPol.put("AF", '0');
		decPol.put("DV", '1');
		decPol.put("FD", '2');
		decPol.put("GG", '3');
		decPol.put("DA", '4');
		decPol.put("VD", '5');
		decPol.put("AX", '6');
		decPol.put("VV", '7');
		decPol.put("XX", '8');
		decPol.put("XD", '9');
		decPol.put("AZ", '.');
		decPol.put("DZ", ',');
		decPol.put("FZ", '\"');
		decPol.put("GZ", ':');
		decPol.put("VZ", '-');
		decPol.put("XZ", '?');
		decPol.put("ZA", '(');
		decPol.put("ZD", ')');
		decPol.put("ZF", ' ');
		decPol.put("ZG", '_');
		decPol.put("ZV", ';');
		decPol.put("ZX", '\'');
		decPol.put("ZZ", '!');
		decPol.put("YD", '[');
		decPol.put("YF", ']');
		decPol.put("YG", '=');
		decPol.put("YV", '/');
		decPol.put("YA", '*');
	}
} // class
