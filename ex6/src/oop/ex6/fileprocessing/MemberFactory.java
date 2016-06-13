package oop.ex6.fileprocessing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import oop.ex6.variables.Member;


public class MemberFactory {

	private static final String EMPTY_STRING = "";
	private static final Pattern SPACES = Pattern.compile("\\s+");
	private static final Pattern WORD = Pattern.compile("\\w+");
	private static final Pattern VALUE = Pattern.compile("[\\w\"\\.']+");
	private static final Pattern WITH_MODIFIER = Pattern.compile("\\w+\\s+\\w+\\s+\\w+");
	
	
	private MemberFactory(){}
	
	public static Member[] createMembers(String line){
		String tempString = new String(line);
		String modifier = null;
		String type = null;
		String name = null;
		String value = null;
		clearSpaces(tempString);
		Matcher withModifireMatcher = WITH_MODIFIER.matcher(tempString);
		if (withModifireMatcher.lookingAt()){
			return createMembersWithModifire(tempString);
		}
		else {
			return createMembersWithoutModifire(tempString);
		}
		
		wordMatcher.lookingAt();
		if (tempString.substring(wordMatcher.start(), wordMatcher.end()).equals(MODIFIER)){
			modifier = true;
			wordMatcher.replaceFirst(EMPTY_STRING);
			wordMatcher.reset();
			wordMatcher.lookingAt();
			type = tempString.substring(wordMatcher.start(), wordMatcher.end());
			wordMatcher.replaceFirst(EMPTY_STRING);
		}
		else {
			type = tempString.substring(wordMatcher.start(), wordMatcher.end());
			wordMatcher.replaceFirst(EMPTY_STRING);
		}
		Matcher declerationMatcher = DECLERATION.matcher(tempString);
		while (declerationMatcher.find()){
			String decleration = tempString.substring(wordMatcher.start(), wordMatcher.end());
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
		return null
	}
	
	private static Member[] createMembersWithoutModifire(String tempString) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Member[] createMembersWithModifire(String tempString) {
		Matcher wordMatcher = WORD.matcher(tempString);
		wordMatcher.find();
		String modifier = tempString.substring(wordMatcher.start(), wordMatcher.end());
		wordMatcher.replaceFirst(EMPTY_STRING);
		wordMatcher.reset(tempString);
		String type = tempString.substring(wordMatcher.start(), wordMatcher.end());
		
		return null;
	}

	private static void clearSpaces(String stringToWork){
		Matcher spacesMatcher = SPACES.matcher(stringToWork);
		if (spacesMatcher.lookingAt()){
			spacesMatcher.replaceFirst(EMPTY_STRING);
		}
	}
}
