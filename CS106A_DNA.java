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
		Success("Match detected at index "), Fail("No match detected.");
		
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
		boolean continueLoop = true;
		while (continueLoop){ 
			
			for (int i = 0; i < 2; i ++){	
				
			
				if (clientInputShort.equals("")){
					setClientInput(BaseLengths.SHORT); 
				} else if (clientInputLong.equals("")) { 
					setClientInput(BaseLengths.LONG);
				} 
				
				if (clientInputShort.equals(SENTINEL) || clientInputLong.equals(SENTINEL)){ 
					println("goodbye");
					continueLoop = false;
					break;
				}
			}
			
			if (!continueLoop) break; //for if client entered SENTINEL before setting the long DNA chain
			
			if (verifyFormatting(clientInputShort, clientInputLong)){
				int firstMatch = findFirstMatchingPosition(clientInputShort, clientInputLong);
				String results = (firstMatch != -1) ? Messages.Success.value + firstMatch : Messages.Fail.value;
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
		println("The CS106A_DNA class finds the first index position at " +
				"which a short string representing a DNA base would " +
				"bind with a longer string representing the same," +
				"or -1 should said index not exist.");
		pause(5000);
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
	
	
	/**
	 * I fixed this using a while loop to iterate instead of a nested for loop
	 * moreover, I set up a tmpi and tmpj to iterate both the long and short 
	 * strands to avoid accidently iterating the i too far or not iterating
	 * it at all. The while loop, tmpj, and tmpi vars were the key here.
	 * Also, the ternary operator to set the match var was a huge, consice
	 * help as well.
	 * 
	 * */
	private int findFirstMatchingPosition(String shortDNA, String longDNA)
	{
		int matchPosition = -1;
		boolean match = false; 
		
		for (int i = 0, j = 0; i <= longDNA.length() - shortDNA.length(); i++){
			int tmpi = i; //longDNA iteration persists
			int tmpj = j; //always resets at 0 for shortDNA iteration
			while (tmpj < shortDNA.length()){
				match = verifyBond(shortDNA.charAt(tmpj), longDNA.charAt(tmpi)) ? true : false;
				
				if (match && matchPosition == -1){ matchPosition = tmpi; }
				else if (!match) { matchPosition = -1; }
				
				tmpj++; 
				tmpi++;
			}
			
			if (match) return matchPosition;
		}
		
		return matchPosition; //wouuld be -1 here
	}
		
	
	private boolean verifyBond(char shortStrandChar, char longStrandChar)
	{	
		switch(Character.toUpperCase(shortStrandChar)){
		case 'A':
			if (Character.toUpperCase(longStrandChar) == BaseBonds.A.complement) return true;
			else return false; 
			
		case 'T':
			if (Character.toUpperCase(longStrandChar) == BaseBonds.T.complement) return true;
			else return false; 
			
		case 'G':
			if (Character.toUpperCase(longStrandChar) == BaseBonds.G.complement) return true;
			else return false; 
			
		case 'C':
			if (Character.toUpperCase(longStrandChar) == BaseBonds.C.complement) return true;
			else return false; 
			
		default:
			return false;
		}
	}
	
	//Instance variables
	private String clientInputShort = "";
	private String clientInputLong = "";
}