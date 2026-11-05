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
				String results = (firstMatch != -1) ? Messages.Success.value() + firstMatch : Messages.Fail.value();
				pritnln(results);
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
	
	
	private 
	
	
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
	private String clientInputShort = "";
	private String clientInputLong = "";
}