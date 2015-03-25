package gmit;

import java.util.HashMap;
import java.util.Map;

public class PolybiusSquare {
	Map<String, String> polybius = new HashMap<String, String>();
	
	public PolybiusSquare(){
		
		polybius.put("A", "DG");
		polybius.put("B", "VX");
		polybius.put("C", "GV");
		polybius.put("D", "FX");
		polybius.put("E", "DF");
		polybius.put("F", "FV");
		polybius.put("G", "AV");
		polybius.put("H", "AD");
		polybius.put("I", "XV");
		polybius.put("J", "XA");
		polybius.put("K", "GD");
		polybius.put("L", "FA");
		polybius.put("M", "DD");
		polybius.put("N", "FF");
		polybius.put("O", "FG");
		polybius.put("P", "AA");
		polybius.put("Q", "AG");
		polybius.put("R", "GF");
		polybius.put("S", "VA");
		polybius.put("T", "XG");
		polybius.put("U", "XF");
		polybius.put("V", "GX");
		polybius.put("W", "VG");
		polybius.put("X", "GA");
		polybius.put("Y", "DX");
		polybius.put("Z", "VF");
		polybius.put("0", "AF");
		polybius.put("1", "DV");
		polybius.put("2", "FD");
		polybius.put("3", "GG");
		polybius.put("4", "DA");
		polybius.put("5", "VD");
		polybius.put("6", "AX");
		polybius.put("7", "VV");
		polybius.put("8", "XX");
		polybius.put("9", "XD");
	}
	
	public String encript(String key){
		String val;
		val = polybius.get(key);
		
		return val;
	}
} // class
