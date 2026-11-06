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
	
	//Enumerations
	public enum BaseLengths { SHORT, LONG }
	
	public enum BaseBonds { 
		A('T'), T('A'), G('C'), C('G');
		
		public final char complement;
		
		BaseBonds(char complement)
		{
			this.complement = complement;
		}
	}
	
	public enum Messages { 
		Success("Match detected "), Fail("No match detected.");
		
		private final String value;
		
		Messages(String value)
		{
			this.value = value;
		}
	}
	
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
		while (true){ 
			for (int i = 0; i < 2; i ++){
				if (clientInputShort.equals("")){
					setClientInput(BaseLengths.SHORT); 
				} else { 
					setClientInput(BaseLengths.LONG);
				}
			}
			
			if (clientInputShort.equals(SENTINEL) || clientInputLong.equals(SENTINEL)){ 
				break; 	
				
			} else if (verifyFormatting(clientInputShort, clientInputLong)){
				int firstMatch = findFirstMatchingPosition(clientInputShort, clientInputLong);
				String results = (firstMatch != -1) ? Messages.Success.value : Messages.Fail.value;
				println(results);
			} else {
				println(Errors.FORMATTING.errValue);
			}
				
			clientInputShort = "";
			clientInputLong = "";
		}
	}
	
	
	private void introduceApp()
	{
		
	}
	
	
	private void setClientInput(BaseLengths len)
	{
		switch (len){
		case SHORT:
			clientInputShort = readLine("Enter short DNA: ");
			break;
		case LONG: 
			clientInputLong = readLine("Enter long DNA: ");
			break;
		}
	}
	
	
	private boolean verifyFormatting(String shortDNA, String longDNA)
	{
		if (shortDNA.length() >= longDNA.length()) return false;
		
		for (int i = 0; i < shortDNA.length(); i++){
			char ch = Character.toUpperCase((shortDNA.charAt(i)));
			if (ch != 'A' && ch != 'T' && ch != 'G' && ch != 'C') return false;
		}
		
		for (int i = 0; i < longDNA.length(); i++){
			char ch = Character.toUpperCase((longDNA.charAt(i)));
			if (ch != 'A' && ch != 'T' && ch != 'G' && ch != 'C') return false;
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
	
	
	private boolean verifyBond(char longStrandChar, char shortStrandChar)
	{
		
		return true;
	}
	
	//Instance variables
	private String clientInputShort = "";
	private String clientInputLong = "";
}