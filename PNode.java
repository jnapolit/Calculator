/** 
 * Class definition for a PNode of a singly linked list of doubles
 */
public class PNode {

	/* Note: these fields are public so that they can be directly accessed
	 * from outside this class.  For example, if v is a Node object, 
	 * then v.entry and v.next can be used to access these fields. */
	 
	public double entry;	//numbers
	public PNode next;		//refers to the next node in the list
	
	/** 
	 * Constructor: creates a node with the given entry and next Node. 
	 */
	public PNode(double e, PNode n) {
		entry = e;
		next = n;
	}
}
