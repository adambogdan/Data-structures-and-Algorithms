import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Stack{
	private int maxSize;
	private int[] stArray;
	private int top;
	
	public Stack(int size)
	{
		maxSize=size;
		stArray=new int[maxSize];
		top=-1;
	}
	
	public void push(int el)
	{
		stArray[++top]=el;
	}
	
	public int pop()
	{
		return stArray[top--];
	}
	
	public int top()
	{
		return stArray[top];
	}
	
	public boolean isEmpty()
	{
		return (top==-1);
	}
	
	public boolean isFull()
	{
		return (top==maxSize-1);
	}
	public int size()
	{
		return top+1;
	}
	public int elAtPosition(int i)
	{
		return stArray[i];
	}
	public void display()
	{
		for(int i=0;i<size();i++)
		{
			System.out.print(elAtPosition(i)+' ');
		}
		System.out.println();
	}
}

class EvPostfixExpression{
	private Stack st;
	private String input;
	
	public EvPostfixExpression(String s)
	{
		input=s;
	}
	
	public int doParse()
	{
		st=new Stack(20);
		char ch;
		int j;
		int num1,num2,result;
		
		for(j=0;j<input.length();j++)
		{
			ch=input.charAt(j);
			if(ch>='0' && ch<='9')  // daca e numar pun in stiva
				st.push( (int)(ch-'0'));
			else
			{                        // daca operator scot ultimele 2 nr
				num2=st.pop();
				num1=st.pop();
				switch(ch)
				{
				case '+':
					result=num1+num2;
					break;
				case '-':
					result=num1-num2;
					break;
				case '*':
					result=num1*num2;
					break;
				case '/':
					result=num1/num2;
					break;
				default:
					result=0;
				}
				st.push(result);        //pun rezultatul 
			}	
		}
		result=st.pop(); // dupa ultimul operator aplicat in st o sa fie un singur el, result
		return result;
	}
}

public class EvaluateExpression {
	
	public static void main(String []args) throws IOException
	{
		String input;
		int output;
		
		while(true)
		{
			System.out.print("Enter postfix expression: ");  // 34+ (3+4), 234*+  (2+3*4) 
			InputStreamReader isr=new InputStreamReader(System.in);
			BufferedReader br=new BufferedReader(isr);
			input=br.readLine();
			
			EvPostfixExpression pExp=new EvPostfixExpression(input);
			output=pExp.doParse();
			System.out.println("Result: "+output);
			
		}
	}
}
