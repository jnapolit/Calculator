import java.util.*; //for built-in Stack class

/** 
*class that combines methods from project 3 and the methods from part B in this current assignment
*Actually takes a string from the user and prints out the postfix notation and evaluates it 
 */

public class CombinedApp
{

	public boolean isOperand(char c)
	{
		
		if (c>= 48 && c<=57)		//if it is in the range in the ASCII table
		{
			return true; 
		}
				
		return false;
	}	

	public boolean isOperator(char c)
	{
		char[] operations = {'+','-','*','/'};
		for (int i =0; i<4;i++)
		{
			if (c==operations[i])
			{
				return true;
			}
		}
		return false; 
	}
	
	/** 
* This method converts the char to an integer number,
*@return
*		if it is not in the hard coded list , -1
*@return 
*		the index of where it is found in the nums array
*/	

	public double char2int (char c)
	{
		char[] nums = {'0','1' , '2' , '3', '4', '5', '6', '7', '8', '9'};		//initilize and declare array of numbers
		
		for (int i=0; i<10; i++)		//loop through the nums array
		{
			if (c==nums[i])		//see if this char is in there
			{
				return i; 		//find the index if it does correspond to one
			}
			
		}
		return -1; 	//otherwise return -1
	}

/** 
* This method adds your two number
*@param
*		second num poped, first num poped
*@return 
*		result of the addition
*/		

	public double plus(double s, double f)
	{
		double resultadd = f+s; 
		return resultadd; 
	}

/** 
* This method subtracts your two number
*@param
*		second num poped, first num poped
*@return 
*		result of the subtraction
*/	
	
	public double subtract(double s, double f)
	{
		double resultsub = f-s; 
		return resultsub; 
	}
	
/** 
* This method multiplies your two number
*@param
*		second num poped, first num poped
*@return 
*		result of the multiplication
*/	
	
	public double multiply(double s, double f)
	{
		double resultmul = f*s; 
		return resultmul; 
	}
	
/** 
* This method divides your two number
*@param
*		second num poped, first num poped
*@return 
*		result of the division
*/	

	public double divide(double s, double f)
	{
		double resultdiv = f/s; 
		return resultdiv; 
	}
	
	public BTree buildExpression (String E)
	{
		Stack<BTree> tstack;
		tstack= new Stack<BTree>();
		int length=E.length();
		for (int i= 0; i<length; i++)	//go through all the characters in the string
		{
			if (isOperand(E.charAt(i))==true|| isOperator(E.charAt(i))==true)
			{					
				BTree T= new BTree(); 
				T.addRoot(E.charAt(i)); 
				tstack.push(T);
			}
			if (E.charAt(i)==41)		//if its a closed paranthesis 
			{
				BTree E2= tstack.pop();
				BTree O= tstack.pop();
				BTree E1= tstack.pop();
				O.attach(O, E1, E2);
				tstack.push(O);
			}
		}
		
		return tstack.peek();
	}
	
/** 
*@param	list
*	the linked list which contains the postfix notation of the string 
*@return 
*	the result of the postfix notation 
 */
	
	public double postfixCalc(LL list)
	{
		PStack stck = new PStack();		//create a new pstack called stck
		double result= 0; 	//what will return if don't put any numbers or operators into input 
		double sec;		//initalize sec, standing for second number that was poped
		double fir; 		//initlize fir, standing for first number that was poped
		Node cur = list.getFront(); 
		while (cur!=null)
		{
			if (isOperand(cur.entry)==true)	//the char is an operand
			{
				double operand = char2int(cur.entry);	//convert the char to an int
				stck.push(operand);		//then push it onto the stck
			}
				
			else 		//the char is an operator
			{
				if (cur.entry==42 )		//if the operation is a plus sign 
				{
					sec = stck.pop();
					fir = stck.pop(); 
					result = multiply(sec,fir);	//do the math then push
					stck.push(result);	
				}
				else if (cur.entry==43)	//if it is a minus sign 		
				{
					sec = stck.pop();
					fir = stck.pop(); 
					result = plus(sec,fir);		//do the math then push
					stck.push(result);
				}
				else if (cur.entry==45)	//if it is multiplication
				{
					sec = stck.pop();
					fir= stck.pop(); 
					result = subtract(sec,fir);		//do the math then push
					stck.push(result);
				}
				else if (cur.entry==47)	//if it is division 
				{
					sec = stck.pop();
					fir = stck.pop(); 
					result = divide(sec,fir); 		//do the math then push
					stck.push(result);
				}
			}
			cur=cur.next; 			
		}
		
		double answer = stck.peek();	//the last thing in the stack should be the final answer so
									//you can just peek at the first item
		return answer;
	}
	
	public static void main(String[] args) 
	{
		CombinedApp app= new CombinedApp(); 
		Scanner s = new Scanner(System.in);		//creates a new scanner variable s
                System.out.println("Please input your equation here in infix notation:");		//prints out instructions
		String in=s.next();						//sets the users unput to be in
		BTree t = app.buildExpression(in); 
		System.out.println("This is a binary tree representation of the equation you entered:");
		t.displayTree(); 
		System.out.println(""); 
		System.out.println("This is your equation in postfix notation:"); 
		LL v = t.postOrder(t.getRoot(),new LL(),t);
		System.out.println(""); 
		System.out.println("And this is the solution of your equation:"); 
		System.out.println(app.postfixCalc(v));
		
	}
		
	
}
