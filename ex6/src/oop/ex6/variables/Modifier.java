package oop.ex6.variables;

/**
 * All the modifier types in S-java.
 */
public enum Modifier {
	FINAL("final"),
	NO_MODIFIER(null);

	// The string representation of the modifier.
	private String stringRepresentation;

	// The modifier's constructor.
	private Modifier(String stringRepresentation) {
		this.stringRepresentation = stringRepresentation;
	}

	/**
	 * Returns the modifier fitting for this string, null otherwise.
	 * 
	 * @param modifierString
	 *            The string representation of some modifier.
	 * @return A modifier if there is one fitting, null otherwise,
	 */
	public static Modifier modifierFromString(String modifierString) {
		for (Modifier modifier : Modifier.values()) {
			if (modifier.stringRepresentation != null) {
				if (modifier.stringRepresentation.equals(modifierString)) {
					return modifier;
				}
			} else if (modifierString == null) {
				return Modifier.NO_MODIFIER;
			}
		}
		return null;
	}
}
