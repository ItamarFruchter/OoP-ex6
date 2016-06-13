package oop.ex6.variables;

/**
 * All the modifier types in S-java.
 */
public enum Modifier {
	FINAL {
		this.stringRep
	};
	
	private String stringRepresentation;

	
	public static Modifier modifierFromString(String modifierString) {
		switch (modifierString) {
		case FINAL.:
			
			break;

		default:
			break;
		}
	}
}
