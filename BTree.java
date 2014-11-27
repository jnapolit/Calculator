// PostOrder exercise: 31 + 3 * 95 - 2 + / 374 - * 6 + -  //
////////////////////////////////////////////////////

import java.util.*; //for built-in Stack class

/** 
*class that has same methods as in part B except for a slight change in posttransversal method 
 */
public class BTree
{
	private TNode root; 
	private int size;
	
	public BTree()
	{
		root = null; 
		size=0;
	}
	
	public TNode getRoot()
	{
		return root;
	}
	
	public int getSize()
	{
		return size; 
	}
	
	public void display(char[] v)
	{
		
		for (int i=0; i<v.length; i++)
		{
			System.out.println(v[i]);
		}
	}
/** 
*@param	v
*	the root of the tree you are traversing 
*@return 
*	LL contianing the postfix notation 
* Will traverse the tree in post order andd print out 
*the key values of the nodes. It will also store those values 
*in that order in a singly linked list so that it can be used later
 */	
	public LL postOrder(TNode v, LL list, BTree t)
	{
		if (v.left!=null)
		{
			postOrder(v.left,list,t);
		}
		if(v.right!=null)
		{
			postOrder(v.right,list,t);
		}		
		System.out.print(v.key);
		list.addLast(new Node(v.key,null)); 
		
		if(v==t.getRoot())
		{
			return list;
		}
		
		return list; 
		
		
	}
	
	

	public void displayTree()
	{
		Stack<TNode> globalStack;
		globalStack= new Stack<TNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		
		while(isRowEmpty==false)
		{
			Stack<TNode> localStack;
			localStack= new Stack<TNode>();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
			System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				TNode temp = (TNode)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.key);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if(temp.left != null ||
							temp.right != null)
					isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				
				for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
			}  // end while
			
			System.out.println();
			nBlanks /= 2;
			
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		
		System.out.println(
		"......................................................");
	}  // end displayTree()
	
	
	public void attach(BTree p, BTree t1, BTree t2)
	{
		if (p.getRoot().left==null && p.getRoot().right==null)		//make sure that p is a leaf 
		{
			if (t1.getSize()!=0)		//make sure tree isn't empty
			{
				TNode r= p.getRoot();
				TNode c = t1.getRoot();
				r.left=c; 	//attach t1 as the left kid of the root of p
			}
			if(t2.getSize()!=0)		//make sure tree isn't empty 
			{
				
				TNode r= p.getRoot();
				TNode c = t2.getRoot();
				r.right=c; 	//attach t1 as the left kid of the root of p
			}
			
		}
		
	}
	
	public TNode addRoot(char i)
	{	
		if(size!=0)
		{
			return null; 
		}
		else
		{
			root= new TNode(i,null,null); 
			size=size+1;			
		}		
		return root;
	}

	
	public static void main(String[] args) 
	{
		BTree T = new BTree(); 
		BTree t = new BTree(); 
		t.addRoot('3'); 
		BTree t1= new BTree(); 
		t1.addRoot('4');
		BTree t2 = new BTree(); 
		t2.addRoot('5'); 
		t.displayTree();
		t1.displayTree();
		t2.displayTree();
		t.attach(t,t1,t2); 
		t.displayTree();
		//char[] postfix = new char[1000];
		LL v = new LL(); 
		LL result = t.postOrder(t.getRoot(),v,t); 
		System.out.println("");
		result.display(); 
		
		
		
		
	}
	
}
				
	
