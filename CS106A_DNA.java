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
		FORMATTING("Please ensure that both all bases in each strand consist " +
				"of only 'A','T','G', or 'C' and that the latter strand is longer than " +
				"the former.");
		
		private final String errValue;
		
		Errors(String errValue){
			this.errValue = errValue;
		}
	}
	
	public void run()
	{
		introduceApp();
		while (!clientInputRaw.equals(SENTINEL)){ 
			setStrandsAndFindMatch();
		}
	}
	
	
	private void introduceApp()
	{
		
	}
	
	
	private void setStrandsAndFindMatch()
	{
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
				int firstIndex = findFirstMatchingPosition(clientInputShort, clientInputLong);
				if (firstIndex == -2) { println(Errors.FORMATTING.errValue); break; }
				println("First matching index: " + firstIndex);
			}
		}
	}
	
	
	private void setClientInput(BaseLengths len, String strand)
	{
		switch (len){
		case SHORT:
			clientInputShort = strand;
			break;
		case LONG: 
			clientInputLong = strand;
			break;
		}
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
		if (shortDNA.length() >= longDNA.length()) return -2;
		boolean match = false;
		int jStart = 0;
		while (!match){
			for (int i = 0 ; i < longDNA.length(); i++){
				for (int j = jStart; j < shortDNA.length(); j++){
					
				}
			}
		}
		return 1;
	}
	
	//Instance variables
	private String clientInputRaw = "";
	private String clientInputShort = "";
	private String clientInputLong = "";
}