import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stack {

	private int maxSize;
	private char []stackArray;
	private int top;
	
	public Stack(int s)
	{
		maxSize=s;
		stackArray=new char[maxSize];
		top=-1;
	}
	
	public void push(char el)
	{
		stackArray[++top]=el;
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
	
	public boolean isFull()
	{
		return (top==maxSize-1);
	}
}

class Reverser{
	private String input;
	private String output;
	public Reverser(String in)
	{
		input=in;
	}
	 public String doReverse()
	 {
		 int size=input.length();
		 Stack st=new Stack(size);
		 for(int i=0;i<size;i++)
		 {
			 char ch=input.charAt(i);
			 st.push(ch);
		 }
		 output="";
		 while(!st.isEmpty())
		 {
			 char outch=st.pop();
			 output+=outch;
		 }
		 return output;
	 }
}
class TestApp{
	public static void main(String []args) throws IOException
	{
		System.out.println("Enter string: ");
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String input=br.readLine();
		
		Reverser rev=new Reverser(input);
		String output=rev.doReverse();
		System.out.print("Reverse: "+output);
	}
}
