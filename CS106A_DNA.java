/**
 * File: CS106A_DNA.java 
 * ------------------------------------
 * The CS106A_DNA class finds the first index position 
 * at which a short string representing a DNA base would 
 * bind with a longer string representing the same,
 * or -1 should said index not exist.
 * 
 */

import acm.program.*;

public class CS106A_DNA extends ConsoleProgram
{
	//Named constants
	private static final String SENTINEL = "ENDPROGRAM";
	
	public enum BaseLengths { SHORT, LONG }
	
	public enum Errors { 
		FORMATTING("Please ensure that both all letters in each base consist " +
				"of 'A','T','G', or 'C' and that the latter is longer than the former.");
		
		private final String errValue;
		
		Errors(String errValue){
			this.errValue = errValue;
		}
	}
	
	public void run()
	{
		introduceApp();
		String clientInputRaw = "";
		while (!clientInputRaw.equals(SENTINEL)){
			clientInputShort = "";
			clientInputLong = "";
			for (int i = 0; i < 2; i++){
				String strandLength = clientInputShort.equals("") ? "short" : "long";
				clientInputRaw = readLine("Enter " + strandLength + " strand: ");
				if (clientInputRaw.equals(SENTINEL)) { println("goodbye"); break; }
				
				if (clientInputShort.equals("")) setClientInput(BaseLengths.SHORT, clientInputRaw);
				else setClientInput(BaseLengths.LONG, clientInputRaw);	
				
				if (!verifyStrand(clientInputShort) || !verifyStrand(clientInputLong)){
					println(Errors.FORMATTING.errValue);
					break;
				} else { 
					findFirstMatchingPosition(clientInputShort, clientInputLong);
				}
			}
		}
	}
	
	
	private void introduceApp()
	{
		
	}
	
	
	private String setClientInput(BaseLengths len, String strand)
	{
		switch (len){
		case SHORT:
			//verifyStrand()
		}
		return "";
	}
	
	
	private boolean verifyStrand(String dnaStrand)
	{
		for (int i = 0; i < dnaStrand.length(); i++){
			switch (dnaStrand.toUpperCase().charAt(i)){
			case 'A':
				break;
			case 'T':
				break;
			case 'G':
				break;
			case 'C':
				break;
			default:
				return false;
			}
		}
		return true;
	}
	
	
	private int findFirstMatchingPosition(String shortDNA, String longDNA)
	{
		//verify strands
		if (!verifyStrand(shortDNA)) return -2;
		if (!verifyStrand(longDNA)) return -2;
		
		if (shortDNA.length() >= longDNA.length()) return -2;
		boolean match = false;
		while (!match){
			for (int i = 0, j = 0; i < shortDNA.length(); i = j + 1){
				
			}
		}
		return 1;
	}
	
	//Instance variables
	private String clientInputShort = "";
	private String clientInputLong = "";
}