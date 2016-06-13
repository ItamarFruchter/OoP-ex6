
/**
 * Represents any block in S-java. 
 */
public abstract class Block {
	/**
	 * The known local members this block (scope wise).
	 */
	 protected LinkedList<Member> localMembers;
	 /**
	  * The known local members this block (scope wise).
	  */
	 protected final LinkedList<Member> globalMembers;
	 /**
	  * The known local methods this block (scope wise).
	  */
	 protected LinkedList<String> knownMethods;
	 
	 /**
	  * Creates the block of
	  * @param content The lines to parse in the block.
	  */
	 public Block(String content) {
		 
	 }
	 
	 private abstract boolean checkCondition(String condition);
}