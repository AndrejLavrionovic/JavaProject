package gmit;

import java.util.HashMap;
import java.util.Map;

public class PolybiusSquare {
	Map<Character, String> polybius = new HashMap<Character, String>();
	
	public PolybiusSquare(){
		
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
	
	public String encrypt(char key){
		String val;
		val = polybius.get(key);
		
		return val;
	}
} // class
