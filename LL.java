/**
*This class utalizes a singly linked list to achieve 6 different things: display the items in the list, 
*add something to the front of the list, remove the first node in the list, add a node to the end of 
*the list, add a game entry into the proper place (goes from highest to lowest score), andd remove
* a node in a given position. 
*/



public class LL
{
	
	private Node head;
	
	private Node tail; 
	
	private int size; 
		
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	*Constructor that creates an empty list 
	*/ 
	
	public LL()
	{
		size = 0; 		//initilze the size of the list to be zero
		
		head= null; 	//initilaize the head to be null
		
		tail = null; 	//initilize the tail to be null
		
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Node getFront()
	{
		return head;
	}
	

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	*Prints out all the game entries in the linkied list
	*/ 
	
	public void display() 
	{
		Node cur = head; 	//set cur to be the first node (head)
		
		while (cur != null)	//while cur is not at the end of the list
		{
			
			System.out.println (cur.entry);	//print out the entry of cur
			
			cur= cur.next;		//set cur to the next node in the list
		
		}
		
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	*Add a node to the head of the list 
	*@param v 
	* the Node object to be added
	*/ 
	
	public void addFirst (Node v)
	{
		
		v.next = head; 		//connect v to the list by pointing it's next to the head
		
		head = v; 		//set the head variable to v
		
		if (size==0)		//if the list has a size of zero
		{
			
			tail = head; 		//set the tail equal to the head
			
		}
		
		size ++; 		//increment the size
		
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	*Add a node to the tail of the list 
	*@param v 
	* the node object to be addedd
	*/ 
	
	public void addLast(Node v)
	{
		
		if (size == 0)		//if the size of the list is zero
		{
			head = v; 		//set the head of the list equal to the node we are trying to add
		}
		
		else		//if there are things in the list
		{
			tail.next = v; 		//have the node currently set to tail point to this new node called v
		}
		
		tail = v; 		//set tail now equal to v
		
		v.next = null; 	//make sure this new node is not pointing to anything next since it is the tail
		
		size ++; 		//increment the size
		
	}
	
}
	
