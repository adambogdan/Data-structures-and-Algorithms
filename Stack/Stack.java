// push and pop in O(1)
// LIFO - ultimul element inserat va fi primul scos

public class Stack {

	private int maxSize;
	private long []stackArray;
	private int top;
	
	public Stack(int s)
	{
		maxSize=s;
		stackArray=new long[maxSize];
		top=-1;
	}
	
	public void push(long el)
	{
		stackArray[++top]=el;
	}
	
	public long pop()
	{
		return stackArray[top--];
	}
	
	public long top()
	{
		return stackArray[top];
	}
	
	public boolean isEmpty()
	{
		return (top==-1); //true daca e empty
	}
	
	public boolean isFull()
	{
		return (top==maxSize-1); //true daca e plina
	}
}
class StackApp
{
	public static void main(String []args)
	{
		Stack st=new Stack(10);
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		st.push(60);
		st.push(70);
		
		
		long el=st.pop();
		System.out.println(el);
		
		while(!st.isEmpty())
		{
			long value=st.pop();
			System.out.print(value);
			System.out.println();
		}
	}
}