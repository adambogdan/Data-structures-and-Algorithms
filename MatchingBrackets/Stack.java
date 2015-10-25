import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Stack
{
	private int maxSize;
	private char []stackArray;
	private int top;
	
	public Stack(int s)
	{
		maxSize=s;
		stackArray=new char[maxSize];
		top=-1;
	}
	
	public void push(char j)
	{
		stackArray[++top]=j;
	}
	
	public char pop()
	{
		return stackArray[top--];
	}
	
	public char top()
	{
		return stackArray[top];
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
}

class BracketChecker
{
	private String input;
	
	public BracketChecker(String in)
	{
		input=in;
	}
	
	public void check()
	{
		int stackSize=input.length();
		Stack st=new Stack(stackSize);
		for(int j=0;j<input.length();j++)
		{
			char ch=input.charAt(j);
			switch(ch)
			{
			case '{':
			case '[':
			case '(':
				st.push(ch);
				break;
				
			case '}':
			case ']':
			case ')':
				if(!st.isEmpty())
				{
					char chx=st.pop();
					if( (ch=='}' && chx!='{') || (ch==']' && chx!='[')|| (ch==')' && chx!='(') )
						System.out.print("Error: "+ch+" at "+j);
				}
				else
					System.out.println("Error: "+ch+" at "+j);  //daca e goala
				break;
				default:break;
			}
		}
		if(!st.isEmpty())
			System.out.println("Missing the right delimiter");
	}
}
class TestApp
{
	public static void main(String []args) throws IOException
	{
		String input;
		while(true)
		{
			System.out.println("Enter string: ");
			System.out.flush();
			
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			input=br.readLine();
			if(input.equals(""))
				break;
			BracketChecker bc=new BracketChecker(input);
			bc.check();
		}
	}
}
