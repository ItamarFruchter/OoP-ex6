
/**
 * Represents any block in S-java. 
 */
public class Block {
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
}