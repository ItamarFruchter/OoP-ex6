package oop.ex6.variables;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import oop.ex6.error.IllegalCodeException;

/**
 * A variable in Sjava.
 */
public class Member {
	// The pattern of a legal name.
	private static final Pattern namePattern = Pattern
			.compile("(_\\w+|[A-Za-z])\\w*");
	// The reserved S-java words.
	private static final String[] RESERVED_WORDS = new String[] { "int",
			"double", "boolean", "char", "String", "void", "final", "if",
			"while", "true", "false", "return" };

	// This member's type.
	private final Type type;

	/** A string representation of this member's value. */
	public boolean hasValue;
	
	/** This member's name. */
	public final String name;

	/**
	 * Creates a member.
	 * 
	 * @param nameString
	 *            This member's name.
	 * @param typeString
	 *            This member's type.
	 * @param valueString
	 *            This member's value.
	 * @throws IllegalCodeException
	 * @throws NonValidValueException
	 */
	public Member(String nameString, String typeString, String valueString)
			throws IllegalCodeException, NonValidValueException {
		if (checkName(nameString)) {
			this.name = nameString;
			this.type = Type.findType(typeString); // May throw invalid type
													// exception.
			this.hasValue = true; // Is always initialized as true, and will be
									// ignored if it is an illegal value.
			if (!type.isValidValue(valueString)) {
				throw new NonValidValueException(type, valueString.trim());
			}
		} else {
			throw new IllegalNameException();
		}
	}

	/**
	 * Creates a member with no value.
	 * 
	 * @param nameString
	 *            This member's name.
	 * @param typeString
	 *            This member's type.
	 * @throws InvalidTypeException
	 * @throws IllegalCodeException
	 */
	public Member(String nameString, String typeString)
			throws InvalidTypeException, IllegalCodeException {
		if (checkName(nameString)) {
			this.name = nameString;
			this.type = Type.findType(typeString);
			this.hasValue = false;
		} else {
			throw new IllegalNameException();
		}
	}

	/*
	 * Returns true if the given string is indeed a legal name.
	 */
	private boolean checkName(String name) {
		String trimmedName = name.trim();
		Matcher nameMatcher = namePattern.matcher(trimmedName);
		return (nameMatcher.matches() && !isReservedWord(trimmedName));
	}
	
	private boolean isReservedWord(String name) {
		for (String reserved: RESERVED_WORDS) {
			if(reserved.equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true iff this member has value.
	 * @return
	 */
	public boolean isHasValue() {
		return hasValue;
	}

	public void setHasValue(boolean hasValue) {
		this.hasValue = hasValue;
	}

	public Type getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}