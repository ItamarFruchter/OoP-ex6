package oop.ex6.fileprocessing;

import java.util.regex.Matcher;

/**
 * this class analyze what's the type of each line
 */
public class LineAnalyzer {
	
	private LineAnalyzer(){}
	
	public static LineType analyzeLine(String line) throws MeaninglessLineException{
		for (LineType lineType : LineType.values()){
			Matcher lineMatcher = lineType.getPattern().matcher(line);
			if (lineMatcher.matches()){
				return lineType;
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
