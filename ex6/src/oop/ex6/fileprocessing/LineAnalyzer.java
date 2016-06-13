package oop.ex6.fileprocessing;



import java.util.EnumSet;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * this class analyze what's the purpose of each line
 */
public class LineAnalyzer {

	
	private enum LineType{
		CLOSING_BLOCK("\\s*\\}\\s*"),
		DECLERATION("\\s*\\w+(\\s+\\w+){1,2}(\\s*=\\s*[\\w\"\\.]+\\s*)?((\\s*,\\s*\\w+)\\s*"
				+ "(=\\s*[\\w\"\\.]+\\s*)?)*?\\s*;\\s*"),
		ASSIGNMENT("\\s*\\w+\\s*=\\s*[\\w\"\\.]+\\s*;\\s*"),
		// such as if/while blocks
		NON_METHOD_BLOCK("\\s*\\w+\\s*\\(\\s*([\\w\"\\.]|(\\|\\|)|(\\&\\&))+\\s*\\)\\s*\\{\\s*"),
		METHOD_DECLERATION("\\s*\\w+\\s+\\w+\\s*\\((\\s*\\w+\\s*\\w+(\\s*,\\s*\\w+\\s*\\w+)*)?\\)\\s*\\{\\s*"),
		METHOD_CALLING("\\s*\\w+\\s*\\((\\s*[\\w\"\\.]+(\\s*,\\s*[\\w\"\\.]+)*)?\\)\\s*;\\s*"),
		COMMENT_LINE("\\s*//.*"),
		RETURN_STATEMENT("\\s*return\\s*;\\s*");
		
		/*
		 * the pattern that represents the line type
		 */
		private Pattern pattern;
		
		/*
		 * constructs the different line type
		 */
		private LineType(String regEx){
			this.pattern = Pattern.compile(regEx);
		}
		
		/*
		 * returns the pattern of the line type
		 */
		private Pattern getPattern(){
			return pattern;
		}
		
	}
	
	
	String Dec = "\\s*" + WORD + "(" + SPACES + WORD + "){1,2}";
	private static final String SPACES = ("\\s+");
	private static final String WORD = ("\\w+");
	private static final String VALUE = ("[\\w\"\\.]+");
	private static final String DECLERATION = ("\\s*\\w+(\\s+\\w+){1,2}(\\s*=\\s*[\\w\"\\.]+\\s*)?((\\s*,\\s*\\w+)\\s*"
			+ "(=\\s*[\\w\"\\.]+\\s*)?)*?\\s*;\\s*");
	private static final String ASSIGNMENT = ("\\s*\\w+\\s*=\\s*[\\w\"\\.]+\\s*;\\s*");
	private static final String CLOSING_BLOCK = ("\\s*}\\s*");
	
	
	
	private LineAnalyzer(){}
	
	public static LineType analyzeLine(String line){
		for (LineType type : LineType.values()){
			Matcher lineMatcher = type.getPattern().matcher(line);
			if (lineMatcher.matches()){
				return type;
			}
		}
		throw new MeaninglessLineException();
	}
	
	/**
	 * @param line - the line of the code
	 * @return - an array containing all the object to initialize from this line
	 */
	/*
	public static ObjectParameters[] getValues(String line){
		String modifier = null;
		String type = null;
		String name = null;
		String value = null;
		LinkedList<ObjectParameters> listOfObjects = new LinkedList<ObjectParameters>();
		Matcher spacesMatcher = SPACES.matcher(line);
		if (spacesMatcher.lookingAt()){
			spacesMatcher.replaceFirst(EMPTY_STRING);
		}
		Matcher wordMatcher = WORD.matcher(line);
		wordMatcher.lookingAt();
		if (line.substring(wordMatcher.start(), wordMatcher.end()).equals(MODIFIER)){
			modifier = true;
			wordMatcher.replaceFirst(EMPTY_STRING);
			wordMatcher.reset();
			wordMatcher.lookingAt();
			type = line.substring(wordMatcher.start(), wordMatcher.end());
			wordMatcher.replaceFirst(EMPTY_STRING);
		}
		else {
			type = line.substring(wordMatcher.start(), wordMatcher.end());
			wordMatcher.replaceFirst(EMPTY_STRING);
		}
		Matcher declerationMatcher = DECLERATION.matcher(line);
		while (declerationMatcher.find()){
			String decleration = line.substring(wordMatcher.start(), wordMatcher.end());
			wordMatcher.reset(decleration);
			wordMatcher.find();
			name = decleration.substring(wordMatcher.start(), wordMatcher.end());
			wordMatcher.replaceFirst(EMPTY_STRING);
			Matcher valueMatcher = VALUE.matcher(decleration);
			if (valueMatcher.find()){
				value = decleration.substring(valueMatcher.start(), valueMatcher.end());
				listOfObjects.add(new ObjectParameters(modifier, type, name, value));
				name = null;
				value = null;
				declerationMatcher.replaceFirst(EMPTY_STRING);
				declerationMatcher.reset();
			}
			listOfObjects.add(new ObjectParameters(modifier, type, name, value));
			name = null;
			declerationMatcher.replaceFirst(EMPTY_STRING);
			declerationMatcher.reset();
		}
		return listOfObjects.toArray(new ObjectParameters[listOfObjects.size()]);
	}
	*/
}
