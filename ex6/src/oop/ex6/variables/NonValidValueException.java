package oop.ex6.variables;

/**
 * Occurs when the value given to a parameter was not legal. It might be another
 * variable's name, so this exception holds any needed information to check
 * this. Not necessarily an illegal code exception!
 */
public class NonValidValueException extends Exception {
	/** The variable type to check. */
	public Type type;
	/** The name to check. */
	public String name;
	
	public NonValidValueException(Type type, String name) {
		this.type = type;
		this.name = name;
	}
}
