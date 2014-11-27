/** 
 * Class definition for a TNode that consists of a key, and two children 
 */
public class TNode
{
	public char key; 	
	public TNode left;	
	public TNode right;
	
/** 
* Constructor: creates a node
* @param k 
*			key
*@param L 
*			left
*@param R
*			right
 */	
	
	public TNode(char k,TNode L, TNode R)
	{
		key = k; 
		left = L;
		right=R;		
		
	}
	
}
