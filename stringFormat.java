/*
QUESTION #3:
        Write a Java method with the following method signature that takes a String and
        returns a String formatted so that it satisfies the requirements below.  It may
        need to insert newlines and/or delete spaces.
        Method Signature:
public static String wrapText(String text, int maxCharsPerLine)
        Definitions and Assumptions:
        A word is a nonempty sequence of characters that contains no spaces and no newlines.
        Lines in the return String are separated by the newline character, '\n'.
        Words on each line are separated by spaces. Assume that the String argument does
        not contain any whitespace characters other than spaces and newlines.
        Requirements:
        1. Newlines in the String argument are preserved.
        2. Words in the return String are separated by either a single space or by one or
        more newlines.
        3. Lines in the return String do not start or end with any spaces.
        4. When constructing the return String from the String argument, each word in the
        String argument with at most maxCharsPerLine characters should not be broken up.
        Each word in the String argument with more than maxCharsPerLine characters should
        be broken up so that all of the other requirements are satisfied.
        5. The String argument may contain lines longer than maxCharsPerLine. Newlines
        should be added so that each line in the return String has at most maxCharsPerLine
        characters. To determine where newlines should be added, try to fit as many words
        as possible on a line (while keeping line length at most maxCharsPerLine and
        satisfying the other requirements) before starting a new line.
*/
class stringformatter{
	public void printFormattedString(String s, int maxCharsPerLine){
		System.out.println(wrapText(s,maxCharsPerLine));
	}
	
	public static String wrapText(String text, int maxCharsPerLine){
		int lineLen,i;
		StringBuilder strFormated = new StringBuilder();
		
		if(text=="" || text.length()<=1 || maxCharsPerLine==0){
			return text;
		}
		
		String[] lines = text.split("\n");
		for(String line : lines){
			if(line.length()>=maxCharsPerLine){
				String[] words = text.split("\\s+");
				if(words.length==1){
					//System.out.println("single word");
					/*strFormated.append(line.substring(0, maxCharsPerLine-2));
					strFormated.append("\\n");
					strFormated.append(line.substring(maxCharsPerLine-2));*/
					strFormated.append(splitWord(line,maxCharsPerLine));
				}else{
					/*lastWordIndex = line.lastIndexOf(words[words.length-1]);
					strFormated.append(line.substring(0, lastWordIndex));
					strFormated.append("\\n");
					strFormated.append(line.substring(lastWordIndex)+"\\n");*/
					strFormated.append(splitLine(line,maxCharsPerLine));
				}
			}else{
				strFormated.append(line+"\n");
			}
		}
		
		
		return strFormated.toString();
	}
	public static String splitWord(String s, int maxCharsPerLine){
		StringBuilder wordFormated = new StringBuilder();
		if(s.length()<maxCharsPerLine-2){
			return wordFormated.append(s+"\n").toString();
		}
		wordFormated.append(s.substring(0, maxCharsPerLine-2)+"\n");
		return wordFormated.append(splitWord(s.substring(maxCharsPerLine-2),maxCharsPerLine)).toString();
	}

	public static String splitLine(String s, int maxCharsPerLine){
		int i=0, wordStart=0, wordEnd=0;
		StringBuilder currentWord = new StringBuilder();
		StringBuilder lineFormated = new StringBuilder();
		if(s.length()<maxCharsPerLine-2){
			return lineFormated.append(s+"\n").toString();
		}
		i = maxCharsPerLine-3;
		while(i>=0){
			if(s.charAt(i)==' '){
				wordStart=i+1;
				break;
			}
			i--;
		}
		i = wordStart;
		wordEnd = s.length();
		while(i<s.length()){
			if(s.charAt(i)==' ' || s.charAt(i)=='\n'){
				wordEnd=i;
				break;
			}
			i++;
		}
		currentWord.append(s.substring(wordStart,wordEnd));
		if(wordStart!=0){
			lineFormated.append(s.substring(0, wordStart)+"\n");
		}
		if(currentWord.length()>=maxCharsPerLine-2){
			lineFormated.append(splitWord(currentWord.toString(),maxCharsPerLine));
			if(wordEnd<s.length()){
				return lineFormated.append(splitLine(s.substring(wordEnd+1),maxCharsPerLine)).toString();
			}else{
				return lineFormated.toString();
			}
		}else{
			//return lineFormated.append(splitLine(s.substring(maxCharsPerLine-2),maxCharsPerLine)).toString();
			return lineFormated.append(splitLine(s.substring(wordStart),maxCharsPerLine)).toString();
		}
	}
}
public class stringFormat {

	public static void main(String[] args) {
		stringformatter format = new stringformatter();
		String s ="An assertion is a statement in the JavaTM programming language that enables you to test your assumptions about your program. For example, if you write a method that calculates the speed of a particle, you might assert that the calculated speed is less than the speed of light.\n"
                + "\n"
                + "Each assertion contains a boolean expression that you believe will be true when the assertion executes. If it is not true, the system will throw an error. By verifying that the boolean expression is indeed true, the assertion confirms your assumptions about the behavior of your program, increasing your confidence that the program is free of errors.";
		format.printFormattedString(s, 50);

	}

}
