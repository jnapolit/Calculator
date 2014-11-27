/** 
* This class is used to create the methods to be used on a PStack
*/

public class PStack{
	
	public PNode top;		
	public int size;

	
/** 
* This is the constructor method: sets the size to be zero and the top to be null
*/
	public PStack(){
		
		size=0;				
		top=null;		
		
	}


/** 
* This method displays all the items in the list
*/	
	public void display() {
		
		PNode cur = top; 			
		while (cur != null)		//loops through the list
		{		
			System.out.println (cur.entry);		//prints out the current entry		
			cur= cur.next;				//then moves to the next one
		
		}		
	}
	
/** 
* This method pushes numbers onto the stack
*@param
*		double
*/
	public void push(double a){
		
		PNode b = new PNode (a, null);		//creates a new Pnode
		b.next=top;					//connect b to the list
		top=b;		//sets top equal to this new pnode
		size++;		//increase the size
	}
	
/** 
* This method pops the first number off the pstack
*@return
*		if it is not empty, the poped entry
*@return
*		if it's empty, ?
*/
	
	public double pop(){
		
		if(size>0){		//if the size is greater than zero
			double poped = top.entry;	//save out the poped entry to a varaible
			top=top.next;		//set top to be the next one after top
			size--;			//decrease the size
			return poped;		//return the poped entry
		}
		return 'n'+'u'+'l'+'l'; 	//else return ?
	}

/** 
* This method peeks at the first item in the stack
*@return 
*		if empty, ?
*@return 
*		the entry of the top
*/	
	public double peek(){
		
		if (top==null)
			return 'n'+'u'+'l'+'l';
		else
			return top.entry;
	}
	
/** 
* @return 
*		boolean if empty
*/	
	
	public boolean isEmpty(){
		
		return (size==0);
	}
	
/** 
* @return
*		size
*/	
	
	public int size(){
		
		return size;
	}
	
	
	
	
	
	public static void main (String [] args){
		
		PStack testStack= new PStack(); 	
		
		testStack.push('2'); 	
		testStack.push('3');
		testStack.push('5'); 
		/*
		testStack.pop();
		testStack.pop();
		char return1 = testStack.pop();
		System.out.println(return1+" the symbol before should show it poped the ]");
		testStack.pop(); 
		char return2 = testStack.pop(); 
		System.out.println(return2+" the symbol before should show it poped the nothing");
		
		testStack.push(']');
		
		char return3 = testStack.peek(); 
		System.out.println(return3 + "what is peeked");
		
		boolean isempty = testStack.isEmpty();
		System.out.println(isempty + " the list is empty"); 
		
		int size = testStack.size(); 
		System.out.println(size); 
		*/
		testStack.display(); 
		
		double x = testStack.pop(); 
		double result = x+2;
		System.out.println(result);
	}	
	
}
